package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

public class checkroom extends AppCompatActivity {
    private Button checkRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_room);

        checkRoom=findViewById(R.id.checkOutRoom);

        checkRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(checkroom.this,ConfirmBookingRoom.class));
            }
        });
    }
}
