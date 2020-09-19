package com.dean.common.advice;

import com.dean.common.exception.DeanException;
import com.dean.common.vo.DeanExceptionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 * 自定义异常捕获处理类
 */
@ControllerAdvice
public class BaseExceptionAdvice {
    private static final Logger logger = LoggerFactory.getLogger(BaseExceptionAdvice.class);

    /**
     * 异常捕获方法
     * @param deanException
     * @return
     */
    @ExceptionHandler(DeanException.class)
    public ResponseEntity<DeanExceptionResult> handlerDeanException(DeanException deanException){
        logger.error(deanException.getMessage());
        return ResponseEntity.status(deanException.getStatus()).body(new DeanExceptionResult(deanException));
    }
}
