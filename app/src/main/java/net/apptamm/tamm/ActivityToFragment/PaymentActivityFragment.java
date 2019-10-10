package net.apptamm.tamm.ActivityToFragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import net.apptamm.tamm.R;
import net.apptamm.tamm.SignInFragment;

public class PaymentActivityFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_fragment);

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().add(android.R.id.content, new SignInFragment()).commit();

        }


    }
}
