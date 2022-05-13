package com.daelim;

import static android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class WebActivity extends AppCompatActivity {

    private WebView wv_page;
    private String url = "";
    private EditText et_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        et_text = findViewById(R.id.et_text);
        et_text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                switch (i) {
                    case EditorInfo.IME_ACTION_SEARCH:
                        url = et_text.getText().toString();
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
        wv_page = findViewById(R.id.wv_page);
        wv_page.setWebViewClient(new WebViewClientClass());
        wv_page.getSettings().setJavaScriptEnabled(true);
        wv_page.loadUrl(url);
    }

    private class WebViewClientClass extends WebViewClient { //페이지 이동
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}