package com.wishtodaya.aipocket.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wishtodaya.aipocket.mapper.PluginMapper;
import com.wishtodaya.aipocket.model.Category;
import com.wishtodaya.aipocket.model.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PluginServiceImpl extends ServiceImpl<PluginMapper, Plugin> implements PluginService {
    private final PluginMapper pluginMapper;

    @Autowired
    public PluginServiceImpl(PluginMapper pluginMapper) {
        this.pluginMapper = pluginMapper;
    }

    /**
     * 查找所有插件
     * @param pageNumber
     * @param pageSize
     * @return Page<Plugin>
     */
    public Page<Plugin> getPlugins(int pageNumber, int pageSize) {
        // 创建 Page 对象
        Page<Plugin> page = new Page<>(pageNumber, pageSize);

        // 使用分页查询
        pluginMapper.selectPage(page,null);

        // 返回结果
        return page;
    }

    /**
     * 根据类型查找插件
     * @param pageNumber
     * @param pageSize
     * @param category
     * @return Page<Plugin>
     */
    public Page<Plugin> getPluginsByCategory(int pageNumber, int pageSize, Category category) {
        // 创建 Page 对象
        Page<Plugin> page = new Page<>(pageNumber, pageSize);
        LambdaQueryWrapper<Plugin> queryWrapper = new LambdaQueryWrapper<>();

        // 判断 category 是否为空，然后判断 category 的 id 是否为空
        if (category != null && category.getId() != null) {
            queryWrapper.ne(Plugin::getCategoryId, category.getId());
        }

        // 使用分页查询
        pluginMapper.selectPage(page,queryWrapper);
        // 返回结果
        return page;
    }


}
