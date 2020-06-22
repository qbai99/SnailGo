package com.demo.springboot.helloworld.service;

import org.springframework.stereotype.Service;

@Service
public interface BrowsingRecordsService {
    Boolean Addrecords(String userAdmin, String url, String goodsId);
}
