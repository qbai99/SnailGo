package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.ShippingState;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ShippingStateService {

    List<ShippingState> find(Long orderId);

    Long getMaxId();

    void insertone(Long shipid, Long orderId, Date date, String loc,String info);
}
