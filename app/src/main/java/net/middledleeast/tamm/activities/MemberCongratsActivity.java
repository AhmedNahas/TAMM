package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.ActivityToFragment.PaymentActivityFragment;
import net.middledleeast.tamm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MemberCongratsActivity extends AppCompatActivity {

    @BindView(R.id.continueTo)
    Button continueTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_congrats);
        ButterKnife.bind(this);

        continueTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MemberCongratsActivity.this, PaymentActivityFragment.class));
            }
        });

    }
}
