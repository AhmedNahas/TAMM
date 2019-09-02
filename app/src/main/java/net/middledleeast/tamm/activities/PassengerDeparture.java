package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class PassengerDeparture extends AppCompatActivity {
    int counter = 0;
    int counter2 = 0;
    int counter3 = 0;
    int counter4 = 0;
    int counter5 = 0;
    int counter6 = 0;

    Button priceFinal;
    @BindView(R.id.relative_passenger)
    RelativeLayout relativePassenger;
    @BindView(R.id.im_medium_line)
    ImageView imMediumLine;
    @BindView(R.id.tv_passenger)
    TextView tvPassenger;
    @BindView(R.id.tv_depature)
    TextView tvDepature;
    @BindView(R.id.iv_walchair)
    ImageView ivWalchair;
    @BindView(R.id.iv_logo_plane)
    ImageView ivLogoPlane;
    @BindView(R.id.iv_bag)
    ImageView ivBag;
    @BindView(R.id.relative_chair_bag)
    RelativeLayout relativeChairBag;
    @BindView(R.id.tv_adult)
    TextView tvAdult;
    @BindView(R.id.rd_wal_chair)
    CheckBox rdWalChair;
    @BindView(R.id.rd_passenger)
    CheckBox rdPassenger;
    @BindView(R.id.rd_group)
    RelativeLayout rdGroup;
    @BindView(R.id.decrease_adult)
    ImageView decreaseAdult;
    @BindView(R.id.tv_adult_bg)
    TextView tvAdultBg;
    @BindView(R.id.increase_adult)
    ImageView increaseAdult;
    @BindView(R.id.relative_decrease_increase)
    RelativeLayout relativeDecreaseIncrease;
    @BindView(R.id.tv_price_adult)
    TextView tvPriceAdult;
    @BindView(R.id.relative_adult)
    RelativeLayout relativeAdult;
    @BindView(R.id.iv_line01)
    ImageView ivLine01;
    @BindView(R.id.tv_child)
    TextView tvChild;
    @BindView(R.id.rd_wal_chair_child)
    CheckBox rdWalChairChild;
    @BindView(R.id.rd_passenger_Child)
    CheckBox rdPassengerChild;
    @BindView(R.id.rd_group1)
    RelativeLayout rdGroup1;
    @BindView(R.id.decrease_child)
    ImageView decreaseChild;
    @BindView(R.id.tv_child_bg)
    TextView tvChildBg;
    @BindView(R.id.increase_child)
    ImageView increaseChild;
    @BindView(R.id.relative_decrease_increase2)
    RelativeLayout relativeDecreaseIncrease2;
    @BindView(R.id.tv_price_child)
    TextView tvPriceChild;
    @BindView(R.id.relative_child)
    RelativeLayout relativeChild;
    @BindView(R.id.iv_line02)
    ImageView ivLine02;
    @BindView(R.id.tv_infant)
    TextView tvInfant;
    @BindView(R.id.rd_wal_chair_infant)
    CheckBox rdWalChairInfant;
    @BindView(R.id.rd_passenger_infant)
    CheckBox rdPassengerInfant;
    @BindView(R.id.rd_group2)
    RelativeLayout rdGroup2;
    @BindView(R.id.decrease_infant)
    ImageView decreaseInfant;
    @BindView(R.id.tv_infant_bg)
    TextView tvInfantBg;
    @BindView(R.id.increase_infant)
    ImageView increaseInfant;
    @BindView(R.id.relative_decrease_increase3)
    RelativeLayout relativeDecreaseIncrease3;
    @BindView(R.id.tv_price_infant)
    TextView tvPriceInfant;
    @BindView(R.id.relative_infant)
    RelativeLayout relativeInfant;
    @BindView(R.id.iv_line03)
    ImageView ivLine03;
    @BindView(R.id.tv_totaltaxes)
    TextView tvTotaltaxes;
    @BindView(R.id.tv_total_taxes)
    TextView tvTotalTaxes;
    @BindView(R.id.relative_total_taxes)
    RelativeLayout relativeTotalTaxes;
    @BindView(R.id.iv_line04)
    ImageView ivLine04;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.relative_many)
    RelativeLayout relativeMany;
    @BindView(R.id.tv_return)
    TextView tvReturn;
    @BindView(R.id.iv_walchair2)
    ImageView ivWalchair2;
    @BindView(R.id.iv_logo_plane2)
    ImageView ivLogoPlane2;
    @BindView(R.id.iv_bag2)
    ImageView ivBag2;
    @BindView(R.id.relative_chair_bag2)
    RelativeLayout relativeChairBag2;
    @BindView(R.id.tv_adult2)
    TextView tvAdult2;
    @BindView(R.id.rd_wal_chair2)
    CheckBox rdWalChair2;
    @BindView(R.id.rd_passenger2)
    CheckBox rdPassenger2;
    @BindView(R.id.rd_group3)
    RelativeLayout rdGroup3;
    @BindView(R.id.decrease_adult2)
    ImageView decreaseAdult2;
    @BindView(R.id.tv_adult_bg2)
    TextView tvAdultBg2;
    @BindView(R.id.increase_adult2)
    ImageView increaseAdult2;
    @BindView(R.id.relative_decrease_increase4)
    RelativeLayout relativeDecreaseIncrease4;
    @BindView(R.id.tv_price_adult2)
    TextView tvPriceAdult2;
    @BindView(R.id.relative_adult2)
    RelativeLayout relativeAdult2;
    @BindView(R.id.iv_line05)
    ImageView ivLine05;
    @BindView(R.id.tv_child2)
    TextView tvChild2;
    @BindView(R.id.rd_wal_chair_child2)
    CheckBox rdWalChairChild2;
    @BindView(R.id.rd_passenger_Child2)
    CheckBox rdPassengerChild2;
    @BindView(R.id.rd_group4)
    RelativeLayout rdGroup4;
    @BindView(R.id.decrease_child2)
    ImageView decreaseChild2;
    @BindView(R.id.tv_child_bg2)
    TextView tvChildBg2;
    @BindView(R.id.increase_child2)
    ImageView increaseChild2;
    @BindView(R.id.relative_decrease_increase5)
    RelativeLayout relativeDecreaseIncrease5;
    @BindView(R.id.tv_price_child2)
    TextView tvPriceChild2;
    @BindView(R.id.relative_child2)
    RelativeLayout relativeChild2;
    @BindView(R.id.iv_line06)
    ImageView ivLine06;
    @BindView(R.id.tv_infant2)
    TextView tvInfant2;
    @BindView(R.id.rd_wal_chair_infant2)
    CheckBox rdWalChairInfant2;
    @BindView(R.id.rd_passenger_infant2)
    CheckBox rdPassengerInfant2;
    @BindView(R.id.rd_group5)
    RelativeLayout rdGroup5;
    @BindView(R.id.decrease_infant2)
    ImageView decreaseInfant2;
    @BindView(R.id.tv_infant_bg2)
    TextView tvInfantBg2;
    @BindView(R.id.increase_infant2)
    ImageView increaseInfant2;
    @BindView(R.id.relative_decrease_increase6)
    RelativeLayout relativeDecreaseIncrease6;
    @BindView(R.id.tv_price_infant2)
    TextView tvPriceInfant2;
    @BindView(R.id.relative_infant2)
    RelativeLayout relativeInfant2;
    @BindView(R.id.iv_line07)
    ImageView ivLine07;
    @BindView(R.id.tv_totaltaxes2)
    TextView tvTotaltaxes2;
    @BindView(R.id.tv_total_taxes_2)
    TextView tvTotalTaxes2;
    @BindView(R.id.relative_total_taxes2)
    RelativeLayout relativeTotalTaxes2;
    @BindView(R.id.iv_line08)
    ImageView ivLine08;
    @BindView(R.id.tv_total2)
    TextView tvTotal2;
    @BindView(R.id.relative_many2)
    RelativeLayout relativeMany2,relative_back_flight_departure;

    ImageView iv_booked_passenger_departure;

    private ImageView imgincreaseadult, imgdecreaseadult;
    // private TextView txtadult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_departure);
        ButterKnife.bind(this);
        priceFinal = findViewById(R.id.priceFinal);
        imgdecreaseadult = findViewById(R.id.decrease_adult);
        imgincreaseadult = findViewById(R.id.increase_adult);

        iv_booked_passenger_departure=findViewById(R.id.iv_booked_passenger_departure);
        iv_booked_passenger_departure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(PassengerDeparture.this,MyBookActivity.class);
                startActivity(intent);
            }
        });

        relative_back_flight_departure=findViewById(R.id.relative_back_flight_departure);
        relative_back_flight_departure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //   txtadult=findViewById(R.id.txtview_adult);

        priceFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PassengerDeparture.this, SeatSelection.class));
                // startActivity(new Intent(PassengerDeparture.this,Seat));
            }
        });

//        imgincreaseadult.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//           counter=counter+1;
//           display(counter);


//


        // });
//        imgdecreaseadult.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                counter =counter - 1;
//                display(counter);
//            }

//            private void display(int counter) {
//                TextView displayInteger =  findViewById(
//                        R.id.txtview_adult);
//                displayInteger.setText("" + counter +"KG");
//
//            }
//        });


    }


    private void display(int counter , TextView  view) {

        view.setText("" + counter +"KG");

    }

    @OnClick({R.id.decrease_adult, R.id.increase_adult, R.id.decrease_child, R.id.increase_child, R.id.decrease_infant, R.id.increase_infant, R.id.decrease_adult2, R.id.increase_adult2, R.id.decrease_child2, R.id.increase_child2, R.id.decrease_infant2, R.id.increase_infant2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.decrease_adult:
                counter =counter - 1;
               display(counter , tvAdultBg);
                break;
            case R.id.increase_adult:

                counter=counter+1;
           display(counter ,tvAdultBg);

                break;
            case R.id.decrease_child:

                counter2 =counter2 - 1;
                display(counter2 , tvChildBg);

                break;
            case R.id.increase_child:

                counter2 =counter2  + 1;
                display(counter2 , tvChildBg);

                break;
            case R.id.decrease_infant:

                counter3 =counter3  - 1;
                display(counter3 , tvInfantBg);



                break;
            case R.id.increase_infant:

                counter3 =counter3  + 1;
                display(counter3, tvInfantBg);

                break;
            case R.id.decrease_adult2:

                counter4 =counter4 - 1;
                display(counter4 , tvAdultBg2);

                break;
            case R.id.increase_adult2:
                counter4 =counter4 + 1;
                display(counter4 , tvAdultBg2);

                break;
            case R.id.decrease_child2:

                counter5 =counter5 - 1;
                display(counter5 , tvChildBg2);

                break;
            case R.id.increase_child2:


                counter5 =counter5 + 1;
                display(counter5 , tvChildBg2);
                break;
            case R.id.decrease_infant2:


                counter6 =counter6- 1;
                display(counter6 , tvInfantBg2);

                break;
            case R.id.increase_infant2:


                counter6 =counter6 +1;
                display(counter6 , tvInfantBg2);
                break;
        }
    }
}




