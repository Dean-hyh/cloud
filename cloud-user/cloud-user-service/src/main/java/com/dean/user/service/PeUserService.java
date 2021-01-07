package com.dean.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dean.user.entity.PeUser;
import com.dean.user.pojo.VO.PeUserVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Dean
 * @since 2020-09-18
 */
public interface PeUserService extends IService<PeUser> {

    List<PeUserVO> queryUserList();

    void rabbitMqTest();

    void registerTest(String test);

    void registerTest1(String test);
}
