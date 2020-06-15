package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Userfinance;
import com.demo.springboot.helloworld.common.domain.UserfinanceExample;
import com.demo.springboot.helloworld.mapper.UserfinanceMapper;
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
}
