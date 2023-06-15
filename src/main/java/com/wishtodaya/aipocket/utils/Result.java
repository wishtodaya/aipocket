package com.wishtodaya.aipocket.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class Result {
    private int status;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public Result(StatusEnum statusEnum) {
        this.status = statusEnum.getCode();
        this.message = statusEnum.getMessage();
    }

    public void addData(String key, Object value) {
        data.put(key, value);
    }
}
