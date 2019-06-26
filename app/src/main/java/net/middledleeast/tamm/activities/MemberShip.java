package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import net.middledleeast.tamm.R;

public class MemberShip extends AppCompatActivity {
Button accept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_ship);
        accept = (Button) findViewById(R.id.btn_register_signup);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MemberShip.this, MemberShipPlan.class);
                startActivity(intent);
            }
        });
    }
}
