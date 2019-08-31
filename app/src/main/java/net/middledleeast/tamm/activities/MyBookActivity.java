package net.middledleeast.tamm.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.BookedAdapter;
import net.middledleeast.tamm.model.Room.AppDatabase;
import net.middledleeast.tamm.model.Room.RoomCartModel;

import java.util.List;

public class MyBookActivity extends AppCompatActivity {

    RecyclerView recycler_view_booked;
    BookedAdapter bookedAdapter;



    private String namehotel;
    private String checkin;
    private String checkout;
    private String cancellation;

    AppDatabase appDatabase ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_book);


        recycler_view_booked=findViewById(R.id.recycler_view_booked);


        appDatabase= Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"myBooking").fallbackToDestructiveMigration().allowMainThreadQueries().build();


        List<RoomCartModel> allData = appDatabase.cartDao().getAllData();





        bookedAdapter=new BookedAdapter(MyBookActivity.this,allData);
        recycler_view_booked.setLayoutManager(new LinearLayoutManager(MyBookActivity.this));
        recycler_view_booked.setAdapter(bookedAdapter);
        bookedAdapter.notifyDataSetChanged();





    }
















}
