package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

public class AssistantActivity extends AppCompatActivity {

    ImageView iv_booked_assistant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistant);

        iv_booked_assistant=findViewById(R.id.iv_booked_assistant);
        iv_booked_assistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AssistantActivity.this,MyBookActivity.class);
                startActivity(intent);

            }
        });


    }
}
