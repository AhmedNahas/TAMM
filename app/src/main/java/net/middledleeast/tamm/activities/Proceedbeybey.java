package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckedTextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.fragments.MultiCitiesFlights;
import net.middledleeast.tamm.fragments.ProceedBeyBeyOriginal;
import net.middledleeast.tamm.fragments.ReturnWayFlights;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import FlightApi.FlightApiService;
import FlightApi.FlightAuthentication;
import FlightApi.FlightConstants;
import FlightApi.SearchFlights;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Proceedbeybey extends AppCompatActivity {

 //   private CheckedTextView passenger, jet, one_way, return_passe, multi_cities;
    public static final String BASE_URL = "https://xmloutapi.tboair.com/api/v1/";
    private static final String TAG = MainActivity.class.getSimpleName();
    private static Retrofit retrofit = null;
    public FlightAuthentication flightAuthentication;
    String password;
    private RecyclerView recyclerView = null;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proceedbey_bey);


//        password = "App02072019";
//
//        Gson gson = new GsonBuilder()
//                .create();
//
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).connectTimeout(100, TimeUnit.SECONDS)
//                .readTimeout(100, TimeUnit.SECONDS).build();
//
//        connectAndGetApiData(gson, client);
//        FlightApiService flightApiService = retrofit.create(FlightApiService.class);
//
//        final FlightAuthentication[] flightAuthentication = {new FlightAuthentication()};
//        flightAuthentication[0].setUserName(FlightConstants.API_USER_NAME);
//        flightAuthentication[0].setPassword(password);
//        flightAuthentication[0].setBookingMode("API");
//        flightAuthentication[0].setIPAddress("192.169.10.22");
//
//        Call<FlightAuthentication> call = flightApiService.getAuthentication("application/json", flightAuthentication[0]);
//
//        call.enqueue(new Callback<FlightAuthentication>() {
//            @Override
//            public void onResponse(Call<FlightAuthentication> call, Response<FlightAuthentication> response) {
//                flightAuthentication[0] = response.body();
//
//
//                System.out.println("Helper: " + flightAuthentication[0].getTokenId());
//                final SearchFlights[] searchFlights = {new SearchFlights()};
//                searchFlights[0].setTokenId(flightAuthentication[0].getTokenId());
//                String test = flightAuthentication[0].getTokenId();
//                searchFlights[0].setAdultCount(1);
//                searchFlights[0].setChildCount(1);
//                searchFlights[0].setFlightCabinClass(1);
//                searchFlights[0].setInfantCount(1);
//                searchFlights[0].setJourneyType(1);
//                searchFlights[0].setIPAddress("192.168.4.238");
//                List<SearchFlights.Segment> segments = new ArrayList<>();
//                SearchFlights.Segment segment = new SearchFlights.Segment();
//                segment.setDestination("DEL");
//                segment.setOrigin("DXB");
//                segment.setPreferredDepartureTime("2019-8-7T00:00:00");
//                segment.setPreferredArrivalTime("2019-8-8T00:00:00");
//
//                List<String> airlines = new ArrayList<>();
//                airlines.add("DEL");
//                airlines.add("DXB");
//                segment.setPreferredAirlines(airlines);
//                segments.add(segment);
//                searchFlights[0].setSegment(segments);
//                Call<SearchFlights> searchCall = flightApiService.getFlightSearch("application/json", searchFlights[0]);
//                searchCall.enqueue(new Callback<SearchFlights>() {
//
//                    @Override
//                    public void onResponse(Call<SearchFlights> call, Response<SearchFlights> response) {
//                        searchFlights[0] = response.body();
//                        System.out.println("How: " + searchFlights.length);
//                    }
//
//                    @Override
//                    public void onFailure(Call<SearchFlights> call, Throwable throwable) {
//                        Log.e(TAG, throwable.toString());
//                    }
//                });
//
//            }
//
//            @Override
//            public void onFailure(Call<FlightAuthentication> call, Throwable throwable) {
//                Log.e(TAG, throwable.toString());
//            }
//        });
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
//
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
//                    System.out.println("How: " + searchFlights[0].searchFlightsResponse.getResults());
//                }
//
//                @Override
//                public void onFailure(Call<SearchFlights> call, Throwable throwable) {
//                    Log.e(TAG, throwable.toString());
//                }
//            });
//        }
//
//




//
//        passenger=findViewById(R.id.passen_air);
//        jet=findViewById(R.id.private_jet);
//        one_way=findViewById(R.id.one_way);
//        return_passe=findViewById(R.id.return_passe);
//        multi_cities=findViewById(R.id.multi_cities);
//
//
      getSupportFragmentManager().beginTransaction().replace(R.id.flights_container, new ProceedBeyBeyOriginal())
               .commit();
//
//        passenger.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                    passenger.setTextColor(0xFFFFFFFF);
//                    jet.setTextColor(0xFFBE973B);
//                }
//                return false;
//            }
//        });
//        jet.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                    jet.setTextColor(0xFFFFFFFF);
//                    passenger.setTextColor(0xFFBE973B);
//                }
//
//                return false;
//            }
//        });
//        one_way.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                    one_way.setTextColor(0xFFFFFFFF);
//                    return_passe.setTextColor(0xFFBE973B);
//                    multi_cities.setTextColor(0xFFBE973B);
//                    ProceedBeyBeyOriginal proceedBeyBeyOriginal = new ProceedBeyBeyOriginal();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.flights_container, proceedBeyBeyOriginal)
//                            .commit();
//
//
//                }
//                return false;
//            }
//        });
//        return_passe.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                    return_passe.setTextColor(0xFFFFFFFF);
//                    one_way.setTextColor(0xFFBE973B);
//                    multi_cities.setTextColor(0xFFBE973B);
//                    getSupportFragmentManager().beginTransaction().replace(R.id.flights_container, new ReturnWayFlights())
//                            .commit();
//
//
//                }
//                return false;
//            }
//        });
//        multi_cities.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                    multi_cities.setTextColor(0xFFFFFFFF);
//                    one_way.setTextColor(0xFFBE973B);
//                    return_passe.setTextColor(0xFFBE973B);
//
//                    MultiCitiesFlights multiCitiesFlights = new MultiCitiesFlights();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.flights_container, multiCitiesFlights)
//                            .commit();
//
//
//
//                }
//                return false;
//            }
//        });

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

