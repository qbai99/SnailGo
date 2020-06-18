package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class   GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/search")

    public String search(String search_key, Model model) {


        List<Goods> tmp = goodsService.search(search_key);

        System.out.println("返回成功");
        System.out.println(tmp.size());
        System.out.println(tmp);
        if (tmp.size() != 0) {//返回不为空。搜索成功
            /*将搜索结果集合、集合元素个数(结果商品个数)、搜索关键字添加到model的属性中返回前端页面*/
            model.addAttribute("search_result", tmp);//搜索结果商品list
            model.addAttribute("result_num", tmp.size());//搜索结果商品数
            model.addAttribute("search_key", search_key);//搜索关键词

            return "search";//跳转到搜索页search.html
        } else {//搜索失败
            model.addAttribute("error_search_fail", "没有相关商品");
            return "goods/goodsnotfound";
        }



    }

    @RequestMapping("/details")
    public String details(long id,Model model)
    {
        List<Goods> tmp = goodsService.goodsdetails(id);
        if (tmp.size() != 0) {//返回不为空。搜索成功
            /*将搜索结果集合、集合元素个数(结果商品个数)、搜索关键字添加到model的属性中返回前端页面*/
            model.addAttribute("goodsdetails", tmp);//搜索结果商品list
            return "goods/details";
        } else {//搜索失败
            model.addAttribute("error_search_fail", "没有相关商品");
            return "goods/goodsnotfound";
        }

    }
    @RequestMapping("/cart")
    public String cart(){
        return"cart";
    }
}
