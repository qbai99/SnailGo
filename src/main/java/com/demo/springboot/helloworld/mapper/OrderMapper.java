package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Order;
import com.demo.springboot.helloworld.common.domain.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //void insertone(Long userid, Integer goodsId, Long buyerid, Integer addId, String goodsName, Integer quantity, Double price);

    Long getMaxId();

    void insertone(Order list);
}