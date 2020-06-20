package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> check(String userAdmin);
}
