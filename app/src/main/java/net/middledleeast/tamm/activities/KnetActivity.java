package net.middledleeast.tamm.activities;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KnetActivity extends AppCompatActivity {

    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.webview_knet)
    WebView webviewKnet;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.knet);
        ButterKnife.bind(this);



        webviewKnet.getSettings().setJavaScriptEnabled(true);
        webviewKnet.loadUrl("http://egyptgoogle.com/k");


//        txtDay=findViewById(R.id.day);
//                txtHour=findViewById(R.id.hour);
//        txtMinute=findViewById(R.id.minute);
//                txtSecond=findViewById(R.id.second);
//        txtmonth=findViewById(R.id.month);

//                countDownStart();
    }

//
//    public void countDownStart() {
//        handler = new Handler();
//        runnable = new Runnable() {
//            @Override
//            public void run() {
//                handler.postDelayed(this, 1000);
//                try {
//
//                    // Please here set your event date//YYYY-MM-DD
//                    Calendar calendar = Calendar.getInstance();
//                    calendar.add(Calendar.YEAR,1);
//                    Date futureDate = calendar.getTime();
//                    String dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(futureDate);
//
//
//
//
//                    Date currentDate = new Date();
//                    if (!currentDate.after(futureDate)) {
//                        long diff = futureDate.getTime()
//                                - currentDate.getTime();
//                        long days = diff / (24 * 60 * 60 * 1000);
//                        diff -= days * (24 * 60 * 60 * 1000);
//                        long hours = diff / (60 * 60 * 1000);
//                        diff -= hours * (60 * 60 * 1000);
//                        long minutes = diff / (60 * 1000);
//                        diff -= minutes * (60 * 1000);
//                        long seconds = diff / 1000;
////                        txtmonth.setText("" + String.format("%02d", months));
//                        txtDay.setText("" + String.format("%02d", days));
//                        txtHour.setText("" + String.format("%02d", hours));
//                        txtMinute.setText(""
//                                + String.format("%02d", minutes));
//                        txtSecond.setText(""
//                                + String.format("%02d", seconds));
//                    } else {
//
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        handler.postDelayed(runnable, 1 * 1000);
//    }
}