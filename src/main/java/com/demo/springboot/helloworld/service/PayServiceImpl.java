package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.mapper.UserfinanceMapper;
import com.demo.springboot.helloworld.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService{
    @Autowired
    private UserfinanceMapper userfinanceMapper;

    @Override
    public Double getbalance() {
        return userfinanceMapper.selectBalance();
    }
}
