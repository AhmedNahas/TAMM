package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Tamm.Hotels.wcf.ArrayOfInt;
import com.Tamm.Hotels.wcf.ArrayOfRoomGuest;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.CountryList;
import com.Tamm.Hotels.wcf.DestinationCityListResponse;
import com.Tamm.Hotels.wcf.Filters;
import com.Tamm.Hotels.wcf.HotelInfo;
import com.Tamm.Hotels.wcf.HotelSearchResponse;
import com.Tamm.Hotels.wcf.Hotel_Result;
import com.Tamm.Hotels.wcf.MinHotelPrice;
import com.Tamm.Hotels.wcf.RoomGuest;
import com.google.gson.Gson;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.AdapterChildCount;
import net.middledleeast.tamm.adapters.AutoCompleteAdapter;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

import static java.util.Calendar.YEAR;
import static net.middledleeast.tamm.helper.helperMethod.isInternetAvailable;
import static net.middledleeast.tamm.helper.helperMethod.isNetworkConnected;

public class FindHotels extends AppCompatActivity {


    @BindView(R.id.startDate_day)
    TextView startDateDay;
    @BindView(R.id.startDate_month)
    TextView startDateMonth;
    @BindView(R.id.startDate_year)
    TextView startDateYear;
    @BindView(R.id.layout_check)
    LinearLayout layoutCheck;
    @BindView(R.id.endDate_day)
    TextView endDateDay;
    @BindView(R.id.endDate_month)
    TextView endDateMonth;
    @BindView(R.id.endDate_year)
    TextView endDateYear;
    @BindView(R.id.layout_check_out)
    LinearLayout layoutCheckOut;
    @BindView(R.id.findHotels)
    Button findHotels;
    ArrayList<Integer> ratrHotel = new ArrayList<Integer>();

    ImageView iv_booked_find_hotels;

    //    RelativeLayout relativeImgFindHotelTamm;
//    @BindView(R.id.assistant_label_voice_find_hotel)
//    TextView assistantLabelVoiceFindHotel;
//    @BindView(R.id.assistant_label_call_find_hotel)
//    TextView assistantLabelCallFindHotel;
//    @BindView(R.id.assistant_label_message_find_hotel)
//    TextView assistantLabelMessageFindHotel;
    Spinner chooseRate;
    private List<String> listName = new ArrayList<>();
    ArrayList<String> addressHotel = new ArrayList<>();
    private List<String> nameCity = new ArrayList<>();
    private BasicHttpBinding_IHotelService1 service;
    private AuthenticationData authenticationData;
    private boolean checked;
    private String ctyId;
    private List<String> lisNameHotels = new ArrayList<>();
    private String idCountry;
    ArrayList<String> nameHotel = new ArrayList<>();
    Calendar myCalendar;
    ArrayList<String> photoHotel = new ArrayList<>();
    ArrayList<String> listcodeHotel = new ArrayList<>();
    private String hotelAddress;
    private String hotelName;
    private String hotelPicture;
    private Spinner adultCount, childCount;
    private AutoCompleteTextView regions, areas;
    private Spinner room1Adult, childCountRoom1;
    private List<String> listID = new ArrayList<>();
    private String nameCountry;
    private String name_city;
    private TextView nights;
    private String mendTime;
    private String mstartTime;
    private List<Integer> listOfRooms = new ArrayList<>();
    private List<Integer> listOfRate = new ArrayList<>();
    private List<Integer> listOfAdult = new ArrayList<>();
    private int noRomes;
    private String sessionId;
    ArrayList<Integer> arrayOfResultIndex;
    private int resultIndex = 0;
    private Date time1;
    private Date time2;
    private RecyclerView recycl_child_spiner;
    AdapterChildCount room1ChildAgeSpinner;
    private List<Integer> listOfChild = new ArrayList<>();
    private List<Integer> listChildernCount = new ArrayList<>();
    private List<Integer> listChildernCountRoom2 = new ArrayList<>();
    //    private int nom_adult;
    private int mChildCountRoom1;
    private int mChildCountRoom2;

    private List<Integer> listOfChildAge = new ArrayList<>();
    private List<Integer> listOfChildAgeRoom2 = new ArrayList<>();

    boolean chicDateStart = false;
    boolean chicDateEnd = false;
    private RelativeLayout toolbar_back;
    boolean child_mor = false;
    private HotelSearchResponse hotelSearchResponse;
    private CountryList countryList;
    ArrayList<String> listPrice = new ArrayList<>();
    Spinner chooseNumberOfRoomsSpinner;
    private TextView roomCount;
    RelativeLayout room1View;
    RelativeLayout room2View;
    RelativeLayout room3View;
    private RecyclerView room2ChildAgeSpinner;
    private AdapterChildCount adapterChildCountRoom2;
    private AdapterChildCount adapterChildCountRoom3;
    private AdapterChildCount adapterChildCountRoom4;
    private Spinner room3Child;
    private int nom_adultRoom1;
    private int nom_adultRoom2;
    private Spinner room3Adult;
    private int nom_adultRoom3;
    private Spinner room4Adult;
    private int nom_adultRoom4;
    private int mChildCountRoom3;
    private List<Integer> listChildernCountRoom3 = new ArrayList<>();
    private Spinner room4Child;
    private int mChildCountRoom4;
    private List<Integer> listChildernCountRoom4 = new ArrayList<>();
    private RecyclerView room3ChildAgeSpinner;
    private RecyclerView room4ChildAgeSpinner;


    ProgressBar simpleProgressBar;
    private boolean ClickFindHotel = false;
    private Filters filters;
    private boolean counttryCheked = false;


//    private boolean saved ;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_hotels);
        ButterKnife.bind(this);
        auth();


        iv_booked_find_hotels=findViewById(R.id.iv_booked_find_hotels);

        iv_booked_find_hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FindHotels.this,MyBookActivity.class);
                startActivity(intent);
            }
        });
//

        areas = findViewById(R.id.area_spinner);
        regions = findViewById(R.id.region_spinner);




            String dayOfTheWeek = SharedPreferencesManger.LoadStringData(FindHotels.this, "startDateSyear");
        if (dayOfTheWeek!=null){

            startDateYear.setText(dayOfTheWeek);

            String day = SharedPreferencesManger.LoadStringData(FindHotels.this, "startDateSday");
            startDateDay.setText(day);

            String monthString = SharedPreferencesManger.LoadStringData(FindHotels.this, "startDateSmonth");
            startDateMonth.setText(monthString);

            String enddayOfTheWeek = SharedPreferencesManger.LoadStringData(FindHotels.this, "endDateSyear");
            endDateYear.setText(enddayOfTheWeek);

            String endday = SharedPreferencesManger.LoadStringData(FindHotels.this, "endDateSday");
            endDateDay.setText(endday);

            String endmonthString = SharedPreferencesManger.LoadStringData(FindHotels.this, "endDateSmonth");
            endDateMonth.setText(endmonthString);



            String nameCountry =SharedPreferencesManger.LoadStringData(FindHotels.this, "nameCountry_");
            regions.setText(nameCountry);

            String nameCity=SharedPreferencesManger.LoadStringData(FindHotels.this,"name_city_");
            areas.setText(nameCity);








        }else {


            String date_n = new SimpleDateFormat("dd", Locale.getDefault()).format(new Date());
            String date_m = new SimpleDateFormat("MMM", Locale.getDefault()).format(new Date());
            String date_d = new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date());


        endDateDay.setText(date_n);
        endDateMonth.setText(date_m);
        endDateYear.setText(date_d);
        startDateDay.setText(date_n);
        startDateMonth.setText(date_m);
        startDateYear.setText(date_d);


        }

//        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);
//        simpleProgressBar.setVisibility(View.INVISIBLE);
        FrameLayout frameLayout = findViewById(R.id.frame1);

        LayoutInflater inflater = (LayoutInflater) FindHotels.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        room1View = (RelativeLayout) inflater.inflate(R.layout.spinnersfrag2, null);
        frameLayout.addView(room1View);
        TextView room2 = room1View.findViewById(R.id.no_of_rooms);
        room2.setText("Room 2");
        Spinner room2Adult = room1View.findViewById(R.id.adilt_count);
        Spinner room2Child = room1View.findViewById(R.id.no_of_childs);

        room1View.setVisibility(View.INVISIBLE);

        FrameLayout frameLayout1 = findViewById(R.id.frame2);
        LayoutInflater inflater1 = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        room2View = (RelativeLayout) inflater1.inflate(R.layout.spinnersfrag2, null);
        frameLayout1.addView(room2View);
        TextView room3 = room2View.findViewById(R.id.no_of_rooms);
        room3.setText("Room 3");
        room3Adult = room2View.findViewById(R.id.adilt_count);
        room3Child = room2View.findViewById(R.id.no_of_childs);
        room3ChildAgeSpinner = room2View.findViewById(R.id.rv_child);

        room3.setVisibility(View.INVISIBLE);

        FrameLayout frameLayout2 = findViewById(R.id.frame3);
        LayoutInflater inflater2 = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        room3View = (RelativeLayout) inflater2.inflate(R.layout.spinnersfrag2, null);
        frameLayout2.addView(room3View);
        TextView room4 = room3View.findViewById(R.id.no_of_rooms);
        room4.setText("Room 4");
        room4Adult = room3View.findViewById(R.id.adilt_count);
        room4Child = room3View.findViewById(R.id.no_of_childs);
        room4.setVisibility(View.INVISIBLE);
        room4ChildAgeSpinner = room3View.findViewById(R.id.rv_child);


        roomCount = findViewById(R.id.no_of_rooms);
        room1Adult = findViewById(R.id.adilt_count);
        childCountRoom1 = findViewById(R.id.no_of_childs);
        chooseNumberOfRoomsSpinner = findViewById(R.id.chooseroom);
//        startDate = findViewById(R.id.startDate);
//        endDate = findViewById(R.id.endDate);
        nights = findViewById(R.id.nights);
        toolbar_back = findViewById(R.id.toolbar_back1);
        recycl_child_spiner = findViewById(R.id.rv_child);
        room2ChildAgeSpinner = room1View.findViewById(R.id.rv_child);




        if (!isNetworkConnected(this)){



            new SweetAlertDialog(FindHotels.this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Please Check Your Internet first ")
                    .setConfirmText("Ok")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {

                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();


        }



        if (regions.getText().equals("")&&regions.getText().equals("COUNTRY")){

            counttryCheked =false;


        }else {

            counttryCheked =true;
        }

//        relativeImgFindHotelTamm = findViewById(R.id.relative_img_find_hotel_tamm);


//        relativeImgFindHotelTamm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (ClickFindHotel == false) {
//                    assistantLabelCallFindHotel.setVisibility(View.VISIBLE);
//                    assistantLabelMessageFindHotel.setVisibility(View.VISIBLE);
//                    assistantLabelVoiceFindHotel.setVisibility(View.VISIBLE);
//                    ClickFindHotel = true;
//
//                } else {
//                    assistantLabelCallFindHotel.setVisibility(View.INVISIBLE);
//                    assistantLabelMessageFindHotel.setVisibility(View.INVISIBLE);
//                    assistantLabelVoiceFindHotel.setVisibility(View.INVISIBLE);
//                    ClickFindHotel = false;
//
//                }
//
//            }
//        });

//        assistantLabelCallFindHotel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(FindHotels.this, "Call", Toast.LENGTH_SHORT).show();
//            }
//        });

//        assistantLabelMessageFindHotel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(FindHotels.this, "Message", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        assistantLabelVoiceFindHotel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(FindHotels.this, "Voice", Toast.LENGTH_SHORT).show();
//
//            }
//        });


        toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindHotels.this, ReserveRoom.class));
            }
        });

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        //   auth();


//if (saved==true){
//
//    final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class,
//            "country").allowMainThreadQueries().fallbackToDestructiveMigration().build();
//
//    List<RoomcountrytModel> allData = db.CountryDeo().getAllData();
//
//    for (int i = 0; i < allData.size(); i++) {
//
//        String code = allData.get(i).getCode();
//        String name = allData.get(i).getName();
//
//        list.add(name);
//        listID.add(code);
//
//        Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
//
//    }
//
//}else {

        //   getCountries();

//}


        getCountries();


        recycl_child_spiner.setLayoutManager(new GridLayoutManager(this, 2));
        room2ChildAgeSpinner.setLayoutManager(new GridLayoutManager(this, 2));
        room3ChildAgeSpinner.setLayoutManager(new GridLayoutManager(this, 2));
        room4ChildAgeSpinner.setLayoutManager(new GridLayoutManager(this, 2));

        for (int i = 0; i < 19; i++) {
            listOfChildAge.add(i);
        }
        for (int i = 0; i < 19; i++) {
            listOfChildAgeRoom2.add(i);
        }
        room1ChildAgeSpinner = new AdapterChildCount(this, listChildernCount, listOfChildAge, this, 1);
        adapterChildCountRoom2 = new AdapterChildCount(this, listChildernCountRoom2, listOfChildAge, this, 2);
        adapterChildCountRoom3 = new AdapterChildCount(this, listChildernCountRoom3, listOfChildAge, this, 3);
        adapterChildCountRoom4 = new AdapterChildCount(this, listChildernCountRoom4, listOfChildAge, this, 4);

        recycl_child_spiner.setAdapter(room1ChildAgeSpinner);

        room1ChildAgeSpinner.notifyDataSetChanged();
        room2ChildAgeSpinner.setAdapter(adapterChildCountRoom2);
        adapterChildCountRoom2.notifyDataSetChanged();
        room3ChildAgeSpinner.setAdapter(adapterChildCountRoom3);
        adapterChildCountRoom3.notifyDataSetChanged();
        room4ChildAgeSpinner.setAdapter(adapterChildCountRoom4);
        adapterChildCountRoom4.notifyDataSetChanged();

//        listOfChild.add(0);
        list1();
        listOfChildCount();


        // FIXME: 7/31/2019  check

        for (int r = 1; r < 6; r++) {

            listOfRate.add(r);
        }

        arrayOfResultIndex = new ArrayList<>();
        noRomes = 1;
        for (int i = 1; i < 5; i++) {

            listOfRooms.add(i);
        }
        ArrayList<Integer> noOfROoms = new ArrayList();
        for (int i = 0; i < 4; i++) {
            noOfROoms.add(i + 1);
        }


//        ArrayAdapter adapterRateCount = new ArrayAdapter(FindHotels.this, R.layout.item_spener, listOfRate);
//
//        adapterRateCount.setDropDownViewResource(R.layout.drop_dowen);
//        chooseRate.setDropDownWidth(420);
//        chooseRate.setDropDownVerticalOffset(200);
//        chooseRate.setAdapter(adapterRateCount);
//        chooseRate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                int position = listOfRate.get(i);
//
//                switch (position) {
//
//                    case 0:
//                        filters = new Filters();
//                        filters.StarRating = Enums.HotelRatingInput.All;
//                        break;
//                    case 1:
//
//                        filters = new Filters();
//                        filters.StarRating = Enums.HotelRatingInput.OneStarOrLess;
//
//                        break;
//                    case 2:
//
//                        filters = new Filters();
//                        filters.StarRating = Enums.HotelRatingInput.TwoStarOrLess;
//
//                        break;
//                    case 3:
//
//                        filters = new Filters();
//                        filters.StarRating = Enums.HotelRatingInput.ThreeStarOrLess;
//
//                        break;
//                    case 4:
//
//                        filters = new Filters();
//                        filters.StarRating = Enums.HotelRatingInput.FourStarOrLess;
//
//                        break;
//                    case 5:
//
//                        filters = new Filters();
//                        filters.StarRating = Enums.HotelRatingInput.FiveStarOrMore;
//
//                    default:
//
//                        return;
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


        ArrayAdapter adapterRoomCount = new ArrayAdapter(FindHotels.this, R.layout.item_spener, listOfRooms);

        ArrayAdapter numberOfRoomsAdapter = new ArrayAdapter(this, R.layout.item_spener, noOfROoms);
        numberOfRoomsAdapter.setDropDownViewResource(R.layout.drop_dowen);
        chooseNumberOfRoomsSpinner.setDropDownWidth(420);
        chooseNumberOfRoomsSpinner.setDropDownVerticalOffset(200);
        chooseNumberOfRoomsSpinner.setAdapter(numberOfRoomsAdapter);
        chooseNumberOfRoomsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        noRomes = 1;

                        room1View.setVisibility(View.INVISIBLE);
                        room2View.setVisibility(View.INVISIBLE);
                        room3View.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
//                        listOfAdult.clear();
//                        listOfChild.clear();
//                        list1();
//                        listOfChildCount();


                        noRomes = 2;
                        room1View.setVisibility(View.VISIBLE);
                        room2View.setVisibility(View.INVISIBLE);
                        room3View.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
//                        listOfAdult.clear();
                        noRomes = 3;
//                        listOfChild.clear();
//                        list2();
//                        listOfChildCount2();
                        room1View.setVisibility(View.VISIBLE);
                        room2View.setVisibility(View.VISIBLE);
                        room3View.setVisibility(View.INVISIBLE);
                        room3.setVisibility(View.VISIBLE);

                        break;
                    case 3:
                        room1View.setVisibility(View.VISIBLE);
                        room2View.setVisibility(View.VISIBLE);
                        room3View.setVisibility(View.VISIBLE);
                        room3.setVisibility(View.VISIBLE);
                        room4.setVisibility(View.VISIBLE);
                        noRomes = 4;
                        break;


                    default:


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                return;
            }
        });

        ArrayAdapter adapteradult = new ArrayAdapter(FindHotels.this, R.layout.item_spener, listOfAdult);

        adapteradult.setDropDownViewResource(R.layout.drop_dowen);
        room1Adult.setDropDownWidth(420);
        room1Adult.setDropDownVerticalOffset(200);
        room1Adult.setAdapter(adapteradult);
        room1Adult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                nom_adultRoom1 = listOfAdult.get(i);
                SharedPreferencesManger.SaveData(FindHotels.this, "no_adultroom1", nom_adultRoom1);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //duplicate for room 2 test

        room2Adult.setDropDownWidth(420);
        room2Adult.setDropDownVerticalOffset(200);
        room2Adult.setAdapter(adapteradult);
        room2Adult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

// TODO: 27/07/19 add for room 2
                nom_adultRoom2 = listOfAdult.get(i);
                SharedPreferencesManger.SaveData(FindHotels.this, "no_adultroom2", nom_adultRoom2);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        room3Adult.setDropDownWidth(420);
        room3Adult.setDropDownVerticalOffset(200);
        room3Adult.setAdapter(adapteradult);
        room3Adult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

// TODO: 27/07/19 add for room 2
                nom_adultRoom3 = listOfAdult.get(i);
                SharedPreferencesManger.SaveData(FindHotels.this, "no_adultroom3", nom_adultRoom3);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        room4Adult.setDropDownWidth(420);
        room4Adult.setDropDownVerticalOffset(200);
        room4Adult.setAdapter(adapteradult);
        room4Adult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

// TODO: 27/07/19 add for room 2
                nom_adultRoom4 = listOfAdult.get(i);
                SharedPreferencesManger.SaveData(FindHotels.this, "no_adultroom4", nom_adultRoom4);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


//    }

//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
//});


        ArrayAdapter adapterchild = new ArrayAdapter(FindHotels.this, R.layout.item_spener, listOfChild);

        adapterchild.setDropDownViewResource(R.layout.drop_dowen);
        childCountRoom1.setDropDownWidth(420);
        childCountRoom1.setDropDownVerticalOffset(200);
        childCountRoom1.setAdapter(adapterchild);
        childCountRoom1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i != 0) {


                    if (i == 1) {

                        mChildCountRoom1 = 1;
                        listChildernCount.clear();
                        for (int j = 1; j < 2; j++) {
                            listChildernCount.add(j);
                            room1ChildAgeSpinner.notifyDataSetChanged();
                        }
                    } else if (i == 2) {
                        mChildCountRoom1 = 2;
                        listChildernCount.clear();
                        for (int j = 1; j < 3; j++) {
                            listChildernCount.add(j);
                            room1ChildAgeSpinner.notifyDataSetChanged();
                        }
                    } else if (i == 3) {
                        mChildCountRoom1 = 3;
                        listChildernCount.clear();
                        for (int j = 1; j < 4; j++) {
                            listChildernCount.add(j);
                            room1ChildAgeSpinner.notifyDataSetChanged();
                        }
                    } else if (i == 4) {
                        mChildCountRoom1 = 4;

                        listChildernCount.clear();
                        for (int j = 1; j < 5; j++) {

                            listChildernCount.add(j);
                            room1ChildAgeSpinner.notifyDataSetChanged();

                        }
                    }


                } else {
                    mChildCountRoom1 = 0;
                    listChildernCount.clear();
                    room1ChildAgeSpinner.notifyDataSetChanged();
                }

                SharedPreferencesManger.SaveData(FindHotels.this, "no_childroom1", mChildCountRoom1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //duplicate for room 2 children

        room2Child.setDropDownWidth(420);
        room2Child.setDropDownVerticalOffset(200);
        room2Child.setAdapter(adapterchild);
        room2Child.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i != 0) {


                    if (i == 1) {

                        // TODO: 27/07/19 change all
                        mChildCountRoom2 = 1;
                        listChildernCountRoom2.clear();
                        for (int j = 1; j < 2; j++) {
                            listChildernCountRoom2.add(j);
                            adapterChildCountRoom2.notifyDataSetChanged();
                        }
                    } else if (i == 2) {
                        mChildCountRoom2 = 2;
                        listChildernCountRoom2.clear();
                        for (int j = 1; j < 3; j++) {
                            listChildernCountRoom2.add(j);
                            adapterChildCountRoom2.notifyDataSetChanged();
                        }
                    } else if (i == 3) {
                        mChildCountRoom2 = 3;
                        listChildernCountRoom2.clear();
                        for (int j = 1; j < 4; j++) {
                            listChildernCountRoom2.add(j);
                            adapterChildCountRoom2.notifyDataSetChanged();
                        }
                    } else if (i == 4) {
                        mChildCountRoom2 = 4;

                        listChildernCountRoom2.clear();
                        for (int j = 1; j < 5; j++) {

                            listChildernCountRoom2.add(j);
                            adapterChildCountRoom2.notifyDataSetChanged();

                        }
                    }


                } else {
                    mChildCountRoom2 = 0;
                    listChildernCountRoom2.clear();
                    adapterChildCountRoom2.notifyDataSetChanged();
                }

                SharedPreferencesManger.SaveData(FindHotels.this, "no_childroom2", mChildCountRoom2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        room3Child.setDropDownWidth(420);
        room3Child.setDropDownVerticalOffset(200);
        room3Child.setAdapter(adapterchild);
        room3Child.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i != 0) {


                    if (i == 1) {

                        // TODO: 27/07/19 change all
                        mChildCountRoom3 = 1;
                        listChildernCountRoom3.clear();
                        for (int j = 1; j < 2; j++) {
                            listChildernCountRoom3.add(j);
                            adapterChildCountRoom3.notifyDataSetChanged();
                        }
                    } else if (i == 2) {
                        mChildCountRoom3 = 2;
                        listChildernCountRoom3.clear();
                        for (int j = 1; j < 3; j++) {
                            listChildernCountRoom3.add(j);
                            adapterChildCountRoom3.notifyDataSetChanged();
                        }
                    } else if (i == 3) {
                        mChildCountRoom3 = 3;
                        listChildernCountRoom3.clear();
                        for (int j = 1; j < 4; j++) {
                            listChildernCountRoom3.add(j);
                            adapterChildCountRoom3.notifyDataSetChanged();
                        }
                    } else if (i == 4) {
                        mChildCountRoom3 = 4;

                        listChildernCountRoom3.clear();
                        for (int j = 1; j < 5; j++) {

                            listChildernCountRoom3.add(j);
                            adapterChildCountRoom3.notifyDataSetChanged();

                        }
                    }


                } else {
                    mChildCountRoom3 = 0;
                    listChildernCountRoom3.clear();
                    adapterChildCountRoom3.notifyDataSetChanged();
                }

                SharedPreferencesManger.SaveData(FindHotels.this, "no_childroom3", mChildCountRoom3);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        room4Child.setDropDownWidth(420);
        room4Child.setDropDownVerticalOffset(200);
        room4Child.setAdapter(adapterchild);
        room4Child.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i != 0) {


                    if (i == 1) {

                        // TODO: 27/07/19 change all
                        mChildCountRoom4 = 1;
                        listChildernCountRoom4.clear();
                        for (int j = 1; j < 2; j++) {
                            listChildernCountRoom4.add(j);
                            adapterChildCountRoom4.notifyDataSetChanged();
                        }
                    } else if (i == 2) {
                        mChildCountRoom4 = 2;
                        listChildernCountRoom4.clear();
                        for (int j = 1; j < 3; j++) {
                            listChildernCountRoom4.add(j);
                            adapterChildCountRoom4.notifyDataSetChanged();
                        }
                    } else if (i == 3) {
                        mChildCountRoom4 = 3;
                        listChildernCountRoom4.clear();
                        for (int j = 1; j < 4; j++) {
                            listChildernCountRoom4.add(j);
                            adapterChildCountRoom4.notifyDataSetChanged();
                        }
                    } else if (i == 4) {
                        mChildCountRoom4 = 4;

                        listChildernCountRoom4.clear();
                        for (int j = 1; j < 5; j++) {

                            listChildernCountRoom4.add(j);
                            adapterChildCountRoom4.notifyDataSetChanged();

                        }
                    }


                } else {
                    mChildCountRoom4 = 0;
                    listChildernCountRoom4.clear();
                    adapterChildCountRoom4.notifyDataSetChanged();
                }

                SharedPreferencesManger.SaveData(FindHotels.this, "no_childroom4", mChildCountRoom4);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        myCalendar = Calendar.getInstance();
//        startDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                dilogstart();
//
//            }
//        });


//        endDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                dialogendTime();
//
//
//            }
//        });


    }


    @SuppressLint("ClickableViewAccessibility")
    private void getCountries() {


        // get all name country in string
        String name_country = SharedPreferencesManger.LoadStringData(FindHotels.this, "name_country");
        Gson gson = new Gson();
        listName = gson.fromJson(name_country, ArrayList.class);


        String code_country = SharedPreferencesManger.LoadStringData(FindHotels.this, "code_country");

        Gson gson2 = new Gson();
        listID = gson2.fromJson(code_country, ArrayList.class);


        //list of cod country


//        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item_spener, listName);
//        adapter.setDropDownViewResource(R.layout.drop_dowen);
//        regions.setDropDownWidth(420);
//        regions.setDropDownVerticalOffset(200);
//        regions.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//


//        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item_spener, listName);
//        adapter.setDropDownViewResource(R.layout.drop_dowen);
//        regions.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//

        AutoCompleteAdapter adapter2 = new AutoCompleteAdapter(this, R.layout.drop_dowen, android.R.id.text1, listName);

        regions.setAdapter(adapter2);


        regions.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                regions.showDropDown();
                return false;
            }
        });


        regions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                nameCountry = listName.get(adapter2.getPosition(adapter2.getItem(position)));
                SharedPreferencesManger.SaveData(FindHotels.this,"nameCountry_",nameCountry);
                idCountry = listID.get(adapter2.getPosition(adapter2.getItem(position)));

                getCities(idCountry);


            }

        });


        // String test = hotelSearchResponse.Status.Description;
//            System.out.println("Hello: " + test);

    }

    private void listOfChildCount() {

        for (int i = 0; i < 3; i++) {
            listOfChild.add(i);
        }


    }


    private void listOfChildCount2() {

        for (int i = 0; i < 3; i++) {
            listOfChild.add(i);
        }


    }

    private void list1() {

        for (int i = 1; i < 5; i++) {


            listOfAdult.add(i);
        }


    }

    private void list2() {

        for (int i = 1; i < 13; i++) {


            listOfAdult.add(i);
        }


    }


    @SuppressLint("ClickableViewAccessibility")
    private void getCities(String idCountry) {

        nameCity.clear();

        try {
            DestinationCityListResponse cities = service.DestinationCityList(idCountry, "true", authenticationData);
            for (int j = 0; j < cities.CityList.size(); j++) {


                String cityName = cities.CityList.get(j).CityName;
                nameCity.add(cityName);


                AutoCompleteAdapter adapter2 = new AutoCompleteAdapter(this, R.layout.drop_dowen, android.R.id.text1, nameCity);

                areas.setAdapter(adapter2);


                areas.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean b) {

                        if (b) {

                            areas.getOnFocusChangeListener();
                        } else {

                            areas.getOnFocusChangeListener();
                        }

                    }
                });

                areas.setOnTouchListener(new View.OnTouchListener() {

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        areas.showDropDown();
                        return false;
                    }
                });


                areas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                        name_city = nameCity.get(adapter2.getPosition(adapter2.getItem(position)));
                        SharedPreferencesManger.SaveData(FindHotels.this,"name_city_",name_city);
                        ctyId = cities.CityList.get(adapter2.getPosition(adapter2.getItem(position))).CityCode;


                    }

                });

            }

            areas.setText("");


        } catch (Exception e) {
            e.printStackTrace();
        }//

    }

    private void gethotelsInfo(String ctyId) {


//        Calendar cal1 = Calendar.getInstance();
//        cal1.set(Calendar.DAY_OF_MONTH, 22);
//        Calendar cal2 = Calendar.getInstance();
//        cal2.set(Calendar.DAY_OF_MONTH, 23);
//        DateTime date1 = DateTime.parse(mstartTime);
//        DateTime date2 = DateTime.parse(mendTime);
////        date1 = date1.plusDays(4);
////        date2 = date2.plusDays(7);
//
//        ArrayOfRoomGuest roomguests = new ArrayOfRoomGuest();
//
//        service.enableLogging = true;
//        ArrayList<String> childAgeStringArray = new ArrayList<>();
//        childAgeStringArray.add(SharedPreferencesManger.LoadStringData(this, "child_countroom1"));
//        childAgeStringArray.add(SharedPreferencesManger.LoadStringData(this, "child_countroom2"));
//        childAgeStringArray.add(SharedPreferencesManger.LoadStringData(this, "child_countroom3"));
//        childAgeStringArray.add(SharedPreferencesManger.LoadStringData(this, "child_countroom4"));
//
//        ArrayList<Integer> adultCountArray = new ArrayList<>();
//        adultCountArray.add(nom_adultRoom1);
//        adultCountArray.add(nom_adultRoom2);
//        adultCountArray.add(nom_adultRoom3);
//        adultCountArray.add(nom_adultRoom4);
//        ArrayList<Integer> childCountArray = new ArrayList<>();
//        childCountArray.add(mChildCountRoom1);
//        childCountArray.add(mChildCountRoom2);
//        childCountArray.add(mChildCountRoom3);
//        childCountArray.add(mChildCountRoom4);
//
//        for (int i = 0; i < noRomes; i++) {
//
//            RoomGuest roomGuest = new RoomGuest();
//            roomGuest.AdultCount = adultCountArray.get(i);
//            roomGuest.ChildCount = childCountArray.get(i);
//            roomGuest.ChildAge = new ArrayOfInt();
//            if (roomGuest.ChildCount == 0) {
//                roomGuest.ChildAge = null;
//            } else {
//                String child_count = childAgeStringArray.get(i);
//                child_count= child_count.replace("[", "");
//                child_count = child_count.replace("]", "");
//                StringTokenizer st = new StringTokenizer(child_count.trim(), ",");
//
//                while (st.hasMoreTokens()) {
//
//                    // child age count
//                    String ageChildCount = st.nextToken().trim();
//                    roomGuest.ChildAge.add(Integer.parseInt(ageChildCount));
//
//                }
//            }
//            roomguests.add(roomGuest);
//
//            SharedPreferencesManger.SaveData(this, "roomGuests", new Gson().toJson(roomguests));
//        }
//
//
//        try {
//            //HotelSearchResponse hotelSearchResponse = service.HotelSearch1(date1.toDateTimeISO(), date2.toDateTimeISO(), Integer.parseInt(ctyId), 1, roomguests, "EG", authenticationData);
//
//
//            hotelSearchResponse = service.HotelSearch(date1.toString("yyyy-MM-dd"), date2.toString("yyyy-MM-dd"), nameCountry, name_city, Integer.parseInt(ctyId),
//                    true, noRomes, "EG", roomguests, null, 100, filters, "true", null,
//                    10000, authenticationData);
//
//
//
//
////            HotelSearchWithRoomsResponse hotelSearchWithRoomsResponse = service.HotelSearchWithRooms(date1.toString("yyyy-MM-dd"), date2.toString("yyyy-MM-dd"), nameCountry,name_city,Integer.parseInt(ctyId),
////                    true, noRomes, "EG", roomguests, null, 100, null, null, false, authenticationData);
//
//
//            listPrice.clear();
//            ratrHotel.clear();
//            nameHotel.clear();
//            photoHotel.clear();
//            listcodeHotel.clear();
//            addressHotel.clear();
//            arrayOfResultIndex.clear();
//
//
//            if (hotelSearchResponse.HotelResultList != null) {
//                for (int i = 0; i < hotelSearchResponse.HotelResultList.size(); i++) {
//
//                    Hotel_Result hotel_result = hotelSearchResponse.HotelResultList.get(i);
//                    MinHotelPrice minHotelPrice = hotelSearchResponse.HotelResultList.get(i).MinHotelPrice;
//                    String currency = minHotelPrice.OriginalPrice.toString();
//                    String currency1 = minHotelPrice.Currency;
//                    listPrice.add(currency1 + " " + currency);
//                    HotelInfo hotelInfo = hotel_result.HotelInfo;
//                    sessionId = hotelSearchResponse.SessionId;
//                    hotelAddress = hotelInfo.HotelAddress;
//                    hotelName = hotelInfo.HotelName;
//                    hotelPicture = hotelInfo.HotelPicture;
//                    int code = hotelInfo.Rating.getCode();
//
//
//                    arrayOfResultIndex.add(hotel_result.ResultIndex);
//
//                    String hotelCode = hotelInfo.HotelCode;
//
//                    listcodeHotel.add(hotelCode);
//
//                    nameHotel.add(hotelName);
//                    ratrHotel.add(code);
//                    photoHotel.add(hotelPicture);
//                    addressHotel.add(hotelAddress);
//
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        Intent intent = new Intent(FindHotels.this, ChooseHotelActivity.class);
//        intent.putExtra("hotelName", nameHotel);
//        intent.putExtra("hotelrat", ratrHotel);
//        intent.putExtra("hotelPhoto", photoHotel);
//        intent.putExtra("hotelCode", listcodeHotel);
//        intent.putExtra("hotelAddress", addressHotel);
//        intent.putExtra("checkInDate", mstartTime);
//        intent.putExtra("checkOutDate", mendTime);
//        intent.putExtra("countryName", nameCountry);
//        intent.putExtra("cityName", name_city);
//        intent.putExtra("cityId", ctyId);
//        intent.putExtra("noOfRooms", noRomes);
//        intent.putExtra("list_price", listPrice);
//        SharedPreferencesManger.SaveData(this, "noOfRooms", noRomes);
//        intent.putExtra("resultIndex", arrayOfResultIndex);
//
//
//        // intent.putExtra("roomGuest",roomguests);
//        startActivity(intent);
//
//
//

        DoSomeTask task = new DoSomeTask();
        task.execute();

    }

    private void auth() {

        service = new BasicHttpBinding_IHotelService1();
        service.enableLogging = true;
        authenticationData = new AuthenticationData();
        authenticationData.UserName = (getString(R.string.user_name_tamm));
        authenticationData.Password = (getString(R.string.passowrd_tamm));

    }


    private void dilogstart() {

        chicDateStart = true;
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "yyyy-MM-dd"; //In which you need put here
                SimpleDateFormat start = new SimpleDateFormat(myFormat, Locale.US);
                time1 = myCalendar.getTime();
                mstartTime = start.format(myCalendar.getTime());
                //  startDate.setText(mstartTime);

                long time = time1.getTime();
                long timedev = formatTimeForEvent(time);


                String dayOfTheWeek = (String) DateFormat.format("EEEE", time); // Thursday
                String day = (String) DateFormat.format("dd", time); // Thursday
                String monthString = (String) DateFormat.format("MMM", time); // Thursday
                String day2 = (String) DateFormat.format("dd", time+86400000); // Thursday


                SharedPreferencesManger.SaveData(FindHotels.this, "startDateS", dayOfTheWeek + " " + day + " " + monthString + " " + "till ");

                SharedPreferencesManger.SaveData(FindHotels.this, "startDateSyear", dayOfTheWeek );
                SharedPreferencesManger.SaveData(FindHotels.this, "startDateSday",  day );
                SharedPreferencesManger.SaveData(FindHotels.this, "startDateSmonth",  monthString);

                startDateDay.setText(day);
                startDateMonth.setText(monthString);
                startDateYear.setText(dayOfTheWeek);



                endDateDay.setText(day2);
                endDateMonth.setText(monthString);
                endDateYear.setText(dayOfTheWeek);

            }
        };


        new DatePickerDialog(FindHotels.this, date, myCalendar.get(YEAR),
                myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

    }


    private void dialogendTime() {

        chicDateEnd = true;
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "yyyy-MM-dd"; //In which you need put here
                SimpleDateFormat end = new SimpleDateFormat(myFormat);

                time2 = myCalendar.getTime();

                mendTime = end.format(myCalendar.getTime());
                // endDate.setText(mendTime);

                long time = time2.getTime();

                String dayOfTheWeek = (String) DateFormat.format("EEEE", time); // Thursday
                String day = (String) DateFormat.format("dd", time); // Thursday
                String monthString = (String) DateFormat.format("MMM", time); // Thursday


                endDateDay.setText(day);
                endDateMonth.setText(monthString);
                endDateYear.setText(dayOfTheWeek);

                long diff = time2.getTime() - time1.getTime();

                long seconds = diff / 1000;
                long minutes = seconds / 60;
                long hours = minutes / 60;
                long days = hours / 24;

                String date_n = new SimpleDateFormat("dd", Locale.getDefault()).format(new Date());
                String date_m = new SimpleDateFormat("MMM", Locale.getDefault()).format(new Date());
                String date_d = new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date());


                if (days < 0) {
                    Toast.makeText(FindHotels.this, "Choose Correct Date", Toast.LENGTH_SHORT).show();


                    endDateDay.setText(date_n);
                    endDateMonth.setText(date_m);
                    endDateYear.setText(date_d);


                } else {

                    nights.setText(" " + days + " ");
                    SharedPreferencesManger.SaveData(FindHotels.this, "nights", days);

                    SharedPreferencesManger.SaveData(FindHotels.this, "endDateS", dayOfTheWeek + " " + day + " " + monthString + " " + "-" + days + "  nights");

                    SharedPreferencesManger.SaveData(FindHotels.this, "endDateSyear", dayOfTheWeek );
                    SharedPreferencesManger.SaveData(FindHotels.this, "endDateSday",  day );
                    SharedPreferencesManger.SaveData(FindHotels.this, "endDateSmonth",  monthString );
                    SharedPreferencesManger.SaveData(FindHotels.this, "endDateSnights",  days + "  nights");

                }

            }
        };


        new DatePickerDialog(FindHotels.this, date, myCalendar.get(YEAR),
                myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

    }


    @OnClick({R.id.layout_check, R.id.layout_check_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_check:

                dilogstart();

                break;
            case R.id.layout_check_out:


                if (!chicDateStart) {
                    new SweetAlertDialog(FindHotels.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("Select Check in Date First")
                            .setConfirmText("open")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    dilogstart();
                                    sDialog.dismissWithAnimation();
                                }
                            })
                            .show();

                } else {

                    dialogendTime();
                }
                break;
        }
    }

    @OnClick(R.id.findHotels)
    public void onViewClicked() {


        //    simpleProgressBar.setVisibility(View.VISIBLE);

                   if (isInternetAvailable()){

            if (chicDateStart && chicDateEnd && counttryCheked) {

                SharedPreferencesManger.SaveData(FindHotels.this, "start_date", mstartTime);

                SharedPreferencesManger.SaveData(FindHotels.this, "no_room", noRomes);

                SharedPreferencesManger.SaveData(FindHotels.this, "end_date", mendTime);
                gethotelsInfo(ctyId);

            } else if (chicDateStart) {

                new SweetAlertDialog(FindHotels.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Please Enter All Data First")
                        .setConfirmText("open")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                dialogendTime();
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();


            } else {

                new SweetAlertDialog(FindHotels.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Select Check In Date First")
                        .setConfirmText("open")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                dilogstart();
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();


            }



        }else {


            Toast.makeText(this, "no internet", Toast.LENGTH_SHORT).show();
            hideProgressingView();
        }




    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(FindHotels.this, ReserveRoom.class));

    }


    public class DoSomeTask extends AsyncTask<Void, Integer, HotelSearchResponse> {

        @Override
        protected void onPreExecute() {
//            simpleProgressBar.setVisibility(View.VISIBLE);
            showProgressingView();
        }

        @Override
        protected HotelSearchResponse doInBackground(Void... voids) {


            DateTime date1 = DateTime.parse(mstartTime);
            DateTime date2 = DateTime.parse(mendTime);
//        date1 = date1.plusDays(4);
//        date2 = date2.plusDays(7);

            ArrayOfRoomGuest roomguests = new ArrayOfRoomGuest();

            service.enableLogging = true;
            ArrayList<String> childAgeStringArray = new ArrayList<>();
            childAgeStringArray.add(SharedPreferencesManger.LoadStringData(FindHotels.this, "child_countroom1"));
            childAgeStringArray.add(SharedPreferencesManger.LoadStringData(FindHotels.this, "child_countroom2"));
            childAgeStringArray.add(SharedPreferencesManger.LoadStringData(FindHotels.this, "child_countroom3"));
            childAgeStringArray.add(SharedPreferencesManger.LoadStringData(FindHotels.this, "child_countroom4"));

            ArrayList<Integer> adultCountArray = new ArrayList<>();
            adultCountArray.add(nom_adultRoom1);
            adultCountArray.add(nom_adultRoom2);
            adultCountArray.add(nom_adultRoom3);
            adultCountArray.add(nom_adultRoom4);
            ArrayList<Integer> childCountArray = new ArrayList<>();
            childCountArray.add(mChildCountRoom1);
            childCountArray.add(mChildCountRoom2);
            childCountArray.add(mChildCountRoom3);
            childCountArray.add(mChildCountRoom4);

            for (int i = 0; i < noRomes; i++) {

                RoomGuest roomGuest = new RoomGuest();
                roomGuest.AdultCount = adultCountArray.get(i);
                roomGuest.ChildCount = childCountArray.get(i);
                roomGuest.ChildAge = new ArrayOfInt();
                if (roomGuest.ChildCount == 0) {
                    roomGuest.ChildAge = null;
                } else {
                    String child_count = childAgeStringArray.get(i);
                    child_count = child_count.replace("[", "");
                    child_count = child_count.replace("]", "");
                    StringTokenizer st = new StringTokenizer(child_count.trim(), ",");

                    while (st.hasMoreTokens()) {

                        // child age count
                        String ageChildCount = st.nextToken().trim();
                        roomGuest.ChildAge.add(Integer.parseInt(ageChildCount));

                    }
                }
                roomguests.add(roomGuest);

                SharedPreferencesManger.SaveData(FindHotels.this, "roomGuests", new Gson().toJson(roomguests));
            }


            try {
                //HotelSearchResponse hotelSearchResponse = service.HotelSearch1(date1.toDateTimeISO(), date2.toDateTimeISO(), Integer.parseInt(ctyId), 1, roomguests, "EG", authenticationData);


                hotelSearchResponse = service.HotelSearch(date1.toString("yyyy-MM-dd"), date2.toString("yyyy-MM-dd"), nameCountry, name_city, Integer.parseInt(ctyId),
                        true, noRomes, "EG", roomguests, null, 0, filters, "true", null,
                        0, authenticationData);


//            HotelSearchWithRoomsResponse hotelSearchWithRoomsResponse = service.HotelSearchWithRooms(date1.toString("yyyy-MM-dd"), date2.toString("yyyy-MM-dd"), nameCountry,name_city,Integer.parseInt(ctyId),
//                    true, noRomes, "EG", roomguests, null, 100, null, null, false, authenticationData);


            } catch (Exception e) {
                e.printStackTrace();

            }


            return hotelSearchResponse;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //Update the progress of current task

        }


        @Override
        protected void onPostExecute(HotelSearchResponse hotelSearchResponse) {


            listPrice.clear();
            ratrHotel.clear();
            nameHotel.clear();
            photoHotel.clear();
            listcodeHotel.clear();
            addressHotel.clear();
            arrayOfResultIndex.clear();


            try {
                if (hotelSearchResponse.HotelResultList != null) {


                    sessionId = hotelSearchResponse.SessionId;


                    for (int i = 0; i < hotelSearchResponse.HotelResultList.size(); i++) {

                        Hotel_Result hotel_result = hotelSearchResponse.HotelResultList.get(i);
                        MinHotelPrice minHotelPrice = hotelSearchResponse.HotelResultList.get(i).MinHotelPrice;
                        String currency = minHotelPrice.OriginalPrice.toString();
                        String currency1 = minHotelPrice.Currency;
                        listPrice.add(currency1 + " " + currency);
                        HotelInfo hotelInfo = hotel_result.HotelInfo;
                        // todo
                        hotelAddress = hotelInfo.HotelAddress;
                        hotelName = hotelInfo.HotelName;
                        hotelPicture = hotelInfo.HotelPicture;
                        int code = hotelInfo.Rating.getCode();


                        arrayOfResultIndex.add(hotel_result.ResultIndex);

                        String hotelCode = hotelInfo.HotelCode;

                        listcodeHotel.add(hotelCode);

                        nameHotel.add(hotelName);
                        ratrHotel.add(code);
                        photoHotel.add(hotelPicture);
                        addressHotel.add(hotelAddress);


                        Intent intent = new Intent(FindHotels.this, ChooseHotelActivity.class);
                        intent.putExtra("hotelName", nameHotel);
                        intent.putExtra("hotelrat", ratrHotel);
                        intent.putExtra("hotelPhoto", photoHotel);
                        intent.putExtra("hotelCode", listcodeHotel);
                        intent.putExtra("hotelAddress", addressHotel);
                        intent.putExtra("checkInDate", mstartTime);
                        intent.putExtra("checkOutDate", mendTime);
                        intent.putExtra("countryName", nameCountry);
                        intent.putExtra("cityName", name_city);
                        intent.putExtra("cityId", ctyId);
                        intent.putExtra("noOfRooms", noRomes);
                        intent.putExtra("list_price", listPrice);
                        SharedPreferencesManger.SaveData(FindHotels.this, "noOfRooms", noRomes);
                        intent.putExtra("resultIndex", arrayOfResultIndex);

                        SharedPreferencesManger.SaveData(FindHotels.this, "session_id", sessionId);

                        // intent.putExtra("roomGuest",roomguests);
                        startActivity(intent);


//                        simpleProgressBar.setVisibility(View.GONE);
                        hideProgressingView();


                    }
                } else {

hideProgressingView();
                    Toast.makeText(FindHotels.this, "no result found", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e) {

//                simpleProgressBar.setVisibility(View.GONE);
                hideProgressingView();

                new SweetAlertDialog(FindHotels.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Please Enter All Data First")
                        .setConfirmText("Search Again")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                sDialog.dismissWithAnimation();

                            }
                        })
                        .show();
            }
        }



    }
    ViewGroup progressView;
    protected boolean isProgressShowing = false;

    public void showProgressingView() {

        if (!isProgressShowing) {
            isProgressShowing = true;
            progressView = (ViewGroup) getLayoutInflater().inflate(R.layout.progressbar_layout, null);
            View v = this.findViewById(android.R.id.content).getRootView();
            ViewGroup viewGroup = (ViewGroup) v;
            viewGroup.addView(progressView);
        }
    }

    public void hideProgressingView() {
        View v = this.findViewById(android.R.id.content).getRootView();
        ViewGroup viewGroup = (ViewGroup) v;
        viewGroup.removeView(progressView);
        isProgressShowing = false;
    }
    public static long formatTimeForEvent(long pacificTime) {
        return (pacificTime + TimeZone.getTimeZone("America/Los_Angeles").getOffset(pacificTime))
                - TimeZone.getDefault().getOffset(pacificTime);
    }

}

