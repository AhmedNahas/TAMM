package net.apptamm.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import net.apptamm.tamm.R;
import net.apptamm.tamm.helper.SharedPreferencesManger;

public class RecommendedTwoWay extends AppCompatActivity {

    RelativeLayout relative_back_recommend_two_way;

    ImageView iv_booked_recommended_two_way;
    private Integer accountPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommended_two_way);

        iv_booked_recommended_two_way=findViewById(R.id.iv_booked_recommended_two_way);
        iv_booked_recommended_two_way.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecommendedTwoWay.this,MyBookActivity.class);
                startActivity(intent);
            }
        });
        accountPlan = SharedPreferencesManger.LoadIntegerData(this, "accountPlan");

        try {
            if (accountPlan == 1) {


                iv_booked_recommended_two_way.setVisibility(View.VISIBLE);

            } else if (accountPlan == 0) {

                iv_booked_recommended_two_way.setVisibility(View.VISIBLE);

            } else if (accountPlan == 2) {
                iv_booked_recommended_two_way.setVisibility(View.GONE);

            }
        }catch (Exception e){}

        relative_back_recommend_two_way=findViewById(R.id.relative_back_recommend_two_way);
        relative_back_recommend_two_way.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
