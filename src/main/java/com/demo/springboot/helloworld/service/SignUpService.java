package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Login;
import com.demo.springboot.helloworld.common.domain.SignUp;

public interface SignUpService {
    public boolean signUp(SignUp signUp);
    public SignUp login(Login login);
}
