package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.util.Base64;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.FreeAdapter;
import net.middledleeast.tamm.model.Users;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UsersFree extends AppCompatActivity {
        ImageView imgView;
        RecyclerView recyclerView;
        FreeAdapter freeAdapter;
        List<Users> users=new ArrayList<>();

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_free);
        imgView=findViewById(R.id.img_tamm);
        recyclerView=findViewById(R.id.recycler_view);

        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        freeAdapter=new FreeAdapter(UsersFree.this,users);
        recyclerView.setLayoutManager(new LinearLayoutManager(UsersFree.this));
        recyclerView.setAdapter(freeAdapter);
        freeAdapter.notifyDataSetChanged();

    }
}
