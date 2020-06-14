package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Login;
import com.demo.springboot.helloworld.common.domain.LoginExample;
import com.demo.springboot.helloworld.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{
    @Resource
    private LoginMapper loginMapper;

    @Override
    public Login login(Login login) {
        LoginExample loginExample=new LoginExample();
        loginExample.createCriteria().andUserAdminEqualTo(login.getUserAdmin());
        List<Login> logins=loginMapper.selectByExample(loginExample);
        return (logins.size()>0?logins.get(0):null);

    }
}
