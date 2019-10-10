package net.apptamm.tamm.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import net.apptamm.tamm.R;
import net.apptamm.tamm.fragments.TammFamilyFragment;
import net.apptamm.tamm.sevice.MyService;

import java.util.Date;

public class WelcomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    private Date currentDate;

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



        toolbar = findViewById(R.id.welcome_toolbar);
        setSupportActionBar(toolbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.welcome_container, new TammFamilyFragment())
                .commit();
    }
}
