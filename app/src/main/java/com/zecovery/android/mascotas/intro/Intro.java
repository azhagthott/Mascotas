package com.zecovery.android.mascotas.intro;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.github.paolorotolo.appintro.AppIntro;
import com.zecovery.android.mascotas.activity.MainActivity;

/**
 * Created by francisco on 30-08-16.
 */

public class Intro extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(new FirstFragment());
        addSlide(new SecondFragment());
        addSlide(new ThirdFragment());
        addSlide(new FourthFragment());

        showSkipButton(false);
        setSwipeLock(false);
        showStatusBar(false);
        //setDepthAnimation();
        setFadeAnimation();
    }

    private void loadMainActivity() {
        Intent intent = new Intent(Intro.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        loadMainActivity();
        finish();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(Intro.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                askForPermissions(new String[]{Manifest.permission.CAMERA}, 3);
            }
        }
    }
}
