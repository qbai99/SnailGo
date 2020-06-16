package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Userfinance;
import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.common.domain.Userlevel;
import com.demo.springboot.helloworld.service.UserfinanceService;
import com.demo.springboot.helloworld.service.UserinfoService;
import com.demo.springboot.helloworld.service.UserlevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;

    @Autowired
    private UserfinanceService userfinanceService;

    @Autowired
    private UserlevelService userlevelService;


    @RequestMapping("/MyInformation")
    public String List(){
        return "/user/userInfomation";
    }

    @RequestMapping(value = "/information",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> info(){
        List<Userinfo> user = userinfoService.find();
        List<Userfinance> userfinance = userfinanceService.balance();
        List<Userlevel> userlevel = userlevelService.level();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("UserInfo",user);
        map.put("UserFinance",userfinance);
        map.put("UserLevel",userlevel);
        return map;
    }

    @RequestMapping("/updateInfo")
    @ResponseBody
    public Userinfo updateinfo(String email,String username,String sex,String birthdate,String phonenumber,String introduction){
        Userinfo result = userinfoService.updateInfo(email,username,sex,birthdate,phonenumber,introduction);
        return result;
    }
    @RequestMapping("/changepassword")
    public String password(){
        return "/user/ChangePassword";
    }

    @RequestMapping("/AdressManage")
    public String adress(){
        return "/user/AddressManage";
    }
    @RequestMapping("/changeCommit")
    @ResponseBody
    public String ChangePassword(String oldPassword,String newPassword) {
        System.out.println(oldPassword);
        System.out.println(newPassword);
        boolean result = userinfoService.changepassword(oldPassword,newPassword);
        System.out.println("结果"+result);
        if(result==false){
            return "密码错误！";
        }
        else {
            return "修改成功！";
        }
    }
}
