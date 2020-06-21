package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Address;
import com.demo.springboot.helloworld.common.domain.AddressExample;
import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.common.domain.UserinfoWithBLOBs;
import com.demo.springboot.helloworld.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    UserinfoService userinfoService;
    @Override
    public List<Address> MyAddress(String userAdmin) {
        AddressExample addressExample = new AddressExample();
        List<UserinfoWithBLOBs> userinfoList = userinfoService.findWithAdmin(userAdmin);
        addressExample.createCriteria().andUserIdEqualTo(userinfoList.get(0).getUserId());
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

    @Override
    public int delete(String addressId) {
        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andAddressIdEqualTo(Long.parseLong(addressId));
        int result = addressMapper.deleteByExample(addressExample);
        return result;
    }
}
