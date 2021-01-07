package com.dean.user.listener;

import com.dean.common.constants.BaseMqConstants;
import com.dean.user.service.PeUserService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.dean.common.constants.BaseMqConstants.RoutingKey.USER_REGISTER_KEY;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/8/7 20:23
 */
@Component
public class UserListener2 {
    @Autowired
    private PeUserService peUserService;

    /**
     * test
     * @param test
     * @throws Exception
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = BaseMqConstants.Queue.USER_REGISTR, durable = "true"),
            exchange = @Exchange(
                    value = BaseMqConstants.Exchange.USER_EXCHANGE_NAME,
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC
            ),
            key = USER_REGISTER_KEY))
    public void registerTest(String test) throws Exception{
        peUserService.registerTest1(test);
    }
}
