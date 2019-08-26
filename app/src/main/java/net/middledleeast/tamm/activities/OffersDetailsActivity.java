package net.middledleeast.tamm.activities;

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

public class OffersDetailsActivity extends AppCompatActivity {

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
    @BindView(R.id.hotel_image_detail_offer)
    ViewPager hotelImageDetailOffer;
    @BindView(R.id.view_pager_details_offer)
    RelativeLayout viewPagerDetailsOffer;
    @BindView(R.id.SliderDots_offer)
    LinearLayout SliderDotsOffer;
    @BindView(R.id.hotel_name_detail_offer)
    TextView hotelNameDetailOffer;
    @BindView(R.id.hotel_desc_detail_offer)
    TextView hotelDescDetailOffer;
    @BindView(R.id.hotel_detils_rat_offer)
    TextView hotelDetilsRatOffer;
    @BindView(R.id.hotel_rat_offer)
    TextView hotelRatOffer;
    @BindView(R.id.layout_rat_offer)
    LinearLayout layoutRatOffer;
    @BindView(R.id.btn_map_offer)
    Button btnMapOffer;
    @BindView(R.id.btn_next_offer)
    Button btnNextOffer;
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

    private List<String> listOfPhoto = new ArrayList<>();


    private int dotscount;
    private ImageView[] dots;
    private AdapterOfferPhoto adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers_details);
        ButterKnife.bind(this);


        final String offerName_ = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "offerName_");
        final String country_ = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "country_");
        final String hotelName_ = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "hotelName_");
        final String breakfast = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "breakfast");
        final String dinner = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "dinner");
        final String lunch = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "lunch");
        final String fromairport = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "fromairport");
        final String fromhotel = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "fromhotel");
        final String day = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "day");
        final String month = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "month");
        final String year = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "year");
        final String dd = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "dd");
        final String mm = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "mm");
        final String yy = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "yy");
        final String offerdesc = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "offerdesc");
        final String image = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "image");
        final String price = SharedPreferencesManger.LoadStringData(OffersDetailsActivity.this, "price");



        listOfPhoto.add(image);


        adapter = new AdapterOfferPhoto(OffersDetailsActivity.this, listOfPhoto);
        hotelImageDetailOffer.setAdapter(adapter);


        dotscount = adapter.getCount();
        dots = new ImageView[dotscount];


        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            SliderDotsOffer.addView(dots[i], params);

        }

        try {
            dots[0].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dot));
        } catch (Exception e) {


        }


        hotelImageDetailOffer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

    @OnClick({R.id.btn_map_offer, R.id.btn_next_offer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_map_offer:
                break;
            case R.id.btn_next_offer:
                break;
        }
    }
}