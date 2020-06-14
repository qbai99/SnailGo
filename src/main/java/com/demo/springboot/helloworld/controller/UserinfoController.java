package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/userInformation")
    public List<Userinfo> List(){

        List<Userinfo> user = userinfoService.find();
        return user;
    }
}
