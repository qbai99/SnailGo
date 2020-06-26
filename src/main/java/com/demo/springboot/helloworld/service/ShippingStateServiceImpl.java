package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.ShippingState;
import com.demo.springboot.helloworld.common.domain.ShippingStateExample;
import com.demo.springboot.helloworld.mapper.ShippingStateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShippingStateServiceImpl implements ShippingStateService{
    @Autowired
    ShippingStateMapper shippingStateMapper;

    @Override
    public List<ShippingState> find(Long orderId){
        ShippingStateExample shippingStateExample = new ShippingStateExample();
        shippingStateExample.createCriteria().andOrderIdEqualTo(orderId);

        List<ShippingState> shippingStates = shippingStateMapper.selectByExampleWithBLOBs(shippingStateExample);

        return shippingStates;
    }

    @Override
    public Long getMaxId(){
        return shippingStateMapper.getMaxId();
    }

    @Override
    public void insertone(Long shipid, Long orderId, Date date,String loc, String info){
        ShippingState ship=new ShippingState();
        ship.setId(shipid);
        ship.setOrderId(orderId);
        ship.setDate(date);
        ship.setLoc(loc);
        ship.setOtherInfo(info);
        shippingStateMapper.insert(ship);
    }
}
