package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.Tamm.Hotels.wcf.AmendInformation;
import com.Tamm.Hotels.wcf.AmendmentRequestType;
import com.Tamm.Hotels.wcf.AmendmentResponse;
import com.Tamm.Hotels.wcf.ArrayOfGuest;
import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
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
import com.Tamm.Hotels.wcf.SuppInfo;
import com.Tamm.Hotels.wcf.Supplement;
import com.google.gson.Gson;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

public class RoomBooked extends AppCompatActivity {


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


    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_booked);

        service = new BasicHttpBinding_IHotelService1();
        service.enableLogging = true;
        authenticandata = new AuthenticationData();
        authenticandata.UserName = ("Tammtest");
        authenticandata.Password = ("Tam@18418756");
        sessionId = SharedPreferencesManger.LoadStringData(this, "session_id");
        noOfRooms = SharedPreferencesManger.LoadIntegerData(this, "noOfRooms");
        resultIndex = SharedPreferencesManger.LoadIntegerData(this, "resultIndex");
        roomIndex = SharedPreferencesManger.LoadIntegerData(this, "roomIndex");
        mHOtelCode = SharedPreferencesManger.LoadStringData(this, "mHotel_code");


        arrayOfGuest = new ArrayOfGuest();
        Guest guest = new Guest();
        guest.Title = "Mr";
        guest.Age = 25;
        guest.FirstName = SharedPreferencesManger.LoadStringData(this, "firstName");
        guest.LeadGuest = true;
        guest.GuestType = Enums.GuestType.Adult;
        guest.LastName = SharedPreferencesManger.LoadStringData(this, "lastName");
        guest.GuestInRoom = 1;
        arrayOfGuest.add(guest);
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


            String arraySupp = SharedPreferencesManger.LoadStringData(this, "suppArray");
            ArrayOfSupplement arrayOfSupplement = gson.fromJson(arraySupp, ArrayOfSupplement.class);
            boolean atProperty = false;
            if (arrayOfSupplement != null) {
                for (Supplement supplement : arrayOfSupplement) {
                    if (supplement.SuppIsMandatory) {
                        atProperty = supplement.SuppChargeType.getCode() == Enums.SuppChargeType.AtProperty.getCode();

                    }
                }
                String reqRoomString = SharedPreferencesManger.LoadStringData(this, "arrayOfroomsreq");

                arrayOfRooms = gson.fromJson(reqRoomString, ArrayOfRequestedRooms.class);
                if (atProperty) {

                    RequestedRooms requestedRooms = arrayOfRooms.get(0);
                    if (requestedRooms.Supplements != null) {
                        for (SuppInfo suppInfo : requestedRooms.Supplements) {
                            suppInfo.SuppChargeType = Enums.SuppChargeType.AtProperty;
                        }
                    }
                }


            }
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

            AmendmentResponse amendmentResponse = service.Amendment(amendmentRequestType, hotelBookingResponse.BookingId, amendInformation, hotelBookingResponse.ConfirmationNo, authenticandata);
//            HotelCancelResponse hotelCancelResponse = service.HotelCancel(hotelBookingResponse.BookingId, Enums.CancelRequestType.HotelCancel, "Test", hotelBookingResponse.ConfirmationNo, authenticandata);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
