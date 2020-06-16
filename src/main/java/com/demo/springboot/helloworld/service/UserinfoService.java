package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Userinfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserinfoService {

    Userinfo updateInfo(String email, String username, String sex, String birthdate, String phonenumber, String introduction);

    List<Userinfo> find();

    boolean changepassword(String oldPassword,String newPassword);
}
