package com.wishtodaya.aipocket.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wishtodaya.aipocket.model.Category;
import com.wishtodaya.aipocket.model.Plugin;
import com.wishtodaya.aipocket.service.CategoryService;
import com.wishtodaya.aipocket.service.PluginService;
import com.wishtodaya.aipocket.utils.Result;
import com.wishtodaya.aipocket.utils.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PluginController {
    private final PluginService pluginService;
    private final CategoryService categoryService;

    @Autowired
    public PluginController(PluginService pluginService, CategoryService categoryService) {
        this.pluginService = pluginService;
        this.categoryService = categoryService;
    }

    /**
     * 获取指定分类下的插件列表
     *
     * @param pageNumber 页码，用于分页查询
     * @param pageSize   每页的记录数，用于分页查询
     * @param categoryId 分类ID，用于指定插件分类
     * @return 返回一个Result类型的响应，包含插件的分页信息
     */
    @GetMapping("/plugins")
    public Result getPluginsByCategory(@RequestParam int pageNumber, @RequestParam int pageSize, @RequestParam String categoryId) {
        Page<Plugin> pagePlugins = pluginService.getPluginsByCategory(pageNumber, pageSize, categoryId);
        Result result = new Result(StatusEnum.SUCCESS);
        result.addData("pagePlugins", pagePlugins);
        return result;
    }

    /**
     * 获取所有分类的列表
     *
     * @return 返回一个Result类型的响应，包含所有的分类信息
     */
    @GetMapping("/categorys")
    public Result getAllCategorys() {
        List<Category> categorys = categoryService.getCategorys();
        Result result = new Result(StatusEnum.SUCCESS);
        result.addData("categorys", categorys);
        return result;
    }

    @ExceptionHandler(Exception.class)
    public Result handleGeneralException(Exception ex) {
        Result result = new Result(StatusEnum.FAIL);
        result.addData("error", ex.getMessage());
        return result;
    }
}
