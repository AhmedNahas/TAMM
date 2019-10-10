package net.apptamm.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import net.apptamm.tamm.R;
import net.apptamm.tamm.helper.SharedPreferencesManger;

public class AssistantActivity extends AppCompatActivity {

    ImageView iv_booked_assistant;
    RelativeLayout relative_flight_assist,relative_hotel_assist,relative_luxury_assist,toolbar_back1_assistant;
    int id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistant);
        relative_hotel_assist=findViewById(R.id.relative_hotel_assist);

        iv_booked_assistant=findViewById(R.id.iv_booked_assistant);
        relative_flight_assist=findViewById(R.id.relative_flight_assist);
        toolbar_back1_assistant=findViewById(R.id.toolbar_back1_assistant);
        relative_luxury_assist=findViewById(R.id.relative_luxury_assist);
        toolbar_back1_assistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        relative_flight_assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id=1;
                Intent intent =new Intent(AssistantActivity.this,ChattingActivity.class);
                SharedPreferencesManger.SaveData(AssistantActivity.this,"idAssistant",id);
                startActivity(intent);


            }
        });




        relative_luxury_assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id=2;

                SharedPreferencesManger.SaveData(AssistantActivity.this,"idAssistant",id);

                Intent intent =new Intent(AssistantActivity.this,ChattingActivity.class);
                startActivity(intent);


//                String Dial="24549544548754";
//
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:"+Dial));
//                startActivity(intent);
            }
        });
        relative_hotel_assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id=3;

                SharedPreferencesManger.SaveData(AssistantActivity.this,"idAssistant",id);

                Intent intent =new Intent(AssistantActivity.this,ChattingActivity.class);
                startActivity(intent);
//                String Dial="24549544548754";
//
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:"+Dial));
//                startActivity(intent);

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
