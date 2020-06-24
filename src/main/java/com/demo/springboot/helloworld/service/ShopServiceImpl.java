package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Shop;
import com.demo.springboot.helloworld.common.domain.ShopExample;
import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.common.domain.UserinfoExample;
import com.demo.springboot.helloworld.mapper.ShopMapper;
import com.demo.springboot.helloworld.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    UserinfoMapper userinfoMapper;

    @Autowired
    ShopMapper shopMapper;

    @Override
    public Shop information(String userAdmin) {
        //搜索用户id
        UserinfoExample userinfoExample = new UserinfoExample();
        userinfoExample.createCriteria().andUserAdminEqualTo(userAdmin);
        List<Userinfo> userinfoList = userinfoMapper.selectByExample(userinfoExample);
        Long userId = userinfoList.get(0).getUserId();

        ShopExample shopExample = new ShopExample();
        shopExample.createCriteria().andUserIdEqualTo(userId);

        Shop shop = shopMapper.selectByExample(shopExample).get(0);

        return shop;
    }
}
