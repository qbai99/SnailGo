package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Address;
import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.common.domain.Userfinance;
import com.demo.springboot.helloworld.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
    @Autowired
    private AddressService addressService;

    private Integer listq[];
    private List<Cart> listlis;

    @RequestMapping("/pay")
    public  String pay(String s){
        return "pay";
    }

    @RequestMapping("/payBybalance")
    @ResponseBody
    public List<Userfinance> payBybalance(@CookieValue("username") String username){
        System.out.println("/payBybalance-----username:"+username);
        Long userid = userinfoService.selectid(username);
        System.out.println("/payBybalance-----userid:"+userid);
        List<Userfinance> list =payService.selectall(userid);
        System.out.println("/payBybalance-----list:"+list);
        return list;
    }
    @RequestMapping("/balancePay")
    public String balancePay(int total,@CookieValue("username") String username){
        Long userid = userinfoService.selectid(username);
        int t;
        t=total;
        System.out.println("total: "+total+"userid: "+userid);
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("userid",userid);
        map.put("num",total);
        payService.balancePay(map);
        for(int i=0;i<listq.length;i++){
            cartService.del(listq[i]);
        }
        return "pay";
    }
    @RequestMapping("/meetpay")
    public String meetpay(){
        return "pay";
    }

    @RequestMapping("/paylist")
    public String paylist(Integer list[],Integer num[],HttpServletResponse response) throws IOException {
        //System.out.println("str:"+arr.toString());
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out =response.getWriter();
        System.out.println(list[0]);
        listq=null;
        listq=list.clone();
        List<Cart> paylist = new ArrayList<Cart>();
        for(int i=0;i<list.length;i++){
            List<Cart> listc= cartService.selectByid(list[i]);
            int remaning = goodsService.selectRem(listc.get(0).getGoodsId());
            System.out.println("/paylist---------remaning: "+remaning);
            if((num[i]<=remaning)&(remaning!=0)) {
                listc.get(0).setGoodsPrice(listc.get(0).getGoodsPrice() * num[i]);
                listc.get(0).setGoodsQuantity(num[i]);
                System.out.println(listc);
                paylist.add(listc.get(0));
            }else{
                out.println("<script> alert('商品:"+listc.get(0).getGoodsName()+" 库存不足！');</script>");
                out.flush();
                System.out.println("/payone---------alert: ");
                return "cart";
            }
        }
        listlis=paylist;
        return "pay";
    }

    @RequestMapping("/paylistjs")
    @ResponseBody
    public List<Cart> paylistjs(){
        System.out.println(listlis);
        return listlis;
    }
    @RequestMapping("/getaddress")
    @ResponseBody
    public List<Address> getaddress(@CookieValue("username")String username){
        Long userid = userinfoService.selectid(username);
        List<Address> list =addressService.getaddress(userid);
        System.out.println("/getaddress---------------list: "+list);
        return list;
    }
}
