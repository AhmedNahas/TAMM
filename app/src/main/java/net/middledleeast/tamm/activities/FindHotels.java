package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.format.DateFormat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
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
import com.Tamm.Hotels.wcf.Enums;
import com.Tamm.Hotels.wcf.Filters;
import com.Tamm.Hotels.wcf.HotelInfo;
import com.Tamm.Hotels.wcf.HotelSearchResponse;
import com.Tamm.Hotels.wcf.Hotel_Result;
import com.Tamm.Hotels.wcf.MinHotelPrice;
import com.Tamm.Hotels.wcf.RoomGuest;
import com.Tamm.Hotels.wcf.TagInfoResponse;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

import static java.util.Calendar.YEAR;

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

    RelativeLayout relativeImgFindHotelTamm;
    @BindView(R.id.assistant_label_voice_find_hotel)
    TextView assistantLabelVoiceFindHotel;
    @BindView(R.id.assistant_label_call_find_hotel)
    TextView assistantLabelCallFindHotel;
    @BindView(R.id.assistant_label_message_find_hotel)
    TextView assistantLabelMessageFindHotel;
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
    private Spinner roomCount, adultCount, childCount;
    private AutoCompleteTextView regions, areas;
    private List<String> listID = new ArrayList<>();
    private String nameCountry;
    private String name_city;
    private TextView nights;
    private String mendTime;
    private String mstartTime;
    private List<Integer> listOfRooms = new ArrayList<>();
    private List<Integer> listOfAdult = new ArrayList<>();
    private int noRomes;
    private String sessionId;
    ArrayList<Integer> arrayOfResultIndex;
    private int resultIndex = 0;
    private Date time1;
    private Date time2;
    private RecyclerView recycl_child_spiner;
    AdapterChildCount adapterChildCount;
    private List<Integer> listOfChild = new ArrayList<>();
    private List<Integer> listChildernCount = new ArrayList<>();
    private int nom_adult;
    private int mChildCount;
    private List<Integer> listOfChildAge = new ArrayList<>();
    boolean chicDateStart = false;
    boolean chicDateEnd = false;
    private RelativeLayout toolbar_back;
    boolean child_mor = false;
    private HotelSearchResponse hotelSearchResponse;
    private CountryList countryList;
    ArrayList<String> listPrice = new ArrayList<>();
    private boolean ClickFindHotel=false;
    private Filters filters;
//    private boolean saved ;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_hotels);
        ButterKnife.bind(this);
        auth();

        areas = findViewById(R.id.area_spinner);
        regions = findViewById(R.id.region_spinner);
        roomCount = findViewById(R.id.no_of_rooms);
        adultCount = findViewById(R.id.adilt_count);
        childCount = findViewById(R.id.no_of_childs);
//        startDate = findViewById(R.id.startDate);
//        endDate = findViewById(R.id.endDate);
        nights = findViewById(R.id.nights);
        toolbar_back = findViewById(R.id.toolbar_back1);
        recycl_child_spiner = findViewById(R.id.rv_child);


        relativeImgFindHotelTamm = findViewById(R.id.relative_img_find_hotel_tamm);



        relativeImgFindHotelTamm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ClickFindHotel == false) {
                    assistantLabelCallFindHotel.setVisibility(View.VISIBLE);
                    assistantLabelMessageFindHotel.setVisibility(View.VISIBLE);
                    assistantLabelVoiceFindHotel.setVisibility(View.VISIBLE);
                    ClickFindHotel = true;

                } else {
                    assistantLabelCallFindHotel.setVisibility(View.INVISIBLE);
                    assistantLabelMessageFindHotel.setVisibility(View.INVISIBLE);
                    assistantLabelVoiceFindHotel.setVisibility(View.INVISIBLE);
                    ClickFindHotel = false;

                }

            }
        });

        assistantLabelCallFindHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FindHotels.this, "Call", Toast.LENGTH_SHORT).show();
            }
        });

        assistantLabelMessageFindHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FindHotels.this, "Message", Toast.LENGTH_SHORT).show();

            }
        });

        assistantLabelVoiceFindHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FindHotels.this, "Voice", Toast.LENGTH_SHORT).show();

            }
        });






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

        for (int i = 0; i < 18; i++) {
            listOfChildAge.add(i);
        }
        adapterChildCount = new AdapterChildCount(this, listChildernCount, listOfChildAge, this);

        recycl_child_spiner.setAdapter(adapterChildCount);

        adapterChildCount.notifyDataSetChanged();


        listOfChild.add(0);

        String date_n = new SimpleDateFormat("dd", Locale.getDefault()).format(new Date());
        String date_m = new SimpleDateFormat("MMM", Locale.getDefault()).format(new Date());
        String date_d = new SimpleDateFormat("EEEE", Locale.getDefault()).format(new Date());

        endDateDay.setText(date_n);
        endDateMonth.setText(date_m);
        endDateYear.setText(date_d);
        startDateDay.setText(date_n);
        startDateMonth.setText(date_m);
        startDateYear.setText(date_d);


        arrayOfResultIndex = new ArrayList<>();
        noRomes = 1;
        for (int i = 1; i < 7; i++) {

            listOfRooms.add(i);
        }


        ArrayAdapter adapterRoomCount = new ArrayAdapter(this, R.layout.item_spener, listOfRooms);

        adapterRoomCount.setDropDownViewResource(R.layout.drop_dowen);
        roomCount.setDropDownWidth(420);
        roomCount.setDropDownVerticalOffset(200);
        roomCount.setAdapter(adapterRoomCount);
        roomCount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int position = listOfRooms.get(i);

                switch (position) {
                    case 1:
                        listOfAdult.clear();
                        listOfChild.clear();
                        list1();
                        listOfChildCount();
                        noRomes = 1;
                        break;
                    case 2:
                        listOfAdult.clear();
                        noRomes = 2;
                        listOfChild.clear();
                        list2();
                        listOfChildCount2();


                    default:

                        return;
                }


                ArrayAdapter adapteradult = new ArrayAdapter(FindHotels.this, R.layout.item_spener, listOfAdult);

                adapteradult.setDropDownViewResource(R.layout.drop_dowen);
                adultCount.setDropDownWidth(420);
                adultCount.setDropDownVerticalOffset(200);
                adultCount.setAdapter(adapteradult);
                adultCount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                        nom_adult = listOfAdult.get(i);
                        SharedPreferencesManger.SaveData(FindHotels.this, "no_adult", nom_adult);


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter adapterchild = new ArrayAdapter(FindHotels.this, R.layout.item_spener, listOfChild);

        adapterchild.setDropDownViewResource(R.layout.drop_dowen);
        childCount.setDropDownWidth(420);
        childCount.setDropDownVerticalOffset(200);
        childCount.setAdapter(adapterchild);
        childCount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i != 0) {


                    if (i == 1) {

                        mChildCount = 1;
                        listChildernCount.clear();
                        for (int j = 1; j < 2; j++) {
                            listChildernCount.add(j);
                            adapterChildCount.notifyDataSetChanged();
                        }
                    } else if (i == 2) {
                        mChildCount = 2;
                        listChildernCount.clear();
                        for (int j = 1; j < 3; j++) {
                            listChildernCount.add(j);
                            adapterChildCount.notifyDataSetChanged();
                        }
                    } else if (i == 3) {
                        mChildCount = 3;
                        listChildernCount.clear();
                        for (int j = 1; j < 4; j++) {
                            listChildernCount.add(j);
                            adapterChildCount.notifyDataSetChanged();
                        }
                    } else if (i == 4) {
                        mChildCount = 4;

                        listChildernCount.clear();
                        for (int j = 1; j < 5; j++) {

                            listChildernCount.add(j);
                            adapterChildCount.notifyDataSetChanged();

                        }
                    }


                } else {
                    mChildCount = 0;
                    listChildernCount.clear();
                    adapterChildCount.notifyDataSetChanged();
                }

                SharedPreferencesManger.SaveData(FindHotels.this, "no_child", mChildCount);

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
                idCountry = listID.get(adapter2.getPosition(adapter2.getItem(position)));

                getCities(idCountry);


            }

        });


        // String test = hotelSearchResponse.Status.Description;
//            System.out.println("Hello: " + test);

    }

    private void listOfChildCount() {

        for (int i = 0; i < 4; i++) {
            listOfChild.add(i);
        }


    }


    private void listOfChildCount2() {

        for (int i = 0; i < 9; i++) {
            listOfChild.add(i);
        }


    }

    private void list1() {

        for (int i = 1; i < 7; i++) {


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
        DateTime date1 = DateTime.parse(mstartTime);
        DateTime date2 = DateTime.parse(mendTime);
//        date1 = date1.plusDays(4);
//        date2 = date2.plusDays(7);


        service.enableLogging = true;
        String child_count = SharedPreferencesManger.LoadStringData(this, "child_count");


        RoomGuest roomGuest = new RoomGuest();
        roomGuest.AdultCount = nom_adult;
        roomGuest.ChildCount = mChildCount;
        roomGuest.ChildAge = new ArrayOfInt();
        ArrayOfRoomGuest roomguests = new ArrayOfRoomGuest();

        if (mChildCount == 0) {
            roomGuest.ChildAge = null;
        } else {
            StringTokenizer st = new StringTokenizer(child_count.trim(), ",");


            while (st.hasMoreTokens()) {

                // child age count
                String ageChildCount = st.nextToken().trim();
                roomGuest.ChildAge.add(Integer.parseInt(ageChildCount));

            }
        }
        roomguests.add(roomGuest);


        filters = new Filters();
        filters.StarRating = Enums.HotelRatingInput.All;



        try {
            //HotelSearchResponse hotelSearchResponse = service.HotelSearch1(date1.toDateTimeISO(), date2.toDateTimeISO(), Integer.parseInt(ctyId), 1, roomguests, "EG", authenticationData);



            hotelSearchResponse = service.HotelSearch(date1.toString("yyyy-MM-dd"), date2.toString("yyyy-MM-dd"), nameCountry, name_city, Integer.parseInt(ctyId),
                    true, noRomes, "EG", roomguests, null, 100,filters , "true", null,
                    10000, authenticationData);


//            HotelSearchWithRoomsResponse hotelSearchWithRoomsResponse = service.HotelSearchWithRooms(date1.toString("yyyy-MM-dd"), date2.toString("yyyy-MM-dd"), nameCountry,name_city,Integer.parseInt(ctyId),
//                    true, noRomes, "EG", roomguests, null, 100, null, null, false, authenticationData);



            listPrice.clear();
            ratrHotel.clear();
            nameHotel.clear();
            photoHotel.clear();
            listcodeHotel.clear();
            addressHotel.clear();
            arrayOfResultIndex.clear();



            if (hotelSearchResponse.HotelResultList != null) {
                for (int i = 0; i < hotelSearchResponse.HotelResultList.size(); i++) {

                    Hotel_Result hotel_result = hotelSearchResponse.HotelResultList.get(i);
                    MinHotelPrice minHotelPrice = hotelSearchResponse.HotelResultList.get(i).MinHotelPrice;
                    String currency = minHotelPrice.OriginalPrice.toString();
                    String currency1 = minHotelPrice.Currency;
                    listPrice.add(currency1 + " " + currency);
                    HotelInfo hotelInfo = hotel_result.HotelInfo;
                    sessionId = hotelSearchResponse.SessionId;
                    hotelAddress = hotelInfo.HotelAddress;
                    hotelName = hotelInfo.HotelName;
                    this.hotelPicture = hotelInfo.HotelPicture;
                    int code = hotelInfo.Rating.getCode();


                    arrayOfResultIndex.add(hotel_result.ResultIndex);

                    String hotelCode = hotelInfo.HotelCode;

                    listcodeHotel.add(hotelCode);

                    nameHotel.add(hotelName);
                    ratrHotel.add(code);
                    photoHotel.add(this.hotelPicture);
                    addressHotel.add(hotelAddress);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


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
        SharedPreferencesManger.SaveData(this, "noOfRooms", noRomes);
        intent.putExtra("resultIndex", arrayOfResultIndex);

        SharedPreferencesManger.SaveData(FindHotels.this, "session_id", sessionId);

        // intent.putExtra("roomGuest",roomguests);
        startActivity(intent);


    }

    private void auth() {

        service = new BasicHttpBinding_IHotelService1();
        service.enableLogging = true;
        authenticationData = new AuthenticationData();
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");

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

                String dayOfTheWeek = (String) DateFormat.format("EEEE", time); // Thursday
                String day = (String) DateFormat.format("dd", time); // Thursday
                String monthString = (String) DateFormat.format("MMM", time); // Thursday


                SharedPreferencesManger.SaveData(FindHotels.this, "startDateS", dayOfTheWeek + " " + day + " " + monthString + " " + "till ");
                startDateDay.setText(day);
                startDateMonth.setText(monthString);

                startDateYear.setText(dayOfTheWeek);

                endDateDay.setText(day);
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
                            .setTitleText("Select Check in Dat First")
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


        Toast.makeText(FindHotels.this, "loading...", Toast.LENGTH_SHORT).show();
        if (chicDateStart && chicDateEnd) {

            SharedPreferencesManger.SaveData(FindHotels.this, "start_date", mstartTime);

            SharedPreferencesManger.SaveData(FindHotels.this, "no_room", noRomes);

            SharedPreferencesManger.SaveData(FindHotels.this, "end_date", mendTime);
            gethotelsInfo(ctyId);

        } else if (chicDateStart) {

            new SweetAlertDialog(FindHotels.this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Select Check Out Dat First")
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
                    .setTitleText("Select Check In Dat First")
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


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(FindHotels.this, ReserveRoom.class));

    }
}
