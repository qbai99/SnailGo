package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Cart;
import com.demo.springboot.helloworld.common.domain.CartExample;
import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.common.domain.GoodsExample;
import com.demo.springboot.helloworld.mapper.CartMapper;
import com.demo.springboot.helloworld.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> search(String search_key) {

        List<Goods> list=goodsMapper.mysearch(search_key);
        return list;
    }

    @Override
    @ResponseBody
    public List<Goods> goodsdetails(long id) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andGoodsIdEqualTo(id);
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

    @Override
    public List<Goods> allgoods() {
        GoodsExample goodsExample = new GoodsExample();

        List<Goods> list=goodsMapper.selectByExample(goodsExample);
        return list;
    }
    @Autowired
    private CartMapper cartMapper;
    @Override
    public List<Cart> addgoodstocart(long userId, long goodsId, double price, int quantity, String goodsname) {
        Cart cart=new Cart();
        cart.setGoodsId(goodsId);
        cart.setUserId((long) 1);
        cart.setGoodsPrice(price);
        cart.setGoodsQuantity(quantity);
        cart.setGoodsName(goodsname);
        CartExample example = new CartExample();

        cartMapper.insert(cart);
        example.createCriteria().andGoodsIdEqualTo(goodsId);
        return cartMapper.selectByExample(example);

    }
    @Override
    public int selectRem(long goodsId){
        return goodsMapper.selectRem(goodsId);
    }



}
