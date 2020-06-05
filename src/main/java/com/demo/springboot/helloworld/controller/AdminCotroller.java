package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Admin;
import com.demo.springboot.helloworld.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminCotroller {

    @Autowired
    private AdminService adminService;//控制层注入服务层

    //controller  接受页面所有请求，根据请求去调用处理这些请求的服务
    //mapper    数据库操作的集合
    //service   是一个系统的核心，包含了所有的服务， 根据自己的服务的功能去执行相应的元操作（数据库操作）
    //domain


    @RequestMapping("user/login")
    // 接受参数的方式:
//     //直接获取
//    bean 方式获取
//    public String login(@RequestParam("loginName") String name, String password,@RequestParam(name = "age",defaultValue = "0") int age)
    public String login(Admin admin){
        Admin adminInDB = adminService.login(admin);
        if(adminInDB==null){
            System.out.println("用户名不存在");
        }else {
            String passwordInDB = adminInDB.getPassword();
            if(passwordInDB.equals(admin.getPassword())){
                System.out.println("登录成功");
                return "/views/book/book-list.html";
            }else{
                System.out.println("登录失败");
                System.out.println("登录失败");
            }
        }
        return "/test";
    }
}
