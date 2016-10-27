package com.zecovery.android.mascotas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.crash.FirebaseCrash;
import com.zecovery.android.mascotas.R;
import com.zecovery.android.mascotas.intro.Intro;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseCrash.log("MainActivity created");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupButtons();
    }

    private void setupButtons() {
        ImageView ivRut = (ImageView) findViewById(R.id.ivRut);
        ImageView ivChip = (ImageView) findViewById(R.id.ivChip);
        ImageView ivQR = (ImageView) findViewById(R.id.ivQR);
        ImageView ivInfo = (ImageView) findViewById(R.id.ivInfo);

        ivRut.setOnClickListener(this);
        ivChip.setOnClickListener(this);
        ivQR.setOnClickListener(this);
        ivInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.ivRut:
                startActivity(new Intent(MainActivity.this, RutActivity.class));
                break;
            case R.id.ivChip:
                startActivity(new Intent(MainActivity.this, ChipActivity.class));
                break;
            case R.id.ivQR:
                startActivity(new Intent(MainActivity.this, QRActivity.class));
                break;
            case R.id.ivInfo:
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
            case R.id.action_intro:
                startActivity(new Intent(MainActivity.this, Intro.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
