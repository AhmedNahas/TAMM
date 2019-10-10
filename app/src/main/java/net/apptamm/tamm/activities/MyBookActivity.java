package net.apptamm.tamm.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import net.apptamm.tamm.R;
import net.apptamm.tamm.adapters.BookedAdapter;
import net.apptamm.tamm.model.Room.AppDatabase;
import net.apptamm.tamm.model.Room.RoomCartModel;

import java.util.List;

public class MyBookActivity extends AppCompatActivity {

    RecyclerView recycler_view_booked;
    BookedAdapter bookedAdapter;
    RelativeLayout toolbar_back1_booked;




    private String namehotel;
    private String checkin;
    private String checkout;
    private String cancellation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_book);


        recycler_view_booked=findViewById(R.id.recycler_view_booked);

        toolbar_back1_booked=findViewById(R.id.toolbar_back1_booked);
        toolbar_back1_booked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"myBooking").fallbackToDestructiveMigration().allowMainThreadQueries().build();


        List<RoomCartModel> allData = appDatabase.cartDao().getAllData();





        bookedAdapter=new BookedAdapter(MyBookActivity.this,allData);
        recycler_view_booked.setLayoutManager(new LinearLayoutManager(MyBookActivity.this));
        recycler_view_booked.setAdapter(bookedAdapter);
        bookedAdapter.notifyDataSetChanged();

    }


}
