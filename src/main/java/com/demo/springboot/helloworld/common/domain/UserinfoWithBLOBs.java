package com.demo.springboot.helloworld.common.domain;

import java.io.UnsupportedEncodingException;

public class UserinfoWithBLOBs extends Userinfo {
    private byte[] userImg;

    private String userIntroduction;

    public String getUserImg() throws UnsupportedEncodingException {
        String str = new String(userImg, "utf-8");
        return str;
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