package net.middledleeast.tamm.activities;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;

        import androidx.appcompat.app.AppCompatActivity;

        import net.middledleeast.tamm.R;

public class PaymentFlights extends AppCompatActivity {
    Button proceed_check_out;

    ImageView iv_back_payment_flight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_flights);

        iv_back_payment_flight=findViewById(R.id.iv_back_payment_flight);
        iv_back_payment_flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        proceed_check_out=findViewById(R.id.proceed_check_out_flight);



        proceed_check_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentFlights.this,FlightDetails.class));
            }
        });
    }
}
