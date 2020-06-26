package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.*;
import com.demo.springboot.helloworld.mapper.CartMapper;
import com.demo.springboot.helloworld.mapper.GoodsImgMapper;
import com.demo.springboot.helloworld.mapper.GoodsMapper;
import com.demo.springboot.helloworld.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsImgMapper goodsImgMapper;

    @Override
    public List<Goods> search(String search_key, String goods_tag) {
        if (search_key.length()==0){
            search_key=null;
        };
//        List<Goods> list=goodsMapper.mysearch(search_key);
        List<Goods> list=goodsMapper.mysearch(search_key,goods_tag);
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
        cart.setUserId(userId);
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

    @Override
    public List<Goods> selectByShopid(Long shopId) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andShopIdEqualTo(shopId);

        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);

        return goodsList;
    }

    @Override
    public boolean deleteById(String goodsId) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andGoodsIdEqualTo(Long.parseLong(goodsId));

        //判断是否在订单表里面
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andGoodsIdEqualTo(Long.parseLong(goodsId));
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        if(orderList.size()==0){
            int result = goodsMapper.deleteByExample(goodsExample);
            if (result==1)return true;
            else return false;
        }
        else return false;
    }

    @Override
    public boolean UpdateInfo(String goodsId, String name, String dsp, String tag, String price, String remain) {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andGoodsIdEqualTo(Long.parseLong(goodsId));
        Goods goods = goodsMapper.selectByExample(goodsExample).get(0);
        goods.setGoodsName(name);
        goods.setGoodsDsp(dsp);
        goods.setGoodsTag(tag);
        goods.setGoodsPrice(Double.valueOf(price));
        goods.setGoodsRemaning(Integer.parseInt(remain));

        int result = goodsMapper.updateByExample(goods,goodsExample);
        if(result == 1)return true;
        else return false;
    }

    @Override
    public boolean AddGoods(String shopId, String goodsName, String goodsIntro, String goodsTag, String goodsPrice, String goodsRemain, String file) {

        Goods goods = new Goods();
        goods.setShopId(Long.parseLong(shopId));
        goods.setGoodsName(goodsName);
        goods.setGoodsDsp(goodsIntro);
        goods.setGoodsTag(goodsTag);
        goods.setGoodsPrice(Double.valueOf(goodsPrice));
        goods.setGoodsRemaning(Integer.parseInt(goodsRemain));

        int result = goodsMapper.insert(goods);
        Long goodsId = goodsMapper.selectCurId();
        System.out.println("新id"+goodsId);

        GoodsImg goodsImg = new GoodsImg();
        goodsImg.setGoodsId(goodsId);
        goodsImg.setGoodsImg(file.getBytes());

        int result2 = goodsImgMapper.insert(goodsImg);

        if (result==1&&result2==1) return true;
        else return false;
    }

    @Override
    public Integer getShopIdBygoodsId(Integer goodsId){
        return goodsMapper.getShopIdBygoodsId(goodsId);
    }

    @Override
    public List<Goods> selectNameAndPri(Integer goodsId){
        return goodsMapper.selectNameAndPri(goodsId);
    }

    @Override
    public void delnum(Integer goodsId, Integer quantity){
        Goods goods=new Goods();
        goods.setGoodsId(Long.valueOf(goodsId));
        goods.setGoodsRemaning(quantity);
        goodsMapper.delnum(goods);
    }
}
