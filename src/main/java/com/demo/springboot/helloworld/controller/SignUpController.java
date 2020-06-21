package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Login;
import com.demo.springboot.helloworld.common.domain.SignUp;
import com.demo.springboot.helloworld.service.SignUpService;
import com.demo.springboot.helloworld.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @Autowired
  private UserinfoService userinfoService;

    @RequestMapping("/signUpPage")
    public String signUpPage(){
        return "signUp/signUpPage";
    }
    @RequestMapping("/signUp")
    public String signUp(SignUp signup, Model model)
    {
        if(signup.getEmailAddress().equals(""))
        {
            model.addAttribute("errorMsg","邮箱不能为空");
            return "signUp/signUpPage";
        }
        if(signup.getUserPassword().equals(""))
        {
            model.addAttribute("errorMsg","密码不能为空");
            return "signUp/signUpPage";
        }
        if(signup.getUserName().equals(""))
        {
            model.addAttribute("errorMsg","昵称不能为空");
            return "signUp/signUpPage";
        }
        if(signUpService.signUp(signup)){
            model.addAttribute("userAdminForUser",signup.getEmailAddress());
            SignUp signUpInDB=signUpService.returnSignUp(signup);
            userinfoService.addUser(signUpInDB);
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
    public String login(Login login, Model model, HttpServletResponse response) {
        SignUp SignUpInDB = signUpService.login(login);
        if (SignUpInDB == null) {
            System.out.println("用户名不存在");
            model.addAttribute("errorMsg","用户名不存在");

        } else {
            String passwordInDB=SignUpInDB.getUserPassword();
            if (passwordInDB.equals(login.getUserPassword())){
                System.out.println("登陆成功");
                Cookie cookie=new Cookie("username",login.getUserAdmin());
                cookie.setMaxAge(60*5);
                //将cookie发给浏览器（如果没有这句，cookie就不会发送给客户端）
                cookie.setSecure(true);
                response.addCookie(cookie);
                return "/goods";
//                return "login/loginPage";
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
