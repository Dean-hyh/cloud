#user-service开发记录
##1.统一异常处理类捕获不到指定异常
    原因：BaseExceptionAdvice类中@ControllerAdvise只能扫描本包，而抛出的异常包名不同
    处理方案：
        1.controller接口类继承BaseExceptionAdvice
        2.修改启动类的注解为@SpringBootApplication(scanBasePackages = {"com.dean"})
##2.接口返回数据为xml格式
     原因：
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
        坐标中包含了jackson-dataformat-xml的包导致解析异常
      处理方案1：添加以下内容，手动除去xml包
        <exclusions>
            <exclusion>
                <groupId>com.fasterxml.jackson.dataformat</groupId>
                <artifactId>jackson-dataformat-xml</artifactId>
            </exclusion>
        </exclusions>
        
        处理方案2：在接口注解中添加以下内容（方法已过时）：
            @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
##3.在idea中开启Dashboard
    在项目的.idea中的workspace.xml文件中插入如下语句
        <component name="RunDashboard">
              <option name="configurationTypes">
                <set>
                  <option value="SpringBootApplicationConfigurationType" />
                </set>
              </option>
              <option name="ruleStates">
                <list>
                  <RuleState>
                    <option name="name" value="ConfigurationTypeDashboardGroupingRule" />
                  </RuleState>
                  <RuleState>
                    <option name="name" value="StatusDashboardGroupingRule" />
                  </RuleState>
                </list>
              </option>
              <option name="contentProportion" value="0.20013662" />
        </component> 
##4.idea右侧maven模块中部分项目变灰色
    file-settings-maven-ignorefiles把勾选去掉