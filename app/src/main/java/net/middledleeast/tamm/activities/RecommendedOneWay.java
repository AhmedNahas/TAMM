package net.middledleeast.tamm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.middledleeast.tamm.R;

public class RecommendedOneWay extends AppCompatActivity {
    private Button proceedButn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommended__one_way);

        proceedButn=findViewById(R.id.btn_proceed);

        proceedButn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecommendedOneWay.this,PassengerInformation.class));
            }
        });
    }
}
