package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;
    private AnimatedCircleLoadingView animatedCircleLoadingView;
    private String mUsrename;
    int count = 0;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.img_splash_logo);




//        SharedPreferencesManger.clean(this);


//        String mUsrename =    SharedPreferencesManger.LoadStringData(this, "user_name" );
        mUsrename = SharedPreferencesManger.LoadStringData(this, "userNameFromSignIn");


        if (mUsrename != null && mUsrename.length() > 3) {
            animatedCircleLoadingView = (AnimatedCircleLoadingView) findViewById(R.id.circle_loading_view);
            startLoading();
            startPercentMockThread();


            imageView = findViewById(R.id.img_splash_logo);

            Animation animation = AnimationUtils.loadAnimation(this, R.anim.logo_splash_anim);
            imageView.setAnimation(animation);


            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    startActivity(new Intent(SplashActivity.this, RenewAccount.class));
                }
            }, 5000);
        } else {
            animatedCircleLoadingView = (AnimatedCircleLoadingView) findViewById(R.id.circle_loading_view);
            startLoading();
            startPercentMockThread();

            imageView = findViewById(R.id.img_splash_logo);

            Animation animation = AnimationUtils.loadAnimation(this, R.anim.logo_splash_anim);
            imageView.setAnimation(animation);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
                    finish();
                }
            }, 5000);

        }


    }


    private void startLoading() {
        animatedCircleLoadingView.startDeterminate();
    }

    private void startPercentMockThread() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(35);
                        changePercent(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();
    }

    private void changePercent(final int percent) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                animatedCircleLoadingView.setPercent(percent);
            }
        });
    }

    public void resetLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                animatedCircleLoadingView.resetLoading();
            }
        });
    }


}
