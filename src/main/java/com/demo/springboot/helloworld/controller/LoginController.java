package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Login;
import com.demo.springboot.helloworld.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class LoginController {
    @Resource
    private LoginService loginService;
    @RequestMapping("/loginPage")
    String loginPage(){
        return "login/loginPage";
    }
    @RequestMapping("/login")
    // 接受参数的方式:
//     //直接获取
//    bean 方式获取
//    public String login(@RequestParam("loginName") String name, String password,@RequestParam(name = "age",defaultValue = "0") int age)
    public String login(Login login, Model model) {
        Login loginInDB = loginService.login(login);
        if (loginInDB == null) {
            System.out.println("用户名不存在");

        } else {
            String passwordInDB=loginInDB.getUserPassword();
            if (passwordInDB.equals(login.getUserPassword())){
                System.out.println("登陆成功");
                return "goods";
            }
            else
            System.out.println("登陆失败");
        }
        return "login/loginPage";
    }
}
