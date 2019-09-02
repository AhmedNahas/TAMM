package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

import java.util.ArrayList;
import java.util.Calendar;

public class PassengerInformation extends AppCompatActivity {
    Spinner mrormiss1,mrormiss2,mrormiss3,nationality1,nationality2,nationality3;
    private TextView dobadult,strtadult,endadult,dobchild,strtchild,endchild,dobinfant,strtinfant,endinfant;
    private DatePickerDialog.OnDateSetListener mDateSetListener,mDateSetListener2,mDateSetListener3,mDateSetListener4,mDateSetListener5,mDateSetListener6,mDateSetListener7,mDateSetListener8,mDateSetListener9;
    ArrayAdapter mrormiss1adapter,mrormiss2adapter,mrormiss3adapter;
    ArrayList<String> mrormiss1array,mrormiss2array,mrormiss3array;
    private Button confirmFlight;

    ImageView iv_booked_passenger_information;


    RelativeLayout relative_back_passenger_information;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_information);


        iv_booked_passenger_information=findViewById(R.id.iv_booked_passenger_information);
        iv_booked_passenger_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(PassengerInformation.this,MyBookActivity.class);
                startActivity(intent);
            }
        });

        relative_back_passenger_information=findViewById(R.id.relative_back_passenger_information);

        relative_back_passenger_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        mrormiss1array = new ArrayList<>();
        mrormiss1array.add(getString(R.string.mr));
        mrormiss1array.add(getString(R.string.mrs));

        mrormiss2array = new ArrayList<>();
        mrormiss2array.add(getString(R.string.mr));
        mrormiss2array.add(getString(R.string.mrs));

        mrormiss3array = new ArrayList<>();
        mrormiss3array.add(getString(R.string.mr));
        mrormiss3array.add(getString(R.string.mrs));

        dobadult= findViewById(R.id.date_of_birth_adult);
        dobchild=findViewById(R.id.date_of_birth_child);
        dobinfant=findViewById(R.id.date_of_birth_infant);

        strtadult=findViewById(R.id.start_date_adult);
        strtchild=findViewById(R.id.start_date_child);
        strtinfant=findViewById(R.id.start_date_infant);

        endadult=findViewById(R.id.end_date_adult);
        endchild=findViewById(R.id.end_date_child);
        endinfant=findViewById(R.id.end_date_infant);



        mrormiss1adapter=new ArrayAdapter(this,R.layout.mrormissspinnerlist
                , mrormiss1array);
        mrormiss1=findViewById(R.id.mrormiss_adult);
        mrormiss1.setSelection(1);
        mrormiss1.setAdapter(mrormiss1adapter);

        mrormiss2adapter=new ArrayAdapter(this,R.layout.mrormissspinnerlist
                , mrormiss2array);

        mrormiss2=findViewById(R.id.mrormiss_child);
        mrormiss2.setSelection(1);
        mrormiss2.setAdapter(mrormiss2adapter);


        mrormiss3adapter=new ArrayAdapter(this,R.layout.mrormissspinnerlist
                , mrormiss3array);
        mrormiss3=findViewById(R.id.mrormiss_infant);
        mrormiss3.setSelection(1);
        mrormiss3.setAdapter(mrormiss3adapter);


        confirmFlight = findViewById(R.id.confirm_flight);
        confirmFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PassengerInformation.this, FlightsSummary.class));
            }
        });




        dobadult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PassengerInformation.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                dobadult.setText(date);
            }
        };

        dobchild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PassengerInformation.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener2,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                dobchild.setText(date);
            }
        };

        dobinfant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PassengerInformation.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener3,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener3 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                dobinfant.setText(date);
            }
        };


        strtadult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PassengerInformation.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener4,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener4 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                strtadult.setText(date);
            }
        };


        endadult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PassengerInformation.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener5,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener5 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                endadult.setText(date);
            }
        };



        strtchild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PassengerInformation.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener6,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener6 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                strtchild.setText(date);
            }
        };


        endchild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PassengerInformation.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener7,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener7 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                endchild.setText(date);
            }
        };

        strtinfant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PassengerInformation.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener8,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener8 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                strtinfant.setText(date);
            }
        };

        endinfant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PassengerInformation.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener9,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener9 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                endinfant.setText(date);
            }
        };












    }
}
