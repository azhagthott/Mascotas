package com.zecovery.android.mascotas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.albinmathew.transitions.ActivityTransitionLauncher;
import com.zecovery.android.mascotas.R;

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
        ImageView buttonRut = (ImageView) findViewById(R.id.buttonRut);
        Button buttonAddress = (Button) findViewById(R.id.buttonAddress);
        Button buttonQr = (Button) findViewById(R.id.buttonQr);
        Button buttonChip = (Button) findViewById(R.id.buttonChip);

        buttonRut.setOnClickListener(this);
        buttonAddress.setOnClickListener(this);
        buttonQr.setOnClickListener(this);
        buttonChip.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonRut:

                final Intent intent = new Intent(MainActivity.this, RutActivity.class);
                ActivityTransitionLauncher.with(MainActivity.this).from(view).launch(intent);

                //startActivity(new Intent(MainActivity.this, RutActivity.class));
                break;
            case R.id.buttonAddress:
                startActivity(new Intent(MainActivity.this, AddressActivity.class));
                break;
            case R.id.buttonQr:
                startActivity(new Intent(MainActivity.this, QRActivity.class));
                break;
            case R.id.buttonChip:
                startActivity(new Intent(MainActivity.this, ChipActivity.class));
                break;
        }
    }
}
