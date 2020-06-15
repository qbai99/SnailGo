package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Userfinance;
import com.demo.springboot.helloworld.common.domain.UserfinanceExample;
import com.demo.springboot.helloworld.mapper.UserfinanceMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserfinanceServiceImpl implements UserfinanceService {

    @Autowired
    UserfinanceMapper userfinanceMapper;

    @Override
    public List<Userfinance> balance() {
        UserfinanceExample userfinanceExample = new UserfinanceExample();
        userfinanceExample.createCriteria().andUserIdEqualTo((long) 1);
        List<Userfinance> userfinance = userfinanceMapper.selectByExample(userfinanceExample);
        return userfinance;
    }

    @Override
    public List<Userfinance> check() {
        UserfinanceExample userfinanceExample = new UserfinanceExample();
        userfinanceExample.createCriteria().andUserIdEqualTo((long) 1);
        List<Userfinance> userfinances = userfinanceMapper.selectByExample(userfinanceExample);
        return userfinances;
    }

    @Override
    public Userfinance charge(double price) {
        Userfinance finance = new Userfinance();
        finance.setUserId((long) 1);
        finance.setBalance(price);
        Userfinance userfinances = userfinanceMapper.selectByPrimaryKey((long) 1);
        finance.setFinanceId(userfinances.getFinanceId());
        finance.setBalance(finance.getBalance()+userfinances.getBalance());
        int result = userfinanceMapper.updateByPrimaryKey(finance);
        return finance;
    }
}
