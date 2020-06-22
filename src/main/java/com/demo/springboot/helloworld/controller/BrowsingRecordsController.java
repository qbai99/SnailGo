package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.BrowsingRecords;
import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.service.BrowsingRecordsService;
import com.demo.springboot.helloworld.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Records")
public class BrowsingRecordsController {

    @Autowired
    BrowsingRecordsService browsingRecordsService;

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/addrecords")
    @ResponseBody
    public String Addrecords(String userAdmin,String URL,String goodsId){
        Boolean result = browsingRecordsService.Addrecords(userAdmin,URL,goodsId);
        if (result==true) return "添加成功";
        else return "添加失败！";
    }

    @RequestMapping("/getrecords")
    @ResponseBody
    public List<BrowsingRecords> check(String userAdmin){
        List<BrowsingRecords> browsingRecordsList = browsingRecordsService.check(userAdmin);
        if(browsingRecordsList.size()!=0){
            List<Goods> goodsList = goodsService.goodsdetails(Long.parseLong(browsingRecordsList.get(0).getRecords()));
            for(int i = 0;i<browsingRecordsList.size();i++){

            }
        }

        return browsingRecordsList;
    }
}
