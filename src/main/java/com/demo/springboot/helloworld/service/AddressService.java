package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    List<Address> MyAddress(String userAdmin);

    List<Address> AddAdress(String newAddress,String userAdmin);

    int delete(String addressId,String userAdmin);

    List<Address> getaddress(Long userid);

    List<Address> selectAddress(Long addressId);
}
