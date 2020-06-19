package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Userlevel;
import com.demo.springboot.helloworld.common.domain.UserlevelExample;
import com.demo.springboot.helloworld.mapper.UserlevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserlevelServiceImpl implements UserlevelService {

    @Autowired
    UserlevelMapper userlevelMapper;

    @Override
    public List<Userlevel> level() {
        UserlevelExample userlevelExample = new UserlevelExample();
        userlevelExample.createCriteria().andUserIdEqualTo((long) 1);
        List<Userlevel> userlevel = userlevelMapper.selectByExample(userlevelExample);
        return userlevel;
    }

}
