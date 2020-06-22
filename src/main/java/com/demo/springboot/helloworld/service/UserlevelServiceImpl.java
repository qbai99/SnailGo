package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.common.domain.UserinfoExample;
import com.demo.springboot.helloworld.common.domain.Userlevel;
import com.demo.springboot.helloworld.common.domain.UserlevelExample;
import com.demo.springboot.helloworld.mapper.UserinfoMapper;
import com.demo.springboot.helloworld.mapper.UserlevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserlevelServiceImpl implements UserlevelService {

    @Autowired
    UserlevelMapper userlevelMapper;

    @Autowired
    UserinfoMapper userinfoMapper;
    @Override
    public List<Userlevel> level(String userEmail) {
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(userEmail);
        List<Userinfo> userinfos = userinfoMapper.selectByExample(userinfoExample);
        Long userId = userinfos.get(0).getUserId();
        UserlevelExample userlevelExample = new UserlevelExample();
        userlevelExample.createCriteria().andUserIdEqualTo(userId);
        List<Userlevel> userlevel = userlevelMapper.selectByExample(userlevelExample);
        return userlevel;
    }

}
