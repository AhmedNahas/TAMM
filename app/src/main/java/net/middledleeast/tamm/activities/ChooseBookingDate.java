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
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.List;

public class ChooseBookingDate extends AppCompatActivity {


    private TextView startDate, endDate  , nights , no_room ,no_child , adult_tv;
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
    private List<Hotel_Room> rooms  = new ArrayList<>();
    private String end_time;
    private String start_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tempchoosebooking);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        roomRecyclerView = findViewById(R.id.rv_hotel);
        nights = findViewById(R.id.nights_booking);
        startDate= findViewById(R.id.startDate2);
        endDate = findViewById(R.id.endDate2);
        no_room = findViewById(R.id.no_room);
        no_child = findViewById(R.id.no_child2);
        adult_tv = findViewById(R.id.adult2);




        long nightsDeff = SharedPreferencesManger.LoadLongData(ChooseBookingDate.this, "nights");
        start_time = SharedPreferencesManger.LoadStringData(ChooseBookingDate.this, "start_date");
        end_time = SharedPreferencesManger.LoadStringData(ChooseBookingDate.this, "end_date");
        long no_roomS = SharedPreferencesManger.LoadLongData(this, "no_room");
        long no_adult = SharedPreferencesManger.LoadLongData(this, "no_adult");
        int no_childS = SharedPreferencesManger.LoadIntegerData(this, "no_child");

        no_child.setText(no_childS+"Children");

        no_room.setText(""+no_roomS+" room");
        adult_tv.setText(no_adult+"Adult");


        startDate.setText(start_time);
        endDate.setText(end_time);

        nights.setText(nightsDeff+" Nights");
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

            service.enableLogging = true;
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

            roomAdapter = new RoomsAdapter(rooms, hotel_room, arrayOfRooms, start_time, end_time, noOfRooms, resultIndex, mHotelCode, authenticationData, sessionId, this);


            roomRecyclerView.setAdapter(roomAdapter);
            roomAdapter.notifyDataSetChanged();






        } catch (Exception e) {
            e.printStackTrace();
        }



//
//        try {
//            service.enableLogging = true;
//
//            HotelRoomAvailabilityResponse hotelRoomAvailabilityResponse = service.AvailableHotelRooms(sessionId, 1, mHotelCode,
//                    1000, true, authenticationData);
//
//
//            String roomTypeName = hotelRoomAvailabilityResponse.HotelRooms.get(0).RoomTypeName;
//            Toast.makeText(this, ""+roomTypeName, Toast.LENGTH_SHORT).show();
//
//        }catch (Exception e){
//
//            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
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
