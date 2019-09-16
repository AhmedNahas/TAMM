package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;
import net.middledleeast.tamm.model.Room.AppDatabase;
import net.middledleeast.tamm.model.Room.RoomCartModel;

import org.joda.time.Hours;

import java.util.concurrent.TimeUnit;

import FlightApi.FlightApiService;
import FlightApi.FlightGetBooking;
import FlightApi.GetBookingResponse;
import FlightApi.Itinerary;
import FlightApi.Passenger;
import FlightApi.Segment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static net.middledleeast.tamm.helper.helperMethod.getLocalIpAddress;

public class FlightDetailsActivity extends AppCompatActivity {

    @BindView(R.id.my_trips)
    Button myTripBtn;
    @BindView(R.id.back_to_hotel)
    Button Home;
    private Retrofit retrofit;

    public static final String BASE_URL = "https://xmloutapi.tboair.com/api/v1/";
    private AppDatabase appDatabase;
    private long adult;
    private String pnr2;
    private String firstName;
    private String lastName,


    pnr3,
            firstName3,
            lastName3,
            pnr4,
            firstName4,
            lastName4,
            pnr5,
            firstName5,
            lastName5,


    FLIGHT_NO,
            FROM,
            TO,
            GROUND_TIME,
            NAME_PASSENGER,
            DATE,
            TICKIT_NO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);
        ButterKnife.bind(this);


        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(FlightDetailsActivity.this, RenewAccount.class));

            }
        });

        adult = SharedPreferencesManger.LoadLongData(this, "adult");

        FlightGetBooking flightGetBooking = new FlightGetBooking();
        String localIpAddress = getLocalIpAddress();

        String pnr = SharedPreferencesManger.LoadStringData(FlightDetailsActivity.this, "pnr");
        String tokenId2 = SharedPreferencesManger.LoadStringData(FlightDetailsActivity.this, "tokenId2");

        flightGetBooking.setIPAddress(localIpAddress);
        flightGetBooking.setPNR(pnr);
        flightGetBooking.setTokinId(tokenId2);

        Gson gson = new GsonBuilder()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).connectTimeout(0, TimeUnit.SECONDS)
                .readTimeout(0, TimeUnit.SECONDS).build();

        connectAndGetApiData(gson, client);
        FlightApiService flightApiService = retrofit.create(FlightApiService.class);

        flightApiService.getFlightbooking("application/json", flightGetBooking).enqueue(new Callback<GetBookingResponse>() {
            @Override
            public void onResponse(Call<GetBookingResponse> call, Response<GetBookingResponse> response) {


                try {

                    Itinerary data = response.body().getItinerary();


                    String pnr1 = (String) response.body().getItinerary().getPassenger().get(0).getTicket().getTicketNumber();


                    pnr2 = (String) response.body().getItinerary().getPassenger().get(1).getTicket().getTicketNumber();

                    Passenger passenger2 = data.getPassenger().get(1);

                    firstName = passenger2.getFirstName();
                    lastName = passenger2.getLastName();


                    pnr3 = (String) response.body().getItinerary().getPassenger().get(2).getTicket().getTicketNumber();

                    Passenger passenger3 = data.getPassenger().get(2);

                    firstName3 = passenger3.getFirstName();
                    lastName3 = passenger3.getLastName();


                    pnr4 = (String) response.body().getItinerary().getPassenger().get(3).getTicket().getTicketNumber();

                    Passenger passenger4 = data.getPassenger().get(3);

                    firstName4 = passenger4.getFirstName();
                    lastName4 = passenger4.getLastName();


                    pnr5 = (String) response.body().getItinerary().getPassenger().get(4).getTicket().getTicketNumber();

                    Passenger passenger5 = data.getPassenger().get(4);

                    firstName5 = passenger5.getFirstName();
                    lastName5 = passenger5.getLastName();

                    Segment segment = data.getSegments().get(0);
                    String flightNumber = segment.getFlightNumber();

                    FLIGHT_NO = "FLIGHT   " + flightNumber;


                    String countryCode = segment.getOrigin().getCityCode();
                    String countryName = segment.getOrigin().getCityName();
                    String countryCode1 = segment.getDestination().getCityCode();
                    String countryName1 = segment.getDestination().getCityName();


                    String to = SharedPreferencesManger.LoadStringData(FlightDetailsActivity.this, "to");
                    String from = SharedPreferencesManger.LoadStringData(FlightDetailsActivity.this, "from");


                    for (int i = 0; i < data.getSegments().size(); i++) {


                        FROM = countryName + "  /  " + from;

                        TO = data.getSegments().get(i).getDestination().getCityName() + "  /  " + to;

                    }


                    GROUND_TIME = segment.getAccumulatedDuration();

                    Passenger passenger = data.getPassenger().get(0);

                    String firstName = passenger.getFirstName();
                    String lastName = passenger.getLastName();
                    NAME_PASSENGER = firstName + " / " + lastName;

                    String departureTime = segment.getDepartureTime();


                    String[] ts = departureTime.split("T");
                    String t = ts[0];
                    DATE = "DATE   " + t;

                    TICKIT_NO = "TicketNo  : " + pnr1;


                } catch (Exception e) {
                }


            }

            @Override
            public void onFailure(Call<GetBookingResponse> call, Throwable t) {

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

    @OnClick(R.id.my_trips)
    public void onViewClicked() {



        switch ((int) adult) {

            case 1:
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

                RoomCartModel roomTripModel = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                        FLIGHT_NO, DATE, "7", "7a", GROUND_TIME, TICKIT_NO);

                appDatabase.cartDao().addoffer(roomTripModel);


                startActivity(new Intent(this, MyTripsActivity.class));

                break;

            case 2:


                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

                RoomCartModel roomTripModel1 = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                        FLIGHT_NO, DATE, "7", "7a", GROUND_TIME, TICKIT_NO);


                appDatabase.cartDao().addoffer(roomTripModel1);
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

                RoomCartModel roomTripModel2 = new RoomCartModel(firstName + " / " + lastName, FROM, TO
                        , FLIGHT_NO, DATE, "Gate 7", "SEAT 1A", GROUND_TIME, pnr2);

                appDatabase.cartDao().addoffer(roomTripModel2);

                startActivity(new Intent(this, MyTripsActivity.class));

                break;

            case 3:
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

                RoomCartModel roomTripModel1_3 = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                        FLIGHT_NO, DATE, "7", "7a", GROUND_TIME, TICKIT_NO);


                appDatabase.cartDao().addoffer(roomTripModel1_3);
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

                RoomCartModel roomTripModel2_3 = new RoomCartModel(firstName + " / " + lastName, FROM, TO
                        , FLIGHT_NO, DATE, "Gate 7", "SEAT 1A", GROUND_TIME, pnr2);

                appDatabase.cartDao().addoffer(roomTripModel2_3);
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();


                RoomCartModel roomTripModel3_3 = new RoomCartModel(firstName3 + " / " + lastName3, FROM, TO,
                        FLIGHT_NO
                        , DATE,
                        "Gate 15",
                        "Seat 5A"
                        , GROUND_TIME,
                        pnr3);
                appDatabase.cartDao().addoffer(roomTripModel3_3);

                startActivity(new Intent(this, MyTripsActivity.class));

                break;


            case 4:
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

                RoomCartModel roomTripModel1_4 = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                        FLIGHT_NO, DATE, "7", "7a", GROUND_TIME, TICKIT_NO);


                appDatabase.cartDao().addoffer(roomTripModel1_4);
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

                RoomCartModel roomTripModel2_4 = new RoomCartModel(firstName + " / " + lastName, FROM, TO
                        , FLIGHT_NO, DATE, "Gate 7", "SEAT 1A", GROUND_TIME, pnr2);
                appDatabase.cartDao().addoffer(roomTripModel2_4);

                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

                RoomCartModel roomTripModel3_4 = new RoomCartModel(firstName3 + " / " + lastName3, FROM, TO,
                        FLIGHT_NO
                        , DATE,
                        "Gate 15",
                        "Seat 5A"
                        , GROUND_TIME,
                        pnr3);
                appDatabase.cartDao().addoffer(roomTripModel3_4);

                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

                RoomCartModel roomTripModel4_4 = new RoomCartModel(firstName4 + " / " + lastName4,
                        FROM,
                        TO,
                        FLIGHT_NO,
                        DATE,
                        "Gate 12",
                        "Seat 1B",
                        GROUND_TIME,
                        pnr4);
                appDatabase.cartDao().addoffer(roomTripModel4_4);
                startActivity(new Intent(this, MyTripsActivity.class));

                break;


            case 5:
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

                RoomCartModel roomTripModel1_5 = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                        FLIGHT_NO, DATE, "7", "7a", GROUND_TIME, TICKIT_NO);


                appDatabase.cartDao().addoffer(roomTripModel1_5);
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

                RoomCartModel roomTripModel2_5 = new RoomCartModel(firstName + " / " + lastName, FROM, TO
                        , FLIGHT_NO, DATE, "Gate 7", "SEAT 1A", GROUND_TIME, pnr2);
                appDatabase.cartDao().addoffer(roomTripModel2_5);

                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

                RoomCartModel roomTripModel3_5 = new RoomCartModel(firstName3 + " / " + lastName3, FROM, TO,
                        FLIGHT_NO
                        , DATE,
                        "Gate 15",
                        "Seat 5A"
                        , GROUND_TIME,
                        pnr3);

                appDatabase.cartDao().addoffer(roomTripModel3_5);
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();


                RoomCartModel roomTripModel4_5 = new RoomCartModel(firstName4 + " / " + lastName4,
                        FROM,
                        TO,
                        FLIGHT_NO,
                        DATE,
                        "Gate 12",
                        "Seat 1B",
                        GROUND_TIME,
                        pnr4);

                appDatabase.cartDao().addoffer(roomTripModel4_5);
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();
                RoomCartModel roomTripModel5_5 = new RoomCartModel(firstName5 + " / " + lastName5
                        , FROM
                        , TO,
                        FLIGHT_NO
                        , DATE,
                        "Gate 17",
                        "Seat 4C",
                        GROUND_TIME,
                        pnr5);

                appDatabase.cartDao().addoffer(roomTripModel5_5);

                startActivity(new Intent(this, MyTripsActivity.class));

                break;

        }




    }


}
