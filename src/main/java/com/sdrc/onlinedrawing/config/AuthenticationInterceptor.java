package com.sdrc.onlinedrawing.config;

import com.sdrc.onlinedrawing.pojo.UserAdmin;
import com.sdrc.onlinedrawing.service.LoginService;
import com.sdrc.onlinedrawing.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Resource
    LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //进入方法之前进行的操作
        //获取token
        String token  =  request.getHeader("token");
        //如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        response.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        if (StringUtils.isEmpty(token)){
            response.getWriter().append("无token,请登录");
            throw new RuntimeException("无token,请登录");
        }
        if (JwtUtil.isExpires(token)){
            response.getWriter().append("时间已经过时");
            throw new RuntimeException("时间已经过时");
        } else{
            String userName= JwtUtil.getUsername(token);
            UserAdmin userAdmin = loginService.getUserAdminInfoByUserName(userName);
            if (org.springframework.util.StringUtils.isEmpty(userAdmin)){
                response.getWriter().append("没有此用户信息,请登录");
                throw new RuntimeException("没有此用户信息,请登录");
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
