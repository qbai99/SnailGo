package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.SignUp;
import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.common.domain.UserinfoExample;
import com.demo.springboot.helloworld.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class UserinfoServiceImpl implements UserinfoService{

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private SignUpService signUpService;

    @Override
    public Userinfo updateInfo(String email, String newAdmin,String username, String sex, String birthdate, String phonenumber, String introduction) {
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(email);
        Userinfo result = userinfoMapper.selectByExampleWithBLOBs(userinfoExample).get(0);
        System.out.println("旧数据"+result.toString());
//        System.out.println(file);
        result.setUserAdmin(newAdmin);
        result.setUserId(result.getUserId());
        result.setUserName(username);
        result.setUsersex(Integer.parseInt(sex));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse(birthdate);
        result.setUserBirthdate(java.sql.Date.valueOf(birthdate));
        result.setUserPhonenumber(phonenumber);
        result.setUserIntroduction(introduction);
//        result.setUserImg(file);
        System.out.println("新数据"+result.toString());
        int res = userinfoMapper.updateByPrimaryKeyWithBLOBs(result);

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
    public List<Userinfo> findWithAdmin(String userAdmin) {
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(userAdmin);
        List<Userinfo> userinfo = userinfoMapper.selectByExampleWithBLOBs(userinfoExample);
        System.out.println(userinfo.toString());
        return userinfo;
    }

    @Override
    public boolean changepassword(String oldPassword,String newPassword,String userAdmin) {
       UserinfoExample userinfoExample = new UserinfoExample();
       userinfoExample.createCriteria().andUserAdminEqualTo(userAdmin);
        Userinfo newuser = userinfoMapper.selectByExampleWithBLOBs(userinfoExample).get(0);
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

    @Override
    public boolean addUser(SignUp signUp) {

        Userinfo userinfo = new Userinfo();
        userinfo.setMessageId(null);
        userinfo.setLoginId(null);
        userinfo.setFinanceId(null);
        userinfo.setUseLevelId(null);
        userinfo.setShopId(null);
        userinfo.setSignUpId(signUp.getSignUpId());
        userinfo.setUserAdmin(signUp.getEmailAddress());
        userinfo.setUserPassword(signUp.getUserPassword());
        userinfo.setUserName(signUp.getUserName());
        userinfo.setUserTag(signUp.getIdentity());
        userinfo.setUsersex(signUp.getSex());
        userinfo.setUserIntroduction(null);
        userinfo.setUserPhonenumber(null);
        userinfo.setUserBirthdate(null);
        userinfo.setFinanceId(null);

        int result = userinfoMapper.insert(userinfo);
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(signUp.getEmailAddress());
        List<Userinfo> userinfoList = userinfoMapper.selectByExampleWithBLOBs(userinfoExample);

        SignUp sign = signUpService.updateUserId(userinfoList.get(0));

        if(result==1){
            return true;
        }
        if(result==0)
        {
            return false;
        }
        else{
            return false;
        }
    }
}
