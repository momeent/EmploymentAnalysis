package com.example.group2.entity;


import java.sql.Date;
import java.sql.Timestamp;

/**
 * 可修改的用户信息表
 * 用于用户修改简历时修改基础信息、更新数据库
 */
public class ChangeableUserInfoEntity {
    private String userName;//user nick name
    private String trueName;//user true name
    private String userPhone;
    private String email;
    private boolean gender;//false代表female，true代表male
    private String city;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ChangeableUserInfoEntity() {
    }

    public ChangeableUserInfoEntity(String userName, String trueName, String userPhone, String email, boolean gender, String city) {
        this.userName = userName;
        this.trueName = trueName;
        this.userPhone = userPhone;
        this.email = email;
        this.gender = gender;
        this.city = city;
    }

    @Override
    public String toString() {
        return "ChangeableUserInfoEntity{" +
                "userName='" + userName + '\'' +
                ", trueName='" + trueName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                '}';
    }
}
