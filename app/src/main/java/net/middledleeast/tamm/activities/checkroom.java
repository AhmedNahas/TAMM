package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
import com.Tamm.Hotels.wcf.ArrayOfString2;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.AvailabilityAndPricingResponse;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.BookingOptions;
import com.Tamm.Hotels.wcf.HotelCancellationPolicyResponse;
import com.Tamm.Hotels.wcf.Hotel_Room;
import com.Tamm.Hotels.wcf.RoomCombination;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class checkroom extends AppCompatActivity {
    @BindView(R.id.tv_9)
    TextView deadLine_tv;

    @BindView(R.id.check_room_close)
    ImageView checkRoomClose;
    @BindView(R.id.img_check_out)
    ImageView imgCheckOut;

    private Button checkRoom, back;
    @BindView(R.id.tv_total_mount)
    TextView tvTotalMount;

    private BasicHttpBinding_IHotelService1 service;
    private AuthenticationData authenticationData;
    private String sessionId;
    private String mHotelCode;
    private int resultIndex;
    private List<Hotel_Room> rooms = new ArrayList<>();
    TextView roomTyben;
    private String intent;
    private String roomTybe;
    private String description;
    private String mealTybe;
    private ArrayList<Double> roomIndexArray;
    private String roomPrice;
    private String currency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_room);
        ButterKnife.bind(this);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        SharedPreferencesManger.SaveData(this, "noOfTimes", 0);
        auth();
        getIntentInfo();
        back = findViewById(R.id.btn_baack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(checkroom.this, ChooseBookingDate.class));
            }
        });



        tvTotalMount.setText("  Total Amount:             " + roomPrice);

        roomPrice = SharedPreferencesManger.LoadStringData(this, "roomPrice");
        currency = SharedPreferencesManger.LoadStringData(this, "currency");

        String roomIndexArrayStr = SharedPreferencesManger.LoadStringData(this, "roomIndexArray");
        Gson gson = new Gson();
        roomIndexArray = gson.fromJson(roomIndexArrayStr,ArrayList.class);
        ArrayList<Integer> roomIndexArrayInt = new ArrayList<>();
        for (double aDouble : roomIndexArray) {
            roomIndexArrayInt.add((int)aDouble);
        }

        Collections.sort(roomIndexArrayInt);
        tvTotalMount.setText("  TOTAl AMOUNT :                          " + currency + " " + roomPrice);

// FIXME: 29/07/19 booking options according to correct


        BookingOptions bookingOptions = new BookingOptions();
        bookingOptions.RoomCombination = new ArrayList<>();
        RoomCombination roomCombination = new RoomCombination();
        roomCombination.RoomIndex = new ArrayList<>();
        roomCombination.RoomIndex = new ArrayList<>(roomIndexArrayInt);
        bookingOptions.RoomCombination.add(roomCombination);
        SharedPreferencesManger.SaveData(this,"roomIndexArray",null);
        try {

            HotelCancellationPolicyResponse cancelPolicies = service.HotelCancellationPolicy(resultIndex, sessionId, bookingOptions, authenticationData);



            String autoCancellationText = cancelPolicies.CancelPolicies.AutoCancellationText;


            AvailabilityAndPricingResponse availabilityAndPricingResponse = service.AvailabilityAndPricing(resultIndex, sessionId, bookingOptions, authenticationData);

            String deadline = availabilityAndPricingResponse.HotelCancellationPolicies.CancelPolicies.LastCancellationDeadline.toString();

            String[] arrOfStr = deadline.split("T");

            deadLine_tv.setText("Until : " + arrOfStr[0]);

        } catch (Exception e) {
            e.printStackTrace();
        }


        checkRoom = findViewById(R.id.checkOutRoom);
        roomTyben = findViewById(R.id.room_Tybe);
        roomTyben.setText(roomTybe);


        checkRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(checkroom.this, ConfirmBookingRoom.class));

            }
        });


        try {

            service.enableLogging = true;


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getIntentInfo() {

        intent = getIntent().getStringExtra("smok");
        roomTybe = getIntent().getStringExtra("roomTybe");
        description = getIntent().getStringExtra("description");
        sessionId = getIntent().getStringExtra("sessionId");
        mHotelCode = getIntent().getStringExtra("hotelCode");
        resultIndex = getIntent().getIntExtra("resultIndex", 0);
        mealTybe = getIntent().getStringExtra("mealTybe");
//        roomIndex = getIntent().getIntExtra("roomIndex", 1);
    }

    private void auth() {

        service = new BasicHttpBinding_IHotelService1();
        authenticationData = new AuthenticationData();
        service.enableLogging = true;
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");

    }

    @OnClick(R.id.check_room_close)
    public void onViewClicked() {

        startActivity(new Intent(checkroom.this, ChooseBookingDate.class));
    }

    public static class transferClass {

        public static ArrayOfRequestedRooms arrayOfRequestedRooms;


        public static ArrayOfRequestedRooms getArrayOfRequestedRooms() {
            return arrayOfRequestedRooms;
        }

        public static void setArrayOfRequestedRooms(ArrayOfRequestedRooms arrayOfRequestedRooms) {
            ChooseBookingDate.transferClass.arrayOfRequestedRooms = arrayOfRequestedRooms;
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(checkroom.this, ChooseBookingDate.class));

    }
}
