package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.service.BrowsingRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Records")
public class BrowsingRecordsController {

    @Autowired
    BrowsingRecordsService browsingRecordsService;

    @RequestMapping("/addrecords")
    @ResponseBody
    public String Addrecords(String userAdmin,String URL,String goodsId){
        Boolean result = browsingRecordsService.Addrecords(userAdmin,URL,goodsId);
        return "添加成功";
    }
}
