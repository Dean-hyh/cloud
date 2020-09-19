#auth-service开发记录
##1.Feign接口注入失败
```
问题原因：
   1.本服务启动类缺少注解：@EnableFeignClients
   2.@EnableFeignClients注解缺少以下内容，导致扫描不到接口暴露服务的包
        (basePackages = "com.dean")
   处理：如上，添加 @EnableFeignClients(basePackages = "com.dean")
```
