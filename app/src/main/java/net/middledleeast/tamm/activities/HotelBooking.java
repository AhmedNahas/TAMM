package net.middledleeast.tamm.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.HotelBookingDetailResponse;
import com.Tamm.Hotels.wcf.ResponseStatus;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

public class HotelBooking extends AppCompatActivity {

    private AuthenticationData authenticandata;
    private BasicHttpBinding_IHotelService1 service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_booking);
        service = new BasicHttpBinding_IHotelService1();
        service.enableLogging = true;
        authenticandata = new AuthenticationData();
        authenticandata.UserName = ("Tammtest");
        authenticandata.Password = ("Tam@18418756");
        int BookingId = SharedPreferencesManger.LoadIntegerData(this, "BookingID");
        String clientReferenceNo = SharedPreferencesManger.LoadStringData(this, "ClientRef");
        String confirmationNo = SharedPreferencesManger.LoadStringData(this, "ConfirmationNo");
        try {
            HotelBookingDetailResponse hotelBookingDetailResponse = service.HotelBookingDetail(BookingId, confirmationNo, clientReferenceNo, authenticandata);
            ResponseStatus status = hotelBookingDetailResponse.Status;
            String statuscODE = status.StatusCode;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
