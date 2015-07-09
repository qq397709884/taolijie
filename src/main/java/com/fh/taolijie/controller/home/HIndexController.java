package com.fh.taolijie.controller.home;

import cn.fh.security.credential.Credential;
import cn.fh.security.utils.CredentialUtils;
import com.fh.taolijie.component.ListResult;
import com.fh.taolijie.domain.BannerPicModel;
import com.fh.taolijie.domain.JobPostModel;
import com.fh.taolijie.domain.SHPostModel;
import com.fh.taolijie.service.BannerPicService;
import com.fh.taolijie.service.JobPostService;
import com.fh.taolijie.service.ShPostService;
import com.fh.taolijie.utils.Constants;
import com.fh.taolijie.utils.ObjWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wynfrith on 15-6-11.
 */
@RequestMapping(value = "/")
@Controller
public class HIndexController {

    @Autowired
    JobPostService jobPostService;
    @Autowired
    ShPostService shPostService;

    @Autowired
    BannerPicService banService;

    /**
     * 显示主页
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(HttpSession session, Model model){
        Credential credential = CredentialUtils.getCredential(session);

        // 放入兼职二手信息
        List<JobPostModel> jobs = jobPostService.getAllJobPostList(0, 6, new ObjWrapper()).stream().filter(s->!s.isDeleted()).collect(Collectors.toList());
        List<SHPostModel> shs = shPostService.getAllPostList(0, 3, new ObjWrapper()).stream().filter(s->!s.isDeleted()).collect(Collectors.toList());;

        // 放入banner
        ListResult<BannerPicModel> banResult = banService.getBannerList(0, Integer.MAX_VALUE);

        model.addAttribute("jobs", jobs);
        model.addAttribute("shs", shs);
        model.addAttribute("mem", credential);

        model.addAttribute("bannerList", banResult.getList());
        model.addAttribute("bannerCount", banResult.getResultCount());

        return "pc/index";
    }


    /**
     * 搜索一条兼职
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam(defaultValue = "") String content,
                         @RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "job") String type,
                         @RequestParam(defaultValue = Constants.PAGE_CAPACITY + "") int pageSize,
                         Model model) {


        if(type.equals("job")){
            JobPostModel jobCommand = new JobPostModel();
            // 根据标题或内容匹配
            jobCommand.setTitle(content);
            jobCommand.setJobDetail(content);
            List<JobPostModel> list = jobPostService.runSearch(jobCommand, (page - 1)*pageSize, pageSize,new ObjWrapper());

            int pageStatus = 1;
            if(list.size() == 0){
                pageStatus = 0;
            }else if(list.size() == pageSize){
                pageStatus = 2;
            }
            model.addAttribute("pageStatus",pageStatus);
            model.addAttribute("jobs", list);
            model.addAttribute("page", page);
            return "pc/joblist";
        } else {
            SHPostModel shCommand = new SHPostModel();
            // 根据标题或内容匹配
            shCommand.setTitle(content);
            shCommand.setDescription(content);
            List<SHPostModel> list =shPostService.runSearch(shCommand,new ObjWrapper());

            int pageStatus = 1;
            if(list.size() == 0){
                pageStatus = 0;
            }else if(list.size() == pageSize){
                pageStatus = 2;
            }
            model.addAttribute("pageStatus",pageStatus);

            model.addAttribute("shs", list);
            model.addAttribute("page", page);
            return "pc/shlist";
        }

    }




}
