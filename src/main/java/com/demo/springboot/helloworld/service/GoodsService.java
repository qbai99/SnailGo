package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> search(String search_key);
    List<Goods> goodsdetails(long id);
    List<Goods> searchtest(String search_input);


    List<Goods> allgoods();
}
