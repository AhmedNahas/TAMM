package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
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
import net.middledleeast.tamm.fragments.TammFamilyFragment;

public class Proceedbeybey extends AppCompatActivity {

    private CheckedTextView passenger , jet , one_way , return_passe , multi_cities , royalClass , firstClass , businessClass , economyClass;
    private TextView fromTextView , toTextView;
    private RecyclerView fromToRecycler ;


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
        royalClass=findViewById(R.id.royal_class);
        firstClass=findViewById(R.id.first_class);
        businessClass=findViewById(R.id.business_class);
        economyClass=findViewById(R.id.economy_class);
        fromTextView=findViewById(R.id.country_from_textview);
        toTextView=findViewById(R.id.country_to_textview);
        fromToRecycler=findViewById(R.id.from_to_rV);



        fromTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(Proceedbeybey.this);

            }
        });

        toTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(Proceedbeybey.this);

            }
        });


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
        royalClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    royalClass.setTextColor(0xFFFFFFFF);
                    businessClass.setTextColor(0xFFBE973B);
                    economyClass.setTextColor(0xFFBE973B);
                    firstClass.setTextColor(0xFFBE973B);

                }
                return false;
            }
        });
        firstClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    firstClass.setTextColor(0xFFFFFFFF);
                    royalClass.setTextColor(0xFFBE973B);
                    businessClass.setTextColor(0xFFBE973B);
                    economyClass.setTextColor(0xFFBE973B);

                }
                return false;
            }
        });
        businessClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    businessClass.setTextColor(0xFFFFFFFF);
                    royalClass.setTextColor(0xFFBE973B);
                    firstClass.setTextColor(0xFFBE973B);
                    economyClass.setTextColor(0xFFBE973B);

                }
                return false;
            }
        });
        economyClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    economyClass.setTextColor(0xFFFFFFFF);
                    royalClass.setTextColor(0xFFBE973B);
                    firstClass.setTextColor(0xFFBE973B);
                    businessClass.setTextColor(0xFFBE973B);

                }
                return false;
            }
        });
    }
    public void showDialog(Activity activity){

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);

        final EditText et = dialog.findViewById(R.id.et);

        Button btnok = (Button) dialog.findViewById(R.id.btnok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Proceedbeybey.this, ""+(et.getText().toString()), Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }
        });

           dialog.show();
    }
}

