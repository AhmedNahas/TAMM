package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KnetActivity extends AppCompatActivity {

    @BindView(R.id.webview_knet)
    WebView webviewKnet;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.knet);
        ButterKnife.bind(this);

        webviewKnet.setWebViewClient(new MyWebViewClient());
        String url = "http://www.egyptgoogle.com/k";
        webviewKnet.getSettings().setJavaScriptEnabled(true);
        webviewKnet.loadUrl(url); // load a web page in a web view


    }



    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (url.contains("CAPTURED"))
            {
                startActivity(new Intent(KnetActivity.this, RoomBooked.class));

            }else{

                Toast.makeText(KnetActivity.this, "Failed Unknown Error() 2145012114(Json)  ", Toast.LENGTH_SHORT).show();

            }
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

