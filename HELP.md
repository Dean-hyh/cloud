# Getting Started

### cloud-eureka
Registration Center, For service delivery 微服务注册中心，用于服务的注册与发现

### cloud-gateway
Gateway，微服务网关，用于请求的路由及白名单过滤，跨域问题处理等

### cloud-common
common utils，通用基础工具包

### cloud-user
用户中心-登录，注册，用户信息查询等功能

### cloud-author
授权中心-访问授权等信息查询等功能

###20210105导入依赖失败原因
maven配置文件setting.xml未配置，导致从远程仓库无法正常下载依赖坐标
