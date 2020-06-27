package com.demo.springboot.helloworld.common.domain;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GoodsImg {
    private Long imgId;

    private Long goodsId;

    private byte[] goodsImg;

    public Long getImgId() {
        return imgId;
    }

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsImg() {
        String str = "";
        try {
            str = new String(goodsImg, "utf-8");
        } catch (UnsupportedEncodingException e) {
            Logger LOGGER = Logger.getLogger("lavasoft");
            LOGGER.setLevel(Level.INFO);
            LOGGER.info("aaa");
        }
        return str;
    }

    public void setGoodsImg(byte[] goodsImg) {
        this.goodsImg = goodsImg;
    }
}