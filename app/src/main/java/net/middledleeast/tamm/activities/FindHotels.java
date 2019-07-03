package net.middledleeast.tamm.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.Tamm.Hotels.wcf.ArrayOfRoomGuest;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.CityList;
import com.Tamm.Hotels.wcf.CountryList;
import com.Tamm.Hotels.wcf.CountryListResponse;
import com.Tamm.Hotels.wcf.DestinationCityListResponse;
import com.Tamm.Hotels.wcf.HotelInfo;
import com.Tamm.Hotels.wcf.HotelSearchResponse;
import com.Tamm.Hotels.wcf.RoomGuest;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.AreaAdapter;
import net.middledleeast.tamm.adapters.CountryAdapter;
import net.middledleeast.tamm.adapters.RegionAdapter;
import net.middledleeast.tamm.model.AreaItem;
import net.middledleeast.tamm.model.RegionItem;

import org.joda.time.DateTime;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Queue;

public class FindHotels extends AppCompatActivity {


    private Button findHotel;
    private Spinner  regions ,areas , roomsSelected;
    private List<String> list = new ArrayList<>();
    private  List<String> listID = new ArrayList<>();
    private List<String> nameCity = new ArrayList<>();
    private BasicHttpBinding_IHotelService1 service;
    private AuthenticationData authenticationData;
    private boolean checked;
    private String ctyId;
    private List<String> lisNameHotels = new ArrayList<>();
    private String idCountry;
    ArrayList<String> nameHotel = new ArrayList<>();
    ArrayList<String> descHotel = new ArrayList<>();
    ArrayList<String> photoHotel = new ArrayList<>();
    private String hotelAddress;
    private String hotelName;
    private String hotelPicture;
    private TextView startD , endD;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Calendar cal;
    private String countryName;
    private String cityName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_hotels);
        findHotel= findViewById(R.id.findHotels);
        areas = findViewById(R.id.area_spinner);
        startD=findViewById(R.id.startDate);
        endD=findViewById(R.id.endDate);
        roomsSelected= findViewById(R.id.roomsSelected);




        startD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        FindHotels.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                String date = month + "/" + day + "/" + year;
                startD.setText(date);
            }
        };

        regions = findViewById(R.id.region_spinner);




        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);



        findHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gethotelsInfo(ctyId);

            }
        });

        auth();
        try {

            service.enableLogging = true;
//            service.DestinationCityList("IN", null, authenticationData);




            CountryListResponse countryListResponse = service.CountryList(authenticationData);


            for (int i = 0; i < countryListResponse.CountryList.size(); i++) {

                CountryList countryList = countryListResponse.CountryList.get(i);
                String cod = countryList.CountryCode;

                listID.add(cod);
                countryName = countryList.CountryName;
//                countryList.CountryCode
//                countryListResponse.Status.Category
                list.add(countryName);

                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                regions.setAdapter(adapter);


            }
            regions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                   nameCity.clear();
                   idCountry = listID.get(position);


                    Toast.makeText(FindHotels.this, "country id "+idCountry, Toast.LENGTH_SHORT).show();




                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });





            try {
                DestinationCityListResponse cities = service.DestinationCityList(idCountry, "true", authenticationData);

                for (int j = 0; j < cities.CityList.size(); j++) {

                    cityName = cities.CityList.get(j).CityName;

                    nameCity.add(cityName);
                    ArrayAdapter adapterCity = new ArrayAdapter(FindHotels.this, android.R.layout.simple_spinner_item, nameCity);
                    adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    areas.setAdapter(adapterCity);
                    areas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            ctyId = cities.CityList.get(i).CityCode;
                            Toast.makeText(FindHotels.this, "city id "+ctyId, Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }


            } catch (Exception e) {
                e.printStackTrace();
            }

//            String test = hotelSearchResponse.Status.Description;
//            System.out.println("Hello: " + test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void gethotelsInfo(String ctyId) {




        auth();

        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.DAY_OF_MONTH, 22);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.DAY_OF_MONTH, 23);
        DateTime date1 = DateTime.now();
        DateTime date2 = DateTime.now();
        date1 = date1.plusDays(4);
        date2 = date2.plusDays(7);


        service.enableLogging = true;



        RoomGuest roomGuest = new RoomGuest();
        roomGuest.AdultCount = 1;
        roomGuest.ChildCount = 0;
        ArrayOfRoomGuest roomguests = new ArrayOfRoomGuest();
        roomguests.add(roomGuest);


        try {
            HotelSearchResponse hotelSearchResponse = service.HotelSearch(date1.toDateTimeISO(), date2.toDateTimeISO(),countryName,cityName,Integer.parseInt(ctyId),
                    true,1,"EG",roomguests,null,20 ,null,null,null,
                    null, authenticationData);



            for (int i = 0; i < hotelSearchResponse.HotelResultList.size(); i++) {

                HotelInfo hotelInfo = hotelSearchResponse.HotelResultList.get(i).HotelInfo;
                 hotelAddress = hotelInfo.HotelAddress;
                 hotelName = hotelInfo.HotelName;
                 hotelPicture = hotelInfo.HotelPicture;
                String hotelDescription = hotelInfo.HotelDescription;

                nameHotel.add(hotelName);
                descHotel.add(hotelDescription);
                photoHotel.add(hotelPicture);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }




        Intent intent = new Intent(FindHotels.this,ChooseBookingDate.class);
                intent.putExtra("hotelName",nameHotel);
                intent.putExtra("hotelAddress",descHotel);
                intent.putExtra("hotelPhoto",photoHotel);
        startActivity(intent);

    }


    private void auth() {

        service = new com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1();
        authenticationData = new AuthenticationData();
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");

    }


}
