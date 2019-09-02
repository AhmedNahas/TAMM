package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FlightDetails extends AppCompatActivity {

    @BindView(R.id.back_to_hotel)
    Button backToHotel;

    ImageView iv_booked_flight_details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_details);
        ButterKnife.bind(this);


        iv_booked_flight_details=findViewById(R.id.iv_booked_flight_details);
        iv_booked_flight_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(FlightDetails.this,MyBookActivity.class);
                startActivity(intent);
            }
        });



    }

    @OnClick(R.id.back_to_hotel)
    public void onViewClicked() {

        startActivity(new Intent(FlightDetails.this,FindHotels.class));
    }
}
