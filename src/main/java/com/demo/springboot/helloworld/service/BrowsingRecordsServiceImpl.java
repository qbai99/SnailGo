package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.BrowsingRecords;
import com.demo.springboot.helloworld.common.domain.BrowsingRecordsExample;
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

        //搜索用户id
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(userAdmin);
        List<Userinfo> userinfoList = userinfoMapper.selectByExample(userinfoExample);
        Long userId = userinfoList.get(0).getUserId();

        BrowsingRecords browsingRecords = new BrowsingRecords();
        browsingRecords.setUserId(userId);
        browsingRecords.setRecords(goodsId);
        int result = browsingRecordsMapper.insert(browsingRecords);
        if(result==1)return true;
        else return false;
    }

    @Override
    public List<BrowsingRecords> check(String userAdmin) {
        //搜索用户id
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(userAdmin);
        List<Userinfo> userinfoList = userinfoMapper.selectByExample(userinfoExample);
        Long userId = userinfoList.get(0).getUserId();

        BrowsingRecordsExample browsingRecordsExample = new BrowsingRecordsExample();
        browsingRecordsExample.createCriteria().andUserIdEqualTo(userId);

        List<BrowsingRecords> browsingRecordsList = browsingRecordsMapper.selectByExample(browsingRecordsExample);

        return browsingRecordsList;
    }
}
