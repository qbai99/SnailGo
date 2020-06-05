package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Category;
import com.demo.springboot.helloworld.common.domain.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(String cid);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(String cid);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> selectAll();

    Category selectById(@Param("id")String id, @Param("name")String name);

    Category selectByMyExample(@Param("cate")Category cate);

    void deleteByIds(@Param("list")List<String> list);

    Category selectByIdCopy(String cid);
}