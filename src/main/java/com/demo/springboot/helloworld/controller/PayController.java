package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class PayController {
    @Autowired
    private PayService payService;
    @RequestMapping("/pay")
    public  String pay(){
        return "pay";
    }
    @RequestMapping("/payBybalance")
    public  String payBybalance(){
        //Double balance =payService.getbalance();
        return "pay";
    }
}
