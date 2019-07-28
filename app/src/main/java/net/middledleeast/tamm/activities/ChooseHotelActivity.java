package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    @BindView(R.id.assistant_label_voice_choose_hotel)
    TextView assistantLabelVoiceChooseHotel;
    @BindView(R.id.assistant_label_call_choose_hotel)
    TextView assistantLabelCallChooseHotel;
    @BindView(R.id.assistant_label_message_choose_hotel)
    TextView assistantLabelMessageChooseHotel;
    @BindView(R.id.relative_img_choose_hotel_tamm)
    RelativeLayout relativeImgChooseHotelTamm;
    private RecyclerView reInfoHotels;
    private ArrayList<String> hotelName;
    private ArrayList<String> hotelAddress;
    private ArrayList<Integer> hotelrat;
    private ArrayList<String> hotelphoto;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_hotel);
        ButterKnife.bind(this);

        reInfoHotels = findViewById(R.id.hotels_rv);
        resultIndex = new ArrayList<>();

        imageView = findViewById(R.id.toolbar_back1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseHotelActivity.this, FindHotels.class));
            }
        });


        list_price = (ArrayList<String>) getIntent().getSerializableExtra("list_price");

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
        String sessionId = getIntent().getStringExtra("sessionId");
        resultIndex = (ArrayList<Integer>) getIntent().getSerializableExtra("resultIndex");
        session_id = SharedPreferencesManger.LoadStringData(this, "session_id");
        reInfoHotels.setLayoutManager(new LinearLayoutManager(this));
        adapterHotelInfo = new AdapterHotelInfo(ChooseHotelActivity.this, hotelName, hotelrat, hotelphoto, this, onHotelListener, hotelAddress, hotelCode, session_id,
                mstartTime, mendTime, countryName, cityName, cityId, noOfRooms, roomGuests, resultIndex, list_price);
        reInfoHotels.setAdapter(adapterHotelInfo);
        adapterHotelInfo.notifyDataSetChanged();


    }


    @Override
    public void onHotelClick(int position) {


    }


    @OnClick(R.id.relative_img_choose_hotel_tamm)
    public void onViewClicked() {

        if (ClickChooseHotel == false) {
            assistantLabelCallChooseHotel.setVisibility(View.VISIBLE);
            assistantLabelMessageChooseHotel.setVisibility(View.VISIBLE);
            assistantLabelVoiceChooseHotel.setVisibility(View.VISIBLE);
            ClickChooseHotel = true;

        } else {
            assistantLabelMessageChooseHotel.setVisibility(View.INVISIBLE);
            assistantLabelCallChooseHotel.setVisibility(View.INVISIBLE);
            assistantLabelVoiceChooseHotel.setVisibility(View.INVISIBLE);
            ClickChooseHotel = false;

        }
    }



    @OnClick({R.id.assistant_label_voice_choose_hotel, R.id.assistant_label_call_choose_hotel, R.id.assistant_label_message_choose_hotel, R.id.relative_img_choose_hotel_tamm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.assistant_label_voice_choose_hotel:
                Toast.makeText(this, "Voice", Toast.LENGTH_SHORT).show();

                break;
            case R.id.assistant_label_call_choose_hotel:
                Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show();

                break;
            case R.id.assistant_label_message_choose_hotel:

                Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show();

                break;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ChooseHotelActivity.this, FindHotels.class));

    }
}
