package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Userfinance;
import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.common.domain.Userlevel;
import com.demo.springboot.helloworld.service.UserfinanceService;
import com.demo.springboot.helloworld.service.UserinfoService;
import com.demo.springboot.helloworld.service.UserlevelService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/information")
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

    @RequestMapping("/changepassword")
    public String password(){
        return "/user/ChangePassword";
    }
}
