package net.apptamm.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
import com.Tamm.Hotels.wcf.ArrayOfRoomGuest;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.BookingOptions;
import com.Tamm.Hotels.wcf.HotelRoomAvailabilityResponse;
import com.Tamm.Hotels.wcf.Hotel_Room;
import com.google.gson.Gson;

import net.apptamm.tamm.R;
import net.apptamm.tamm.adapters.RoomsAdapter;
import net.apptamm.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChooseBookingDate extends AppCompatActivity {


    private TextView startDate, endDate, nights, no_room, no_child, adult_tv;
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
    private List<Hotel_Room> rooms = new ArrayList<>();
    private String end_time;
    private String start_time;
    List<Integer> list_count_child = new ArrayList<>();
    private String hotel_name_s;
    private TextView tv_name_hotel,tv_date_hotels;
    private Button btn_search_change  ;
    private RelativeLayout toolbar_back1;
    private TextView tv_word;
    ImageView iv_booked_temp;
    private Integer accountPlan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tempchoosebooking);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        roomRecyclerView = findViewById(R.id.rv_hotel);
        nights = findViewById(R.id.nights_booking);
        startDate = findViewById(R.id.startDate2);
        endDate = findViewById(R.id.endDate2);
        no_room = findViewById(R.id.no_room);
        no_child = findViewById(R.id.no_child2);
        adult_tv = findViewById(R.id.adult2);

//        tv_name_hotel = findViewById(R.id.tv_name_hotel);
//        tv_date_hotels = findViewById(R.id.tv_date_hotels);
        tv_name_hotel = findViewById(R.id.tv_name_hotel);
        tv_date_hotels = findViewById(R.id.tv_date_hotels);
        tv_word = findViewById(R.id.tv_word);



        btn_search_change = findViewById(R.id.btn_search_change);
        toolbar_back1=findViewById(R.id.toolbar_back1);
        toolbar_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseBookingDate.this,HotelDetails.class));

            }
        });

        iv_booked_temp=findViewById(R.id.iv_booked_temp);
        iv_booked_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseBookingDate.this,MyBookActivity.class);
                startActivity(intent);
            }
        });


        accountPlan = SharedPreferencesManger.LoadIntegerData(this, "accountPlan");
        try {
            if (accountPlan == 1) {


                iv_booked_temp.setVisibility(View.VISIBLE);

            } else if (accountPlan == 0) {

                iv_booked_temp.setVisibility(View.VISIBLE);

            } else if (accountPlan == 2) {
                iv_booked_temp.setVisibility(View.GONE);

            }
        }catch (Exception e){}


//
//        String child_count = SharedPreferencesManger.LoadStringData(this, "child_count");
//
//         StringTokenizer st = new StringTokenizer(child_count, ",");
//
//         while (st.hasMoreTokens()){
//
//             //Toast.makeText(this, ""+list_count_child.ic_add(Integer.parseInt(st.nextToken())), Toast.LENGTH_SHORT).show();
//
//         }




        btn_search_change.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                backIntent();
            }
        });

        // TODO: 28/07/19 what is the purpose
//        String child_count = SharedPreferencesManger.LoadStringData(this, "child_count");
//
//
//        if (child_count == null) {
//
//        } else {
//            StringTokenizer st = new StringTokenizer(child_count.trim(), ",");
//            while (st.hasMoreTokens()) {
//                list_count_child.ic_add(Integer.parseInt(st.nextToken().trim()));
//            }
        //Toast.makeText(this, ""+list_count_child.get(0), Toast.LENGTH_SHORT).show();
//    }


        //  Toast.makeText(this, ""+child_count, Toast.LENGTH_SHORT).show();
        //  SharedPreferencesManger.remove(this,"child_count");

        //SharedPreferencesManger.clean(this);

        long nightsDeff = SharedPreferencesManger.LoadLongData(ChooseBookingDate.this, "nights");
        start_time = SharedPreferencesManger.LoadStringData(ChooseBookingDate.this, "start_date");
        end_time = SharedPreferencesManger.LoadStringData(ChooseBookingDate.this, "end_date");
        int no_roomS = SharedPreferencesManger.LoadIntegerData(this, "no_room");
        // TODO: 28/07/19 fix implement all rooms
        int no_adult = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom1");
        int no_childS = SharedPreferencesManger.LoadIntegerData(this, "no_childroom1");

        no_child.setText(no_childS + getString(R.string.children));

        no_room.setText("" + no_roomS + getString(R.string.room));
        adult_tv.setText(no_adult + getString(R.string.adult));


        startDate.setText(start_time);
        endDate.setText(end_time);

        nights.setText(nightsDeff + getString(R.string.nights));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        roomRecyclerView.setLayoutManager(manager);
        auth();
        hotel_name_s = SharedPreferencesManger.LoadStringData(this,"hotel_name_s");

        mstartTime = getIntent().getStringExtra("checkInDate");
        mendTime = getIntent().getStringExtra("checkOutDate");
        sessionId = SharedPreferencesManger.LoadStringData(ChooseBookingDate.this, "session_id");
        mHotelCode = SharedPreferencesManger.LoadStringData(ChooseBookingDate.this, "mHotel_code");

        countryName = SharedPreferencesManger.LoadStringData(this,"country_name_s");


        cityName = getIntent().getStringExtra("cityName");


        cityId = getIntent().getStringExtra("cityId");
        noOfRooms = getIntent().getIntExtra("noOfRooms", 1);

//        roomGuests =getIntent().getStringArrayListExtra("roomGuest");
        resultIndex = SharedPreferencesManger.LoadIntegerData(this, "resultindex");


        String startDateS = SharedPreferencesManger.LoadStringData(this, "startDateS");
        String endDateS = SharedPreferencesManger.LoadStringData(this, "endDateS");


        tv_name_hotel.setText(hotel_name_s + " - " + countryName);

        tv_word.setText(hotel_name_s + " - " + countryName);

        tv_date_hotels.setText(startDateS + endDateS);


        try {
            service.enableLogging = true;
            HotelRoomAvailabilityResponse response = service.AvailableHotelRooms(sessionId, resultIndex, mHotelCode, 0,
                    true, authenticationData);


            Gson gson = new Gson();
            String roomAvailability = gson.toJson(response);
            SharedPreferencesManger.SaveData(this, "roomAvailability", roomAvailability);
            rooms = response.HotelRooms;



// TODO: 13/07/19 remove

            Hotel_Room hotel_room = rooms.get(0);
            for (int i = 0; i < rooms.size(); i++) {

                 hotel_room = rooms.get(i);
            }


//
            transferClass.setHotel_room(hotel_room);

//            transferClass.setArrayOfRequestedRooms(arrayOfRooms);

            BookingOptions bookingOptionsResponse = response.OptionsForBooking;

//            bookingOptions.RoomCombination.clear();
//            RoomCombination roomCombination = new RoomCombination();
//            roomCombination.RoomIndex = new ArrayList<>();

            // TODO: 17/07/19 fix
//            for (int i =1;i<=rooms.size();i++) {
//                roomCombination.RoomIndex.ic_add(i);
//            }

//            bookingOptions.RoomCombination.ic_add(roomCombination);

// TODO: 17/07/19 fix

//            HotelCancellationPolicyResponse cancelPolicies = service.HotelCancellationPolicy(resultIndex, sessionId, bookingOptions, authenticationData);

//            SharedPreferencesManger.SaveData(this, "resultIndex", resultIndex);

            Bundle extras = getIntent().getExtras();
            ArrayList<Double> roomCombs = new ArrayList<>();
            if (extras != null) {

                String roomCombStr = extras.getString("roomcomb");
                roomCombs = gson.fromJson(roomCombStr, ArrayList.class);
//                if (roomCombs != null) {
//                    for (double comb : roomCombs) {
//                        roomCOmbsInt.ic_add((int) comb);
//                    }


                if (roomCombs != null) {
                    List<Hotel_Room> tempRooms = new ArrayList<>();
//                for (Hotel_Room room : rooms) {
//
//                }

// FIXME: 29/07/19 refine arraylist
                    for (double roomComb : roomCombs) {
                        for (Hotel_Room room : rooms) {
                            if (room.RoomIndex == (int) roomComb) {
                                tempRooms.add(room);
                            }
                        }

                    }

                    rooms.clear();
                    rooms = new ArrayList<>(tempRooms);


                    ArrayList<Integer> roomCombsInt = new ArrayList<>();
                    for (double roomComb : roomCombs) {
                        roomCombsInt.add((int) roomComb);
                    }
                    Collections.sort(roomCombsInt);

                    roomAdapter = new RoomsAdapter(roomCombsInt, ChooseBookingDate.this, authenticationData,
                            service, response, rooms, hotel_room, start_time, end_time, noOfRooms, resultIndex,
                            mHotelCode, authenticationData, sessionId, ChooseBookingDate.this);


                }
                else
                {
                    roomAdapter = new RoomsAdapter(null,ChooseBookingDate.this, authenticationData,
                            service, response, rooms, hotel_room, start_time, end_time, noOfRooms, resultIndex,
                            mHotelCode, authenticationData, sessionId, ChooseBookingDate.this);
                }
            }
            else
            {
                roomAdapter = new RoomsAdapter(null,ChooseBookingDate.this, authenticationData,
                        service, response, rooms, hotel_room, start_time, end_time, noOfRooms, resultIndex,
                        mHotelCode, authenticationData, sessionId, ChooseBookingDate.this);
            }




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

    private void backIntent() {



        Intent intent = new Intent(ChooseBookingDate.this, FindHotels.class);
        startActivity(intent);


    }

    private void auth() {

        service = new BasicHttpBinding_IHotelService1();
        authenticationData = new AuthenticationData();
        service.enableLogging = true;
        authenticationData.UserName = (getString(R.string.user_name_tamm));
        authenticationData.Password = (getString(R.string.passowrd_tamm));

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        Intent intent = new Intent(ChooseBookingDate.this,FindHotels.class);
//        startActivity(intent);
    }
}