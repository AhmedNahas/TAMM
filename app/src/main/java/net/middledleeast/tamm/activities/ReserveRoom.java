package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ReserveRoom extends AppCompatActivity {
    @BindView(R.id.relative_img_hotel_tamm)
    RelativeLayout relativeImgHotelTamm;
//    @BindView(R.id.assistant_label_voice_hotel)
//    TextView assistantLabelVoiceHotel;
//    @BindView(R.id.assistant_label_call_hotel)
//    TextView assistantLabelCall;
//    @BindView(R.id.assistant_label_message_hotel)
//    TextView assistantLabelMessage;
    private Toolbar toolbar;
    private ImageView logo, imgbutton, bigline, smallline, imghotel, imgman,iv_booked_reserve;
    private TextView tammtxt, hotelstxt, besttxt, specialtxt, anywhere, anytime;
    private Button btnarrow, reservebtn;
    LinearLayout imageView;

    boolean ClickHotel=false;
    private Integer accountPlan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserve_room);
        ButterKnife.bind(this);
        accountPlan = SharedPreferencesManger.LoadIntegerData(this, "accountPlan");


        SharedPreferencesManger.remove(this,"startDateSyear");
        SharedPreferencesManger.remove(this,"startDateSday");
        SharedPreferencesManger.remove(this,"startDateSmonth");

        SharedPreferencesManger.remove(this,"endDateSyear");
        SharedPreferencesManger.remove(this,"endDateSday");
        SharedPreferencesManger.remove(this,"endDateSmonth");







        imageView = findViewById(R.id.back_pressed);
        iv_booked_reserve=findViewById(R.id.iv_booked_reserve);
        iv_booked_reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ReserveRoom.this,MyBookActivity.class);
                startActivity(intent);


            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReserveRoom.this,RenewAccount.class));

            }
        });




try {
    if (accountPlan == 1) {


        iv_booked_reserve.setVisibility(View.VISIBLE);

    } else if (accountPlan == 0) {

        iv_booked_reserve.setVisibility(View.VISIBLE);

    } else if (accountPlan == 2) {
        iv_booked_reserve.setVisibility(View.GONE);

    }
}catch (Exception e){}


//


        reservebtn = findViewById(R.id.btn_reserve_user);
//        bigline=findViewById(R.id.img_bigline);
//        smallline=findViewById(R.id.img_smallline);
//        imghotel=findViewById(R.id.img_hotel);
//        imgman=findViewById(R.id.img_man);
//        tammtxt=findViewById(R.id.txt_tamm);
//        hotelstxt=findViewById(R.id.txt_hotels);
//        besttxt=findViewById(R.id.txt_best);
//        specialtxt=findViewById(R.id.txt_special);
//        anywhere=findViewById(R.id.txt_anywhere);
//        anytime=findViewById(R.id.txt_anytime)

        reservebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReserveRoom.this, FindHotels.class));
            }
        });

    }


    @OnClick(R.id.relative_img_hotel_tamm)
    public void onViewClicked() {
        Intent intent =new Intent(ReserveRoom.this,AssistantActivity.class);
        startActivity(intent);

//        if (ClickHotel == false) {
//            assistantLabelCall.setVisibility(View.VISIBLE);
//            assistantLabelMessage.setVisibility(View.VISIBLE);
//            assistantLabelVoiceHotel.setVisibility(View.VISIBLE);
//            ClickHotel = true;
//
//        } else {
//            assistantLabelCall.setVisibility(View.INVISIBLE);
//            assistantLabelMessage.setVisibility(View.INVISIBLE);
//            assistantLabelVoiceHotel.setVisibility(View.INVISIBLE);
//            ClickHotel = false;
//
//        }


    }
//
//    @OnClick({R.id.assistant_label_voice_hotel, R.id.assistant_label_call_hotel, R.id.assistant_label_message_hotel})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.assistant_label_voice_hotel:
//
//                Intent intent = new Intent(ReserveRoom.this, AssistantActivity.class);
//                startActivity(intent);
//                Toast.makeText(this, "Voice", Toast.LENGTH_SHORT).show();
//
//                break;
//            case R.id.assistant_label_call_hotel:
//
//                Intent intent1 = new Intent(ReserveRoom.this, AssistantActivity.class);
//                startActivity(intent1);
//                Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show();
//
//                break;
//            case R.id.assistant_label_message_hotel:
//
//                Intent intent2 = new Intent(ReserveRoom.this, AssistantActivity.class);
//                startActivity(intent2);
//                Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show();
//
//                break;
//        }
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        startActivity(new Intent(ReserveRoom.this, RenewAccount.class));
    }





}
