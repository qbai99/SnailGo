package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.common.domain.UserinfoExample;
import com.demo.springboot.helloworld.mapper.BrowsingRecordsMapper;
import com.demo.springboot.helloworld.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrowsingRecordsServiceImpl implements BrowsingRecordsService {

    @Autowired
    BrowsingRecordsMapper browsingRecordsMapper;

    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public Boolean Addrecords(String userAdmin, String url, String goodsId) {

        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(userAdmin);
        List<Userinfo> userinfoList = userinfoMapper.selectByExample(userinfoExample);
        Long userId = userinfoList.get(0).getUserId();



        return null;
    }
}
