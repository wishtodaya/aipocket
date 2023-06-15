package com.wishtodaya.aipocket.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wishtodaya.aipocket.mapper.CategoryMapper;
import com.wishtodaya.aipocket.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{
    private final CategoryMapper categoryMapper;
    @Autowired

    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    /**
     * 获取到所有分类类型
     * @return List<Category>
     */
    public List<Category> getCategorys(){
    return categoryMapper.selectList(null);
    }

}
