package com.dean.sms.mq;


import com.dean.common.utils.JsonUtils;
import com.dean.sms.config.SmsProperties;
import com.dean.sms.utils.SmsHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.dean.common.constants.BaseMqConstants.Exchange.SMS_EXCHANGE_NAME;
import static com.dean.common.constants.BaseMqConstants.Queue.SMS_VERIFY_CODE_QUEUE;
import static com.dean.common.constants.BaseMqConstants.RoutingKey.VERIFY_CODE_KEY;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/8/9 11:03
 * 短信服务监听类
 */
@Component
@EnableConfigurationProperties(SmsProperties.class)
public class SmsListener {
    @Autowired
    private SmsProperties prop;

    @Autowired
    private SmsHelper smsHelper;

    /**
     * 监听队列消息（消息为map类型的数据）
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = SMS_VERIFY_CODE_QUEUE),
            exchange = @Exchange(
                    name = SMS_EXCHANGE_NAME,
                    type = ExchangeTypes.TOPIC,
                    ignoreDeclarationExceptions = "true"
            ),
            key = VERIFY_CODE_KEY
    ))
    public void listenVerifyCode(Map<String, String> msg) {
        if(msg==null){
            return;
        }
        String phone = msg.remove("phone");
        if(StringUtils.isEmpty(phone)){
            return;
        }
        smsHelper.sendMessage(phone, prop.getSignName(), prop.getVerifyCodeTemplate(), JsonUtils.toString(msg));
    }
}
