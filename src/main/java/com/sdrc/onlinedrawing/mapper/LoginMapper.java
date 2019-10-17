package com.sdrc.onlinedrawing.mapper;

import com.sdrc.onlinedrawing.pojo.UserAdmin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {
    /**
     * 插入管理员信息
     * @param userAdmin
     * @return
     */
    @Insert("insert into table_user_admin(user_name,pass_word,salt,head_url,create_time) values(#{userName},#{passWord},#{salt},'',now())")
    int insertAddUserAdminInfo(UserAdmin userAdmin);

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    @Select("select user_name as userName, pass_word as passWord, salt as salt, head_url as headUrl from table_user_admin where user_name = #{username}")
    UserAdmin selectUserAdminByUserName(@Param("username") String userName);
}
