package com.example.jiceng.openblog.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;

import com.example.jiceng.openblog.R;

/**
 *
 *
 */
public class FullscreenActivity extends Activity {


    private VideoView main_videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        main_videoview = (VideoView) findViewById(R.id.main_videoview);
        main_videoview.setVideoURI(Uri.parse("android.resource://com.example.jiceng.openblog/"+R.raw.video));
        main_videoview.start();
        main_videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        main_videoview.stopPlayback();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        main_videoview.start();
    }
}
