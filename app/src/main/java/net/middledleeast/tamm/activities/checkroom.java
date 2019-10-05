package net.middledleeast.tamm.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
import com.Tamm.Hotels.wcf.ArrayOfString2;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.AvailabilityAndPricingResponse;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.BookingOptions;
import com.Tamm.Hotels.wcf.HotelCancellationPolicyResponse;
import com.Tamm.Hotels.wcf.Hotel_Room;
import com.Tamm.Hotels.wcf.RoomCombination;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.AmenitiesAdapter;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class checkroom extends AppCompatActivity {


    @BindView(R.id.check_room_close)
    ImageView checkRoomClose;
    @BindView(R.id.img_check_out)
    ImageView imgCheckOut;
    @BindView(R.id.tv_8)
    TextView tv8;

    private Button checkRoom, back;
    @BindView(R.id.tv_total_mount)
    TextView tvTotalMount;
    private BasicHttpBinding_IHotelService1 service;
    private AuthenticationData authenticationData;
    private String sessionId;
    private String mHotelCode;
    private int resultIndex;
    private List<Hotel_Room> rooms = new ArrayList<>();
    TextView roomTyben;
    private String intent;
    private String roomTybe;
    private String description;
    private String mealTybe;
    private ArrayList<Double> roomIndexArray;
    private String roomPrice;
    private String currency;
    private ArrayOfRequestedRooms arrayOfRooms = new ArrayOfRequestedRooms();
    private float sum;
    private String singlePic;
    TextView  cancellation_fees;

    RecyclerView room_details_list ;
    private String amenties;
    private String untile;
    private String fromDate;
    private BigDecimal autoCancellationText;
    private String s1;
    private String feesFree;
    private String feesMember;
    private String roomMarkUpSt;
    private int roomMarkUp;
    private int roomCount;
    private AmenitiesAdapter amenitiesAdapter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_room);
        ButterKnife.bind(this);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        room_details_list = findViewById(R.id.room_details_list);
        StrictMode.setThreadPolicy(policy);
        SharedPreferencesManger.SaveData(this, "noOfTimes", 0);
        auth();
        getIntentInfo();
        back = findViewById(R.id.btn_baack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(checkroom.this, ChooseBookingDate.class));
            }
        });

        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(checkroom.this, R.style.alert_dialog_dark);

                builder.setNegativeButton("OKAY",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                View root = getLayoutInflater().inflate((R.layout.activity_cancellation_plicy_details), null);
                builder.setView(root);
                builder.setTitle("Cancellation Policy");


//

                AlertDialog dialog = builder.create();
                cancellation_fees = root.findViewById(R.id.cancellation_fees);
                cancellation_fees.setText("For Cancellation on Or After " + fromDate + " You Would be Charged " + autoCancellationText + " USD. ");

                TextView deadLine_tv = root.findViewById(R.id.tv_9);
                deadLine_tv.setText(untile);
                dialog.show();


            }
        });


        Gson gson1 = new Gson();
        String reqRoomString = SharedPreferencesManger.LoadStringData(this, "arrayOfroomsreq");

        arrayOfRooms = gson1.fromJson(reqRoomString, ArrayOfRequestedRooms.class);
//        roomPrice = SharedPreferencesManger.LoadStringData(this, "roomPrice");
        currency = SharedPreferencesManger.LoadStringData(this, "currency");
        singlePic = SharedPreferencesManger.LoadStringData(this, "singlePic");

        feesFree = SharedPreferencesManger.LoadStringData(this, "feesFree");
        feesMember = SharedPreferencesManger.LoadStringData(this, "feesMember");

        if (feesFree!=null){
            roomMarkUpSt = feesFree;
        }else {
            roomMarkUpSt = feesMember;
        }

        roomMarkUp = Integer.parseInt(roomMarkUpSt);
        Glide.with(this).load(singlePic).into(imgCheckOut);


        if (arrayOfRooms.size() == 2) {

            roomCount = 2 * roomMarkUp;

            String roomTypeName = arrayOfRooms.get(0).RoomTypeName;
            BigDecimal totalFare = arrayOfRooms.get(0).RoomRate.TotalFare;
            String price = totalFare.toString();



            String roomTypeName2 = arrayOfRooms.get(1).RoomTypeName;
            BigDecimal totalFare2 = arrayOfRooms.get(1).RoomRate.TotalFare;
            String price2 = totalFare2.toString();



            float finalPrice1 = Float.parseFloat(price);

            float finalPrice2 = Float.parseFloat(price2);
            sum = Float.sum(finalPrice1, finalPrice2);

            tvTotalMount.setText("  TOTAl AMOUNT :                          " + "USD " + (sum +roomCount));


        } else if (arrayOfRooms.size() == 3) {

            roomCount = 3 * roomMarkUp;

            String roomTypeName = arrayOfRooms.get(0).RoomTypeName;
            BigDecimal totalFare = arrayOfRooms.get(0).RoomRate.TotalFare;
            String price = totalFare.toString();


            String roomTypeName2 = arrayOfRooms.get(1).RoomTypeName;
            BigDecimal totalFare2 = arrayOfRooms.get(1).RoomRate.TotalFare;
            String price2 = totalFare2.toString();


            float finalPrice1 = Float.parseFloat(price);
            float finalPrice2 = Float.parseFloat(price2);
            float sum_ = Float.sum(finalPrice1, finalPrice2);


            String roomTypeName3 = arrayOfRooms.get(2).RoomTypeName;
            BigDecimal totalFare3 = arrayOfRooms.get(2).RoomRate.TotalFare;
            String price3 = totalFare3.toString();
            float finalPrice3 = Float.parseFloat(price3);


            sum = Float.sum(sum_, finalPrice3);
            tvTotalMount.setText("  TOTAl AMOUNT :                          " + (sum +roomCount));


        } else if (arrayOfRooms.size() == 4) {
            roomCount = 4 * roomMarkUp;

            String roomTypeName = arrayOfRooms.get(0).RoomTypeName;
            BigDecimal totalFare = arrayOfRooms.get(0).RoomRate.TotalFare;
            String price = totalFare.toString();


            String roomTypeName2 = arrayOfRooms.get(1).RoomTypeName;
            BigDecimal totalFare2 = arrayOfRooms.get(1).RoomRate.TotalFare;
            String price2 = totalFare2.toString();


            float finalPrice1 = Float.parseFloat(price);
            float finalPrice2 = Float.parseFloat(price2);
            float sum_ = Float.sum(finalPrice1, finalPrice2);


            String roomTypeName3 = arrayOfRooms.get(2).RoomTypeName;
            BigDecimal totalFare3 = arrayOfRooms.get(2).RoomRate.TotalFare;
            String price3 = totalFare3.toString();
            float finalPrice3 = Float.parseFloat(price3);


            float sum_4 = Float.sum(sum_, finalPrice3);


            String roomTypeName4 = arrayOfRooms.get(3).RoomTypeName;
            BigDecimal totalFare4 = arrayOfRooms.get(3).RoomRate.TotalFare;
            String price4 = totalFare4.toString();
            float finalPrice4 = Float.parseFloat(price4);


            sum = Float.sum(finalPrice4, sum_4);

            tvTotalMount.setText("  TOTAl AMOUNT :                          " + (sum +roomCount));


        } else if (arrayOfRooms.size() == 1) {
            roomCount = 1 * roomMarkUp;

            String roomTypeName = arrayOfRooms.get(0).RoomTypeName;
            BigDecimal totalFare = arrayOfRooms.get(0).RoomRate.TotalFare;
            String price = totalFare.toString();

            float finalPrice = Float.parseFloat(price);


            sum = finalPrice;
            tvTotalMount.setText("  TOTAl AMOUNT :                          " + (sum +roomCount));


        }


        String roomIndexArrayStr = SharedPreferencesManger.LoadStringData(this, "roomIndexArray");
        Gson gson = new Gson();


        try {


            // TODO: 31/07/2019  error
            roomIndexArray = gson.fromJson(roomIndexArrayStr, ArrayList.class);
            ArrayList<Integer> roomIndexArrayInt = new ArrayList<>();
            for (double aDouble : roomIndexArray) {
                roomIndexArrayInt.add((int) aDouble);
            }

            Collections.sort(roomIndexArrayInt);


// FIXME: 29/07/19 booking options according to correct


            BookingOptions bookingOptions = new BookingOptions();
            bookingOptions.RoomCombination = new ArrayList<>();
            RoomCombination roomCombination = new RoomCombination();
            roomCombination.RoomIndex = new ArrayList<>();
            roomCombination.RoomIndex = new ArrayList<>(roomIndexArrayInt);
            bookingOptions.RoomCombination.add(roomCombination);
            SharedPreferencesManger.SaveData(this, "roomIndexArray", null);
            try {

                HotelCancellationPolicyResponse cancelPolicies = service.HotelCancellationPolicy(resultIndex, sessionId, bookingOptions, authenticationData);


                AvailabilityAndPricingResponse availabilityAndPricingResponse = service.AvailabilityAndPricing(resultIndex, sessionId, bookingOptions, authenticationData);

                autoCancellationText = availabilityAndPricingResponse.HotelCancellationPolicies.CancelPolicies.CancelPolicy.get(0).CancellationCharge;
                fromDate = availabilityAndPricingResponse.HotelCancellationPolicies.CancelPolicies.CancelPolicy.get(0).FromDate;


                String deadline = availabilityAndPricingResponse.HotelCancellationPolicies.CancelPolicies.LastCancellationDeadline.toString();
                ArrayOfString2 hotelNorms = availabilityAndPricingResponse.HotelCancellationPolicies.HotelNorms;
                ArrayList<String>  listHotelNormis = new ArrayList<>();

                String[] split = hotelNorms.toString().split(",");

                for (int i = 0; i < split.length; i++) {

                    listHotelNormis.add(split[i]);
                    room_details_list.setLayoutManager(new GridLayoutManager(this,2));

                    amenitiesAdapter = new AmenitiesAdapter(checkroom.this,listHotelNormis);
                    room_details_list.setAdapter(amenitiesAdapter);
                    amenitiesAdapter.notifyDataSetChanged();
                }




                String[] arrOfStr = deadline.split("T");


                untile = "Until : " + arrOfStr[0];
                SharedPreferencesManger.SaveData(this, "Until", untile);


            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {


        }
        checkRoom = findViewById(R.id.checkOutRoom);
        roomTyben = findViewById(R.id.room_Tybe);
        roomTyben.setText(roomTybe);

        SharedPreferencesManger.SaveData(this, "firstName1GustOne", "");
        SharedPreferencesManger.SaveData(this, "lastName1GustOne", "");
        SharedPreferencesManger.SaveData(this, "firstName2GustOne", "");
        SharedPreferencesManger.SaveData(this, "lastName2GustOne", "");
        SharedPreferencesManger.SaveData(this, "firstName3GustOne", "");
        SharedPreferencesManger.SaveData(this, "lastName3GustOne", "");
        SharedPreferencesManger.SaveData(this, "firstName4GustOne", "");
        SharedPreferencesManger.SaveData(this, "firstName1ChildGustOne", "");
        SharedPreferencesManger.SaveData(this, "lastName1ChildGustOne", "");
        SharedPreferencesManger.SaveData(this, "firstName2ChildGustOne", "");
        SharedPreferencesManger.SaveData(this, "lastName2ChildGustOne", "");
        SharedPreferencesManger.SaveData(this, "firstName1Gust2", "");
        SharedPreferencesManger.SaveData(this, "lastName1Gust2", "");
        SharedPreferencesManger.SaveData(this, "firstName2Gust2", "");
        SharedPreferencesManger.SaveData(this, "lastName2Gust2", "");
        SharedPreferencesManger.SaveData(this, "firstName3Gust2", "");
        SharedPreferencesManger.SaveData(this, "lastName3Gust2", "");
        SharedPreferencesManger.SaveData(this, "firstName4Gust2", "");
        SharedPreferencesManger.SaveData(this, "lastName4Gust2", "");
        SharedPreferencesManger.SaveData(this, "firstName1ChildGust2", "");
        SharedPreferencesManger.SaveData(this, "lastName1ChildGust2", "");
        SharedPreferencesManger.SaveData(this, "firstName2ChildGust2", "");
        SharedPreferencesManger.SaveData(this, "lastName2ChildGust2", "");
        SharedPreferencesManger.SaveData(this, "firstName1Gust3", "");
        SharedPreferencesManger.SaveData(this, "lastName1Gust3", "");
        SharedPreferencesManger.SaveData(this, "firstName2Gust3", "");
        SharedPreferencesManger.SaveData(this, "lastName2Gust3", "");
        SharedPreferencesManger.SaveData(this, "firstName3Gust3", "");
        SharedPreferencesManger.SaveData(this, "lastName3Gust3", "");
        SharedPreferencesManger.SaveData(this, "firstName4Gust3", "");
        SharedPreferencesManger.SaveData(this, "lastName4Gust3", "");
        SharedPreferencesManger.SaveData(this, "firstName1ChildGust3", "");
        SharedPreferencesManger.SaveData(this, "lastName1ChildGust3", "");
        SharedPreferencesManger.SaveData(this, "firstName2ChildGust3", "");
        SharedPreferencesManger.SaveData(this, "lastName2ChildGust3", "");
        SharedPreferencesManger.SaveData(this, "firstName1Gust4", "");
        SharedPreferencesManger.SaveData(this, "lastName1Gust4", "");
        SharedPreferencesManger.SaveData(this, "firstName2Gust4", "");
        SharedPreferencesManger.SaveData(this, "lastName2Gust4", "");
        SharedPreferencesManger.SaveData(this, "firstName3Gust4", "");
        SharedPreferencesManger.SaveData(this, "lastName3Gust4", "");
        SharedPreferencesManger.SaveData(this, "firstName4Gust4", "");
        SharedPreferencesManger.SaveData(this, "lastName4Gust4", "");
        SharedPreferencesManger.SaveData(this, "firstName1ChildGust4", "");
        SharedPreferencesManger.SaveData(this, "lastName1ChildGust4", "");
        SharedPreferencesManger.SaveData(this, "firstName2ChildGust4", "");
        SharedPreferencesManger.SaveData(this, "lastName2ChildGust4", "");

        checkRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesManger.SaveData(checkroom.this, "finalpriceRoom", String.valueOf(sum+roomCount));

                startActivity(new Intent(checkroom.this, ConfirmBookingRoom.class));

            }
        });


        try {

            service.enableLogging = true;


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getIntentInfo() {

        intent = getIntent().getStringExtra("smok");

        roomTybe = getIntent().getStringExtra("roomTybe");
        roomPrice = getIntent().getStringExtra("roomPrice");
        String[] s = roomPrice.split(" ");
        s1 = s[1];


        description = getIntent().getStringExtra("description");
        sessionId = SharedPreferencesManger.LoadStringData(this, "session_id");
        mHotelCode = getIntent().getStringExtra("hotelCode");
        resultIndex = getIntent().getIntExtra("resultIndex", 0);
        mealTybe = getIntent().getStringExtra("mealTybe");
//        roomIndex = getIntent().getIntExtra("roomIndex", 1);
    }

    private void auth() {

        service = new BasicHttpBinding_IHotelService1();
        authenticationData = new AuthenticationData();
        service.enableLogging = true;
        authenticationData.UserName = (getString(R.string.user_name_tamm));
        authenticationData.Password = (getString(R.string.passowrd_tamm));

    }

    @OnClick(R.id.check_room_close)
    public void onViewClicked() {

        startActivity(new Intent(checkroom.this, ChooseBookingDate.class));
    }


    public static class transferClass {

        public static ArrayOfRequestedRooms arrayOfRequestedRooms;


        public static ArrayOfRequestedRooms getArrayOfRequestedRooms() {
            return arrayOfRequestedRooms;
        }

        public static void setArrayOfRequestedRooms(ArrayOfRequestedRooms arrayOfRequestedRooms) {
            ChooseBookingDate.transferClass.arrayOfRequestedRooms = arrayOfRequestedRooms;
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(checkroom.this, ChooseBookingDate.class));

    }

}
