package net.middledleeast.tamm.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.AdapterHotelInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class ChooseBookingDate extends AppCompatActivity {



    private TextView nameHotel , addressHotel ;
    private ImageView photoHotel ;
    private DatePickerDialog.OnDateSetListener startDateAdapter;
    private DatePickerDialog.OnDateSetListener endDateAdapter;
    private String date;
    private String endDateR;
    private RecyclerView reInfoHotels ;
    Calendar cal = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    AdapterHotelInfo adapterHotelInfo  ;

    long diff;
    private ArrayList<String> hotelName = new ArrayList<>();
    private ArrayList<String> hotelAddress= new ArrayList<>();
    private ArrayList<String> hotelphoto = new ArrayList<>();

    @Override
    protected void onRestart() {
        super.onRestart();

//        hotelName.clear();
//        hotelAddress.clear();
//        hotelphoto.clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_booking_date);
        reInfoHotels = findViewById(R.id.rv_info_hotel);


            hotelName = (ArrayList<String>) getIntent().getSerializableExtra("hotelName");
            hotelAddress = (ArrayList<String>) getIntent().getSerializableExtra("hotelAddress");
            hotelphoto = (ArrayList<String>) getIntent().getSerializableExtra("hotelPhoto");




     //   String hotelName = getIntent().getStringExtra("hotelName");

      //  Toast.makeText(this, ""+hotelName, Toast.LENGTH_SHORT).show();

//
//        ArrayList<String> namesOfHotels = getIntent().getStringArrayListExtra("hotelName");
        reInfoHotels.setLayoutManager(new LinearLayoutManager(this));
        adapterHotelInfo = new AdapterHotelInfo(hotelName,hotelAddress,hotelphoto,this);
        reInfoHotels.setAdapter(adapterHotelInfo);
        adapterHotelInfo.notifyDataSetChanged();






































//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(ChooseBookingDate.this,checkroom.class));
//            }
//        });



//
//        startDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(
//                        ChooseBookingDate.this,
//                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
//                        startDateAdapter,
//                        year,month,day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//
//
//            }
//        });
//        endDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                int year = cal2.get(Calendar.YEAR);
//                int month = cal2.get(Calendar.MONTH);
//                int day = cal2.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(
//                        ChooseBookingDate.this,
//                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
//                        endDateAdapter,
//                        year,month,day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//        });



//
//        startDateAdapter = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//                date = month + "/" + day + "/" + year;
//
//                startDate.setText(date);
//
//
//
//            }
//        };
//        endDateAdapter = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//
//
//
//                endDateR = month + "/" + day + "/" + year;
//
//                endDate.setText(endDateR);
//                nights.setText("" + diff);
//            }
//        };
//
//         diff =  (( cal2.getTimeInMillis() - cal.getTimeInMillis()) / (1000*60*60*24));
//        Log.e("hello", "diffrence : " + diff );

    }
}
