package com.dean.filter;

import com.dean.common.auth.utils.RsaUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.security.PublicKey;

/**
 * 配置文件读取类
 * @author Dean
 * @version 1.0
 * @date 2019/8/12 21:41
 */
@ConfigurationProperties(prefix = "dean.jwt")
public class JwtProperties implements InitializingBean {
    private String pubKeyPath;
    private PublicKey publicKey;

    public String getPubKeyPath() {
        return pubKeyPath;
    }

    public void setPubKeyPath(String pubKeyPath) {
        this.pubKeyPath = pubKeyPath;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public UserTokenProperties getUser() {
        return user;
    }

    public void setUser(UserTokenProperties user) {
        this.user = user;
    }

    private UserTokenProperties user = new UserTokenProperties();

    public class UserTokenProperties{
        private String cookieName;

        public String getCookieName() {
            return cookieName;
        }

        public void setCookieName(String cookieName) {
            this.cookieName = cookieName;
        }
    }

    /**
     * 初始化
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        //获取公钥
        try {
            publicKey = RsaUtils.getPublicKey(pubKeyPath);
        }catch (Exception e){
            //log.error("获取公钥失败",e);
            throw new RuntimeException(e);
        }

    }
}
