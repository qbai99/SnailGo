package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/cart")
    public String cart(){
        return "cart";
    }

    @RequestMapping("/cartlist")
    @ResponseBody
    public List<Cart> cartList(){

        List<Cart> list=cartService.selectall();
        System.out.println("123");
        return list;
    }
}
