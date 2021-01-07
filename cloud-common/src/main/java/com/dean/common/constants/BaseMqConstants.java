package com.dean.common.constants;

public abstract class BaseMqConstants {

    public static final class Exchange {
        /**
         * 用户服务交换机
         */
        public static final String USER_EXCHANGE_NAME = "cloud.user.exchange";

        /**
         * 短信服务交换机
         */
        public static final String SMS_EXCHANGE_NAME = "cloud.sms.exchange";

        /**
         * 购物车服务交换机
         */
        public static final String CARTS_EXCHANGE_NAME = "cloud.order.exchange";
    }

    public static final class RoutingKey {
        /**
         * 用户注册的routing-key
         */
        public static final String USER_REGISTER_KEY = "user.register";
        /**
         * 用户注销的routing-key
         */
        public static final String USER_LOGOUT_KEY = "user.logout";
        /**
         * 发送短信验证码
         */
        public static final String VERIFY_CODE_KEY = "sms.verify.code";

        /**
         * 发送userId及skuId
         */
        public static final String CARTS_DELETE_KEY = "order.delete";
    }

    public static final class Queue{

        public static final String USER_REGISTR = "cloud.user.queue";
        /**
         * 搜索服务，商品上架的队列-添加Es索引库
         */
        public static final String SEARCH_ITEM_UP = "search.item.up.queue";
        /**
         * 搜索服务，商品下架的队列-删除Es索引库
         */
        public static final String SEARCH_ITEM_DOWN = "search.item.down.queue";

        /**
         * 静态页面服务，商品上架的队列-生成静态页
         */
        public static final String PAGE_ITEM_UP = "page.item.up.queue";
        /**
         * 静态页面，商品下架的队列-删除静态页
         */
        public static final String PAGE_ITEM_DOWN = "page.item.down.queue";

        /**
         * 发送短信验证码
         */
        public static final String SMS_VERIFY_CODE_QUEUE = "sms.verify.code.queue";

        /**
         * 删除购物车信息
         */
        public static final String CARTS_DELETE = "order.delete.queue";
    }
}