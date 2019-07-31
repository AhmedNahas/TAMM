package net.middledleeast.tamm.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.Tamm.Hotels.wcf.AmendInformation;
import com.Tamm.Hotels.wcf.AmendmentRequestType;
import com.Tamm.Hotels.wcf.AmendmentResponse;
import com.Tamm.Hotels.wcf.ArrayOfGuest;
import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
import com.Tamm.Hotels.wcf.ArrayOfRoomGuest;
import com.Tamm.Hotels.wcf.ArrayOfSupplement;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.CheckInReq;
import com.Tamm.Hotels.wcf.Enums;
import com.Tamm.Hotels.wcf.Guest;
import com.Tamm.Hotels.wcf.HotelBookResponse;
import com.Tamm.Hotels.wcf.Hotel_Room;
import com.Tamm.Hotels.wcf.PaymentInfo;
import com.Tamm.Hotels.wcf.RequestedRooms;
import com.Tamm.Hotels.wcf.RoomGuest;
import com.Tamm.Hotels.wcf.SuppInfo;
import com.Tamm.Hotels.wcf.Supplement;
import com.google.gson.Gson;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RoomBooked extends AppCompatActivity {


    ArrayOfGuest arrayOfGuest;
    @BindView(R.id.assistant_label_voice_booked_hotel)
    TextView assistantLabelVoiceBookedHotel;
    @BindView(R.id.assistant_label_call_booked_hotel)
    TextView assistantLabelCallBookedHotel;
    @BindView(R.id.assistant_label_message_booked_hotel)
    TextView assistantLabelMessageBookedHotel;
    @BindView(R.id.relative_img_hotel_booked_tamm)
    RelativeLayout relativeImgHotelBookedTamm;
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
    RelativeLayout backButton;


    private Button button;
    private boolean ClickBookedHotel=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_booked);
        ButterKnife.bind(this);

        backButton = findViewById(R.id.toolbar_back1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoomBooked.this, ConfirmBookingRoom.class));
            }
        });


        assistantLabelCallBookedHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RoomBooked.this, "Call", Toast.LENGTH_SHORT).show();
            }
        });

        assistantLabelVoiceBookedHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RoomBooked.this, "Voice", Toast.LENGTH_SHORT).show();
            }
        });

        assistantLabelMessageBookedHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RoomBooked.this, "Message", Toast.LENGTH_SHORT).show();
            }
        });

        service = new BasicHttpBinding_IHotelService1();
        service.enableLogging = true;
        authenticandata = new AuthenticationData();
        authenticandata.UserName = ("Tammtest");
        authenticandata.Password = ("Tam@18418756");
        sessionId = SharedPreferencesManger.LoadStringData(this, "session_id");
        noOfRooms = SharedPreferencesManger.LoadIntegerData(this, "noOfRooms");
        resultIndex = SharedPreferencesManger.LoadIntegerData(this, "resultindex");
        roomIndex = SharedPreferencesManger.LoadIntegerData(this, "roomIndex");
        mHOtelCode = SharedPreferencesManger.LoadStringData(this, "mHotel_code");






        ArrayOfRoomGuest arrayOfRoomGuest = new Gson().fromJson(SharedPreferencesManger.LoadStringData(this,"roomGuests"));


        arrayOfGuest = new ArrayOfGuest();
        for (RoomGuest roomGuest : arrayOfRoomGuest) {
            Guest guest =new Guest();
            guest.FirstName = roomGuest
        }

//        Guest guest = new Guest();
//        guest.Title = "Mr";
//        guest.Age = 25;
//        guest.FirstName = SharedPreferencesManger.LoadStringData(this, "firstName");
//        guest.LeadGuest = true;
//        guest.GuestType = Enums.GuestType.Adult;
//        guest.LastName = SharedPreferencesManger.LoadStringData(this, "lastName");
//        guest.GuestInRoom = 1;
//        arrayOfGuest.add(guest);
//        Guest guest2 = new Guest();
//        guest2.Title = "Mr";
//        guest2.Age = 5;
//        guest2.FirstName = "CC";
//        guest2.LeadGuest = false;
//        guest2.GuestType = Enums.GuestType.Child;
//        guest2.LastName = "DD";
//        guest2.GuestInRoom = 1;
//        arrayOfGuest.add(guest2);
//        Guest guest1 = new Guest();
//        guest1.Title = "Mr";
//        guest1.Age = 35;
//        guest1.FirstName = "Farid";
//        guest1.LeadGuest = false;
//        guest1.GuestType = Enums.GuestType.Adult;
//        guest1.LastName = "Fady";
//        guest1.GuestInRoom = 2;
//        arrayOfGuest.add(guest1);
//        Guest guest3 = new Guest();
//        guest3.Title = "Mr";
//        guest3.Age = 2;
//        guest3.FirstName = "aa";
//        guest3.LeadGuest = false;
//        guest3.GuestType = Enums.GuestType.Child;
//        guest3.LastName = "BB";
//        guest3.GuestInRoom = 1;
//        arrayOfGuest.add(guest3);
//        Guest guest4 = new Guest();
//        guest4.Title = "Mr";
//        guest4.Age = 35;
//        guest4.FirstName = "Sherif";
//        guest4.LeadGuest = false;
//        guest4.GuestType = Enums.GuestType.Adult;
//        guest4.LastName = "Anwar";
//        guest4.GuestInRoom = 2;
//        arrayOfGuest.add(guest4);
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.VoucherBooking = true;
        paymentInfo.PaymentModeType = Enums.PaymentModeType.Limit;

//        paymentInfo.CvvNumber="500";

        start_time = SharedPreferencesManger.LoadStringData(RoomBooked.this, "start_date");
        end_time = SharedPreferencesManger.LoadStringData(RoomBooked.this, "end_date");
        hotel_name = SharedPreferencesManger.LoadStringData(RoomBooked.this, "hotel_name");


        bookingresponse(paymentInfo);


        button = findViewById(R.id.get_code);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoomBooked.this, HotelBooking.class));
            }
        });
    }

    private void bookingresponse(PaymentInfo paymentInfo) {
        try {

            Gson gson = new Gson();

            //jodatime cannot be serialized
//            String roomAvailacbityresponse = SharedPreferencesManger.LoadStringData(this,"roomAvailability");
//            HotelRoomAvailabilityResponse availabilityResponse = gson.fromJson(roomAvailacbityresponse, HotelRoomAvailabilityResponse.class);

            DateTime dt = new DateTime();
            DateTimeFormatter fmt = DateTimeFormat.forPattern("ddMMyyhhmmssSSS");
            String dtStr = fmt.print(dt);

            String reqRoomString = SharedPreferencesManger.LoadStringData(this, "arrayOfroomsreq");

            arrayOfRooms = gson.fromJson(reqRoomString, ArrayOfRequestedRooms.class);

            String arraySupp = SharedPreferencesManger.LoadStringData(this, "suppArray");
            ArrayOfSupplement arrayOfSupplement = gson.fromJson(arraySupp, ArrayOfSupplement.class);
            boolean atProperty = false;
            if (arrayOfSupplement != null) {
                for (Supplement supplement : arrayOfSupplement) {
                    if (supplement.SuppIsMandatory) {
                        atProperty = supplement.SuppChargeType.getCode() == Enums.SuppChargeType.AtProperty.getCode();

                    }
                }

                if (atProperty) {

                    RequestedRooms requestedRooms = arrayOfRooms.get(0);
                    if (requestedRooms.Supplements != null) {
                        for (SuppInfo suppInfo : requestedRooms.Supplements) {
                            suppInfo.SuppChargeType = Enums.SuppChargeType.AtProperty;
                        }
                    }
                }


            }
            SharedPreferencesManger.SaveData(this, "arrayOfroomsreq", null);

            String clientReferenceNo = dtStr + "#TAMM";
            HotelBookResponse hotelBookingResponse = service.HotelBook(start_time, end_time,
                    clientReferenceNo, "EG", arrayOfGuest, null, paymentInfo
                    , sessionId, null, noOfRooms, resultIndex, mHOtelCode, hotel_name, arrayOfRooms, null,
                    null, false, authenticandata);
            SharedPreferencesManger.SaveData(this, "ClientRef", clientReferenceNo);
            SharedPreferencesManger.SaveData(this, "BookingID", hotelBookingResponse.BookingId);
            SharedPreferencesManger.SaveData(this, "ConfirmationNo", hotelBookingResponse.ConfirmationNo);

            AmendmentRequestType amendmentRequestType = new AmendmentRequestType();
            amendmentRequestType.Type = Enums.AmendmentType.OfflineAmendment;
            AmendInformation amendInformation = new AmendInformation();
            amendInformation.CheckIn = new CheckInReq();
            amendInformation.CheckIn.Date = new DateTime(start_time);
            AmendmentResponse amendmentResponse = service.Amendment(amendmentRequestType, hotelBookingResponse.BookingId, amendInformation, hotelBookingResponse.ConfirmationNo, authenticandata);
//this is to cancel request

            //HotelCancelResponse hotelCancelResponse = service.HotelCancel(hotelBookingResponse.BookingId, Enums.CancelRequestType.HotelCancel, "Test", hotelBookingResponse.ConfirmationNo, authenticandata);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.relative_img_hotel_booked_tamm)
    public void onViewClicked() {

        if (ClickBookedHotel == false) {
            assistantLabelCallBookedHotel.setVisibility(View.VISIBLE);
            assistantLabelMessageBookedHotel.setVisibility(View.VISIBLE);
            assistantLabelVoiceBookedHotel.setVisibility(View.VISIBLE);
            ClickBookedHotel = true;

        } else {
            assistantLabelCallBookedHotel.setVisibility(View.INVISIBLE);
            assistantLabelMessageBookedHotel.setVisibility(View.INVISIBLE);
            assistantLabelVoiceBookedHotel.setVisibility(View.INVISIBLE);
            ClickBookedHotel = false;

        }

    }
}
