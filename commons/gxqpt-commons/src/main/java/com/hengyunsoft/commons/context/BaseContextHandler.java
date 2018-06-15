package com.hengyunsoft.commons.context;

import com.hengyunsoft.commons.utils.StringHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tyh
 * @createTime 2017-12-13 16:52
 */
public class BaseContextHandler {
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        return map.get(key);
    }


    /**
     * 获取用户id
     * @return
     */
    public static Long getAdminId() {
        Object value = get(CommonConstants.CONTEXT_KEY_ADMIN_ID);
        if (value != null && !"".equals(value)) {
            try {
                return Long.valueOf(value.toString());
            } catch (Exception e) {
                return -1L;
            }
        }
        return -1L;
    }

    /** 用户昵称 */
    public static String getName() {
        Object value = get(CommonConstants.CONTEXT_KEY_NAME);
        return returnObjectValue(value);
    }

    /**
     * appName
     * @return
     */
    public static String getAppName() {
        Object value = get(CommonConstants.CONTEXT_KEY_APP_NAME);
        return StringHelper.getObjectValue(value);
    }

    /**
     * 获取应用id
     * @return
     */
    public static String getAppId() {
        Object value = get(CommonConstants.CONTEXT_KEY_APP_ID);
        return StringHelper.getObjectValue(value);
    }

    //public static Long getOrgId() {
    //    Object value = get(CommonConstants.CONTEXT_KEY_ORG_ID);
    //    if (value != null && !"".equals(value)) {
    //        try {
    //            return Long.valueOf(value.toString());
    //        } catch (Exception e) {
    //            return -1L;
    //        }
    //    }
    //    return -1L;
    //}

    public static String getToken() {
        Object value = get(CommonConstants.CONTEXT_KEY_APP_TOKEN);
        return StringHelper.getObjectValue(value);
    }

    public static void setToken(String token) {
        set(CommonConstants.CONTEXT_KEY_APP_TOKEN, token);
    }

    /**
     * 设置昵称
     * @param name
     */
    public static void setAppName(String name) {
        set(CommonConstants.CONTEXT_KEY_APP_NAME, name);
    }

    /**
     * 设置用户id
     * @param adminId
     */
    public static void setAdminId(Long adminId) {
        set(CommonConstants.CONTEXT_KEY_ADMIN_ID, adminId);
    }

    public static void setName(String userName) {
        set(CommonConstants.CONTEXT_KEY_NAME, userName);
    }

    /**
     * 设置应用id
     * @param appId
     */
    public static void setAppId(String appId) {
        set(CommonConstants.CONTEXT_KEY_APP_ID, appId);
    }

    private static String returnObjectValue(Object value) {
        return value == null ? null : value.toString();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
