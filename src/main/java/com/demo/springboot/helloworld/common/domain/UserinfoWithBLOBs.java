package com.demo.springboot.helloworld.common.domain;

public class UserinfoWithBLOBs extends Userinfo {
    private Integer usersex;

    private String userIntroductoin;

    public Integer getUsersex() {
        return usersex;
    }

    public void setUsersex(Integer usersex) {
        this.usersex = usersex;
    }

    public String getUserIntroductoin() {
        return userIntroductoin;
    }

    public void setUserIntroductoin(String userIntroductoin) {
        this.userIntroductoin = userIntroductoin == null ? null : userIntroductoin.trim();
    }
}