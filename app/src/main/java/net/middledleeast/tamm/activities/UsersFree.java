package net.middledleeast.tamm.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.FreeAdapter;
import net.middledleeast.tamm.model.Users;

import java.util.ArrayList;
import java.util.List;

public class UsersFree extends AppCompatActivity {
        ImageView imgView;
        RecyclerView recyclerView;
        FreeAdapter freeAdapter;
        List<Users> users=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_free);
        imgView=findViewById(R.id.img_tamm);
        recyclerView=findViewById(R.id.recycler_view);
        users.add(new Users("Mohamed","01062594878",0));
        users.add(new Users("Mohamed","01062594878",0));
        users.add(new Users("Mohamed","01062594878",0));
        freeAdapter=new FreeAdapter(UsersFree.this,users);
        recyclerView.setLayoutManager(new LinearLayoutManager(UsersFree.this));
        recyclerView.setAdapter(freeAdapter);
        freeAdapter.notifyDataSetChanged();

    }
}
