package net.middledleeast.tamm.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import net.middledleeast.tamm.R;

import java.util.ArrayList;

public class PassengerInformation extends AppCompatActivity {
    Spinner mrormiss;
    ArrayAdapter mrormissadapter;
    ArrayList<String> mrormissarray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_information);
        mrormissarray = new ArrayList<>();
        mrormissarray.add("Mr.");
        mrormissarray.add("Mrs.");




    }
}
