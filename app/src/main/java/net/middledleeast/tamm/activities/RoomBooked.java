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
import com.Tamm.Hotels.wcf.ResponseStatus;
import com.Tamm.Hotels.wcf.RoomGuest;
import com.Tamm.Hotels.wcf.SuppInfo;
import com.Tamm.Hotels.wcf.Supplement;
import com.google.gson.Gson;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
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
    private boolean ClickBookedHotel = false;

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
        arrayOfGuest = new ArrayOfGuest();

// FIXME: 7/31/2019 complete
        int noOfAdultRoom1 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom1");
        int noOfAdultRoom2 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom2");
        int noOfAdultRoom3 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom3");
        int noOfAdultRoom4 = SharedPreferencesManger.LoadIntegerData(this, "no_adultroom4");
        int noOfChildRoom1 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom1");
        int noOfChildRoom2 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom2");
        int noOfChildRoom3 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom3");
        int noOfChildRoom4 = SharedPreferencesManger.LoadIntegerData(this, "no_childroom4");


        String childAgeRoom1 = SharedPreferencesManger.LoadStringData(this, "child_countroom1");
        ArrayList<Integer> childAgeRoom1Array = new Gson().fromJson(childAgeRoom1, ArrayList.class);
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

    private void adult_4_Room4(int noOfAdultRoom4, int noOfChildRoom4) {



        if (noOfAdultRoom4 == 1) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust4");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust4");
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
            guest.Title = "Mr";
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust4");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust4");
            Guest guest2 = new Guest();
            guest2.Title = "Mr";
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


        } else if (noOfAdultRoom4 == 3) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust4");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust4");
            Guest guest = new Guest();
            guest.Title = "Mr";
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust4");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust4");
            Guest guest2 = new Guest();
            guest2.Title = "Mr";
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


            String firstName3GustOne = SharedPreferencesManger.LoadStringData(this, "firstName3Gust4");
            String lastName3GustOne = SharedPreferencesManger.LoadStringData(this, "lastName3Gust4");
            Guest guest3 = new Guest();
            guest3.Title = "Mr";
            guest3.FirstName = firstName3GustOne;
            guest3.GuestType = Enums.GuestType.Adult;
            guest3.LastName = lastName3GustOne;
            arrayOfGuest.add(guest3);

        } else if (noOfAdultRoom4 == 4) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust4");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust4");
            Guest guest = new Guest();
            guest.Title = "Mr";
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust4");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust4");
            Guest guest2 = new Guest();
            guest2.Title = "Mr";
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


            String firstName3GustOne = SharedPreferencesManger.LoadStringData(this, "firstName3Gust4");
            String lastName3GustOne = SharedPreferencesManger.LoadStringData(this, "lastName3Gust4");
            Guest guest3 = new Guest();
            guest3.Title = "Mr";
            guest3.FirstName = firstName3GustOne;
            guest3.GuestType = Enums.GuestType.Adult;
            guest3.LastName = lastName3GustOne;
            arrayOfGuest.add(guest3);

            String firstName4Gust2 = SharedPreferencesManger.LoadStringData(this, "firstName4Gust4");
            String lastName4Gust2 = SharedPreferencesManger.LoadStringData(this, "lastName4Gust4");
            Guest guest4 = new Guest();
            guest4.Title = "Mr";
            guest4.FirstName = firstName4Gust2;
            guest4.GuestType = Enums.GuestType.Adult;
            guest4.LastName = lastName4Gust2;
            arrayOfGuest.add(guest4);


        }

        if (noOfChildRoom4 == 1) {
            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGust4");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGust4");


            Guest child1 = new Guest();
            child1.Title = "Mr";
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.LastName = lastName1ChildGustOne;
            arrayOfGuest.add(child1);


        } else if (noOfChildRoom4 == 2) {

            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGust4");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGust4");


            Guest child1 = new Guest();
            child1.Title = "Mr";
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.LastName = lastName1ChildGustOne;
            arrayOfGuest.add(child1);


            String firstName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName2ChildGust4");
            String lastName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName2ChildGust4");

            Guest child2 = new Guest();
            child2.Title = "Mr";
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
            guest.Title = "Mr";
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


        } else if (noOfAdultRoom3 == 2) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust3");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust3");
            Guest guest = new Guest();
            guest.Title = "Mr";
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust3");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust3");
            Guest guest2 = new Guest();
            guest2.Title = "Mr";
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


        } else if (noOfAdultRoom3 == 3) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust3");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust3");
            Guest guest = new Guest();
            guest.Title = "Mr";
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust3");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust3");
            Guest guest2 = new Guest();
            guest2.Title = "Mr";
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


            String firstName3GustOne = SharedPreferencesManger.LoadStringData(this, "firstName3Gust3");
            String lastName3GustOne = SharedPreferencesManger.LoadStringData(this, "lastName3Gust3");
            Guest guest3 = new Guest();
            guest3.Title = "Mr";
            guest3.FirstName = firstName3GustOne;
            guest3.GuestType = Enums.GuestType.Adult;
            guest3.LastName = lastName3GustOne;
            arrayOfGuest.add(guest3);

        } else if (noOfAdultRoom3 == 4) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust3");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust3");
            Guest guest = new Guest();
            guest.Title = "Mr";
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust3");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust3");
            Guest guest2 = new Guest();
            guest2.Title = "Mr";
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


            String firstName3GustOne = SharedPreferencesManger.LoadStringData(this, "firstName3Gust3");
            String lastName3GustOne = SharedPreferencesManger.LoadStringData(this, "lastName3Gust3");
            Guest guest3 = new Guest();
            guest3.Title = "Mr";
            guest3.FirstName = firstName3GustOne;
            guest3.GuestType = Enums.GuestType.Adult;
            guest3.LastName = lastName3GustOne;
            arrayOfGuest.add(guest3);

            String firstName4Gust2 = SharedPreferencesManger.LoadStringData(this, "firstName4Gust3");
            String lastName4Gust2 = SharedPreferencesManger.LoadStringData(this, "lastName4Gust3");
            Guest guest4 = new Guest();
            guest4.Title = "Mr";
            guest4.FirstName = firstName4Gust2;
            guest4.GuestType = Enums.GuestType.Adult;
            guest4.LastName = lastName4Gust2;
            arrayOfGuest.add(guest4);


        }

        if (noOfChildRoom3 == 1) {
            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGust3");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGust3");


            Guest child1 = new Guest();
            child1.Title = "Mr";
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.LastName = lastName1ChildGustOne;
            arrayOfGuest.add(child1);


        } else if (noOfChildRoom3 == 2) {

            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGust3");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGust3");


            Guest child1 = new Guest();
            child1.Title = "Mr";
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.LastName = lastName1ChildGustOne;
            arrayOfGuest.add(child1);


            String firstName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName2ChildGust3");
            String lastName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName2ChildGust3");

            Guest child2 = new Guest();
            child2.Title = "Mr";
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
            guest.Title = "Mr";
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


        } else if (noOfAdultRoom2 == 2) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust2");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust2");
            Guest guest = new Guest();
            guest.Title = "Mr";
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust2");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust2");
            Guest guest2 = new Guest();
            guest2.Title = "Mr";
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


        } else if (noOfAdultRoom2 == 3) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust2");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust2");
            Guest guest = new Guest();
            guest.Title = "Mr";
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust2");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust2");
            Guest guest2 = new Guest();
            guest2.Title = "Mr";
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


            String firstName3GustOne = SharedPreferencesManger.LoadStringData(this, "firstName3Gust2");
            String lastName3GustOne = SharedPreferencesManger.LoadStringData(this, "lastName3Gust2");
            Guest guest3 = new Guest();
            guest3.Title = "Mr";
            guest3.FirstName = firstName3GustOne;
            guest3.GuestType = Enums.GuestType.Adult;
            guest3.LastName = lastName3GustOne;
            arrayOfGuest.add(guest3);

        } else if (noOfAdultRoom2 == 4) {


            String firstName1GustOne = SharedPreferencesManger.LoadStringData(this, "firstName1Gust2");
            String lastName1GustOne = SharedPreferencesManger.LoadStringData(this, "lastName1Gust2");
            Guest guest = new Guest();
            guest.Title = "Mr";
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
            guest.LastName = lastName1GustOne;
            arrayOfGuest.add(guest);


            String firstName2GustOne = SharedPreferencesManger.LoadStringData(this, "firstName2Gust2");
            String lastName2GustOne = SharedPreferencesManger.LoadStringData(this, "lastName2Gust2");
            Guest guest2 = new Guest();
            guest2.Title = "Mr";
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;
            arrayOfGuest.add(guest2);


            String firstName3GustOne = SharedPreferencesManger.LoadStringData(this, "firstName3Gust2");
            String lastName3GustOne = SharedPreferencesManger.LoadStringData(this, "lastName3Gust2");
            Guest guest3 = new Guest();
            guest3.Title = "Mr";
            guest3.FirstName = firstName3GustOne;
            guest3.GuestType = Enums.GuestType.Adult;
            guest3.LastName = lastName3GustOne;
            arrayOfGuest.add(guest3);

            String firstName4Gust2 = SharedPreferencesManger.LoadStringData(this, "firstName4Gust2");
            String lastName4Gust2 = SharedPreferencesManger.LoadStringData(this, "lastName4Gust2");
            Guest guest4 = new Guest();
            guest4.Title = "Mr";
            guest4.FirstName = firstName4Gust2;
            guest4.GuestType = Enums.GuestType.Adult;
            guest4.LastName = lastName4Gust2;
            arrayOfGuest.add(guest4);


        }

        if (noOfChildRoom2 == 1) {
            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGust2");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGust2");


            Guest child1 = new Guest();
            child1.Title = "Mr";
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.LastName = lastName1ChildGustOne;
            arrayOfGuest.add(child1);


        } else if (noOfChildRoom2 == 2) {

            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGust2");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGust2");


            Guest child1 = new Guest();
            child1.Title = "Mr";
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.LastName = lastName1ChildGustOne;
            arrayOfGuest.add(child1);


            String firstName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName2ChildGust2");
            String lastName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName2ChildGust2");

            Guest child2 = new Guest();
            child2.Title = "Mr";
            child2.FirstName = firstName2ChildGustOne;
            child2.GuestType = Enums.GuestType.Child;
            child2.LastName = lastName2ChildGustOne;
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
            guest.Title = "Mr";
            guest.FirstName = firstName1GustOne;
            guest.GuestType = Enums.GuestType.Adult;
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
            guest1.Title = "Mr";
            guest1.FirstName = firstName1GustOne;
            guest1.GuestType = Enums.GuestType.Adult;
            guest1.LastName = lastName1GustOne;
            arrayOfGuest.add(guest1);

            Guest guest2 = new Guest();
            guest2.Title = "Mr";
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;

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
            guest1.Title = "Mr";
            guest1.FirstName = firstName1GustOne;
            guest1.GuestType = Enums.GuestType.Adult;
            guest1.LastName = lastName1GustOne;
            arrayOfGuest.add(guest1);

            Guest guest2 = new Guest();
            guest2.Title = "Mr";
            guest2.FirstName = firstName2GustOne;
            guest2.GuestType = Enums.GuestType.Adult;
            guest2.LastName = lastName2GustOne;

            arrayOfGuest.add(guest2);


            Guest guest3 = new Guest();
            guest3.Title = "Mr";
            guest3.FirstName = firstName3GustOne;
            guest3.GuestType = Enums.GuestType.Adult;
            guest3.LastName = lastName3GustOne;

            arrayOfGuest.add(guest3);


        } else if (noOfAdultRoom1 == 4) {

            adult_4_Room1();
        }

        if (noOfChildRoom1 == 1) {
            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGustOne");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGustOne");


            Guest child1 = new Guest();
            child1.Title = "Mr";
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.LastName = lastName1ChildGustOne;
            arrayOfGuest.add(child1);


        } else if (noOfChildRoom1 == 2) {

            String firstName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName1ChildGustOne");
            String lastName1ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName1ChildGustOne");


            Guest child1 = new Guest();
            child1.Title = "Mr";
            child1.FirstName = firstName1ChildGustOne;
            child1.GuestType = Enums.GuestType.Child;
            child1.LastName = lastName1ChildGustOne;
            arrayOfGuest.add(child1);


            String firstName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "firstName2ChildGustOne");
            String lastName2ChildGustOne = SharedPreferencesManger.LoadStringData(this, "lastName2ChildGustOne");

            Guest child2 = new Guest();
            child2.Title = "Mr";
            child2.FirstName = firstName2ChildGustOne;
            child2.GuestType = Enums.GuestType.Child;
            child2.LastName = lastName2ChildGustOne;
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
        guest1.Title = "Mr";
        guest1.FirstName = firstName1GustOne;
        guest1.GuestType = Enums.GuestType.Adult;
        guest1.LastName = lastName1GustOne;
        arrayOfGuest.add(guest1);

        Guest guest2 = new Guest();
        guest2.Title = "Mr";
        guest2.FirstName = firstName2GustOne;
        guest2.GuestType = Enums.GuestType.Adult;
        guest2.LastName = lastName2GustOne;

        arrayOfGuest.add(guest2);


        Guest guest3 = new Guest();
        guest3.Title = "Mr";
        guest3.FirstName = firstName3GustOne;
        guest3.GuestType = Enums.GuestType.Adult;
        guest3.LastName = lastName3GustOne;

        arrayOfGuest.add(guest3);


        Guest guest4 = new Guest();
        guest4.Title = "Mr";
        guest4.FirstName = firstName4GustOne;
        guest4.GuestType = Enums.GuestType.Adult;
        guest4.LastName = lastName4GustOne;
        arrayOfGuest.add(guest4);

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
                            requestedRooms.RoomTypeName = "  ";
                            suppInfo.SuppChargeType = Enums.SuppChargeType.AtProperty;
                        }
                    }
                }


            }
         //   SharedPreferencesManger.SaveData(this, "arrayOfroomsreq", null);

            String clientReferenceNo = dtStr + "#TAMM";
            HotelBookResponse hotelBookingResponse = service.HotelBook(start_time, end_time,
                    clientReferenceNo, "EG", arrayOfGuest, null, paymentInfo
                    , sessionId, null, noOfRooms, resultIndex, mHOtelCode, hotel_name, arrayOfRooms, null,
                    null, false, authenticandata);


            ResponseStatus status = hotelBookingResponse.Status;
          //  int bookingId = hotelBookingResponse.BookingId;

           // Toast.makeText(this, ""+bookingId, Toast.LENGTH_SHORT).show();


            SharedPreferencesManger.SaveData(this, "ClientRef", clientReferenceNo);
            SharedPreferencesManger.SaveData(this, "BookingID", hotelBookingResponse.BookingId);
            SharedPreferencesManger.SaveData(this, "ConfirmationNo", hotelBookingResponse.ConfirmationNo);

//            AmendmentRequestType amendmentRequestType = new AmendmentRequestType();
//            amendmentRequestType.Type = Enums.AmendmentType.OfflineAmendment;
//            AmendInformation amendInformation = new AmendInformation();
//            amendInformation.CheckIn = new CheckInReq();
//            amendInformation.CheckIn.Date = new DateTime(start_time);
//            AmendmentResponse amendmentResponse = service.Amendment(amendmentRequestType, hotelBookingResponse.BookingId, amendInformation, hotelBookingResponse.ConfirmationNo, authenticandata);
////this is to cancel request

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
