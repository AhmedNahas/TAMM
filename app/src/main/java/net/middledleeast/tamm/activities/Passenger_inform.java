package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
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
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;
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

    @BindView(R.id.ed_first_name1)
    EditText edFirstName;
    @BindView(R.id.ed_last_name1)
    EditText edLastName;
    @BindView(R.id.ed_first_name_child1)
    EditText edFirstNameChild;
    @BindView(R.id.ed_last_name_child1)
    EditText edLastNameChild;
    @BindView(R.id.ed_first_name_infant1)
    EditText edFirstNameInfant;
    @BindView(R.id.ed_last_name_infant1)
    EditText edLastNameInfant;
    @BindView(R.id.passport_no1)
    EditText passportNo;
    @BindView(R.id.tv_issue_Date1)
    TextView tvIssueDate;
    @BindView(R.id.tv_end_dat1)
    TextView tvEndDat;
    @BindView(R.id.toolbar_back1)
    ImageView toolbarBack1;
    @BindView(R.id.relative_back_passenger_inform)
    RelativeLayout relativeBackPassengerInform;
    @BindView(R.id.iv_booked_passenger_inform)
    ImageView ivBookedPassengerInform;
    @BindView(R.id.tollbar_relatev)
    RelativeLayout tollbarRelatev;
    @BindView(R.id.PassengerText)
    TextView PassengerText;
    @BindView(R.id.adultText1)
    TextView adultText1;
    @BindView(R.id.mromiss1)
    Spinner mromiss1;
    @BindView(R.id.mromiss_layout1)
    RelativeLayout mromissLayout1;
    @BindView(R.id.relative_first_last1)
    RelativeLayout relativeFirstLast1;
    @BindView(R.id.tv_dob1)
    TextView tvDob1;
    @BindView(R.id.date_of_birth_adult1)
    TextView dateOfBirthAdult1;
    @BindView(R.id.nationality_adult1)
    AutoCompleteTextView nationalityAdult1;
    @BindView(R.id.relative_date1)
    RelativeLayout relativeDate1;
    @BindView(R.id.issue_1)
    TextView issue1;
    @BindView(R.id.end_dat1)
    TextView endDat1;
    @BindView(R.id.relative_adult_1)
    RelativeLayout relativeAdult1;
    @BindView(R.id.adultText2)
    TextView adultText2;
    @BindView(R.id.mromiss2)
    Spinner mromiss2;
    @BindView(R.id.mromiss_layout2)
    RelativeLayout mromissLayout2;
    @BindView(R.id.ed_first_name2)
    EditText edFirstName2;
    @BindView(R.id.ed_last_name2)
    EditText edLastName2;
    @BindView(R.id.relative_first_last2)
    RelativeLayout relativeFirstLast2;
    @BindView(R.id.tv_dob2)
    TextView tvDob2;
    @BindView(R.id.date_of_birth_adult2)
    TextView dateOfBirthAdult2;
    @BindView(R.id.nationality_adult2)
    AutoCompleteTextView nationalityAdult2;
    @BindView(R.id.relative_date2)
    RelativeLayout relativeDate2;
    @BindView(R.id.passport_no2)
    EditText passportNo2;
    @BindView(R.id.issue_2)
    TextView issue2;
    @BindView(R.id.tv_issue_Date2)
    TextView tvIssueDate2;
    @BindView(R.id.end_dat2)
    TextView endDat2;
    @BindView(R.id.tv_end_dat2)
    TextView tvEndDat2;
    @BindView(R.id.relative_adult_2)
    RelativeLayout relativeAdult2;
    @BindView(R.id.adultText3)
    TextView adultText3;
    @BindView(R.id.mromiss_3)
    Spinner mromiss3;
    @BindView(R.id.mromiss_layout3)
    RelativeLayout mromissLayout3;
    @BindView(R.id.ed_first_name3)
    EditText edFirstName3;
    @BindView(R.id.ed_last_name3)
    EditText edLastName3;
    @BindView(R.id.relative_first_last3)
    RelativeLayout relativeFirstLast3;
    @BindView(R.id.tv_dob3)
    TextView tvDob3;
    @BindView(R.id.date_of_birth_adult3)
    TextView dateOfBirthAdult3;
    @BindView(R.id.nationality_adult3)
    AutoCompleteTextView nationalityAdult3;
    @BindView(R.id.relative_date3)
    RelativeLayout relativeDate3;
    @BindView(R.id.passport_no3)
    EditText passportNo3;
    @BindView(R.id.issue_3)
    TextView issue3;
    @BindView(R.id.tv_issue_Date3)
    TextView tvIssueDate3;
    @BindView(R.id.end_dat3)
    TextView endDat3;
    @BindView(R.id.tv_end_dat3)
    TextView tvEndDat3;
    @BindView(R.id.relative_adult_3)
    RelativeLayout relativeAdult3;
    @BindView(R.id.adultText4)
    TextView adultText4;
    @BindView(R.id.mromiss_4)
    Spinner mromiss4;
    @BindView(R.id.mromiss_layout4)
    RelativeLayout mromissLayout4;
    @BindView(R.id.ed_first_name4)
    EditText edFirstName4;
    @BindView(R.id.ed_last_name4)
    EditText edLastName4;
    @BindView(R.id.relative_first_last4)
    RelativeLayout relativeFirstLast4;
    @BindView(R.id.tv_dob4)
    TextView tvDob4;
    @BindView(R.id.date_of_birth_adult4)
    TextView dateOfBirthAdult4;
    @BindView(R.id.nationality_adult4)
    AutoCompleteTextView nationalityAdult4;
    @BindView(R.id.relative_date4)
    RelativeLayout relativeDate4;
    @BindView(R.id.passport_no4)
    EditText passportNo4;
    @BindView(R.id.issue_4)
    TextView issue4;
    @BindView(R.id.tv_issue_Date4)
    TextView tvIssueDate4;
    @BindView(R.id.end_dat4)
    TextView endDat4;
    @BindView(R.id.tv_end_dat4)
    TextView tvEndDat4;
    @BindView(R.id.relative_adult_4)
    RelativeLayout relativeAdult4;
    @BindView(R.id.adultText5)
    TextView adultText5;
    @BindView(R.id.mromiss_5)
    Spinner mromiss5;
    @BindView(R.id.mromiss_layout5)
    RelativeLayout mromissLayout5;
    @BindView(R.id.ed_first_name5)
    EditText edFirstName5;
    @BindView(R.id.ed_last_name5)
    EditText edLastName5;
    @BindView(R.id.relative_first_last5)
    RelativeLayout relativeFirstLast5;
    @BindView(R.id.tv_dob5)
    TextView tvDob5;
    @BindView(R.id.date_of_birth_adult5)
    TextView dateOfBirthAdult5;
    @BindView(R.id.nationality_adult5)
    AutoCompleteTextView nationalityAdult5;
    @BindView(R.id.relative_date5)
    RelativeLayout relativeDate5;
    @BindView(R.id.passport_no5)
    EditText passportNo5;
    @BindView(R.id.issue_5)
    TextView issue5;
    @BindView(R.id.tv_issue_Date5)
    TextView tvIssueDate5;
    @BindView(R.id.end_dat5)
    TextView endDat5;
    @BindView(R.id.tv_end_dat5)
    TextView tvEndDat5;
    @BindView(R.id.relative_adult_5)
    RelativeLayout relativeAdult5;
    @BindView(R.id.childtText1)
    TextView childtText1;
    @BindView(R.id.mromiss_child1)
    Spinner mromissChild1;
    @BindView(R.id.mromiss_child_layout1)
    RelativeLayout mromissChildLayout1;
    @BindView(R.id.relative_first_last_child1)
    RelativeLayout relativeFirstLastChild1;
    @BindView(R.id.tv_dob_child1)
    TextView tvDobChild1;
    @BindView(R.id.date_of_birth_child1)
    TextView dateOfBirthChild1;
    @BindView(R.id.nationality_child1)
    AutoCompleteTextView nationalityChild1;
    @BindView(R.id.relative_date_child1)
    RelativeLayout relativeDateChild1;
    @BindView(R.id.relative_child_1)
    RelativeLayout relativeChild1;
    @BindView(R.id.childtText2)
    TextView childtText2;
    @BindView(R.id.mromiss_child2)
    Spinner mromissChild2;
    @BindView(R.id.mromiss_child_layout2)
    RelativeLayout mromissChildLayout2;
    @BindView(R.id.ed_first_name_child2)
    EditText edFirstNameChild2;
    @BindView(R.id.ed_last_name_child2)
    EditText edLastNameChild2;
    @BindView(R.id.relative_first_last_child2)
    RelativeLayout relativeFirstLastChild2;
    @BindView(R.id.tv_dob_child2)
    TextView tvDobChild2;
    @BindView(R.id.date_of_birth_child2)
    TextView dateOfBirthChild2;
    @BindView(R.id.nationality_child2)
    AutoCompleteTextView nationalityChild2;
    @BindView(R.id.relative_date_child2)
    RelativeLayout relativeDateChild2;
    @BindView(R.id.relative_child_2)
    RelativeLayout relativeChild2;
    @BindView(R.id.childtText3)
    TextView childtText3;
    @BindView(R.id.mromiss_child3)
    Spinner mromissChild3;
    @BindView(R.id.mromiss_child_layout3)
    RelativeLayout mromissChildLayout3;
    @BindView(R.id.ed_first_name_child3)
    EditText edFirstNameChild3;
    @BindView(R.id.ed_last_name_child3)
    EditText edLastNameChild3;
    @BindView(R.id.relative_first_last_child3)
    RelativeLayout relativeFirstLastChild3;
    @BindView(R.id.tv_dob_child3)
    TextView tvDobChild3;
    @BindView(R.id.date_of_birth_child3)
    TextView dateOfBirthChild3;
    @BindView(R.id.nationality_child3)
    AutoCompleteTextView nationalityChild3;
    @BindView(R.id.relative_date_child3)
    RelativeLayout relativeDateChild3;
    @BindView(R.id.relative_child_3)
    RelativeLayout relativeChild3;
    @BindView(R.id.childtText4)
    TextView childtText4;
    @BindView(R.id.mromiss_child4)
    Spinner mromissChild4;
    @BindView(R.id.mromiss_child_layout4)
    RelativeLayout mromissChildLayout4;
    @BindView(R.id.ed_first_name_child4)
    EditText edFirstNameChild4;
    @BindView(R.id.ed_last_name_child4)
    EditText edLastNameChild4;
    @BindView(R.id.relative_first_last_child4)
    RelativeLayout relativeFirstLastChild4;
    @BindView(R.id.tv_dob_child4)
    TextView tvDobChild4;
    @BindView(R.id.date_of_birth_child4)
    TextView dateOfBirthChild4;
    @BindView(R.id.nationality_child4)
    AutoCompleteTextView nationalityChild4;
    @BindView(R.id.relative_date_child4)
    RelativeLayout relativeDateChild4;
    @BindView(R.id.relative_child_4)
    RelativeLayout relativeChild4;
    @BindView(R.id.childtText5)
    TextView childtText5;
    @BindView(R.id.mromiss_child5)
    Spinner mromissChild5;
    @BindView(R.id.mromiss_child_layout5)
    RelativeLayout mromissChildLayout5;
    @BindView(R.id.ed_first_name_child5)
    EditText edFirstNameChild5;
    @BindView(R.id.ed_last_name_child5)
    EditText edLastNameChild5;
    @BindView(R.id.relative_first_last_child5)
    RelativeLayout relativeFirstLastChild5;
    @BindView(R.id.tv_dob_child5)
    TextView tvDobChild5;
    @BindView(R.id.date_of_birth_child5)
    TextView dateOfBirthChild5;
    @BindView(R.id.nationality_child5)
    AutoCompleteTextView nationalityChild5;
    @BindView(R.id.relative_date_child5)
    RelativeLayout relativeDateChild5;
    @BindView(R.id.relative_child_5)
    RelativeLayout relativeChild5;
    @BindView(R.id.infanttText1)
    TextView infanttText1;
    @BindView(R.id.mromiss_infant1)
    Spinner mromissInfant1;
    @BindView(R.id.mromiss_infant_layout1)
    RelativeLayout mromissInfantLayout1;
    @BindView(R.id.relative_first_last_infant1)
    RelativeLayout relativeFirstLastInfant1;
    @BindView(R.id.tv_dob_infant1)
    TextView tvDobInfant1;
    @BindView(R.id.date_of_birth_adult_infant1)
    TextView dateOfBirthAdultInfant1;
    @BindView(R.id.nationality_adult_infant1)
    AutoCompleteTextView nationalityAdultInfant1;
    @BindView(R.id.relative_date_infant1)
    RelativeLayout relativeDateInfant1;
    @BindView(R.id.relative_infant_1)
    RelativeLayout relativeInfant1;
    @BindView(R.id.infanttText2)
    TextView infanttText2;
    @BindView(R.id.mromiss_infant2)
    Spinner mromissInfant2;
    @BindView(R.id.mromiss_infant_layout2)
    RelativeLayout mromissInfantLayout2;
    @BindView(R.id.ed_first_name_infant2)
    EditText edFirstNameInfant2;
    @BindView(R.id.ed_last_name_infant2)
    EditText edLastNameInfant2;
    @BindView(R.id.relative_first_last_infant2)
    RelativeLayout relativeFirstLastInfant2;
    @BindView(R.id.tv_dob_infant2)
    TextView tvDobInfant2;
    @BindView(R.id.date_of_birth_adult_infant2)
    TextView dateOfBirthAdultInfant2;
    @BindView(R.id.nationality_adult_infant2)
    AutoCompleteTextView nationalityAdultInfant2;
    @BindView(R.id.relative_date_infant2)
    RelativeLayout relativeDateInfant2;
    @BindView(R.id.relative_infant_2)
    RelativeLayout relativeInfant2;
    @BindView(R.id.infanttText3)
    TextView infanttText3;
    @BindView(R.id.mromiss_infant3)
    Spinner mromissInfant3;
    @BindView(R.id.mromiss_infant_layout3)
    RelativeLayout mromissInfantLayout3;
    @BindView(R.id.ed_first_name_infant3)
    EditText edFirstNameInfant3;
    @BindView(R.id.ed_last_name_infant3)
    EditText edLastNameInfant3;
    @BindView(R.id.relative_first_last_infant3)
    RelativeLayout relativeFirstLastInfant3;
    @BindView(R.id.tv_dob_infant3)
    TextView tvDobInfant3;
    @BindView(R.id.date_of_birth_adult_infant3)
    TextView dateOfBirthAdultInfant3;
    @BindView(R.id.nationality_adult_infant3)
    AutoCompleteTextView nationalityAdultInfant3;
    @BindView(R.id.relative_date_infant3)
    RelativeLayout relativeDateInfant3;
    @BindView(R.id.relative_infant_3)
    RelativeLayout relativeInfant3;
    @BindView(R.id.infanttText4)
    TextView infanttText4;
    @BindView(R.id.mromiss_infant4)
    Spinner mromissInfant4;
    @BindView(R.id.mromiss_infant_layout4)
    RelativeLayout mromissInfantLayout4;
    @BindView(R.id.ed_first_name_infant4)
    EditText edFirstNameInfant4;
    @BindView(R.id.ed_last_name_infant4)
    EditText edLastNameInfant4;
    @BindView(R.id.relative_first_last_infant4)
    RelativeLayout relativeFirstLastInfant4;
    @BindView(R.id.tv_dob_infant4)
    TextView tvDobInfant4;
    @BindView(R.id.date_of_birth_adult_infant4)
    TextView dateOfBirthAdultInfant4;
    @BindView(R.id.nationality_adult_infant4)
    AutoCompleteTextView nationalityAdultInfant4;
    @BindView(R.id.relative_date_infant4)
    RelativeLayout relativeDateInfant4;
    @BindView(R.id.relative_infant_4)
    RelativeLayout relativeInfant4;
    @BindView(R.id.infanttText5)
    TextView infanttText5;
    @BindView(R.id.mromiss_infant5)
    Spinner mromissInfant5;
    @BindView(R.id.mromiss_infant_layout5)
    RelativeLayout mromissInfantLayout5;
    @BindView(R.id.ed_first_name_infant5)
    EditText edFirstNameInfant5;
    @BindView(R.id.line_first_name_infant5)
    View lineFirstNameInfant5;
    @BindView(R.id.ed_last_name_infant5)
    EditText edLastNameInfant5;
    @BindView(R.id.relative_first_last_infant5)
    RelativeLayout relativeFirstLastInfant5;
    @BindView(R.id.tv_dob_infant5)
    TextView tvDobInfant5;
    @BindView(R.id.date_of_birth_adult_infant5)
    TextView dateOfBirthAdultInfant5;
    @BindView(R.id.nationality_adult_infant5)
    AutoCompleteTextView nationalityAdultInfant5;
    @BindView(R.id.relative_date_infant5)
    RelativeLayout relativeDateInfant5;
    @BindView(R.id.relative_infant_5)
    RelativeLayout relativeInfant5;
    @BindView(R.id.scroll_passenger_inform)
    ScrollView scrollPassengerInform;
    private TextView datebirthadult, datebirthchild, datebirthinfant;
    private DatePickerDialog.OnDateSetListener mDateSetListener1, mDateSetListener2, mDateSetListener3, mDateSetListener4, mDateSetListener5 ,mDateSetListener6 ;
    ArrayAdapter mrmiss1adapter, mrmiss2adapter, mrmiss3adapter;
    ArrayList<String> mrmiss1array, mrmiss2array, mrmiss3array;
    Button confirm;

    AutoCompleteTextView nationality_adult, nationality_child, nationality_adult_infant;
    Spinner mrmisAdult, mrmisChild, mrmisinfent;
    private boolean notFailed;
    private InputStream inputStream;
    private List<String> list_nationalites = new ArrayList<>();
    private String MDataMrmisAdult, MDataMrmisChild, MDataMrmisInfent ,MDataMrmisChild2,
    MDataMrmisChild3,
            MDataMrmisChild4,
    MDataMrmisChild5;

    RelativeLayout relative_back_passenger_inform;
    ImageView iv_booked_passenger_inform;
    private boolean rightAge;
    private DatePickerDialog.OnDateSetListener mDateSetListener7;
    private DatePickerDialog.OnDateSetListener mDateSetListener8;
    private String MDataMrmisAdult2;
    private DatePickerDialog.OnDateSetListener mDateSetListener9 , mDateSetListener10 , mDateSetListener11 , mDateSetListener12 , mDateSetListener13 , mDateSetListener14 ,
            mDateSetListener15  , mDateSetListener16 ,  mDateSetListener17  ,   mDateSetListener18,
    mDateSetListener19,
            mDateSetListener20,
    mDateSetListener21   ,    mDateSetListener22,
    mDateSetListener23,
            mDateSetListener24,
    mDateSetListener25;
    private String MDataMrmisAdult5 , MDataMrmisAdult4 , MDataMrmisAdult3  ,  MDataMrmisInfent2,
    MDataMrmisInfent3,
            MDataMrmisInfent4,
    MDataMrmisInfent5 ;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_inform);
        ButterKnife.bind(this);


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
                onBackPressed();
            }
        });
        nationality_adult = findViewById(R.id.nationality_adult1);
        nationality_child = findViewById(R.id.nationality_child1);
        nationality_adult_infant = findViewById(R.id.nationality_adult_infant1);
        datebirthadult = findViewById(R.id.date_of_birth_adult1);
        datebirthchild = findViewById(R.id.date_of_birth_child1);
        datebirthinfant = findViewById(R.id.date_of_birth_adult_infant1);
//
        confirm = findViewById(R.id.passenger_btn_info);
        mrmisAdult = findViewById(R.id.mromiss1);
        mrmisChild = findViewById(R.id.mromiss_child1);
        mrmisinfent = findViewById(R.id.mromiss_infant1);


        long adult = SharedPreferencesManger.LoadLongData(this, "adult");
        long child = SharedPreferencesManger.LoadLongData(this, "child");
        long infant = SharedPreferencesManger.LoadLongData(this, "infant");


        dateOfBirthAdult2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openAdultAge(mDateSetListener6);


            }
        });
        mDateSetListener6 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                dateOfBirthAdult2.setText(date);
                String age = getAge(year, month, day);

                int ageInt = Integer.parseInt(age);

                if (ageInt < 18) {
                    rightAge = false;


                } else {
                    rightAge = true;


                }


            }

        };
        tvIssueDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Passenger_inform.this,
                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar
                        ,
                        mDateSetListener7,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();



            }
        });
        mDateSetListener7 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                tvIssueDate2.setText(date);



            }

        };

        tvEndDat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Passenger_inform.this,
                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar
                        ,
                        mDateSetListener8,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();





            }
        });
        mDateSetListener8 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                tvEndDat2.setText(date);



            }

        };

        switch ((int) adult) {

            case 2:

                relativeAdult2.setVisibility(View.VISIBLE);

                break;

            case 3:
                relativeAdult2.setVisibility(View.VISIBLE);
                relativeAdult3.setVisibility(View.VISIBLE);

                break;

            case 4:
                relativeAdult2.setVisibility(View.VISIBLE);
                relativeAdult3.setVisibility(View.VISIBLE);
                relativeAdult4.setVisibility(View.VISIBLE);

                break;

            case 5:

                relativeAdult2.setVisibility(View.VISIBLE);
                relativeAdult3.setVisibility(View.VISIBLE);
                relativeAdult4.setVisibility(View.VISIBLE);
                relativeAdult5.setVisibility(View.VISIBLE);

        }


        switch ((int) child) {

            case 1:

                relativeChild1.setVisibility(View.VISIBLE);

                break;


            case 2:
                relativeChild1.setVisibility(View.VISIBLE);
                relativeChild2.setVisibility(View.VISIBLE);
                break;


            case 3:
                relativeChild1.setVisibility(View.VISIBLE);
                relativeChild2.setVisibility(View.VISIBLE);
                relativeChild3.setVisibility(View.VISIBLE);
                break;


            case 4:
                relativeChild1.setVisibility(View.VISIBLE);
                relativeChild2.setVisibility(View.VISIBLE);
                relativeChild3.setVisibility(View.VISIBLE);
                relativeChild4.setVisibility(View.VISIBLE);

                break;


            case 5:
                relativeChild1.setVisibility(View.VISIBLE);
                relativeChild2.setVisibility(View.VISIBLE);
                relativeChild3.setVisibility(View.VISIBLE);
                relativeChild4.setVisibility(View.VISIBLE);
                relativeChild5.setVisibility(View.VISIBLE);


                break;


        }


        switch ((int) infant) {


            case 1:

                relativeInfant1.setVisibility(View.VISIBLE);

                break;


            case 2:
                relativeInfant1.setVisibility(View.VISIBLE);
                relativeInfant2.setVisibility(View.VISIBLE);
                break;


            case 3:
                relativeInfant1.setVisibility(View.VISIBLE);
                relativeInfant2.setVisibility(View.VISIBLE);
                relativeInfant3.setVisibility(View.VISIBLE);
                break;


            case 4:
                relativeInfant1.setVisibility(View.VISIBLE);
                relativeInfant2.setVisibility(View.VISIBLE);
                relativeInfant3.setVisibility(View.VISIBLE);
                relativeInfant4.setVisibility(View.VISIBLE);

                break;


            case 5:
                relativeInfant1.setVisibility(View.VISIBLE);
                relativeInfant2.setVisibility(View.VISIBLE);
                relativeInfant3.setVisibility(View.VISIBLE);
                relativeInfant4.setVisibility(View.VISIBLE);
                relativeInfant5.setVisibility(View.VISIBLE);


                break;


        }

        dateOfBirthAdult3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openAdultAge(mDateSetListener9);

            }
        });

        mDateSetListener9 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                dateOfBirthAdult3.setText(date);

                String age = getAge(year, month, day);

                int ageInt = Integer.parseInt(age);

                if (ageInt < 18) {
                    rightAge = false;


                } else {
                    rightAge = true;


                }

            }

        };


        dateOfBirthAdult4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdultAge(mDateSetListener10);

            }
        });
        mDateSetListener10 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                dateOfBirthAdult4.setText(date);

                String age = getAge(year, month, day);

                int ageInt = Integer.parseInt(age);

                if (ageInt < 18) {
                    rightAge = false;


                } else {
                    rightAge = true;


                }

            }

        };
        dateOfBirthAdult5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                openAdultAge(mDateSetListener11);
            }
        });


        mDateSetListener11 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                dateOfBirthAdult5.setText(date);

                String age = getAge(year, month, day);

                int ageInt = Integer.parseInt(age);

                if (ageInt < 18) {
                    rightAge = false;


                } else {
                    rightAge = true;


                }

            }

        };


        tvIssueDate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openAdultAge(mDateSetListener12);
            }
        });

        mDateSetListener12 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                tvIssueDate3.setText(date);

                String age = getAge(year, month, day);


            }

        };

        tvIssueDate4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdultAge(mDateSetListener13);

            }
        });
        mDateSetListener13 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                tvIssueDate4.setText(date);

                String age = getAge(year, month, day);


            }

        };

        tvIssueDate5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdultAge(mDateSetListener14);

            }
        });
        mDateSetListener14 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                tvIssueDate5.setText(date);



            }

        };


        tvEndDat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdultAge(mDateSetListener15);

            }
        });

        mDateSetListener15 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                tvEndDat3.setText(date);



            }

        };




        tvEndDat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdultAge(mDateSetListener16);

            }
        });
        mDateSetListener16 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                tvEndDat4.setText(date);



            }

        };



        tvEndDat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdultAge(mDateSetListener17);

            }
        });



        mDateSetListener17 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                tvEndDat5.setText(date);



            }

        };










        dateOfBirthChild2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openAdultAge(mDateSetListener18);

            }
        });

        mDateSetListener18 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                dateOfBirthChild2.setText(date);



            }

        };
        dateOfBirthAdult3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdultAge(mDateSetListener19);


            }
        });


        mDateSetListener19 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                dateOfBirthChild3.setText(date);



            }

        };

        dateOfBirthAdult4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openAdultAge(mDateSetListener20);

            }
        });

        mDateSetListener20 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                dateOfBirthChild4.setText(date);



            }

        };
        dateOfBirthAdult5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdultAge(mDateSetListener21);


            }
        });

        mDateSetListener21 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                dateOfBirthChild5.setText(date);



            }

        };








        dateOfBirthAdultInfant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdultAge(mDateSetListener22);


            }
        });

        mDateSetListener22 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                dateOfBirthAdultInfant2.setText(date);



            }

        };



        dateOfBirthAdultInfant3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdultAge(mDateSetListener23);


            }
        });
        mDateSetListener23 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                dateOfBirthAdultInfant3.setText(date);



            }

        };



        dateOfBirthAdultInfant4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdultAge(mDateSetListener24);


            }
        });


        mDateSetListener24 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                dateOfBirthAdultInfant4.setText(date);



            }

        };


        dateOfBirthAdultInfant5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdultAge(mDateSetListener25);


            }
        });


        mDateSetListener25 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                String date = month + "/" + day + "/" + year;
                dateOfBirthAdultInfant5.setText(date);

            }

        };


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (edFirstName.getText().toString().equals("")) {
                    edFirstName.setError("Invalid First Name");

                } else if (edLastName.getText().toString().equals("")) {

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

                } else if (datebirthadult.getText().toString().equals("DD-MM-YYYY")) {
                    Toast.makeText(Passenger_inform.this, "Invalid DOB", Toast.LENGTH_SHORT).show();
//
//                }else if (datebirthchild.getText().toString().equals("DD-MM-YYYY")) {
//                    Toast.makeText(Passenger_inform.this, "Invalid DOB", Toast.LENGTH_SHORT).show();
//
//                }else if (datebirthinfant.getText().toString().equals("DD-MM-YYYY")) {
//
//                    Toast.makeText(Passenger_inform.this, "Invalid DOB", Toast.LENGTH_SHORT).show();


                } else if (nationality_adult.getText().toString().equals("")) {
                    nationality_adult.setError("Invalid Nationality");

//                }else if (nationality_child.getText().toString().equals("")){
//                    nationality_child.setError("Invalid Nationality");
//
//                }else if (nationality_adult_infant.getText().toString().equals("")){
//                    nationality_adult_infant.setError("Invalid Nationality");


                } else if (tvEndDat.getText().toString().equals("")) {

                    tvEndDat.setError("Invalid End Date");

                } else if (tvIssueDate.getText().toString().equals("")) {

                    tvIssueDate.setError("Invalid Issue Date");

                } else if (passportNo.getText().toString().equals("")) {


                    passportNo.setError("Invalid Passport Number ");
                } else if (!rightAge) {


                    Toast.makeText(Passenger_inform.this, " your Age is less than 18  ", Toast.LENGTH_SHORT).show();


                } else {


                    switch ((int) adult) {


                        case 1:

                            informationAdult1();


                            break;


                        case 2:
                            informationAdult1();
                            informationAdult2();

                            break;

                        case 3:
                            informationAdult1();
                            informationAdult2();
                            informationAdult3();


                            break;

                        case 4:

                            informationAdult1();
                            informationAdult2();
                            informationAdult3();
                            informationAdult4();

                            break;

                        case 5:

                            informationAdult1();
                            informationAdult2();
                            informationAdult3();
                            informationAdult4();
                            informationAdult5();

                            break;

                    }


                    switch ((int) child) {

                        case 1:

                            infprmationChild1();

                            break;


                        case 2:
                            infprmationChild1();
                            infprmationChild2();

                            break;


                        case 3:
                            infprmationChild1();
                            infprmationChild2();
                            infprmationChild3();

                            break;


                        case 4:

                            infprmationChild1();
                            infprmationChild2();
                            infprmationChild3();
                            infprmationChild4();

                            break;


                        case 5:


                            infprmationChild1();
                            infprmationChild2();
                            infprmationChild3();
                            infprmationChild4();
                            infprmationChild5();

                            break;


                    }


                    switch ((int) infant) {


                        case 1:

                            informationInfant1();
                            break;


                        case 2:
                            informationInfant1();
                            informationInfant2();

                            break;


                        case 3:
                            informationInfant1();
                            informationInfant2();
                            informationInfant3();

                            break;


                        case 4:
                            informationInfant1();
                            informationInfant2();
                            informationInfant3();
                            informationInfant4();

                            break;


                        case 5:
                            informationInfant1();
                            informationInfant2();
                            informationInfant3();
                            informationInfant4();
                            informationInfant5();
                            break;


                    }


                    List<SearchFlightsResponse.Segment> segments = (List<SearchFlightsResponse.Segment>) getIntent().getSerializableExtra("segments");
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


            }


        });


        AutoCompleteAdapter adapter5 = new AutoCompleteAdapter(this, R.layout.drop_dowen, android.R.id.text1, list_nationalites);


        nationalityAdult2.setAdapter(adapter5);
        nationalityAdult2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {




            }


        });

        nationalityAdult3.setAdapter(adapter5);
        nationalityAdult3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {




            }


        });


        nationalityAdult4.setAdapter(adapter5);
        nationalityAdult4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {




            }


        });

        nationalityAdult5.setAdapter(adapter5);
        nationalityAdult5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {




            }


        });


        AutoCompleteAdapter adapter3 = new AutoCompleteAdapter(this, R.layout.drop_dowen, android.R.id.text1, list_nationalites);


        nationality_child.setAdapter(adapter3);
        nationality_child.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {




            }


        });


        AutoCompleteAdapter adapter4 = new AutoCompleteAdapter(this, R.layout.drop_dowen, android.R.id.text1, list_nationalites);


        nationality_adult_infant.setAdapter(adapter4);
        nationality_adult_infant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                String nationalite = list_nationalites.get(adapter4.getPosition(adapter4.getItem(position)));


            }


        });





        nationalityChild2.setAdapter(adapter4);
        nationalityChild2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {




            }


        });


        nationalityChild3.setAdapter(adapter4);
        nationalityChild3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {




            }


        });



        nationalityChild4.setAdapter(adapter4);
        nationalityChild4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {




            }


        });



        nationalityChild5.setAdapter(adapter4);
        nationalityChild5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


            }


        });


        nationalityAdultInfant2.setAdapter(adapter4);
        nationalityAdultInfant2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


            }


        });





        nationalityAdultInfant3.setAdapter(adapter4);
        nationalityAdultInfant3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


            }


        });


        nationalityAdultInfant4.setAdapter(adapter4);
        nationalityAdultInfant4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


            }


        });




        nationalityAdultInfant5.setAdapter(adapter4);
        nationalityAdultInfant5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


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


        mromiss2.setAdapter(adapteradult);
        mromiss2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                MDataMrmisAdult2 = mrmiss1array.get(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mromiss3.setAdapter(adapteradult);
        mromiss3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                MDataMrmisAdult3 = mrmiss1array.get(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mromiss4.setAdapter(adapteradult);
        mromiss4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                MDataMrmisAdult4 = mrmiss1array.get(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mromiss5.setAdapter(adapteradult);
        mromiss5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                MDataMrmisAdult5 = mrmiss1array.get(i);


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




        mromissChild2.setAdapter(adapterChild);
        mromissChild2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MDataMrmisChild2 = mrmiss2array.get(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        mromissChild3.setAdapter(adapterChild);
        mromissChild3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MDataMrmisChild3 = mrmiss2array.get(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mromissChild4.setAdapter(adapterChild);
        mromissChild4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MDataMrmisChild4 = mrmiss2array.get(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mromissChild5.setAdapter(adapterChild);
        mromissChild5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MDataMrmisChild5 = mrmiss2array.get(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mromissInfant2.setAdapter(adapterChild);
        mromissInfant2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MDataMrmisInfent2 = mrmiss2array.get(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mromissInfant3.setAdapter(adapterChild);
        mromissInfant3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MDataMrmisInfent3 = mrmiss2array.get(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        mromissInfant4.setAdapter(adapterChild);
        mromissInfant4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MDataMrmisInfent4 = mrmiss2array.get(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mromissInfant5.setAdapter(adapterChild);
        mromissInfant5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MDataMrmisInfent5 = mrmiss2array.get(i);


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

                MDataMrmisInfent = mrmiss3array.get(i);


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
                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar,
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
                String age = getAge(year, month, day);

                int ageInt = Integer.parseInt(age);

                if (ageInt < 18) {
                    rightAge = false;


                } else {
                    rightAge = true;


                }


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
                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar,
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
                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar
                        ,
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


        tvIssueDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Passenger_inform.this,
                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar
                        ,
                        mDateSetListener4,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener4 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                tvIssueDate.setText(date);
            }
        };


        tvEndDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Passenger_inform.this,
                        android.R.style.Theme_Holo_Wallpaper_NoTitleBar
                        ,
                        mDateSetListener5,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener5 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;


                String date = month + "/" + day + "/" + year;
                tvEndDat.setText(date);
            }
        };

    }




    private void infprmationChild2() {


        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameChild2", edFirstNameChild2.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameChild2", edLastNameChild2.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthchild2", dateOfBirthChild2.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_child2", nationalityChild2.getText().toString());

    }


    private void infprmationChild3() {


        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameChild3", edFirstNameChild3.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameChild3", edLastNameChild3.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthchild3", dateOfBirthChild3.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_child3", nationalityChild3.getText().toString());

    }


    private void infprmationChild4() {


        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameChild4", edFirstNameChild4.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameChild4", edLastNameChild4.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthchild4", dateOfBirthChild4.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_child4", nationalityChild4.getText().toString());

    }


    private void infprmationChild5() {


        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameChild5", edFirstNameChild5.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameChild5", edLastNameChild5.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthchild5", dateOfBirthChild5.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_child5", nationalityChild5.getText().toString());

    }


    private void informationAdult5() {
        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameAduld5", edFirstName5.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameAduld5", edLastName5.getText().toString());


        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthadult5", dateOfBirthAdult5.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_adult5", nationalityAdult5.getText().toString());


        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportNo5", passportNo5.getText().toString());
        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportIssue5", tvIssueDate5.getText().toString());
        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportEnd5", tvEndDat5.getText().toString());
        SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisAdult3", MDataMrmisAdult5);


    }

    private void informationAdult4() {
        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameAduld4", edFirstName4.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameAduld4", edLastName4.getText().toString());


        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthadult4", dateOfBirthAdult4.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_adult4", nationalityAdult4.getText().toString());


        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportNo4", passportNo4.getText().toString());
        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportIssue4", tvIssueDate4.getText().toString());
        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportEnd4", tvEndDat4.getText().toString());
        SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisAdult4", MDataMrmisAdult4);


    }

    private void informationAdult3() {
        SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisAdult3", MDataMrmisAdult3);

        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameAduld3", edFirstName3.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameAduld3", edLastName3.getText().toString());


        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthadult3", dateOfBirthAdult3.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_adult3", nationalityAdult3.getText().toString());


        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportNo3", passportNo3.getText().toString());
        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportIssue3", tvIssueDate3.getText().toString());
        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportEnd3", tvEndDat3.getText().toString());
    }

    private void informationAdult2() {

        SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisAdult2", MDataMrmisAdult2);

        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameAduld2", edFirstName2.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameAduld2", edLastName2.getText().toString());


        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthadult2", dateOfBirthAdult2.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_adult2", nationalityAdult2.getText().toString());


        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportNo2", passportNo2.getText().toString());
        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportIssue2", tvIssueDate2.getText().toString());
        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportEnd2", tvEndDat2.getText().toString());


    }

    private void informationAdult1() {


         SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisAdult", MDataMrmisAdult);

        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameAduld", edFirstName.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameAduld", edLastName.getText().toString());


        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthadult", datebirthadult.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_adult", nationality_adult.getText().toString());


        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportNo", passportNo.getText().toString());
        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportIssue", tvIssueDate.getText().toString());
        SharedPreferencesManger.SaveData(Passenger_inform.this, "passportEnd", tvEndDat.getText().toString());


    }

    private void infprmationChild1() {


        SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisChild", MDataMrmisChild);

        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameChild", edFirstNameChild.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameChild", edLastNameChild.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthchild", datebirthchild.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_child", nationality_child.getText().toString());


    }


    private void informationInfant1() {


        SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisInfent", MDataMrmisInfent);

        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameInfant", edFirstNameInfant.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameInfant", edLastNameInfant.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthinfant", datebirthinfant.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_infant", nationality_adult_infant.getText().toString());


    }


    private void informationInfant2() {


        //     SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisInfent2", MDataMrmisInfent2);

        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameInfant2", edFirstNameInfant2.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameInfant2", edLastNameInfant2.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthinfant2", dateOfBirthAdultInfant2.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_infant2", nationalityAdultInfant2.getText().toString());


    }

    private void informationInfant3() {


        //     SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisInfent2", MDataMrmisInfent2);

        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameInfant3", edFirstNameInfant3.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameInfant3", edLastNameInfant3.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthinfant3", dateOfBirthAdultInfant3.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_infant3", nationalityAdultInfant3.getText().toString());


    }


    private void informationInfant4() {


        //     SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisInfent2", MDataMrmisInfent2);

        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameInfant4", edFirstNameInfant4.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameInfant4", edLastNameInfant4.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthinfant4", dateOfBirthAdultInfant4.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_infant4", nationalityAdultInfant4.getText().toString());


    }


    private void informationInfant5() {


        //     SharedPreferencesManger.SaveData(Passenger_inform.this, "MDataMrmisInfent2", MDataMrmisInfent2);

        SharedPreferencesManger.SaveData(Passenger_inform.this, "FirstNameInfant5", edFirstNameInfant5.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "LastNameInfant5", edLastNameInfant5.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "datebirthinfant5", dateOfBirthAdultInfant5.getText().toString());

        SharedPreferencesManger.SaveData(Passenger_inform.this, "nationality_infant5", nationalityAdultInfant5.getText().toString());


    }


    private String getAge(int year, int month, int day) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }


    public void openAdultAge(DatePickerDialog.OnDateSetListener mDateSetListener  ) {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                Passenger_inform.this,
                android.R.style.Theme_Holo_Wallpaper_NoTitleBar,
                mDateSetListener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();



    }




}