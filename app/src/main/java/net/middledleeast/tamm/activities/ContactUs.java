package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;



public class ContactUs extends AppCompatActivity {

    RelativeLayout toolbar_back_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        toolbar_back_contact=findViewById(R.id.toolbar_back_contact);
        toolbar_back_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(ContactUs.this,RenewAccount.class);
                startActivity(intent);

            }
        });

    }
}
