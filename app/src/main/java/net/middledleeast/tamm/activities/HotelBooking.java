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
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;
import net.middledleeast.tamm.model.AllLinks.LinksUrl;

import java.util.HashMap;
import java.util.Map;

public class HotelBooking extends AppCompatActivity {

    private AuthenticationData authenticandata;
    private BasicHttpBinding_IHotelService1 service;
    private Button backToMain;
    private RelativeLayout backButton;
    ImageView iv_booked_booking;
//    private String send_best_Hotel_data = "http://egyptgoogle.com/backend/besthotelbooking/inserthotelbooking.php";
//    private String send_best_Flight_data = "http://egyptgoogle.com/backend/bestflightbooking/insertflightbooking.php";
    private String price;
    private String hotelName_;
    private String country_;
    private String takeoff  , airplane,from_airport,to_airport, priceflight,landing;
    private String first_name;
    TextView tv_guest_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_booking);
        backToMain = findViewById(R.id.back_to_main);
        TextView code = findViewById(R.id.tv_code);
        iv_booked_booking=findViewById(R.id.iv_booked_booking);
        tv_guest_name=findViewById(R.id.tv_guest_name);

        first_name = SharedPreferencesManger.LoadStringData(this, "firstName1GustOne");
        country_ = SharedPreferencesManger.LoadStringData(HotelBooking.this, "country_");
        hotelName_ = SharedPreferencesManger.LoadStringData(HotelBooking.this, "hotelName_");
        price = SharedPreferencesManger.LoadStringData(HotelBooking.this, "price");


        airplane = SharedPreferencesManger.LoadStringData(HotelBooking.this, "airplane");
        from_airport = SharedPreferencesManger.LoadStringData(HotelBooking.this, "from_airport");
        to_airport = SharedPreferencesManger.LoadStringData(HotelBooking.this, "to_airport");
        priceflight = SharedPreferencesManger.LoadStringData(HotelBooking.this, "price");
        landing = SharedPreferencesManger.LoadStringData(HotelBooking.this, "landing");
        takeoff = SharedPreferencesManger.LoadStringData(HotelBooking.this, "takeoff");

        tv_guest_name.setText(first_name);

        sendBestHotelBooked();
        sendBestFlightBooked();
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

            HotelBookingDetailResponse hotelBookingDetailResponse = service.HotelBookingDetail(BookingId, confirmationNo, clientReferenceNo, authenticandata);
            ResponseStatus status = hotelBookingDetailResponse.Status;
            String statuscODE = status.StatusCode;


            String confirmationNo1 = hotelBookingDetailResponse.BookingDetail.ConfirmationNo;

            code.setText(confirmationNo1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(HotelBooking.this, RoomBooked.class));

    }

    private void sendBestHotelBooked() {

        StringRequest request = new StringRequest(Request.Method.POST, LinksUrl.SEND_BEST_HOTEL_DATA, new Response.Listener<String>() {

            @Override

            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }

        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("name",hotelName_);
                parameters.put("country",country_);
                parameters.put("price", price);


                return parameters;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(HotelBooking.this);
        requestQueue.add(request);

    }

    private void sendBestFlightBooked() {

        StringRequest request = new StringRequest(Request.Method.POST, LinksUrl.SEND_BEST_FLIGHT_DATA, new Response.Listener<String>() {

            @Override

            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }

        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("airplane",airplane);
                parameters.put("fromairport",from_airport);
                parameters.put("toairport", to_airport);
                parameters.put("price", priceflight);
                parameters.put("takeoff", takeoff);
                parameters.put("landing", landing);


                return parameters;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(HotelBooking.this);
        requestQueue.add(request);

    }
}
