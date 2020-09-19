package com.dean.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName CloudUserApplication
 * @Description CloudUserApplication
 * @Author yuanh
 * @Date 2020/9/17 18:16
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.dean"})
@EnableDiscoveryClient
@MapperScan("com.dean.user.mapper")
public class CloudUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudUserApplication.class,args);
    }
}
