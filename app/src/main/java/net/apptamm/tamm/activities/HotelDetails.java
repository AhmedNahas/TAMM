package net.apptamm.tamm.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.Tamm.Hotels.wcf.ArrayOfImageUrlDetails;
import com.Tamm.Hotels.wcf.ArrayOfString4;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.HotelDetailsResponse;
import com.Tamm.Hotels.wcf.ImageUrlDetails;
import com.google.gson.Gson;

import net.apptamm.tamm.R;
import net.apptamm.tamm.adapters.AmenitiesAdapter;
import net.apptamm.tamm.adapters.adapterPhotoHotels;
import net.apptamm.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HotelDetails extends AppCompatActivity {

    //  ImageView imageView;
    @BindView(R.id.hotel_name_detail)
    TextView hotelNameDetail;
    @BindView(R.id.hotel_desc_detail)
    TextView hotelDescDetail;
    @BindView(R.id.btn_map)
    Button btnMap;
    @BindView(R.id.btn_next)
    Button btnNext;
    LinearLayout sliderDotspanel;
    @BindView(R.id.hotel_detils_rat)
    TextView hotelDetilsRat;
    @BindView(R.id.relative_img_hotel_details_tamm)
    RelativeLayout relativeImgHotelDetailsTamm;
//    @BindView(R.id.assistant_label_voice_details_hotel)
//    TextView assistantLabelVoiceDetailsHotel;
//    @BindView(R.id.assistant_label_call_details_hotel)
//    TextView assistantLabelCallDetailsHotel;
//    @BindView(R.id.assistant_label_message_details_hotel)
//    TextView assistantLabelMessageDetailsHotel;
    private AuthenticationData authenticationData;
    private int dotscount;
    private ImageView[] dots;
    private adapterPhotoHotels adapter;
    private String mHotelCode;
    private BasicHttpBinding_IHotelService1 service;
   // private String sessionId;
    private List<String> listOfPhoto = new ArrayList<>();
    private String address;
    private String hotelName;
    private int code;
    private String mendTime;
    private String mstartTime;
    private String countryName;
    private String cityName;
    private String cityId;
    private int noOfRooms;
    private ArrayList<String> roomGuests;
    private int resultIndex;
    private String part1;
    private String part2;
    private String map;
    private RecyclerView amenitiesRecycler;


    RelativeLayout toolbar_back1;

    ImageView iv_booked_hotel_details;
    private boolean ClickDetailsHotel=false;
    private Integer accountPlan;
    private AmenitiesAdapter amenitiesAdapter;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);
        ViewPager viewPager = findViewById(R.id.hotel_image_detail);
        sliderDotspanel = findViewById(R.id.SliderDots);
        ButterKnife.bind(this);


        toolbar_back1=findViewById(R.id.toolbar_back1);
        amenitiesRecycler=findViewById(R.id.amnities_recycler);


        toolbar_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(HotelDetails.this,ChooseHotelActivity.class);
//                startActivity(intent);
                onBackPressed();
            }
        });

        iv_booked_hotel_details=findViewById(R.id.iv_booked_hotel_details);
        iv_booked_hotel_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HotelDetails.this,MyBookActivity.class);
                startActivity(intent);
            }
        });


        accountPlan = SharedPreferencesManger.LoadIntegerData(this, "accountPlan");
        try {
            if (accountPlan == 1) {


                iv_booked_hotel_details.setVisibility(View.VISIBLE);

            } else if (accountPlan == 0) {

                iv_booked_hotel_details.setVisibility(View.VISIBLE);

            } else if (accountPlan == 2) {
                iv_booked_hotel_details.setVisibility(View.GONE);

            }
        }catch (Exception e){}


//
//        assistantLabelVoiceDetailsHotel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(HotelDetails.this, AssistantActivity.class);
//                startActivity(intent);
//                Toast.makeText(HotelDetails.this, "Voice", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        assistantLabelCallDetailsHotel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent1 = new Intent(HotelDetails.this, AssistantActivity.class);
//                startActivity(intent1);
//                Toast.makeText(HotelDetails.this, "Call", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        assistantLabelMessageDetailsHotel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent2 = new Intent(HotelDetails.this, AssistantActivity.class);
//                startActivity(intent2);
//                Toast.makeText(HotelDetails.this, "Message", Toast.LENGTH_SHORT).show();
//
//            }
//        });



        //testing
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        // imageView=findViewById(R.id.hotel_image_detail);

        SharedPreferencesManger.SaveData(this, "noOfTimes", 0);
        SharedPreferencesManger.SaveData(this, "RoomComb",null);
        SharedPreferencesManger.SaveData(this, "arrayOfroomsreq", null);

        auth();
        getdataIntent();


        String sessionId = SharedPreferencesManger.LoadStringData(this, "session_id");

        try {
            service.enableLogging = true;
            HotelDetailsResponse hotelDetailsResponse = service.HotelDetails(resultIndex, sessionId, mHotelCode, "EN", authenticationData);


            ArrayOfString4 description = hotelDetailsResponse.HotelDetails.HotelFacilities;


            ArrayList<String>  listDetails = new ArrayList<>();
            String[] split = description.toString().split(",");





            for (int i = 0; i < split.length; i++) {

                listDetails.add(split[i]);
                amenitiesRecycler.setLayoutManager(new GridLayoutManager(this,2));

                amenitiesAdapter = new AmenitiesAdapter(this,listDetails);
                amenitiesRecycler.setAdapter(amenitiesAdapter);
                amenitiesAdapter.notifyDataSetChanged();
            }


            Gson  gson = new Gson();
            String facility = gson.toJson(split);
            SharedPreferencesManger.SaveData(this,"facility",facility);


            ArrayOfImageUrlDetails imageUrls = hotelDetailsResponse.HotelDetails.ImageUrls;
            for (int i = 0; i < imageUrls.size(); i++) {

                ImageUrlDetails imageUrlDetails = imageUrls.get(i);
                String value = imageUrlDetails.value;

                listOfPhoto.add(value);
            }

            //  address = hotelDetailsResponse.HotelDetails.Address;
            hotelName = hotelDetailsResponse.HotelDetails.HotelName;
            // code = hotelDetailsResponse.HotelDetails.HotelRating.getCode();
            String address = hotelDetailsResponse.HotelDetails.Address;
            String phoneNumber = hotelDetailsResponse.HotelDetails.PhoneNumber;

            int code = hotelDetailsResponse.HotelDetails.HotelRating.getCode();
            hotelDetilsRat.setText("" + code);

            hotelDescDetail.setText(address + "\n" + phoneNumber);



            map = hotelDetailsResponse.HotelDetails.Map;

            String[] parts = map.split("\\|", 2);

            part1 = parts[0];
            part2 = parts[1];


        } catch (Exception e) {
            e.printStackTrace();
        }

        hotelNameDetail.setText(hotelName);


        adapter = new adapterPhotoHotels(this, listOfPhoto);
        viewPager.setAdapter(adapter);


        dotscount = adapter.getCount();
        dots = new ImageView[dotscount];


        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        try {
            dots[0].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dot));
        } catch (Exception e) {


        }


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(HotelDetails.this, ChooseBookingDate.class);
                intent.putExtra("checkInDate", mstartTime);
                intent.putExtra("checkOutDate", mendTime);
              //  intent.putExtra("sessionId", sessionId);
                intent.putExtra("hotelCode", mHotelCode);
                intent.putExtra("countryName", countryName);
                intent.putExtra("cityName", cityName);
                intent.putExtra("cityId", cityId);
                intent.putExtra("noOfRooms", noOfRooms);
                intent.putExtra("roomGuest", roomGuests);
                intent.putExtra("resultIndex", resultIndex);
                SharedPreferencesManger.SaveData(HotelDetails.this, "hotel_name_s", hotelName);
                SharedPreferencesManger.SaveData(HotelDetails.this, "country_name_s", countryName);

                SharedPreferencesManger.SaveData(HotelDetails.this, "resultindex", resultIndex);
                SharedPreferencesManger.SaveData(HotelDetails.this,"roomIndexArray",null);
                startActivity(intent);


            }
        });


    }

    private void getdataIntent() {

        mHotelCode = getIntent().getStringExtra("hotelCode");
        mstartTime = getIntent().getStringExtra("checkInDate");
        mendTime = getIntent().getStringExtra("checkOutDate");
        countryName = getIntent().getStringExtra("countryName");
        cityName = getIntent().getStringExtra("cityName");
        cityId = getIntent().getStringExtra("cityId");
        noOfRooms = getIntent().getIntExtra("noOfRooms", 1);
        roomGuests = getIntent().getStringArrayListExtra("roomGuest");
        resultIndex = getIntent().getIntExtra("resultIndex", 1);
    }


    private void auth() {

        service = new BasicHttpBinding_IHotelService1();
        authenticationData = new AuthenticationData();
        authenticationData.UserName = (getString(R.string.user_name_tamm));
        authenticationData.Password = (getString(R.string.passowrd_tamm));

    }

    @OnClick({R.id.btn_map, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_map:
                openMap();
                break;
            case R.id.btn_next:

                break;
        }
    }

    private void openMap() {

        float lang = Float.parseFloat(part1);
        float longi = Float.parseFloat(part2);
        // TODO: 12/07/19 replace "Hotel" with hotel name from api
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<" + lang + ">,<" + longi + ">?q=<" + lang + ">,<" + longi + ">(" + "Hotel" + ")"));


        startActivity(intent);

    }

    @OnClick(R.id.relative_img_hotel_details_tamm)
    public void onViewClicked() {


        Intent intent =new Intent(HotelDetails.this,AssistantActivity.class);
        startActivity(intent);
//        if (ClickDetailsHotel == false) {
//            assistantLabelCallDetailsHotel.setVisibility(View.VISIBLE);
//            assistantLabelMessageDetailsHotel.setVisibility(View.VISIBLE);
//            assistantLabelVoiceDetailsHotel.setVisibility(View.VISIBLE);
//            ClickDetailsHotel = true;
//
//        } else {
//            assistantLabelCallDetailsHotel.setVisibility(View.INVISIBLE);
//            assistantLabelMessageDetailsHotel.setVisibility(View.INVISIBLE);
//            assistantLabelVoiceDetailsHotel.setVisibility(View.INVISIBLE);
//            ClickDetailsHotel = false;
//
//        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        startActivity(new Intent(HotelDetails.this, FindHotels.class));

    }
}

