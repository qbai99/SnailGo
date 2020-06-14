package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.service.UserinfoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/MyInformation")

    public String List(){
        List<Userinfo> user = userinfoService.find();
        return "/user/userInfomation";
    }

    @RequestMapping("/information")
    @ResponseBody
    public List<Userinfo> info(){
        List<Userinfo> user = userinfoService.find();
        return user;
    }
}
