package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.SignUp;
import com.demo.springboot.helloworld.common.domain.UserinfoWithBLOBs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserinfoService {

    UserinfoWithBLOBs updateInfo(String email, String newAdmin,String username, String sex, String birthdate, String phonenumber, String introduction,String file);

    List<UserinfoWithBLOBs> find(Long userId);

    List<UserinfoWithBLOBs> findWithAdmin(String userAdmin);

    boolean changepassword(String oldPassword,String newPassword,String userAdmin);

    boolean addUser(SignUp signUp);
}
