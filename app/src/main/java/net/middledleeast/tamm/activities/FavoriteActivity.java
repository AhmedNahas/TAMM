package net.middledleeast.tamm.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.OffersAdapter;

public class FavoriteActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    OffersAdapter offersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);


        recyclerView=findViewById(R.id.recycler_view_favorite);

        offersAdapter = new OffersAdapter(this,2);
        recyclerView.setLayoutManager(new LinearLayoutManager(FavoriteActivity.this));
        recyclerView.setAdapter(offersAdapter);

    }
}
