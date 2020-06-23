package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.BrowsingRecords;
import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.service.BrowsingRecordsService;
import com.demo.springboot.helloworld.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Records")
public class BrowsingRecordsController {

    @Autowired
    BrowsingRecordsService browsingRecordsService;

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/addrecords")
    @ResponseBody
    public String Addrecords(@CookieValue("username") String userAdmin,String URL,String goodsId){
        Boolean result = browsingRecordsService.Addrecords(userAdmin,URL,goodsId);
        if (result==true) return "添加成功";
        else return "添加失败！";
    }

    @RequestMapping("/getrecords")
    @ResponseBody
    public Map<String,Object> check(@CookieValue("username") String userAdmin){
        List<BrowsingRecords> browsingRecordsList = browsingRecordsService.check(userAdmin);
        Map<String,Object> map = new HashMap<>();
        if(browsingRecordsList.size()!=0){
            List<Goods> goodsList = goodsService.goodsdetails(Long.parseLong(browsingRecordsList.get(0).getRecords()));
            for(int i = 1;i<browsingRecordsList.size();i++){
                goodsList.addAll(goodsService.goodsdetails(Long.parseLong(browsingRecordsList.get(i).getRecords())));
            }
            map.put("BrowsingRecords",browsingRecordsList);
            map.put("GoodsInfo",goodsList);
        }
        else{
            List<Goods> goodsList = null;
            map.put("BrowsingRecords",browsingRecordsList);
            map.put("GoodsInfo",goodsList);
        }

        return map;
    }

    @RequestMapping("/deleterecords")
    public String DeleteRecords(String recordsId,@CookieValue("username") String userAdmin){
        boolean result = browsingRecordsService.delete(recordsId,userAdmin);
        return "/user/ViewHistory";
    }
    @RequestMapping("/deleteall")
    public String DeleteAll(@CookieValue("username") String userAdmin){
        boolean result = browsingRecordsService.deleteall(userAdmin);
        return "/user/ViewHistory";
    }
}
