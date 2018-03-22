package com.example.jiceng.openblog;

import android.app.Application;

import com.example.jiceng.core.AppAction;
import com.example.jiceng.core.AppActionImpl;

/**
 * Created by jichunzeng on 2018/3/22.
 */

public class OpenBlogApplication extends Application {
    private AppAction appAction;

    @Override
    public void onCreate() {
        super.onCreate();
        appAction = new AppActionImpl(this);
    }

    public AppAction getAppAction() {
        return appAction;
    }
}
