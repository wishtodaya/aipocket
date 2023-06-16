package com.wishtodaya.aipocket.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("plugin_category")
public class PluginCategory {
    private String pluginId;
    private String categoryId;
}
