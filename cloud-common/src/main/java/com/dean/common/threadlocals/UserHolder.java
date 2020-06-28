package com.dean.common.threadlocals;

/**
 * @author Dean.h
 * @version 1.0 2020/6/28
 * ThreadLocal工具类
 */
public class UserHolder {
    /**
     * threadLocal中存入登录者的id
     */
    private static final ThreadLocal TL = new ThreadLocal();

    /**
     * 给threadlocal绑定用户数据
     * @param userId
     */
    public static void setUserId(Long userId){
        TL.set(userId);
    }

    /**
     * 对外提供获取数据的接口
     * @return
     */
    public static Object getUserId(){
       return TL.get();
    }

    /**
     * 移除用户信息
     * <p>
     *     ThreadLocal线程局部(私有)变量，ThreadLocal的弱引用作为key，如果gc想要回收的时候，ThreadLcoal必然回收，
     *     Thread ref -> Thread ->ThreadLocalMap->Entry->value这个强引用一直就会存在，造成内存泄漏，所以在使
     *     用之后要移除存储的内容
     * </p>
     */
    public static void removeUserId(){
        TL.remove();
    }
}
