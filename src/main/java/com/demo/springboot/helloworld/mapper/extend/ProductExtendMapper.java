package com.demo.springboot.helloworld.mapper.extend;

import com.demo.springboot.helloworld.common.domain.Product;

public interface ProductExtendMapper {
    Product selectById(String pid);
}
