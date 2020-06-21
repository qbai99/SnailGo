package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/cart")
    public String cart(){
        return "cart";
    }

    @RequestMapping("/cartlist")
    @ResponseBody
    public List<Cart> cartList(){
        List<Cart> list0=cartService.selectallnr();
        List<Cart> list1=cartService.selectall();

        for (int i=0;i<list0.size();i++){
            for (int j=0;j<list1.size();j++){
                if (list1.get(j).getGoodsId()==list0.get(i).getGoodsId()){
                    list0.get(i).setGoodsRemaning(list1.get(j).getGoodsRemaning());
                }
            }
        }
        /*for(int i=0;i<list0.size();i++){
            if(list0.get(i).getGoodsRemaning()==null){
                list1.add(list0.get(i));
            }
        }*/
        /*for (int i=0;i<list0.size();i++){
            System.out.println(list0.get(i).toString());
        }*/
        /*System.out.println();
        for (int i=0;i<list1.size();i++){
            System.out.println(list1.get(i).toString());
        }*/
        return list0;
    }
    @RequestMapping("/cartdel")
    public String cartdel(int id){
        cartService.del(id);
        return "cart";
    }
}
