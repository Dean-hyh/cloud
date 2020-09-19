package com.dean.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dean.user.pojo.VO.PeUserVO;

import java.util.List;

/**
 * @ClassName AuthService
 * @Description AuthService
 * @Author yuanh
 * @Date 2020/9/19 19:54
 * @Version 1.0
 */
public interface AuthService{
    List<PeUserVO> getList();
}
