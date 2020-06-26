package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.GoodsImg;
import com.demo.springboot.helloworld.common.domain.GoodsImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsImgMapper {
    long countByExample(GoodsImgExample example);

    int deleteByExample(GoodsImgExample example);

    int deleteByPrimaryKey(Long imgId);

    int insert(GoodsImg record);

    int insertSelective(GoodsImg record);

    List<GoodsImg> selectByExampleWithBLOBs(GoodsImgExample example);

    List<GoodsImg> selectByExample(GoodsImgExample example);

    GoodsImg selectByPrimaryKey(Long imgId);

    int updateByExampleSelective(@Param("record") GoodsImg record, @Param("example") GoodsImgExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsImg record, @Param("example") GoodsImgExample example);

    int updateByExample(@Param("record") GoodsImg record, @Param("example") GoodsImgExample example);

    int updateByPrimaryKeySelective(GoodsImg record);

    int updateByPrimaryKeyWithBLOBs(GoodsImg record);

    int updateByPrimaryKey(GoodsImg record);
}