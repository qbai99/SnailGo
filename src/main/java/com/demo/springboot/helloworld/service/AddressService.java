package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    List<Address> MyAddress();

    List<Address> AddAdress(String newAddress);
}
