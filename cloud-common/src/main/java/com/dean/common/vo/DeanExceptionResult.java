package com.dean.common.vo;

import com.dean.common.exception.DeanException;
import org.joda.time.DateTime;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 * 自定义异常结果类
 */
public class DeanExceptionResult {

    private Integer status;
    private String message;
    private String timestamp;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    /**
     * 参数：自定的义异常类  DeanException
     * @param deanException
     */
    public DeanExceptionResult(DeanException deanException) {
        this.status = deanException.getStatus();
        this.message = deanException.getMessage();
        this.timestamp = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
    }
}
