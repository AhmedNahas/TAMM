package net.middledleeast.tamm.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.AdapterHotelInfo;
import net.middledleeast.tamm.adapters.HotelsActivityAdapter;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ChooseHotelActivity extends AppCompatActivity implements HotelsActivityAdapter.onHotelListener {

    AdapterHotelInfo adapterHotelInfo;
    private RecyclerView reInfoHotels;
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
    private int noOfRooms;
    private ArrayList<String> roomGuests;
    private ArrayList<Integer> resultIndex;
    List<Integer> childCont = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_hotel);

//        reInfoHotels = findViewById(R.id.hotels_rv);
//        resultIndex = new ArrayList<>();

//        hotelAddress = (ArrayList<String>) getIntent().getSerializableExtra("hotelAddress");
//        hotelName = (ArrayList<String>) getIntent().getSerializableExtra("hotelName");
//        hotelrat = (ArrayList<Integer>) getIntent().getSerializableExtra("hotelrat");
//        hotelphoto = (ArrayList<String>) getIntent().getSerializableExtra("hotelPhoto");
//        hotelCode = (ArrayList<String>) getIntent().getSerializableExtra("hotelCode");
//        mstartTime = getIntent().getStringExtra("checkInDate");
//        mendTime = getIntent().getStringExtra("checkOutDate");
//        countryName = getIntent().getStringExtra("countryName");
//        cityName = getIntent().getStringExtra("cityName");
//        cityId = getIntent().getStringExtra("cityId");
//        noOfRooms = getIntent().getIntExtra("noOfRooms", 1);
//        roomGuests = getIntent().getStringArrayListExtra("roomGuest");
//        String sessionId = getIntent().getStringExtra("sessionId");
//        resultIndex = (ArrayList<Integer>) getIntent().getSerializableExtra("resultIndex");
//
//        reInfoHotels.setLayoutManager(new LinearLayoutManager(this));
//        adapterHotelInfo = new AdapterHotelInfo(ChooseHotelActivity.this, hotelName, hotelrat, hotelphoto, this, onHotelListener, hotelAddress, hotelCode, sessionId,
//                mstartTime, mendTime, countryName, cityName, cityId, noOfRooms, roomGuests, resultIndex);
//        reInfoHotels.setAdapter(adapterHotelInfo);
//        adapterHotelInfo.notifyDataSetChanged();

        String child_count = SharedPreferencesManger.LoadStringData(this, "child_count");

       // StringTokenizer st = new StringTokenizer(savedString, ",");

        Toast.makeText(this, ""+child_count, Toast.LENGTH_SHORT).show();
        SharedPreferencesManger.remove(this,"child_count");
      //  while (st.hasMoreTokens()) {
      //      childCont.add(Integer.parseInt(st.nextToken()));

      //  }


    }


    @Override
    public void onHotelClick(int position) {


    }
}
