package com.example.group2.dao;
import com.example.group2.entity.ChangeableUserInfoEntity;
import com.example.group2.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    /**
     * 通过用户ID来找到用户
     * @param userId 用户ID
     * @return User
     */
    @Select("select * from user where user_id=#{userId}")
    @Results({
            @Result(property = "userPhone",column = "user_phone"),
            @Result(property = "userName", column = "user_nick_name")
    })
    User findUserById(int userId);

    /**
     * 通过用户手机号来找到用户
     * @param userPhone 用户手机号
     * @return User
     */
    @Select("select * from user where user_phone = #{userPhone}")
    @Results({
            @Result(property = "userPhone",column = "user_phone"),
            @Result(property = "userName", column = "user_nick_name")
    })
    User findUserByPhone(String userPhone);
    @Select("select * from user where email = #{userPhone}")
    @Results({
            @Result(property = "userPhone",column = "user_phone"),
            @Result(property = "userName", column = "user_nick_name")
    })
    User findUserByEmail(String userPhone);
    @Select("select * from user where user_nick_name = #{userPhone}")
    @Results({
            @Result(property = "userPhone",column = "user_phone"),
            @Result(property = "userName", column = "user_nick_name")
    })
    User findUserByNickName(String userPhone);

    /**
     * 传入用户的3个信息（nick name、password、phone）来添加用户。
     * 用在注册时
     * 添加后,user对象中的userId将被填充为数据库产生的user_id
     * @param user 用户对象
     */
    @Options(useGeneratedKeys = true,keyProperty = "userId",keyColumn = "user_id")
    @Insert("INSERT INTO `careercrafthub`.`user` ( `user_nick_name`,`password` , `user_phone`) " +
            "VALUES ( #{userName}, #{password}, #{userPhone});")
    void addUserWith3Info(User user);

    @Update("UPDATE `careercrafthub`.`user` SET `avatar` = #{avatar} WHERE `user_id` =#{userId};")
    void uploadAvatar(int userId,String avatar);

    /**
     * 更新基础信息
     *
     */
    @Update("UPDATE `careercrafthub`.`user` SET `true_name` = #{trueName} WHERE `user_id` =#{userId};"
            )
    void uploadTrueName(User user);
    @Update("UPDATE `careercrafthub`.`user` SET `user_phone` = #{userPhone} WHERE `user_id` =#{userId};"
    )
    void uploadPhone(User user);
    @Update("UPDATE `careercrafthub`.`user` SET `email` = #{email} WHERE `user_id` =#{userId};"
    )
    void uploadEmail(User user);
    @Update("UPDATE `careercrafthub`.`user` SET `gender` = #{gender} WHERE `user_id` =#{userId};"
    )
    void uploadGender(User user);
    @Update("UPDATE `careercrafthub`.`user` SET `city` = #{city} WHERE `user_id` =#{userId};"
    )
    void uploadCity(User user);
}
