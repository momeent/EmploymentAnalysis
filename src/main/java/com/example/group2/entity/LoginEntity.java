package com.example.group2.entity;

public class LoginEntity {
    private String userphone;
    private String password;

    public LoginEntity() {
    }

    public LoginEntity(String userphone, String password) {
        this.userphone = userphone;
        this.password = password;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "userphone='" + userphone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
