package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import edu.princeton.cs.algs4.Cat;
import org.springframework.beans.factory.annotation.Autowired;

public interface CategoryService {

    /**
     *  分类分页查询
     * @param categoryPageQueryDTO
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 新增分类
     * @param categoryDTO
     */
    void save(CategoryDTO categoryDTO);
}
