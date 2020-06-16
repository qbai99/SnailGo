package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Order;
import com.demo.springboot.helloworld.common.domain.OrderExample;
import com.demo.springboot.helloworld.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> check() {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andBuyerIdEqualTo((long) 1);
        List<Order> orderList = orderMapper.selectByExample(orderExample);

        return orderList;
    }
}
