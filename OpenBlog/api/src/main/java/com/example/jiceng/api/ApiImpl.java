package com.example.jiceng.api;

/**
 * Created by jichunzeng on 2018/3/22.
 * 请求实现类基础类
 */

public class ApiImpl implements Api {
    private final static String APP_KEY = "ANDROID_KCOUPON";
    private final static String TIME_OUT_EVENT = "CONNECT_TIME_OUT";
    private final static String TIME_OUT_EVENT_MSG = "连接服务器失败";
    // http引擎
    private HttpEngine httpEngine;

    public ApiImpl() {
        httpEngine = HttpEngine.getInstance();
    }


    @Override
    public ApiResponse<Void> sendSampleCode(String parameter) {
        return null;
    }
}
