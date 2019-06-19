package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.model.ReserveRoom;

public class FlightsOrHotels extends AppCompatActivity {

    ImageView img1 , img2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flightsorhotels);

        img2 = findViewById(R.id.imageView10);
        img1 = findViewById(R.id.imageView9);

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FlightsOrHotels.this, ReserveRoom.class);
                startActivity(intent);
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FlightsOrHotels.this,FlightTamm.class));
            }
        });
    }
}
