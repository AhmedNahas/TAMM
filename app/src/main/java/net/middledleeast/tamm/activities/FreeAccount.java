package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

public class FreeAccount extends AppCompatActivity {
    Button accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freeaccount);
        accept = findViewById(R.id.btn_register_signup);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FreeAccount.this, FreeAccountPlan.class);
                startActivity(intent);

            }
        });
    }
}
