package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.*;
import com.demo.springboot.helloworld.service.AddressService;
import com.demo.springboot.helloworld.service.OrderService;
import com.demo.springboot.helloworld.service.ShippingStateService;
import com.demo.springboot.helloworld.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sound.midi.Soundbank;
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

    @Autowired
    AddressService addressService;

    @RequestMapping("/user/OrderHistory")
    public String OrderPage(){
        //System.out.println(id);
        return "/user/CheckOrder";
    }

    @RequestMapping("/order/check")
    @ResponseBody
    public Map<String,Object> CheckOrder(@CookieValue("username") String userAdmin){
        List<Order> orderList = orderService.check(userAdmin);
        System.out.println(orderList.get(0).getUserId());
        List<UserinfoWithBLOBs> buyerList = userinfoService.find(orderList.get(0).getUserId());
        List<UserinfoWithBLOBs> sellerList = userinfoService.find(orderList.get(0).getSellerId());
        //System.out.println(orderList.get(0).getOrderId());
        List<ShippingState> shippingStateList = shippingStateService.find(orderList.get(0).getOrderId());
        List<Address> addressList = addressService.selectAddress(orderList.get(0).getAddressId());
        System.out.println("shippingstatelist 11:  "+shippingStateList);
        for(int i=1;i<orderList.size();i++){
            List<UserinfoWithBLOBs> tempbuyerList = userinfoService.find(orderList.get(i).getUserId());
            List<UserinfoWithBLOBs> tempsellerList = userinfoService.find(orderList.get(i).getSellerId());
            List<ShippingState> tempshippingStateList = shippingStateService.find(orderList.get(i).getOrderId());
            List<Address> tempaddressList = addressService.selectAddress(orderList.get(i).getAddressId());
            buyerList.addAll(tempbuyerList);
            sellerList.addAll(tempsellerList);
            shippingStateList.addAll(tempshippingStateList);
            addressList.addAll(tempaddressList);
            //System.out.println("shipingstate: "+i+"   "+shippingStateList);
        }
        //System.out.println("shippingstatelistall:  "+shippingStateList);
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("Order",orderList);
        result.put("Buyer",buyerList);
        result.put("Seller",sellerList);
        result.put("ShippingState",shippingStateList);
        result.put("address",addressList);

        return result;
    }
}
