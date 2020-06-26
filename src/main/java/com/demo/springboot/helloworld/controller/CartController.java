package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.service.CartService;
import com.demo.springboot.helloworld.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/cart")
    public String cart(){
        return "cart";
    }

    @RequestMapping("/cartlist")
    @ResponseBody
    public List<Cart> cartList(@CookieValue("username") String username){
        /*Cookie[] cookies = req.getCookies();
        System.out.println(cookies);*/
        System.out.println(username);
        Long userid = userinfoService.selectid(username);
        System.out.println(userid);
        List<Cart> list0=cartService.selectallnr(userid);
        List<Cart> list1=cartService.selectall(userid);

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
    @RequestMapping("/dellist")
    public String dellist(Integer list[]){
        for(int i=0;i<list.length;i++){
            cartService.del(list[i]);
        }
        return "cart";
    }
}
