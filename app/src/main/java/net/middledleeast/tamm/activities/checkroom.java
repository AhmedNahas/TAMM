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
import com.Tamm.Hotels.wcf.ArrayOfString;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.HotelDetailsResponse;
import com.Tamm.Hotels.wcf.HotelRoomAvailabilityResponse;
import com.Tamm.Hotels.wcf.Hotel_Room;
import com.Tamm.Hotels.wcf.Rate;
import com.Tamm.Hotels.wcf.RequestedRooms;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.RoomsAdapter;

import org.joda.time.DateTime;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_room);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        auth();
        String intent = getIntent().getStringExtra("smok");
        String roomTybe = getIntent().getStringExtra("roomTybe");
        String description = getIntent().getStringExtra("description");
        Toast.makeText(this, ""+description, Toast.LENGTH_SHORT).show();

        checkRoom=findViewById(R.id.checkOutRoom);
        roomTyben=findViewById(R.id.room_Tybe);
        roomTyben.setText(roomTybe);

        checkRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(checkroom.this,ConfirmBookingRoom.class));
            }
        });

        sessionId = getIntent().getStringExtra("sessionId");
        mHotelCode = getIntent().getStringExtra("hotelCode");
        resultIndex = getIntent().getIntExtra("resultIndex", 1);
        try {

            service.enableLogging = true;




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


        public static ArrayOfRequestedRooms getArrayOfRequestedRooms() {
            return arrayOfRequestedRooms;
        }

        public static void setArrayOfRequestedRooms(ArrayOfRequestedRooms arrayOfRequestedRooms) {
            ChooseBookingDate.transferClass.arrayOfRequestedRooms = arrayOfRequestedRooms;
        }


    }
}
