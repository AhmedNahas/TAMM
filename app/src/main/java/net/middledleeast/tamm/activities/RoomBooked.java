package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.Tamm.Hotels.wcf.ArrayOfGuest;
import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.Enums;
import com.Tamm.Hotels.wcf.Guest;
import com.Tamm.Hotels.wcf.HotelBookResponse;
import com.Tamm.Hotels.wcf.Hotel_Room;
import com.Tamm.Hotels.wcf.PaymentInfo;

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
        sessionId = SharedPreferencesManger.LoadStringData(this, "sessionId");
        noOfRooms = SharedPreferencesManger.LoadIntegerData(this, "noOfRooms");
        resultIndex = SharedPreferencesManger.LoadIntegerData(this, "resultIndex");
        roomIndex = SharedPreferencesManger.LoadIntegerData(this, "roomIndex");
        mHOtelCode = SharedPreferencesManger.LoadStringData(this, "mHOtelCode");
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

        start_time = SharedPreferencesManger.LoadStringData(RoomBooked.this, "start_date");
        end_time = SharedPreferencesManger.LoadStringData(RoomBooked.this, "end_date");
        hotel_name = SharedPreferencesManger.LoadStringData(RoomBooked.this, "hotel_name");

        try {
            DateTime dt = new DateTime();
            DateTimeFormatter fmt = DateTimeFormat.forPattern("ddMMyyhhmmssSSS");
            String dtStr = fmt.print(dt);
            String clientReferenceNo = dtStr + "#TAMM";
            HotelBookResponse hotelBookingResponse = service.HotelBook(start_time, end_time,
                    clientReferenceNo, "EG", arrayOfGuest, null, paymentInfo
                    , sessionId, null, noOfRooms, resultIndex, mHOtelCode, hotel_name, arrayOfRooms, null,
                    null, false, authenticandata);
            SharedPreferencesManger.SaveData(this, "ClientRef", clientReferenceNo);
            SharedPreferencesManger.SaveData(this, "BookingID", hotelBookingResponse.BookingId);
            SharedPreferencesManger.SaveData(this, "ConfirmationNo", hotelBookingResponse.ConfirmationNo);

        } catch (Exception e) {
            e.printStackTrace();
        }

        button = findViewById(R.id.get_code);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoomBooked.this, HotelBooking.class));
            }
        });
    }
}
