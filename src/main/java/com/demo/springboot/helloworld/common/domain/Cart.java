package com.demo.springboot.helloworld.common.domain;

public class Cart {
    private Integer cartId;

    private Long userId;

    private Integer shoCartId;

    private String goodsName;

    private Integer goodsRemaining;

    private Integer goodsQuantity;

    private Double goodsPrice;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getShoCartId() {
        return shoCartId;
    }

    public void setShoCartId(Integer shoCartId) {
        this.shoCartId = shoCartId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getGoodsRemaining() {
        return goodsRemaining;
    }

    public void setGoodsRemaining(Integer goodsRemaining) {
        this.goodsRemaining = goodsRemaining;
    }

    public Integer getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(Integer goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}