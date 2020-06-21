package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.common.domain.Userfinance;
import com.demo.springboot.helloworld.service.CartService;
import com.demo.springboot.helloworld.service.GoodsService;
import com.demo.springboot.helloworld.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller

public class PayController {
    @Autowired
    private PayService payService;
    @Autowired
    private CartService cartService;
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/pay")
    public  String pay(String s){
        return "pay";
    }

    @RequestMapping("/payBybalance")
    @ResponseBody
    public List<Userfinance> payBybalance(){
        List<Userfinance> list =payService.selectall();
        return list;
    }
    @RequestMapping("/balancePay")
    public String balancePay(int total){
        int t;
        t=total;
        System.out.println(total);
        payService.balancePay(t);
        return "pay";
    }
    @RequestMapping("/meetpay")
    public String meetpay(){
        return "pay";
    }

    @RequestMapping("/payone")
    @ResponseBody
    public ModelAndView payone(int id, int num, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //response.setCharacterEncoding("utf-8");
        ModelAndView mav =new ModelAndView();
        List<Cart> list = cartService.selectByid(id);
        int remaning= goodsService.selectRem(list.get(0).getGoodsId());
        System.out.println(remaning);
        if (num<=remaning) {
            list.get(0).setGoodsPrice(list.get(0).getGoodsPrice() * num);
            list.get(0).setGoodsQuantity(num);
            mav.addObject("pay",list);
            mav.setViewName("pay");
            return mav;
        }else {
            out.print("<script> alert('商品库存不足！');</script>");
            out.flush();
            mav.setViewName("cart");
            return mav;
        }
        //out.print("<script>alert('test');</script>");
    }
}
