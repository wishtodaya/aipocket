package com.wishtodaya.aipocket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wishtodaya.aipocket.model.Category;

import java.util.List;

public interface CategoryService extends IService<Category> {
    List<Category> getCategorys();
}
