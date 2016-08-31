package com.zecovery.android.mascotas.intro;

import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;

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
        setSwipeLock(true);
        showStatusBar(false);
        setDepthAnimation();
    }
}
