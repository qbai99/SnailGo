package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Userfinance;
import com.demo.springboot.helloworld.service.UserfinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/balance")
public class UserfinanceController {

    @Autowired
    UserfinanceService userfinanceService;

    @RequestMapping("/balancepage")
    public String balancepage(){
        return "/user/BalanceRecharge";
    }

    @RequestMapping("/check")
    @ResponseBody
    public List<Userfinance> check(@CookieValue("username") String userAdmin){
        List<Userfinance> userfinances = userfinanceService.check(userAdmin);
        return userfinances;
    }

    @RequestMapping("/postcharge")
    @ResponseBody
    public Userfinance charge(@CookieValue("username") String userAdmin,String input){
        double price = Double.valueOf(input);
        Userfinance userfinances = userfinanceService.charge(userAdmin,price);
        return userfinances;
    }
}
