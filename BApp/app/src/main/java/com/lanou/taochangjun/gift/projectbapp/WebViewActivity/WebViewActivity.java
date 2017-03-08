package com.lanou.taochangjun.gift.projectbapp.WebViewActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.lanou.taochangjun.gift.projectbapp.R;

// 扫码用的界面  张德鹏
public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wev_view);

        TextView textView = (TextView) findViewById(R.id.activity_wev_textview);

        Intent intent = getIntent();
        String uri = intent.getStringExtra("webView");

        textView .setText("扫描结果是...."+uri);

        WebView webView = (WebView) findViewById(R.id.activity_webView_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(uri);
        webView.setWebViewClient( new WebViewClient());



    }
}
