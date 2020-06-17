package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> selectall(){
        return cartMapper.selectAll();
    }
}
