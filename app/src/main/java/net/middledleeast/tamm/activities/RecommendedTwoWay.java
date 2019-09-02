package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

public class RecommendedTwoWay extends AppCompatActivity {

    RelativeLayout relative_back_recommend_two_way;

    ImageView iv_booked_recommended_two_way;
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

        relative_back_recommend_two_way=findViewById(R.id.relative_back_recommend_two_way);
        relative_back_recommend_two_way.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
