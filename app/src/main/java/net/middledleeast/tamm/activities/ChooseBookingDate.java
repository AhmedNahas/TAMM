package net.middledleeast.tamm.activities;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import net.middledleeast.tamm.R;

import java.util.Calendar;

public class ChooseBookingDate extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView startDate , endDate , nights;
    private DatePickerDialog.OnDateSetListener startDateAdapter;
    private DatePickerDialog.OnDateSetListener endDateAdapter;
    int date , endDateR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_booking_date);

        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);
        nights = findViewById(R.id.nights);




        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
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
                Calendar cal = Calendar.getInstance();

                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

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
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                date = month + "/" + day + "/" + year;

                startDate.setText(date);

            }
        };
        endDateAdapter = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);


                endDateR = month + "/" + day + "/" + year;

                endDate.setText(endDateR);
            }
        };



    }
}
