package com.example.demo.exception;

/**
 * <p>Title: ResultVo</p >
 * <p>Description: </p >
 * <p>Company: www.h-visions.com</p >
 * <p>create date: 2022/7/24</p >
 *
 * @author :xtren
 * @version :1.0.0
 */

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: wenTaoDong
 * @Date: 2022/3/6 03-06 22:10
 * @Description: com.ums.api
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class ResultVo<T> implements Serializable, Comparable<T> {
    //状态码
    private int code;
    private String message;
    private T data;

    public static ResultVo getSuccessBuilder() {
        ResultVo<Object> objectResultVo = new ResultVo<>();
        objectResultVo.setCode(ResponseCode.SUCCESS.getCode());
        objectResultVo.setMessage(ResponseCode.SUCCESS.getMessage()) ;
        return objectResultVo;
    }

    public static ResultVo getFailBuilder() {
        ResultVo<Object> objectResultVo = new ResultVo<>();
        objectResultVo.setCode(ResponseCode.SUCCESS.getCode());
        objectResultVo.setMessage(ResponseCode.SUCCESS.getMessage()) ;
        return objectResultVo;
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}