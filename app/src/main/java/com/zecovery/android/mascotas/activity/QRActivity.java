package com.zecovery.android.mascotas.activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.zxing.Result;
import com.zecovery.android.mascotas.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRActivity extends BaseActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    public static final int PERMISSIONS_REQUEST_CAMERA = 1;
    private Context context = this;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){
                Log.d(LOG_TAG, "es M sin permisos");

                if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA)){
                    Log.d(LOG_TAG, "pide permisos para usar camara");
                }else{
                    Log.d(LOG_TAG, "que paso?");
                }

            }
        }

        mScannerView = (ZXingScannerView) findViewById(R.id.qrScanner);
        readQr();

                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void readQr(){
        Log.d(LOG_TAG, "readQr");

        if(mScannerView.isEnabled()){
            mScannerView.setResultHandler(this);
        }else {
            mScannerView.startCamera();
            mScannerView.setResultHandler(this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        readQr();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mScannerView.stopCamera();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mScannerView.startCamera();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    public void handleResult(final Result result) {

        Log.d(LOG_TAG, "handleResult: " + result.getText());
        Log.d(LOG_TAG, "handleResult: " + result.getBarcodeFormat());

        builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.qr_alert_message);
        builder.setMessage(result.getText());

        builder.setPositiveButton(R.string.qr_alert_message_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(URL_REQUEST + result.getText())));
            }
        });

        builder.setNegativeButton(R.string.qr_alert_message_nok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //***********************
                mScannerView.resumeCameraPreview((ZXingScannerView.ResultHandler) context);
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
