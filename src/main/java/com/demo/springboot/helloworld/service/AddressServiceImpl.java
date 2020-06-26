package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.*;
import com.demo.springboot.helloworld.mapper.AddressMapper;
import com.demo.springboot.helloworld.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    UserinfoService userinfoService;

    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public List<Address> MyAddress(String userAdmin) {
        AddressExample addressExample = new AddressExample();
        List<UserinfoWithBLOBs> userinfoList = userinfoService.findWithAdmin(userAdmin);
        addressExample.createCriteria().andUserIdEqualTo(userinfoList.get(0).getUserId());
        List<Address> myaddress = addressMapper.selectByExample(addressExample);
        return myaddress;
    }

    @Override
    public List<Address> AddAdress(String newAddress,String userAdmin) {
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(userAdmin);
        List<Userinfo> userinfoList = userinfoMapper.selectByExample(userinfoExample);
        Long userId = userinfoList.get(0).getUserId();

        AddressExample addressExample = new AddressExample();
        Address newaddress = new Address();
        newaddress.setUserId(userId);
        newaddress.setAddress(newAddress);
        addressMapper.insert(newaddress);
        addressExample.createCriteria().andUserIdEqualTo(userId);

        return addressMapper.selectByExample(addressExample);
    }

    @Override
    public int delete(String addressId,String userAdmin) {
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(userAdmin);
        List<Userinfo> userinfoList = userinfoMapper.selectByExample(userinfoExample);
        Long userId = userinfoList.get(0).getUserId();

        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andAddressIdEqualTo(Long.parseLong(addressId));
        int result = addressMapper.deleteByExample(addressExample);
        return result;
    }

    @Override
    public List<Address> getaddress(Long userid){
        return addressMapper.selectByuserid(userid);
    }

    @Override
    public List<Address> selectAddress(Long addressId) {
        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andAddressIdEqualTo(addressId);
        List<Address> addressList = addressMapper.selectByExample(addressExample);

        return addressList;
    }
}
