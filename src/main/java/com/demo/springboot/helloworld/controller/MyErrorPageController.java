package com.demo.springboot.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MyErrorPageController {

    @RequestMapping("error-404")
    public String toPage404(){
        return "error";
    }
    @RequestMapping("error-400")
    public String toPage400(){
        return "error";
    }
    @RequestMapping("error-500")
    public String toPage500(){
        return "error";
    }

}

