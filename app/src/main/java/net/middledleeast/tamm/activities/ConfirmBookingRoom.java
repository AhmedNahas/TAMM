package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.Tamm.Hotels.wcf.ArrayOfGuest;
import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.Hotel_Room;
import com.google.gson.Gson;
import com.wirecard.ecom.Client;
import com.wirecard.ecom.model.out.PaymentResponse;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import payments.PaymentObjectProvider;
import payments.ResponseHelper;

public class ConfirmBookingRoom extends AppCompatActivity {

    @BindView(R.id.relative_firstlast)
    RelativeLayout relativeFirstlast;
    @BindView(R.id.relative_firstlast2)
    RelativeLayout relativeFirstlast2;
    @BindView(R.id.relative_firstlast3)
    RelativeLayout relativeFirstlast3;
    @BindView(R.id.mromiss4)
    Spinner mromiss4;
    @BindView(R.id.relative_firstlast4)
    RelativeLayout relativeFirstlast4;
    @BindView(R.id.relative_firstlast5)
    RelativeLayout relativeFirstlast5;
    @BindView(R.id.mromiss6)
    Spinner mromiss6;
    @BindView(R.id.relative_firstlast6)
    RelativeLayout relativeFirstlast6;
    @BindView(R.id.specification)
    EditText specification;
    @BindView(R.id.assistant_label_voice_confirm_hotel)
    TextView assistantLabelVoiceConfirmHotel;
    @BindView(R.id.assistant_label_call_confirm_hotel)
    TextView assistantLabelCallConfirmHotel;
    @BindView(R.id.assistant_label_message_confirm_hotel)
    TextView assistantLabelMessageConfirmHotel;
    @BindView(R.id.relative_img_confirm_hotel_tamm)
    RelativeLayout relativeImgConfirmHotelTamm;
    @BindView(R.id.toolbar_back2)
    ImageView toolbarBack2;
    @BindView(R.id.back_pressed_txt)
    TextView backPressedTxt;
    @BindView(R.id.toolbar_back1)
    RelativeLayout toolbarBack1;
    @BindView(R.id.relative_booking)
    RelativeLayout relativeBooking;
    @BindView(R.id.img_linee)
    ImageView imgLinee;
    @BindView(R.id.tv_guest)
    TextView tvGuest;
    @BindView(R.id.tv_adult)
    TextView tvAdult;
    @BindView(R.id.img_linee2)
    ImageView imgLinee2;
    @BindView(R.id.mromiss1)
    Spinner mromiss1;
    @BindView(R.id.mromiss2)
    Spinner mromiss2;
    @BindView(R.id.mromiss3)
    Spinner mromiss3;
    @BindView(R.id.mromiss5)
    Spinner mromiss5;

    @BindView(R.id.relative_names_1)
    RelativeLayout relativeNames1;
    @BindView(R.id.mromiss1R_2)
    Spinner mromiss1R2;
    @BindView(R.id.relative_firstlastR_2)
    RelativeLayout relativeFirstlastR2;
    @BindView(R.id.mromiss2R_2)
    Spinner mromiss2R2;
    @BindView(R.id.relative_firstlast2R_2)
    RelativeLayout relativeFirstlast2R2;
    @BindView(R.id.mromiss3R_2)
    Spinner mromiss3R2;
    @BindView(R.id.relative_firstlast3R_2)
    RelativeLayout relativeFirstlast3R2;
    @BindView(R.id.mromiss4R_2)
    Spinner mromiss4R2;
    @BindView(R.id.relative_firstlast4R_2)
    RelativeLayout relativeFirstlast4R2;
    @BindView(R.id.mromiss5R_2)
    Spinner mromiss5R2;

    @BindView(R.id.relative_firstlast5R_2)
    RelativeLayout relativeFirstlast5R2;
    @BindView(R.id.mromiss6R_2)
    Spinner mromiss6R2;

    @BindView(R.id.relative_firstlast6R_2)
    RelativeLayout relativeFirstlast6R2;
    @BindView(R.id.relative_namesR_2)
    RelativeLayout relativeNamesR2;
    @BindView(R.id.mromiss1R_3)
    Spinner mromiss1R3;
    @BindView(R.id.relative_firstlastR_3)
    RelativeLayout relativeFirstlastR3;
    @BindView(R.id.mromiss2R_3)
    Spinner mromiss2R3;
    @BindView(R.id.relative_firstlast2R_3)
    RelativeLayout relativeFirstlast2R3;
    @BindView(R.id.mromiss3R_3)
    Spinner mromiss3R3;
    @BindView(R.id.relative_firstlast3R_3)
    RelativeLayout relativeFirstlast3R3;
    @BindView(R.id.mromiss4R_3)
    Spinner mromiss4R3;
    @BindView(R.id.relative_firstlast4R_3)
    RelativeLayout relativeFirstlast4R3;
    @BindView(R.id.mromiss5R_3)
    Spinner mromiss5R3;

    @BindView(R.id.relative_firstlast5R_3)
    RelativeLayout relativeFirstlast5R3;
    @BindView(R.id.mromiss6R_3)
    Spinner mromiss6R3;

    @BindView(R.id.relative_firstlast6R_3)
    RelativeLayout relativeFirstlast6R3;
    @BindView(R.id.relative_namesR_3)
    RelativeLayout relativeNamesR3;
    @BindView(R.id.mromiss1R_4)
    Spinner mromiss1R4;
    @BindView(R.id.relative_firstlastR_4)
    RelativeLayout relativeFirstlastR4;
    @BindView(R.id.mromiss2R_4)
    Spinner mromiss2R4;
    @BindView(R.id.relative_firstlast2R_4)
    RelativeLayout relativeFirstlast2R4;
    @BindView(R.id.mromiss3R_4)
    Spinner mromiss3R4;
    @BindView(R.id.relative_firstlast3R_4)
    RelativeLayout relativeFirstlast3R4;
    @BindView(R.id.mromiss4R_4)
    Spinner mromiss4R4;

    @BindView(R.id.relative_firstlast4R_4)
    RelativeLayout relativeFirstlast4R4;
    @BindView(R.id.mromiss5R_4)
    Spinner mromiss5R4;

    @BindView(R.id.relative_firstlast5R_4)
    RelativeLayout relativeFirstlast5R4;
    @BindView(R.id.mromiss6R_4)
    Spinner mromiss6R4;

    @BindView(R.id.relative_firstlast6R_4)
    RelativeLayout relativeFirstlast6R4;
    @BindView(R.id.relative_namesR_4)
    RelativeLayout relativeNamesR4;
    @BindView(R.id.names_layout)
    ScrollView namesLayout;
    @BindView(R.id.tv_request)
    TextView tvRequest;
    @BindView(R.id.tv_tab_me_confirm_hotels)
    TextView tvTabMeConfirmHotels;
    @BindView(R.id.first_name_1_gust_one)
    EditText firstName1GustOne;
    @BindView(R.id.lastName_1_gust_one)
    EditText lastName1GustOne;
    @BindView(R.id.first_name_2_gust_one)
    EditText firstName2GustOne;
    @BindView(R.id.last_name_2_gust_one)
    EditText lastName2GustOne;
    @BindView(R.id.first_name_3_gust_one)
    EditText firstName3GustOne;
    @BindView(R.id.last_name_3_gust_one)
    EditText lastName3GustOne;
    @BindView(R.id.first_name_4_gust_one)
    EditText firstName4GustOne;
    @BindView(R.id.last_name_4_gust_one)
    EditText lastName4GustOne;
    @BindView(R.id.first_name_1_child_gust_one)
    EditText firstName1ChildGustOne;
    @BindView(R.id.last_name_1_child_gust_one)
    EditText lastName1ChildGustOne;
    @BindView(R.id.first_name_2_child_gust_one)
    EditText firstName2ChildGustOne;
    @BindView(R.id.last_name_2_child_gust_one)
    EditText lastName2ChildGustOne;
    @BindView(R.id.first_name_1_gust_2)
    EditText firstName1Gust2;
    @BindView(R.id.last_name_1_gust_2)
    EditText lastName1Gust2;
    @BindView(R.id.first_name_2_gust_2)
    EditText firstName2Gust2;
    @BindView(R.id.last_name_2_gust_2)
    EditText lastName2Gust2;
    @BindView(R.id.first_name_3_gust_2)
    EditText firstName3Gust2;
    @BindView(R.id.last_name_3_gust_2)
    EditText lastName3Gust2;
    @BindView(R.id.first_name_4_gust_2)
    EditText firstName4Gust2;
    @BindView(R.id.last_name_4_gust_2)
    EditText lastName4Gust2;
    @BindView(R.id.first_name_1_child_gust_2)
    EditText firstName1ChildGust2;
    @BindView(R.id.last_name_1_child_gust_2)
    EditText lastName1ChildGust2;
    @BindView(R.id.first_name_2_child_gust_2)
    EditText firstName2ChildGust2;
    @BindView(R.id.last_name_2_child_gust_2)
    EditText lastName2ChildGust2;
    @BindView(R.id.first_name_1_gust_3)
    EditText firstName1Gust3;
    @BindView(R.id.last_name_1_gust_3)
    EditText lastName1Gust3;
    @BindView(R.id.first_name_2_gust_3)
    EditText firstName2Gust3;
    @BindView(R.id.last_name_2_gust_3)
    EditText lastName2Gust3;
    @BindView(R.id.first_name_3_gust_3)
    EditText firstName3Gust3;
    @BindView(R.id.last_name_3_gust_3)
    EditText lastName3Gust3;
    @BindView(R.id.first_name_4_gust_3)
    EditText firstName4Gust3;
    @BindView(R.id.last_name_4_gust_3)
    EditText lastName4Gust3;
    @BindView(R.id.first_name_1_child_gust_3)
    EditText firstName1ChildGust3;
    @BindView(R.id.last_name_1_child_gust_3)
    EditText lastName1ChildGust3;
    @BindView(R.id.first_name_2_child_gust_3)
    EditText firstName2ChildGust3;
    @BindView(R.id.last_name_2_child_gust_3)
    EditText lastName2ChildGust3;
    @BindView(R.id.first_name_1_gust_4)
    EditText firstName1Gust4;
    @BindView(R.id.last_name_1_gust_4)
    EditText lastName1Gust4;
    @BindView(R.id.first_name_2_gust_4)
    EditText firstName2Gust4;
    @BindView(R.id.last_name_2_gust_4)
    EditText lastName2Gust4;
    @BindView(R.id.first_name_3_gust_4)
    EditText firstName3Gust4;
    @BindView(R.id.last_name_3_gust_4)
    EditText lastName3Gust4;
    @BindView(R.id.first_name_4_gust_4)
    EditText firstName4Gust4;
    @BindView(R.id.last_name_4_gust_4)
    EditText lastName4Gust4;
    @BindView(R.id.first_name_1_child_gust_4)
    EditText firstName1ChildGust4;
    @BindView(R.id.last_name_1_child_gust_4)
    EditText lastName1ChildGust4;
    @BindView(R.id.first_name_2_child_gust_4)
    EditText firstName2ChildGust4;
    @BindView(R.id.last_name_2_child_gust_4)
    EditText lastName2ChildGust4;
    private Button confirmRoom;
    private RelativeLayout back;
    ArrayOfGuest arrayOfGuest;
    private Hotel_Room hotel_room;
    private ArrayOfRequestedRooms arrayOfRooms;
    private DateTime date1;
    private DateTime date2;
    private int noOfRooms;
    private int resultIndex;
    private String mHOtelCode;
    private AuthenticationData authenticandata;
    private String sessionId;
    private List<Hotel_Room> rooms;
    private BasicHttpBinding_IHotelService1 service;
    private int roomIndex;
    private String start_time;
    private String end_time;
    private String hotel_name;
    private String roomPrice;
    private String currency;
    private boolean ClickConfirmHotel = false;
    private int no_adultroom1, no_adultroom2, no_adultroom3, no_adultroom4;
    private int child_countroom4, child_countroom3, child_countroom2, child_countroom1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking_room);
        ButterKnife.bind(this);
        confirmRoom = findViewById(R.id.confirm_room_booking);
        Gson gson = new Gson();

        back = findViewById(R.id.toolbar_back1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfirmBookingRoom.this, checkroom.class));
            }
        });


        Intent intent = getIntent();
        service = new BasicHttpBinding_IHotelService1();
        service.enableLogging = true;
        authenticandata = new AuthenticationData();
        authenticandata.UserName = ("Tammtest");
        authenticandata.Password = ("Tam@18418756");
//        arrayOfRooms = (ArrayOfRequestedRooms) intent.getSerializableExtra("arrayOfRooms");
//        rooms = (List<Hotel_Room>) gson.fromJson(intent.getStringExtra("rooms"), List.class);
//        hotel_room(xxhdpi) = gson.fromJson(intent.getStringExtra("hotel_room(xxhdpi)"), Hotel_Room.class);
        sessionId = intent.getStringExtra("sessionId");
//        SharedPreferencesManger.SaveData(this, "sessionId", sessionId);
        noOfRooms = intent.getIntExtra("noOfRooms", 1);
//        SharedPreferencesManger.SaveData(this, "noOfRooms", noOfRooms);
        resultIndex = intent.getIntExtra("resultIndex", 1);
//        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");


        int noOfRooms = SharedPreferencesManger.LoadIntegerData(ConfirmBookingRoom.this, "noOfRooms");


        // 1 room
        if (noOfRooms == 1) {
            no_adultroom1 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom1");


            if (no_adultroom1 == 1) {

                String firstName1GustOne = this.firstName1GustOne.getText().toString();
                String lastName1GustOne = this.lastName1GustOne.getText().toString();


            } else if (no_adultroom1 == 2) {

                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlastR4.setVisibility(View.GONE);


                String firstName2GustOne = this.firstName2GustOne.getText().toString();
                String lastName2GustOne = this.lastName2GustOne.getText().toString();

            } else if (no_adultroom1 == 3) {
                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);
                relativeFirstlastR4.setVisibility(View.GONE);

                String firstName3GustOne = this.firstName3GustOne.getText().toString();
                String lastName3GustOne = this.lastName3GustOne.getText().toString();


            } else if (no_adultroom1 == 4) {
                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);
                relativeFirstlast4.setVisibility(View.VISIBLE);


                String firstName4GustOne = this.firstName4GustOne.getText().toString();
                String lastName4GustOne = this.lastName4GustOne.getText().toString();
            }
            child_countroom1 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom1");


            if (child_countroom1 == 1) {

                relativeFirstlast5.setVisibility(View.VISIBLE);

                String firstName1ChildGustOne = this.firstName1ChildGustOne.getText().toString();
                String lastName1ChildGustOne = this.lastName1ChildGustOne.getText().toString();

            } else if (child_countroom1 == 2) {
                relativeFirstlast5.setVisibility(View.VISIBLE);
                relativeFirstlast6.setVisibility(View.VISIBLE);

                String firstName2ChildGustOne = this.firstName2ChildGustOne.getText().toString();
                String lastName2ChildGustOne = this.lastName2ChildGustOne.getText().toString();

            }


            // 2 rooms
        } else if (noOfRooms == 2) {
            no_adultroom2 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom2");


            if (no_adultroom2 == 1) {
                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeFirstlastR2.setVisibility(View.VISIBLE);

                String firstName1Gust2 = this.firstName1Gust2.getText().toString();
                String lastName1Gust2 = this.lastName1Gust2.getText().toString();

            } else if (no_adultroom2 == 2) {
                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast2R2.setVisibility(View.VISIBLE);


                String firstName2Gust2 = this.firstName2Gust2.getText().toString();
                String lastName2Gust2 = this.lastName2Gust2.getText().toString();
            } else if (no_adultroom2 == 3) {

                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);
                relativeFirstlast2R2.setVisibility(View.VISIBLE);
                relativeFirstlast3R2.setVisibility(View.VISIBLE);

                String firstName3Gust2 = this.firstName3Gust2.getText().toString();
                String lastName3Gust2 = this.lastName3Gust2.getText().toString();
            } else if (no_adultroom2 == 4) {
                relativeNamesR2.setVisibility(View.VISIBLE);

                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);
                relativeFirstlast4.setVisibility(View.VISIBLE);
                relativeFirstlast2R2.setVisibility(View.VISIBLE);
                relativeFirstlast3R2.setVisibility(View.VISIBLE);
                relativeFirstlast4R2.setVisibility(View.VISIBLE);


                String firstName4Gust2 = this.firstName4Gust2.getText().toString();
                String lastName4Gust2 = this.lastName4Gust2.getText().toString();
            }


            child_countroom2 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom2");

            if (child_countroom2 == 1) {
                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeFirstlast5.setVisibility(View.VISIBLE);
                relativeFirstlast5R2.setVisibility(View.VISIBLE);

                String firstName1ChildGust2 = this.firstName1ChildGust2.getText().toString();
                String lastName1ChildGust2 = this.lastName1ChildGust2.getText().toString();
            } else if (child_countroom2 == 2) {

                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeFirstlast5.setVisibility(View.VISIBLE);
                relativeFirstlast6.setVisibility(View.VISIBLE);
                relativeFirstlast5R2.setVisibility(View.VISIBLE);
                relativeFirstlast6R2.setVisibility(View.VISIBLE);

                String firstName2ChildGust2 = this.firstName2ChildGust2.getText().toString();
                String lastName2ChildGust2 = this.lastName2ChildGust2.getText().toString();
            }


            // 3 rooms
        } else if (noOfRooms == 3) {

            no_adultroom3 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom3");


            if (no_adultroom3 == 1) {
                relativeFirstlastR2.setVisibility(View.VISIBLE);
                relativeNamesR3.setVisibility(View.VISIBLE);
                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeFirstlastR3.setVisibility(View.VISIBLE);


                String firstName1Gust3 = this.firstName1Gust3.getText().toString();
                String lastName1Gust3 = this.lastName1Gust3.getText().toString();


            } else if (no_adultroom3 == 2) {
                relativeNamesR3.setVisibility(View.VISIBLE);
                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast2R2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);
                relativeFirstlast2R3.setVisibility(View.VISIBLE);
                relativeFirstlastR4.setVisibility(View.GONE);


                String firstName2Gust3 = this.firstName2Gust3.getText().toString();
                String lastName2Gust3 = this.lastName2Gust3.getText().toString();


            } else if (no_adultroom3 == 3) {
                relativeFirstlastR4.setVisibility(View.GONE);

                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeNamesR3.setVisibility(View.VISIBLE);

                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);
                relativeFirstlast2R2.setVisibility(View.VISIBLE);
                relativeFirstlast3R2.setVisibility(View.VISIBLE);
                relativeFirstlastR3.setVisibility(View.VISIBLE);
                relativeFirstlast2R3.setVisibility(View.VISIBLE);
                relativeFirstlast3R3.setVisibility(View.VISIBLE);


                String firstName3Gust3 = this.firstName3Gust3.getText().toString();
                String lastName3Gust3 = this.lastName3Gust3.getText().toString();

            } else if (no_adultroom3 == 4) {
                relativeFirstlastR4.setVisibility(View.GONE);


                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeNamesR3.setVisibility(View.VISIBLE);

                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);
                relativeFirstlast4.setVisibility(View.VISIBLE);
                relativeFirstlastR2.setVisibility(View.VISIBLE);
                relativeFirstlast2R2.setVisibility(View.VISIBLE);
                relativeFirstlast3R2.setVisibility(View.VISIBLE);
                relativeFirstlast4R2.setVisibility(View.VISIBLE);

                relativeFirstlastR3.setVisibility(View.VISIBLE);

                relativeFirstlast2R3.setVisibility(View.VISIBLE);
                relativeFirstlast3R3.setVisibility(View.VISIBLE);
                relativeFirstlast4R3.setVisibility(View.VISIBLE);

                String firstName4Gust3 = this.firstName4Gust3.getText().toString();
                String lastName4Gust3 = this.lastName4Gust3.getText().toString();

            }


            child_countroom3 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom3");


            if (child_countroom3 == 1) {


                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeNamesR3.setVisibility(View.VISIBLE);

                relativeFirstlast5.setVisibility(View.VISIBLE);
                relativeFirstlast5R2.setVisibility(View.VISIBLE);
                relativeFirstlast5R3.setVisibility(View.VISIBLE);

                String firstName1ChildGust3 = this.firstName1ChildGust3.getText().toString();
                String lastName1ChildGust3 = this.lastName1ChildGust3.getText().toString();

            } else if (child_countroom3 == 2) {


                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeNamesR3.setVisibility(View.VISIBLE);
                relativeFirstlast5.setVisibility(View.VISIBLE);
                relativeFirstlast6.setVisibility(View.VISIBLE);
                relativeFirstlast5R2.setVisibility(View.VISIBLE);
                relativeFirstlast6R2.setVisibility(View.VISIBLE);
                relativeFirstlast5R3.setVisibility(View.VISIBLE);
                relativeFirstlast6R3.setVisibility(View.VISIBLE);


                String firstName2ChildGust3 = this.firstName2ChildGust3.getText().toString();
                String lastName2ChildGust3 = this.lastName2ChildGust3.getText().toString();


            }


            // 4 rooms
        } else if (noOfRooms == 4) {


            no_adultroom4 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom4");


            if (no_adultroom4 == 1) {

                relativeFirstlastR2.setVisibility(View.VISIBLE);
                relativeNamesR3.setVisibility(View.VISIBLE);
                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeNamesR4.setVisibility(View.VISIBLE);
                relativeFirstlastR3.setVisibility(View.VISIBLE);
                relativeFirstlastR4.setVisibility(View.VISIBLE);


                String firstName1Gust4 = this.firstName1Gust4.getText().toString();
                String lastName1Gust4 = this.lastName1Gust4.getText().toString();

            } else if (no_adultroom4 == 2) {
                relativeNamesR3.setVisibility(View.VISIBLE);
                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeNamesR4.setVisibility(View.VISIBLE);

                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast2R2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);
                relativeFirstlast2R3.setVisibility(View.VISIBLE);
                relativeFirstlast4R4.setVisibility(View.VISIBLE);
                relativeFirstlastR4.setVisibility(View.VISIBLE);

                String firstName2Gust4 = this.firstName2Gust4.getText().toString();
                String lastName2Gust4 = this.lastName2Gust4.getText().toString();

            } else if (no_adultroom4 == 3) {


                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeNamesR3.setVisibility(View.VISIBLE);
                relativeNamesR4.setVisibility(View.VISIBLE);


                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);
                relativeFirstlast4.setVisibility(View.VISIBLE);


                relativeFirstlast2R2.setVisibility(View.VISIBLE);
                relativeFirstlast3R2.setVisibility(View.VISIBLE);
                relativeFirstlast4R2.setVisibility(View.VISIBLE);


                relativeFirstlastR3.setVisibility(View.VISIBLE);
                relativeFirstlast2R3.setVisibility(View.VISIBLE);
                relativeFirstlast3R3.setVisibility(View.VISIBLE);

                relativeFirstlastR4.setVisibility(View.VISIBLE);
                relativeFirstlast2R4.setVisibility(View.VISIBLE);
                relativeFirstlast3R4.setVisibility(View.VISIBLE);


                String firstName3Gust4 = this.firstName3Gust4.getText().toString();
                String lastName3Gust4 = this.lastName3Gust4.getText().toString();


            } else if (no_adultroom4 == 4) {


                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeNamesR3.setVisibility(View.VISIBLE);
                relativeNamesR4.setVisibility(View.VISIBLE);


                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);
                relativeFirstlast4.setVisibility(View.VISIBLE);


                relativeFirstlast2R2.setVisibility(View.VISIBLE);
                relativeFirstlast3R2.setVisibility(View.VISIBLE);
                relativeFirstlast4R2.setVisibility(View.VISIBLE);


                relativeFirstlastR3.setVisibility(View.VISIBLE);
                relativeFirstlast2R3.setVisibility(View.VISIBLE);
                relativeFirstlast3R3.setVisibility(View.VISIBLE);
                relativeFirstlast4R3.setVisibility(View.VISIBLE);

                relativeFirstlastR4.setVisibility(View.VISIBLE);
                relativeFirstlast2R4.setVisibility(View.VISIBLE);
                relativeFirstlast3R4.setVisibility(View.VISIBLE);
                relativeFirstlast4R4.setVisibility(View.VISIBLE);


                String firstName4Gust4 = this.firstName4Gust4.getText().toString();
                String lastName4Gust4 = this.lastName4Gust4.getText().toString();


            }


// 4
            child_countroom4 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom4");


            if (child_countroom4 == 1) {


                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeNamesR3.setVisibility(View.VISIBLE);
                relativeNamesR4.setVisibility(View.VISIBLE);


                relativeFirstlast5.setVisibility(View.VISIBLE);
                relativeFirstlast5R2.setVisibility(View.VISIBLE);
                relativeFirstlast5R3.setVisibility(View.VISIBLE);
                relativeFirstlast5R4.setVisibility(View.VISIBLE);


                String firstName1ChildGust4 = this.firstName1ChildGust4.getText().toString();
                String lastName1ChildGust4 = this.lastName1ChildGust4.getText().toString();
            } else if (child_countroom4 == 2) {


                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeNamesR3.setVisibility(View.VISIBLE);
                relativeNamesR4.setVisibility(View.VISIBLE);


                relativeFirstlast5.setVisibility(View.VISIBLE);
                relativeFirstlast6.setVisibility(View.VISIBLE);


                relativeFirstlast5R2.setVisibility(View.VISIBLE);
                relativeFirstlast6R2.setVisibility(View.VISIBLE);

                relativeFirstlast5R3.setVisibility(View.VISIBLE);
                relativeFirstlast6R3.setVisibility(View.VISIBLE);


                relativeFirstlast5R4.setVisibility(View.VISIBLE);
                relativeFirstlast6R4.setVisibility(View.VISIBLE);


                String firstName2ChildGust4 = this.firstName2ChildGust4.getText().toString();
                String lastName2ChildGust4 = this.lastName2ChildGust4.getText().toString();

            }


        }


        start_time = SharedPreferencesManger.LoadStringData(ConfirmBookingRoom.this, "start_date");
        end_time = SharedPreferencesManger.LoadStringData(ConfirmBookingRoom.this, "end_date");
        hotel_name = SharedPreferencesManger.LoadStringData(ConfirmBookingRoom.this, "hotel_name");
        roomPrice = SharedPreferencesManger.LoadStringData(this, "roomPrice");
        currency = SharedPreferencesManger.LoadStringData(this, "currency");


//        date1 = formatter.parseDateTime(intent.getStringExtra("date1"));
//        date1.toString();
        //  date2 = formatter.parseDateTime(intent.getStringExtra("date2"));

        roomIndex = intent.getIntExtra("roomIndex", 0);
        mHOtelCode = intent.getStringExtra("mHOtelCode");

        BigDecimal amount = new BigDecimal(roomPrice);


        try {
//            HotelBookResponse hotelBookingResponse = service.HotelBook(start_time, end_time,
//                    "070817125855789#kuld", "EG", arrayOfGuest, null, paymentInfo
//                    , sessionId, null, noOfRooms, resultIndex, mHOtelCode, hotel_name, arrayOfRooms, null,
//                    null, false, authenticandata);
//
//
////            Toast.makeText(this, "" + hotelBookingResponse.ConfirmationNo, Toast.LENGTH_SHORT).show();
//
////            HotelBookResponse hotelBookingResponse = service.HotelBook(date1.toString("yyyy-MM-dd"), date2.toString("yyyy-MM-dd"), "070817125855789#kuld", "EG", arrayOfGuest, null, paymentInfo, sessionId, null, noOfRooms, resultIndex, mHOtelCode, null, arrayOfRooms, null, null, false, authenticandata);
//
//            HotelBookingDetailResponse hotelBookingDetailResponse = service.HotelBookingDetail(hotelBookingResponse.BookingId, hotelBookingResponse.ConfirmationNo, "070817125855789#kuld", authenticandata);
//            String confirmationNo = hotelBookingResponse.ConfirmationNo;
            hotel_room = ChooseBookingDate.transferClass.hotel_room;

        } catch (Exception e) {
            e.printStackTrace();
        }


        PaymentObjectProvider mPaymentObjectProvider = new PaymentObjectProvider();
        BigDecimal finalAmount = amount;
        String finalCurrency = currency;
        confirmRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (firstName1GustOne.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName1GustOne", firstName1GustOne.getText().toString());
                    if (firstName1GustOne.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }
                if (lastName1GustOne.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName1GustOne", lastName1GustOne.getText().toString());
                    if (lastName1GustOne.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName2GustOne.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName2GustOne", firstName2GustOne.getText().toString());
                    if (firstName2GustOne.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName2GustOne.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName2GustOne", lastName2GustOne.getText().toString());
                    if (lastName2GustOne.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName3GustOne.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName3GustOne", firstName3GustOne.getText().toString());
                    if (firstName3GustOne.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName3GustOne.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName3GustOne", lastName3GustOne.getText().toString());
                    if (lastName3GustOne.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName4GustOne.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName4GustOne", firstName4GustOne.getText().toString());
                    if (firstName4GustOne.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName4GustOne.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName4GustOne", lastName4GustOne.getText().toString());
                    if (lastName4GustOne.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName1ChildGustOne.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName1ChildGustOne", firstName1ChildGustOne.getText().toString());
                    if (firstName1ChildGustOne.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName1ChildGustOne.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName1ChildGustOne", lastName1ChildGustOne.getText().toString());
                    if (lastName1ChildGustOne.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName2ChildGustOne.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName2ChildGustOne", firstName2ChildGustOne.getText().toString());
                    if (firstName2ChildGustOne.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName2ChildGustOne.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName2ChildGustOne", lastName2ChildGustOne.getText().toString());
                    if (lastName2ChildGustOne.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName1Gust2.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName1Gust2", firstName1Gust2.getText().toString());
                    if (firstName1Gust2.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName1Gust2.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName1Gust2", lastName1Gust2.getText().toString());
                    if (lastName1Gust2.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName2Gust2.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName2Gust2", firstName2Gust2.getText().toString());
                    if (firstName2Gust2.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName2Gust2.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName2Gust2", lastName2Gust2.getText().toString());
                    if (lastName2Gust2.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName3Gust2.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName3Gust2", firstName3Gust2.getText().toString());
                    if (firstName3Gust2.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName3Gust2.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName3Gust2", lastName3Gust2.getText().toString());
                    if (lastName3Gust2.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }


                if (firstName4Gust2.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName4Gust2", firstName4Gust2.getText().toString());
                    if (firstName4Gust2.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName4Gust2.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName4Gust2", lastName4Gust2.getText().toString());
                    if (lastName4Gust2.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName1ChildGust2.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName1ChildGust2", firstName1ChildGust2.getText().toString());
                    if (firstName1ChildGust2.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName1ChildGust2.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName1ChildGust2", lastName1ChildGust2.getText().toString());
                    if (lastName1ChildGust2.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName2ChildGust2.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName2ChildGust2", firstName2ChildGust2.getText().toString());
                    if (firstName2ChildGust2.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }


                if (lastName2ChildGust2.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName2ChildGust2", lastName2ChildGust2.getText().toString());
                    if (lastName2ChildGust2.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName1Gust3.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName1Gust3", firstName1Gust3.getText().toString());
                    if (firstName1Gust3.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName1Gust3.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName1Gust3", lastName1Gust3.getText().toString());
                    if (lastName1Gust3.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName2Gust3.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName2Gust3", firstName2Gust3.getText().toString());
                    if (firstName2Gust3.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName2Gust3.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName2Gust3", lastName2Gust3.getText().toString());
                    if (lastName2Gust3.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }


                if (firstName3Gust3.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName3Gust3", firstName3Gust3.getText().toString());
                    if (firstName3Gust3.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName3Gust3.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName3Gust3", lastName3Gust3.getText().toString());
                    if (lastName3Gust3.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName4Gust3.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName4Gust3", firstName4Gust3.getText().toString());
                    if (firstName4Gust3.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName4Gust3.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName4Gust3", lastName4Gust3.getText().toString());
                    if (lastName4Gust3.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }


                if (firstName1ChildGust3.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName1ChildGust3", firstName1ChildGust3.getText().toString());
                    if (firstName1ChildGust3.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName1ChildGust3.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName1ChildGust3", lastName1ChildGust3.getText().toString());
                    if (lastName1ChildGust3.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }


                if (firstName2ChildGust3.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName2ChildGust3", firstName2ChildGust3.getText().toString());
                    if (firstName2ChildGust3.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }


                if (lastName2ChildGust3.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName2ChildGust3", lastName2ChildGust3.getText().toString());
                    if (lastName2ChildGust3.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName1Gust4.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName1Gust4", firstName1Gust4.getText().toString());
                    if (firstName1Gust4.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName1Gust4.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName1Gust4", lastName1Gust4.getText().toString());
                    if (lastName1Gust4.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }


                if (firstName2Gust4.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName2Gust4", firstName2Gust4.getText().toString());
                    if (firstName2Gust4.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName2Gust4.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName2Gust4", lastName2Gust4.getText().toString());
                    if (lastName2Gust4.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName3Gust4.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName3Gust4", firstName3Gust4.getText().toString());
                    if (firstName3Gust4.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName3Gust4.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName3Gust4", lastName3Gust4.getText().toString());
                    if (lastName3Gust4.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName4Gust4.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName4Gust4", firstName4Gust4.getText().toString());
                    if (firstName4Gust4.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName4Gust4.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName4Gust4", lastName4Gust4.getText().toString());
                    if (lastName4Gust4.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName1ChildGust4.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName1ChildGust4", firstName1ChildGust4.getText().toString());
                    if (firstName1ChildGust4.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName1ChildGust4.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName1ChildGust4", lastName1ChildGust4.getText().toString());
                    if (lastName1ChildGust4.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (firstName2ChildGust4.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName2ChildGust4", firstName2ChildGust4.getText().toString());
                    if (firstName2ChildGust4.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }

                if (lastName2ChildGust4.getVisibility() == View.VISIBLE) {

                    SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName2ChildGust4", lastName2ChildGust4.getText().toString());
                    if (lastName2ChildGust4.getText().toString().equals("")) {
                        notifynoData();
                        return;
                    }
                }


//                int noOfStrings = no_adultroom1 + no_adultroom2 + no_adultroom3 + no_adultroom4 + child_countroom1 +
//                        child_countroom2 + child_countroom3 + child_countroom4;
//                for (int i = 0; i < noOfStrings; i++) {
//
//
//                }
//                ArrayList<String> texts = new ArrayList<>();
//                for (String str : texts) {
//                    if (str.equals("")) {
//
//                    }
//                }


//                if (firstName.getText().toString().equals("") || lastName.getText().toString().equals("")) {
//                    SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(ConfirmBookingRoom.this);
//                    sweetAlertDialog.setConfirmButton("Ok", null);
//                    sweetAlertDialog.setContentText("Please add First guest's first and last name at least");
//                    sweetAlertDialog.show();
//                    return;
//                }
//                SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName", firstName.getText().toString());
//                SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName", lastName.getText().toString());


//                Client client = new Client(ConfirmBookingRoom.this, "https://api-test.wirecard.com");
//                client.startPayment(mPaymentObjectProvider.getCardPayment(true, finalAmount, finalCurrency));
                Intent intent1 = new Intent(ConfirmBookingRoom.this, PaymentActivity.class);

                intent1.putExtra("mId", 2);
                // FIXME: 03/08/2019 change to startactivityforresult
                startActivity(intent1);
            }
        });


        Spinner s1, s2, s3;
        ArrayAdapter mrOrMissAdapter;
        ArrayList<String> mrOrMissArray;


        mrOrMissArray = new ArrayList<>();
        mrOrMissArray.add("Mr.");
        mrOrMissArray.add("Mrs.");
        mrOrMissAdapter = new ArrayAdapter(this, R.layout.item_spener, mrOrMissArray);
        mrOrMissAdapter.setDropDownViewResource(R.layout.drop_dowen);
        s1 = findViewById(R.id.mromiss1);
        s1.setSelection(1);
        s1.setAdapter(mrOrMissAdapter);
        s2 = findViewById(R.id.mromiss2);
        s2.setSelection(1);
        s2.setAdapter(mrOrMissAdapter);
        s3 = findViewById(R.id.mromiss3);
        s3.setSelection(1);
        s3.setAdapter(mrOrMissAdapter);


        String mSpecification = specification.getText().toString();


        setSpecification(mSpecification);


    }

    private void notifynoData() {
        AlertDialog.Builder alert = new AlertDialog.Builder(ConfirmBookingRoom.this);
        alert.setNeutralButton("Ok", null);
        alert.setMessage("Please fill out all forms");
        alert.show();
    }

    private void setSpecification(String mSpecification) {


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Serializable paymentSdkResponse = data.getSerializableExtra(Client.EXTRA_PAYMENT_SDK_RESPONSE);
        if (paymentSdkResponse instanceof PaymentResponse) {
            String formattedResponse = ResponseHelper.getFormattedResponse((PaymentResponse) paymentSdkResponse);

        }
        if (resultCode == RESULT_OK) {
            Toast.makeText(this, "your payment is successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ConfirmBookingRoom.this, RoomBooked.class));
        }
    }

    @OnClick({R.id.assistant_label_voice_confirm_hotel, R.id.assistant_label_call_confirm_hotel, R.id.assistant_label_message_confirm_hotel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.assistant_label_voice_confirm_hotel:
                Toast.makeText(this, "Voice", Toast.LENGTH_SHORT).show();

                break;
            case R.id.assistant_label_call_confirm_hotel:

                Toast.makeText(this, "Call", Toast.LENGTH_SHORT).show();

                break;
            case R.id.assistant_label_message_confirm_hotel:


                Toast.makeText(this, "Message", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    @OnClick(R.id.relative_img_confirm_hotel_tamm)
    public void onViewClicked() {


        if (ClickConfirmHotel == false) {
            assistantLabelCallConfirmHotel.setVisibility(View.VISIBLE);
            assistantLabelMessageConfirmHotel.setVisibility(View.VISIBLE);
            assistantLabelVoiceConfirmHotel.setVisibility(View.VISIBLE);
            ClickConfirmHotel = true;

        } else {
            assistantLabelCallConfirmHotel.setVisibility(View.INVISIBLE);
            assistantLabelMessageConfirmHotel.setVisibility(View.INVISIBLE);
            assistantLabelVoiceConfirmHotel.setVisibility(View.INVISIBLE);
            ClickConfirmHotel = false;

        }


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ConfirmBookingRoom.this, checkroom.class));

    }
}
