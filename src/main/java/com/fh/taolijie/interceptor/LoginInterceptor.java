package com.fh.taolijie.interceptor;

import cn.fh.security.credential.Credential;
import cn.fh.security.utils.CredentialUtils;
import com.fh.taolijie.component.ListResult;
import com.fh.taolijie.domain.JobPostCategoryModel;
import com.fh.taolijie.domain.NewsModel;
import com.fh.taolijie.domain.SHPostCategoryModel;
import com.fh.taolijie.service.JobPostCateService;
import com.fh.taolijie.service.NewsService;
import com.fh.taolijie.service.ResumeService;
import com.fh.taolijie.service.ShPostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断session是否存在
        HttpSession session = request.getSession(false);
        if (null != session) {
            // session存在，检查是否登陆
            Credential credential = CredentialUtils.getCredential(session);
            if (null != credential) {
                //已经登陆，将用户名放到model中
                request.setAttribute("isLoggedIn", true);
                request.setAttribute("username", credential.getUsername());
            } else {
                // 没登陆
                request.setAttribute("isLoggedIn", false);
            }
        } else {
            request.setAttribute("isLoggedIn", false);
        }

        return  true;
    }

}