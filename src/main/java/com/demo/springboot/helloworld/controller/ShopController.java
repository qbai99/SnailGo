package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.common.domain.GoodsImg;
import com.demo.springboot.helloworld.common.domain.Shop;
import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.service.GoodsImgService;
import com.demo.springboot.helloworld.service.GoodsService;
import com.demo.springboot.helloworld.service.ShopService;
import com.demo.springboot.helloworld.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    UserinfoService userinfoService;

    @Autowired
    GoodsImgService goodsImgService;

    @RequestMapping("/information")
    @ResponseBody
    public Map<String,Object> information(@CookieValue("username") String userAdmin){
        Shop shop = shopService.information(userAdmin);
        List<Goods> goodsList = goodsService.selectByShopid(shop.getShopId());
        Userinfo userinfo = userinfoService.findWithAdmin(userAdmin).get(0);
        List<GoodsImg> goodsImg = new ArrayList<>();
        for(int i=0;i<goodsList.size();i++){
            goodsImg.addAll(goodsImgService.selectByGoodsId(goodsList.get(i).getGoodsId()));
        }

        Map<String,Object> map = new HashMap<>();
        map.put("shop",shop);
        map.put("goods",goodsList);
        map.put("user",userinfo);
        map.put("img",goodsImg);

        return map;
    }

    @RequestMapping("/change")
    @ResponseBody
    public boolean Change(@CookieValue("username") String userAdmin,String shopId,String name,String mbs,String loc,String dsp)
    {
        boolean result = shopService.Change(userAdmin,shopId,name,mbs,loc,dsp);
        return result;
    }

    @RequestMapping("/deletegoods")
    @ResponseBody
    public ModelAndView DeleteGoods(String goodsId){
        System.out.println(goodsId);
        ModelAndView model = new ModelAndView();
        boolean result = goodsService.deleteById(goodsId);
        model.addObject("result",String.valueOf(result));
        model.setViewName("/user/ShopManage");
//        if (result == true)
        return model;
//        else return "订单";

    }

    @RequestMapping("/changeinfo")
    @ResponseBody
    public ModelAndView ChangeInfo(String goodsId,String name,String dsp,String tag,String price,String remain,String file){
        ModelAndView model = new ModelAndView();
        System.out.println(goodsId);
        System.out.println(name+" "+dsp+" "+tag+" "+price+" "+remain);
        System.out.println(file);
        boolean result = goodsService.UpdateInfo(goodsId,name,dsp,tag,price,remain);
        boolean result1 = goodsImgService.UpdateImg(goodsId,file);
        model.addObject("result",String.valueOf(result));
        model.setViewName("/user/ShopManage");
        return model;
    }
    @RequestMapping("/addgoods")
    @ResponseBody
    public boolean AddGoods(String shopId,String goodsName,String goodsIntro,String goodsTag,String goodsPrice,String goodsRemain,String file)
    {
//        System.out.println(shopId);
//        System.out.println(goodsName);
//        System.out.println(goodsIntro);
//        System.out.println(goodsTag);
//        System.out.println(goodsPrice);
//        System.out.println(goodsRemain);
//        System.out.println(file);
        boolean result = goodsService.AddGoods(shopId,goodsName,goodsIntro,goodsTag,goodsPrice,goodsRemain,file);
        return result;
    }
}
