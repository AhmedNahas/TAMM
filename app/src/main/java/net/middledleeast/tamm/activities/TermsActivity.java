package net.middledleeast.tamm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.RegisterationActivity;

import static net.middledleeast.tamm.fragments.MemberShip.TERMS;

public class TermsActivity extends AppCompatActivity {

    TextView terms ;
    RelativeLayout toolbar_back1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        terms = findViewById(R.id.tv_term);
        toolbar_back1=findViewById(R.id.toolbar_back1);
        terms.setText(TERMS);

        toolbar_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TermsActivity.this, RenewAccount.class));

            }
        });


    }
}
