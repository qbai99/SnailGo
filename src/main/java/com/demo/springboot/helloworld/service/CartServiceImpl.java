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
    public List<Cart> selectall(Long userid){
        return cartMapper.selectAll(userid);
    }

    @Override
    public List<Cart> selectallnr(Long userid){
        return cartMapper.selectAllNr(userid);
    }

    @Override
    public void del(int id){
        cartMapper.del(id);
    }

    @Override
    public List<Cart> selectByid(Integer id){
        return cartMapper.selectByid(id);
    }
}
