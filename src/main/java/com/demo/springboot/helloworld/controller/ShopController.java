package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.common.domain.Shop;
import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.service.GoodsService;
import com.demo.springboot.helloworld.service.ShopService;
import com.demo.springboot.helloworld.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    UserinfoService userinfoService;

    @RequestMapping("/information")
    @ResponseBody
    public Map<String,Object> information(@CookieValue("username") String userAdmin){
        Shop shop = shopService.information(userAdmin);
        List<Goods> goodsList = goodsService.selectByShopid(shop.getShopId());
        Userinfo userinfo = userinfoService.findWithAdmin(userAdmin).get(0);

        Map<String,Object> map = new HashMap<>();
        map.put("shop",shop);
        map.put("goods",goodsList);
        map.put("user",userinfo);

        return map;
    }
}