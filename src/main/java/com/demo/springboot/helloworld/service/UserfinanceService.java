package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Userfinance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserfinanceService {
    List<Userfinance> balance();

    List<Userfinance> check();

    Userfinance charge(double price);
}
