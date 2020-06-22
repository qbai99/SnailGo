package com.demo.springboot.helloworld.common.domain;

public class Shop {
    private Long shopId;

    private Long userId;

    private String shopName;

    private String shopMainBussiness;

    private Double shopStar;

    private String shopDsp;

    private String shopLoc;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopMainBussiness() {
        return shopMainBussiness;
    }

    public void setShopMainBussiness(String shopMainBussiness) {
        this.shopMainBussiness = shopMainBussiness == null ? null : shopMainBussiness.trim();
    }

    public Double getShopStar() {
        return shopStar;
    }

    public void setShopStar(Double shopStar) {
        this.shopStar = shopStar;
    }

    public String getShopDsp() {
        return shopDsp;
    }

    public void setShopDsp(String shopDsp) {
        this.shopDsp = shopDsp == null ? null : shopDsp.trim();
    }

    public String getShopLoc() {
        return shopLoc;
    }

    public void setShopLoc(String shopLoc) {
        this.shopLoc = shopLoc == null ? null : shopLoc.trim();
    }
}