package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FlightTamm extends AppCompatActivity {

    @BindView(R.id.relative_img_flight_tamm)
    RelativeLayout relativeImgFlightTamm;
    @BindView(R.id.fragment_assistant_label_voice)
    TextView fragmentAssistantLabelVoice;
    @BindView(R.id.fragment_assistant_label_call)
    TextView fragmentAssistantLabelCall;
    @BindView(R.id.fragment_assistant_label_message)
    TextView fragmentAssistantLabelMessage;
    private Button button;
    private RelativeLayout toolbar_back;

    ImageView iv_booked_flight_tamm;

    boolean Click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_tamm);
        ButterKnife.bind(this);

        iv_booked_flight_tamm=findViewById(R.id.iv_booked_flight_tamm);
        iv_booked_flight_tamm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(FlightTamm.this,MyBookActivity.class);
                startActivity(intent);
            }
        });

        toolbar_back= findViewById(R.id.toolbar_back1);

        toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FlightTamm.this, RenewAccount.class));
            }
        });

        button = findViewById(R.id.btn_reserve_user);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FlightTamm.this, Proceedbeybey.class));
            }
        });

    }

    @OnClick(R.id.relative_img_flight_tamm)
    public void onViewClicked() {

        if (Click == false) {
            fragmentAssistantLabelCall.setVisibility(View.VISIBLE);
            fragmentAssistantLabelMessage.setVisibility(View.VISIBLE);
            fragmentAssistantLabelVoice.setVisibility(View.VISIBLE);
            Click = true;

        } else {
            fragmentAssistantLabelCall.setVisibility(View.INVISIBLE);
            fragmentAssistantLabelMessage.setVisibility(View.INVISIBLE);
            fragmentAssistantLabelVoice.setVisibility(View.INVISIBLE);
            Click = false;

        }


    }

    @OnClick({R.id.fragment_assistant_label_voice, R.id.fragment_assistant_label_call, R.id.fragment_assistant_label_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment_assistant_label_voice:

                Toast.makeText(this, "voice", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fragment_assistant_label_call:
                Toast.makeText(this, "call", Toast.LENGTH_SHORT).show();

                break;
            case R.id.fragment_assistant_label_message:
                Toast.makeText(this, "message", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
