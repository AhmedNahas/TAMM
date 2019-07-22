package net.middledleeast.tamm.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.FindHotels;
import net.middledleeast.tamm.activities.RenewAccount;
import net.middledleeast.tamm.fragments.TammFamilyFragment;


public class ReserveRoom extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView logo,imgbutton,bigline,smallline,imghotel,imgman;
    private TextView tammtxt,hotelstxt,besttxt,specialtxt,anywhere,anytime;
    private Button btnarrow,reservebtn;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserve_room);


        imageView = findViewById(R.id.back_pressed);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(ReserveRoom.this, RenewAccount.class));
            }
        });
//


        reservebtn =findViewById(R.id.btn_reserve_user);
//        bigline=findViewById(R.id.img_bigline);
//        smallline=findViewById(R.id.img_smallline);
//        imghotel=findViewById(R.id.img_hotel);
//        imgman=findViewById(R.id.img_man);
//        tammtxt=findViewById(R.id.txt_tamm);
//        hotelstxt=findViewById(R.id.txt_hotels);
//        besttxt=findViewById(R.id.txt_best);
//        specialtxt=findViewById(R.id.txt_special);
//        anywhere=findViewById(R.id.txt_anywhere);
//        anytime=findViewById(R.id.txt_anytime)

        reservebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReserveRoom.this, FindHotels.class));
            }
        });

    }


}
