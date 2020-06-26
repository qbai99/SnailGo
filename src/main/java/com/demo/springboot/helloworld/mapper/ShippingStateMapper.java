package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.ShippingState;
import com.demo.springboot.helloworld.common.domain.ShippingStateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingStateMapper {
    long countByExample(ShippingStateExample example);

    int deleteByExample(ShippingStateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShippingState record);

    int insertSelective(ShippingState record);

    List<ShippingState> selectByExampleWithBLOBs(ShippingStateExample example);

    List<ShippingState> selectByExample(ShippingStateExample example);

    ShippingState selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShippingState record, @Param("example") ShippingStateExample example);

    int updateByExampleWithBLOBs(@Param("record") ShippingState record, @Param("example") ShippingStateExample example);

    int updateByExample(@Param("record") ShippingState record, @Param("example") ShippingStateExample example);

    int updateByPrimaryKeySelective(ShippingState record);

    int updateByPrimaryKeyWithBLOBs(ShippingState record);

    int updateByPrimaryKey(ShippingState record);

    Long getMaxId();
}