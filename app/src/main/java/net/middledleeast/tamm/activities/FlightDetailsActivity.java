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
    @BindView(R.id.go_home)
    Button Home;
    private Retrofit retrofit;

    public static final String BASE_URL = "https://xmloutapi.tboair.com/api/v1/";
    private AppDatabase appDatabase;
    private long adult;
    private String pnr2;
    private String firstName2;
    private String lastName2,


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




    }




    @OnClick(R.id.my_trips)
    public void onViewClicked() {

        startActivity(new Intent(FlightDetailsActivity.this, MyTripsActivity.class));





    }

    private void getTecjit() {

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


                Itinerary data = response.body().getItinerary();


                Segment segment = data.getSegments().get(0);
                String flightNumber = segment.getFlightNumber();

                FLIGHT_NO = "FLIGHT   " + flightNumber+" / ";
                String countryName = segment.getOrigin().getCityName();
                GROUND_TIME = segment.getAccumulatedDuration();


                String departureTime = segment.getDepartureTime();


                String[] ts = departureTime.split("T");
                String t = ts[0];
                DATE = "DATE   " + t;



                String to = SharedPreferencesManger.LoadStringData(FlightDetailsActivity.this, "to");
                String from = SharedPreferencesManger.LoadStringData(FlightDetailsActivity.this, "from");


                for (int i = 0; i < data.getSegments().size(); i++) {


                    FROM = countryName + "  /  " + from;

                    TO = data.getSegments().get(i).getDestination().getCityName() + "  /  " + to;





                }

                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();


                switch ((int) adult){



                    case 1:

                        Passenger passenger1 = data.getPassenger().get(0);

                        String firstName = passenger1.getFirstName();
                        String lastName= passenger1.getLastName();
                        NAME_PASSENGER = firstName + " / " + lastName;

                        String teckit1 = (String) response.body().getItinerary().getPassenger().get(0).getTicket().getTicketNumber();

                        TICKIT_NO = "TicketNo  : " + teckit1;

                        RoomCartModel roomTripModel = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                                FLIGHT_NO, DATE, "7", "7A", GROUND_TIME, TICKIT_NO);

                        appDatabase.cartDao().addoffer(roomTripModel);


                        break;

                    case 2:


                        Passenger passenger1_2 = data.getPassenger().get(0);

                        String firstName_2 = passenger1_2.getFirstName();
                        String lastName_2= passenger1_2.getLastName();
                        NAME_PASSENGER = firstName_2 + " / " + lastName_2;

                        String pnr1_2 = (String) response.body().getItinerary().getPassenger().get(0).getTicket().getTicketNumber();

                        TICKIT_NO = "TicketNo  : " + pnr1_2;



                         String  tickit2 = (String) response.body().getItinerary().getPassenger().get(1).getTicket().getTicketNumber();

                        pnr2 = "TicketNo  : " + tickit2;


                        Passenger passenger2 = data.getPassenger().get(1);

                        firstName2 = passenger2.getFirstName();
                        lastName2 = passenger2.getLastName();

                        RoomCartModel roomTripModel1 = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                                FLIGHT_NO, DATE, "7", "7A", GROUND_TIME, TICKIT_NO);


                        appDatabase.cartDao().addoffer(roomTripModel1);

                        RoomCartModel roomTripModel2 = new RoomCartModel(firstName2 + " / " + lastName2, FROM, TO
                                , FLIGHT_NO, DATE, "Gate 7", "SEAT 1A", GROUND_TIME, pnr2);

                        appDatabase.cartDao().addoffer(roomTripModel2);

                       startActivity(new Intent(FlightDetailsActivity.this, MyTripsActivity.class));

                        break;

                    case 3:



                        Passenger passenger_3 = data.getPassenger().get(0);

                        String firstName_3 = passenger_3.getFirstName();
                        String lastName_3= passenger_3.getLastName();
                        NAME_PASSENGER = firstName_3 + " / " + lastName_3;

                        String pnr1_3 = (String) response.body().getItinerary().getPassenger().get(0).getTicket().getTicketNumber();

                        TICKIT_NO = "TicketNo  : " + pnr1_3;



                    String    teckit2_3 = (String) response.body().getItinerary().getPassenger().get(1).getTicket().getTicketNumber();

                    pnr2 =  "TicketNo  : " + teckit2_3;


                        Passenger passenger2_3 = data.getPassenger().get(1);

                        firstName2 = passenger2_3.getFirstName();
                        lastName2 = passenger2_3.getLastName();


                       String  teckit3_3 = (String) response.body().getItinerary().getPassenger().get(2).getTicket().getTicketNumber();

                        pnr3 =   "TicketNo  : " + teckit3_3;


                        Passenger passenger3 = data.getPassenger().get(2);

                        firstName3 = passenger3.getFirstName();
                        lastName3 = passenger3.getLastName();

                        RoomCartModel roomTripModel1_3 = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                                FLIGHT_NO, DATE, "7", "7A", GROUND_TIME, TICKIT_NO);


                        appDatabase.cartDao().addoffer(roomTripModel1_3);

                        RoomCartModel roomTripModel2_3 = new RoomCartModel(firstName2 + " / " + lastName2, FROM, TO
                                , FLIGHT_NO, DATE, "Gate 7", "SEAT 1A", GROUND_TIME, pnr2);

                        appDatabase.cartDao().addoffer(roomTripModel2_3);


                        RoomCartModel roomTripModel3_3 = new RoomCartModel(firstName3 + " / " + lastName3, FROM, TO,
                                FLIGHT_NO
                                , DATE,
                                "Gate 15",
                                "Seat 5A"
                                , GROUND_TIME,
                                pnr3);
                        appDatabase.cartDao().addoffer(roomTripModel3_3);

                        startActivity(new Intent(FlightDetailsActivity.this, MyTripsActivity.class));

                        break;


                    case 4:



                        Passenger passenger_4 = data.getPassenger().get(0);

                        String firstName_4 = passenger_4.getFirstName();
                        String lastName_4= passenger_4.getLastName();
                        NAME_PASSENGER = firstName_4 + " / " + lastName_4;

                        String pnr1_4 = (String) response.body().getItinerary().getPassenger().get(0).getTicket().getTicketNumber();

                        TICKIT_NO = "TicketNo  : " + pnr1_4;

                        String    teckit2_4 = (String) response.body().getItinerary().getPassenger().get(1).getTicket().getTicketNumber();

                        pnr2 = "TicketNo  : " + teckit2_4;


                        Passenger passenger2_4 = data.getPassenger().get(1);

                        firstName2 = passenger2_4.getFirstName();
                        lastName2 = passenger2_4.getLastName();


                        String    teckit3_4 = (String) response.body().getItinerary().getPassenger().get(2).getTicket().getTicketNumber();

                        pnr3 = "TicketNo  : " + teckit3_4;
                        Passenger passenger4 = data.getPassenger().get(2);

                        firstName3 = passenger4.getFirstName();
                        lastName3 = passenger4.getLastName();





                     String    tickit_4_ = (String) response.body().getItinerary().getPassenger().get(3).getTicket().getTicketNumber();

                     pnr4 =    "TicketNo  : " + tickit_4_;


                        Passenger passenger4_4 = data.getPassenger().get(3);

                        firstName4 = passenger4_4.getFirstName();
                        lastName4 = passenger4_4.getLastName();
                        RoomCartModel roomTripModel1_4 = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                                FLIGHT_NO, DATE, "7", "7A", GROUND_TIME, TICKIT_NO);


                        appDatabase.cartDao().addoffer(roomTripModel1_4);

                        RoomCartModel roomTripModel2_4 = new RoomCartModel(firstName2 + " / " + lastName2, FROM, TO
                                , FLIGHT_NO, DATE, "Gate 7", "SEAT 1A", GROUND_TIME, pnr2);
                        appDatabase.cartDao().addoffer(roomTripModel2_4);


                        RoomCartModel roomTripModel3_4 = new RoomCartModel(firstName3 + " / " + lastName3, FROM, TO,
                                FLIGHT_NO
                                , DATE,
                                "Gate 15",
                                "Seat 5A"
                                , GROUND_TIME,
                                pnr3);
                        appDatabase.cartDao().addoffer(roomTripModel3_4);


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
                       startActivity(new Intent(FlightDetailsActivity.this, MyTripsActivity.class));
                        break;


                    case 5:






                        Passenger passenger_5 = data.getPassenger().get(0);

                        String firstName_5 = passenger_5.getFirstName();
                        String lastName_5= passenger_5.getLastName();
                        NAME_PASSENGER = firstName_5 + " / " + lastName_5;

                        String pnr1_5 = (String) response.body().getItinerary().getPassenger().get(0).getTicket().getTicketNumber();

                        TICKIT_NO = "TicketNo  : " + pnr1_5;

                        String    teckit2_5 = (String) response.body().getItinerary().getPassenger().get(1).getTicket().getTicketNumber();

                        pnr2 = "TicketNo  : " + teckit2_5;


                        Passenger passenger2_5 = data.getPassenger().get(1);

                        firstName2 = passenger2_5.getFirstName();
                        lastName2 = passenger2_5.getLastName();


                        String    teckit3_5 = (String) response.body().getItinerary().getPassenger().get(2).getTicket().getTicketNumber();

                        pnr3 = "TicketNo  : " + teckit3_5;
                        Passenger passenger5 = data.getPassenger().get(2);

                        firstName3 = passenger5.getFirstName();
                        lastName3 = passenger5.getLastName();





                        String    tickit_5_ = (String) response.body().getItinerary().getPassenger().get(3).getTicket().getTicketNumber();

                        pnr4 =    "TicketNo  : " + tickit_5_;


                        Passenger passenger4_5 = data.getPassenger().get(3);

                        firstName4 = passenger4_5.getFirstName();
                        lastName4 = passenger4_5.getLastName();














                      String  teckit5_5 = (String) response.body().getItinerary().getPassenger().get(4).getTicket().getTicketNumber();

                        pnr5 =    "TicketNo  : " + teckit5_5;


                        Passenger passenger5_5 = data.getPassenger().get(4);

                        firstName5 = passenger5_5.getFirstName();
                        lastName5 = passenger5_5.getLastName();


                        RoomCartModel roomTripModel1_5 = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                                FLIGHT_NO, DATE, "7", "7A", GROUND_TIME, TICKIT_NO);


                        appDatabase.cartDao().addoffer(roomTripModel1_5);

                        RoomCartModel roomTripModel2_5 = new RoomCartModel(firstName2 + " / " + lastName2, FROM, TO
                                , FLIGHT_NO, DATE, "Gate 7", "SEAT 1A", GROUND_TIME, pnr2);
                        appDatabase.cartDao().addoffer(roomTripModel2_5);


                        RoomCartModel roomTripModel3_5 = new RoomCartModel(firstName3 + " / " + lastName3, FROM, TO,
                                FLIGHT_NO
                                , DATE,
                                "Gate 15",
                                "Seat 5A"
                                , GROUND_TIME,
                                pnr3);

                        appDatabase.cartDao().addoffer(roomTripModel3_5);


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

                       startActivity(new Intent(FlightDetailsActivity.this, MyTripsActivity.class));

                        break;
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

}
