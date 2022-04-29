package com.daelim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        EditText et_text = findViewById(R.id.et_text);
//        String url = et_text.getText().toString();

        WebView wv_page = findViewById(R.id.wv_page);
        wv_page.setWebViewClient(new WebViewClientClass());
        wv_page.getSettings().setJavaScriptEnabled(true);
        wv_page.loadUrl("http://www.naver.com");
    }

    private class WebViewClientClass extends WebViewClient { //페이지 이동
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl("http://www.naver.com");
            return true;
        }
    }

}