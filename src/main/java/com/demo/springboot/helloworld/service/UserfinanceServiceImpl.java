package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Userfinance;
import com.demo.springboot.helloworld.common.domain.UserfinanceExample;
import com.demo.springboot.helloworld.common.domain.UserinfoExample;
import com.demo.springboot.helloworld.mapper.UserfinanceMapper;
import com.demo.springboot.helloworld.mapper.UserinfoMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserfinanceServiceImpl implements UserfinanceService {

    @Autowired
    UserfinanceMapper userfinanceMapper;

    @Autowired
    UserinfoMapper userinfoMapper;
    @Override
    public List<Userfinance> balance() {
        UserfinanceExample userfinanceExample = new UserfinanceExample();
        userfinanceExample.createCriteria().andUserIdEqualTo((long) 1);
        List<Userfinance> userfinance = userfinanceMapper.selectByExample(userfinanceExample);
        return userfinance;
    }

    @Override
    public List<Userfinance> check(String userAdmin) {
        //找用户信息
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(userAdmin);
        Long userId = userinfoMapper.selectByExampleWithBLOBs(userinfoExample).get(0).getUserId();
        //找账户信息
        UserfinanceExample userfinanceExample = new UserfinanceExample();
        userfinanceExample.createCriteria().andUserIdEqualTo(userId);
        List<Userfinance> userfinances = userfinanceMapper.selectByExample(userfinanceExample);
        return userfinances;
    }

    @Override
    public Userfinance charge(String userAdmin,double price) {

        //找用户信息
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(userAdmin);
        Long userId = userinfoMapper.selectByExampleWithBLOBs(userinfoExample).get(0).getUserId();

        Userfinance finance = new Userfinance();
        finance.setUserId(userId);
        finance.setBalance(price);
        Userfinance userfinances = userfinanceMapper.selectByPrimaryKey(userId);
        finance.setFinanceId(userfinances.getFinanceId());
        finance.setBalance(finance.getBalance()+userfinances.getBalance());
        int result = userfinanceMapper.updateByPrimaryKey(finance);
        return finance;
    }
}
