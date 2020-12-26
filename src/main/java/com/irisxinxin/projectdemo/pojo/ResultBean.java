package com.irisxinxin.projectdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 封装统一的返回信息
 * @param <T>
 */
@Data
@AllArgsConstructor
public class ResultBean<T> {
    private String status;
    private T data;
}
