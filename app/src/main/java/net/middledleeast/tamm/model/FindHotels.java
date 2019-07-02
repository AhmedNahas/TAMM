package net.middledleeast.tamm.model;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.Tamm.Hotels.wcf.ArrayOfCityList;
import com.Tamm.Hotels.wcf.ArrayOfCountryList;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.CityList;
import com.Tamm.Hotels.wcf.CountryList;
import com.Tamm.Hotels.wcf.CountryListResponse;
import com.Tamm.Hotels.wcf.DestinationCityListResponse;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.ChooseHotelActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class FindHotels extends AppCompatActivity {

    Spinner cities;
    ArrayList cityNames;
    ArrayOfCityList arrayOfCityList;
    private ArrayList<String> countryList = new ArrayList<>();
    private Button findHotel;
    private ArrayList<String> cityList = new ArrayList<>();
    private ArrayAdapter countryAdapter;
    private ArrayAdapter cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_hotels);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        findHotel= findViewById(R.id.findHotels);

        findHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindHotels.this, ChooseHotelActivity.class));
            }
        });

        String[] locales = Locale.getISOCountries();

        Collections.addAll(countryList, locales);

        com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1 service = new com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1();
        service.enableLogging = true;
        AuthenticationData authenticationData = new AuthenticationData();
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");
        ArrayOfCountryList arrayOfCountryList = null;
        arrayOfCityList = null;
        final String[] countryName = new String[1];
        final String[] countryCode = new String[1];
        cityNames = new ArrayList();

        try {
            CountryListResponse countryListResponse = service.CountryList(authenticationData);
            arrayOfCountryList = countryListResponse.CountryList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> countryNames = new ArrayList<>();
        ArrayList<String> countryCodes = new ArrayList<>();
        for (CountryList countryList : arrayOfCountryList) {
            countryNames.add(countryList.CountryName);
            countryCodes.add(countryList.CountryCode);
        }
        Spinner countries = findViewById(R.id.country_spinner);
        countryAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,
                countryNames);
        countries.setAdapter(countryAdapter);
        ArrayOfCountryList finalArrayOfCountryList = arrayOfCountryList;
        ArrayOfCountryList finalArrayOfCountryList1 = arrayOfCountryList;
        countries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String countrycod = countryCodes.get(countries.getSelectedItemPosition());
                DestinationCityListResponse destinationCityListResponse = null;

                try {
                    destinationCityListResponse = service.DestinationCityList(countrycod, "true", authenticationData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                arrayOfCityList = destinationCityListResponse.CityList;
                cityNames.clear();

                for (CityList cityList : arrayOfCityList) {
                    cityNames.add(cityList.CityName);
                }
                cityAdapter = new ArrayAdapter(FindHotels.this, android.R.layout.simple_spinner_dropdown_item,
                        cityNames);

                cities.setAdapter(cityAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String countryNam = countryNames.get(countries.getSelectedItemPosition());

        cities = findViewById(R.id.city_spinner);

        cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }







}
