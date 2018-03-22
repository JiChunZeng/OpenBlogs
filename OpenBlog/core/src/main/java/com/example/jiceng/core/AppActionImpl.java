package com.example.jiceng.core;

import android.content.Context;

import com.example.jiceng.api.Api;
import com.example.jiceng.api.ApiImpl;

/**
 * Created by jichunzeng on 2018/3/22.
 * 请求实现示例
 */

public class AppActionImpl implements AppAction {
    private final static int LOGIN_OS = 1; // 表示Android
    private final static int PAGE_SIZE = 20; // 默认每页20条

    private Context context;
    private Api api;

    public AppActionImpl(Context context) {
        this.context = context;
        this.api = new ApiImpl();
    }

    @Override
    public void sendSampCode(String parameter, ActionCallbackListener<Void> listener) {

    }
}
