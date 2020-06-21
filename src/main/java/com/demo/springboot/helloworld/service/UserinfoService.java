package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.SignUp;
import com.demo.springboot.helloworld.common.domain.Userinfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserinfoService {

    Userinfo updateInfo(String email, String newAdmin,String username, String sex, String birthdate, String phonenumber, String introduction);

    List<Userinfo> find(Long userId);

    List<Userinfo> findWithAdmin(String userAdmin);

    boolean changepassword(String oldPassword,String newPassword,String userAdmin);

    boolean addUser(SignUp signUp);
}
