package com.sdrc.onlinedrawing.controller;

import com.sdrc.onlinedrawing.service.LoginService;
import com.sdrc.onlinedrawing.util.InfoUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("logincontroller")
@Api("登录登出接口")
public class LoginController {
    @Resource
    private LoginService loginService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    @ApiOperation(value = "登录接口")
    public InfoUtils login(@RequestParam(value = "username",required = true) String userName,
                           @RequestParam(value = "password",required = true) String passWord) throws Exception {
        return this.loginService.getLoginInfo(userName,passWord);
    }

    @RequestMapping(value = "adduser",method = RequestMethod.POST)
    public InfoUtils addUserAdmin(@RequestParam("username") String userName,
                                  @RequestParam("password") String passWord){
        return this.loginService.addUserAdmin(userName,passWord);
    }
}
