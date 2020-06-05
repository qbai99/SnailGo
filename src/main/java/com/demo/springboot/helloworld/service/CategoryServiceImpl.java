package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Category;
import com.demo.springboot.helloworld.common.domain.CategoryExample;
import com.demo.springboot.helloworld.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> list() {
        //真正处理请求的地方
        //请求的目的：获取所有的类别   调用获取所有类别的数据库操作
        //查询模板
        CategoryExample example = new CategoryExample();
        //给这个模板添加条件: 查询cid值为传过来的id
        CategoryExample.Criteria criteria = example.createCriteria();
        List<Category> list = categoryMapper.selectByExample(example);
        return list;
    }

    @Override
    public Category selectById(String id, String name) {
       Category category =  categoryMapper.selectById(id,name);
        return category;
    }

    @Override
    public Category selectById(Category cate) {
        Category category =  categoryMapper.selectByMyExample(cate);
        return category;
    }

    @Override
    public void deleteByIds(List<String> list) {
        //delete from xx where id in(xx,xx,xx)
        categoryMapper.deleteByIds(list);
    }

    @Override
    public Category selectByIdCopy(String cid) {
        return categoryMapper.selectByIdCopy(cid);
    }
}
