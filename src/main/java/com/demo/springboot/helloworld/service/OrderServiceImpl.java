package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Order;
import com.demo.springboot.helloworld.common.domain.OrderExample;
import com.demo.springboot.helloworld.common.domain.UserinfoExample;
import com.demo.springboot.helloworld.mapper.OrderMapper;
import com.demo.springboot.helloworld.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public List<Order> check(String userAdmin) {
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(userAdmin);
        Long userId = userinfoMapper.selectByExampleWithBLOBs(userinfoExample).get(0).getUserId();
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andBuyerIdEqualTo(userId);
        List<Order> orderList = orderMapper.selectByExample(orderExample);

        return orderList;
    }

    @Override
    public void insertone(Long orderId,Long userid,Integer goodsId,Long buyerid,Long sellerId, Integer addId,String goodsName,Integer quantity,Double price){
        Order list = new Order();
        list.setOrderId(orderId);
        list.setUserId(userid);
        Long goodsIdd=Long.valueOf(goodsId);
        list.setGoodsId(goodsIdd);
        list.setBuyerId(buyerid);
        list.setSellerId(sellerId);
        Long addIdd=Long.valueOf(addId);
        list.setAddressId(addIdd);
        list.setGoodsName(goodsName);
        Long quantityy=Long.valueOf(quantity);
        list.setGoodsQuantity(quantityy);
        list.setGoodsPrice(price);
        orderMapper.insertone(list);
    }

    @Override
    public Long getMaxId(){
        return orderMapper.getMaxId();
    }
}
