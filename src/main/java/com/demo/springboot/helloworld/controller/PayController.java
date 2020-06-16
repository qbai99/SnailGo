package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Userfinance;
import com.demo.springboot.helloworld.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class PayController {
    @Autowired
    private PayService payService;

    @RequestMapping("/pay")
    public  String pay(){
        return "pay";
    }

    @RequestMapping("/payBybalance")
    @ResponseBody
    public List<Userfinance> payBybalance(){
        List<Userfinance> list =payService.selectall();
        return list;
    }
    @RequestMapping("/balancePay")
    public String balancePay(int total){
        int t;
        t=total;
        System.out.println(total);
        payService.balancePay(t);
        return "pay";
    }
    @RequestMapping("/meetpay")
    public String meetpay(){
        return "pay";
    }
}
