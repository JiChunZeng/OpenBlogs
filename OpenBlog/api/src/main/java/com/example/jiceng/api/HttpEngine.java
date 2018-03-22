package com.example.jiceng.api;

/**
 * Created by jichunzeng on 2018/3/22.
 * http请求引擎
 */

public class HttpEngine {
    private final static String SERVER_URL = "http://192.168.1.1";
    private final static String REQUEST_MOTHOD = "POST";
    private final static String ENCODE_TYPE = "UTF-8";
    private final static int TIME_OUT = 15000;

    private static HttpEngine instance = null;

    private HttpEngine() {
    }

    public static HttpEngine getInstance() {
        if (instance == null) {
            instance = new HttpEngine();
        }
        return instance;
    }
}
