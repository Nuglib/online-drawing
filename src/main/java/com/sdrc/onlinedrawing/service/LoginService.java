package com.sdrc.onlinedrawing.service;

import com.sdrc.onlinedrawing.pojo.UserAdmin;
import com.sdrc.onlinedrawing.util.InfoUtils;

public interface LoginService {
    InfoUtils getLoginInfo(String userName, String passWord) throws Exception;

    InfoUtils addUserAdmin(String userName, String passWord);

    UserAdmin getUserAdminInfoByUserName(String userName);
}
