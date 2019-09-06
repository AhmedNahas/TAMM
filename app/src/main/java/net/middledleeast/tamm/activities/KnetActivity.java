package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KnetActivity extends AppCompatActivity  implements View.OnClickListener{

    @BindView(R.id.webview_knet)
    WebView webviewKnet;
    @BindView(R.id.loadWebPage)
    Button loadWebPage;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.knet);
        ButterKnife.bind(this);


        loadWebPage.setOnClickListener(this);
        webviewKnet.setWebViewClient(new MyWebViewClient());
        String url = "http://www.egyptgoogle.com/k";
        webviewKnet.getSettings().setJavaScriptEnabled(true);
        webviewKnet.loadUrl(url); // load a web page in a web view


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loadWebPage:

                break;
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

}
//        WebSettings webSettings = webviewKnet.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
//        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
//        webviewKnet.setWebViewClient(webViewClient);
////        webviewKnet.loadUrl("http://www.egyptgoogle.com/k");
//        webviewKnet.loadUrl(LinksUrl.URL_KNET);
//
//    }
//
//    //
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webviewKnet.canGoBack()) {
//            this.webviewKnet.goBack();
//            return true;
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }
//
//    @OnClick(R.id.loadWebPage)
//    public void onViewClicked() {
//    }
//
//
//    public class WebViewClientImpl extends WebViewClient {
//
//        private Activity activity = null;
//
//        public WebViewClientImpl(Activity activity) {
//            this.activity = activity;
//        }
//
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
//            if (url.indexOf("egyptgoogle.com") > -1) return false;
//
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//            activity.startActivity(intent);
//            return true;
//        }




}

