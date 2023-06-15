package com.wishtodaya.aipocket.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    SUCCESS(200, "Success"),
    FAIL(500, "Failure"),
    NOT_FOUND(404, "Not Found");

    private final int code;
    private final String message;
}
