package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.Tamm.Hotels.wcf.ArrayOfImageUrlDetails;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.HotelDetailsResponse;
import com.Tamm.Hotels.wcf.ImageUrlDetails;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.adapterPhotoHotels;

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
    private AuthenticationData authenticationData;
    private int dotscount;
    private ImageView[] dots;
    private adapterPhotoHotels adapter;
    private String mHotelCode;
    private BasicHttpBinding_IHotelService1 service;
    private String sessionId;
    private List<String> listOfPhoto = new ArrayList<>();
    private String address;
    private String hotelName;
    private int code;
    private String description;
    private String phoneNumber;
    private String map;
    private String mendTime;
    private String mstartTime;
    private String countryName;
    private String cityName;
    private String cityId;
    private int noOfRooms;
    private ArrayList<String> roomGuests;
    private int resultIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);
        ButterKnife.bind(this);
        //testing
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        // imageView=findViewById(R.id.hotel_image_detail);
        ViewPager viewPager = findViewById(R.id.hotel_image_detail);
        sliderDotspanel = findViewById(R.id.SliderDots);

        auth();
        getdataIntent();

        try {
            service.enableLogging = true;
            HotelDetailsResponse hotelDetailsResponse = service.HotelDetails(resultIndex, sessionId, mHotelCode, "EN", authenticationData);


            ArrayOfImageUrlDetails imageUrls = hotelDetailsResponse.HotelDetails.ImageUrls;
            for (int i = 0; i < imageUrls.size(); i++) {

                ImageUrlDetails imageUrlDetails = imageUrls.get(i);
                String value = imageUrlDetails.value;

                listOfPhoto.add(value);
            }

            //  address = hotelDetailsResponse.HotelDetails.Address;
            hotelName = hotelDetailsResponse.HotelDetails.HotelName;
            // code = hotelDetailsResponse.HotelDetails.HotelRating.getCode();
            description = hotelDetailsResponse.HotelDetails.Description;

            //    phoneNumber = hotelDetailsResponse.HotelDetails.PhoneNumber;
            //map = hotelDetailsResponse.HotelDetails.Map;

            Toast.makeText(this, "" + description, Toast.LENGTH_LONG).show();


        } catch (Exception e) {
            e.printStackTrace();
        }

        hotelNameDetail.setText(hotelName);
        hotelDescDetail.setText(description);


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


        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

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
                intent.putExtra("sessionId", sessionId);
                intent.putExtra("hotelCode", mHotelCode);
                intent.putExtra("countryName", countryName);
                intent.putExtra("cityName", cityName);
                intent.putExtra("cityId", cityId);
                intent.putExtra("noOfRooms", noOfRooms);
                intent.putExtra("roomGuest", roomGuests);
                intent.putExtra("resultIndex", resultIndex);
                startActivity(intent);


            }
        });


    }

    private void getdataIntent() {

        sessionId = getIntent().getStringExtra("sessionId");
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
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");

    }

    @OnClick({R.id.btn_map, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_map:
                break;
            case R.id.btn_next:
                break;
        }
    }
}

