package net.middledleeast.tamm.activities;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.HotelsActivityAdapter;
import net.middledleeast.tamm.model.HotelsModel;

import java.util.ArrayList;
import java.util.List;

public class ChooseHotelActivity extends AppCompatActivity implements HotelsActivityAdapter.onHotelListener {

    private RecyclerView recyclerView;
    private List<HotelsModel> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_hotel);

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
