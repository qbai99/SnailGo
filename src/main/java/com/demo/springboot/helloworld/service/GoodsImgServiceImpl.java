package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.GoodsImg;
import com.demo.springboot.helloworld.common.domain.GoodsImgExample;
import com.demo.springboot.helloworld.mapper.GoodsImgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsImgServiceImpl implements GoodsImgService {

    @Autowired
    GoodsImgMapper goodsImgMapper;

    @Override
    public List<GoodsImg> selectByGoodsId(Long goodsId) {
        GoodsImgExample goodsImgExample = new GoodsImgExample();
        goodsImgExample.createCriteria().andGoodsIdEqualTo(goodsId);
        List<GoodsImg> goodsImgs = goodsImgMapper.selectByExampleWithBLOBs(goodsImgExample);
        return goodsImgs;
    }

    @Override
    public boolean UpdateImg(String goodsId, String file) {
        GoodsImgExample goodsImgExample = new GoodsImgExample();
        goodsImgExample.createCriteria().andGoodsIdEqualTo(Long.parseLong(goodsId));
        List<GoodsImg> goodsImg = goodsImgMapper.selectByExampleWithBLOBs(goodsImgExample);

        System.out.println(file);

        GoodsImg tempGoodsImg = goodsImg.get(0);
        GoodsImg newGoodsImg = new GoodsImg();
        newGoodsImg.setImgId(tempGoodsImg.getImgId());
        newGoodsImg.setGoodsId(tempGoodsImg.getGoodsId());
        newGoodsImg.setGoodsImg(file.getBytes());

        int result = goodsImgMapper.updateByPrimaryKeyWithBLOBs(newGoodsImg);
        System.out.println(result);

        if (result==1)return true;
        else return false;
    }
}
