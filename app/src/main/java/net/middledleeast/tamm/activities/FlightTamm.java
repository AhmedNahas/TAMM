package net.middledleeast.tamm.activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.middledleeast.tamm.R;

public class FlightTamm extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_tamm);

        button=findViewById(R.id.btn_reserve_user);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FlightTamm.this,Proceedbeybey.class));
            }
        });
    }
}
