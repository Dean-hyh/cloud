package com.dean.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;
import java.util.List;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 * cors跨域配置文件读取类
 */
@ConfigurationProperties(prefix ="dean.cors")
public class CorsProperties implements Serializable {
    private List<String> allowedOrigins;
    private Boolean allowedCredentials;
    private List<String> allowedHeaders;
    private List<String> allowedMethods;
    private Long maxAge;
    private String filterPath;

    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(List<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public Boolean getAllowedCredentials() {
        return allowedCredentials;
    }

    public void setAllowedCredentials(Boolean allowedCredentials) {
        this.allowedCredentials = allowedCredentials;
    }

    public List<String> getAllowedHeaders() {
        return allowedHeaders;
    }

    public void setAllowedHeaders(List<String> allowedHeaders) {
        this.allowedHeaders = allowedHeaders;
    }

    public List<String> getAllowedMethods() {
        return allowedMethods;
    }

    public void setAllowedMethods(List<String> allowedMethods) {
        this.allowedMethods = allowedMethods;
    }

    public Long getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Long maxAge) {
        this.maxAge = maxAge;
    }

    public String getFilterPath() {
        return filterPath;
    }

    public void setFilterPath(String filterPath) {
        this.filterPath = filterPath;
    }
}
