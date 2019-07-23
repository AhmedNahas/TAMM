package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

public class PaymentFlights extends AppCompatActivity {
Button proceed_check_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_flights);

        proceed_check_out=findViewById(R.id.proceed_check_out_flight);

        proceed_check_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentFlights.this,FlightDetails.class));
            }
        });
    }
}
