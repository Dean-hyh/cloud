package com.dean.common.utils;

import com.dean.common.utils.constants.BaseRegexPatterns;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 * 正则校验工具类
 */
public class RegexUtils {
    /**
     * 手机号码格式校验
     * @param phone 手机号(大陆地区11位手机号)
     * @return 校验结果
     */
    public static boolean isPhone(String phone){
        return matches(phone, BaseRegexPatterns.PHONE_REGEX);
    }
    /**
     * 邮箱格式校验
     * @param email 要校验的邮箱
     * @return true:符合，false：不符合
     */
    public static boolean isEmail(String email){
        return matches(email, BaseRegexPatterns.EMAIL_REGEX);
    }

    /**
     * 18位身份证证件号校验
     * @param idNo 证件号（大陆地区18位身份证）
     * @return 校验结果
     */
    public static boolean isIdNo(String idNo){
        Character[] varArray = new Character[18];
        char[] ch = idNo.toCharArray();
        if (idNo.length() != 18) {
            return false;
        }

        for (int i = 0; i < idNo.length(); i++) {
            varArray[i] = idNo.charAt(i);
            boolean isValid = (varArray[i] < '0' || varArray[i] > '9') && (i != 17);
            if (isValid) {
                return false;
            }
        }
        final boolean verify = verify(ch);
        return verify && matches(idNo, BaseRegexPatterns.ID_NO_REGEX) && matches(idNo.substring(6,14), BaseRegexPatterns.BIRTHDAY_REGEX);
    }

    /**
     * 用户名合规校验
     * @param userName 用户名
     * @return 校验结果
     */
    public static boolean isValidUserName(String userName){
        return matches(userName, BaseRegexPatterns.USERNAME_REGEX);
    }

    /**
     * 校验方法
     * @param str 被校验内容
     * @param regex 校验规则
     * @return 校验结果
     */
    private static boolean matches(String str, String regex) {
        return !StringUtils.isBlank(str) && str.matches(regex);
    }

    /**
     * 证件号末位（校验码）校验
     * @param id
     * @return
     */
    public static boolean verify(char[] id) {
        int sum = 0;
        int w[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
        char[] ch = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
        for (int i = 0; i < id.length - 1; i++) {
            sum += (id[i] - '0') * w[i];
        }
        int c = sum % 11;
        char code = ch[c];
        char last = id[id.length - 1];
        last = last == 'x' ? 'X' : last;
        return last == code;
    }
}
