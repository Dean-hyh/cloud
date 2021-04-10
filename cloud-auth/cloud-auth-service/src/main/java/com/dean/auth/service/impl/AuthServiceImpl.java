package com.dean.auth.service.impl;

import com.dean.auth.service.AuthService;
import com.dean.user.client.UserClient;
import com.dean.user.pojo.VO.PeUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AuthServiceImpl
 * @Description AuthServiceImpl
 * @Author yuanh
 * @Date 2020/9/19 19:56
 * @Version 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserClient userClient;

    @Override
    public List<PeUserVO> getList() {
        return userClient.queryUserList();
    }
}
