package com.sdrc.onlinedrawing.service.Impl;

import com.sdrc.onlinedrawing.mapper.LoginMapper;
import com.sdrc.onlinedrawing.pojo.UserAdmin;
import com.sdrc.onlinedrawing.service.LoginService;
import com.sdrc.onlinedrawing.util.InfoUtils;
import com.sdrc.onlinedrawing.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;
    /**
     * 根据登录信息进行校验
     * @param userName
     * @param passWord
     * @return
     */
    public InfoUtils getLoginInfo(String userName, String passWord) throws Exception {
        InfoUtils infoUtils = new InfoUtils();
        infoUtils.setaBoolean(false);
        if (StringUtils.isEmpty(userName)){
            infoUtils.setMessage("用户名不能为空！");
            return infoUtils;
        }else if (StringUtils.isEmpty(passWord)){
            infoUtils.setMessage("密码不能为空！");
            return infoUtils;
        }else{
            UserAdmin userAdmin  = this.loginMapper.selectUserAdminByUserName(userName);
            if (org.springframework.util.StringUtils.isEmpty(userAdmin)){
                infoUtils.setMessage("没有此账号！");
                return infoUtils;
            }
            if (!MD5Util.md5Encode(passWord+userAdmin.getSalt()).equals(userAdmin.getPassWord())){
                infoUtils.setMessage("密码错误！");
                return infoUtils;
            }

            infoUtils.setMessage("登录成功！");
            infoUtils.setaBoolean(true);
        }
        return infoUtils;
    }

    /**
     * 添加管理员
     * @param userName
     * @param passWord
     * @return
     */
    @Override
    public InfoUtils addUserAdmin(String userName, String passWord) {
        InfoUtils infoUtils = new InfoUtils();
        UserAdmin userAdmin = new UserAdmin();
        infoUtils.setaBoolean(false);
        if (StringUtils.isEmpty(userName)){
            infoUtils.setMessage("用户名不能为空！");
            return infoUtils;
        }else if (StringUtils.isEmpty(passWord)){
            infoUtils.setMessage("密码不能为空！");
            return infoUtils;
        }else{
            UserAdmin userAdmin1 = this.loginMapper.selectUserAdminByUserName(userName);
            if (!org.springframework.util.StringUtils.isEmpty(userAdmin1)){
                infoUtils.setMessage("用户已经存在");
                return infoUtils;
            }
            userAdmin.setUserName(userName);
            userAdmin.setSalt(MD5Util.saltEncode());
            try {
                userAdmin.setPassWord(MD5Util.md5Encode(passWord+userAdmin.getSalt()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                int nubmer = this.loginMapper.insertAddUserAdminInfo(userAdmin);
                if (nubmer == 1){
                    infoUtils.setMessage("添加成功!");
                    infoUtils.setaBoolean(true);
                }else {
                    infoUtils.setMessage("添加失败");
                }

            } catch (Exception e) {
                infoUtils.setMessage("添加失败");
                e.printStackTrace();
            }
        }
        return infoUtils;
    }
}
