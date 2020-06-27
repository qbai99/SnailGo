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
import java.io.UnsupportedEncodingException;
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
    public Map<String,Object> info(@CookieValue("username") String userEmail) throws UnsupportedEncodingException {
        System.out.println(userEmail);
        List<UserinfoWithBLOBs> user = userinfoService.findWithAdmin(userEmail);
        List<Userfinance> userfinance = userfinanceService.check(user.get(0).getUserAdmin());
        List<Userlevel> userlevel = userlevelService.level(userEmail);
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

    @RequestMapping("/emailExist")
    @ResponseBody
    public boolean Exist(String newEmail){
        List<UserinfoWithBLOBs> list = userinfoService.findWithAdmin(newEmail);
        if (list.size()==0) return true;
        else return false;
    }

    @RequestMapping("/updateInfo")
    @ResponseBody
    public Userinfo updateinfo(@CookieValue("username") String email, String newAdmin,String username, String sex, String birthdate, String phonenumber, String introduction,String file){
        System.out.println(email);
        Userinfo result = userinfoService.updateInfo(email,newAdmin,username,sex,birthdate,phonenumber,introduction,file);
        return result;
    }
    @RequestMapping("/changepassword")
    public String password(){
        return "/user/ChangePassword";
    }

    @RequestMapping("/viewhistory")
    public String history(){return "/user/ViewHistory";}

    @RequestMapping("ShopManage")
    public String shopmanage(){return "/user/ShopManage";}

    @RequestMapping("/AdressManage")
    public String adress(){
        return "/user/AddressManage";
    }

    @RequestMapping("/isSeller")
    @ResponseBody
    public boolean IsSeller(@CookieValue("username") String userAdmin){
        Userinfo user = userinfoService.findWithAdmin(userAdmin).get(0);
        return user.getUserTag();
    }
    @RequestMapping("/changeCommit")
    @ResponseBody
    public String ChangePassword(String oldPassword,String newPassword,@CookieValue("username") String userAdmin) {
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
