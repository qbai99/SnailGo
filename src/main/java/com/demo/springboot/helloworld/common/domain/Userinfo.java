package com.demo.springboot.helloworld.common.domain;

import java.util.Date;

public class Userinfo {
    private Long userId;

    private Integer messageId;

    private Long signUpId;

    private Integer loginId;

    private Long financeId;

    private Long useLevelId;

    private Long shopId;

    private String userAdmin;

    private String userName;

    private String userPassword;

    private Integer usersex;

    private Date userBirthdate;

    private String userPhonenumber;

    private String userImg;

    private Boolean userTag;


    private String userIntroduction;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Long getSignUpId() {
        return signUpId;
    }

    public void setSignUpId(Long signUpId) {
        this.signUpId = signUpId;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Long getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Long financeId) {
        this.financeId = financeId;
    }

    public Long getUseLevelId() {
        return useLevelId;
    }

    public void setUseLevelId(Long useLevelId) {
        this.useLevelId = useLevelId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(String userAdmin) {
        this.userAdmin = userAdmin == null ? null : userAdmin.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUsersex() {
        return usersex;
    }

    public void setUsersex(Integer usersex) {
        this.usersex = usersex;
    }

    public Date getUserBirthdate() {
        return userBirthdate;
    }

    public void setUserBirthdate(java.sql.Date userBirthdate) {
        this.userBirthdate = userBirthdate;
    }

    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber == null ? null : userPhonenumber.trim();
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg == null ? null : userImg.trim();
    }

    public Boolean getUserTag() {
        return userTag;
    }

    public void setUserTag(Boolean userTag) {
        this.userTag = userTag;
    }


    public String getUserIntroductoin() {
        return userIntroduction;
    }

    public void setUserIntroductoin(String userIntroductoin) {
        this.userIntroduction = userIntroductoin == null ? null : userIntroductoin.trim();
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "userId=" + userId +
                ", messageId=" + messageId +
                ", signUpId=" + signUpId +
                ", loginId=" + loginId +
                ", financeId=" + financeId +
                ", useLevelId=" + useLevelId +
                ", shopId=" + shopId +
                ", userAdmin='" + userAdmin + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", usersex=" + usersex +
                ", userBirthdate=" + userBirthdate +
                ", userPhonenumber='" + userPhonenumber + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userTag=" + userTag +
                ", userIntroduction='" + userIntroduction + '\'' +
                '}';
    }
}