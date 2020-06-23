package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Userfinance;

import java.util.List;

public interface PayService {
    Double getbalance();

    List<Userfinance> selectall(Long userid);

    void balancePay(int t);
}
