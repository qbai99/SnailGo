package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Userfinance;
import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.common.domain.UserinfoWithBLOBs;
import com.demo.springboot.helloworld.common.domain.Userlevel;
import com.demo.springboot.helloworld.service.UserfinanceService;
import com.demo.springboot.helloworld.service.UserinfoService;
import com.demo.springboot.helloworld.service.UserlevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
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

    @RequestMapping("/MyProfile")
    public String profile(){
        return "/user/UserProfile";
    }

    @RequestMapping(value = "/information",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> info(String userEmail){
        System.out.println(userEmail);
        List<UserinfoWithBLOBs> user = userinfoService.findWithAdmin(userEmail);
        System.out.println(user.get(0).toString());
        List<Userfinance> userfinance = userfinanceService.balance();
        List<Userlevel> userlevel = userlevelService.level();
        Map<String,Object> map = new HashMap<String,Object>();
//        Cookie[] cookies=request.getCookies();
//        String userAdmin="";
//        if(cookies!=null&&cookies.length>0)
//        {
//            for (int i=0;i<cookies.length;i++)
//            {
//
//            }
//        }
        map.put("UserInfo",user);
        map.put("UserFinance",userfinance);
        map.put("UserLevel",userlevel);

        return map;
    }

    @RequestMapping("/updateInfo")
    @ResponseBody
    public Userinfo updateinfo(String email, String newAdmin,String username, String sex, String birthdate, String phonenumber, String introduction,String file){
        System.out.println(file);
        Userinfo result = userinfoService.updateInfo(email,newAdmin,username,sex,birthdate,phonenumber,introduction,file);
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
    public String ChangePassword(String oldPassword,String newPassword,String userAdmin) {
        System.out.println(oldPassword);
        System.out.println(newPassword);
        boolean result = userinfoService.changepassword(oldPassword,newPassword,userAdmin);
        System.out.println("结果"+result);
        if(result==false){
            return "密码错误！";
        }
        else {
            return "修改成功！";
        }
    }


}
