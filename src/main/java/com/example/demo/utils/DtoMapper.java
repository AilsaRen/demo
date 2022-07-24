package com.example.demo.utils;

import org.springframework.beans.BeanUtils;

/**
 * <p>Title: DtoMapper</p >
 * <p>Description: </p >
 * <p>Company: www.h-visions.com</p >
 * <p>create date: 2022/7/24</p >
 *
 * @author :xtren
 * @version :1.0.0
 */
public class DtoMapper {

    public static <T> T convert(Object obj, Class<T> clazz, String... ignoreProperties) {
        if (obj == null) {
            return null;
        } else {
            T t = BeanUtils.instantiateClass(clazz);
            BeanUtils.copyProperties(obj, t, ignoreProperties);
            return t;
        }
    }

}
