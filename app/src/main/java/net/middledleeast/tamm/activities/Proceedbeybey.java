package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckedTextView;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.fragments.TammFamilyFragment;

public class Proceedbeybey extends AppCompatActivity {

    CheckedTextView passenger , jet , one_way , return_passe , multi_cities;



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

               }
               return false;
           }
       });
    }
}
