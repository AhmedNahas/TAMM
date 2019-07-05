package net.middledleeast.tamm.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Tamm.Hotels.wcf.ArrayOfHotel_ResultWithRooms;
import com.Tamm.Hotels.wcf.ArrayOfHotel_Room;
import com.Tamm.Hotels.wcf.ArrayOfImageUrlDetails;
import com.Tamm.Hotels.wcf.ArrayOfRoomGuest;
import com.Tamm.Hotels.wcf.ArrayOfString;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.HotelDetailsResponse;
import com.Tamm.Hotels.wcf.HotelRoomAvailabilityResponse;
import com.Tamm.Hotels.wcf.HotelSearchWithRoomsResponse;
import com.Tamm.Hotels.wcf.ImageUrlDetails;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.AdapterHotelInfo;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class ChooseBookingDate extends AppCompatActivity {



    private TextView startDate , endDate ;
    private String mendTime;
    private String mstartTime;
    private BasicHttpBinding_IHotelService1 service;
    private AuthenticationData authenticationData;
    private String sessionId;
    private String mHotelCode;
    private String imageURLs;
    private String countryName;
    private String cityName;
    private String cityId;
    private String noOfRooms;
    private ArrayOfRoomGuest roomGuests;
    private List<String> listOfPhoto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_booking_date);


        auth();


            DateTime date1 = DateTime.now();
            DateTime date2 = DateTime.now();
            date1.plusDays(10);
            date2.plusDays(15);



        try {


            HotelRoomAvailabilityResponse response = service.AvailableHotelRooms(sessionId, 100, mHotelCode, 6000, true, authenticationData);



            for (int i = 0; i < response.HotelRooms.size(); i++) {


                String description = response.HotelRooms.get(i).Inclusion;

                Toast.makeText(this, "descrip" + description, Toast.LENGTH_SHORT).show();


            }
//        try {
//            service.enableLogging = true;
//
//            HotelRoomAvailabilityResponse hotelRoomAvailabilityResponse = service.AvailableHotelRooms(sessionId, 15, mHotelCode, 10000, false, authenticationData);
//            ArrayOfHotel_Room hotelRooms1 = hotelRoomAvailabilityResponse.HotelRooms;
//            for (int i = 0; i <hotelRooms1.size(); i++) {
//
//                ArrayOfString imageURLs = hotelRooms1.get(i).RoomAdditionalInfo.ImageURLs;
//
//                Toast.makeText(this, ""+imageURLs.size(), Toast.LENGTH_SHORT).show();
//
//
//
//
//            }

//            //  address = hotelDetailsResponse.HotelDetails.Address;
//            hotelName = hotelDetailsResponse.HotelDetails.HotelName;
//            // code = hotelDetailsResponse.HotelDetails.HotelRating.getCode();
//            description = hotelDetailsResponse.HotelDetails.Description;
//            //    phoneNumber = hotelDetailsResponse.HotelDetails.PhoneNumber;
//            //map = hotelDetailsResponse.HotelDetails.Map;
//
//            Toast.makeText(this, "" + description, Toast.LENGTH_LONG).show();


        } catch (Exception e) {
            e.printStackTrace();
        }


        mstartTime = getIntent().getStringExtra("checkInDate");
        mendTime = getIntent().getStringExtra("checkOutDate");
        sessionId = getIntent().getStringExtra("sessionId");
        mHotelCode = getIntent().getStringExtra("hotelCode");
        countryName = getIntent().getStringExtra("countryName");
        cityName = getIntent().getStringExtra("cityName");
        cityId = getIntent().getStringExtra("cityId");
        noOfRooms = getIntent().getStringExtra("noOfRooms");
        //roomGuests =getIntent().getStringArrayListExtra("roomGuest");






    }
    private void auth() {

        service = new BasicHttpBinding_IHotelService1();
        authenticationData = new AuthenticationData();
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");

    }
}
