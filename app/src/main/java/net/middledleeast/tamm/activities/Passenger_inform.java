
package net.middledleeast.tamm.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.FlightsSummary;
import net.middledleeast.tamm.activities.MyBookActivity;
import net.middledleeast.tamm.adapters.AutoCompleteAdapter;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import FlightApi.SearchFlightsResponse;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Passenger_inform extends AppCompatActivity {

    @BindView(R.id.ed_first_name)
    EditText edFirstName;
    @BindView(R.id.ed_last_name)
    EditText edLastName;
    @BindView(R.id.ed_first_name_child)
    EditText edFirstNameChild;
    @BindView(R.id.ed_last_name_child)
    EditText edLastNameChild;
    @BindView(R.id.ed_first_name_infant)
    EditText edFirstNameInfant;
    @BindView(R.id.ed_last_name_infant)
    EditText edLastNameInfant;
    private TextView datebirthadult, datebirthchild, datebirthinfant;
    private DatePickerDialog.OnDateSetListener mDateSetListener1, mDateSetListener2, mDateSetListener3;
    ArrayAdapter mrmiss1adapter, mrmiss2adapter, mrmiss3adapter;
    ArrayList<String> mrmiss1array, mrmiss2array, mrmiss3array;
    Button confirm;

    AutoCompleteTextView nationality_adult, nationality_child, nationality_adult_infant;
    Spinner mrmisAdult, mrmisChild, mrmisinfent;
    private boolean notFailed;
    private InputStream inputStream;
    private List<String> list_nationalites = new ArrayList<>();
    private String MDataMrmisAdult   ,  MDataMrmisChild  ,MDataMrmisInfent;

    RelativeLayout relative_back_passenger_inform;
    ImageView iv_booked_passenger_inform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_inform);
        ButterKnife.bind(this);









        iv_booked_passenger_inform=findViewById(R.id.iv_booked_passenger_inform);
        iv_booked_passenger_inform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Passenger_inform.this, MyBookActivity.class);
                startActivity(intent);
            }
        });

        relative_back_passenger_inform=findViewById(R.id.relative_back_passenger_inform);
        relative_back_passenger_inform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        nationality_adult = findViewById(R.id.nationality_adult);
        nationality_child = findViewById(R.id.nationality_child);
        nationality_adult_infant = findViewById(R.id.nationality_adult_infant);
        datebirthadult = findViewById(R.id.date_of_birth_adult);
        datebirthchild = findViewById(R.id.date_of_birth_child);
        datebirthinfant = findViewById(R.id.date_of_birth_adult_infant);
//
        confirm = findViewById(R.id.passenger_btn_info);
        mrmisAdult = findViewById(R.id.mromiss);
        mrmisChild = findViewById(R.id.mromiss_child);
        mrmisinfent = findViewById(R.id.mromiss_infant);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (edFirstName.getText().toString().equals("")){
                    edFirstName.setError("Invalid First Name");

                }else if (edLastName.getText().toString().equals("")){

                    edLastName.setError("Invalid Last Name");
//                }else if (edFirstNameChild.getText().toString().equals("")) {
//                    edFirstNameChild.setError("Invalid First Name");
//
//                }else if (edLastNameChild.getText().toString().equals("")){
//
//                    edLastNameChild.setError("Invalid Last Name");
//                }else if (edFirstNameInfant.getText().toString().equals("")) {
//                    edFirstNameInfant.setError("Invalid First Name");
//
//                }else if (edLastNameInfant.getText().toString().equals("")) {
//
//                    edLastNameInfant.setError("Invalid Last Name");

                }else if (datebirthadult.getText().toString().equals("DD-MM-YYYY")) {
                    Toast.makeText(Passenger_inform.this, "Invalid DOB", Toast.LENGTH_SHORT).show();
//
//                }else if (datebirthchild.getText().toString().equals("DD-MM-YYYY")) {
//                    Toast.makeText(Passenger_inform.this, "Invalid DOB", Toast.LENGTH_SHORT).show();
//
//                }else if (datebirthinfant.getText().toString().equals("DD-MM-YYYY")) {
//
//                    Toast.makeText(Passenger_inform.this, "Invalid DOB", Toast.LENGTH_SHORT).show();



                    }else if (nationality_adult.getText().toString().equals("")){
                    nationality_adult.setError("Invalid Nationality");

//                }else if (nationality_child.getText().toString().equals("")){
//                    nationality_child.setError("Invalid Nationality");
//
//                }else if (nationality_adult_infant.getText().toString().equals("")){
//                    nationality_adult_infant.setError("Invalid Nationality");


                }else {


                    SharedPreferencesManger.SaveData(Passenger_inform.this,"MDataMrmisAdult",MDataMrmisAdult);
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"MDataMrmisChild",MDataMrmisChild);
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"MDataMrmisInfent",MDataMrmisInfent);

                    //first
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"FirstNameAduld",edFirstName.getText().toString());
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"FirstNameChild",edFirstNameChild.getText().toString());
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"FirstNameInfant",edFirstNameInfant.getText().toString());

                    //last
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"LastNameAduld",edLastName.getText().toString());
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"LastNameChild",edLastNameChild.getText().toString());
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"LastNameInfant",edLastNameInfant.getText().toString());


                    //date
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"datebirthadult",datebirthadult.getText().toString());
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"datebirthchild",datebirthchild.getText().toString());
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"datebirthinfant",datebirthinfant.getText().toString());

                    // nationality
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"nationality_adult",nationality_adult.getText().toString());
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"nationality_child",nationality_child.getText().toString());
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"nationality_infant",nationality_adult_infant.getText().toString());

                    List<SearchFlightsResponse.Segment> segments = (List<SearchFlightsResponse.Segment> ) getIntent().getSerializableExtra("segments");
                    SharedPreferencesManger.SaveData(Passenger_inform.this,"nationality_infant",nationality_adult_infant.getText().toString());
                    Intent intent = new Intent(Passenger_inform.this, FlightsSummary.class);
                    intent.putExtra("segments", (Serializable) segments);

                    startActivity(intent);




                }
                    //
            }
        });


        inputStream = getResources().openRawResource(R.raw.nationality);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {

            String data;

            while ((data = reader.readLine()) != null) {


                try {


                    list_nationalites.add(data);


                } catch (Exception e) {


                }

            }


        } catch (Exception e) {


        }


        AutoCompleteAdapter adapter2 = new AutoCompleteAdapter(this, R.layout.drop_dowen, android.R.id.text1, list_nationalites);


        nationality_adult.setAdapter(adapter2);
        nationality_adult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                String nationalite = list_nationalites.get(adapter2.getPosition(adapter2.getItem(position)));

                Toast.makeText(Passenger_inform.this, "" + nationalite, Toast.LENGTH_SHORT).show();

            }


        });


        AutoCompleteAdapter adapter3 = new AutoCompleteAdapter(this, R.layout.drop_dowen, android.R.id.text1, list_nationalites);


        nationality_child.setAdapter(adapter3);
        nationality_child.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                String nationalite = list_nationalites.get(adapter3.getPosition(adapter3.getItem(position)));

                Toast.makeText(Passenger_inform.this, "" + nationalite, Toast.LENGTH_SHORT).show();

            }


        });


        AutoCompleteAdapter adapter4 = new AutoCompleteAdapter(this, R.layout.drop_dowen, android.R.id.text1, list_nationalites);


        nationality_adult_infant.setAdapter(adapter4);
        nationality_adult_infant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                String nationalite = list_nationalites.get(adapter4.getPosition(adapter4.getItem(position)));

                Toast.makeText(Passenger_inform.this, "" + nationalite, Toast.LENGTH_SHORT).show();

            }


        });


        mrmiss1array = new ArrayList<>();
        mrmiss1array.add(getString(R.string.mr));
        mrmiss1array.add(getString(R.string.mrs));

        mrmiss2array = new ArrayList<>();
        mrmiss2array.add(getString(R.string.male));
        mrmiss2array.add(getString(R.string.female));

        mrmiss3array = new ArrayList<>();
        mrmiss3array.add(getString(R.string.male));
        mrmiss3array.add(getString(R.string.female));


        ArrayAdapter adapteradult = new ArrayAdapter(this, R.layout.item_spener, mrmiss1array);

        adapteradult.setDropDownViewResource(R.layout.drop_dowen);
        mrmisAdult.setAdapter(adapteradult);
        mrmisAdult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                 MDataMrmisAdult = mrmiss1array.get(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter adapterChild = new ArrayAdapter(this, R.layout.item_spener, mrmiss2array);

        adapterChild.setDropDownViewResource(R.layout.drop_dowen);
        mrmisChild.setAdapter(adapterChild);
        mrmisChild.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MDataMrmisChild = mrmiss2array.get(i);



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter adapteinfent = new ArrayAdapter(this, R.layout.item_spener, mrmiss2array);

        adapteinfent.setDropDownViewResource(R.layout.drop_dowen);
        mrmisinfent.setAdapter(adapteinfent);
        mrmisinfent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                MDataMrmisInfent=  mrmiss3array.get(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


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
                        year, month, day);
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
                        year, month, day);
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
                        year, month, day);
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
