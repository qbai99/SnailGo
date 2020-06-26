package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> check(String userAdmin);

    void insertone(Long orderId,Long userid,Integer goodsId,Long buyerid,Long sellerId, Integer addId,String goodsName,Integer quantity,Double price);

    Long getMaxId();
}
