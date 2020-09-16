package com.dean.test;

import com.netflix.servo.util.VisibleForTesting;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test1
 * @Description Test1
 * @Author yuanh
 * @Date 2020/8/26 18:06
 * @Version 1.0
 */
public class Test1 {
    @Test
    public void demo1(){
        Map<String, Object> map = new HashMap<>();
        String key = "test";
        map.put("test",null);
        System.out.println((String) getMapValue(map, key, "0"));
    }

    public static <T> T getMapValue(Map map, String key, Object def){
        if(null !=map && null != key && map.containsKey(key)){
            return (T) map.get(key);
        }
        return (T)def;
    }

    @Test
    public void test2() throws UnsupportedEncodingException {
        String str = "测"+"u7F5E"+"试";
        System.out.println(str);
    }
}
