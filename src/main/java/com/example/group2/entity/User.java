package com.example.group2.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class User {
    private int userId;
    private String userName;//user nick name
    private String trueName;//user true name
    private String password;
    private String userPhone;
    private String email;
    private String avatar;
    private boolean isAdmin;
    private boolean gender;//false代表female，true代表male
    private String city;
    private Date birthDate;
    private Timestamp registerTime;

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, String userPhone) {
        this.userName = userName;
        this.password = password;
        this.userPhone = userPhone;
    }

    public User(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public User(int userId, String userName, String password, String userPhone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userPhone = userPhone;
    }

    public User(int userId, String userName, String password, String userPhone, String avatar) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userPhone = userPhone;
        this.avatar = avatar;
    }

    public User(int userId, String userName, String trueName, String password, String userPhone, String email, String avatar, boolean isAdmin, boolean gender, String city, Date birthDate, Timestamp registerTime) {
        this.userId = userId;
        this.userName = userName;
        this.trueName = trueName;
        this.password = password;
        this.userPhone = userPhone;
        this.email = email;
        this.avatar = avatar;
        this.isAdmin = isAdmin;
        this.gender = gender;
        this.city = city;
        this.birthDate = birthDate;
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", trueName='" + trueName + '\'' +
                ", password='" + password + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", isAdmin=" + isAdmin +
                ", gender=" + gender +
                ", city='" + city + '\'' +
                ", birthDate=" + birthDate +
                ", registerTime=" + registerTime +
                '}';
    }
}
