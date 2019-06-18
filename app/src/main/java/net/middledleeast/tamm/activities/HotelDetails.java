package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import net.middledleeast.tamm.R;

public class HotelDetails extends AppCompatActivity {

    ImageView imageView;
    TextView name, descrip;
    int hotelImage;
    String hotelName;
    String hotelDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            hotelImage = extras.getInt("selected_hotel_image");
            hotelName = extras.getString("selected_hotel_name");
            hotelDesc = extras.getString("selected_hotel_desc");
        }
        imageView = findViewById(R.id.hotel_image_detail);
        name = findViewById(R.id.hotel_name_detail);
        descrip = findViewById(R.id.hotel_desc_detail);

        imageView.setImageResource(hotelImage);
        name.setText(hotelName);
        descrip.setText(hotelDesc);


    }
}

