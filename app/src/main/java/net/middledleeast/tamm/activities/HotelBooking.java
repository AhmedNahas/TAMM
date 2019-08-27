package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.Enums;
import com.Tamm.Hotels.wcf.HotelBookingDetailResponse;
import com.Tamm.Hotels.wcf.ResponseStatus;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

public class HotelBooking extends AppCompatActivity {

    private AuthenticationData authenticandata;
    private BasicHttpBinding_IHotelService1 service;
    private Button backToMain;
    private RelativeLayout backButton;
    ImageView iv_booked_booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_booking);
        backToMain = findViewById(R.id.back_to_main);
        TextView code = findViewById(R.id.tv_code);
        iv_booked_booking=findViewById(R.id.iv_booked_booking);

        iv_booked_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HotelBooking.this,MyBookActivity.class);
                startActivity(intent);

            }
        });

        backButton=findViewById(R.id.toolbar_back1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(HotelBooking.this, RoomBooked.class));
            }
        });
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HotelBooking.this, RenewAccount.class));
            }
        });
        service = new BasicHttpBinding_IHotelService1();
        service.enableLogging = true;
        authenticandata = new AuthenticationData();
        authenticandata.UserName = (getString(R.string.user_name_tamm));
        authenticandata.Password = (getString(R.string.passowrd_tamm));
        int BookingId = SharedPreferencesManger.LoadIntegerData(this, "BookingID");
        String clientReferenceNo = SharedPreferencesManger.LoadStringData(this, "ClientRef");
        String confirmationNo = SharedPreferencesManger.LoadStringData(this, "ConfirmationNo");
        try {
            Enums.CancelRequestType cancelRequestType = Enums.CancelRequestType.HotelCancel;
//            HotelCancelResponse hotelCancelResponse = service.HotelCancel(BookingId,cancelRequestType , "Testing", confirmationNo, authenticandata);

            HotelBookingDetailResponse hotelBookingDetailResponse = service.HotelBookingDetail(BookingId, null, clientReferenceNo, authenticandata);
            ResponseStatus status = hotelBookingDetailResponse.Status;
            String statuscODE = status.StatusCode;


            code.setText(confirmationNo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(HotelBooking.this, RoomBooked.class));

    }
}
