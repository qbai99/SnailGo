package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Login;
import com.demo.springboot.helloworld.common.domain.SignUp;
import org.springframework.ui.Model;

public interface SignUpService {
    public boolean signUp(SignUp signUp);
    public SignUp login(Login login);
    public SignUp returnSignUp(SignUp signUp);
    public SignUp updateUserId(SignUp signUp) ;
}
