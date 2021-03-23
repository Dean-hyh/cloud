package com.dean.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dean.common.enums.DeanExceptionEnum;
import com.dean.common.exception.DeanException;
import com.dean.common.utils.BeanHelper;
import com.dean.common.utils.JsonUtils;
import com.dean.user.entity.PeUser;
import com.dean.user.mapper.PeUserMapper;
import com.dean.user.pojo.VO.PeUserVO;
import com.dean.user.service.PeUserService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.dean.common.constants.BaseMqConstants.Exchange.USER_EXCHANGE_NAME;
import static com.dean.common.constants.BaseMqConstants.RoutingKey.USER_REGISTER_KEY;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Dean
 * @since 2020-09-18
 */
@Service
public class PeUserServiceImpl extends ServiceImpl<PeUserMapper, PeUser> implements PeUserService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<PeUserVO> queryUserList() {
        QueryWrapper<PeUser> queryWrapper = new QueryWrapper<>();
        List<PeUser> peUserList = this.getBaseMapper().selectList(queryWrapper);

        if(CollectionUtils.isEmpty(peUserList)){
            throw new DeanException(DeanExceptionEnum.SPEC_NOT_FOUND);
        }
        //赋值参数到用户VO
        List<PeUserVO> peUserVOList = BeanHelper.copyWithCollection(peUserList, PeUserVO.class);

        redisTemplate.opsForValue().set("userList", JsonUtils.toString(peUserList));
        return peUserVOList;
    }

    @Override
    public void rabbitMqTest() {
        amqpTemplate.convertAndSend(USER_EXCHANGE_NAME, USER_REGISTER_KEY, "rabbitMq测试数据");
    }

    @Override
    public void registerTest(String test) {
        System.out.println(test+0+"========================");
    }

    @Override
    public void registerTest1(String test) {
        System.out.println(test+1+"========================");
    }
}
