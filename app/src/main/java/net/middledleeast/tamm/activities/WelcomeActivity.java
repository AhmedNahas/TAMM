package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.fragments.LanguangeFragment;
import net.middledleeast.tamm.sevice.MyService;

public class WelcomeActivity extends AppCompatActivity {

    Toolbar toolbar;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Intent intent = new Intent(WelcomeActivity.this, MyService.class);
                startService(intent);
                return null;
            }
        }.execute();


//        toolbar = findViewById(R.id.welcome_toolbar);
        setSupportActionBar(toolbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.welcome_container, new LanguangeFragment())
                .commit();
    }
}
