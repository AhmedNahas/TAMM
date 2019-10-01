package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.AdapterPassengerInfo;
import net.middledleeast.tamm.model.CountPassengerAndType;

import java.util.ArrayList;
import java.util.List;

import FlightApi.Passenger;
import FlightApi.SearchFlightsResponse;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Passenger_inform extends AppCompatActivity {


    ImageView iv_booked_passenger_inform;
    @BindView(R.id.rc_passenger_info)
    RecyclerView rcPassengerInfo;
    @BindView(R.id.passenger_btn_info)
    Button passengerBtnInfo;
    private RelativeLayout relative_back_passenger_inform;
    private AdapterPassengerInfo adapterPassengerInfo;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_inform);
        ButterKnife.bind(this);
        List<SearchFlightsResponse.Segment> segments = (List<SearchFlightsResponse.Segment>) getIntent().getSerializableExtra("segments");
        List<CountPassengerAndType> passenger_type = (List<CountPassengerAndType>) getIntent().getSerializableExtra("passenger_type");




         adapterPassengerInfo = new AdapterPassengerInfo(passenger_type,passenger_type.size() ,passengerBtnInfo , this , segments);
        rcPassengerInfo.setLayoutManager(new LinearLayoutManager(this));
        rcPassengerInfo.setAdapter(adapterPassengerInfo);
        adapterPassengerInfo.notifyDataSetChanged();







        iv_booked_passenger_inform = findViewById(R.id.iv_booked_passenger_inform);
        iv_booked_passenger_inform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Passenger_inform.this, MyBookActivity.class);
                startActivity(intent);
            }
        });



        relative_back_passenger_inform = findViewById(R.id.relative_back_passenger_inform);
        relative_back_passenger_inform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Passenger_inform.this, RecommendedOneWay.class);
                startActivity(intent);
            }
        });












//        dateOfBirthAdult2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                openAdultAge(mDateSetListener6);
//
//
//            }
//        });
//        mDateSetListener6 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                dateOfBirthAdult2.setText(date);
//                String age = getAge(year, month, day);
//
//                int ageInt = Integer.parseInt(age);
//
//                if (ageInt < 18) {
//                    rightAge = false;
//
//
//                } else {
//                    rightAge = true;
//
//
//                }
//
//
//            }
//
//        };
//        tvIssueDate2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(
//                        Passenger_inform.this,
//                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar
//                        ,
//                        mDateSetListener7,
//                        year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//
//
//
//            }
//        });
//        mDateSetListener7 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                tvIssueDate2.setText(date);
//
//
//
//            }
//
//        };
//
//        tvEndDat2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(
//                        Passenger_inform.this,
//                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar
//                        ,
//                        mDateSetListener8,
//                        year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//
//
//
//
//
//            }
//        });
//        mDateSetListener8 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                tvEndDat2.setText(date);
//
//
//
//            }
//
//        };
//
//        switch ((int) adult) {
//
//            case 2:
//
//                relativeAdult2.setVisibility(View.VISIBLE);
//
//                break;
//
//            case 3:
//                relativeAdult2.setVisibility(View.VISIBLE);
//                relativeAdult3.setVisibility(View.VISIBLE);
//
//                break;
//
//            case 4:
//                relativeAdult2.setVisibility(View.VISIBLE);
//                relativeAdult3.setVisibility(View.VISIBLE);
//                relativeAdult4.setVisibility(View.VISIBLE);
//
//                break;
//
//            case 5:
//
//                relativeAdult2.setVisibility(View.VISIBLE);
//                relativeAdult3.setVisibility(View.VISIBLE);
//                relativeAdult4.setVisibility(View.VISIBLE);
//                relativeAdult5.setVisibility(View.VISIBLE);
//
//        }
//
//
//        switch ((int) child) {
//
//            case 1:
//
//                relativeChild1.setVisibility(View.VISIBLE);
//
//                break;
//
//
//            case 2:
//                relativeChild1.setVisibility(View.VISIBLE);
//                relativeChild2.setVisibility(View.VISIBLE);
//                break;
//
//
//            case 3:
//                relativeChild1.setVisibility(View.VISIBLE);
//                relativeChild2.setVisibility(View.VISIBLE);
//                relativeChild3.setVisibility(View.VISIBLE);
//                break;
//
//
//            case 4:
//                relativeChild1.setVisibility(View.VISIBLE);
//                relativeChild2.setVisibility(View.VISIBLE);
//                relativeChild3.setVisibility(View.VISIBLE);
//                relativeChild4.setVisibility(View.VISIBLE);
//
//                break;
//
//
//            case 5:
//                relativeChild1.setVisibility(View.VISIBLE);
//                relativeChild2.setVisibility(View.VISIBLE);
//                relativeChild3.setVisibility(View.VISIBLE);
//                relativeChild4.setVisibility(View.VISIBLE);
//                relativeChild5.setVisibility(View.VISIBLE);
//
//
//                break;
//
//
//        }
//
//
//        switch ((int) infant) {
//
//
//            case 1:
//
//                relativeInfant1.setVisibility(View.VISIBLE);
//
//                break;
//
//
//            case 2:
//                relativeInfant1.setVisibility(View.VISIBLE);
//                relativeInfant2.setVisibility(View.VISIBLE);
//                break;
//
//
//            case 3:
//                relativeInfant1.setVisibility(View.VISIBLE);
//                relativeInfant2.setVisibility(View.VISIBLE);
//                relativeInfant3.setVisibility(View.VISIBLE);
//                break;
//
//
//            case 4:
//                relativeInfant1.setVisibility(View.VISIBLE);
//                relativeInfant2.setVisibility(View.VISIBLE);
//                relativeInfant3.setVisibility(View.VISIBLE);
//                relativeInfant4.setVisibility(View.VISIBLE);
//
//                break;
//
//
//            case 5:
//                relativeInfant1.setVisibility(View.VISIBLE);
//                relativeInfant2.setVisibility(View.VISIBLE);
//                relativeInfant3.setVisibility(View.VISIBLE);
//                relativeInfant4.setVisibility(View.VISIBLE);
//                relativeInfant5.setVisibility(View.VISIBLE);
//
//
//                break;
//
//
//        }
//
//        dateOfBirthAdult3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                openAdultAge(mDateSetListener9);
//
//            }
//        });
//
//        mDateSetListener9 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                dateOfBirthAdult3.setText(date);
//
//                String age = getAge(year, month, day);
//
//                int ageInt = Integer.parseInt(age);
//
//                if (ageInt < 18) {
//                    rightAge = false;
//
//
//                } else {
//                    rightAge = true;
//
//
//                }
//
//            }
//
//        };
//
//
//        dateOfBirthAdult4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openAdultAge(mDateSetListener10);
//
//            }
//        });
//        mDateSetListener10 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                dateOfBirthAdult4.setText(date);
//
//                String age = getAge(year, month, day);
//
//                int ageInt = Integer.parseInt(age);
//
//                if (ageInt < 18) {
//                    rightAge = false;
//
//
//                } else {
//                    rightAge = true;
//
//
//                }
//
//            }
//
//        };
//        dateOfBirthAdult5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                openAdultAge(mDateSetListener11);
//            }
//        });
//
//
//        mDateSetListener11 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                dateOfBirthAdult5.setText(date);
//
//                String age = getAge(year, month, day);
//
//                int ageInt = Integer.parseInt(age);
//
//                if (ageInt < 18) {
//                    rightAge = false;
//
//
//                } else {
//                    rightAge = true;
//
//
//                }
//
//            }
//
//        };
//
//
//        tvIssueDate3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                openAdultAge(mDateSetListener12);
//            }
//        });
//
//        mDateSetListener12 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                tvIssueDate3.setText(date);
//
//                String age = getAge(year, month, day);
//
//
//            }
//
//        };
//
//        tvIssueDate4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openAdultAge(mDateSetListener13);
//
//            }
//        });
//        mDateSetListener13 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                tvIssueDate4.setText(date);
//
//                String age = getAge(year, month, day);
//
//
//            }
//
//        };
//
//        tvIssueDate5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openAdultAge(mDateSetListener14);
//
//            }
//        });
//        mDateSetListener14 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                tvIssueDate5.setText(date);
//
//
//
//            }
//
//        };
//
//
//        tvEndDat3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openAdultAge(mDateSetListener15);
//
//            }
//        });
//
//        mDateSetListener15 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                tvEndDat3.setText(date);
//
//
//
//            }
//
//        };
//
//
//
//
//        tvEndDat4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openAdultAge(mDateSetListener16);
//
//            }
//        });
//        mDateSetListener16 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                tvEndDat4.setText(date);
//
//
//
//            }
//
//        };
//
//
//
//        tvEndDat5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openAdultAge(mDateSetListener17);
//
//            }
//        });
//
//
//
//        mDateSetListener17 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                tvEndDat5.setText(date);
//
//
//
//            }
//
//        };
//
//
//
//
//
//
//
//
//
//
//        dateOfBirthChild2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                openAdultAge(mDateSetListener18);
//
//            }
//        });
//
//        mDateSetListener18 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                dateOfBirthChild2.setText(date);
//
//
//
//            }
//
//        };
//        dateOfBirthAdult3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openAdultAge(mDateSetListener19);
//
//
//            }
//        });
//
//
//        mDateSetListener19 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                dateOfBirthChild3.setText(date);
//
//
//
//            }
//
//        };
//
//        dateOfBirthAdult4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                openAdultAge(mDateSetListener20);
//
//            }
//        });
//
//        mDateSetListener20 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                dateOfBirthChild4.setText(date);
//
//
//
//            }
//
//        };
//        dateOfBirthAdult5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openAdultAge(mDateSetListener21);
//
//
//            }
//        });
//
//        mDateSetListener21 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                dateOfBirthChild5.setText(date);
//
//
//
//            }
//
//        };
//
//
//
//
//
//
//
//
//        dateOfBirthAdultInfant2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openAdultAge(mDateSetListener22);
//
//
//            }
//        });
//
//        mDateSetListener22 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                dateOfBirthAdultInfant2.setText(date);
//
//
//
//            }
//
//        };
//
//
//
//        dateOfBirthAdultInfant3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openAdultAge(mDateSetListener23);
//
//
//            }
//        });
//        mDateSetListener23 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                dateOfBirthAdultInfant3.setText(date);
//
//
//
//            }
//
//        };
//
//
//
//        dateOfBirthAdultInfant4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openAdultAge(mDateSetListener24);
//
//
//            }
//        });
//
//
//        mDateSetListener24 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                dateOfBirthAdultInfant4.setText(date);
//
//
//
//            }
//
//        };
//
//
//        dateOfBirthAdultInfant5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openAdultAge(mDateSetListener25);
//
//
//            }
//        });
//
//
//        mDateSetListener25 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//                String date = month + "/" + day + "/" + year;
//                dateOfBirthAdultInfant5.setText(date);
//
//            }
//
//        };
//
//
//        confirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                if (edFirstName.getText().toString().equals("")) {
//                    edFirstName.setError("Invalid First Name");
//
//                } else if (edLastName.getText().toString().equals("")) {
//
//                    edLastName.setError("Invalid Last Name");
////                }else if (edFirstNameChild.getText().toString().equals("")) {
////                    edFirstNameChild.setError("Invalid First Name");
////
////                }else if (edLastNameChild.getText().toString().equals("")){
////
////                    edLastNameChild.setError("Invalid Last Name");
////                }else if (edFirstNameInfant.getText().toString().equals("")) {
////                    edFirstNameInfant.setError("Invalid First Name");
////
////                }else if (edLastNameInfant.getText().toString().equals("")) {
////
////                    edLastNameInfant.setError("Invalid Last Name");
//
//                } else if (datebirthadult.getText().toString().equals("DD-MM-YYYY")) {
//                    Toast.makeText(Passenger_inform.this, "Invalid DOB", Toast.LENGTH_SHORT).show();
////
////                }else if (datebirthchild.getText().toString().equals("DD-MM-YYYY")) {
////                    Toast.makeText(Passenger_inform.this, "Invalid DOB", Toast.LENGTH_SHORT).show();
////
////                }else if (datebirthinfant.getText().toString().equals("DD-MM-YYYY")) {
////
////                    Toast.makeText(Passenger_inform.this, "Invalid DOB", Toast.LENGTH_SHORT).show();
//
//
//                } else if (nationality_adult.getText().toString().equals("")) {
//                    nationality_adult.setError("Invalid Nationality");
//
////                }else if (nationality_child.getText().toString().equals("")){
////                    nationality_child.setError("Invalid Nationality");
////
////                }else if (nationality_adult_infant.getText().toString().equals("")){
////                    nationality_adult_infant.setError("Invalid Nationality");
//
//
//                } else if (tvEndDat.getText().toString().equals("")) {
//
//                    tvEndDat.setError("Invalid End Date");
//
//                } else if (tvIssueDate.getText().toString().equals("")) {
//
//                    tvIssueDate.setError("Invalid Issue Date");
//
//                } else if (passportNo.getText().toString().equals("")) {
//
//
//                    passportNo.setError("Invalid Passport Number ");
//                } else if (!rightAge) {
//
//
//                    Toast.makeText(Passenger_inform.this, " your Age is less than 18  ", Toast.LENGTH_SHORT).show();
//
//
//                } else {
//
//
//                    switch ((int) adult) {
//
//
//                        case 1:
//
//                            informationAdult1();
//
//
//                            break;
//
//
//                        case 2:
//                            informationAdult1();
//                            informationAdult2();
//
//                            break;
//
//                        case 3:
//                            informationAdult1();
//                            informationAdult2();
//                            informationAdult3();
//
//
//                            break;
//
//                        case 4:
//
//                            informationAdult1();
//                            informationAdult2();
//                            informationAdult3();
//                            informationAdult4();
//
//                            break;
//
//                        case 5:
//
//                            informationAdult1();
//                            informationAdult2();
//                            informationAdult3();
//                            informationAdult4();
//                            informationAdult5();
//
//                            break;
//
//                    }
//
//
//                    switch ((int) child) {
//
//                        case 1:
//
//                            infprmationChild1();
//
//                            break;
//
//
//                        case 2:
//                            infprmationChild1();
//                            infprmationChild2();
//
//                            break;
//
//
//                        case 3:
//                            infprmationChild1();
//                            infprmationChild2();
//                            infprmationChild3();
//
//                            break;
//
//
//                        case 4:
//
//                            infprmationChild1();
//                            infprmationChild2();
//                            infprmationChild3();
//                            infprmationChild4();
//
//                            break;
//
//
//                        case 5:
//
//
//                            infprmationChild1();
//                            infprmationChild2();
//                            infprmationChild3();
//                            infprmationChild4();
//                            infprmationChild5();
//
//                            break;
//
//
//                    }
//
//
//                    switch ((int) infant) {
//
//
//                        case 1:
//
//                            informationInfant1();
//                            break;
//
//
//                        case 2:
//                            informationInfant1();
//                            informationInfant2();
//
//                            break;
//
//
//                        case 3:
//                            informationInfant1();
//                            informationInfant2();
//                            informationInfant3();
//
//                            break;
//
//
//                        case 4:
//                            informationInfant1();
//                            informationInfant2();
//                            informationInfant3();
//                            informationInfant4();
//
//                            break;
//
//
//                        case 5:
//                            informationInfant1();
//                            informationInfant2();
//                            informationInfant3();
//                            informationInfant4();
//                            informationInfant5();
//                            break;
//
//
//                    }
//
//
//                    Intent intent = new Intent(Passenger_inform.this, FlightsSummary.class);
//                    intent.putExtra("segments", (Serializable) segments);
//
//                    if (journyTipe==2){
//
//                        List<SearchFlightsResponse.Segment> segmentsReturn = (List<SearchFlightsResponse.Segment>) getIntent().getSerializableExtra("segmentsReturn");
//
//                        intent.putExtra("segmentsReturn", (Serializable) segmentsReturn);
//                    }
//
//                    startActivity(intent);
//
//
//                }
//                //
//            }
//        });
//
//
//        inputStream = getResources().openRawResource(R.raw.nationality);
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//
//        try {
//
//            String data;
//
//            while ((data = reader.readLine()) != null) {
//
//
//                try {
//
//
//                    list_nationalites.add(data);
//
//
//                } catch (Exception e) {
//
//
//                }
//
//            }
//
//
//        } catch (Exception e) {
//
//
//        }
//
//
//        AutoCompleteAdapter adapter2 = new AutoCompleteAdapter(this, R.layout.drop_dowen, android.R.id.text1, list_nationalites);
//
//
//        nationality_adult.setAdapter(adapter2);
//        nationality_adult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//                String nationalite = list_nationalites.get(adapter2.getPosition(adapter2.getItem(position)));
//
//
//            }
//
//
//        });
//
//
//        AutoCompleteAdapter adapter5 = new AutoCompleteAdapter(this, R.layout.drop_dowen, android.R.id.text1, list_nationalites);
//
//
//        nationalityAdult2.setAdapter(adapter5);
//        nationalityAdult2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//
//
//            }
//
//
//        });
//
//        nationalityAdult3.setAdapter(adapter5);
//        nationalityAdult3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//
//
//            }
//
//
//        });
//
//
//        nationalityAdult4.setAdapter(adapter5);
//        nationalityAdult4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//
//
//            }
//
//
//        });
//
//        nationalityAdult5.setAdapter(adapter5);
//        nationalityAdult5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//
//
//            }
//
//
//        });
//
//
//        AutoCompleteAdapter adapter3 = new AutoCompleteAdapter(this, R.layout.drop_dowen, android.R.id.text1, list_nationalites);
//
//
//        nationality_child.setAdapter(adapter3);
//        nationality_child.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//
//
//            }
//
//
//        });
//
//
//        AutoCompleteAdapter adapter4 = new AutoCompleteAdapter(this, R.layout.drop_dowen, android.R.id.text1, list_nationalites);
//
//
//        nationality_adult_infant.setAdapter(adapter4);
//        nationality_adult_infant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//                String nationalite = list_nationalites.get(adapter4.getPosition(adapter4.getItem(position)));
//
//
//            }
//
//
//        });
//
//
//
//
//
//        nationalityChild2.setAdapter(adapter4);
//        nationalityChild2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//
//
//            }
//
//
//        });
//
//
//        nationalityChild3.setAdapter(adapter4);
//        nationalityChild3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//
//
//            }
//
//
//        });
//
//
//
//        nationalityChild4.setAdapter(adapter4);
//        nationalityChild4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//
//
//            }
//
//
//        });
//
//
//
//        nationalityChild5.setAdapter(adapter4);
//        nationalityChild5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//            }
//
//
//        });
//
//
//        nationalityAdultInfant2.setAdapter(adapter4);
//        nationalityAdultInfant2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//            }
//
//
//        });
//
//
//
//
//
//        nationalityAdultInfant3.setAdapter(adapter4);
//        nationalityAdultInfant3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//            }
//
//
//        });
//
//
//        nationalityAdultInfant4.setAdapter(adapter4);
//        nationalityAdultInfant4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//            }
//
//
//        });
//
//
//
//
//        nationalityAdultInfant5.setAdapter(adapter4);
//        nationalityAdultInfant5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//
//            }
//        });
//
//
//
//
//
//
//
//
//
//
//        mrmiss1array = new ArrayList<>();
//        mrmiss1array.add(getString(R.string.mr));
//        mrmiss1array.add(getString(R.string.mrs));
//
//        mrmiss2array = new ArrayList<>();
//        mrmiss2array.add(getString(R.string.male));
//        mrmiss2array.add(getString(R.string.female));
//
//        mrmiss3array = new ArrayList<>();
//        mrmiss3array.add(getString(R.string.male));
//        mrmiss3array.add(getString(R.string.female));
//
//
//        ArrayAdapter adapteradult = new ArrayAdapter(this, R.layout.item_spener, mrmiss1array);
//
//        adapteradult.setDropDownViewResource(R.layout.drop_dowen);
//        mrmisAdult.setAdapter(adapteradult);
//        mrmisAdult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                MDataMrmisAdult = mrmiss1array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//        mromiss2.setAdapter(adapteradult);
//        mromiss2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                MDataMrmisAdult2 = mrmiss1array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//        mromiss3.setAdapter(adapteradult);
//        mromiss3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                MDataMrmisAdult3 = mrmiss1array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//        mromiss4.setAdapter(adapteradult);
//        mromiss4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                MDataMrmisAdult4 = mrmiss1array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        mromiss5.setAdapter(adapteradult);
//        mromiss5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                MDataMrmisAdult5 = mrmiss1array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        ArrayAdapter adapterChild = new ArrayAdapter(this, R.layout.item_spener, mrmiss2array);
//
//        adapterChild.setDropDownViewResource(R.layout.drop_dowen);
//        mrmisChild.setAdapter(adapterChild);
//        mrmisChild.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                MDataMrmisChild = mrmiss2array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//
//
//        mrmisChild.setAdapter(adapterChild);
//        mrmisChild.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                MDataMrmisChild = mrmiss2array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//
//
//        mromissChild2.setAdapter(adapterChild);
//        mromissChild2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                MDataMrmisChild2 = mrmiss2array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//
//
//        mromissChild3.setAdapter(adapterChild);
//        mromissChild3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                MDataMrmisChild3 = mrmiss2array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//        mromissChild4.setAdapter(adapterChild);
//        mromissChild4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                MDataMrmisChild4 = mrmiss2array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//        mromissChild5.setAdapter(adapterChild);
//        mromissChild5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                MDataMrmisChild5 = mrmiss2array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//        mromissInfant2.setAdapter(adapterChild);
//        mromissInfant2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                MDataMrmisInfent2 = mrmiss2array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        mromissInfant3.setAdapter(adapterChild);
//        mromissInfant3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                MDataMrmisInfent3 = mrmiss2array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//
//        mromissInfant4.setAdapter(adapterChild);
//        mromissInfant4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                MDataMrmisInfent4 = mrmiss2array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//        mromissInfant5.setAdapter(adapterChild);
//        mromissInfant5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                MDataMrmisInfent5 = mrmiss2array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//
//        ArrayAdapter adapteinfent = new ArrayAdapter(this, R.layout.item_spener, mrmiss2array);
//
//        adapteinfent.setDropDownViewResource(R.layout.drop_dowen);
//        mrmisinfent.setAdapter(adapteinfent);
//        mrmisinfent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                MDataMrmisInfent = mrmiss3array.get(i);
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//        datebirthadult.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(
//                        Passenger_inform.this,
//                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar,
//                        mDateSetListener1,
//                        year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//
//
//        });
//        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                datebirthadult.setText(date);
//                String age = getAge(year, month, day);
//
//                int ageInt = Integer.parseInt(age);
//
//                if (ageInt < 18) {
//                    rightAge = false;
//
//
//                } else {
//                    rightAge = true;
//
//
//                }
//
//
//            }
//        };
//
//
//        datebirthchild.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(
//                        Passenger_inform.this,
//                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar,
//                        mDateSetListener2,
//                        year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//        });
//
//        mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//
//                datebirthchild.setText(date);
//            }
//        };
//
//
//        datebirthinfant.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(
//                        Passenger_inform.this,
//                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar
//                        ,
//                        mDateSetListener3,
//                        year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//        });
//
//        mDateSetListener3 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                datebirthinfant.setText(date);
//            }
//        };
//
//
//        tvIssueDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(
//                        Passenger_inform.this,
//                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar
//                        ,
//                        mDateSetListener4,
//                        year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//        });
//        mDateSetListener4 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                tvIssueDate.setText(date);
//            }
//        };
//
//
//        tvEndDat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(
//                        Passenger_inform.this,
//                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar
//                        ,
//                        mDateSetListener5,
//                        year, month, day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//        });
//        mDateSetListener5 = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                String date = month + "/" + day + "/" + year;
//                tvEndDat.setText(date);
//            }
//        };
//
//    }
//
//
//
//
//    private void infprmationChild2() {
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameChild2", edFirstNameChild2.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameChild2", edLastNameChild2.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthchild2", dateOfBirthChild2.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_child2", nationalityChild2.getText().toString());
//
//    }
//
//
//    private void infprmationChild3() {
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameChild3", edFirstNameChild3.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameChild3", edLastNameChild3.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthchild3", dateOfBirthChild3.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_child3", nationalityChild3.getText().toString());
//
//    }
//
//
//    private void infprmationChild4() {
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameChild4", edFirstNameChild4.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameChild4", edLastNameChild4.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthchild4", dateOfBirthChild4.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_child4", nationalityChild4.getText().toString());
//
//    }
//
//
//    private void infprmationChild5() {
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameChild5", edFirstNameChild5.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameChild5", edLastNameChild5.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthchild5", dateOfBirthChild5.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_child5", nationalityChild5.getText().toString());
//
//    }
//
//
//    private void informationAdult5() {
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameAduld5", edFirstName5.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameAduld5", edLastName5.getText().toString());
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthadult5", dateOfBirthAdult5.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_adult5", nationalityAdult5.getText().toString());
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportNo5", passportNo5.getText().toString());
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportIssue5", tvIssueDate5.getText().toString());
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportEnd5", tvEndDat5.getText().toString());
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisAdult3", MDataMrmisAdult5);
//
//
//    }
//
//    private void informationAdult4() {
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameAduld4", edFirstName4.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameAduld4", edLastName4.getText().toString());
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthadult4", dateOfBirthAdult4.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_adult4", nationalityAdult4.getText().toString());
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportNo4", passportNo4.getText().toString());
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportIssue4", tvIssueDate4.getText().toString());
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportEnd4", tvEndDat4.getText().toString());
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisAdult4", MDataMrmisAdult4);
//
//
//    }
//
//    private void informationAdult3() {
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisAdult3", MDataMrmisAdult3);
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameAduld3", edFirstName3.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameAduld3", edLastName3.getText().toString());
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthadult3", dateOfBirthAdult3.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_adult3", nationalityAdult3.getText().toString());
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportNo3", passportNo3.getText().toString());
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportIssue3", tvIssueDate3.getText().toString());
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportEnd3", tvEndDat3.getText().toString());
//    }
//
//    private void informationAdult2() {
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisAdult2", MDataMrmisAdult2);
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameAduld2", edFirstName2.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameAduld2", edLastName2.getText().toString());
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthadult2", dateOfBirthAdult2.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_adult2", nationalityAdult2.getText().toString());
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportNo2", passportNo2.getText().toString());
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportIssue2", tvIssueDate2.getText().toString());
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportEnd2", tvEndDat2.getText().toString());
//
//
//    }
//
//    private void informationAdult1() {
//
//
//         SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisAdult", MDataMrmisAdult);
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameAduld", edFirstName.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameAduld", edLastName.getText().toString());
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthadult", datebirthadult.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_adult", nationality_adult.getText().toString());
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportNo", passportNo.getText().toString());
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportIssue", tvIssueDate.getText().toString());
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportEnd", tvEndDat.getText().toString());
//
//
//    }
//
//    private void infprmationChild1() {
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisChild", MDataMrmisChild);
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameChild", edFirstNameChild.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameChild", edLastNameChild.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthchild", datebirthchild.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_child", nationality_child.getText().toString());
//
//
//    }
//
//
//    private void informationInfant1() {
//
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisInfent", MDataMrmisInfent);
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameInfant", edFirstNameInfant.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameInfant", edLastNameInfant.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthinfant", datebirthinfant.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_infant", nationality_adult_infant.getText().toString());
//
//
//    }
//
//
//    private void informationInfant2() {
//
//
//        //     SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisInfent2", MDataMrmisInfent2);
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameInfant2", edFirstNameInfant2.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameInfant2", edLastNameInfant2.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthinfant2", dateOfBirthAdultInfant2.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_infant2", nationalityAdultInfant2.getText().toString());
//
//
//    }
//
//    private void informationInfant3() {
//
//
//        //     SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisInfent2", MDataMrmisInfent2);
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameInfant3", edFirstNameInfant3.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameInfant3", edLastNameInfant3.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthinfant3", dateOfBirthAdultInfant3.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_infant3", nationalityAdultInfant3.getText().toString());
//
//
//    }
//
//
//    private void informationInfant4() {
//
//
//        //     SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisInfent2", MDataMrmisInfent2);
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameInfant4", edFirstNameInfant4.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameInfant4", edLastNameInfant4.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthinfant4", dateOfBirthAdultInfant4.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_infant4", nationalityAdultInfant4.getText().toString());
//
//
//    }
//
//
//    private void informationInfant5() {
//
//
//        //     SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisInfent2", MDataMrmisInfent2);
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameInfant5", edFirstNameInfant5.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameInfant5", edLastNameInfant5.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthinfant5", dateOfBirthAdultInfant5.getText().toString());
//
//        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_infant5", nationalityAdultInfant5.getText().toString());
//
//
//    }
//
//
//    private String getAge(int year, int month, int day) {
//        Calendar dob = Calendar.getInstance();
//        Calendar today = Calendar.getInstance();
//
//        dob.set(year, month, day);
//
//        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
//
//        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
//            age--;
//        }
//
//        Integer ageInt = new Integer(age);
//        String ageS = ageInt.toString();
//
//        return ageS;
//    }
//
//
//    public void openAdultAge(DatePickerDialog.OnDateSetListener mDateSetListener  ) {
//
//        Calendar cal = Calendar.getInstance();
//        int year = cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH);
//        int day = cal.get(Calendar.DAY_OF_MONTH);
//
//        DatePickerDialog dialog = new DatePickerDialog(
//                Passenger_inform.this,
//                android.R.style.Theme_Holo_Wallpaper_NoTitleBar,
//                mDateSetListener,
//                year, month, day);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.show();
//
//
//
//    }
//
//

    }
//
//    @OnClick(R.id.passenger_btn_info)
//    public void onViewClicked() {
//
//        adapterPassengerInfo.notifyDataSetChanged();
//        List<Passenger> passengers = adapterPassengerInfo.gerPassengerInfo();
//
//
//
//    }
}