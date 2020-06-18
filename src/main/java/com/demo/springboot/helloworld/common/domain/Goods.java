package com.demo.springboot.helloworld.common.domain;

public class Goods {
    private Long goodsId;

    private Long shopId;

    private Long orderId;

    private Double goodsPrice;

    private String goodsName;

    private Integer goodsRemaning;

    private String goodsDsp;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getGoodsRemaning() {
        return goodsRemaning;
    }

    public void setGoodsRemaning(Integer goodsRemaning) {
        this.goodsRemaning = goodsRemaning;
    }

    public String getGoodsDsp() {
        return goodsDsp;
    }

    public void setGoodsDsp(String goodsDsp) {
        this.goodsDsp = goodsDsp == null ? null : goodsDsp.trim();
    }
}