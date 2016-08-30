package com.zecovery.android.mascotas.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.zecovery.android.mascotas.R;

/**
 * Created by fran on 24-08-16.
 */

public class BaseActivity extends AppCompatActivity {

    public static final String LOG_TAG = ":::LOG:::";
    public static final String URL_ROOT = "http://alvaro.desa.exec.cl/moe/REST/Pet/index.php";
    public static final String URL_RUT = "http://alvaro.desa.exec.cl/moe/REST/Pet/index.php?rut=";
    public static final String URL_ADDRESS = "http://alvaro.desa.exec.cl/moe/REST/Pet/index.php?direccion=";
    public static final String URL_CHIP = "http://alvaro.desa.exec.cl/moe/REST/Pet/index.php?chip=";

    public static final String RESPONSE_STATUS = "status";

    public static final long SPLASH_SCREEN_DELAY = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


}
