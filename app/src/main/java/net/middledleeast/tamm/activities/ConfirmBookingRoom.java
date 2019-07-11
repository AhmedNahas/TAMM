package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.Tamm.Hotels.wcf.ArrayOfGuest;
import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.Enums;
import com.Tamm.Hotels.wcf.Guest;
import com.Tamm.Hotels.wcf.HotelBookResponse;
import com.Tamm.Hotels.wcf.HotelBookingDetailResponse;
import com.Tamm.Hotels.wcf.Hotel_Room;
import com.Tamm.Hotels.wcf.PaymentInfo;
import com.google.gson.Gson;
import com.wirecard.ecom.Client;
import com.wirecard.ecom.model.out.PaymentResponse;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import payments.PaymentObjectProvider;
import payments.ResponseHelper;

public class ConfirmBookingRoom extends AppCompatActivity {

    private Button confirmRoom;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking_room);
        Gson gson = new Gson();
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
        noOfRooms = intent.getIntExtra("noOfRooms", 1);
        resultIndex = intent.getIntExtra("resultIndex", 1);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");

        start_time = SharedPreferencesManger.LoadStringData(ConfirmBookingRoom.this, "start_date");
        end_time = SharedPreferencesManger.LoadStringData(ConfirmBookingRoom.this, "end_date");
        hotel_name = SharedPreferencesManger.LoadStringData(ConfirmBookingRoom.this, "hotel_name");


//        date1 = formatter.parseDateTime(intent.getStringExtra("date1"));
//        date1.toString();
        //  date2 = formatter.parseDateTime(intent.getStringExtra("date2"));

        roomIndex = intent.getIntExtra("roomIndex", 0);
        mHOtelCode = intent.getStringExtra("mHOtelCode");
//        authenticandata = gson.fromJson(intent.getStringExtra("authenticandata"), AuthenticationData.class);
        arrayOfGuest = new ArrayOfGuest();
        Guest guest = new Guest();
        guest.Title = "Mr";
        guest.Age = 25;
        guest.FirstName = "Tester";
        guest.LeadGuest = true;
        guest.GuestType = Enums.GuestType.Adult;
        guest.LastName = "Test";
        guest.GuestInRoom = 1;
        arrayOfGuest.add(guest);
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.VoucherBooking = false;
        paymentInfo.PaymentModeType = Enums.PaymentModeType.CreditCard;
        arrayOfRooms = ChooseBookingDate.transferClass.getArrayOfRequestedRooms();
        BigDecimal amount = BigDecimal.valueOf(0);
        String clientReferenceNo = DateTime.now().toString() + "#TAMM";
        String currency = "";
        try {
            HotelBookResponse hotelBookingResponse = service.HotelBook(start_time, end_time,
                    "070817125855789#kuld", "EG", arrayOfGuest, null, paymentInfo
                    , sessionId, null, noOfRooms, resultIndex, mHOtelCode, hotel_name, arrayOfRooms, null,
                    null, false, authenticandata);


//            Toast.makeText(this, "" + hotelBookingResponse.ConfirmationNo, Toast.LENGTH_SHORT).show();

//            HotelBookResponse hotelBookingResponse = service.HotelBook(date1.toString("yyyy-MM-dd"), date2.toString("yyyy-MM-dd"), "070817125855789#kuld", "EG", arrayOfGuest, null, paymentInfo, sessionId, null, noOfRooms, resultIndex, mHOtelCode, null, arrayOfRooms, null, null, false, authenticandata);

            HotelBookingDetailResponse hotelBookingDetailResponse = service.HotelBookingDetail(hotelBookingResponse.BookingId, hotelBookingResponse.ConfirmationNo, "070817125855789#kuld", authenticandata);
            String confirmationNo = hotelBookingResponse.ConfirmationNo;
            hotel_room = ChooseBookingDate.transferClass.hotel_room;
            amount = hotel_room.RoomRate.TotalFare;
            currency = hotel_room.RoomRate.Currency;
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
//                startActivity(new Intent(ConfirmBookingRoom.this, PaymentActivity.class ));
                Client client = new Client(ConfirmBookingRoom.this, "https://api-test.wirecard.com");
                client.startPayment(mPaymentObjectProvider.getCardPayment(true, finalAmount, finalCurrency));
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
}
