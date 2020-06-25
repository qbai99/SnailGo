package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.common.domain.Comment;
import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.service.CommentService;
import com.demo.springboot.helloworld.service.GoodsService;
import com.demo.springboot.helloworld.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class   GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/search")

    public String search(String search_key, Model model,String goods_tag) {


        List<Goods> tmp = goodsService.search(search_key,goods_tag);
        List<Goods> tmp1= goodsService.search("",goods_tag);

        System.out.println(tmp.size());
        System.out.println(tmp);
        if (tmp.size() != 0) {//返回不为空。搜索成功
            System.out.println("返回成功");
            /*将搜索结果集合、集合元素个数(结果商品个数)、搜索关键字添加到model的属性中返回前端页面*/
            model.addAttribute("search_result", tmp);//搜索结果商品list
            model.addAttribute("result_num", tmp.size());//搜索结果商品数
            model.addAttribute("search_key", search_key);//搜索关键词
            model.addAttribute("tag", goods_tag);//tag

            return "search";//跳转到搜索页search.html
        } else {//搜索失败
            System.out.println("返回成功");
            model.addAttribute("error_search_fail", "没有相关商品");

            model.addAttribute("tag", goods_tag);//tag
            model.addAttribute("relatedgoods",tmp1);
            return "searcherror";
        }



    }


    @Autowired
    private CommentService commentService;
    @RequestMapping("/details")
    public String details(long id,Model model)
    {
        List<Goods> tmp = goodsService.goodsdetails(id);
        List<Comment> tmp2= commentService.allcomment(id);
        if (tmp.size() != 0) {//返回不为空。搜索成功
            /*将搜索结果集合、集合元素个数(结果商品个数)、搜索关键字添加到model的属性中返回前端页面*/
            model.addAttribute("goodsdetails", tmp);//搜索结果商品list
            model.addAttribute("comments",tmp2);
            model.addAttribute("commentnumber",tmp2.size());
            return "product_details";
        } else {//搜索失败
            model.addAttribute("error_search_fail", "没有相关商品");
            return "goods/goodsnotfound";
        }

    }
    @RequestMapping("/newdetail")
        public String newdetail(){
            return "product_details";
        }
    @Autowired
    private UserinfoService userinfoService;
    @RequestMapping("/addgoodstocart")

    public String addgoodstocart(@CookieValue("username") String email,HttpServletRequest request, long goodsId, double price, int quantity, Model model, String goodsname){

        long userId=userinfoService.findWithAdmin(email).get(0).getUserId();
        List<Cart> tmp1 =goodsService.addgoodstocart(userId,goodsId,price,quantity,goodsname);
        List<Goods> tmp2 = goodsService.goodsdetails(goodsId);
        model.addAttribute("goodsdetails", tmp2);//搜索结果商品list

        return"product_details";
    }

    @RequestMapping("/addgoodstocartlist")
    public String addgoodstocartlist(@CookieValue("username") String email,HttpServletRequest request, long goodsId, double price, int quantity, Model model, String goodsname,String search_key,String goods_tag){
        long userId=userinfoService.findWithAdmin(email).get(0).getUserId();
        if(userinfoService.findWithAdmin(email).size()==0){
            return "error";
        }
        List<Cart> tmp1 =goodsService.addgoodstocart(userId,goodsId,price,quantity,goodsname);
        List<Goods> tmp2 = goodsService.search(search_key,goods_tag);

            /*将搜索结果集合、集合元素个数(结果商品个数)、搜索关键字添加到model的属性中返回前端页面*/
            model.addAttribute("search_result", tmp2);//搜索结果商品list
            model.addAttribute("result_num", tmp2.size());//搜索结果商品数
            model.addAttribute("search_key", search_key);//搜索关键词
            model.addAttribute("tag", goods_tag);//tag

            return "search";//跳转到搜索页search.html

    }
}
