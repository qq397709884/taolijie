package com.fh.taolijie.controller.restful.quest;

import cn.fh.security.credential.Credential;
import com.fh.taolijie.component.ListResult;
import com.fh.taolijie.component.ResponseText;
import com.fh.taolijie.constant.ErrorCode;
import com.fh.taolijie.domain.AnRecordModel;
import com.fh.taolijie.domain.quest.QuestionModel;
import com.fh.taolijie.domain.quest.QuestionOptModel;
import com.fh.taolijie.domain.quest.QuestModel;
import com.fh.taolijie.dto.ExamDto;
import com.fh.taolijie.dto.QuestionAnalyzeDto;
import com.fh.taolijie.exception.checked.*;
import com.fh.taolijie.exception.checked.acc.BalanceNotEnoughException;
import com.fh.taolijie.exception.checked.acc.CashAccNotExistsException;
import com.fh.taolijie.exception.checked.acc.OrderNotFoundException;
import com.fh.taolijie.exception.checked.quest.NotQuestionQuestException;
import com.fh.taolijie.exception.checked.quest.QuestNotFoundException;
import com.fh.taolijie.exception.checked.quest.QuestionNotFoundException;
import com.fh.taolijie.exception.checked.quest.RequestRepeatedException;
import com.fh.taolijie.service.quest.QuestService;
import com.fh.taolijie.service.quest.QuestionService;
import com.fh.taolijie.utils.Constants;
import com.fh.taolijie.utils.SessionUtils;
import com.fh.taolijie.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by whf on 10/22/15.
 */
@RestController
@RequestMapping("/api/user/quest/question")
public class RestQuestionUCtr {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestService questService;

    /**
     * 发布答题或问卷任务
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST, produces = Constants.Produce.JSON, consumes = Constants.Produce.JSON)
    public ResponseText publishQuestion(@RequestBody @Valid ExamDto dto,
                                        BindingResult br,
                                        HttpServletRequest req) throws GeneralCheckedException {
        // 参数合法性检查
        if (br.hasErrors()) {
            return new ResponseText(ErrorCode.INVALID_PARAMETER);
        }
        if (!validateDto(dto)) {
            return new ResponseText(ErrorCode.INVALID_PARAMETER);
        }
        // 验证任务对象合法性
        if (false == StringUtils.validateLadderString(dto.getSchoolIds(), dto.getCollegeIds(), dto.getCityIds(), dto.getProIds()) ) {
            return new ResponseText(ErrorCode.INVALID_PARAMETER);
        }

        // award最低为0.10
        BigDecimal award = dto.getQuest().getAward();
        if (award.compareTo(new BigDecimal("0.10")) < 0) {
            return new ResponseText(ErrorCode.AWARD_TOO_LITTLE);
        }

        // 检查任务数量与问题数量是否匹配
/*        if ( false == dto.getQuest().getTotalAmt().equals(dto.getQuestions().size()) ) {
            return new ResponseText(ErrorCode.HACKER);
        }*/

        // 将id string 转换成List<Integer>
        QuestModel model = dto.getQuest();

        List<Integer> coList = StringUtils.splitIntendIds(dto.getCollegeIds());
        List<Integer> schList = StringUtils.splitIntendIds(dto.getSchoolIds());
        List<Integer> cityList = StringUtils.splitIntendIds(dto.getCityIds());
        List<Integer> proList = StringUtils.splitIntendIds(dto.getProIds());
        model.setCollegeIdList(coList);
        model.setSchoolIdList(schList);
        model.setCityIdList(cityList);
        model.setProvinceIdList(proList);

        Credential credential = SessionUtils.getCredential(req);
        dto.getQuest().setMemberId(credential.getId());

        questionService.publishQuestions(dto.getQuest(), dto.getQuestions(), dto.getOrderId(), dto.getSave());

        return ResponseText.getSuccessResponseText();
    }

    /**
     * 提交一个题目的答案
     * @return
     */
    @RequestMapping(value = "/check", method = RequestMethod.GET, produces = Constants.Produce.JSON)
    public ResponseText checkAnswer(@RequestParam Integer questionId,
                                    @RequestParam String optIds,
                                    HttpServletRequest req) throws GeneralCheckedException {

        Credential credential = SessionUtils.getCredential(req);

        // id string转换成List<Integer>
        List<Integer> idList = StringUtils.splitIntendIds(optIds);
        // 验证答案
        boolean result = questionService.validateAnswer(credential.getId(), questionId, idList);
        return new ResponseText(result);
    }

    /**
     * 查询某个任务的答题记录
     * @return
     */
    @RequestMapping(value = "/record", method = RequestMethod.GET, produces = Constants.Produce.JSON)
    public ResponseText queryRecord(@RequestParam Integer questId,
                                    HttpServletRequest req) {

        Credential credential = SessionUtils.getCredential(req);


        // 检查任务是否已经领取
        if (false == questService.checkAssigned(credential.getId(), questId) ) {
            return new ResponseText(ErrorCode.QUEST_NOT_ASSIGNED);
        }

        List<AnRecordModel> list = questionService.findAnRecordByQuest(questId, credential.getId());

        return new ResponseText(new ListResult<>(list, list.size()));
    }

    /**
     * 查询答题问卷任务的所有题目和选项
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = Constants.Produce.JSON)
    public ResponseText queryQuestionsForQuest(@RequestParam Integer questId,
                                               HttpServletRequest req) throws GeneralCheckedException {
        Credential credential = SessionUtils.getCredential(req);


        // 检查任务是否已经领取
        Boolean assigned = questService.checkAssigned(credential.getId(), questId);
        if (false == assigned) {
            return new ResponseText(ErrorCode.QUEST_NOT_ASSIGNED);
        }

        ListResult<QuestionModel> lr = questionService.findQuestionList(questId);
        return new ResponseText(lr);
    }

    /**
     * 查询题目统计信息
     * @return
     */
    @RequestMapping(value = "/result", method = RequestMethod.GET, produces = Constants.Produce.JSON)
    public ResponseText analyzeData(@RequestParam Integer questId,
                                    HttpServletRequest req) throws GeneralCheckedException {

        // 检查是不是自己发布的任务
        Credential credential = SessionUtils.getCredential(req);
        QuestModel quest = questService.findById(questId);
        if (false == quest.getMemberId().equals(credential.getId())) {
            return new ResponseText(ErrorCode.PERMISSION_ERROR);
        }

        List<QuestionAnalyzeDto> data = questionService.analyzeData(questId);
        return new ResponseText(new ListResult<>(data, data.size()));
    }

    /**
     * 验证DTO对象合法性
     * @return
     */
    private boolean validateDto(ExamDto dto) {
        // 验证Quest对象
        QuestModel quest = dto.getQuest();
        if (!QuestModel.validate(quest)) {
            return false;
        }

        // 验证Question对象
        for (QuestionModel q : dto.getQuestions()) {
            if (!QuestionModel.validate(q)) {
                return false;
            }
            // 验证QuestionOpt对象
            for (QuestionOptModel opt : q.getOpts()) {
                if (!QuestionOptModel.validate(opt)) {
                    return false;
                }
            }
        }

        return true;
    }
}
