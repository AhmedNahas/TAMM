package net.middledleeast.tamm.activities;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

import java.util.ArrayList;
import java.util.Calendar;

public class Passenger_inform extends AppCompatActivity {

    Spinner mrmiss1,mrmiss2,mrmiss3;
    private TextView datebirthadult,datebirthchild,datebirthinfant;
    private DatePickerDialog.OnDateSetListener mDateSetListener1,mDateSetListener2,mDateSetListener3;
    ArrayAdapter mrmiss1adapter,mrmiss2adapter,mrmiss3adapter;
    ArrayList<String> mrmiss1array,mrmiss2array,mrmiss3array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_inform);

        mrmiss1array = new ArrayList<>();
        mrmiss1array.add("Mr.");
        mrmiss1array.add("Mrs.");

        mrmiss2array = new ArrayList<>();
        mrmiss2array.add("Mr.");
        mrmiss2array.add("Mrs.");

        mrmiss3array = new ArrayList<>();
        mrmiss3array.add("Mr.");
        mrmiss3array.add("Mrs.");


        datebirthadult=findViewById(R.id.dob_adult);
        datebirthchild=findViewById(R.id.dob_child);
        datebirthinfant=findViewById(R.id.dob_infant);





        mrmiss1adapter=new ArrayAdapter(this,R.layout.mrormissspinnerlist
                , mrmiss1array);
        mrmiss1=findViewById(R.id.mrmiss_adult);
        mrmiss1.setSelection(1);
        mrmiss1.setAdapter(mrmiss1adapter);

        mrmiss2adapter=new ArrayAdapter(this,R.layout.mrormissspinnerlist
                , mrmiss2array);

        mrmiss2=findViewById(R.id.mrmiss_child);
        mrmiss2.setSelection(1);
        mrmiss2.setAdapter(mrmiss2adapter);


        mrmiss3adapter=new ArrayAdapter(this,R.layout.mrormissspinnerlist
                , mrmiss3array);
        mrmiss3=findViewById(R.id.mrmiss_infant);
        mrmiss3.setSelection(1);
        mrmiss3.setAdapter(mrmiss3adapter);





        datebirthadult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Passenger_inform.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener1,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                datebirthadult.setText(date);
            }
        };


        datebirthchild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Passenger_inform.this,
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
                datebirthchild.setText(date);
            }
        };


        datebirthinfant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Passenger_inform.this,
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
                datebirthinfant.setText(date);
            }
        };





















    }
}
