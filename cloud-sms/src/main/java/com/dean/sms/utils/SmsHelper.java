package com.dean.sms.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.dean.common.enums.DeanExceptionEnum;
import com.dean.common.exception.DeanException;
import com.dean.common.utils.JsonUtils;
import com.dean.sms.config.SmsProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.dean.sms.constants.SmsConstants.*;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/8/9 10:52
 */
@Component
public class SmsHelper {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final int RESP_HTTP_STATUS  = 300;

    private IAcsClient client;
    private SmsProperties prop;

    public SmsHelper(IAcsClient iAcsClient, SmsProperties smsProperties) {
        this.client = iAcsClient;
        this.prop = smsProperties;
    }

    public void sendMessage(String phone, String signName, String template, String param) {
        CommonRequest request = new CommonRequest();
        request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain(prop.getDomain());
        request.setVersion(prop.getVersion());
        request.setAction(prop.getAction());
        request.putQueryParameter(SMS_PARAM_KEY_PHONE, phone);
        request.putQueryParameter(SMS_PARAM_KEY_SIGN_NAME, signName);
        request.putQueryParameter(SMS_PARAM_KEY_TEMPLATE_CODE, template);
        request.putQueryParameter(SMS_PARAM_KEY_TEMPLATE_PARAM, param);
        try {
            CommonResponse response = client.getCommonResponse(request);
            if (response.getHttpStatus() >= RESP_HTTP_STATUS) {
                logger.error("【SMS服务】发送短信失败。响应信息：{}", response.getData());
            }
            // 获取响应体
            Map<String, String> resp = JsonUtils.toMap(response.getData(), String.class, String.class);
            logger.info("Ali短信平台响应值：{}",resp);
            if(resp == null){
                logger.error("【SMS服务】发送短信失败[sms.resp.isEmpty]");
                throw new DeanException(DeanExceptionEnum.SEND_MESSAGE_ERROR);
            }
            // 判断是否是成功
            if (!StringUtils.equals(OK, resp.get(SMS_RESPONSE_KEY_CODE))) {
                // 不成功，
                logger.error("【SMS服务】发送短信失败，原因：{}", resp.get(SMS_RESPONSE_KEY_MESSAGE));
                throw new DeanException(DeanExceptionEnum.SEND_MESSAGE_ERROR);
            }
            logger.info("【SMS服务】发送短信成功，手机号：{}, 响应：{}", phone, response.getData());
        } catch (ServerException e) {
            logger.error("【SMS服务】发送短信失败，服务端异常。", e);
        } catch (ClientException e) {
            logger.error("【SMS服务】发送短信失败，客户端异常。", e);
        }
    }
}
