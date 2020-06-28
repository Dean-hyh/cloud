package com.dean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudRegistry {
    public static void main(String[] args) {
        SpringApplication.run(CloudRegistry.class,args);
    }
}
