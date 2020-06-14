package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.common.domain.UserinfoExample;
import com.demo.springboot.helloworld.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserinfoServiceImpl implements UserinfoService{

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public List<Userinfo> find() {
//        userinfoMapper.selectByExample();
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserIdEqualTo(null);

        List<Userinfo> userinfo = userinfoMapper.selectByExample(userinfoExample);
        System.out.println("service已经被调用");
        return null;
    }
}
