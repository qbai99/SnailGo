package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.common.domain.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> search(String search_key, String goods_tag);
    List<Goods> goodsdetails(long id);
    List<Goods> searchtest(String search_input);
    List<Goods> allgoods();
    List<Cart> addgoodstocart(long userId, long goodsId, double price, int quantity, String goodsname);
    int selectRem(long goodsId);

    List<Goods> selectByShopid(Long shopId);

    boolean deleteById(String goodsId);

    boolean UpdateInfo(String goodsId, String name, String dsp, String tag, String price, String remain);

    boolean AddGoods(String shopId, String goodsName, String goodsIntro, String goodsTag, String goodsPrice, String goodsRemain, String file);

    Integer getShopIdBygoodsId(Integer goodsId);

    List<Goods> selectNameAndPri(Integer goodsId);

    void delnum(Integer goodsId, Integer quantity);
}
