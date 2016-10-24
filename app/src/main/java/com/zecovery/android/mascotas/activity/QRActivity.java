package com.zecovery.android.mascotas.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.zecovery.android.mascotas.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRActivity extends BaseActivity implements ZXingScannerView.ResultHandler, View.OnClickListener {

    private ZXingScannerView mScannerView;
    public static final int PERMISSION_REQUEST_CODE = 1;
    private Context context = this;
    private AlertDialog.Builder builder;

    private TextView textViewResult;
    private Button buttonRescan;
    private Button buttonWeb;

    private String qrResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){

            if(checkSelfPermission(Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){
                Log.d(LOG_TAG, "sin permisos de camara");

                requestPermissions(new String[]{Manifest.permission.CAMERA},PERMISSION_REQUEST_CODE);
            }
        }

        textViewResult = (TextView) findViewById(R.id.textViewResult);
        mScannerView = (ZXingScannerView) findViewById(R.id.qrScanner);
        readQr();

        buttonRescan = (Button) findViewById(R.id.buttonRescan);
        buttonWeb =(Button) findViewById(R.id.buttonWeb);

        buttonWeb.setOnClickListener(this);
        buttonRescan.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE: {
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(LOG_TAG, "onRequestPermissionsResult: ");
                } else {
                    Toast.makeText(this, "La camara es necesaria", Toast.LENGTH_SHORT).show();
                }
                return;
            }
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

        textViewResult.setVisibility(View.VISIBLE);
        textViewResult.setText(result.getText());

        qrResult = result.getText();
        /*
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
        alert.show();*/
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buttonRescan:
                textViewResult.setText("");
                mScannerView.resumeCameraPreview((ZXingScannerView.ResultHandler) context);
                break;

            case R.id.buttonWeb:
                if(qrResult!=null){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(URL_REQUEST + qrResult)));
                }else {
                    Log.d(LOG_TAG, "onClick: NO QR");
                }
                break;
        }

    }
}
