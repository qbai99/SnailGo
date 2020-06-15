package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Userinfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserinfoService {

    List<Userinfo> find();

    boolean changepassword(String oldPassword,String newPassword);
}
