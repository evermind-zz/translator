package de.americanstacker.app.translator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private String mUrl = "https://www.deepl.com/de/translator";
    private WebView  mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mWebView.restoreState(savedInstanceState);
        } else {
            mWebView = (WebView) findViewById(R.id.activity_main_webview);
            mWebView.setWebViewClient(new WebViewClient());

            // Enable Javascript
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            mWebView.loadUrl(mUrl);
        }
    }

    // Save the state of the web view when the screen is rotated.
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        mWebView.saveState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if ( null != mWebView )
        {
            mWebView.destroy();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if ( null != mWebView )
        {
            mWebView.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if ( null != mWebView )
        {
            mWebView.onResume();
        }
    }
}