package com.zecovery.android.mascotas.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;
import com.zecovery.android.mascotas.R;

/**
 * Created by fran on 24-08-16.
 */

public class BaseActivity extends AppCompatActivity {

    public static final String LOG_TAG = ":::LOG:::";
    private FirebaseAnalytics mFirebaseAnalytics;

    //desa dummy
    //public static final String URL_REQUEST = "http://alvaro.desa.exec.cl/moe/REST/Pet/index.php?request=";

    //desa con datos reales
    public static final String URL_REQUEST_RUT = "http://subdere.desa.exec.cl/ws/mascota/busqueda.php?rut=";
    public static final String URL_REQUEST_CHIP = "http://subdere.desa.exec.cl/ws/mascota/busqueda.php?chip=";

    public static final String RESPONSE_STATUS = "status";
    public static final String RESPONSE_STATUS_OK = "OK";
    public static final String RESPONSE_STATUS_404 = "NO ENCOTRADO";

    // tiempo que
    public static final long SPLASH_SCREEN_DELAY = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        FirebaseCrash.log("BaseActivity created");
    }

    public void showProgressDialog(){


    }
}
