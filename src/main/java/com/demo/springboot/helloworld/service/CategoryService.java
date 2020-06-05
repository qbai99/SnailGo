package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> list();

    Category selectById(String id, String name);

    Category selectById(Category cate);

    void deleteByIds(List<String> list);

    Category selectByIdCopy(String cid);
}
