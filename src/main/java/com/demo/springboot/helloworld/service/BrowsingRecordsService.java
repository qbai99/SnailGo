package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.BrowsingRecords;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrowsingRecordsService {
    Boolean Addrecords(String userAdmin, String url, String goodsId);

    List<BrowsingRecords> check(String userAdmin);

    boolean delete(String recordsId, String userAdmin);

    boolean deleteall(String userAdmin);
}
