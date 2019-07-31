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
import cn.pedant.SweetAlert.SweetAlertDialog;
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
    @BindView(R.id.ed_first4)
    EditText edFirst4;
    @BindView(R.id.relative_firstlast4)
    RelativeLayout relativeFirstlast4;
    EditText edFirst5;
    @BindView(R.id.relative_firstlast5)
    RelativeLayout relativeFirstlast5;
    @BindView(R.id.mromiss6)
    Spinner mromiss6;
    @BindView(R.id.ed_first6)
    EditText edFirst6;
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
    @BindView(R.id.ed_first)
    EditText edFirst;
    @BindView(R.id.lastName)
    EditText lastName;
    @BindView(R.id.mromiss2)
    Spinner mromiss2;
    @BindView(R.id.ed_first2)
    EditText edFirst2;
    @BindView(R.id.mromiss3)
    Spinner mromiss3;
    @BindView(R.id.ed_first3)
    EditText edFirst3;
    @BindView(R.id.mromiss5)
    Spinner mromiss5;

    @BindView(R.id.relative_names_1)
    RelativeLayout relativeNames1;
    @BindView(R.id.mromiss1R_2)
    Spinner mromiss1R2;
    @BindView(R.id.ed_firstR_2)
    EditText edFirstR2;
    @BindView(R.id.lastNameR_2)
    EditText lastNameR2;
    @BindView(R.id.relative_firstlastR_2)
    RelativeLayout relativeFirstlastR2;
    @BindView(R.id.mromiss2R_2)
    Spinner mromiss2R2;
    @BindView(R.id.ed_first2R_2)
    EditText edFirst2R2;
    @BindView(R.id.relative_firstlast2R_2)
    RelativeLayout relativeFirstlast2R2;
    @BindView(R.id.mromiss3R_2)
    Spinner mromiss3R2;
    @BindView(R.id.ed_first3R_2)
    EditText edFirst3R2;
    @BindView(R.id.relative_firstlast3R_2)
    RelativeLayout relativeFirstlast3R2;
    @BindView(R.id.mromiss4R_2)
    Spinner mromiss4R2;
    @BindView(R.id.ed_first4R_2)
    EditText edFirst4R2;
    @BindView(R.id.relative_firstlast4R_2)
    RelativeLayout relativeFirstlast4R2;
    @BindView(R.id.mromiss5R_2)
    Spinner mromiss5R2;
    @BindView(R.id.ed_first5R_2)
    EditText edFirst5R2;
    @BindView(R.id.relative_firstlast5R_2)
    RelativeLayout relativeFirstlast5R2;
    @BindView(R.id.mromiss6R_2)
    Spinner mromiss6R2;
    @BindView(R.id.ed_first6R_2)
    EditText edFirst6R2;
    @BindView(R.id.relative_firstlast6R_2)
    RelativeLayout relativeFirstlast6R2;
    @BindView(R.id.relative_namesR_2)
    RelativeLayout relativeNamesR2;
    @BindView(R.id.mromiss1R_3)
    Spinner mromiss1R3;
    @BindView(R.id.ed_firstR_3)
    EditText edFirstR3;
    @BindView(R.id.lastNameR_3)
    EditText lastNameR3;
    @BindView(R.id.relative_firstlastR_3)
    RelativeLayout relativeFirstlastR3;
    @BindView(R.id.mromiss2R_3)
    Spinner mromiss2R3;
    @BindView(R.id.ed_first2R_3)
    EditText edFirst2R3;
    @BindView(R.id.relative_firstlast2R_3)
    RelativeLayout relativeFirstlast2R3;
    @BindView(R.id.mromiss3R_3)
    Spinner mromiss3R3;
    @BindView(R.id.ed_first3R_3)
    EditText edFirst3R3;
    @BindView(R.id.relative_firstlast3R_3)
    RelativeLayout relativeFirstlast3R3;
    @BindView(R.id.mromiss4R_3)
    Spinner mromiss4R3;
    @BindView(R.id.ed_first4R_3)
    EditText edFirst4R3;
    @BindView(R.id.relative_firstlast4R_3)
    RelativeLayout relativeFirstlast4R3;
    @BindView(R.id.mromiss5R_3)
    Spinner mromiss5R3;
    @BindView(R.id.ed_first5R_3)
    EditText edFirst5R3;
    @BindView(R.id.relative_firstlast5R_3)
    RelativeLayout relativeFirstlast5R3;
    @BindView(R.id.mromiss6R_3)
    Spinner mromiss6R3;
    @BindView(R.id.ed_first6R_3)
    EditText edFirst6R3;
    @BindView(R.id.relative_firstlast6R_3)
    RelativeLayout relativeFirstlast6R3;
    @BindView(R.id.relative_namesR_3)
    RelativeLayout relativeNamesR3;
    @BindView(R.id.mromiss1R_4)
    Spinner mromiss1R4;
    @BindView(R.id.ed_firstR_4)
    EditText edFirstR4;
    @BindView(R.id.lastNameR_4)
    EditText lastNameR4;
    @BindView(R.id.relative_firstlastR_4)
    RelativeLayout relativeFirstlastR4;
    @BindView(R.id.mromiss2R_4)
    Spinner mromiss2R4;
    @BindView(R.id.ed_first2R_4)
    EditText edFirst2R4;
    @BindView(R.id.relative_firstlast2R_4)
    RelativeLayout relativeFirstlast2R4;
    @BindView(R.id.mromiss3R_4)
    Spinner mromiss3R4;
    @BindView(R.id.ed_first3R_4)
    EditText edFirst3R4;
    @BindView(R.id.relative_firstlast3R_4)
    RelativeLayout relativeFirstlast3R4;
    @BindView(R.id.mromiss4R_4)
    Spinner mromiss4R4;
    @BindView(R.id.ed_first4R_4)
    EditText edFirst4R4;
    @BindView(R.id.relative_firstlast4R_4)
    RelativeLayout relativeFirstlast4R4;
    @BindView(R.id.mromiss5R_4)
    Spinner mromiss5R4;
    @BindView(R.id.ed_first5R_4)
    EditText edFirst5R4;
    @BindView(R.id.relative_firstlast5R_4)
    RelativeLayout relativeFirstlast5R4;
    @BindView(R.id.mromiss6R_4)
    Spinner mromiss6R4;
    @BindView(R.id.ed_first6R_4)
    EditText edFirst6R4;
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
    EditText firstName;
    private boolean ClickConfirmHotel = false;
    private int no_adultroom1, no_adultroom2, no_adultroom3, no_adultroom4;
    private int child_countroom4, child_countroom3, child_countroom2, child_countroom1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking_room);
        ButterKnife.bind(this);
        firstName = findViewById(R.id.ed_first);
        lastName = findViewById(R.id.lastName);
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

        if (noOfRooms == 1) {
            no_adultroom1 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom1");


            if (no_adultroom1 == 1) {

            } else if (no_adultroom1 == 2) {
                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlastR4.setVisibility(View.GONE);


            } else if (no_adultroom1 == 3) {
                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);

                relativeFirstlastR4.setVisibility(View.GONE);


            } else if (no_adultroom1 == 4) {
                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);
                relativeFirstlast4.setVisibility(View.VISIBLE);

            }
            child_countroom1 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom1");


            if (child_countroom1 == 1) {

                relativeFirstlast5.setVisibility(View.VISIBLE);
            } else if (child_countroom1 == 2) {
                relativeFirstlast5.setVisibility(View.VISIBLE);
                relativeFirstlast6.setVisibility(View.VISIBLE);



            }


        } else if (noOfRooms == 2) {
            no_adultroom2 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom2");


            if (no_adultroom2 == 1) {
                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeFirstlastR2.setVisibility(View.VISIBLE);

            } else if (no_adultroom2 == 2) {
                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast2R2.setVisibility(View.VISIBLE);

            } else if (no_adultroom2 == 3) {

                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);
                relativeFirstlast2R2.setVisibility(View.VISIBLE);
                relativeFirstlast3R2.setVisibility(View.VISIBLE);


            } else if (no_adultroom2 == 4) {
                relativeNamesR2.setVisibility(View.VISIBLE);

                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);
                relativeFirstlast4.setVisibility(View.VISIBLE);
                relativeFirstlast2R2.setVisibility(View.VISIBLE);
                relativeFirstlast3R2.setVisibility(View.VISIBLE);
                relativeFirstlast4R2.setVisibility(View.VISIBLE);

            }


            child_countroom2 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom2");

            if (child_countroom2 == 1) {
                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeFirstlast5.setVisibility(View.VISIBLE);
                relativeFirstlast5R2.setVisibility(View.VISIBLE);

            } else if (child_countroom2 == 2) {

                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeFirstlast5.setVisibility(View.VISIBLE);
                relativeFirstlast6.setVisibility(View.VISIBLE);
                relativeFirstlast5R2.setVisibility(View.VISIBLE);
                relativeFirstlast6R2.setVisibility(View.VISIBLE);
            }


        } else if (noOfRooms == 3) {

            no_adultroom3 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom3");


            if (no_adultroom3 == 1) {
                relativeFirstlastR2.setVisibility(View.VISIBLE);
                relativeNamesR3.setVisibility(View.VISIBLE);
                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeFirstlastR3.setVisibility(View.VISIBLE);


            } else if (no_adultroom3 == 2) {
                relativeNamesR3.setVisibility(View.VISIBLE);
                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeFirstlast2.setVisibility(View.VISIBLE);
                relativeFirstlast2R2.setVisibility(View.VISIBLE);
                relativeFirstlast3.setVisibility(View.VISIBLE);
                relativeFirstlast2R3.setVisibility(View.VISIBLE);
                relativeFirstlastR4.setVisibility(View.GONE);

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


            }


            child_countroom3 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom3");


            if (child_countroom3 == 1) {


                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeNamesR3.setVisibility(View.VISIBLE);

                relativeFirstlast5.setVisibility(View.VISIBLE);
                relativeFirstlast5R2.setVisibility(View.VISIBLE);
                relativeFirstlast5R3.setVisibility(View.VISIBLE);


            } else if (child_countroom3 == 2) {


                relativeNamesR2.setVisibility(View.VISIBLE);
                relativeNamesR3.setVisibility(View.VISIBLE);
                relativeFirstlast5.setVisibility(View.VISIBLE);
                relativeFirstlast6.setVisibility(View.VISIBLE);
                relativeFirstlast5R2.setVisibility(View.VISIBLE);
                relativeFirstlast6R2.setVisibility(View.VISIBLE);
                relativeFirstlast5R3.setVisibility(View.VISIBLE);
                relativeFirstlast6R3.setVisibility(View.VISIBLE);



            }

            } else if (noOfRooms == 4) {


                //4


                no_adultroom4 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom4");

                Toast.makeText(this, "" + no_adultroom4, Toast.LENGTH_SHORT).show();

                if (no_adultroom4 == 1) {

                    relativeFirstlastR2.setVisibility(View.VISIBLE);
                    relativeNamesR3.setVisibility(View.VISIBLE);
                    relativeNamesR2.setVisibility(View.VISIBLE);
                    relativeNamesR4.setVisibility(View.VISIBLE);
                    relativeFirstlastR3.setVisibility(View.VISIBLE);
                    relativeFirstlastR4.setVisibility(View.VISIBLE);


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
                if (firstName.getText().toString().equals("") || lastName.getText().toString().equals("")) {
                    SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(ConfirmBookingRoom.this);
                    sweetAlertDialog.setConfirmButton("Ok", null);
                    sweetAlertDialog.setContentText("Please add First guest's first and last name at least");
                    sweetAlertDialog.show();
                    return;
                }
                SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "firstName", firstName.getText().toString());
                SharedPreferencesManger.SaveData(ConfirmBookingRoom.this, "lastName", lastName.getText().toString());


//                Client client = new Client(ConfirmBookingRoom.this, "https://api-test.wirecard.com");
//                client.startPayment(mPaymentObjectProvider.getCardPayment(true, finalAmount, finalCurrency));
                Intent intent1 = new Intent(ConfirmBookingRoom.this, PaymentActivity.class);

                intent1.putExtra("mId", 2);
                startActivity(intent1);
            }
        });


        Spinner s1, s2, s3;
        ArrayAdapter mrOrMissAdapter;
        ArrayList<String> mrOrMissArray;


        mrOrMissArray = new ArrayList<>();
        mrOrMissArray.add("Mr.");
        mrOrMissArray.add("Mrs.");
        mrOrMissAdapter = new ArrayAdapter(this,
                R.layout.item_spener
                , mrOrMissArray);
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
