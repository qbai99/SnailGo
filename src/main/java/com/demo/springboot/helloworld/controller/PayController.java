package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.*;
import com.demo.springboot.helloworld.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShippingStateService shippingStateService;

    private Integer listq[];
    private List<Cart> listlis;
    private Integer listnum[];

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
    public String balancePay(int total,Integer addId,@CookieValue("username") String username){
        Long userid = userinfoService.selectid(username);
        System.out.println("total: "+total+"userid: "+userid);
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("userid",userid);
        map.put("num",total);
        payService.balancePay(map);
        for(int i=0;i<listq.length;i++){
            Integer goodsId=cartService.getGoodsId(listq[i]);
            cartService.del(listq[i]);
            System.out.println("/balancePay-------goodsId: "+goodsId);
            Integer shopId=goodsService.getShopIdBygoodsId(goodsId);
            goodsService.delnum(goodsId,listnum[i]);
            System.out.println("/balancePay-------shopId: "+shopId);
            Long sellerId=shopService.getsellerID(shopId);
            System.out.println("/balancePay-------sellerId: "+sellerId);
            List<Goods> NameAndPrilist= goodsService.selectNameAndPri(goodsId);
            Double price=NameAndPrilist.get(0).getGoodsPrice()*listnum[i];
            Long orderId=orderService.getMaxId()+1;
            System.out.println("/balancePay-------orderId: "+orderId);
            orderService.insertone(orderId,userid,goodsId,userid,sellerId,addId,NameAndPrilist.get(0).getGoodsName(),listnum[i],price);
            Long shipid=shippingStateService.getMaxId()+1;
            Date date= new Date();
            Long times = date.getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(date);
            String loc=shopService.getLoc(shopId);
            String info= "等待配送";
            shippingStateService.insertone(shipid,orderId,date,loc,info);
        }
        return "/user/CheckOrder";
    }
    @RequestMapping("/meetpay")
    public String meetpay(Integer addId,@CookieValue("username") String username){
        Long userid = userinfoService.selectid(username);
        for(int i=0;i<listq.length;i++){
            Integer goodsId=cartService.getGoodsId(listq[i]);
            System.out.println("/balancePay-------goodsId: "+goodsId);
            Integer shopId=goodsService.getShopIdBygoodsId(goodsId);
            goodsService.delnum(goodsId,listnum[i]);
            System.out.println("/balancePay-------shopId: "+shopId);
            Long sellerId=shopService.getsellerID(shopId);
            System.out.println("/balancePay-------sellerId: "+sellerId);
            List<Goods> NameAndPrilist= goodsService.selectNameAndPri(goodsId);
            Double price=NameAndPrilist.get(0).getGoodsPrice()*listnum[i];
            Long orderId=orderService.getMaxId()+1;
            System.out.println("/balancePay-------orderId: "+orderId);
            orderService.insertone(orderId,userid,goodsId,userid,sellerId,addId,NameAndPrilist.get(0).getGoodsName(),listnum[i],price);
            Long shipid=shippingStateService.getMaxId()+1;
            Date date= new Date();
            Long times = date.getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(date);
            String loc=shopService.getLoc(shopId);
            String info= "等待配送";
            shippingStateService.insertone(shipid,orderId,date,loc,info);
        }
        return "/user/CheckOrder";
    }

    @RequestMapping("/paylist")
    public String paylist(Integer list[],Integer num[],HttpServletResponse response) throws IOException {
        //System.out.println("str:"+arr.toString());
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out =response.getWriter();
        System.out.println(list[0]);
        listq=null;
        listq=list.clone();
        listnum=null;
        listnum=num.clone();
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
        System.out.println("/paylist--------paylist: "+paylist);
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

    @RequestMapping("/quickpay")
    public String quickpay(Long goodsId, Integer num){
        List<Cart> paylist = new ArrayList<Cart>();
        Cart cart=new Cart();
        Goods goods=goodsService.selectone(goodsId);
        System.out.println("/quickpay-------goods: "+goods);
        cart.setGoodsId(goodsId);
        cart.setGoodsName(goods.getGoodsName());
        cart.setGoodsQuantity(num);
        cart.setGoodsPrice(goods.getGoodsPrice()*num);
        paylist.add(cart);
        listlis=paylist;
        System.out.println("/quickpay-------paylist: "+paylist);
        return "/pay";
    }

    @RequestMapping("/paywithali")
    public String paywithali(Integer addId,@CookieValue("username") String username){
        Long userid = userinfoService.selectid(username);
        for(int i=0;i<listq.length;i++){
            Integer goodsId = cartService.getGoodsId(listq[i]);
            cartService.del(listq[i]);
            Integer shopId=goodsService.getShopIdBygoodsId(goodsId);
            goodsService.delnum(goodsId,listnum[i]);
            Long sellerId = shopService.getsellerID(shopId);
            List<Goods> NameAndPrilist = goodsService.selectNameAndPri(goodsId);
            Double price = NameAndPrilist.get(0).getGoodsPrice()*listnum[i];
            Long orderId = orderService.getMaxId()+1;
            orderService.insertone(orderId,userid,goodsId,userid,sellerId,addId,NameAndPrilist.get(0).getGoodsName(),listnum[i],price);
            Long shipid = shippingStateService.getMaxId()+1;
            Date date = new Date();
            String loc = shopService.getLoc(shopId);
            String info = "等待配送";
            shippingStateService.insertone(shipid,orderId,date,loc,info);
        }
        return "/user/CheckOrder";
    }


    @RequestMapping("/paynotice")
    @ResponseBody
    public void paynotice(HttpServletResponse response){
        System.out.println(response.toString());
    }
}
