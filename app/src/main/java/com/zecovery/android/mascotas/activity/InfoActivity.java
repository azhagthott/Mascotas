package com.zecovery.android.mascotas.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.crash.FirebaseCrash;
import com.zecovery.android.mascotas.R;

public class InfoActivity extends AppCompatActivity {

    private WebView mWebView;
    private static final String URL_PERRY_GATTY = "http://www.defensoresdemascotas.cl/";
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FirebaseCrash.log("InfoActivity created");

        mWebView= (WebView) findViewById(R.id.webView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        initWebView(URL_PERRY_GATTY,true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initWebView(final String url, boolean js){

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(js);
        mProgressBar.setIndeterminate(true);
        mWebView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                    mProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Toast.makeText(InfoActivity.this, "some error!!!!!", Toast.LENGTH_SHORT).show();
            }
        });
        mWebView.loadUrl(url);
    }
}