package com.demo.springboot.helloworld.common.domain;

public class UserinfoWithBLOBs extends Userinfo {
    private byte[] userImg;

    private String userIntroduction;

    public byte[] getUserImg() {
        return userImg;
    }

    public void setUserImg(byte[] userImg) {
        this.userImg = userImg;
    }

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction == null ? null : userIntroduction.trim();
    }
}