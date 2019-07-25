package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FlightDetails extends AppCompatActivity {

    @BindView(R.id.back_to_hotel)
    Button backToHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_details);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back_to_hotel)
    public void onViewClicked() {

        startActivity(new Intent(FlightDetails.this,FindHotels.class));
    }
}
