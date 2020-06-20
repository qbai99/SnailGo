package com.demo.springboot.helloworld.controller;

import com.demo.springboot.helloworld.common.domain.Address;
import com.demo.springboot.helloworld.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping("/myaddress")
    @ResponseBody
    public List<Address> MyAddress(String userAdmin){
        List<Address> myaddress = addressService.MyAddress(userAdmin);
        return myaddress;
    }

    @RequestMapping("/addaddress")
    @ResponseBody
    public List<Address> AddAddress(String newAddress){
        List<Address> myaddress = addressService.AddAdress(newAddress);
        return myaddress;
    }

    @RequestMapping("/deleteaddress")
    @ResponseBody
    public int DeleteAddress(String addressId){
        int addressList = addressService.delete(addressId);
        return addressList;
    }
}
