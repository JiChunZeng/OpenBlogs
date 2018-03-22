package com.example.jiceng.core;

/**
 * Created by jichunzeng on 2018/3/22.
 * 核心层处于接口层和界面层之间，向下调用Api，向上提供Action，它的核心任务就是处理复杂的业务逻辑
 */

public interface AppAction {
    // 请求示例
    public void sendSampCode(String parameter, ActionCallbackListener<Void> listener);
}
