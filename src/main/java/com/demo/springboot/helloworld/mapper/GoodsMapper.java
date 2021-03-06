package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Goods;
import com.demo.springboot.helloworld.common.domain.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Long goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Long goodsId);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    int selectRem(long goodsId);

    List<Goods> mysearch(String search_key,String goods_tag);

    Long selectCurId();

    Integer getShopIdBygoodsId(Integer goodsId);

    List<Goods> selectNameAndPri(Integer goodsId);

    void delnum(Goods goods);

    List<Goods> mysearchsorted(String search_key, String goods_tag);

    List<Goods> mysearchsortedh2l(String search_key, String goods_tag);
}