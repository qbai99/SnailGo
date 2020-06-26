package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Shop;
import org.springframework.stereotype.Service;

@Service
public interface ShopService {
    Shop information(String userAdmin);

    boolean Change(String userAdmin,String shopId, String name, String mbs, String loc, String dsp);
}
