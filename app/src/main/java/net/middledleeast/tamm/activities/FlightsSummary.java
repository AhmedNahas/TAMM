package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlightsSummary extends AppCompatActivity {

    Button proccedBtn;
    @BindView(R.id.toolbar_back1)
    ImageView toolbarBack1;
    @BindView(R.id.toolbar_back)
    RelativeLayout toolbarBack;
    @BindView(R.id.line1)
    View line1;
    @BindView(R.id.tv_price_summary)
    TextView tvPriceSummary;
    @BindView(R.id.line2)
    View line2;
    @BindView(R.id.tv_bey)
    TextView tvBey;
    @BindView(R.id.tv_to)
    TextView tvTo;
    @BindView(R.id.tv_dxb)
    TextView tvDxb;
    @BindView(R.id.tv_country)
    TextView tvCountry;
    @BindView(R.id.tv_ccountry)
    TextView tvCcountry;
    @BindView(R.id.relative_country)
    RelativeLayout relativeCountry;
    @BindView(R.id.tv_flight)
    TextView tvFlight;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.tv_airline)
    TextView tvAirline;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.relative_airline)
    RelativeLayout relativeAirline;
    @BindView(R.id.iv_bag)
    ImageView ivBag;
    @BindView(R.id.tv_kg)
    TextView tvKg;
    @BindView(R.id.iv_bag2)
    ImageView ivBag2;
    @BindView(R.id.relative_package)
    RelativeLayout relativePackage;
    @BindView(R.id.tv_cabin_class)
    TextView tvCabinClass;
    @BindView(R.id.tv_departure)
    TextView tvDeparture;
    @BindView(R.id.tv_date_departure)
    TextView tvDateDeparture;
    @BindView(R.id.tv_arrival)
    TextView tvArrival;
    @BindView(R.id.date_arrival)
    TextView dateArrival;
    @BindView(R.id.tv_bey2)
    TextView tvBey2;
    @BindView(R.id.tv_to2)
    TextView tvTo2;
    @BindView(R.id.tv_dxb2)
    TextView tvDxb2;
    @BindView(R.id.tv_country2)
    TextView tvCountry2;
    @BindView(R.id.tv_ccountry2)
    TextView tvCcountry2;
    @BindView(R.id.relative_country2)
    RelativeLayout relativeCountry2;
    @BindView(R.id.tv_flight2)
    TextView tvFlight2;
    @BindView(R.id.iv_icon2)
    ImageView ivIcon2;
    @BindView(R.id.tv_airline2)
    TextView tvAirline2;
    @BindView(R.id.tv_time2)
    TextView tvTime2;
    @BindView(R.id.relative_airline2)
    RelativeLayout relativeAirline2;
    @BindView(R.id.iv_bag21)
    ImageView ivBag21;
    @BindView(R.id.tv_kg2)
    TextView tvKg2;
    @BindView(R.id.iv_bag22)
    ImageView ivBag22;
    @BindView(R.id.relative_package2)
    RelativeLayout relativePackage2;
    @BindView(R.id.tv_cabin_class2)
    TextView tvCabinClass2;
    @BindView(R.id.tv_departure2)
    TextView tvDeparture2;
    @BindView(R.id.tv_date_departure2)
    TextView tvDateDeparture2;
    @BindView(R.id.tv_arrival2)
    TextView tvArrival2;
    @BindView(R.id.date_arrival2)
    TextView dateArrival2;
    @BindView(R.id.relalala)
    RelativeLayout relalala;
    @BindView(R.id.closure)
    RelativeLayout closure;
    @BindView(R.id.relative_all)
    RelativeLayout relativeAll;
    @BindView(R.id.iv_man_hand)
    ImageView ivManHand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flights_summary);
        ButterKnife.bind(this);

        proccedBtn = findViewById(R.id.procced_btn);

        proccedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FlightsSummary.this, PassengerDeparture.class));
            }
        });


        String a_totalFare = SharedPreferencesManger.LoadStringData(this, "A_TotalFare");
        String a_typeFare = SharedPreferencesManger.LoadStringData(this, "A_typeFare");

        String a_airlin_name = SharedPreferencesManger.LoadStringData(this, "A_airlin_name");
        String a_duration = SharedPreferencesManger.LoadStringData(this, "A_duration");

        //
        String a_cabinBaggage = SharedPreferencesManger.LoadStringData(this, "A_CabinBaggage");
        String a_includedBaggage = SharedPreferencesManger.LoadStringData(this, "A_IncludedBaggage");

        String a_deTime = SharedPreferencesManger.LoadStringData(this, "A_deTime");
        String a_arrTime = SharedPreferencesManger.LoadStringData(this, "A_arrTime");

        String a_destination = SharedPreferencesManger.LoadStringData(this, "A_destination");
        String a_origin = SharedPreferencesManger.LoadStringData(this, "A_origin");

        String distnation = SharedPreferencesManger.LoadStringData(this, "Distnation");
        String origin = SharedPreferencesManger.LoadStringData(this, "Origin");


        String flightNumber = SharedPreferencesManger.LoadStringData(this, "flightNumber");


        if (a_airlin_name ==null){
            tvAirline.setText("Not Available right now");


        }else {

            tvAirline.setText(a_airlin_name);
        }




        tvFlight.setText("Flight Nb :"+flightNumber);
        // name
        tvCcountry.setText(a_origin);
        tvCountry.setText(a_destination);

        // code
        tvBey.setText(origin);
        tvDxb.setText(distnation);


    }
}
