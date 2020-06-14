package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/search")
    @ResponseBody
    public List<Goods> search(String name){
        List<Goods> list=goodsService.search(name);
        return list;
    }
    @RequestMapping("/details")
    public String details(){
        return "/goods/details";
    }

}
