package com.example.group2.entity;

/**
 * 用户注册时填的表对应的类
 */
public class SignupForm {
    private String username;
    private String password;
    private String userphone;
    private String code;//验证码

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SignupForm() {
    }

    public SignupForm(String username, String password, String userphone, String code) {
        this.username = username;
        this.password = password;
        this.userphone = userphone;
        this.code = code;
    }

    @Override
    public String toString() {
        return "SignupForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userphone='" + userphone + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
