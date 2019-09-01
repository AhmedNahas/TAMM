package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.ActivityToFragment.PaymentActivityFragment;
import net.middledleeast.tamm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FreeCongratsActivity extends AppCompatActivity {


    @BindView(R.id.iv_ok1)
    ImageView ivOk1;
    @BindView(R.id.tv_congrats)
    TextView tvCongrats;
    @BindView(R.id.tv_now)
    TextView tvNow;
    @BindView(R.id.tv_community)
    TextView tvCommunity;
    @BindView(R.id.iv_theman2)
    ImageView ivTheman2;
    @BindView(R.id.continueToFree)
    Button continueTo;
    @BindView(R.id.relative_free_congrats)
    RelativeLayout relativeFreeCongrats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_congrats);
        ButterKnife.bind(this);


        continueTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FreeCongratsActivity.this, PaymentActivityFragment.class));


            }
        });
    }
}
