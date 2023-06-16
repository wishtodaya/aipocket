package com.wishtodaya.aipocket.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wishtodaya.aipocket.mapper.PluginMapper;
import com.wishtodaya.aipocket.model.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PluginServiceImpl extends ServiceImpl<PluginMapper, Plugin> implements PluginService {
    private final PluginMapper pluginMapper;
    private final CategoryService categoryService;

    @Autowired
    public PluginServiceImpl(PluginMapper pluginMapper, CategoryService categoryService) {
        this.pluginMapper = pluginMapper;
        this.categoryService = categoryService;
    }


    @Override
    public Page<Plugin> getPluginsByCategory(int pageNumber, int pageSize, String categoryId) {
        List<String> pluginIds = categoryService.getPluginIdsByCategory(categoryId);
        // 创建一个Page对象，用于传递分页参数
        Page<Plugin> page = new Page<>(pageNumber, pageSize);

        // 创建一个LambdaQueryWrapper对象，用于传递查询条件
        LambdaQueryWrapper<Plugin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Plugin::getId, pluginIds); // 将pluginId作为查询条件

        // 执行分页查询
        return pluginMapper.selectPage(page, queryWrapper);
    }
}
