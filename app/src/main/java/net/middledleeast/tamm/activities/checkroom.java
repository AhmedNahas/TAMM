package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.Hotel_Room;

import net.middledleeast.tamm.R;

import java.util.ArrayList;
import java.util.List;

public class checkroom extends AppCompatActivity {
    private Button checkRoom;
    private BasicHttpBinding_IHotelService1 service;
    private AuthenticationData authenticationData;
    private String sessionId;
    private String mHotelCode;
    private int resultIndex;
    private List<Hotel_Room> rooms  = new ArrayList<>();
    TextView roomTyben;
    private String intent;
    private String roomTybe;
    private String description;
    private String mealTybe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_room);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        auth();
        getIntentInfo();

//        if (mealTybe == null) {
//            Toast.makeText(this, "" + mealTybe, Toast.LENGTH_SHORT).show();
//        }



        checkRoom=findViewById(R.id.checkOutRoom);
        roomTyben=findViewById(R.id.room_Tybe);
        roomTyben.setText(roomTybe);

        checkRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(checkroom.this,ConfirmBookingRoom.class));
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
        resultIndex = getIntent().getIntExtra("resultIndex", 1);
        mealTybe = getIntent().getStringExtra("mealTybe");

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


        public static ArrayOfRequestedRooms getArrayOfRequestedRooms() {
            return arrayOfRequestedRooms;
        }

        public static void setArrayOfRequestedRooms(ArrayOfRequestedRooms arrayOfRequestedRooms) {
            ChooseBookingDate.transferClass.arrayOfRequestedRooms = arrayOfRequestedRooms;
        }


    }
}
