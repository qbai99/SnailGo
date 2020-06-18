package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Cart;

import java.util.List;

public interface CartService {
    List<Cart> selectall();
}
