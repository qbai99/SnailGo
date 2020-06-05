package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Product;
import com.demo.springboot.helloworld.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    //查询pid=p001的商品,同时获取它的所属类别
    @RequestMapping("/selectById")
    @ResponseBody
    public Product selectById(){
        String pid= "p001";
       return productService.selectById(pid);
    }
        //查询所有商品
    @RequestMapping("/list")
    @ResponseBody
    public PageInfo list(){
        return productService.list();
    }
}
