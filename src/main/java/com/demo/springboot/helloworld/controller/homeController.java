package com.demo.springboot.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class homeController {
    @RequestMapping(value = "/")
    public String index() {
        System.out.println("/index");
        return "/goods.html";
    }
}
