package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.common.domain.UserinfoExample;
import com.demo.springboot.helloworld.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
@Service
public class UserinfoServiceImpl implements UserinfoService{

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public Userinfo updateInfo(String email, String username, String sex, String birthdate, String phonenumber, String introduction) {
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserIdEqualTo((long) 1);
        Userinfo result = userinfoMapper.selectByPrimaryKey((long) 1);
        System.out.println("旧数据"+result.toString());
        result.setUserAdmin(email);
        result.setUserId((long) 1);
        result.setUserName(username);
        result.setUsersex(Integer.parseInt(sex));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse(birthdate);
        result.setUserBirthdate(Date.valueOf(birthdate));
        result.setUserPhonenumber(phonenumber);
        result.setUserIntroductoin(introduction);
        System.out.println("新数据"+result.toString());
        int res = userinfoMapper.updateByPrimaryKeyWithBLOBs(result);
        System.out.println(userinfoMapper.selectByPrimaryKey((long) 1).toString());

        return result;
    }

    @Override
    public List<Userinfo> find(Long userId) {
//        userinfoMapper.selectByExample();
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserIdEqualTo(userId);

        List<Userinfo> userinfo = userinfoMapper.selectByExampleWithBLOBs(userinfoExample);
        System.out.println(userinfo.toString());
        return userinfo;
    }

    @Override
    public boolean changepassword(String oldPassword,String newPassword) {
        Userinfo newuser = (Userinfo) userinfoMapper.selectByPrimaryKey((long) 1);
        System.out.println("正确密码"+newuser.getUserPassword());
        System.out.println("当前输入密码"+oldPassword);
        if(newuser.getUserPassword().equals(oldPassword)){
            newuser.setUserPassword(newPassword);
            int userinfo = userinfoMapper.updateByPrimaryKey(newuser);
            System.out.println("密码正确");
            return true;
        }
        else{
            System.out.println("密码错误");
            return false;
        }
    }
}
