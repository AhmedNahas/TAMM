package net.middledleeast.tamm.activities;

import android.os.Bundle;
import android.os.StrictMode;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.Tamm.Hotels.wcf.AuthenticationData;

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
        authenticationData.setUserName("Tammtest");
        authenticationData.setPassword("Tam@18418756");
        try {
            Calendar cal1 = Calendar.getInstance();
            cal1.set(Calendar.DAY_OF_MONTH, 28);
            Calendar cal2 = Calendar.getInstance();
            cal2.set(Calendar.DAY_OF_MONTH, 30);
            DateTime date1 = DateTime.now();
            DateTime date2 = DateTime.now();
            date2.plusDays(3);


            service.enableLogging = true;

            service.enableMTOM = true;
            service.DestinationCityList("IN", null, authenticationData);

//            HotelSearchResponse hotelSearchResponse = service.HotelSearch(date1,date2, null, null, null, null, null, null, null, null, null
//                    , null, null, null, null, authenticationData);
//            String test = hotelSearchResponse.Status.Description;
//            System.out.println("Hello: " + test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}