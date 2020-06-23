package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Cart;

import java.util.List;

public interface CartService {
    List<Cart> selectall(Long userid);

    List<Cart> selectallnr(Long userid);

    void del(int id);

    List<Cart> selectByid(Integer id);
}
