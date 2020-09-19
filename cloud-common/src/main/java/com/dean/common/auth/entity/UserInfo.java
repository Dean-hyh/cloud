package com.dean.common.auth.entity;

import java.io.Serializable;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 * 注册用户的信息实体类
 */
public class UserInfo implements Serializable {

    private Long id;

    private String username;
    
    private String role;

    public UserInfo() {
    }

    public UserInfo(Long id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}