package com.example.group2.service.Impl;

import com.example.group2.dao.UserMapper;
import com.example.group2.entity.ChangeableUserInfoEntity;
import com.example.group2.entity.LoginEntity;
import com.example.group2.service.UserService;
import com.example.group2.util.TokenUtil;
import com.example.group2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    /**
     * 查找数据库中是否有该用户
     *
     * @param userPhone 用户手机号
     * @return boolean 返回是否有该用户
     */
    @Override
    public boolean findUser(String userPhone) {
        try{
            User user=userMapper.findUserByPhone(userPhone);
            return user!=null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 将用户添加至数据库中
     *
     * @param userPhone
     * @param userName
     * @param password
     */
    @Override
    public User addUser(String userPhone, String userName, String password) {
        User user=new User(userName,password,userPhone);
        userMapper.addUserWith3Info(user);

        //生成文件夹
        File file=new File("src/main/resources/Users/" + user.getUserId());
        if (!file.exists()){ //
            System.out.println("--------mkdir for new user--------");
            file.mkdirs(); //create dir
            File avatarDir=new File("src/main/resources/Users/" + user.getUserId()+"/avatar");
            avatarDir.mkdirs();
        }
        return user;
    }

    /**
     * 登录时调用
     *
     * @param loginEntity 登录界面表单（username、password）
     * @return User 若正确登录，返回一个完整信息的user对象；否则返回null
     */
    @Override
    public User checkLogin(LoginEntity loginEntity) {
        User user=userMapper.findUserByPhone(loginEntity.getUserphone());//用户可能用手机号登录
        if (user!=null && user.getPassword().equals(loginEntity.getPassword())) return user;

        if(user==null) user=userMapper.findUserByEmail(loginEntity.getUserphone());//用户可能用邮箱登录
        if (user!=null && user.getPassword().equals(loginEntity.getPassword())) return user;

        return null;
    }

    /**
     * 基于一个user对象，产生token
     *
     * @param user user对象，包含id,name,password,phone
     * @return String token
     */
    @Override
    public String generateToken(User user) {
        return TokenUtil.sign(user);
    }

    @Override
    public Boolean uploadAvatar(int userId, String avatar) {
        try{
            userMapper.uploadAvatar(userId,avatar);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * 用户修改基础信息
     *
     */
    @Override
    public Boolean updateBasicInfo(User user) {
        try{
            userMapper.uploadTrueName(user);
            userMapper.uploadCity(user);
            userMapper.uploadEmail(user);
            userMapper.uploadPhone(user);
            userMapper.uploadGender(user);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
