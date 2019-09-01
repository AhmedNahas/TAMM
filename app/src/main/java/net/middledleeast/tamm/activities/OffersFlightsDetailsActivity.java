package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.AdapterOfferPhoto;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OffersFlightsDetailsActivity extends AppCompatActivity {


    @BindView(R.id.toolbar_back2_offer)
    ImageView toolbarBack2Offer;
    @BindView(R.id.back_pressed_txt_offer)
    TextView backPressedTxtOffer;
    @BindView(R.id.toolbar_back1_offer)
    RelativeLayout toolbarBack1Offer;
    @BindView(R.id.relative_offer_detail)
    RelativeLayout relativeOfferDetail;
    @BindView(R.id.img_linee_offer)
    ImageView imgLineeOffer;
    @BindView(R.id.flight_image_detail_offer)
    ViewPager flightImageDetailOffer;
    @BindView(R.id.view_pager_details_offer_flight)
    RelativeLayout viewPagerDetailsOfferFlight;
    @BindView(R.id.flight_SliderDots_offer)
    LinearLayout flightSliderDotsOffer;
    @BindView(R.id.flight_name_detail_offer)
    TextView flightNameDetailOffer;
    @BindView(R.id.tv_from_flight)
    TextView tvFromFlight;
    @BindView(R.id.tv_from_airport_flight)
    TextView tvFromAirportFlight;
    @BindView(R.id.tv_to_flight)
    TextView tvToFlight;
    @BindView(R.id.tv_to_airport_flight)
    TextView tvToAirportFlight;
    @BindView(R.id.relative_flight)
    RelativeLayout relativeFlight;
    @BindView(R.id.tv_takeoff_date_flight)
    TextView tvTakeoffDateFlight;
    @BindView(R.id.tv_takeoff_flight)
    TextView tvTakeoffFlight;
    @BindView(R.id.relative_takeoff_flight)
    RelativeLayout relativeTakeoffFlight;
    @BindView(R.id.tv_landing_date_flight)
    TextView tvLandingDateFlight;
    @BindView(R.id.tv_land_date)
    TextView tvLandDate;
    @BindView(R.id.relative_landing_date_best_flight)
    RelativeLayout relativeLandingDateBestFlight;
    @BindView(R.id.flight_price_offer)
    TextView flightPriceOffer;
    @BindView(R.id.btn_map_offer)
    Button btnMapOffer;
    @BindView(R.id.relative_map_next_offer)
    RelativeLayout relativeMapNextOffer;
    @BindView(R.id.assistant_label_voice_details_offer)
    TextView assistantLabelVoiceDetailsOffer;
    @BindView(R.id.assistant_label_call_details_offer)
    TextView assistantLabelCallDetailsOffer;
    @BindView(R.id.assistant_label_message_details_offer)
    TextView assistantLabelMessageDetailsOffer;
    @BindView(R.id.relative_img_offer_details_tamm_offer)
    RelativeLayout relativeImgOfferDetailsTammOffer;
    @BindView(R.id.tv_tab_me_details_offer)
    TextView tvTabMeDetailsOffer;

    ImageView iv_booked_offer_flight;
    private List<String> listairPlane = new ArrayList<>();
    List<String> listfromairport = new ArrayList<>();
    List<String> listtoairport = new ArrayList<>();
    List<String> listflightprice = new ArrayList<>();


    private int dotscount;
    private ImageView[] dots;
    private AdapterOfferPhoto adapter;
    private String airplane;
    private String from_airport;
    private String to_airport;
    private String price;
    private String landing;
    private String takeoff;
    private List<String> listtakeoff = new ArrayList<>();
    private List<String> listlanding = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers_flights_details);
        ButterKnife.bind(this);

        iv_booked_offer_flight=findViewById(R.id.iv_booked_offer_flight);
        iv_booked_offer_flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(OffersFlightsDetailsActivity.this,MyBookActivity.class);
                startActivity(intent);
            }
        });

        airplane = SharedPreferencesManger.LoadStringData(OffersFlightsDetailsActivity.this, "airplane");
        from_airport = SharedPreferencesManger.LoadStringData(OffersFlightsDetailsActivity.this, "from_airport");
        to_airport = SharedPreferencesManger.LoadStringData(OffersFlightsDetailsActivity.this, "to_airport");
        price = SharedPreferencesManger.LoadStringData(OffersFlightsDetailsActivity.this, "price");
        landing = SharedPreferencesManger.LoadStringData(OffersFlightsDetailsActivity.this, "landing");
        takeoff = SharedPreferencesManger.LoadStringData(OffersFlightsDetailsActivity.this, "takeoff");


        listairPlane.add(airplane);
        listfromairport.add(from_airport);
        listtoairport.add(to_airport);
        listflightprice.add(price);
        listlanding.add(landing);
        listtakeoff.add(takeoff);


        flightNameDetailOffer.setText(airplane);
        tvFromAirportFlight.setText(from_airport);
        tvToAirportFlight.setText(to_airport);
        tvTakeoffFlight.setText(takeoff);
        tvLandDate.setText(landing);
        flightPriceOffer.setText(price);

        adapter = new AdapterOfferPhoto(OffersFlightsDetailsActivity.this, listairPlane);
        flightImageDetailOffer.setAdapter(adapter);


        dotscount = adapter.getCount();
        dots = new ImageView[dotscount];


        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            flightSliderDotsOffer.addView(dots[i], params);

        }

        try {
            dots[0].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dot));
        } catch (Exception e) {


        }


        flightImageDetailOffer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });


    }

    @OnClick({R.id.btn_map_offer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_map_offer:

// TODO: 8/31/2019 intent to paymentActivity //// Nahas
                Intent intent = new Intent(OffersFlightsDetailsActivity.this, HotelBooking.class);

                int id = 7;
                intent.putExtra("mId", id);

                SharedPreferencesManger.SaveData(this, "priceflight", price);
                startActivity(intent);

                break;

        }

    }
}
