package net.middledleeast.tamm.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.MyTripsAdapter;
import net.middledleeast.tamm.model.Room.AppDatabase;
import net.middledleeast.tamm.model.Room.RoomCartModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyTripsActivity extends AppCompatActivity {

    @BindView(R.id.re_MyTrips)
    RecyclerView reMyTrips;

    MyTripsAdapter myTripsAdapter;
    @BindView(R.id.delet_all)
    Button deletAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_trips);
        ButterKnife.bind(this);


        AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        List<RoomCartModel> allData = appDatabase.cartDao().getAllData();


        myTripsAdapter = new MyTripsAdapter(MyTripsActivity.this, allData);
        reMyTrips.setLayoutManager(new LinearLayoutManager(MyTripsActivity.this));
        reMyTrips.setAdapter(myTripsAdapter);
        myTripsAdapter.notifyDataSetChanged();


    }

    @OnClick(R.id.delet_all)
    public void onViewClicked() {

        AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

      appDatabase.cartDao().deletAll();

      myTripsAdapter.notifyDataSetChanged();

    }
}
