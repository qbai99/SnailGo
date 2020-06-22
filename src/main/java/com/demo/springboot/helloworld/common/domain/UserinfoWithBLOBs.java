package com.demo.springboot.helloworld.common.domain;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class UserinfoWithBLOBs extends Userinfo {
    private byte[] userImg;

    private String userIntroduction;

    public String getUserImg(){
        String str = "";
        try {
            str = new String(userImg, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
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

    @Override
    public String toString() {
        return "UserinfoWithBLOBs{" +
                "userImg=" + Arrays.toString(userImg) +
                ", userIntroduction='" + userIntroduction + '\'' +
                '}';
    }
}