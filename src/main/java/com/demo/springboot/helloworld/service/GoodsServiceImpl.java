package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.common.domain.GoodsExample;
import com.demo.springboot.helloworld.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> search(String name) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andGoodsNameLike(name);
        List<Goods> list=goodsMapper.selectByExample(goodsExample);
        return list;
    }

    @Override
    public List<Goods> searchtest(String search_input) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andGoodsNameLike(search_input);
        List<Goods> list=goodsMapper.selectByExample(goodsExample);
        return list;
    }


}
