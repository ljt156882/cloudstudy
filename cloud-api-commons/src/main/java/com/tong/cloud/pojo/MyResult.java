package com.tong.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyResult<T> {
    private Integer code;
    private String message;
    private T data;

    public MyResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
