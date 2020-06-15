package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Userfinance;
import com.demo.springboot.helloworld.common.domain.UserfinanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserfinanceMapper {
    long countByExample(UserfinanceExample example);

    int deleteByExample(UserfinanceExample example);

    int deleteByPrimaryKey(Long financeId);

    int insert(Userfinance record);

    int insertSelective(Userfinance record);

    List<Userfinance> selectByExample(UserfinanceExample example);

    Userfinance selectByPrimaryKey(Long financeId);

    int updateByExampleSelective(@Param("record") Userfinance record, @Param("example") UserfinanceExample example);

    int updateByExample(@Param("record") Userfinance record, @Param("example") UserfinanceExample example);

    int updateByPrimaryKeySelective(Userfinance record);

    int updateByPrimaryKey(Userfinance record);

    Double selectBalance();

    List<Userfinance> selectAll();
}