package net.middledleeast.tamm.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

import java.util.Calendar;

public class ChooseBookingDate extends AppCompatActivity {



    private TextView startDate , endDate , nights;
    private DatePickerDialog.OnDateSetListener startDateAdapter;
    private DatePickerDialog.OnDateSetListener endDateAdapter;
    private String date;
    private String endDateR;
    Calendar cal = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    private Button b1 , b2 ;
    long diff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_booking_date);

        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);
        nights = findViewById(R.id.nights);
        b1=findViewById(R.id.book1);
        b2=findViewById(R.id.book2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseBookingDate.this,checkroom.class));
            }
        });




        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ChooseBookingDate.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        startDateAdapter,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });
        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int year = cal2.get(Calendar.YEAR);
                int month = cal2.get(Calendar.MONTH);
                int day = cal2.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ChooseBookingDate.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        endDateAdapter,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });




        startDateAdapter = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                date = month + "/" + day + "/" + year;

                startDate.setText(date);



            }
        };
        endDateAdapter = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
               


                endDateR = month + "/" + day + "/" + year;

                endDate.setText(endDateR);
                nights.setText("" + diff);
            }
        };

         diff =  (( cal2.getTimeInMillis() - cal.getTimeInMillis()) / (1000*60*60*24));
        Log.e("hello", "diffrence : " + diff );

    }
}
