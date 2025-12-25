package com.example.group2.service;

import com.example.group2.entity.ChangeableUserInfoEntity;
import com.example.group2.entity.LoginEntity;
import com.example.group2.entity.User;
import jakarta.servlet.http.HttpSession;

public interface UserService {
    /**
     * 查找数据库中是否有该用户
     * @param userPhone 用户手机号
     * @return boolean 返回是否有该用户
     */
    boolean findUser(String userPhone);

    /**
     * 将用户添加至数据库中
     * @param userPhone 用户手机号
     * @param userName 代表nick name
     * @param password 用户密码
     */
    User addUser(String userPhone,String userName,String password);

    /**
     * 登录时调用
     * @param loginEntity 登录界面表单（username、password）
     * @return User 若正确登录，返回一个完整信息的user对象；否则返回null
     */
    User checkLogin(LoginEntity loginEntity);

    /**
     * 基于一个user对象，产生token
     * @param user user对象，包含id,name,password,phone
     * @return String token
     */
    String generateToken(User user);


    /**
     * 用户上传头像后保存、修改数据库
     * @param userId 用户id
     * @param avatar 用户头像的文件名
     * @return 是否成功
     */
    Boolean uploadAvatar(int userId,String avatar);

    /**
     * 用户修改基础信息
     * @param userId 用户id
     * @param changeableUserInfoEntity 基础信息表
     * @return 是否成功
     */
    Boolean updateBasicInfo(User user);

}
