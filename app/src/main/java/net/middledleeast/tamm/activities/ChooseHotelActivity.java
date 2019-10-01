package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.AdapterHotelInfo;
import net.middledleeast.tamm.adapters.HotelsActivityAdapter;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseHotelActivity extends AppCompatActivity implements HotelsActivityAdapter.onHotelListener {

    AdapterHotelInfo adapterHotelInfo;
//    @BindView(R.id.assistant_label_voice_choose_hotel)
//    TextView assistantLabelVoiceChooseHotel;
//    @BindView(R.id.assistant_label_call_choose_hotel)
//    TextView assistantLabelCallChooseHotel;
////    @BindView(R.id.assistant_label_message_choose_hotel)
//    TextView assistantLabelMessageChooseHotel;
    @BindView(R.id.relative_img_choose_hotel_tamm)
    RelativeLayout relativeImgChooseHotelTamm;
    @BindView(R.id.rating_bar)
    RatingBar ratingBar;
    @BindView(R.id.search_hotel_name)
    EditText searchHotelName;
    private RecyclerView reInfoHotels;
    private ArrayList<String> hotelName;
    private ArrayList<String> hotelAddress;
    private ArrayList<Integer> hotelrat;
    private ArrayList<String> hotelphoto;
    ArrayList<String> nameTemp;
    private AdapterHotelInfo.onHotelListener onHotelListener;
    private ArrayList<String> hotelCode;
    private String mendTime;
    private String mstartTime;
    private String countryName;
    private String cityName;
    private String cityId;
    private int noOfRooms;
    private ArrayList<String> roomGuests;
    private ArrayList<Integer> resultIndex;
    List<Integer> childCont = new ArrayList<>();
    RelativeLayout imageView;
    private String session_id;
    private ArrayList<String> list_price;
    private boolean ClickChooseHotel = false;
    private ArrayList<Integer> list;
    ImageView iv_booked_choose_hotel;
    private Integer accountPlan;
    private ArrayList<String> hotelTripAdvisorURL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_hotel);
        ButterKnife.bind(this);

        reInfoHotels = findViewById(R.id.hotels_rv);
        resultIndex = new ArrayList<>();
        iv_booked_choose_hotel=findViewById(R.id.iv_booked_choose_hotel);

        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(0xFFBE973B, PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(0).setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);



        iv_booked_choose_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChooseHotelActivity.this,MyBookActivity.class);
                startActivity(intent);
            }
        });

        imageView = findViewById(R.id.toolbar_back1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseHotelActivity.this, FindHotels.class));
            }
        });


        accountPlan = SharedPreferencesManger.LoadIntegerData(this, "accountPlan");
        try {
            if (accountPlan == 1) {


                iv_booked_choose_hotel.setVisibility(View.VISIBLE);

            } else if (accountPlan == 0) {

                iv_booked_choose_hotel.setVisibility(View.VISIBLE);

            } else if (accountPlan == 2) {
                iv_booked_choose_hotel.setVisibility(View.GONE);

            }
        }catch (Exception e){}

        searchHotelName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.toString().contains("")){
                    adapterHotelInfo.notifyDataSetChanged();
                }else{
                    searchItem(charSequence.toString());
                }

            }
            @Override
            public void afterTextChanged(Editable editable) {

                nameTemp = new ArrayList<>();



                for (int y = 0; y < hotelName.size(); y++) {
                    if (hotelName.get(y).contains(searchHotelName.getText().toString())) {

                        nameTemp.add(hotelName.get(y));

                        adapterHotelInfo = new AdapterHotelInfo(ChooseHotelActivity.this, nameTemp, hotelrat, hotelphoto, ChooseHotelActivity.this, onHotelListener, hotelAddress, hotelCode, session_id,
                                mstartTime, mendTime, countryName, cityName, cityId, noOfRooms, roomGuests, resultIndex, list_price,hotelTripAdvisorURL);
                        reInfoHotels.setAdapter(adapterHotelInfo);
                        adapterHotelInfo.notifyDataSetChanged();

                    }else {


                    }


                }

            }
        });



        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                ArrayList<String> hotelNameTemp = new ArrayList<>();
                ArrayList<String> advisorURLTemp = new ArrayList<>();
                ArrayList<Integer> hotelRateTemp = new ArrayList<>();
                ArrayList<String> hotelPhotoTemp = new ArrayList<>();
                ArrayList<String> hotelAddressTemp = new ArrayList<>();
                ArrayList<String> hotelCodeTemp = new ArrayList<>();
                ArrayList<Integer> resultIndexTemp = new ArrayList<>();
                ArrayList<String> hotelPriceTemp = new ArrayList<>();


                for (int i = 0; i < hotelrat.size(); i++) {
                    if (hotelrat.get(i) == (int) v) {
                        hotelNameTemp.add(hotelName.get(i));
                        advisorURLTemp.add(hotelTripAdvisorURL.get(i));
                        hotelRateTemp.add(hotelrat.get(i));
                        hotelPhotoTemp.add(hotelphoto.get(i));
                        hotelAddressTemp.add(hotelAddress.get(i));
                        hotelCodeTemp.add(hotelCode.get(i));
                        resultIndexTemp.add(resultIndex.get(i));
                        hotelPriceTemp.add(list_price.get(i));
                        adapterHotelInfo = new AdapterHotelInfo(ChooseHotelActivity.this,
                                hotelNameTemp,
                                hotelRateTemp,
                                hotelPhotoTemp,
                                ChooseHotelActivity.this,
                                onHotelListener,
                                hotelAddressTemp,
                                hotelCodeTemp,
                                session_id,
                                mstartTime,
                                mendTime,
                                countryName,
                                cityName,
                                cityId,
                                noOfRooms,
                                roomGuests,
                                resultIndexTemp,
                                hotelPriceTemp,
                                hotelTripAdvisorURL);


                        reInfoHotels.setAdapter(adapterHotelInfo);
                        adapterHotelInfo.notifyDataSetChanged();
                    }

                }


//
//
//        }else if (v==(int)2){
//
//            Collections.sort(hotelrat, new Comparator<Integer>() {
//                @Override
//                public int compare(Integer integer, Integer t1) {
//
//
//                    return t1.compareTo((int) v);
//                }
//            });
//            adapterHotelInfo.notifyDataSetChanged();
//
//        }else if (v==(int)3){
//
//            Collections.sort(hotelrat, new Comparator<Integer>() {
//                @Override
//                public int compare(Integer integer, Integer t1) {
//
//
//                    return t1.compareTo((int) v);
//                }
//            });
//            adapterHotelInfo.notifyDataSetChanged();
//
//        }else if (v==(int)4){
//
//            Collections.sort(hotelrat, new Comparator<Integer>() {
//                @Override
//                public int compare(Integer integer, Integer t1) {
//
//
//                    return t1.compareTo((int) v);
//                }
//            });
//            adapterHotelInfo.notifyDataSetChanged();
//
//        }else if (v==(int)5){
//
//            Collections.sort(hotelrat, new Comparator<Integer>() {
//                @Override
//                public int compare(Integer integer, Integer t1) {
//
//
//                    return t1.compareTo((int) v);
//                }
//            });
//            adapterHotelInfo.notifyDataSetChanged();
//

            }
        });


        list_price = (ArrayList<String>) getIntent().getSerializableExtra("list_price");
        hotelTripAdvisorURL = (ArrayList<String>) getIntent().getSerializableExtra("hotelTripAdvisorURL");

        hotelAddress = (ArrayList<String>) getIntent().getSerializableExtra("hotelAddress");
        hotelName = (ArrayList<String>) getIntent().getSerializableExtra("hotelName");
        hotelrat = (ArrayList<Integer>) getIntent().getSerializableExtra("hotelrat");
        hotelphoto = (ArrayList<String>) getIntent().getSerializableExtra("hotelPhoto");
        hotelCode = (ArrayList<String>) getIntent().getSerializableExtra("hotelCode");
        mstartTime = getIntent().getStringExtra("checkInDate");
        mendTime = getIntent().getStringExtra("checkOutDate");
        countryName = getIntent().getStringExtra("countryName");
        cityName = getIntent().getStringExtra("cityName");
        cityId = getIntent().getStringExtra("cityId");
        noOfRooms = getIntent().getIntExtra("noOfRooms", 1);
        roomGuests = getIntent().getStringArrayListExtra("roomGuest");
       // String sessionId = getIntent().getStringExtra("sessionId");
        resultIndex = (ArrayList<Integer>) getIntent().getSerializableExtra("resultIndex");
        session_id = SharedPreferencesManger.LoadStringData(this, "session_id");
        reInfoHotels.setLayoutManager(new LinearLayoutManager(this));
        adapterHotelInfo = new AdapterHotelInfo(ChooseHotelActivity.this, hotelName, hotelrat, hotelphoto, this, onHotelListener, hotelAddress, hotelCode, session_id,
                mstartTime, mendTime, countryName, cityName, cityId, noOfRooms, roomGuests, resultIndex, list_price,hotelTripAdvisorURL);
        reInfoHotels.setAdapter(adapterHotelInfo);
        adapterHotelInfo.notifyDataSetChanged();


    }

    private void searchItem(String toString) {

        for (String item : hotelName){
            if (!item.contains(toString)){
                nameTemp.remove(item);

            }
        }

        adapterHotelInfo.notifyDataSetChanged();
    }


    @Override
    public void onHotelClick(int position) {


    }


    @OnClick(R.id.relative_img_choose_hotel_tamm)
    public void onViewClicked() {

        Intent intent =new Intent(ChooseHotelActivity.this,AssistantActivity.class);
        startActivity(intent);

//        if (ClickChooseHotel == false) {
//            assistantLabelCallChooseHotel.setVisibility(View.VISIBLE);
//            assistantLabelMessageChooseHotel.setVisibility(View.VISIBLE);
//            assistantLabelVoiceChooseHotel.setVisibility(View.VISIBLE);
//            ClickChooseHotel = true;
//
//        } else {
//            assistantLabelMessageChooseHotel.setVisibility(View.INVISIBLE);
//            assistantLabelCallChooseHotel.setVisibility(View.INVISIBLE);
//            assistantLabelVoiceChooseHotel.setVisibility(View.INVISIBLE);
//            ClickChooseHotel = false;
//
//        }
    }


//    @OnClick({R.id.assistant_label_voice_choose_hotel, R.id.assistant_label_call_choose_hotel, R.id.assistant_label_message_choose_hotel, R.id.relative_img_choose_hotel_tamm})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.assistant_label_voice_choose_hotel:
//                Intent intent = new Intent(ChooseHotelActivity.this, VoiceMessageActivity.class);
//                startActivity(intent);
//
//                Toast.makeText(this, "Voice", Toast.LENGTH_SHORT).show();
//
//                break;
//            case R.id.assistant_label_call_choose_hotel:
//                Intent intent1 = new Intent(ChooseHotelActivity.this, AssistantActivity.class);
//                startActivity(intent1);
//
//                Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show();
//
//                break;
//            case R.id.assistant_label_message_choose_hotel:
//                Intent intent2 = new Intent(ChooseHotelActivity.this, ContactUs.class);
//                startActivity(intent2);
//
//                Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show();
//
//                break;
//
//        }
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        startActivity(new Intent(ChooseHotelActivity.this, FindHotels.class));

    }

}
