package net.middledleeast.tamm.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import net.middledleeast.tamm.R;

import java.util.ArrayList;

public class ConfirmBookingRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Spinner s1 , s2 , s3;
        ArrayAdapter mrOrMissAdapter;
        ArrayList<String> mrOrMissArray;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking_room);

        mrOrMissArray = new ArrayList<>();
        mrOrMissArray.add("Mr.");
        mrOrMissArray.add("Mrs.");
        mrOrMissAdapter = new ArrayAdapter(this,
                R.layout.mrormissspinnerlist
                , mrOrMissArray);
        s1 = findViewById(R.id.mromiss1);
        s1.setSelection(1);
        s1.setAdapter(mrOrMissAdapter);
        s2 = findViewById(R.id.mromiss2);
        s2.setSelection(1);
        s2.setAdapter(mrOrMissAdapter);
        s3 = findViewById(R.id.mromiss3);
        s3.setSelection(1);
        s3.setAdapter(mrOrMissAdapter);
    }
}
