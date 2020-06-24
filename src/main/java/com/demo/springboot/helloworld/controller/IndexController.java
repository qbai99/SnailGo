package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.service.GoodsService;
import com.demo.springboot.helloworld.service.PayService;
import com.demo.springboot.helloworld.service.UserfinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private GoodsService goodsService;
    private UserfinanceService userfinanceService;
    @RequestMapping({"/","index"})
    public String index(Model model){
        List<Goods> tmp= goodsService.allgoods();
        model.addAttribute("allgoods",tmp);
        return "index";
    }

    @RequestMapping("/Listall")
    public  String Listall(){
        return "ListProducts";
    }

}
