package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> search(String name);

    List<Goods> searchtest(String search_input);
}
