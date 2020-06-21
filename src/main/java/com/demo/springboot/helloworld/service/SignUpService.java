package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Login;
import com.demo.springboot.helloworld.common.domain.SignUp;
import com.demo.springboot.helloworld.common.domain.Userinfo;

public interface SignUpService {
    public boolean signUp(SignUp signUp);
    public SignUp login(Login login);
    public SignUp returnSignUp(SignUp signUp);
    public SignUp updateUserId(Userinfo userinfo) ;
}
