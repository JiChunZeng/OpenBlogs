package com.example.jiceng.openblog;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            getHome();
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        隐藏标题栏以及状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**标题是属于View的，所以窗口所有的修饰部分被隐藏后标题依然有效,需要去掉标题**/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        handler.sendEmptyMessageDelayed(0,3000);
    }
    public void getHome(){
        startActivity(new Intent(this, FullscreenActivity.class));
        finish();
    }
}
