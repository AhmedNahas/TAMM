package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.fragments.LanguangeFragment;
import net.middledleeast.tamm.fragments.MultiCitiesFlights;
import net.middledleeast.tamm.fragments.ProceedBeyBeyOriginal;
import net.middledleeast.tamm.fragments.ReturnWayFlights;
import net.middledleeast.tamm.fragments.TammFamilyFragment;

public class Proceedbeybey extends AppCompatActivity {

    private CheckedTextView passenger , jet , one_way , return_passe , multi_cities ;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proceedbey_bey);

        passenger=findViewById(R.id.passen_air);
        jet=findViewById(R.id.private_jet);
        one_way=findViewById(R.id.one_way);
        return_passe=findViewById(R.id.return_passe);
        multi_cities=findViewById(R.id.multi_cities);


        getSupportFragmentManager().beginTransaction().replace(R.id.flights_container, new ProceedBeyBeyOriginal())
                .commit();
        passenger.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    passenger.setTextColor(0xFFFFFFFF);
                    jet.setTextColor(0xFFBE973B);
                }
                return false;
            }
        });
        jet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    jet.setTextColor(0xFFFFFFFF);
                    passenger.setTextColor(0xFFBE973B);
                }

                return false;
            }
        });
        one_way.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    one_way.setTextColor(0xFFFFFFFF);
                    return_passe.setTextColor(0xFFBE973B);
                    multi_cities.setTextColor(0xFFBE973B);
                    ProceedBeyBeyOriginal proceedBeyBeyOriginal = new ProceedBeyBeyOriginal();
                    getSupportFragmentManager().beginTransaction().replace(R.id.flights_container, proceedBeyBeyOriginal)
                            .commit();


                }
                return false;
            }
        });
        return_passe.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    return_passe.setTextColor(0xFFFFFFFF);
                    one_way.setTextColor(0xFFBE973B);
                    multi_cities.setTextColor(0xFFBE973B);
                    getSupportFragmentManager().beginTransaction().replace(R.id.flights_container, new ReturnWayFlights())
                            .commit();


                }
                return false;
            }
        });
        multi_cities.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    multi_cities.setTextColor(0xFFFFFFFF);
                    one_way.setTextColor(0xFFBE973B);
                    return_passe.setTextColor(0xFFBE973B);

                    MultiCitiesFlights multiCitiesFlights = new MultiCitiesFlights();
                    getSupportFragmentManager().beginTransaction().replace(R.id.flights_container, multiCitiesFlights)
                            .commit();



                }
                return false;
            }
        });

    }

}

