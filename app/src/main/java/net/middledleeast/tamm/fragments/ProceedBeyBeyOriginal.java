package net.middledleeast.tamm.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.MainActivity;
import net.middledleeast.tamm.activities.RecommendedOneWay;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import FlightApi.FlightApiService;
import FlightApi.FlightAuthentication;
import FlightApi.FlightConstants;
import FlightApi.SearchFlights;
import okhttp3.OkHttpClient;
import okhttp3.internal.Util;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProceedBeyBeyOriginal extends Fragment {

    private CheckedTextView royalClass, firstClass, businessClass, economyClass;
    private TextView fromTextView, toTextView;
    private RecyclerView fromToRecycler;
    private Button proccedBtn;
    private Spinner departure, returnFrom, passengerAdult, passengerChild, passengerInfant;
    public static final String BASE_URL = "https://xmloutapi.tboair.com/api/v1/";
    private static Retrofit retrofit = null;
    String password;
    private TextView country_selected_from_spinner , to_country_name;



    public ProceedBeyBeyOriginal() {
        // Required empty public constructor
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_proceed_bey_bey_original, container, false);
        password = "App02072019";

        royalClass = view.findViewById(R.id.royal_class);
        firstClass = view.findViewById(R.id.first_class);
        businessClass = view.findViewById(R.id.business_class);
        economyClass = view.findViewById(R.id.economy_class);
        fromTextView = view.findViewById(R.id.country_from_textview);
        toTextView = view.findViewById(R.id.country_to_textview);
        country_selected_from_spinner = view.findViewById(R.id.country_selected_from_spinner);

        proccedBtn = view.findViewById(R.id.procced_btn);
        departure = view.findViewById(R.id.departure_spinner);
        returnFrom = view.findViewById(R.id.return_spinner);
        passengerAdult = view.findViewById(R.id.adult_spinner);
        passengerChild = view.findViewById(R.id.child_spinner);
        passengerInfant = view.findViewById(R.id.infant_spinner);
        to_country_name = view.findViewById(R.id.to_country_name);



        try {

            String nameCountry2 = SharedPreferencesManger.LoadStringData(getContext(), "2name_country");
            String city_cod2 = SharedPreferencesManger.LoadStringData(getContext(), "2city_code");


            toTextView.setText(city_cod2);
            to_country_name.setText(nameCountry2);

            String nameCountry1 = SharedPreferencesManger.LoadStringData(getContext(), "1name_country");
            String city_cod1 = SharedPreferencesManger.LoadStringData(getContext(), "1city_code");

            country_selected_from_spinner.setText(nameCountry1);

            fromTextView.setText(city_cod1);
            Bundle arguments = getArguments();
            int id = arguments.getInt("id", 0);
            if (id==1){
                String name_country = arguments.getString("name_country");
                String city_code = arguments.getString("city_code");
                country_selected_from_spinner.setText(name_country);

                fromTextView.setText(city_code);

                SharedPreferencesManger.SaveData(getContext(),"1name_country",name_country);
                SharedPreferencesManger.SaveData(getContext(),"1city_code",city_code);

            }else if (id==2){



                String name_country = arguments.getString("name_country");

                String city_code = arguments.getString("city_code");
                toTextView.setText(city_code);
                to_country_name.setText(name_country);
                SharedPreferencesManger.SaveData(getContext(),"2name_country",name_country);
                SharedPreferencesManger.SaveData(getContext(),"2city_code",city_code);
            }

        }catch (Exception e){

        }


        proccedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  getContext().startActivity(new Intent(getContext(), RecommendedOneWay.class));

                searchFlight();

            }
        });


        fromTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchFlightByCity searchFlightByCity = new SearchFlightByCity();

                Bundle bundle = new Bundle();
                bundle.putInt("id_t",1);
                searchFlightByCity.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.flights_container, searchFlightByCity)
                        .addToBackStack( "ProceedBeyBeyOriginal" ) .commit();


            }
        });

        toTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchFlightByCity searchFlightByCity = new SearchFlightByCity();

                Bundle bundle = new Bundle();
                bundle.putInt("id_t",2);
                searchFlightByCity.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.flights_container, searchFlightByCity)
                        .addToBackStack( "ProceedBeyBeyOriginal" ) .commit();

            }
        });


        royalClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    royalClass.setTextColor(0xFFFFFFFF);
                    businessClass.setTextColor(0xFFBE973B);
                    economyClass.setTextColor(0xFFBE973B);
                    firstClass.setTextColor(0xFFBE973B);

                }
                return false;
            }
        });
        firstClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    firstClass.setTextColor(0xFFFFFFFF);
                    royalClass.setTextColor(0xFFBE973B);
                    businessClass.setTextColor(0xFFBE973B);
                    economyClass.setTextColor(0xFFBE973B);

                }
                return false;
            }
        });
        businessClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    businessClass.setTextColor(0xFFFFFFFF);
                    royalClass.setTextColor(0xFFBE973B);
                    firstClass.setTextColor(0xFFBE973B);
                    economyClass.setTextColor(0xFFBE973B);

                }
                return false;
            }
        });
        economyClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    economyClass.setTextColor(0xFFFFFFFF);
                    royalClass.setTextColor(0xFFBE973B);
                    firstClass.setTextColor(0xFFBE973B);
                    businessClass.setTextColor(0xFFBE973B);

                }
                return false;
            }
        });


        return view;
    }
    private void searchFlight() {
        password = "App02072019";

        Gson gson = new GsonBuilder()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);






        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS).build();

        connectAndGetApiData(gson, client);
        FlightApiService flightApiService = retrofit.create(FlightApiService.class);

        final FlightAuthentication[] flightAuthentication = {new FlightAuthentication()};
        flightAuthentication[0].setUserName(FlightConstants.API_USER_NAME);
        flightAuthentication[0].setPassword(password);
        flightAuthentication[0].setBookingMode("API");
        flightAuthentication[0].setIPAddress("192.169.10.22");

        Call<FlightAuthentication> call = flightApiService.getAuthentication("application/json", flightAuthentication[0]);

        call.enqueue(new Callback<FlightAuthentication>() {
            @Override
            public void onResponse(Call<FlightAuthentication> call, Response<FlightAuthentication> response) {
                flightAuthentication[0] = response.body();


                System.out.println("Helper: " + flightAuthentication[0].getTokenId());
                final SearchFlights[] searchFlights = {new SearchFlights()};
                searchFlights[0].setTokenId(flightAuthentication[0].getTokenId());
                String test = flightAuthentication[0].getTokenId();
                searchFlights[0].setAdultCount(1);
                searchFlights[0].setChildCount(1);
                searchFlights[0].setFlightCabinClass(1);
                searchFlights[0].setInfantCount(1);
                searchFlights[0].setJourneyType(1);
                searchFlights[0].setIPAddress("192.168.4.238");
                List<SearchFlights.Segment> segments = new ArrayList<>();
                SearchFlights.Segment segment = new SearchFlights.Segment();

                String to = toTextView.getText().toString();
                String from = fromTextView.getText().toString();
                segment.setDestination(to);
                segment.setOrigin(from);
                //wtf

                List<String> airlines = new ArrayList<>();
                airlines.add("EK");
                airlines.add("AI");
                segment.setPreferredAirlines(airlines);segment.setPreferredDepartureTime("2019-8-7T00:00:00");
                segment.setPreferredArrivalTime("2019-8-8T00:00:00");
//
                segments.add(segment);
                searchFlights[0].setSegment(segments);
                Call<SearchFlights> searchCall = flightApiService.getFlightSearch("application/json", searchFlights[0]);
                searchCall.enqueue(new Callback<SearchFlights>() {

                    @Override
                    public void onResponse(Call<SearchFlights> call, Response<SearchFlights> response) {

                        boolean successful = response.isSuccessful();
                        if (successful){
//                            searchFlights[0] = response.body();
                            Toast.makeText(getContext(), "successful"+response.message(), Toast.LENGTH_SHORT).show();
//                            System.out.println("How: " + searchFlights[0].searchFlightsResponse.getResults());


                        }else {
                            String s = response.raw().body().toString();
                            Toast.makeText(getContext(), "response"+response.message(), Toast.LENGTH_SHORT).show();

                            System.out.println("How: " + s);
                        }

                    }

                    @Override
                    public void onFailure(Call<SearchFlights> call, Throwable throwable) {
                        Toast.makeText(getContext(), "onFailure"+response.message(), Toast.LENGTH_SHORT).show();

                    }
                });

            }

            @Override
            public void onFailure(Call<FlightAuthentication> call, Throwable throwable) {
                Toast.makeText(getContext(), "onFailure"+throwable.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
//        if (flightAuthentication[0].getTokenId() != null) {
//            final SearchFlights[] searchFlights = {new SearchFlights()};
//            searchFlights[0].setTokenId(flightAuthentication[0].getTokenId());
//            String test = flightAuthentication[0].getTokenId();
//            searchFlights[0].setAdultCount(1);
//            searchFlights[0].setChildCount(1);
//            searchFlights[0].setFlightCabinClass(1);
//            searchFlights[0].setInfantCount(1);
//            searchFlights[0].setJourneyType(1);
//            searchFlights[0].setIPAddress("192.168.4.238");
//            List<SearchFlights.Segment> segments = new ArrayList<>();
//            SearchFlights.Segment segment = new SearchFlights.Segment();
//            segment.setDestination("DEL");
//            segment.setOrigin("DXB");
//            segment.setPreferredArrivalTime("2018-12-29T00:00:00");
//            segment.setPreferredDepartureTime("2018-12-29T00:00:00");
//            List<String> airlines = new ArrayList<>();
//            airlines.add("EK");
//            airlines.add("AI");
//            segment.setPreferredAirlines(airlines);
//            segments.add(segment);
//            searchFlights[0].setSegment(segments);
//            Call<SearchFlights> searchCall = flightApiService.getFlightSearch("application/json", searchFlights[0]);
//            searchCall.enqueue(new Callback<SearchFlights>() {
//
//                @Override
//                public void onResponse(Call<SearchFlights> call, Response<SearchFlights> response) {
//                    searchFlights[0] = response.body();
//                    Toast.makeText(getContext(), "searchFlights"+response.message(), Toast.LENGTH_SHORT).show();
//
//                    System.out.println("How: " + searchFlights[0].searchFlightsResponse.getResults());
//                }
//
//                @Override
//                public void onFailure(Call<SearchFlights> call, Throwable throwable) {
//                    Toast.makeText(getContext(), "onFailure"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
//
//                }
//            });
//        }
    }

    public Retrofit connectAndGetApiData(Gson gson, OkHttpClient client) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }



    }


