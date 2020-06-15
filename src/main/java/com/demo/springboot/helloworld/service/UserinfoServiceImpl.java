package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.common.domain.UserinfoExample;
import com.demo.springboot.helloworld.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserinfoServiceImpl implements UserinfoService{

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public List<Userinfo> find() {
//        userinfoMapper.selectByExample();
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo("admin");

        List<Userinfo> userinfo = userinfoMapper.selectByExample(userinfoExample);
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
