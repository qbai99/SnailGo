package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Order;
import com.demo.springboot.helloworld.common.domain.ShippingState;
import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.service.OrderService;
import com.demo.springboot.helloworld.service.ShippingStateService;
import com.demo.springboot.helloworld.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    UserinfoService userinfoService;

    @Autowired
    ShippingStateService shippingStateService;

    @RequestMapping("/user/OrderHistory")
    public String OrderPage(){
        return "/user/CheckOrder";
    }

    @RequestMapping("/order/check")
    @ResponseBody
    public Map<String,Object> CheckOrder(){
        List<Order> orderList = orderService.check();
        System.out.println(orderList.get(0).getUserId());
        List<Userinfo> buyerList = userinfoService.find(orderList.get(0).getUserId());
        List<Userinfo> sellerList = userinfoService.find(orderList.get(0).getSellerId());
        List<ShippingState> shippingStateList = shippingStateService.find(orderList.get(0).getOrderId());
        for(int i=1;i<orderList.size();i++){
            List<Userinfo> tempbuyerList = userinfoService.find(orderList.get(i).getUserId());
            List<Userinfo> tempsellerList = userinfoService.find(orderList.get(i).getSellerId());
            List<ShippingState> tempshippingStateList = shippingStateService.find(orderList.get(i).getOrderId());
            buyerList.addAll(tempbuyerList);
            sellerList.addAll(tempsellerList);
            shippingStateList.addAll(tempshippingStateList);
        }
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("Order",orderList);
        result.put("Buyer",buyerList);
        result.put("Seller",sellerList);
        result.put("ShippingState",shippingStateList);

        return result;
    }
}
