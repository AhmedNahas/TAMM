package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.AdapterHotelInfo;
import net.middledleeast.tamm.adapters.HotelsActivityAdapter;
import net.middledleeast.tamm.model.HotelsModel;

import java.util.ArrayList;
import java.util.List;

public class ChooseHotelActivity extends AppCompatActivity implements HotelsActivityAdapter.onHotelListener {

    private RecyclerView reInfoHotels ;
    AdapterHotelInfo adapterHotelInfo  ;
    private ArrayList<String> hotelName;
    private ArrayList<String> hotelAddress;
    private ArrayList<Integer> hotelrat;
    private ArrayList<String> hotelphoto;
    private AdapterHotelInfo.onHotelListener onHotelListener;
    private ArrayList<String> hotelCode;
    private String mendTime;
    private String mstartTime;
    private String countryName;
    private String cityName;
    private String cityId;
    private String noOfRooms;
    private ArrayList<String> roomGuests;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_hotel);

        reInfoHotels = findViewById(R.id.hotels_rv);


         hotelAddress = (ArrayList<String>) getIntent().getSerializableExtra("hotelAddress");
         hotelName = (ArrayList<String>) getIntent().getSerializableExtra("hotelName");
         hotelrat = (ArrayList<Integer>) getIntent().getSerializableExtra("hotelrat");
         hotelphoto = (ArrayList<String>) getIntent().getSerializableExtra("hotelPhoto");
         hotelCode = (ArrayList<String>) getIntent().getSerializableExtra("hotelCode");
         mstartTime = getIntent().getStringExtra("checkInDate");
         mendTime = getIntent().getStringExtra("checkOutDate");
         countryName = getIntent().getStringExtra("countryName");
        cityName = getIntent().getStringExtra("cityName");
        cityId = getIntent().getStringExtra("cityId");
        noOfRooms = getIntent().getStringExtra("noOfRooms");
        roomGuests =getIntent().getStringArrayListExtra("roomGuest");
         String sessionId = getIntent().getStringExtra("sessionId");


        reInfoHotels.setLayoutManager(new LinearLayoutManager(this));
        adapterHotelInfo = new AdapterHotelInfo(hotelName,hotelrat ,  hotelphoto,this,onHotelListener,hotelAddress , hotelCode ,sessionId ,
                mstartTime , mendTime,countryName,cityName,cityId,noOfRooms,roomGuests);
        reInfoHotels.setAdapter(adapterHotelInfo);
        adapterHotelInfo.notifyDataSetChanged();


    }

    @Override
    public void onHotelClick(int position) {




    }
}
