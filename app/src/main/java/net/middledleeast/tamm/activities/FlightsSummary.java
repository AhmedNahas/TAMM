package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import FlightApi.BookResponse;
import FlightApi.FlightApiService;
import FlightApi.FlightAuthentication;
import FlightApi.FlightBook;
import FlightApi.FlightConstants;
import FlightApi.SearchFlights;
import FlightApi.SearchFlightsResponse;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static net.middledleeast.tamm.activities.FlightSearch.BASE_URL;

public class FlightsSummary extends AppCompatActivity {

    Button proccedBtn;
    @BindView(R.id.toolbar_back1)
    ImageView toolbarBack1;
    @BindView(R.id.toolbar_back)
    RelativeLayout toolbarBack;
    @BindView(R.id.line1)
    View line1;
    @BindView(R.id.tv_price_summary)
    TextView tvPriceSummary;
    @BindView(R.id.line2)
    View line2;
    @BindView(R.id.tv_bey)
    TextView tvBey;
    @BindView(R.id.tv_to)
    TextView tvTo;
    @BindView(R.id.tv_dxb)
    TextView tvDxb;
    @BindView(R.id.tv_country)
    TextView tvCountry;
    @BindView(R.id.tv_ccountry)
    TextView tvCcountry;
    @BindView(R.id.relative_country)
    RelativeLayout relativeCountry;
    @BindView(R.id.tv_flight)
    TextView tvFlight;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.tv_airline)
    TextView tvAirline;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.relative_airline)
    RelativeLayout relativeAirline;
    @BindView(R.id.iv_bag)
    ImageView ivBag;
    @BindView(R.id.tv_kg)
    TextView tvKg;
    @BindView(R.id.iv_bag2)
    ImageView ivBag2;
    @BindView(R.id.relative_package)
    RelativeLayout relativePackage;
    @BindView(R.id.tv_cabin_class)
    TextView tvCabinClass;
    @BindView(R.id.tv_departure)
    TextView tvDeparture;
    @BindView(R.id.tv_date_departure)
    TextView tvDateDeparture;
    @BindView(R.id.tv_arrival)
    TextView tvArrival;
    @BindView(R.id.date_arrival)
    TextView dateArrival;
    @BindView(R.id.tv_bey2)
    TextView tvBey2;
    @BindView(R.id.tv_to2)
    TextView tvTo2;
    @BindView(R.id.tv_dxb2)
    TextView tvDxb2;
    @BindView(R.id.tv_country2)
    TextView tvCountry2;
    @BindView(R.id.tv_ccountry2)
    TextView tvCcountry2;
    @BindView(R.id.relative_country2)
    RelativeLayout relativeCountry2;
    @BindView(R.id.tv_flight2)
    TextView tvFlight2;
    @BindView(R.id.iv_icon2)
    ImageView ivIcon2;
    @BindView(R.id.tv_airline2)
    TextView tvAirline2;
    @BindView(R.id.tv_time2)
    TextView tvTime2;
    @BindView(R.id.relative_airline2)
    RelativeLayout relativeAirline2;
    @BindView(R.id.iv_bag21)
    ImageView ivBag21;
    @BindView(R.id.tv_kg2)
    TextView tvKg2;
    @BindView(R.id.iv_bag22)
    ImageView ivBag22;
    @BindView(R.id.relative_package2)
    RelativeLayout relativePackage2;
    @BindView(R.id.tv_cabin_class2)
    TextView tvCabinClass2;
    @BindView(R.id.tv_departure2)
    TextView tvDeparture2;
    @BindView(R.id.tv_date_departure2)
    TextView tvDateDeparture2;
    @BindView(R.id.tv_arrival2)
    TextView tvArrival2;
    @BindView(R.id.date_arrival2)
    TextView dateArrival2;
    @BindView(R.id.relalala)
    RelativeLayout relalala;
    @BindView(R.id.closure)
    RelativeLayout closure;
    @BindView(R.id.relative_all)
    RelativeLayout relativeAll;
    @BindView(R.id.iv_man_hand)
    ImageView ivManHand;
    @BindView(R.id.tv_cambainBages)
    TextView tvCambainBages;
    private long flightCabinClass;
    private Retrofit retrofit;
    private String password;
    public static final String BASE_URL = "https://xmloutapi.tboair.com/api/v1/";
    private String a_deTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flights_summary);
        ButterKnife.bind(this);
        password = getString(R.string.passowrd_flight);

        proccedBtn = findViewById(R.id.procced_btn);

        proccedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BookingFlight();
            }
        });


        String a_totalFare = SharedPreferencesManger.LoadStringData(this, "A_TotalFare");
        String a_typeFare = SharedPreferencesManger.LoadStringData(this, "A_typeFare");

        String a_airlin_name = SharedPreferencesManger.LoadStringData(this, "A_airlin_name");
        String a_duration = SharedPreferencesManger.LoadStringData(this, "A_duration");

        tvTime.setText(a_duration);
        //
        String a_cabinBaggage = SharedPreferencesManger.LoadStringData(this, "A_CabinBaggage");

        tvCambainBages.setText(a_cabinBaggage);
        String a_includedBaggage = SharedPreferencesManger.LoadStringData(this, "A_IncludedBaggage");

        tvKg.setText(a_includedBaggage);

        // the all time without split  15-09-2019T10-20-55
         a_deTime = SharedPreferencesManger.LoadStringData(this, "A_deTime");
        String a_arrTime = SharedPreferencesManger.LoadStringData(this, "A_arrTime");

        String a_destination = SharedPreferencesManger.LoadStringData(this, "A_destination");
        String a_origin = SharedPreferencesManger.LoadStringData(this, "A_origin");

        String distnation = SharedPreferencesManger.LoadStringData(this, "Distnation");
        String origin = SharedPreferencesManger.LoadStringData(this, "Origin");


        String flightNumber = SharedPreferencesManger.LoadStringData(this, "flightNumber");

        String a_startDateS = SharedPreferencesManger.LoadStringData(this, "A_startDateS");


        String depuruerTime = SharedPreferencesManger.LoadStringData(this, "depuruerTime");
        String arriveTime = SharedPreferencesManger.LoadStringData(this, "arriveTime");
        tvDeparture.setText("Departure: " + depuruerTime);
        tvArrival.setText("Arrival :" + arriveTime);


        dateArrival.setText("Date: " + a_startDateS);
        tvDateDeparture.setText("Date: " + a_startDateS);


        if (a_airlin_name == null) {
            tvAirline.setText("Not Available right now");


        } else {

            tvAirline.setText(a_airlin_name);
        }


        tvFlight.setText("Flight Nb :" + flightNumber);
        // name
        tvCountry.setText(a_origin);
        tvCcountry.setText(a_destination);

        // code
        tvBey.setText(origin);
        tvDxb.setText(distnation);


        flightCabinClass = SharedPreferencesManger.LoadLongData(this, "flightCabinClass");
        switch ((int) flightCabinClass) {

            case 1:
//                All

                tvCabinClass.setText("Cabin Class : All");
                break;
            case 2:
                tvCabinClass.setText("Cabin Class : Economy");
//
                break;
            case 3:
                break;
            case 4:

                tvCabinClass.setText("Cabin Class : Business");

//
                break;

            case 5:
                tvCabinClass.setText("Cabin Class : Royal");

//
                break;
            case 6:
                tvCabinClass.setText("Cabin Class : First");

//

                break;
        }


    }

    private void BookingFlight() {

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
        flightAuthentication[0].setIPAddress("192.168.4.238");

        Call<FlightAuthentication> call = flightApiService.getAuthentication("application/json", flightAuthentication[0]);
        call.enqueue(new Callback<FlightAuthentication>() {
            @Override
            public void onResponse(Call<FlightAuthentication> call, Response<FlightAuthentication> response) {
                flightAuthentication[0] = response.body();


                boolean successful = response.isSuccessful();

                String tokenId = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "tokenId");
                String trackingId = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "trackingId");


                String resultId1 = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "resultId1");
                String PointOfSale = SharedPreferencesManger.LoadStringData(FlightsSummary.this, "PointOfSale");


                final FlightBook[] bookingFlights = {new FlightBook()};

                bookingFlights[0].setIPAddress("192.168.4.238");

                //Origin Country code
                bookingFlights[0].setPointOfSale(PointOfSale);

                bookingFlights[0].setTokenId(tokenId);
                bookingFlights[0].setTrackingId(trackingId);

                bookingFlights[0].setResultId((resultId1));

                bookingFlights[0].setUserData("ahmed");





                FlightBook.Itinerary itinerary = new FlightBook.Itinerary();

                FlightBook.City city = new FlightBook.City();
                FlightBook.Nationality nationality = new FlightBook.Nationality();
                nationality.setCountryCode("EG");
                nationality.setCountryName("CAI");

                FlightBook.Country country = new FlightBook.Country();
                country.setCountryCode("EG");
                country.setCountryName("CAI");

                city.setCityName("Ciro");
                List<FlightBook.Passenger> passengerList = new ArrayList<>();



                FlightBook.Fare fare = new FlightBook.Fare();

                fare.setBaseFare(1230);
                fare.setTax(30);
                fare.setTotalFare(1260);
                fare.setServiceFee(500);



                FlightBook.Passenger passenger = new FlightBook.Passenger();
                passenger.setNationality(nationality);
                passenger.setFirstName("ahmed");
                passenger.setTitle(getString(R.string.adult));
                passenger.setLastName("ahmed");
                passenger.setGender(1);
                passenger.setCity(city);
                passenger.setCountry(country);
               // passenger.setMobile1("00112545645");

passenger.setAddressLine1("");
                passengerList.add(passenger);
                itinerary.setPassenger(passengerList);


                passenger.setFare(fare);
                itinerary.setTravelDate(a_deTime);

               bookingFlights[0].setItinerary(itinerary);



                Call<BookResponse> flightBook = flightApiService.getFlightBook("application/json", bookingFlights[0]);
                flightBook.enqueue(new Callback<BookResponse>() {
                    @Override
                    public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {


                        String ssrMessage = response.body().getTokenId();
                        Toast.makeText(FlightsSummary.this, ""+ssrMessage, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<BookResponse> call, Throwable t) {

                        Toast.makeText(FlightsSummary.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
//

            }

            @Override
            public void onFailure(Call<FlightAuthentication> call, Throwable t) {


                Toast.makeText(FlightsSummary.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

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
