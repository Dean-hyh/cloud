package com.dean.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 * 网关cors跨域配置类
 */
@Configuration
@EnableConfigurationProperties(CorsProperties.class)
public class CorsFilterConfig {

    /**
     * 配置bean，添加自定义配置信息
     * @param cp
     * @return
     */
    @Bean
    public CorsFilter corsFilter(CorsProperties cp){
        //1.添加cors配置信息
        CorsConfiguration ccf = new CorsConfiguration();
        /*允许访问的域名*/
        ccf.setAllowedOrigins(cp.getAllowedOrigins());
        /*是否允许发送cookies*/
        ccf.setAllowCredentials(cp.getAllowedCredentials());
        /*允许的请求方式*/
        ccf.setAllowedMethods(cp.getAllowedMethods());
        /*允许的头信息*/
        ccf.setAllowedHeaders(cp.getAllowedHeaders());
        /*访问有效期*/
        ccf.setMaxAge(cp.getMaxAge());
        //2.添加映射路径-拦截所有请求
        UrlBasedCorsConfigurationSource ubccs = new UrlBasedCorsConfigurationSource();
        ubccs.registerCorsConfiguration(cp.getFilterPath(),ccf);
        //3.返回新的CorsFilter类
        return new CorsFilter(ubccs);
    }
}
