package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Shop;
import org.springframework.stereotype.Service;

@Service
public interface ShopService {
    Shop information(String userAdmin);
}
