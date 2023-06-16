package com.wishtodaya.aipocket.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wishtodaya.aipocket.model.Plugin;

public interface PluginService extends IService<Plugin> {
    /**
     * 根据categoryId获取相关插件
     *
     * @param pageNumber
     * @param pageSize
     * @param categoryId
     * @return Page<Plugin>
     */
    Page<Plugin> getPluginsByCategory(int pageNumber, int pageSize, String categoryId);
}
