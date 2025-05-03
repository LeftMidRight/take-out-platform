package com.sky.service;

import com.sky.dto.CategoryPageQueryDTO;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

public interface CategoryService {

    /**
     *  分类分页查询
     *
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);
}
