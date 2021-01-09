package com.dean.auth.controller;

/**
 * @ClassName UrlTest.java
 * @Description UrlTest.java
 * @author yuanh
 * @Date 2020/12/11 12:33
 * @version 1.0
 */
public class UrlTest {
    static int i;

    public static void main(String[] args) {
       String url = "http://yyws2.creditcard.com.cn/wsv2/index/";
        System.out.println(getUrl(url));
    }

    public static String getUrl(String url){
        if(!url.contains("suplementcard")){
            url = url.replace("index","suplementcard");
        }
        return url;
    }
}
