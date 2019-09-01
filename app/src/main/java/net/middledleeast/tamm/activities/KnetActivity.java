package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KnetActivity extends AppCompatActivity {

    @BindView(R.id.webview_knet)
    WebView webviewKnet;
    @BindView(R.id.button2)
    Button done;
    private Handler handler;
    private Runnable runnable;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.knet);
        ButterKnife.bind(this);


        WebSettings webSettings = webviewKnet.getSettings();
        webSettings.setJavaScriptEnabled(true);

        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        webviewKnet.setWebViewClient(webViewClient);
        webviewKnet.loadUrl("http://www.egyptgoogle.com/k");


    }

    //
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webviewKnet.canGoBack()) {
            this.webviewKnet.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @OnClick(R.id.button2)
    public void onViewClicked() {




    }


    public class WebViewClientImpl extends WebViewClient {

        private Activity activity = null;

        public WebViewClientImpl(Activity activity) {
            this.activity = activity;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            if (url.indexOf("egyptgoogle.com") > -1) return false;

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            activity.startActivity(intent);
            return true;
        }


    }

}

