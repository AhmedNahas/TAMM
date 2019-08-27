package net.middledleeast.tamm.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.BookedAdapter;

public class MyBookActivity extends AppCompatActivity {

    RecyclerView recycler_view_booked;
    BookedAdapter bookedAdapter;

    private String namehotel;
    private String checkin;
    private String checkout;
    private String cancellation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_book);


        recycler_view_booked=findViewById(R.id.recycler_view_booked);




        bookedAdapter=new BookedAdapter(MyBookActivity.this,namehotel,checkin,checkout,cancellation);
        recycler_view_booked.setLayoutManager(new LinearLayoutManager(MyBookActivity.this));
        recycler_view_booked.setAdapter(bookedAdapter);





    }
}
