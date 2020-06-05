package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Category;
import com.demo.springboot.helloworld.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Category> list(){
        //得到list请求---查询所有类别
        //去调用service
        List<Category> list = categoryService.list();
        return list;
    }
    @RequestMapping("/selectById")
    @ResponseBody
    public Category selectById(Category cate){
        //单表操作，没必要自己去写sql，因为mybatis自己写好了
        Category category = categoryService.selectById(cate);
        return category;
        // 解决字段不一致冲突
        // 连接查询
        // 动态sql
        // 分页器
    }
    @RequestMapping("/deleteByIds")
    @ResponseBody
    public void deleteByIds(){
       List<String> list = new ArrayList<>();
       list.add("c00001");
       list.add("c000");
       list.add("c0001");
       //postman
       categoryService.deleteByIds(list);
    }
    /*根据id查类别，同时查询这类别的商品*/
    @RequestMapping("/selectByIdCopy")
    @ResponseBody
    public Category selectByIdCopy(){
       String cid = "c001";
       return categoryService.selectByIdCopy(cid);
    }
}
