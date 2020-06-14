package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.common.domain.UserinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserinfoMapper {
    long countByExample(UserinfoExample example);

    int deleteByExample(UserinfoExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    List<Userinfo> selectByExampleWithBLOBs(UserinfoExample example);

    List<Userinfo> selectByExample(UserinfoExample example);

    Userinfo selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByExample(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKeyWithBLOBs(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}