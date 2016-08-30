package com.zecovery.android.mascotas.activity;

import android.content.Intent;
import android.os.Bundle;

import com.zecovery.android.mascotas.R;

import java.util.Timer;
import java.util.TimerTask;

public class LaunchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
