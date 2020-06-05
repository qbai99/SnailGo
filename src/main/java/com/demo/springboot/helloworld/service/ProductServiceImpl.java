package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Product;
import com.demo.springboot.helloworld.common.domain.ProductExample;
import com.demo.springboot.helloworld.mapper.ProductMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product selectById(String pid) {

        return productMapper.selectById(pid);
    }

    @Override
    public PageInfo list() {
        ProductExample example = new ProductExample();
        Page<Object> objects = PageHelper.startPage(2, 5);
        List<Product> products = productMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(products);
        return pageInfo;
    }
}
