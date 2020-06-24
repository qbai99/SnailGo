package com.demo.springboot.helloworld.common.domain;

public class Cart {

    private Integer id;

    private Long userId;

    private Long goodsId;

    private String goodsName;

    private Integer goodsQuantity;

    private Double goodsPrice;

    private Integer goodsRemaning;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
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

    public Integer getGoodsRemaning() {
        return goodsRemaning;
    }

    public void setGoodsRemaning(Integer goodsRemaning) {
        this.goodsRemaning = goodsRemaning;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsQuantity=" + goodsQuantity +
                ", goodsPrice=" + goodsPrice +
                ", goodsRemaning=" + goodsRemaning +
                '}';
    }
}