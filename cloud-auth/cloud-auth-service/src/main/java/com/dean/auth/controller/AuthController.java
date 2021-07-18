package com.dean.auth.controller;

import com.dean.auth.service.AuthService;
import com.dean.user.pojo.VO.PeUserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName AuthController
 * @Description AuthController
 * @Author yuanh
 * @Date 2020/9/19 19:42
 * @Version 1.0
 */
@RestController
@RequestMapping
public class AuthController {
    @Autowired
    private AuthService authService;

    private Logger logger = LogManager.getLogger(AuthController.class);

    /**
     * 服务间接口调用测试-调用用户微服务接口UserClient
     * @return
     */
    @GetMapping("/testList")
    public ResponseEntity<List> getList(){
        List<PeUserVO> userVOList = authService.getList();
        return ResponseEntity.ok(userVOList);
    }
}
