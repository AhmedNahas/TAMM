package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.fragments.ProceedBeyBeyOriginal;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import FlightApi.FlightAuthentication;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Proceedbeybey extends AppCompatActivity {

    TextView assistantLabelVoiceRenewHotel;
    RelativeLayout relativeImgRenewHotelTamm;
    TextView assistantLabelCallRenewHotel;
    TextView assistantLabelMessageRenewHotel;


 //   private CheckedTextView passenger, jet, one_way, return_passe, multi_cities;
    public static final String BASE_URL = "https://xmloutapi.tboair.com/api/v1/";
    private static final String TAG = MainActivity.class.getSimpleName();
    private static Retrofit retrofit = null;
    public FlightAuthentication flightAuthentication;
    String password;
    private RecyclerView recyclerView = null;
    private boolean ClickRenewHotel = false;

    RelativeLayout toolbar_back1;
    ImageView iv_booked_proceed;
    private Integer accountPlan;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proceedbey_bey);

        iv_booked_proceed=findViewById(R.id.iv_booked_proceed);
        iv_booked_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(Proceedbeybey.this,MyBookActivity.class);
                startActivity(intent);
            }
        });


        try {
            accountPlan = SharedPreferencesManger.LoadIntegerData(this, "accountPlan");

            if (accountPlan == 1) {

                iv_booked_proceed.setVisibility(View.VISIBLE);

            } else if (accountPlan == 0) {

                iv_booked_proceed.setVisibility(View.VISIBLE);

            } else if (accountPlan == 2) {
                iv_booked_proceed.setVisibility(View.GONE);

            }
        }catch (Exception e){}

        toolbar_back1=findViewById(R.id.toolbar_back1);
        toolbar_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        assistantLabelVoiceRenewHotel=findViewById(R.id.assistant_label_voice_renew_flight);
        relativeImgRenewHotelTamm=findViewById(R.id.relative_img_renew_flight_tamm);
        assistantLabelCallRenewHotel=findViewById(R.id.assistant_label_call_renew_flight);
        assistantLabelMessageRenewHotel=findViewById(R.id.assistant_label_message_renew_flight);
        relativeImgRenewHotelTamm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ClickRenewHotel == false) {
                    assistantLabelCallRenewHotel.setVisibility(View.VISIBLE);
                    assistantLabelMessageRenewHotel.setVisibility(View.VISIBLE);
                    assistantLabelVoiceRenewHotel.setVisibility(View.VISIBLE);
                    ClickRenewHotel = true;

                } else {
                    assistantLabelCallRenewHotel.setVisibility(View.INVISIBLE);
                    assistantLabelMessageRenewHotel.setVisibility(View.INVISIBLE);
                    assistantLabelVoiceRenewHotel.setVisibility(View.INVISIBLE);
                    ClickRenewHotel = false;

                }
            }
        });
        assistantLabelVoiceRenewHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Proceedbeybey.this, VoiceMessageActivity.class);
                startActivity(intent);
                Toast.makeText(Proceedbeybey.this, "Voice", Toast.LENGTH_SHORT).show();
            }
        });
        assistantLabelCallRenewHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Proceedbeybey.this, AssistantActivity.class);
                startActivity(intent);

                Toast.makeText(Proceedbeybey.this, "Call", Toast.LENGTH_SHORT).show();
            }
        });

        assistantLabelMessageRenewHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Proceedbeybey.this, ContactUs.class);
                startActivity(intent);

                Toast.makeText(Proceedbeybey.this, "Message", Toast.LENGTH_SHORT).show();
            }
        });


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

