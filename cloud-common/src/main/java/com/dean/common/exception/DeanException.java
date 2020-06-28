package com.dean.common.exception;

import com.dean.common.enums.DeanExceptionEnum;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 * 自定义异常类
 */
public class DeanException extends RuntimeException{
    private int status;

    public int getStatus() {
        return status;
    }

    /**
     * 参数：自定义异常枚举
     * @param deanExceptionEnum
     */
    public DeanException(DeanExceptionEnum deanExceptionEnum) {
        super(deanExceptionEnum.getMessage());
        this.status = deanExceptionEnum.getStatus();
    }

    /**
     * @param deanExceptionEnum
     * @param cause
     */
    public DeanException(DeanExceptionEnum deanExceptionEnum, Throwable cause) {
        super(deanExceptionEnum.getMessage(), cause);
        this.status = deanExceptionEnum.getStatus();
    }

    /**
     * 参数：接收自定义异常信息
     * @param message
     * @param cause
     * @param status
     */
    public DeanException(String message, Throwable cause, int status) {
        super(message, cause);
        this.status = status;
    }

    /**
     * 参数：接收自定义异常信息
     * @param message
     * @param status
     */
    public DeanException(String message, int status) {
        super(message);
        this.status = status;
    }
}
