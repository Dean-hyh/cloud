package com.dean.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName AuthApplication
 * @Description AuthApplication
 * @Author yuanh
 * @Date 2020/9/18 20:54
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.dean"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.dean")
@MapperScan("com.dean.auth.mapper")
public class CloudAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudAuthApplication.class,args);
    }
}
