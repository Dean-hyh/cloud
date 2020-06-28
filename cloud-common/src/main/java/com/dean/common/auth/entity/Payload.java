package com.dean.common.auth.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 * 载荷信息实体类
 */
public class Payload<T> implements Serializable{
    private String id;
    private T userInfo;
    private Date expiration;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(T userInfo) {
        this.userInfo = userInfo;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}