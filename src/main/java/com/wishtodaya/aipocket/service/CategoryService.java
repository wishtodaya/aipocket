package com.wishtodaya.aipocket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wishtodaya.aipocket.model.Category;

import java.util.List;

public interface CategoryService extends IService<Category> {


    /**
     * 根据分类表查插件id
     *
     * @return pluginIds
     */
    List<String> getPluginIdsByCategory(String categoryId);

    /**
     * 获取所有分类
     *
     * @return List<Category>
     */
    List<Category> getCategorys();
}
