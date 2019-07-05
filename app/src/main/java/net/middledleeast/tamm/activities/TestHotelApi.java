package net.middledleeast.tamm.activities;

import android.os.Bundle;
import android.os.StrictMode;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.Tamm.Hotels.wcf.ArrayOfRoomGuest;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.HotelSearchResponse;
import com.Tamm.Hotels.wcf.RoomGuest;

import org.joda.time.DateTime;

import java.util.Calendar;


public class TestHotelApi extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1 service = new com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1();
        AuthenticationData authenticationData = new AuthenticationData();
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");
        try {
            Calendar cal1 = Calendar.getInstance();
            cal1.set(Calendar.DAY_OF_MONTH, 28);
            Calendar cal2 = Calendar.getInstance();
            cal2.set(Calendar.DAY_OF_MONTH, 30);
            DateTime date1 = DateTime.now();
            DateTime date2 = DateTime.now();
            date1 = date1.plusDays(3);
            date2 = date2.plusDays(7);


            service.enableLogging = true;

//            service.DestinationCityList("IN", null, authenticationData);
            RoomGuest roomGuest = new RoomGuest();
            roomGuest.AdultCount = 1;
            roomGuest.ChildCount = 0;
            ArrayOfRoomGuest roomguests = new ArrayOfRoomGuest();
            roomguests.add(roomGuest);
            HotelSearchResponse hotelSearchResponse = service.HotelSearch1(date1.toDateTimeISO(), date2.toDateTimeISO(), 144154, 1, roomguests, "EG", authenticationData);
            String test = hotelSearchResponse.Status.Description;
            System.out.println("Hello: " + test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}