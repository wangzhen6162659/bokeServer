//package com.hengyunsoft.security.auth.cache;
//
//import com.hengyunsoft.cache.KeyGenerator;
//import com.hengyunsoft.cache.RedisHashCache;
//import com.hengyunsoft.security.auth.api.AuthTokenApi;
//import com.hengyunsoft.utils.SpringUtil;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.util.StringJoiner;
//import java.util.function.Supplier;
//
//public class TokenCache extends RedisHashCache<String, String, String> {
//    /**
//     * 业务key
//     */
//    private static final String CACHE_RESOURCE_COLLECTION = "app:token";
//    private static final RedisTemplate<String, String> REDIS_TEMPLATE = SpringUtil.getBean("redisTemplate", RedisTemplate.class);
//
//    private final AuthTokenApi authTokenApi = SpringUtil.getBean(AuthTokenApi.class);
//    private final String appId;
//    private final String appSecret;
//
//    private TokenCache(String appId, String appSecret) {
//        super(() -> REDIS_TEMPLATE);
//        this.appId = appId;
//        this.appSecret = appSecret;
//    }
//
//    @Override
//    protected String key() {
//        return keyGenerator(CACHE_RESOURCE_COLLECTION, appId);
//    }
//
//    @Override
//    protected String field() {
//        return appId;
//    }
//
//    protected String keyGenerator(CharSequence... values) {
//        KeyGenerator bean = SpringUtil.getBean(KeyGenerator.class);
//        if (bean != null) {
//            return new StringJoiner(":")
//                    .add(bean.keyPrefix())
//                    .add("gxqpt-auth-server")
//                    .add(String.join(":", values))
//                    .toString();
//        } else {
//            return String.join(":", values);
//        }
//    }
//
//    @Override
//    protected Supplier<String> getDefaultSupplier() {
//        return () -> authTokenApi.token(appId, appSecret).getData().getToken();
//    }
//
//    public static TokenCache of(String appId, String appSecret ) {
//        return new TokenCache(appId, appSecret);
//    }
//}
