package net.middledleeast.tamm.ActivityToFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.SignInFragment;

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
