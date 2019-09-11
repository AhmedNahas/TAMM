package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

public class AssistantActivity extends AppCompatActivity {

    ImageView iv_booked_assistant;
    RelativeLayout relative_flight_assist,relative_hotel_assist,relative_luxury_assist,toolbar_back1_assistant;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistant);

        iv_booked_assistant=findViewById(R.id.iv_booked_assistant);
        relative_flight_assist=findViewById(R.id.relative_flight_assist);


        relative_flight_assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AssistantActivity.this,ChattingActivity.class);
                startActivity(intent);
            }
        });

        toolbar_back1_assistant=findViewById(R.id.toolbar_back1_assistant);
        toolbar_back1_assistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        relative_luxury_assist=findViewById(R.id.relative_luxury_assist);
        relative_luxury_assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Dial="24549544548754";

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+Dial));
                startActivity(intent);
            }
        });
        relative_hotel_assist=findViewById(R.id.relative_hotel_assist);
        relative_hotel_assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Dial="24549544548754";

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+Dial));
                startActivity(intent);

            }
        });








        relative_flight_assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Dial="24549544548754";

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+Dial));
                startActivity(intent);
            }
        });



        iv_booked_assistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AssistantActivity.this,MyBookActivity.class);
                startActivity(intent);

            }
        });


    }
}
