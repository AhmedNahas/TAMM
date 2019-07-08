package net.middledleeast.tamm.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.Tamm.Hotels.wcf.ArrayOfRoomGuest;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.CountryList;
import com.Tamm.Hotels.wcf.CountryListResponse;
import com.Tamm.Hotels.wcf.DestinationCityListResponse;
import com.Tamm.Hotels.wcf.GeoCodes;
import com.Tamm.Hotels.wcf.HotelInfo;
import com.Tamm.Hotels.wcf.HotelSearchResponse;
import com.Tamm.Hotels.wcf.Hotel_Result;
import com.Tamm.Hotels.wcf.RoomGuest;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import static java.util.Calendar.YEAR;

public class FindHotels extends AppCompatActivity {


    private Button findHotel;
    ArrayList<Integer> ratrHotel = new ArrayList<Integer>();
    private List<String> list = new ArrayList<>();
    ArrayList<String> addressHotel = new ArrayList<>();
    private List<String> nameCity = new ArrayList<>();
    private BasicHttpBinding_IHotelService1 service;
    private AuthenticationData authenticationData;
    private boolean checked;
    private String ctyId;
    private List<String> lisNameHotels = new ArrayList<>();
    private String idCountry;
    ArrayList<String> nameHotel = new ArrayList<>();
    Calendar myCalendar;
    ArrayList<String> photoHotel = new ArrayList<>();
    ArrayList<String> listcodeHotel = new ArrayList<>();
    private String hotelAddress;
    private String hotelName;
    private String hotelPicture;
    private Spinner regions, areas, roomCount, adultCount, childCount;
    private List<String> listID = new ArrayList<>();
    private String nameCountry;
    private String name_city;
    private TextView startDate, endDate , nights;
    private String mendTime;
    private String mstartTime;
    private List<Integer> listOfRooms = new ArrayList<>();
    private List<Integer> listOfAdult = new ArrayList<>();
    private List<Integer> listOfChild = new ArrayList<>();
    private int noRomes;
    private String sessionId;
    ArrayList<Integer> arrayOfResultIndex;
    private int resultIndex = 0;
    private Date time1;
    private Date time2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_hotels);
        findHotel = findViewById(R.id.findHotels);
        areas = findViewById(R.id.area_spinner);
        regions = findViewById(R.id.region_spinner);
        roomCount = findViewById(R.id.no_of_rooms);
        adultCount = findViewById(R.id.adilt_count);
        childCount = findViewById(R.id.child_count);
        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);
        nights = findViewById(R.id.nights);
        noRomes =1 ;
        arrayOfResultIndex = new ArrayList<>();
        for (int i = 1; i < 7; i++) {

            listOfRooms.add(i);
        }






        ArrayAdapter adapterRoomCount = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listOfRooms);

        adapterRoomCount.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomCount.setAdapter(adapterRoomCount);
        roomCount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int position = listOfRooms.get(i);

                switch (position) {
                    case 1:
                        listOfChild.clear();
                        listOfAdult.clear();
                        list1();
                        listOfChildCount();
                        noRomes = 1;
                        break;
                    case 2:
                        listOfAdult.clear();
                        listOfChild.clear();
                        noRomes = 2;
                        list2();
                        listOfChildCount2();


                    default:

                        return;
                }


                ArrayAdapter adapteradult = new ArrayAdapter(FindHotels.this, android.R.layout.simple_spinner_item, listOfAdult);

                adapteradult.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adultCount.setAdapter(adapteradult);
                adultCount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        int nom_adult = listOfAdult.get(i);
                        SharedPreferencesManger.SaveData(FindHotels.this, "no_adult", nom_adult);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter adapterchild = new ArrayAdapter(FindHotels.this, android.R.layout.simple_spinner_item, listOfChild);

        adapterchild.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        childCount.setAdapter(adapterchild);
        childCount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                int no_child = listOfChild.get(i);
                SharedPreferencesManger.SaveData(FindHotels.this,"no_child",no_child);
                Toast.makeText(FindHotels.this, ""+no_child, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        myCalendar = Calendar.getInstance();
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dilogstart();

            }
        });


        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dialogendTime();


            }
        });


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);


        findHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (startDate.getText().toString().matches("")) {
                    dilogstart();
                } else if (endDate.getText().toString().matches("")) {

                    dialogendTime();
                } else {




SharedPreferencesManger.SaveData(FindHotels.this,"start_date",mstartTime);
                    SharedPreferencesManger.SaveData(FindHotels.this,"end_date",mendTime);

                    SharedPreferencesManger.SaveData(FindHotels.this,"no_room",noRomes);






                    gethotelsInfo(ctyId);
                }


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
                String name = countryList.CountryName;
//                countryList.CountryCode
//                countryListResponse.Status.Category
                list.add(name);

                ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item_spener, list);
                adapter.setDropDownViewResource(R.layout.drop_dowen);
                regions.setAdapter(adapter);


            }
            regions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                    nameCity.clear();
                    idCountry = listID.get(position);

                    nameCountry = list.get(position);

                    getCities(idCountry);


                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });


            // String test = hotelSearchResponse.Status.Description;
//            System.out.println("Hello: " + test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listOfChildCount() {

        for (int i = 1; i < 5; i++) {
            listOfChild.add(i);
        }


    }


    private void listOfChildCount2() {

        for (int i = 1; i < 9; i++) {
            listOfChild.add(i);
        }


    }

    private void list1() {

        for (int i = 1; i < 7; i++) {


            listOfAdult.add(i);
        }


    }

    private void list2() {

        for (int i = 1; i < 13; i++) {


            listOfAdult.add(i);
        }


    }


    private void getCities(String idCountry) {


        try {
            DestinationCityListResponse cities = service.DestinationCityList(idCountry, "true", authenticationData);
            for (int j = 0; j < cities.CityList.size(); j++) {


                ctyId = cities.CityList.get(j).CityCode;
                String cityName = cities.CityList.get(j).CityName;
                nameCity.add(cityName);


                ArrayAdapter adapterCity = new ArrayAdapter(FindHotels.this, android.R.layout.simple_spinner_item, nameCity);
                adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                areas.setAdapter(adapterCity);
                areas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//                        FindHotels.this.cityName = cities.CityList.get(position).CityName;
//                        nameCity.add(FindHotels.this.cityName);

                        name_city = nameCity.get(position);


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

            }


        } catch (Exception e) {
            e.printStackTrace();
        }//

    }

    private void gethotelsInfo(String ctyId) {


        auth();

//        Calendar cal1 = Calendar.getInstance();
//        cal1.set(Calendar.DAY_OF_MONTH, 22);
//        Calendar cal2 = Calendar.getInstance();
//        cal2.set(Calendar.DAY_OF_MONTH, 23);
        DateTime date1 = DateTime.parse(mstartTime);
        DateTime date2 = DateTime.parse(mendTime);
//        date1 = date1.plusDays(4);
//        date2 = date2.plusDays(7);


        service.enableLogging = true;

        RoomGuest roomGuest = new RoomGuest();
        roomGuest.AdultCount = 1;
        roomGuest.ChildCount = 0;
        ArrayOfRoomGuest roomguests = new ArrayOfRoomGuest();
        roomguests.add(roomGuest);

        GeoCodes geoCodes = new GeoCodes();
        String countryCode = geoCodes.CountryCode;

        try {
            //HotelSearchResponse hotelSearchResponse = service.HotelSearch1(date1.toDateTimeISO(), date2.toDateTimeISO(), Integer.parseInt(ctyId), 1, roomguests, "EG", authenticationData);


            HotelSearchResponse hotelSearchResponse = service.HotelSearch(date1.toString("yyyy-MM-dd"), date2.toString("yyyy-MM-dd"), nameCountry, name_city, Integer.parseInt(ctyId),
                    true, noRomes, "EG", roomguests, null, 100, null, null, null,
                    600, authenticationData);
            ratrHotel.clear();
            nameHotel.clear();
            photoHotel.clear();
            listcodeHotel.clear();
            for (int i = 0; i < hotelSearchResponse.HotelResultList.size(); i++) {

                Hotel_Result hotel_result = hotelSearchResponse.HotelResultList.get(i);
                HotelInfo hotelInfo = hotel_result.HotelInfo;
                sessionId = hotelSearchResponse.SessionId;
                hotelAddress = hotelInfo.HotelAddress;
                hotelName = hotelInfo.HotelName;
                hotelPicture = hotelInfo.HotelPicture;
                int code = hotelInfo.Rating.getCode();
                arrayOfResultIndex.add(hotel_result.ResultIndex);

                String hotelCode = hotelInfo.HotelCode;
                listcodeHotel.add(hotelCode);

                nameHotel.add(hotelName);
                ratrHotel.add(code);
                photoHotel.add(hotelPicture);
                addressHotel.add(hotelAddress);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        Intent intent = new Intent(FindHotels.this, ChooseHotelActivity.class);
        intent.putExtra("hotelName", nameHotel);
        intent.putExtra("hotelrat", ratrHotel);
        intent.putExtra("hotelPhoto", photoHotel);
        intent.putExtra("hotelCode", listcodeHotel);
        intent.putExtra("hotelAddress", addressHotel);
        intent.putExtra("sessionId", sessionId);
        intent.putExtra("checkInDate", mstartTime);
        intent.putExtra("checkOutDate", mendTime);
        intent.putExtra("countryName", nameCountry);
        intent.putExtra("cityName", name_city);
        intent.putExtra("cityId", ctyId);
        intent.putExtra("noOfRooms", noRomes);
        intent.putExtra("resultIndex", arrayOfResultIndex);
       // intent.putExtra("roomGuest",roomguests);

        startActivity(intent);

    }

    private void auth() {

        service = new com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1();
        authenticationData = new AuthenticationData();
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");

    }


    private void dilogstart() {

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "yyyy-MM-dd"; //In which you need put here
                SimpleDateFormat start = new SimpleDateFormat(myFormat, Locale.US);
                time1 = myCalendar.getTime();
                mstartTime = start.format(myCalendar.getTime());
                startDate.setText(mstartTime);


            }
        };


        new DatePickerDialog(FindHotels.this, date, myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

    }


    private void dialogendTime() {

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "yyyy-MM-dd"; //In which you need put here
                SimpleDateFormat end = new SimpleDateFormat(myFormat, Locale.US);

                 time2 = myCalendar.getTime();

                mendTime = end.format(myCalendar.getTime());
                endDate.setText(mendTime);


                long diff = time2.getTime() - time1.getTime();

                long seconds = diff / 1000;
                long minutes = seconds / 60;
                long hours = minutes / 60;
                long days = hours / 24;


                nights.setText(+days+" Nights");
                SharedPreferencesManger.SaveData(FindHotels.this ,"nights",days);


            }
        };


        new DatePickerDialog(FindHotels.this, date, myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

    }





}
