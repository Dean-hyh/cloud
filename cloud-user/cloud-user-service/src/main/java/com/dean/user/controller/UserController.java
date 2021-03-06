package com.dean.user.controller;

import com.dean.common.enums.DeanExceptionEnum;
import com.dean.common.exception.DeanException;
import com.dean.user.pojo.VO.PeUserVO;
import com.dean.user.service.PeUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description UserController
 * @Author yuanh
 * @Date 2020/9/17 18:02
 * @Version 1.0
 */
@RestController
@RequestMapping
public class UserController{

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PeUserService userService;

    @GetMapping(value = "/userList")
    public ResponseEntity<List<PeUserVO>> queryUserList(){
        List<PeUserVO> userList = userService.queryUserList();
        return ResponseEntity.ok(userList);
    }

    @GetMapping(value = "/errTest")
    public ResponseEntity<Void> errTest(){
        throw new DeanException(DeanExceptionEnum.DATA_TRANSFER_ERROR);
    }

    @GetMapping(value = "/rabbitMqTest")
    public ResponseEntity<Void> rabbitMqTest(){
        userService.rabbitMqTest();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/rabbitSmsTest")
    public ResponseEntity<Void> rabbitSmsTest(){
        userService.rabbitSmsTest();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
