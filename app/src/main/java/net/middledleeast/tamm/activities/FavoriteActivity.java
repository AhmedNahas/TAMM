package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.FavoriteAddapter;
import net.middledleeast.tamm.model.Room.AppDatabase;
import net.middledleeast.tamm.model.Room.RoomCartModel;

import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FavoriteAddapter favoriteAddapter;
    ImageView iv_booked_favorite;
    RelativeLayout toolbar_back1_favorite;

    public static AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        recyclerView=findViewById(R.id.recycler_view_favorite);
        iv_booked_favorite=findViewById(R.id.iv_booked_favorite);
        iv_booked_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(FavoriteActivity.this,MyBookActivity.class);
                startActivity(intent);
            }
        });

        toolbar_back1_favorite=findViewById(R.id.toolbar_back1_favorite);
        toolbar_back1_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(FavoriteActivity.this,RenewAccount.class);
                startActivity(intent);


            }
        });

        appDatabase= Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"offerdp").allowMainThreadQueries().build();

        final List<RoomCartModel> allData = appDatabase.cartDao().getAllData();


        favoriteAddapter = new FavoriteAddapter(allData, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(FavoriteActivity.this));
        recyclerView.setAdapter(favoriteAddapter);
        favoriteAddapter.notifyDataSetChanged();






    }
}
