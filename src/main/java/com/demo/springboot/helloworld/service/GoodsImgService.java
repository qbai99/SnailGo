package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.GoodsImg;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsImgService {
    List<GoodsImg> selectByGoodsId(Long goodsId);

    boolean UpdateImg(String goodsId, String file);
}
