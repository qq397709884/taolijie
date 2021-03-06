package com.fh.taolijie.controller.restful.quest;

import com.fh.taolijie.component.ListResult;
import com.fh.taolijie.component.ResponseText;
import com.fh.taolijie.constant.ErrorCode;
import com.fh.taolijie.constant.quest.OffQuestStatus;
import com.fh.taolijie.domain.OffQuestModel;
import com.fh.taolijie.exception.checked.GeneralCheckedException;
import com.fh.taolijie.service.quest.OffQuestService;
import com.fh.taolijie.utils.Constants;
import com.fh.taolijie.utils.PageUtils;
import com.fh.taolijie.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 线下任务控制器
 * Created by whf on 11/30/15.
 */
@RestController
@RequestMapping("/api/user/offquest")
public class RestOffQuestUCtr {
    @Autowired
    private OffQuestService offService;

    /**
     * 发布线下任务接口
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST, produces = Constants.Produce.JSON)
    public ResponseText publish(@RequestParam String title,
                                @RequestParam("cate") Integer cateId,
                                @RequestParam BigDecimal award,
                                @RequestParam("wt") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date workDate,
                                @RequestParam("wp") String workPlace,
                                @RequestParam("desp") String description,
                                @RequestParam("m") String mobile,

                                @RequestParam("proid") Integer provinceId,
                                @RequestParam("cid") Integer cityId,
                                @RequestParam("rid") Integer regionId,

                                @RequestParam("la") BigDecimal latitude, // 纬度
                                @RequestParam("lo") BigDecimal longitude, // 经度

                                HttpServletRequest req) throws GeneralCheckedException {

        Integer memId = SessionUtils.getCredential(req).getId();

        // 参数验证
        // 日期必须是未来的时间
        if (new Date().compareTo(workDate) >= 0) {
            return new ResponseText(ErrorCode.INVALID_PARAMETER);
        }
        // 赏金必须比0大
        if (award.compareTo(BigDecimal.ZERO) <= 0) {
            return new ResponseText(ErrorCode.AWARD_TOO_LITTLE);
        }

        OffQuestModel model = new OffQuestModel();
        model.setMemId(memId);
        model.setTitle(title);
        model.setCateId(cateId);
        model.setAward(award);
        model.setWorkTime(workDate);
        model.setWorkPlace(workPlace);
        model.setDescription(description);
        model.setContactPhone(mobile);
        model.setProvinceId(provinceId);
        model.setCityId(cityId);
        model.setRegionId(regionId);

        model.setLatitude(latitude);
        model.setLongitude(longitude);

        offService.publish(model);

        return ResponseText.getSuccessResponseText();
    }

    /**
     * 任务上下架
     * @return
     */
    @RequestMapping(value = "/offline", method = RequestMethod.PUT, produces = Constants.Produce.JSON)
    public ResponseText offline(@RequestParam("q") Integer questId,
                                @RequestParam(value = "off", defaultValue = "1") int isOffline, // 是否下线, 默认为1 = 下线
                                HttpServletRequest req) throws GeneralCheckedException {

        // 参数验证
        if (isOffline != 0 && isOffline != 1) {
            return new ResponseText(ErrorCode.INVALID_PARAMETER);
        }

        Integer memId = SessionUtils.getCredential(req).getId();

        offService.updateStatus(questId, memId, isOffline == 1 ? OffQuestStatus.OFFLINE : OffQuestStatus.PUBLISHED);

        return ResponseText.getSuccessResponseText();
    }

    /**
     * 刷新时间
     * @return
     */
    @RequestMapping(value = "/f", method = RequestMethod.PUT, produces = Constants.Produce.JSON)
    public ResponseText flush(@RequestParam("q") Integer questId,
                              HttpServletRequest req) throws GeneralCheckedException{

        Integer memId = SessionUtils.getCredential(req).getId();
        offService.flush(questId, memId);;


        return ResponseText.getSuccessResponseText();
    }

    /**
     * 查询当前用户发布的线下任务
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = Constants.Produce.JSON)
    public ResponseText queryByCurrentUser(HttpServletRequest req,
                                           @RequestParam(defaultValue = "0") int pn,
                                           @RequestParam(defaultValue = Constants.PAGE_CAP) int ps) {

        Integer memId = SessionUtils.getCredential(req).getId();

        pn = PageUtils.getFirstResult(pn, ps);
        OffQuestModel cmd = new OffQuestModel(pn, ps);
        cmd.setMemId(memId);
        ListResult<OffQuestModel> lr = offService.findBy(cmd);

        return new ResponseText(lr);
    }
}
