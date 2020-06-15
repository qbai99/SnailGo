package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.Userlevel;
import com.demo.springboot.helloworld.common.domain.UserlevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserlevelMapper {
    long countByExample(UserlevelExample example);

    int deleteByExample(UserlevelExample example);

    int deleteByPrimaryKey(Long levelId);

    int insert(Userlevel record);

    int insertSelective(Userlevel record);

    List<Userlevel> selectByExample(UserlevelExample example);

    Userlevel selectByPrimaryKey(Long levelId);

    int updateByExampleSelective(@Param("record") Userlevel record, @Param("example") UserlevelExample example);

    int updateByExample(@Param("record") Userlevel record, @Param("example") UserlevelExample example);

    int updateByPrimaryKeySelective(Userlevel record);

    int updateByPrimaryKey(Userlevel record);
}