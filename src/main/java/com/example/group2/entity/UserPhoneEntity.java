package com.example.group2.entity;

public class UserPhoneEntity {
    private String userphone;

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }


    public UserPhoneEntity() {
    }

    public UserPhoneEntity(String userphone) {
        this.userphone = userphone;
    }

    @Override
    public String toString() {
        return "UserPhoneEntity{" +
                "userphone='" + userphone + '\'' + '}';
    }
}
