package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import net.middledleeast.tamm.R;

public  class FreeAccountPlan extends AppCompatActivity {
    private Button accept;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.free_account_plan);

        accept = (Button) findViewById(R.id.btn_register_signup);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FreeAccountPlan.this, ProceedCheckout.class);
                startActivity(intent);

            }
        });
    }
}
