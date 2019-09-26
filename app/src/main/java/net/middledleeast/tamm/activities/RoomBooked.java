package net.middledleeast.tamm.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.Tamm.Hotels.wcf.ArrayOfGuest;
import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
import com.Tamm.Hotels.wcf.ArrayOfRoomGuest;
import com.Tamm.Hotels.wcf.ArrayOfSpecialRequest;
import com.Tamm.Hotels.wcf.ArrayOfSupplement;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.Enums;
import com.Tamm.Hotels.wcf.GenerateInvoiceResponse;
import com.Tamm.Hotels.wcf.Guest;
import com.Tamm.Hotels.wcf.HotelBookResponse;
import com.Tamm.Hotels.wcf.Hotel_Room;
import com.Tamm.Hotels.wcf.PaymentInfo;
import com.Tamm.Hotels.wcf.RequestedRooms;
import com.Tamm.Hotels.wcf.SpecialRequest;
import com.Tamm.Hotels.wcf.SuppInfo;
import com.Tamm.Hotels.wcf.Supplement;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;
import net.middledleeast.tamm.model.AllLinks.LinksUrl;
import net.middledleeast.tamm.model.Room.AppDatabase;
import net.middledleeast.tamm.model.Room.RoomCartModel;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RoomBooked extends AppCompatActivity {
    AppDatabase appDatabase;

    ArrayOfGuest arrayOfGuest;
//    @BindView(R.id.assistant_label_voice_booked_hotel)
//    TextView assistantLabelVoiceBookedHotel;
//    @BindView(R.id.assistant_label_call_booked_hotel)
//    TextView assistantLabelCallBookedHotel;
//    @BindView(R.id.assistant_label_message_booked_hotel)
//    TextView assistantLabelMessageBookedHotel;
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
    RequestQueue requestQueue;
    Context context;

//    private static final String SENDBOOKEDHOTEL = "http://egyptgoogle.com/backend/bookingshow/insert.php";


    private Button button;
    private boolean ClickBookedHotel = false;

    ImageView iv_booked_room;
    private String today_date;
    private String name_city_;
    private long nights;
    private String firstName1GustOne;
    private String lastName1GustOne;
    private String roomType;
    private PaymentInfo paymentInfo;
    private String fullName;
    private Integer noOfAdultRoom1;
    private String tripName;
    private String bookedOn;
    private String childAgeRoom1;
    Double childAge1;
    Double childAge2;
    private String email;
    private String userNameFromSignIn;
    private String Until;
    private String specialRequest;
    private String amount_;
    private String transaction_;
    private String result_;
    private String refno_;
    private String postcode_;
    private String paymentid_;
    private String trackid_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roombooked);
        ButterKnife.bind(this);


        amount_ = SharedPreferencesManger.LoadStringData(context, "amount_");
        transaction_ = SharedPreferencesManger.LoadStringData(context, "transaction_");
        result_ = SharedPreferencesManger.LoadStringData(context, "result_");
        refno_ = SharedPreferencesManger.LoadStringData(context, "refno_");
        trackid_ = SharedPreferencesManger.LoadStringData(context, "trackid_");
        paymentid_ = SharedPreferencesManger.LoadStringData(context, "paymentid_");


        iv_booked_room=findViewById(R.id.iv_booked_room);
        iv_booked_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoomBooked.this,MyBookActivity.class);
                startActivity(intent);
            }
        });

        backButton = findViewById(R.id.toolbar_back1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoomBooked.this, ConfirmBookingRoom.class));
            }
        });

//
//        assistantLabelCallBookedHotel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(RoomBooked.this, AssistantActivity.class);
//                startActivity(intent);
//                Toast.makeText(RoomBooked.this, "Call", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        assistantLabelVoiceBookedHotel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent1 = new Intent(RoomBooked.this, VoiceMessageActivity.class);
//                startActivity(intent1);
//                Toast.makeText(RoomBooked.this, "Voice", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        assistantLabelMessageBookedHotel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent2 = new Intent(RoomBooked.this, ContactUs.class);
//                startActivity(intent2);
//                Toast.makeText(RoomBooked.this, "Message", Toast.LENGTH_SHORT).show();
//            }
//        });

        service = new BasicHttpBinding_IHotelService1();
        service.enableLogging = true;
        authenticandata = new AuthenticationData();
        authenticandata.UserName = (getString(R.string.user_name_tamm));
        authenticandata.Password = (getString(R.string.passowrd_tamm));
        requestQueue = Volley.newRequestQueue(this);
        sessionId = SharedPreferencesManger.LoadStringData(this, "session_id");
        noOfRooms = SharedPreferencesManger.LoadIntegerData(this, "noOfRooms");
        resultIndex = SharedPreferencesManger.LoadIntegerData(this, "resultindex");
        roomIndex = SharedPreferencesManger.LoadIntegerData(this, "roomIndex");
        mHOtelCode = SharedPreferencesManger.LoadStringData(this, "mHotel_code");
        today_date = SharedPreferencesManger.LoadStringData(this, "today_date");
        name_city_ = SharedPreferencesManger.LoadStringData(this, "name_city_");
        nights = SharedPreferencesManger.LoadLongData(this, "nights");
        roomType = SharedPreferencesManger.LoadStringData(this, "roomType");
        bookedOn = SharedPreferencesManger.LoadStringData(this, "bookedOn");
        email = SharedPreferencesManger.LoadStringData(this, "email");
        userNameFromSignIn = SharedPreferencesManger.LoadStringData(this, "userNameFromSignIn");
        Until = SharedPreferencesManger.LoadStringData(this, "Until");
        specialRequest = SharedPreferencesManger.LoadStringData(this, "specs");


        arrayOfGuest = new ArrayOfGuest();



        start_time = SharedPreferencesManger.LoadStringData(RoomBooked.this, "start_date");
        end_time = SharedPreferencesManger.LoadStringData(RoomBooked.this, "end_date");
        hotel_name = SharedPreferencesManger.LoadStringData(RoomBooked.this, "hotel_name");
        String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1GustOne");
        String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1GustOne");

        fullName = firstName1GustOne + " "+lastName1GustOne ;

        tripName = firstName1GustOne + "_" + start_time;


// FIXME: 7/31/2019 complete
        noOfAdultRoom1 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom1");
        int noOfAdultRoom2 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom2");
        int noOfAdultRoom3 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom3");
        int noOfAdultRoom4 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom4");

        int noOfChildRoom1 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom1");
        int noOfChildRoom2 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom2");
        int noOfChildRoom3 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom3");
        int noOfChildRoom4 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom4");


        childAgeRoom1 = SharedPreferencesManger.LoadStringData(this, "child_countroom1");
try {

    ArrayList<Double> childAgeRoom1Array = new Gson().fromJson(childAgeRoom1, ArrayList.class);


    if (childAgeRoom1Array.size() == 1) {

        childAge1 = childAgeRoom1Array.get(0);


    } else if (childAgeRoom1Array.size() == 2) {

        childAge1 = childAgeRoom1Array.get(0);

        childAge2 = childAgeRoom1Array.get(1);
    }

}catch (Exception e){
    e.printStackTrace();
}
        String childAgeRoom2 = SharedPreferencesManger.LoadStringData(this, "child_countroom2");
        ArrayList<Integer> childAgeRoom1Array2 = new Gson().fromJson(childAgeRoom2, ArrayList.class);

        String childAgeRoom3 = SharedPreferencesManger.LoadStringData(this, "child_countroom3");
        ArrayList<Integer> childAgeRoom1Array3 = new Gson().fromJson(childAgeRoom3, ArrayList.class);

        String childAgeRoom4 = SharedPreferencesManger.LoadStringData(this, "child_countroom4");
        ArrayList<Integer> childAgeRoom1Array4 = new Gson().fromJson(childAgeRoom4, ArrayList.class);

        ArrayOfRoomGuest arrayOfRoomGuest = new Gson().fromJson(SharedPreferencesManger.LoadStringData(this, "roomGuests"), ArrayOfRoomGuest.class);
        int noOfRooms = SharedPreferencesManger.LoadIntegerData(this, "noOfRooms");

        switch (noOfRooms) {
            case 1:

                adult_1_Room1(noOfAdultRoom1, noOfChildRoom1);



                break;

            case 2:

                adult_1_Room1(noOfAdultRoom1, noOfChildRoom1);
                adult_2_Room2(noOfAdultRoom2, noOfChildRoom2);

                break;


            case 3:

                adult_1_Room1(noOfAdultRoom1, noOfChildRoom1);
                adult_2_Room2(noOfAdultRoom2, noOfChildRoom2);
                adult_3_Room3(noOfAdultRoom3, noOfChildRoom3);

                break;

            case 4:
                adult_1_Room1(noOfAdultRoom1, noOfChildRoom1);
                adult_2_Room2(noOfAdultRoom2, noOfChildRoom2);
                adult_3_Room3(noOfAdultRoom3, noOfChildRoom3);
                adult_4_Room4(noOfAdultRoom4, noOfChildRoom4);
                break;



        }


        // FIXME: 7/31/2019 end
        paymentInfo = new PaymentInfo();
        paymentInfo.VoucherBooking = true;
        paymentInfo.PaymentModeType = Enums.PaymentModeType.Limit;




//        paymentInfo.CvvNumber="500";


        button = findViewById(R.id.get_code);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                showProgressingView();
                bookingresponse(paymentInfo);


                senddataknettoemail();

//                sendDataToEMail(email,"Dear Mr." + userNameFromSignIn
//                        + " , This is your Confirmation No." + confirmationNo
//                        + " , for booking " + hotel_name
//                        + "  in " + name_city_
//                        + " , check in date is : " + start_time
//                        + " and check out date is : " + end_time
//                        + " , No. of Rooms booked is : " + noOfRooms
//                        +  " , your last cancellation date is : " + Until );

//                senddataknettoemail(email,"Dear Mr." + userNameFromSignIn
//
//                        + " , Your Payment Details for Transaction No.  : " + transaction_
//                        + " , Date / Time : " + bookedOn
//                        + " , Status : " + "Success"
//                        + " , Amount : " +amount_ + " KD "
//                        + " , Reference ID : " +refno_
//                        + " , Payment ID : " +paymentid_
//                        + " , Merchant Track ID : " +trackid_
//
//                        );



                startActivity(new Intent(RoomBooked.this, HotelBooking.class));
                finish();

            }
        });

    }

    private void adult_4_Room4(int noOfAdultRoom4, int noOfChildRoom4) {



        if (noOfAdultRoom4 == 1) {


            firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust4");
            lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust4");
            Guest guest = new Guest();
            guest.Title = "Mr";
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);





        } else if (noOfAdultRoom4 == 2) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust4");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust4");
            Guest guest = new Guest();
            guest.Title = getString(R.string.mr);
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust4");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust4");
            Guest guest2 = new Guest();
            guest2.Title = getString(R.string.mr);
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


        } else if (noOfAdultRoom4 == 3) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust4");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust4");
            Guest guest = new Guest();
            guest.Title =  getString(R.string.mr);
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust4");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust4");
            Guest guest2 = new Guest();
            guest2.Title =  getString(R.string.mr);
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


            String firstName3GustOne = SharedPreferencesManger.LoadStringData(this, "firstName3Gust4");
            String lastName3GustOne = SharedPreferencesManger.LoadStringData(this, "lastName3Gust4");
            Guest guest3 = new Guest();
            guest3.Title =  getString(R.string.mr);
            guest3.FirstName = firstName3GustOne;
            guest3.GuestType = Enums.GuestType.Adult;
            guest3.LastName = lastName3GustOne;
            arrayOfGuest.add(guest3);

        } else if (noOfAdultRoom4 == 4) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust4");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust4");
            Guest guest = new Guest();
            guest.Title =  getString(R.string.mr);
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust4");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust4");
            Guest guest2 = new Guest();
            guest2.Title = getString(R.string.mr);
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


            String firstName3GustOne = SharedPreferencesManger.LoadStringData(this, "firstName3Gust4");
            String lastName3GustOne = SharedPreferencesManger.LoadStringData(this, "lastName3Gust4");
            Guest guest3 = new Guest();
            guest3.Title =  getString(R.string.mr);
            guest3.FirstName = firstName3GustOne;
            guest3.GuestType = Enums.GuestType.Adult;
            guest3.LastName = lastName3GustOne;
            arrayOfGuest.add(guest3);

            String firstName4Gust2 = SharedPreferencesManger.LoadStringData(this, "firstName4Gust4");
            String lastName4Gust2 = SharedPreferencesManger.LoadStringData(this, "lastName4Gust4");
            Guest guest4 = new Guest();
            guest4.Title = getString(R.string.mr);
            guest4.FirstName = firstName4Gust2;
            guest4.GuestType = Enums.GuestType.Adult;
            guest4.LastName = lastName4Gust2;
            arrayOfGuest.add(guest4);


        }

        if (noOfChildRoom4 == 1) {
            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGust4");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGust4");


            Guest child1 = new Guest();
            child1.Title =  getString(R.string.mr);
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.LastName = lastName1ChildGustOne;
            arrayOfGuest.add(child1);


        } else if (noOfChildRoom4 == 2) {

            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGust4");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGust4");


            Guest child1 = new Guest();
            child1.Title =  getString(R.string.mr);
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.LastName = lastName1ChildGustOne;
            arrayOfGuest.add(child1);


            String firstName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName2ChildGust4");
            String lastName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName2ChildGust4");

            Guest child2 = new Guest();
            child2.Title =  getString(R.string.mr);
            child2.FirstName = firstName2ChildGustOne;
            child2.GuestType = Enums.GuestType.Child;
            child2.LastName = lastName2ChildGustOne;
            arrayOfGuest.add(child2);


        }



    }

    private void adult_3_Room3(int noOfAdultRoom3, int noOfChildRoom3) {





        if (noOfAdultRoom3 == 1) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust3");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust3");
            Guest guest = new Guest();
            guest.Title =  getString(R.string.mr);
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


        } else if (noOfAdultRoom3 == 2) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust3");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust3");
            Guest guest = new Guest();
            guest.Title =  getString(R.string.mr);
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust3");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust3");
            Guest guest2 = new Guest();
            guest2.Title =  getString(R.string.mr);
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


        } else if (noOfAdultRoom3 == 3) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust3");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust3");
            Guest guest = new Guest();
            guest.Title =  getString(R.string.mr);
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust3");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust3");
            Guest guest2 = new Guest();
            guest2.Title = getString(R.string.mr);
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


            String firstName3GustOne = SharedPreferencesManger.LoadStringData(this, "firstName3Gust3");
            String lastName3GustOne = SharedPreferencesManger.LoadStringData(this, "lastName3Gust3");
            Guest guest3 = new Guest();
            guest3.Title =  getString(R.string.mr);
            guest3.FirstName = firstName3GustOne;
            guest3.GuestType = Enums.GuestType.Adult;
            guest3.LastName = lastName3GustOne;
            arrayOfGuest.add(guest3);

        } else if (noOfAdultRoom3 == 4) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust3");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust3");
            Guest guest = new Guest();
            guest.Title =  getString(R.string.mr);
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust3");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust3");
            Guest guest2 = new Guest();
            guest2.Title =  getString(R.string.mr);
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


            String firstName3GustOne = SharedPreferencesManger.LoadStringData(this, "firstName3Gust3");
            String lastName3GustOne = SharedPreferencesManger.LoadStringData(this, "lastName3Gust3");
            Guest guest3 = new Guest();
            guest3.Title =  getString(R.string.mr);
            guest3.FirstName = firstName3GustOne;
            guest3.GuestType = Enums.GuestType.Adult;
            guest3.LastName = lastName3GustOne;
            arrayOfGuest.add(guest3);

            String firstName4Gust2 = SharedPreferencesManger.LoadStringData(this, "firstName4Gust3");
            String lastName4Gust2 = SharedPreferencesManger.LoadStringData(this, "lastName4Gust3");
            Guest guest4 = new Guest();
            guest4.Title = getString(R.string.mr);
            guest4.FirstName = firstName4Gust2;
            guest4.GuestType = Enums.GuestType.Adult;
            guest4.LastName = lastName4Gust2;
            arrayOfGuest.add(guest4);


        }

        if (noOfChildRoom3 == 1) {
            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGust3");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGust3");


            Guest child1 = new Guest();
            child1.Title =  getString(R.string.mr);
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.LastName = lastName1ChildGustOne;
            arrayOfGuest.add(child1);


        } else if (noOfChildRoom3 == 2) {

            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGust3");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGust3");


            Guest child1 = new Guest();
            child1.Title =  getString(R.string.mr);
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.LastName = lastName1ChildGustOne;
            arrayOfGuest.add(child1);


            String firstName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName2ChildGust3");
            String lastName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName2ChildGust3");

            Guest child2 = new Guest();
            child2.Title =  getString(R.string.mr);
            child2.FirstName = firstName2ChildGustOne;
            child2.GuestType = Enums.GuestType.Child;
            child2.LastName = lastName2ChildGustOne;
            arrayOfGuest.add(child2);


        }



    }

    private void adult_2_Room2(int noOfAdultRoom2, int noOfChildRoom2) {

        if (noOfAdultRoom2 == 1) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust2");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust2");
            Guest guest = new Guest();
            guest.Title =  getString(R.string.mr);
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            guest.GuestInRoom = 2;
            arrayOfGuest.add(guest);


        } else if (noOfAdultRoom2 == 2) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust2");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust2");
            Guest guest = new Guest();
            guest.Title =  getString(R.string.mr);
            guest.GuestInRoom = 2;

            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust2");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust2");
            Guest guest2 = new Guest();
            guest2.Title =  getString(R.string.mr);
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            guest2.GuestInRoom = 2;

            arrayOfGuest.add(guest2);


        } else if (noOfAdultRoom2 == 3) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust2");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust2");
            Guest guest = new Guest();
            guest.Title =  getString(R.string.mr);
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            guest.GuestInRoom = 2;

            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust2");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust2");
            Guest guest2 = new Guest();
            guest2.Title =  getString(R.string.mr);
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.GuestInRoom = 2;

            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


            String firstName3GustOne = SharedPreferencesManger.LoadStringData(this, "firstName3Gust2");
            String lastName3GustOne = SharedPreferencesManger.LoadStringData(this, "lastName3Gust2");
            Guest guest3 = new Guest();
            guest3.Title =  getString(R.string.mr);
            guest3.FirstName = firstName3GustOne;
            guest3.GuestType = Enums.GuestType.Adult;
            guest3.LastName = lastName3GustOne;
            guest3.GuestInRoom = 2;

            arrayOfGuest.add(guest3);

        } else if (noOfAdultRoom2 == 4) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust2");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust2");
            Guest guest = new Guest();
            guest.Title =  getString(R.string.mr);
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            guest.GuestInRoom = 2;

            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust2");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust2");
            Guest guest2 = new Guest();
            guest2.Title =  getString(R.string.mr);
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            guest2.GuestInRoom = 2;

            arrayOfGuest.add(guest2);


            String firstName3GustOne = SharedPreferencesManger.LoadStringData(this, "firstName3Gust2");
            String lastName3GustOne = SharedPreferencesManger.LoadStringData(this, "lastName3Gust2");
            Guest guest3 = new Guest();
            guest3.Title =  getString(R.string.mr);
            guest3.FirstName = firstName3GustOne;
            guest3.GuestType = Enums.GuestType.Adult;
            guest3.LastName = lastName3GustOne;
            guest3.GuestInRoom = 2;

            arrayOfGuest.add(guest3);

            String firstName4Gust2 = SharedPreferencesManger.LoadStringData(this, "firstName4Gust2");
            String lastName4Gust2 = SharedPreferencesManger.LoadStringData(this, "lastName4Gust2");
            Guest guest4 = new Guest();
            guest4.Title =  getString(R.string.mr);
            guest4.FirstName = firstName4Gust2;
            guest4.GuestType = Enums.GuestType.Adult;
            guest4.LastName = lastName4Gust2;
            guest4.GuestInRoom = 2;

            arrayOfGuest.add(guest4);


        }

        if (noOfChildRoom2 == 1) {
            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGust2");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGust2");


            Guest child1 = new Guest();
            child1.Title =  getString(R.string.mr);
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.LastName = lastName1ChildGustOne;
            child1.GuestInRoom = 2;

            arrayOfGuest.add(child1);


        } else if (noOfChildRoom2 == 2) {

            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGust2");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGust2");


            Guest child1 = new Guest();
            child1.Title =  getString(R.string.mr);
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.LastName = lastName1ChildGustOne;
            child1.GuestInRoom = 2;

            arrayOfGuest.add(child1);


            String firstName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName2ChildGust2");
            String lastName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName2ChildGust2");

            Guest child2 = new Guest();
            child2.Title =  getString(R.string.mr);
            child2.FirstName = firstName2ChildGustOne;
            child2.GuestType = Enums.GuestType.Child;
            child2.LastName = lastName2ChildGustOne;
            child2.GuestInRoom = 2;

            arrayOfGuest.add(child2);


        }


    }

    private void adult_1_Room1(int noOfAdultRoom1, int noOfChildRoom1) {


        if (noOfAdultRoom1 == 1) {

            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1GustOne");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1GustOne");

            Guest guest = new Guest();
            guest.LeadGuest = true;
            guest.LeadGuest = true;
            guest.Title =  getString(R.string.mr);
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.GuestInRoom = 1;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


        } else if (noOfAdultRoom1 == 2) {
            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1GustOne");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1GustOne");

            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2GustOne");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2GustOne");
            Guest guest1 = new Guest();
            guest1.LeadGuest = true;
            guest1.LeadGuest = true;
            guest1.Title =  getString(R.string.mr);
            guest1.GuestInRoom = 1;

            guest1.FirstName = firstName1GustOne;
            guest1.GuestType = Enums.GuestType.Adult;
            guest1.LastName = lastName1GustOne;
            arrayOfGuest.add(guest1);

            Guest guest2 = new Guest();
            guest2.Title =  getString(R.string.mr);
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            guest2.GuestInRoom = 1;

            arrayOfGuest.add(guest2);


        } else if (noOfAdultRoom1 == 3) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1GustOne");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1GustOne");

            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2GustOne");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2GustOne");

            String firstName3GustOne = SharedPreferencesManger.LoadStringData(this, "firstName3GustOne");
            String lastName3GustOne = SharedPreferencesManger.LoadStringData(this, "lastName3GustOne");
            Guest guest1 = new Guest();
            guest1.LeadGuest = true;
            guest1.LeadGuest = true;
            guest1.Title =  getString(R.string.mr);
            guest1.FirstName = firstName1GustOne;
            guest1.GuestType = Enums.GuestType.Adult;
            guest1.LastName = lastName1GustOne;
            guest1.GuestInRoom = 1;

            arrayOfGuest.add(guest1);

            Guest guest2 = new Guest();
            guest2.Title =  getString(R.string.mr);
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            guest2.GuestInRoom = 1;

            arrayOfGuest.add(guest2);


            Guest guest3 = new Guest();
            guest3.Title =  getString(R.string.mr);
            guest3.FirstName = firstName3GustOne;
            guest3.GuestType = Enums.GuestType.Adult;
            guest3.LastName = lastName3GustOne;
            guest3.GuestInRoom = 1;

            arrayOfGuest.add(guest3);


        } else if (noOfAdultRoom1 == 4) {

            adult_4_Room1();
        }

        if (noOfChildRoom1 == 1) {
            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGustOne");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGustOne");


            Guest child1 = new Guest();
            child1.Title =  getString(R.string.mr);
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.Age = (int)Math.round(childAge1);
            child1.LastName = lastName1ChildGustOne;
            child1.GuestInRoom = 1;

            arrayOfGuest.add(child1);


        } else if (noOfChildRoom1 == 2) {

            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGustOne");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGustOne");


            Guest child1 = new Guest();
            child1.Title = getString(R.string.mr);
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.Age = (int)Math.round(childAge1);
            child1.LastName = lastName1ChildGustOne;
            child1.GuestInRoom = 1;
            arrayOfGuest.add(child1);


            String firstName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName2ChildGustOne");
            String lastName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName2ChildGustOne");

            Guest child2 = new Guest();
            child2.Title =  getString(R.string.mr);
            child2.FirstName = firstName2ChildGustOne;
            child2.GuestType = Enums.GuestType.Child;
            child2.Age = (int)Math.round(childAge2);
            child2.LastName = lastName2ChildGustOne;
            child2.GuestInRoom = 1;

            arrayOfGuest.add(child2);


        }


    }

    private void adult_4_Room1() {


        String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1GustOne");
        String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1GustOne");

        String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2GustOne");
        String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2GustOne");

        String firstName3GustOne = SharedPreferencesManger.LoadStringData(this, "firstName3GustOne");
        String lastName3GustOne = SharedPreferencesManger.LoadStringData(this, "lastName3GustOne");


        String firstName4GustOne = SharedPreferencesManger.LoadStringData(this, "firstName4GustOne");
        String lastName4GustOne = SharedPreferencesManger.LoadStringData(this, "lastName4GustOne");


        Guest guest1 = new Guest();
        guest1.LeadGuest = true;
        guest1.LeadGuest = true;
        guest1.Title =  getString(R.string.mr);
        guest1.FirstName = firstName1GustOne;
        guest1.GuestType = Enums.GuestType.Adult;
        guest1.LastName = lastName1GustOne;
        guest1.GuestInRoom = 1;

        guest1.GuestInRoom = 1;

        arrayOfGuest.add(guest1);

        Guest guest2 = new Guest();
        guest2.Title =  getString(R.string.mr);
        guest2.FirstName = firstName2GustOne;
        guest2.GuestType = Enums.GuestType.Adult;
        guest2.LastName = lastName2GustOne;
        guest2.GuestInRoom = 1;

        arrayOfGuest.add(guest2);


        Guest guest3 = new Guest();
        guest3.Title = getString(R.string.mr);
        guest3.FirstName = firstName3GustOne;
        guest3.GuestType = Enums.GuestType.Adult;
        guest3.LastName = lastName3GustOne;
        guest3.GuestInRoom = 1;

        arrayOfGuest.add(guest3);


        Guest guest4 = new Guest();
        guest4.Title =  getString(R.string.mr);
        guest4.FirstName = firstName4GustOne;
        guest4.GuestType = Enums.GuestType.Adult;
        guest4.LastName = lastName4GustOne;
        guest4.GuestInRoom = 1;

        arrayOfGuest.add(guest4);

    }


    @OnClick(R.id.relative_img_hotel_booked_tamm)
    public void onViewClicked() {

//        if (ClickBookedHotel == false) {
//            assistantLabelCallBookedHotel.setVisibility(View.VISIBLE);
//            assistantLabelMessageBookedHotel.setVisibility(View.VISIBLE);
//            assistantLabelVoiceBookedHotel.setVisibility(View.VISIBLE);
//            ClickBookedHotel = true;
//
//        } else {
//            assistantLabelCallBookedHotel.setVisibility(View.INVISIBLE);
//            assistantLabelMessageBookedHotel.setVisibility(View.INVISIBLE);
//            assistantLabelVoiceBookedHotel.setVisibility(View.INVISIBLE);
//            ClickBookedHotel = false;
//
//        }

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

                            // get room type name
                            String roomTypeName = requestedRooms.RoomTypeName;
                            suppInfo.SuppChargeType = Enums.SuppChargeType.AtProperty;
                        }
                    }
                }


            }

            //   SharedPreferencesManger.SaveData(this, "arrayOfroomsreq", null);

            ArrayOfSpecialRequest specialRequests = new ArrayOfSpecialRequest();
            SpecialRequest specialReques = new SpecialRequest();
            specialReques.RequestType = specialRequest;
            specialRequests.add(specialReques);

            String clientReferenceNo = dtStr + "#TAMM";
            SharedPreferencesManger.SaveData(this, "ClientRef", clientReferenceNo);
            String nationality = SharedPreferencesManger.LoadStringData(RoomBooked.this,"nationality");

            HotelBookResponse hotelBookingResponse = service.HotelBook(start_time, end_time,
                    clientReferenceNo, nationality, arrayOfGuest, null, paymentInfo
                    , sessionId, null, noOfRooms, resultIndex, mHOtelCode, hotel_name, arrayOfRooms, specialRequests,
                    null, true, authenticandata);



            int bookingId = hotelBookingResponse.BookingId;
            String confirmationNo = hotelBookingResponse.ConfirmationNo;
            String statusCode = hotelBookingResponse.Status.StatusCode;

            if( statusCode.contains("01")){
                connectdatabase(confirmationNo,bookingId);
                sendDataToEMail(confirmationNo);

//                GenerateInvoiceResponse generateInvoiceResponse = service.GenerateInvoice(bookingId, confirmationNo, paymentInfo, authenticandata);
//                String invoiceNo = generateInvoiceResponse.InvoiceNo;


                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myBooking").fallbackToDestructiveMigration().allowMainThreadQueries().build();


                String untile = SharedPreferencesManger.LoadStringData(this, "Until");

                String imgHotelOne = SharedPreferencesManger.LoadStringData(this, "imageHotel");


                RoomCartModel roomCartModel=new RoomCartModel(untile ,imgHotelOne ,start_time,end_time,String.valueOf(bookingId),confirmationNo,
                        String.valueOf(resultIndex),hotel_name,bookedOn,"vouched",tripName,fullName,noOfAdultRoom1,name_city_);

                appDatabase.cartDao().addoffer(roomCartModel);

                Toast.makeText(RoomBooked.this, "Added To Your Bookings", Toast.LENGTH_SHORT).show();





                SharedPreferencesManger.SaveData(this, "BookingID", hotelBookingResponse.BookingId);
                SharedPreferencesManger.SaveData(this, "ConfirmationNo", confirmationNo);



            }else{

                Toast.makeText(this, "Failed"+hotelBookingResponse.Status.Description, Toast.LENGTH_SHORT).show();
            }







//            AmendmentResponse amendmentResponse = service.Amendment(amendmentRequestType, hotelBookingResponse.BookingId, amendInformation, hotelBookingResponse.ConfirmationNo, authenticandata);
////this is to cancel request

            // HotelCancelResponse hotelCancelResponse = service.HotelCancel(hotelBookingResponse.BookingId, Enums.CancelRequestType.HotelCancel, "Test", hotelBookingResponse.ConfirmationNo, authenticandata);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void connectdatabase(String confirmationNo, int bookingId) {

            StringRequest request = new StringRequest(Request.Method.POST, LinksUrl.URL_SEND_BOOKED_HOTEL, new Response.Listener<String>() {

                @Override

                public void onResponse(String response) {

                    Toast.makeText(RoomBooked.this, "Booked", Toast.LENGTH_SHORT).show();

                    Log.e("HI", "onResponse: " + response);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("HI", "onResponse: " + error);


                }


            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parameters = new HashMap<String, String>();
                    parameters.put("checkin", start_time);
                    parameters.put("checkout", end_time);
                    parameters.put("booked", today_date);
                    parameters.put("lead", fullName);
                    parameters.put("typeroom", roomType);
                    parameters.put("noofroom", String.valueOf(noOfRooms));
                    parameters.put("noofguest", String.valueOf(noOfAdultRoom1));
                    parameters.put("hotelname", hotel_name);
                    parameters.put("city", name_city_);
                    parameters.put("tbohconfno", confirmationNo);
                    parameters.put("tripid", String.valueOf(bookingId));
                    parameters.put("tripname", tripName);
                    parameters.put("booking", "Vouched");
                    parameters.put("nights", String.valueOf(nights));


                    return parameters;

                }
            };
            requestQueue.add(request);

        }
    ViewGroup progressView;
    protected boolean isProgressShowing = false;

    public void showProgressingView() {

        if (!isProgressShowing) {
            isProgressShowing = true;
            progressView = (ViewGroup) getLayoutInflater().inflate(R.layout.progressbar_layout, null);
            View v = this.findViewById(android.R.id.content).getRootView();
            ViewGroup viewGroup = (ViewGroup) v;
            viewGroup.addView(progressView);
        }
    }

    public void hideProgressingView() {
        View v = this.findViewById(android.R.id.content).getRootView();
        ViewGroup viewGroup = (ViewGroup) v;
        viewGroup.removeView(progressView);
        isProgressShowing = false;
    }

    public void sendDataToEMail(String confirmationNo){

        StringRequest request = new StringRequest(Request.Method.POST, LinksUrl.URL_SENT_TO_EMAIL, new com.android.volley.Response.Listener<String>() {

            @Override

            public void onResponse(String response) {




                try {
                    JSONObject jObj = new JSONObject(response);
                    int status = jObj.getInt("msg");
                    String msg = jObj.getString("success");

                    Toast.makeText(RoomBooked.this, ""+msg, Toast.LENGTH_SHORT).show();

                }catch (Exception  e){}



            }

        }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {


            }

        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("mail_to", email);
                parameters.put("name",fullName );
                parameters.put("confno",confirmationNo );
                parameters.put("hotelname",hotel_name );
                parameters.put("cityname",name_city_ );
                parameters.put("checkin", start_time);
                parameters.put("checkout", end_time);
                parameters.put("canceldate", Until);




                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }


    public void senddataknettoemail(){

        StringRequest request = new StringRequest(Request.Method.POST, LinksUrl.URL_SENT_KNET_TO_EMAIL, new com.android.volley.Response.Listener<String>() {

            @Override

            public void onResponse(String response) {




                try {
                    JSONObject jObj = new JSONObject(response);
                    int status = jObj.getInt("msg");
                    String msg = jObj.getString("success");

                    Toast.makeText(RoomBooked.this, ""+msg, Toast.LENGTH_SHORT).show();

                }catch (Exception  e){}

            }


        }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                int statusCode = error.networkResponse.statusCode;

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("mail_to", email);
                parameters.put("name", fullName);
                parameters.put("transid", transaction_);
                parameters.put("cityname", name_city_);
                parameters.put("amount", amount_);
                parameters.put("refno", refno_);
                parameters.put("paymentid", paymentid_);
                parameters.put("trackid", trackid_);
                parameters.put("time", bookedOn);



                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);



    }






}
