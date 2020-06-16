package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Login;
import com.demo.springboot.helloworld.common.domain.SignUp;
import com.demo.springboot.helloworld.service.SignUpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class SignUpController {
    @Resource
    private SignUpService signUpService;
    @RequestMapping("/signUpPage")
    public String signUpPage(){
        return "signUp/signUpPage";
    }
    static  Long i=new Long(0);
    @RequestMapping("/signUp")
    public String signUp(SignUp signup, Model model)
    {
        if(signup.getUserPassword()=="")
        {
            model.addAttribute("errorMsg","密码不能为空");
            return "signUp/signUpPage";
        }
        if(signup.getUserName()=="")
        {
            model.addAttribute("errorMsg","昵称不能为空");
            return "signUp/signUpPage";
        }
            signup.setUserId(this.i);
            signup.setSignUpId((this.i++));
                if(signUpService.signUp(signup)){
                    return "login/loginPage";
                }
        model.addAttribute("errorMsg","邮箱已被注册");
                return "signUp/signUpPage";
    }

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
        SignUp SignUpInDB = signUpService.login(login);
        if (SignUpInDB == null) {
            System.out.println("用户名不存在");
            model.addAttribute("errorMsg","用户名不存在");

        } else {
            String passwordInDB=SignUpInDB.getUserPassword();
            if (passwordInDB.equals(login.getUserPassword())){
                System.out.println("登陆成功");
                return "goods";
            }
            else
            {
                System.out.println("登陆失败");
                model.addAttribute("errorMsg","密码错误");
            }
        }
        return "login/loginPage";
    }
}
