package net.apptamm.tamm.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import net.apptamm.tamm.R;
import net.apptamm.tamm.fragments.FragmentSeats;

public class SeatSelection extends AppCompatActivity {
    private Button accept;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seat_selection);
        accept = findViewById(R.id.btn_accept);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_seats, new FragmentSeats()).commit();
            }
        });














    }
}
