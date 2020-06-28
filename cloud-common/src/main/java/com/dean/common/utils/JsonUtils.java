package com.dean.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 * Json解析工具类
 */
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("json序列化出错：" + obj, e);
            return null;
        }
    }

    public static <T> T toBean(String json, Class<T> tClass) {
        try {
            return OBJECT_MAPPER.readValue(json, tClass);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <E> List<E> toList(String json, Class<E> eClass) {
        try {
            return OBJECT_MAPPER.readValue(json, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <K, V> Map<K, V> toMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return OBJECT_MAPPER.readValue(json, OBJECT_MAPPER.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return OBJECT_MAPPER.readValue(json, type);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    static class User{
        private String name;
        private int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


    public static void main(String[] args) {
        //序列化  bean -> json
        User jack = new User("jack", 20);
        String jsonStr = toString(jack);
        System.out.println(jsonStr);
        //序列化  list -> json
        List<User> users = Arrays.asList(jack, new User("rose", 19));
        jsonStr = toString(users);
        System.out.println(jsonStr);
        //反序列化
        String json = "{\"name\":\"jack\",\"age\":20}";
        User jackClass = toBean(json, User.class);
        System.out.println("user="+jackClass);

        String jsons = "[{\"name\":\"jack\",\"age\":20},{\"name\":\"rose\",\"age\":19}]";
        List<User> users1 = toList(jsons, User.class);
        System.out.println("userlist = "+users1);

        String mapJsons = "{\"65\":[{\"name\":\"jack\",\"age\":20},{\"name\":\"rose\",\"age\":19}],\"66\":[{\"name\":\"jack\",\"age\":20},{\"name\":\"rose\",\"age\":19}]}";

        Map<String, List<User>> stringListMap = nativeRead(mapJsons, new TypeReference<Map<String, List<User>>>() {});
        System.out.println(stringListMap);

    }

}
