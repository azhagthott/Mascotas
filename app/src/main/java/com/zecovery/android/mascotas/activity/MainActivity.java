package com.zecovery.android.mascotas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.zecovery.android.mascotas.R;
import com.zecovery.android.mascotas.intro.Intro;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupButtons();
    }

    private void setupButtons() {
        ImageView imageViewRut = (ImageView) findViewById(R.id.imageViewRut);
        ImageView imageViewAddress = (ImageView) findViewById(R.id.imageViewAddress);
        ImageView imageViewChip = (ImageView) findViewById(R.id.imageViewChip);
        ImageView imageViewQR = (ImageView) findViewById(R.id.imageViewQR);

        imageViewRut.setOnClickListener(this);
        imageViewAddress.setOnClickListener(this);
        imageViewChip.setOnClickListener(this);
        imageViewQR.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageViewRut:
                startActivity(new Intent(MainActivity.this, RutActivity.class));
                break;
            case R.id.imageViewAddress:
                startActivity(new Intent(MainActivity.this, AddressActivity.class));
                break;
            case R.id.imageViewQR:
                startActivity(new Intent(MainActivity.this, QRActivity.class));
                break;
            case R.id.imageViewChip:
                startActivity(new Intent(MainActivity.this, ChipActivity.class));
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
