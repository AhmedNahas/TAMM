package net.middledleeast.tamm.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Tamm.Hotels.wcf.ArrayOfRoomGuest;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.RoomGuest;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.HotelsActivityAdapter;
import net.middledleeast.tamm.model.HotelsModel;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class ChooseHotelActivity extends AppCompatActivity implements HotelsActivityAdapter.onHotelListener {

    private RecyclerView recyclerView;
    private List<HotelsModel> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_hotel);


        com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1 service = new com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1();
        AuthenticationData authenticationData = new AuthenticationData();
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");
        RoomGuest roomGuest = new RoomGuest();
        roomGuest.AdultCount = 1;
        roomGuest.ChildCount = 0;
        ArrayOfRoomGuest roomguests = new ArrayOfRoomGuest();
        roomguests.add(roomGuest);

        DateTime date1 = DateTime.now();
        DateTime date2 = DateTime.now();
        date1 = date1.plusDays(3);
        date2 = date2.plusDays(7);


//        HotelSearchResponse hotelSearchResponse = service.HotelSearchAsync(date1.toDateTimeISO(), date2.toDateTimeISO(),);


//        ArrayOfHotel_Result arrayOfHotelResult = hotelSearchResponse.HotelResultList;



        recyclerView = findViewById(R.id.hotels_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        models.add(new HotelsModel(R.drawable.fourseasonshotel,"Four Seasons","They are spring, summer, fall, and winter. The weather is different during each season. ... " +
                "In spring, the weather begins to get warmer and trees and other plants grow new leaves. Summer is the hottest season and has long, usually sunny, "));
        models.add(new HotelsModel(R.drawable.fourseasons,"Hilton","They are spring, summer, fall, and winter. The weather is different during each season. ... " +
                "In spring, the weather begins to get warmer and trees and other plants grow new leaves. Summer is the hottest season and has long, usually sunny, "));
        models.add(new HotelsModel(R.drawable.le,"Kempenski","They are spring, summer, fall, and winter. The weather is different during each season. ... " +
                "In spring, the weather begins to get warmer and trees and other plants grow new leaves. Summer is the hottest season and has long, usually sunny, "));
        models.add(new HotelsModel(R.drawable.lp,"JW Mariiot","They are spring, summer, fall, and winter. The weather is different during each season. ... " +
                "In spring, the weather begins to get warmer and trees and other plants grow new leaves. Summer is the hottest season and has long, usually sunny, "));
        models.add(new HotelsModel(R.drawable.fourseasonshotel,"Semiramis","They are spring, summer, fall, and winter. The weather is different during each season. ... " +
                "In spring, the weather begins to get warmer and trees and other plants grow new leaves. Summer is the hottest season and has long, usually sunny, "));

        HotelsActivityAdapter recyclerAdapter = new HotelsActivityAdapter(this,models , this);
        recyclerView.setAdapter(recyclerAdapter);

    }

    @Override
    public void onHotelClick(int position) {

    }
}
