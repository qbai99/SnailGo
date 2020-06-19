package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.*;
import com.demo.springboot.helloworld.mapper.SignUpMapper;
import com.demo.springboot.helloworld.mapper.UserinfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

@Service
public class SignUpServiceImpl implements SignUpService{
    @Resource
    SignUpMapper signUpMapper;
    UserinfoMapper userinfoMapper;
    @Override
    public boolean signUp(SignUp signUp){
        SignUpExample signUpExample=new SignUpExample();
        signUpExample.createCriteria().andEmailAddressEqualTo(signUp.getEmailAddress());

      List<SignUp> signUps=signUpMapper.selectByExample(signUpExample);
      if(signUps.size()==0)
      {
          signUpMapper.insert(signUp);
          signUpExample.createCriteria().andEmailAddressEqualTo(signUp.getEmailAddress());
          List<SignUp> sign = signUpMapper.selectByExample(signUpExample);
          return true;
      }

        return false;
    }
    @Override
    public SignUp returnSignUp(SignUp signUp){
        SignUpExample signUpExample=new SignUpExample();
        signUpExample.createCriteria().andEmailAddressEqualTo(signUp.getEmailAddress());
        List<SignUp> signUps=signUpMapper.selectByExample(signUpExample);
        return signUps.get(0);
    }
@Override
public SignUp updateUserId(Userinfo userinfo) {///////////////更新userid
        SignUpExample signUpExample=new SignUpExample();
        signUpExample.createCriteria().andUserIdIsNull();
        List<SignUp> results = signUpMapper.selectByExample(signUpExample);
        SignUp newSign = results.get(0);
        newSign.setUserId(userinfo.getUserId());
        SignUpExample signUpExample1 = new SignUpExample();
        signUpExample1.createCriteria().andEmailAddressEqualTo(results.get(0).getEmailAddress());
        signUpMapper.updateByExample(newSign,signUpExample1);
        return newSign;
}

    @Override
    public SignUp login(Login login) {
        SignUpExample signUpExample=new SignUpExample();
        signUpExample.createCriteria().andEmailAddressEqualTo(login.getUserAdmin());
        List<SignUp> signUps=signUpMapper.selectByExample(signUpExample);
        return (signUps.size()>0?signUps.get(0):null);

    }
}
