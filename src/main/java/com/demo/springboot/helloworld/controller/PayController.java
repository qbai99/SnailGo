package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.common.domain.Userfinance;
import com.demo.springboot.helloworld.service.CartService;
import com.demo.springboot.helloworld.service.GoodsService;
import com.demo.springboot.helloworld.service.PayService;
import com.demo.springboot.helloworld.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
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
    @Autowired
    private UserinfoService userinfoService;

    private List<Cart> listto;

    @RequestMapping("/pay")
    public  String pay(String s){
        return "pay";
    }

    @RequestMapping("/payBybalance")
    @ResponseBody
    public List<Userfinance> payBybalance(@CookieValue("username") String username){
        Long userid = userinfoService.selectid(username);
        List<Userfinance> list =payService.selectall(userid);
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
    public ModelAndView payone(Integer id, Integer num, HttpServletResponse response) throws IOException {
        System.out.println("id: "+id);
        System.out.println("num: "+num);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //response.setCharacterEncoding("utf-8");
        ModelAndView mav =new ModelAndView();
        List<Cart> list = cartService.selectByid(id);
        System.out.println("list: "+list);
        int remaning= goodsService.selectRem(list.get(0).getGoodsId());
        System.out.println(remaning);

        if (num<=remaning) {
            list.get(0).setGoodsPrice(list.get(0).getGoodsPrice() * num);
            list.get(0).setGoodsQuantity(num);
            listto=list;
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
    @RequestMapping("/payonejs")
    @ResponseBody
    public List<Cart> payonejs(){
        return listto;
    }
}
