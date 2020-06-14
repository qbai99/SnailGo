package com.demo.springboot.helloworld.common.domain;

public class UserinfoWithBLOBs extends Userinfo {
    private byte[] usersex;

    private String userIntroductoin;

    public byte[] getUsersex() {
        return usersex;
    }

    public void setUsersex(byte[] usersex) {
        this.usersex = usersex;
    }

    public String getUserIntroductoin() {
        return userIntroductoin;
    }

    public void setUserIntroductoin(String userIntroductoin) {
        this.userIntroductoin = userIntroductoin == null ? null : userIntroductoin.trim();
    }
}