package com.wishtodaya.aipocket.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wishtodaya.aipocket.model.Category;
import com.wishtodaya.aipocket.model.Plugin;

public interface PluginService extends IService<Plugin> {
    Page<Plugin> getPluginsByCategory(int pageNumber, int pageSize, Category category);
}
