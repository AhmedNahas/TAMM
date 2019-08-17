package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.wirecard.ecom.ui.WebViewActivity;

import net.middledleeast.tamm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KnetActivity extends AppCompatActivity {

    @BindView(R.id.wbv_knet)
    WebView wbvKnet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knet);
        ButterKnife.bind(this);


        wbvKnet.setWebChromeClient(new WebChromeClient());
        wbvKnet.loadUrl("http://egyptgoogle.com/k");

    }
}
