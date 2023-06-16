package com.wishtodaya.aipocket.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("category")
public class Category {
    private String id;
    private String type;
    private String nameEn;
    private String nameZh;
}
