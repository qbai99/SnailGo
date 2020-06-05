package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Product;
import com.demo.springboot.helloworld.common.domain.ProductExample;
import java.util.List;

import com.demo.springboot.helloworld.mapper.extend.ProductExtendMapper;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper extends ProductExtendMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String pid);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String pid);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

}