package com.wishtodaya.aipocket.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("plugin")
public class Plugin {
    private String id;
    private String domain;
    private String namespace;
    private String apiUrl;
    private String nameForModel;
    private String nameForHuman;
    private String descriptionForModel;
    private String descriptionForHuman;
    private String logoUrl;
    private String contactEmail;
    private String legalInfoUrl;
    private String descriptionForModelCn;
    private String descriptionForHumanCn;
}
