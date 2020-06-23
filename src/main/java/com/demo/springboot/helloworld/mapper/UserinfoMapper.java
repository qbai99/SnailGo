package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Userinfo;
import com.demo.springboot.helloworld.common.domain.UserinfoExample;
import com.demo.springboot.helloworld.common.domain.UserinfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserinfoMapper {
    long countByExample(UserinfoExample example);

    int deleteByExample(UserinfoExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(UserinfoWithBLOBs record);

    int insertSelective(UserinfoWithBLOBs record);

    List<UserinfoWithBLOBs> selectByExampleWithBLOBs(UserinfoExample example);

    List<Userinfo> selectByExample(UserinfoExample example);

    UserinfoWithBLOBs selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") UserinfoWithBLOBs record, @Param("example") UserinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") UserinfoWithBLOBs record, @Param("example") UserinfoExample example);

    int updateByExample(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByPrimaryKeySelective(UserinfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserinfoWithBLOBs record);

    int updateByPrimaryKey(Userinfo record);

    Long selectid(String username);
}