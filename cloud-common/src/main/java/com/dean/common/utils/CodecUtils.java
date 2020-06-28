package com.dean.common.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 * Codec加密工具类
 */
public class CodecUtils {
    /**
     * MD5加密-用于生成不可逆字符串，例如用户唯一标识/密码等
     * @param data
     * @param salt
     * @return
     */
     public static String md5Hex(String data,String salt) {
         if (StringUtils.isBlank(salt)) {
             salt = data.hashCode() + "";
         }
         return DigestUtils.md5Hex(salt + DigestUtils.md5Hex(data));
     }

    /**
     * sha512加密
     * @param data
     * @param salt
     * @return
     */
     public static String shaHex(String data, String salt) {
         if (StringUtils.isBlank(salt)) {
             salt = data.hashCode() + "";
         }
         return DigestUtils.sha512Hex(salt + DigestUtils.sha512Hex(data));
     }

    /**
     * 生成随机盐
     * @return
     */
     public static String generateSalt(){
         return StringUtils.replace(UUID.randomUUID().toString(), "-", "");
     }
}
