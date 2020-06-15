package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Address;
import com.demo.springboot.helloworld.common.domain.AddressExample;
import com.demo.springboot.helloworld.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    @Override
    public List<Address> MyAddress() {
        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andUserIdEqualTo((long) 1);
        List<Address> myaddress = addressMapper.selectByExample(addressExample);
        return myaddress;
    }

    @Override
    public List<Address> AddAdress(String newAddress) {
        AddressExample addressExample = new AddressExample();
        Address newaddress = new Address();
        newaddress.setUserId((long) 1);
        newaddress.setAddress(newAddress);
        addressMapper.insert(newaddress);
        addressExample.createCriteria().andUserIdEqualTo((long) 1);

        return addressMapper.selectByExample(addressExample);
    }
}
