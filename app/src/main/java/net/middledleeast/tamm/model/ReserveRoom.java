package net.middledleeast.tamm.model;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import net.middledleeast.tamm.R;

import static net.middledleeast.tamm.R.layout.reserve_room;

public class ReserveRoom extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView logo,imgbutton,bigline,smallline,imghotel,imgman;
    private TextView tammtxt,hotelstxt,besttxt,specialtxt,anywhere,anytime;
    private Button btnarrow,reservebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(reserve_room);

        reservebtn =findViewById(R.id.btn_reserve_user);


        bigline=findViewById(R.id.img_bigline);
        smallline=findViewById(R.id.img_smallline);
        imghotel=findViewById(R.id.img_hotel);
        imgman=findViewById(R.id.img_man);

        tammtxt=findViewById(R.id.txt_tamm);
        hotelstxt=findViewById(R.id.txt_hotels);
        besttxt=findViewById(R.id.txt_best);
        specialtxt=findViewById(R.id.txt_special);
        anywhere=findViewById(R.id.txt_anywhere);
        anytime=findViewById(R.id.txt_anytime);


    }

    public void reverse_room(View view) {
        startActivity(new Intent(ReserveRoom.this, FindHotels.class));

    }
}
