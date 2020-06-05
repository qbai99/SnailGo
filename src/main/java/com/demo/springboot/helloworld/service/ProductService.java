package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Product;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {
    Product selectById(String pid);

    PageInfo list();
}
