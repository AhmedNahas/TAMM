package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.middledleeast.tamm.R;

public class HotelDetails extends AppCompatActivity {

    ImageView imageView;
    TextView name, descrip;
    int hotelImage;
    String hotelName;
    String hotelDesc;
    Button btnNext;

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
        btnNext = findViewById(R.id.btn_next);

        imageView.setImageResource(hotelImage);
        name.setText(hotelName);
        descrip.setText(hotelDesc);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HotelDetails.this,ChooseBookingDate.class));
            }
        });


    }
}

