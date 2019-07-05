package net.middledleeast.tamm.activities;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.Tamm.Hotels.wcf.ArrayOfRoomGuest;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.HotelRoomAvailabilityResponse;

import net.middledleeast.tamm.R;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class ChooseBookingDate extends AppCompatActivity {


    private TextView startDate, endDate;
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
    private int noOfRooms;
    private ArrayOfRoomGuest roomGuests;
    private List<String> listOfPhoto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_booking_date);


        auth();
        mstartTime = getIntent().getStringExtra("checkInDate");
        mendTime = getIntent().getStringExtra("checkOutDate");
        sessionId = getIntent().getStringExtra("sessionId");
        mHotelCode = getIntent().getStringExtra("hotelCode");
        countryName = getIntent().getStringExtra("countryName");
        cityName = getIntent().getStringExtra("cityName");
        cityId = getIntent().getStringExtra("cityId");
        noOfRooms = getIntent().getIntExtra("noOfRooms", 1);
        //roomGuests =getIntent().getStringArrayListExtra("roomGuest");


        DateTime date1 = DateTime.now();
        DateTime date2 = DateTime.now();
        date1.plusDays(10);
        date2.plusDays(15);


        try {


            HotelRoomAvailabilityResponse response = service.AvailableHotelRooms(sessionId, 1, mHotelCode, 6000, true, authenticationData);


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


    }

    private void auth() {

        service = new BasicHttpBinding_IHotelService1();
        authenticationData = new AuthenticationData();
        service.enableLogging = true;
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");

    }
}
