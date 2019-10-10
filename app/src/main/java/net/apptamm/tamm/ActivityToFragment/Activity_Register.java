package net.apptamm.tamm.ActivityToFragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import net.apptamm.tamm.R;
import net.apptamm.tamm.fragments.PlansFragment;

public class Activity_Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__register);

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().add(R.id.welcome_container, new PlansFragment()).commit();

        }


    }
}
