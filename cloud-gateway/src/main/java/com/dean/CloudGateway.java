package com.dean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 */
@SpringBootApplication
@EnableZuulProxy
public class CloudGateway {
    public static void main(String[] args) {
        SpringApplication.run(CloudGateway.class,args);
    }
}
