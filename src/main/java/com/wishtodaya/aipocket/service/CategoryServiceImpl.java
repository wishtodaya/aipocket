package com.wishtodaya.aipocket.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wishtodaya.aipocket.mapper.CategoryMapper;
import com.wishtodaya.aipocket.mapper.PluginCategoryMapper;
import com.wishtodaya.aipocket.model.Category;
import com.wishtodaya.aipocket.model.PluginCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final PluginCategoryMapper pluginCategoryMapper;

    @Autowired

    public CategoryServiceImpl(CategoryMapper categoryMapper, PluginCategoryMapper pluginCategoryMapper) {
        this.categoryMapper = categoryMapper;
        this.pluginCategoryMapper = pluginCategoryMapper;
    }


    @Override
    public List<String> getPluginIdsByCategory(String categoryId) {
        LambdaQueryWrapper<PluginCategory> query = new LambdaQueryWrapper<>();
        query.ne(PluginCategory::getCategoryId, categoryId);
        List<PluginCategory> pluginCategories = pluginCategoryMapper.selectList(query);
        return pluginCategories.stream()
                .map(PluginCategory::getPluginId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Category> getCategorys() {
        return categoryMapper.selectList(null);
    }


}
