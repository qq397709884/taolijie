package com.fh.taolijie.controller.user;

import cn.fh.security.credential.Credential;
import cn.fh.security.utils.CredentialUtils;
import com.fh.taolijie.component.ListResult;
import com.fh.taolijie.component.ResponseText;
import com.fh.taolijie.constant.ErrorCode;
import com.fh.taolijie.constant.PostType;
import com.fh.taolijie.domain.*;
import com.fh.taolijie.domain.acc.MemberModel;
import com.fh.taolijie.domain.job.JobPostCategoryModel;
import com.fh.taolijie.domain.job.JobPostModel;
import com.fh.taolijie.service.*;
import com.fh.taolijie.service.acc.impl.SessionServ;
import com.fh.taolijie.service.impl.IntervalCheckService;
import com.fh.taolijie.service.job.JobPostCateService;
import com.fh.taolijie.service.job.JobPostService;
import com.fh.taolijie.utils.*;
import com.fh.taolijie.utils.json.JsonWrapper;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by wynfrith on 15-6-11.
 */
@Controller
@RequestMapping("/user/job")
public class UJobController {

    @Autowired
    JobPostService jobPostService;
    @Autowired
    JobPostCateService jobPostCateService;

    @Autowired
    private SessionServ sessionServ;
    @Autowired
    AccountService accountService;

    @Autowired
    UserService userService;
    @Autowired
    ReviewService reviewService;

    @Autowired
    NotificationService notiService;


    @Autowired
    IntervalCheckService icService;

    /**
     * 我的发布 GET
     *
     * @return
     */
    @RequestMapping(value = "mypost", method = RequestMethod.GET)
    public String myPost(@RequestParam(defaultValue = "0") int page,
                         @RequestParam (defaultValue = Constants.PAGE_CAPACITY + "") int pageSize,
                         HttpServletRequest req,
                         Model model){

        Credential credential = SessionUtils.getCredential(req);
        if(page < 0) page = 0;
        page = PageUtils.getFirstResult(page, pageSize);
        List<JobPostModel> jobs = jobPostService.getJobPostListByMember(credential.getId(), page, pageSize)
                .getList();

        int pageStatus = 1;
        if(jobs.size() == 0){
            pageStatus = 0;
        }else if(jobs.size() == pageSize){
            pageStatus = 2;
        }
        model.addAttribute("pageStatus",pageStatus);
        model.addAttribute("jobs",jobs);
        model.addAttribute("page",page);
        //model.addAttribute("totalPage", );
        model.addAttribute("isFav",false);

        return "pc/user/joblist";
    }


    /**
     * 获取已收藏的列表
     * @param page
     * @param model
     * @return
     */
    @RequestMapping(value = "myfav" ,method = RequestMethod.GET)
    public String fav(@RequestParam (defaultValue = "0") int page,
                      @RequestParam (defaultValue = Constants.PAGE_CAPACITY+"") int pageSize,
                      HttpServletRequest req,
                      Model model){
        Credential credential = SessionUtils.getCredential(req);
        //ObjWrapper objWrapper = new ObjWrapper();
        int totalPage = 0;

        page = PageUtils.getFirstResult(page, pageSize);
        List<JobPostModel> jobs = jobPostService.getFavoritePost(credential.getId(), page, pageSize)
                .getList();

        int pageStatus = 1;
        if(jobs.size() == 0){
            pageStatus = 0;
        }else if(jobs.size() == pageSize){
            pageStatus = 2;
        }
        model.addAttribute("pageStatus",pageStatus);
        model.addAttribute("jobs",jobs);
        model.addAttribute("page",page);
        model.addAttribute("isFav",true);

        return "pc/user/joblist";
    }

    /**
     * 发布兼职页面 get
     * @param
     * @return
     */
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String post(HttpServletRequest req, Model model) {
        int page = 0;
        int pageSize = Integer.MAX_VALUE;

        Credential credential = SessionUtils.getCredential(req);
        if (credential == null) {
            return "redirect:/login";
        }

        ListResult<JobPostCategoryModel> cateList= jobPostCateService.getCategoryList(page, pageSize);
        model.addAttribute("cates",cateList.getList());

        return "pc/user/jobpost";
    }
    //endregion


    /**
     * 修改兼职页面
     * 与发布兼职用同一个页面，只不过修改该兼职会填充好之前的字段
     *
     * @param id 传入要修改的job的id
     * @return
     */
    @RequestMapping(value = "change/{id}", method = RequestMethod.GET)
    public String change(@PathVariable int id, HttpServletRequest req, Model model) {
        //如果该job不是用户发送的,则返回404
        Credential credential = SessionUtils.getCredential(req);

        JobPostModel job = jobPostService.findJobPost(id);
        if(job == null|| !ControllerHelper.isCurrentUser(credential, job)){
            return "redirect:/404";
        }

        // 查询兼职分类
        ListResult<JobPostCategoryModel> cateList = jobPostCateService.getCategoryList(0, Integer.MAX_VALUE);
        model.addAttribute("job", job);
        model.addAttribute("cates", cateList.getList());

        return "pc/user/jobpost";
    }

    /**
     * 发布兼职信息 post ajax
     *
     * @param job
     * @return
     */
    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody String post(@Valid JobPostModel job,
                                     BindingResult result,
                                     HttpServletRequest req,
                                     HttpServletResponse resp) {

        if (result.hasErrors()) {
            JsonWrapper jw = new JsonWrapper(false, result.getAllErrors());
            return jw.getAjaxMessage();
        }

        Credential credential = SessionUtils.getCredential(req);
        String username = credential.getUsername();
        MemberModel mem = accountService.findMember(username, false);

        // 检查是否封号
        if (false == mem.getValid()) {
            // 已经封号了
            // T出登陆
            SessionUtils.logout(resp);
            sessionServ.deleteSession(SessionUtils.getSid(req));

            return new ResponseText(ErrorCode.USER_INVALID).toJson();
        }

        // 检查发送时间间隔
        if (false == icService.checkInterval(mem.getLastJobDate(), 1, TimeUnit.MINUTES)) {
            return new JsonWrapper(false, ErrorCode.TOO_FREQUENT).getAjaxMessage();
        }

        /*创建兼职信息*/
        job.setMemberId(credential.getId());
        job.setPostTime(new Date());
/*        job.setLikes(0);
        job.setDislikes(0);
        job.setComplaint(0);*/

        jobPostService.addJobPost(job);
        // 加分
        //Integer credits = userService.changeCredits(mem.getId(), OperationType.POST, mem.getCredits());
        //LogUtils.getInfoLogger().info("---new credits:{}, level:{}", credits, userService.queryLevel(credits));

        return new JsonWrapper(true, ErrorCode.SUCCESS).getAjaxMessage();
    }


    /**
     * 删除兼职 post ajax
     *
     * @return
     */
    //region 删除兼职 ajax String post
    @RequestMapping(value = "/del/{id}", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody
    String delPost(@PathVariable  int id,
                   @RequestParam(required = false) String ids,
                   HttpServletRequest req) {

        int uid = SessionUtils.getCredential(req).getId();

        String[] delIds = { String.valueOf(id) };

        //id=0视为多条删除
        if( id == 0 ){
            delIds = ids.split(Constants.DELIMITER);
        }


        for(String currId:delIds){
            // 根据id查找兼职
            JobPostModel job =jobPostService.findJobPost(Integer.parseInt(currId));
            if(job == null){
                return new JsonWrapper(false, ErrorCode.NOT_FOUND).getAjaxMessage();
            }

            // 判断是不是当前用户发布的
            if(job.getMember().getId()!=uid){
                return new JsonWrapper(false, ErrorCode.PERMISSION_ERROR).getAjaxMessage();
            }

            //删除兼职
            jobPostService.deleteJobPost(Integer.parseInt(currId));
        }


        return new JsonWrapper(true, ErrorCode.SUCCESS).getAjaxMessage();
    }



    /**
     * 收藏一条兼职
     */
    @RequestMapping(value = "/fav/{id}",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody String fav (@PathVariable int id,
                                     @RequestParam(required = false) String ids,
                                     HttpServletRequest req){

        Credential credential = SessionUtils.getCredential(req);
        if(credential == null)
            return  new JsonWrapper(false, ErrorCode.PERMISSION_ERROR).getAjaxMessage();


        String[] delIds = { String.valueOf(id) };
        //id=0视为多条删除
        if(id==0){
            delIds = ids.split(Constants.DELIMITER);
        }


        String status ="1";
        for (String currId:delIds) {
            Integer jobId = Integer.valueOf(currId);

            if(jobPostService.findJobPost(jobId) == null) {
                return new JsonWrapper(false, ErrorCode.NOT_FOUND).getAjaxMessage();
            }

            //遍历用户的收藏列表
            //如果没有这条兼职则添加,反之删除
            boolean isFav = jobPostService.isPostFavorite(credential.getId(), jobId);

            if(isFav) { //找到,删除收藏
                jobPostService.unfavoritePost(credential.getId(),Integer.parseInt(currId));
                status = "1";
            } else { //没有找到,则添加收藏
                jobPostService.favoritePost(credential.getId(),Integer.parseInt(currId));
                status = "0";
            }
        }

        return new JsonWrapper(true, "status",status).getAjaxMessage();
    }


    /**
     * 取消收藏一条兼职 或多条
     */
    @RequestMapping(value = "/fav/del",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody String fav (HttpServletRequest req,
                                     @RequestParam(required = false) String ids){
        Credential credential = SessionUtils.getCredential(req);

        /*删除一个或多个*/
        try{
            for(String i : ids.split(";")){
                int currId = Integer.parseInt(i);
                jobPostService.unfavoritePost(credential.getId(), currId);
            }
        }catch (Exception e){
            return new JsonWrapper(false, ErrorCode.FAILED).getAjaxMessage();
        }
        return new JsonWrapper(true, ErrorCode.SUCCESS).getAjaxMessage();
    }

    /**
     * 赞
     * @param jobId
     * @return
     */
    @RequestMapping(value = "/{id}/like", method = RequestMethod.POST, produces = Constants.Produce.JSON)
    @ResponseBody
    public String likeJob(@PathVariable("id") Integer jobId,
                          HttpServletRequest req) {
        // 判断是否重复赞
        Credential cre = SessionUtils.getCredential(req);

        if (null == cre) {
            return new JsonWrapper(false, ErrorCode.NOT_LOGGED_IN).getAjaxMessage();
        }

        Integer userId = cre.getId();
        boolean liked = userService.isJobPostAlreadyLiked(userId, jobId);
        if (liked) {
            return new JsonWrapper(false, ErrorCode.ALREADY_DONE).getAjaxMessage();
        }

        userService.likeJobPost(userId, jobId);

        // 加分
        //MemberModel mem = jobPostService.findJobPost(jobId).getMember();
        //userService.changeCredits(mem.getId(), OperationType.LIKE, mem.getCredits());

        return new JsonWrapper(true, ErrorCode.SUCCESS).getAjaxMessage();
    }

    /**
     * 取消赞
     * @return
     */
    @RequestMapping(value = "/{id}/unlike", method = RequestMethod.POST, produces = Constants.Produce.JSON)
    @ResponseBody
    public String unlikeJob(@PathVariable("id") Integer jobId,
                            HttpServletRequest req) {
        // 登陆判断
        Credential cre = SessionUtils.getCredential(req);
        if (null == cre) {
            return new JsonWrapper(false, ErrorCode.NOT_LOGGED_IN).getAjaxMessage();
        }

        // 执行操作
        boolean opsResult = userService.unLikeJobPost(cre.getId(), jobId);
        // 返回false说明用户本来就没有点过赞
        if (false == opsResult) {
            return new JsonWrapper(false, ErrorCode.FAILED).getAjaxMessage();
        }

        return new JsonWrapper(true, ErrorCode.SUCCESS).getAjaxMessage();

    }

    /**
     * 检查是否已赞
     * @return
     */
    @RequestMapping(value = "/{id}/checklike", method = RequestMethod.GET, produces = Constants.Produce.JSON)
    @ResponseBody
    public String checkLike(@PathVariable("id") Integer jobId,
                            HttpServletRequest req) {
        // 登陆判断
        Credential cre = SessionUtils.getCredential(req);
        if (null == cre) {
            return new JsonWrapper(false, ErrorCode.NOT_LOGGED_IN).getAjaxMessage();
        }

        boolean liked = userService.isJobPostAlreadyLiked(cre.getId(), jobId);

        return new JsonWrapper(true, Boolean.toString(liked)).getAjaxMessage();
    }

    /**
     * @deprecated
     * 举报一条兼职
     */
    @RequestMapping(value = "/complaint/{id}", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody String complaint(HttpServletRequest req, @PathVariable int id){
        //TODO:限定举报数目
        Credential credential = SessionUtils.getCredential(req);
        if(credential == null){
            return new JsonWrapper(false, ErrorCode.NOT_LOGGED_IN).getAjaxMessage();
        }
        try{
            jobPostService.complaint(id);
        }
        catch(Exception e){
            System.out.println(e);
            return new JsonWrapper(false, ErrorCode.FAILED).getAjaxMessage();
        }
        return new JsonWrapper(true, ErrorCode.SUCCESS).getAjaxMessage();
    }

    /**
     * 更新兼职信息
     * @return
     */
    @RequestMapping(value = "/change/{jobId}",method = RequestMethod.POST, produces = Constants.Produce.JSON)
    public @ResponseBody String change(@PathVariable("jobId") Integer jobId,
                                       JobPostModel jobPostModel,
                                       HttpServletRequest req,
                                       HttpServletResponse resp){

        Credential credential = SessionUtils.getCredential(req);

        if (null == jobPostModel) {
            resp.setStatus(HttpStatus.BAD_REQUEST.value());
            return new JsonWrapper(false, ErrorCode.USER_INVALID).getAjaxMessage();
        }

        // 检查是不是本用户发布的信息
        jobPostModel.setId(jobId);
        JobPostModel job = jobPostService.findJobPost(jobPostModel.getId());
        if ( false == credential.getId().equals(job.getMemberId()) ) {
            return new JsonWrapper(false, ErrorCode.USER_INVALID).getAjaxMessage();
        }

        // 更新信息
        boolean operationResult = jobPostService.updateJobPost(jobPostModel.getId(), jobPostModel);
        if (false == operationResult) {
            return new JsonWrapper(false, ErrorCode.FAILED).getAjaxMessage();
        }

        return new JsonWrapper(true, ErrorCode.SUCCESS).getAjaxMessage();
    }

    /**
     * 刷新兼职数据 ajax
     * 更新一下posttime
     *
     * @param id      兼职的id
     */
    @RequestMapping(value = "refresh/{id}", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public
    @ResponseBody
    String refresh(@PathVariable int id, HttpServletRequest req) {
        //如果该job不是用户发送的,则错误json
        Credential credential = SessionUtils.getCredential(req);

        JobPostModel job = jobPostService.findJobPost(id);
        if(job == null) {
            return new JsonWrapper(false, ErrorCode.NOT_FOUND).getAjaxMessage();
        }

        if(!ControllerHelper.isCurrentUser(credential,job)){
            return  new JsonWrapper(false, ErrorCode.PERMISSION_ERROR).getAjaxMessage();
        }

        job.setPostTime(new Date());
        if(!jobPostService.updateJobPost(job.getId(),job)){
            return new JsonWrapper(false, ErrorCode.FAILED).getAjaxMessage();
        }

        return new JsonWrapper(true, ErrorCode.SUCCESS).getAjaxMessage();
    }

    /**
     * 发表评论
     * @return
     */
    @RequestMapping(value = "{jobId}/review/post", method = RequestMethod.POST, produces = Constants.Produce.JSON)
    @ResponseBody
    public String postReview(@PathVariable("jobId") Integer jobId,
                             ReviewModel model,
                             HttpServletRequest req) {

        Credential credential = SessionUtils.getCredential(req);
        if (null == credential) {
            return new JsonWrapper(false, ErrorCode.NOT_LOGGED_IN).getAjaxMessage();
        }

        model.setMemberId(credential.getId());
        model.setJobPostId(jobId);
        model.setTime(new Date());

        reviewService.addReview(model);
        Integer newReviewId = model.getId();

        // 发送被评论通知
        // 得到兼职的发送者
        JobPostModel job = jobPostService.findJobPost(jobId);
        Integer toMemberId = job.getMemberId();

        // 创建通知
        String commentTitle = "评论通知";
        String commentContent = StringUtils.concat(50, "你的帖子<a href=\"/item/job/",job.getId(),"\">[",
                job.getTitle(),
                "]</a>被评论了:",
                model.getContent());
        notiService.addCommentNotification(toMemberId, commentTitle, commentContent, jobId, PostType.JOB.toString());


        return new JsonWrapper(true, "reviewId", newReviewId.toString()).getAjaxMessage();
    }

    /**
     * 删除评论
     * @return
     */
    @RequestMapping(value = "{jobId}/review/delete/{reviewId}", method = RequestMethod.POST, produces = Constants.Produce.JSON)
    @ResponseBody
    public String deleteReview(@PathVariable("jobId") Integer jobId,
                               @PathVariable("reviewId") Integer reviewId,
                               HttpServletRequest req
                               ) {
        // 判断是不是自己发的评论
        Integer curUserId = SessionUtils.getCredential(req).getId();
        Integer targetUserId = reviewService.getById(reviewId).getMember().getId();
        if (false == curUserId.equals(targetUserId)) {
            return new JsonWrapper(false, "非法操作").getAjaxMessage();
        }

        // 删除评论
        reviewService.deleteReview(reviewId);
        // 删除评论回复
        reviewService.deleteReplyByReview(reviewId);

        return new JsonWrapper(true, ErrorCode.SUCCESS).getAjaxMessage();
    }


}
