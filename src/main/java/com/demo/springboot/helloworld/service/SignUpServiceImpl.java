package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Login;
import com.demo.springboot.helloworld.common.domain.SignUp;
import com.demo.springboot.helloworld.common.domain.SignUpExample;
import com.demo.springboot.helloworld.mapper.SignUpMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SignUpServiceImpl implements SignUpService{
    @Resource
    SignUpMapper signUpMapper;

    @Override
    public boolean signUp(SignUp signUp){

        SignUpExample signUpExample=new SignUpExample();
        signUpExample.createCriteria().andEmailAddressEqualTo(signUp.getEmailAddress());

      List<SignUp> signUps=signUpMapper.selectByExample(signUpExample);
      if(signUps.size()==0)
      {
          signUpMapper.insert(signUp);
          return true;
      }

        return false;
    }
    @Override
    public SignUp login(Login login) {
        SignUpExample signUpExample=new SignUpExample();
        signUpExample.createCriteria().andEmailAddressEqualTo(login.getUserAdmin());
        List<SignUp> signUps=signUpMapper.selectByExample(signUpExample);
        return (signUps.size()>0?signUps.get(0):null);

    }
}
