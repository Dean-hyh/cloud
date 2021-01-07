package com.dean.common.constants;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 * 正则表达式
 */
public abstract class BaseRegexPatterns {

    /**
     * 手机号正则
     */
    public static final String PHONE_REGEX = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$";

    /**
     * 邮箱正则
     */
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    /**
     * 用户名正则
     */
    public static final String USERNAME_REGEX = "^\\w{4,32}$";

    /**
     * 证件号校验正则
     */
    public static final String ID_NO_REGEX = "^\\d{15}$|^\\d{17}[0-9Xx]$";

    /**
     * 1-2位：以18、19、20开头 19~21世纪
     * 3-4位：任意匹配两位数字00-99
     * 5-6位：月份01-09或者10-12
     * 7-8位：01-09、10-19 、20-29、30、31
     */
    public static final String BIRTHDAY_REGEX = "(18|19|20)?\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d{1}|3[01])";
}
