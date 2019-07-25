package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
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
    @BindView(R.id.mromiss5)
    Spinner mromiss5;
    @BindView(R.id.ed_first5)
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
    EditText lastName;
    private boolean ClickConfirmHotel=false;


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
        SharedPreferencesManger.SaveData(this, "noOfRooms", noOfRooms);
        resultIndex = intent.getIntExtra("resultIndex", 1);
//        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");


        int noOfRooms = SharedPreferencesManger.LoadIntegerData(ConfirmBookingRoom.this, "noOfRooms");


        if (noOfRooms == 1) {

        } else if (noOfRooms == 2) {

            relativeFirstlast2.setVisibility(View.VISIBLE);

        } else if (noOfRooms == 3) {
            relativeFirstlast2.setVisibility(View.VISIBLE);
            relativeFirstlast3.setVisibility(View.VISIBLE);
        } else if (noOfRooms == 4) {
            relativeFirstlast2.setVisibility(View.VISIBLE);
            relativeFirstlast3.setVisibility(View.VISIBLE);
            relativeFirstlast4.setVisibility(View.VISIBLE);
        } else if (noOfRooms == 5) {
            relativeFirstlast2.setVisibility(View.VISIBLE);
            relativeFirstlast3.setVisibility(View.VISIBLE);
            relativeFirstlast4.setVisibility(View.VISIBLE);
            relativeFirstlast5.setVisibility(View.VISIBLE);
        } else if (noOfRooms == 6) {
            relativeFirstlast2.setVisibility(View.VISIBLE);
            relativeFirstlast3.setVisibility(View.VISIBLE);
            relativeFirstlast4.setVisibility(View.VISIBLE);
            relativeFirstlast5.setVisibility(View.VISIBLE);
            relativeFirstlast6.setVisibility(View.VISIBLE);
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

        confirmRoom = findViewById(R.id.confirm_room_booking);
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
                startActivity(new Intent(ConfirmBookingRoom.this, PaymentTemp.class));
            }
        });


        Spinner s1, s2, s3;
        ArrayAdapter mrOrMissAdapter;
        ArrayList<String> mrOrMissArray;


        mrOrMissArray = new ArrayList<>();
        mrOrMissArray.add("Mr.");
        mrOrMissArray.add("Mrs.");
        mrOrMissAdapter = new ArrayAdapter(this,
                R.layout.mrormissspinnerlist
                , mrOrMissArray);
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
}
