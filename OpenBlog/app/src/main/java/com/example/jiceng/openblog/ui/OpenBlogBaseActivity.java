package com.example.jiceng.openblog.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.jiceng.core.AppAction;
import com.example.jiceng.openblog.OpenBlogApplication;
import com.example.jiceng.openblog.R;

/**
 * Created by jichunzeng on 2018/3/22.
 */

public class OpenBlogBaseActivity extends FragmentActivity {
    // 上下文实例
    public Context context;
    // 应用全局的实例
    public OpenBlogApplication application;
    // 核心层的Action实例
    public AppAction appAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_blog_base);
        context = getApplicationContext();
        application = (OpenBlogApplication) this.getApplication();
        appAction = application.getAppAction();

    }
}
