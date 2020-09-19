package com.dean.user.client;

import com.dean.user.pojo.VO.PeUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @ClassName UserClient
 * @Description UserClient
 * @Author yuanh
 * @Date 2020/9/17 17:46
 * @Version 1.0
 */
@FeignClient(name="user-service")
public interface UserClient {
    /**
     * 用户列表查询-服务间调用接口
     * @return
     */
    @GetMapping(value = "/userList")
    List<PeUserVO> queryUserList();

    @GetMapping("/errTest")
    void errTest();
}
