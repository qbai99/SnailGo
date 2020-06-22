package com.demo.springboot.helloworld.mapper;

import com.demo.springboot.helloworld.common.domain.BrowsingRecords;
import com.demo.springboot.helloworld.common.domain.BrowsingRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BrowsingRecordsMapper {
    long countByExample(BrowsingRecordsExample example);

    int deleteByExample(BrowsingRecordsExample example);

    int deleteByPrimaryKey(Long recordsId);

    int insert(BrowsingRecords record);

    int insertSelective(BrowsingRecords record);

    List<BrowsingRecords> selectByExample(BrowsingRecordsExample example);

    BrowsingRecords selectByPrimaryKey(Long recordsId);

    int updateByExampleSelective(@Param("record") BrowsingRecords record, @Param("example") BrowsingRecordsExample example);

    int updateByExample(@Param("record") BrowsingRecords record, @Param("example") BrowsingRecordsExample example);

    int updateByPrimaryKeySelective(BrowsingRecords record);

    int updateByPrimaryKey(BrowsingRecords record);
}