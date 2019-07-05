package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

public class MemberCongrats extends AppCompatActivity {

    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.member_congrats);
    button=findViewById(R.id.continueTo);


   startActivity(new Intent(MemberCongrats.this , RenewAccount.class));


    }
}
