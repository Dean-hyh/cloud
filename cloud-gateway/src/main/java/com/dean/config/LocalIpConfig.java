package com.dean.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取服务所在主机的ip
 * @author Dean.h
 * @version 1.0 2020/6/28
 */
public class LocalIpConfig extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        try {
            // 获取主机IP
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {

        }
        return null;
    }
}