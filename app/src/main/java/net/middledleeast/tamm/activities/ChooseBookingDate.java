package net.middledleeast.tamm.activities;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
import com.Tamm.Hotels.wcf.ArrayOfRoomGuest;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.HotelRoomAvailabilityResponse;
import com.Tamm.Hotels.wcf.Hotel_Room;
import com.Tamm.Hotels.wcf.Rate;
import com.Tamm.Hotels.wcf.RequestedRooms;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.RoomsAdapter;

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
    private int resultIndex;
    private RecyclerView roomRecyclerView;
    private RoomsAdapter roomAdapter;
    private List<Hotel_Room> rooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tempchoosebooking);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        roomRecyclerView = findViewById(R.id.rv_hotel);
        rooms = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        roomRecyclerView.setLayoutManager(manager);
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
        resultIndex = getIntent().getIntExtra("resultIndex", 1);






        try {


            HotelRoomAvailabilityResponse response = service.AvailableHotelRooms(sessionId, resultIndex, mHotelCode, 6000, false, authenticationData);

            rooms = response.HotelRooms;

            Hotel_Room hotel_room = rooms.get(0);
            transferClass.setHotel_room(hotel_room);
            ArrayOfRequestedRooms arrayOfRooms = new ArrayOfRequestedRooms();
            RequestedRooms requestedRooms = new RequestedRooms();
            requestedRooms.RatePlanCode = hotel_room.RatePlanCode;
            requestedRooms.RoomIndex = hotel_room.RoomIndex;
            requestedRooms.RoomRate = new Rate();
            requestedRooms.RoomRate.RoomFare = hotel_room.RoomRate.RoomFare;
            requestedRooms.RoomRate.RoomTax = hotel_room.RoomRate.RoomTax;
            requestedRooms.RoomRate.TotalFare = hotel_room.RoomRate.TotalFare;
            requestedRooms.RoomTypeCode = hotel_room.RoomTypeCode;
            arrayOfRooms.add(requestedRooms);
            transferClass.setArrayOfRequestedRooms(arrayOfRooms);

            roomAdapter = new RoomsAdapter(rooms, hotel_room, arrayOfRooms, mstartTime, mendTime, noOfRooms, resultIndex, mHotelCode, authenticationData, sessionId, this);


            roomRecyclerView.setAdapter(roomAdapter);
            roomAdapter.notifyDataSetChanged();
            for (int i = 0; i < response.HotelRooms.size(); i++) {


//                String description = String.valueOf(response.HotelRooms.get(i).CancelPolicies.DefaultPolicy);
//
//                Toast.makeText(this, "descrip" + description, Toast.LENGTH_SHORT).show();


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

    public static class transferClass {

        public static ArrayOfRequestedRooms arrayOfRequestedRooms;
        public static Hotel_Room hotel_room;

        public static Hotel_Room getHotel_room() {
            return hotel_room;
        }

        public static void setHotel_room(Hotel_Room hotel_room) {
            transferClass.hotel_room = hotel_room;
        }


        public static ArrayOfRequestedRooms getArrayOfRequestedRooms() {
            return arrayOfRequestedRooms;
        }

        public static void setArrayOfRequestedRooms(ArrayOfRequestedRooms arrayOfRequestedRooms) {
            transferClass.arrayOfRequestedRooms = arrayOfRequestedRooms;
        }


    }
}
