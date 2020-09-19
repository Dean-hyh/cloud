package com.dean.common.utils;

import com.dean.common.exception.DeanException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 * java Bean属性复制工具类
 */
public class BeanHelper {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    /**
     *
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public static <T> T copyProperties(Object source, Class<T> target){
        try {
            T t = target.newInstance();
            BeanUtils.copyProperties(source, t);
            return t;
        } catch (Exception e) {
            logger.error("【数据转换】数据转换出错，目对象{}构造函数异常", target.getName(), e);
            //throw new DeanException(ExceptionEnum.DATA_TRANSFER_ERROR);
            return null;
        }
    }

    public static <T> List<T> copyWithCollection(List<?> sourceList, Class<T> target){
        try {
            return sourceList.stream().map(s -> copyProperties(s, target)).collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("【数据转换】数据转换出错，目标对象{}构造函数异常", target.getName(), e);
//            throw new DeanException(ExceptionEnum.DATA_TRANSFER_ERROR);
            return null;
        }
    }

    public static <T> Set<T> copyWithCollection(Set<?> sourceList, Class<T> target){
        try {
            return sourceList.stream().map(s -> copyProperties(s, target)).collect(Collectors.toSet());
        } catch (Exception e) {
            logger.error("【数据转换】数据转换出错，目标对象{}构造函数异常,{}", target.getName(), e);
            //throw new DeanException(ExceptionEnum.DATA_TRANSFER_ERROR);
            return null;
        }
    }
}
