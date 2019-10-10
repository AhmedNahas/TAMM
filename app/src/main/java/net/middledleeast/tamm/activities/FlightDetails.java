package net.middledleeast.tamm.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;
import net.middledleeast.tamm.model.AllLinks.LinksUrl;
import net.middledleeast.tamm.model.Room.AppDatabase;
import net.middledleeast.tamm.model.Room.RoomCartModel;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
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

@SuppressLint("RestrictedApi")
public class FlightDetails extends AppCompatActivity  {

    @BindView(R.id.back_to_hotel)
    Button backToHotel;
    @BindView(R.id.back_flight)
    Button back_flight;

    @BindView(R.id.get_code)
    Button getCode;
    private Retrofit retrofit;
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
    public static final String BASE_URL = "https://xmloutapi.tboair.com/api/v1/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_details);
        ButterKnife.bind(this);

 SharedPreferencesManger.remove(this, "to");
      SharedPreferencesManger.remove(this, "from");




    }


    @OnClick({R.id.iv_booked_flight_details, R.id.get_code, R.id.back_to_hotel,R.id.back_flight})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_booked_flight_details:
                startActivity(new Intent(FlightDetails.this,MyTripsActivity.class));

                break;
            case R.id.get_code:


                getTecjit();




                break;
            case R.id.back_to_hotel:

                startActivity(new Intent(FlightDetails.this, FindHotels .class));

                break;
            case R.id.back_flight:
                startActivity(new Intent(FlightDetails.this,RenewAccount.class));

                break;
        }
    }

    private void getTecjit() {


        int journyTipe = SharedPreferencesManger.LoadIntegerData(this, "journyTipe");



        adult = SharedPreferencesManger.LoadLongData(this, "adult");

        FlightGetBooking flightGetBooking = new FlightGetBooking();
        String localIpAddress = getLocalIpAddress();

        String pnr = SharedPreferencesManger.LoadStringData(FlightDetails.this, "pnr");
        String tokenId2 = SharedPreferencesManger.LoadStringData(FlightDetails.this, "tokenId2");

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


                String email = data.getPassenger().get(0).getEmail();

                Double price = data.getPassenger().get(0).getFare().getTotalFare();


//                for (int i = 0; i < data.getSegments().size(); i++) {


                    FROM = countryName + "  /  ";


                for (int i = 0; i < data.getSegments().size(); i++) {

                    TO = data.getSegments().get(i).getDestination().getCityName() + "  /  ";

                }







//                }

                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();


                switch ((int) adult){

                    case 1:
                        Passenger passenger1 = data.getPassenger().get(0);

                        String firstName = passenger1.getFirstName();
                        String lastName= passenger1.getLastName();
                        NAME_PASSENGER = firstName + " / " + lastName;
                        String teckit1 = (String) response.body().getItinerary().getPassenger().get(0).getTicket().getTicketNumber();

                        TICKIT_NO = "TicketNo  : " + teckit1;
                                String airlineCode = segment.getAirline();

                        if (journyTipe==2){


                            Segment segmentReturn = data.getSegments().get(1);

                            String airlineCodeReturn = segmentReturn.getAirline();

                            String flightNumberReturn = segmentReturn.getFlightNumber();
                            String departureTimeReturn = segmentReturn.getDepartureTime();


                            String[] tsReturn = departureTimeReturn.split("T");
                            String tReturn = tsReturn[0];
                            String DateReturn = "DATE   " + tReturn;

                            String timeReturn = segmentReturn.getAccumulatedDuration();

                            sendDataToEMailReturn(NAME_PASSENGER ,FROM,TO,FLIGHT_NO,DATE,TICKIT_NO, String.valueOf(price),email , data.getSegments().get(0).getAirlineName(),TO,FROM,flightNumberReturn,DateReturn,data.getSegments().get(1).getAirlineName());
//

                        }else {
                            RoomCartModel roomTripModel = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                                    FLIGHT_NO, DATE, airlineCode, airlineCode , GROUND_TIME, TICKIT_NO);

                            appDatabase.cartDao().addoffer(roomTripModel);
                            sendDataToEMail(NAME_PASSENGER ,FROM,TO,FLIGHT_NO,DATE,TICKIT_NO, String.valueOf(price),email , data.getSegments().get(0).getAirlineName());

                        }



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
                        airlineCode = segment.getAirline();






                        if (journyTipe==2) {


                            Segment segmentReturn = data.getSegments().get(1);

                            String airlineCodeReturn = segmentReturn.getAirline();

                            String flightNumberReturn = segmentReturn.getFlightNumber();
                            String departureTimeReturn = segmentReturn.getDepartureTime();


                            String[] tsReturn = departureTimeReturn.split("T");
                            String tReturn = tsReturn[0];
                            String DateReturn = "DATE   " + tReturn;

                            String timeReturn = segmentReturn.getAccumulatedDuration();


                            sendDataToEMailReturn(NAME_PASSENGER, FROM, TO, FLIGHT_NO, DATE, TICKIT_NO, String.valueOf(price), email, data.getSegments().get(0).getAirlineName(), TO, FROM, flightNumberReturn, DateReturn, data.getSegments().get(1).getAirlineName());
                            sendDataToEMailReturn(firstName2 + " / " + lastName2 ,FROM,TO,FLIGHT_NO,DATE,pnr2, String.valueOf(price),email,data.getSegments().get(0).getAirlineName(),
                                    TO, FROM, flightNumberReturn, DateReturn, data.getSegments().get(1).getAirlineName());

//
                        }else {


                            RoomCartModel roomTripModel1 = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                                    FLIGHT_NO, DATE,airlineCode , airlineCode, GROUND_TIME, TICKIT_NO);
                            appDatabase.cartDao().addoffer(roomTripModel1);

                            RoomCartModel roomTripModel2 = new RoomCartModel(firstName2 + " / " + lastName2, FROM, TO
                                    , FLIGHT_NO, DATE, airlineCode, airlineCode, GROUND_TIME, pnr2);

                            appDatabase.cartDao().addoffer(roomTripModel2);
                            sendDataToEMail(NAME_PASSENGER ,FROM,TO,FLIGHT_NO,DATE,TICKIT_NO, String.valueOf(price),email,data.getSegments().get(0).getAirlineName());
                            sendDataToEMail(firstName2 + " / " + lastName2 ,FROM,TO,FLIGHT_NO,DATE,pnr2, String.valueOf(price),email,data.getSegments().get(0).getAirlineName());


                        }






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

                        airlineCode = segment.getAirline();







                        if (journyTipe==2) {


                            Segment segmentReturn = data.getSegments().get(1);

                            String airlineCodeReturn = segmentReturn.getAirline();

                            String flightNumberReturn = segmentReturn.getFlightNumber();
                            String departureTimeReturn = segmentReturn.getDepartureTime();


                            String[] tsReturn = departureTimeReturn.split("T");
                            String tReturn = tsReturn[0];
                            String DateReturn = "DATE   " + tReturn;

                            String timeReturn = segmentReturn.getAccumulatedDuration();


                            sendDataToEMailReturn(NAME_PASSENGER, FROM, TO, FLIGHT_NO, DATE, TICKIT_NO, String.valueOf(price), email, data.getSegments().get(0).getAirlineName(),
                                    TO, FROM, flightNumberReturn, DateReturn, data.getSegments().get(1).getAirlineName());
                            sendDataToEMailReturn(firstName2 + " / " + lastName2, FROM, TO, FLIGHT_NO, DATE, pnr2, String.valueOf(price), email, data.getSegments().get(0).getAirlineName(),
                                    TO, FROM, flightNumberReturn, DateReturn, data.getSegments().get(1).getAirlineName());
                            sendDataToEMailReturn(firstName3 + " / " + lastName3, FROM, TO, FLIGHT_NO, DATE, pnr3, String.valueOf(price), email, data.getSegments().get(0).getAirlineName(),
                                    TO, FROM, flightNumberReturn, DateReturn, data.getSegments().get(1).getAirlineName());


                        }else {


                            RoomCartModel roomTripModel1_3 = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                                    FLIGHT_NO, DATE, airlineCode, airlineCode, GROUND_TIME, TICKIT_NO);


                            appDatabase.cartDao().addoffer(roomTripModel1_3);

                            RoomCartModel roomTripModel2_3 = new RoomCartModel(firstName2 + " / " + lastName2, FROM, TO
                                    , FLIGHT_NO, DATE, airlineCode, airlineCode, GROUND_TIME, pnr2);

                            appDatabase.cartDao().addoffer(roomTripModel2_3);


                            RoomCartModel roomTripModel3_3 = new RoomCartModel(firstName3 + " / " + lastName3, FROM, TO,
                                    FLIGHT_NO
                                    , DATE,
                                    airlineCode,
                                    airlineCode
                                    , GROUND_TIME,
                                    pnr3);
                            appDatabase.cartDao().addoffer(roomTripModel3_3);


                            sendDataToEMail(NAME_PASSENGER ,FROM,TO,FLIGHT_NO,DATE,TICKIT_NO, String.valueOf(price),email,data.getSegments().get(0).getAirlineName());
                            sendDataToEMail(firstName2 + " / " + lastName2 ,FROM,TO,FLIGHT_NO,DATE,pnr2, String.valueOf(price),email,data.getSegments().get(0).getAirlineName());
                            sendDataToEMail(firstName3 + " / " + lastName3 ,FROM,TO,FLIGHT_NO,DATE,pnr3, String.valueOf(price),email,data.getSegments().get(0).getAirlineName());


                        }







                            break;


                    case 4:









                        airlineCode = segment.getAirline();
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






                        if (journyTipe==2) {


                            Segment segmentReturn = data.getSegments().get(1);

                            String airlineCodeReturn = segmentReturn.getAirline();

                            String flightNumberReturn = segmentReturn.getFlightNumber();
                            String departureTimeReturn = segmentReturn.getDepartureTime();


                            String[] tsReturn = departureTimeReturn.split("T");
                            String tReturn = tsReturn[0];
                            String DateReturn = "DATE   " + tReturn;

                            String timeReturn = segmentReturn.getAccumulatedDuration();


                            sendDataToEMailReturn(NAME_PASSENGER, FROM, TO, FLIGHT_NO, DATE, TICKIT_NO, String.valueOf(price), email, data.getSegments().get(0).getAirlineName(),
                                    TO, FROM, flightNumberReturn, DateReturn, data.getSegments().get(1).getAirlineName());
                            sendDataToEMailReturn(firstName2 + " / " + lastName2, FROM, TO, FLIGHT_NO, DATE, pnr2, String.valueOf(price), email, data.getSegments().get(0).getAirlineName(),
                                    TO, FROM, flightNumberReturn, DateReturn, data.getSegments().get(1).getAirlineName());
                            sendDataToEMailReturn(firstName4 + " / " + lastName4 ,FROM,TO,FLIGHT_NO,DATE,pnr4, String.valueOf(price), email, data.getSegments().get(0).getAirlineName(),
                                    TO, FROM, flightNumberReturn, DateReturn, data.getSegments().get(1).getAirlineName()); sendDataToEMailReturn(firstName3 + " / " + lastName3, FROM, TO, FLIGHT_NO, DATE, pnr3, String.valueOf(price), email, data.getSegments().get(0).getAirlineName(),
                                    TO, FROM, flightNumberReturn, DateReturn, data.getSegments().get(1).getAirlineName());



                        }else {

                            RoomCartModel roomTripModel1_4 = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                                    FLIGHT_NO, DATE, airlineCode, airlineCode, GROUND_TIME, TICKIT_NO);


                            appDatabase.cartDao().addoffer(roomTripModel1_4);

                            RoomCartModel roomTripModel2_4 = new RoomCartModel(firstName2 + " / " + lastName2, FROM, TO
                                    , FLIGHT_NO, DATE, airlineCode, airlineCode, GROUND_TIME, pnr2);
                            appDatabase.cartDao().addoffer(roomTripModel2_4);


                            RoomCartModel roomTripModel3_4 = new RoomCartModel(firstName3 + " / " + lastName3, FROM, TO,
                                    FLIGHT_NO
                                    , DATE,
                                    airlineCode,
                                    airlineCode
                                    , GROUND_TIME,
                                    pnr3);
                            appDatabase.cartDao().addoffer(roomTripModel3_4);


                            RoomCartModel roomTripModel4_4 = new RoomCartModel(firstName4 + " / " + lastName4,
                                    FROM,
                                    TO,
                                    FLIGHT_NO,
                                    DATE,
                                    airlineCode,
                                    airlineCode,
                                    GROUND_TIME,
                                    pnr4);
                            appDatabase.cartDao().addoffer(roomTripModel4_4);


                            sendDataToEMail(NAME_PASSENGER ,FROM,TO,FLIGHT_NO,DATE,TICKIT_NO, String.valueOf(price),email,data.getSegments().get(0).getAirlineName());
                            sendDataToEMail(firstName2 + " / " + lastName2 ,FROM,TO,FLIGHT_NO,DATE,pnr2, String.valueOf(price),email,data.getSegments().get(0).getAirlineName());
                            sendDataToEMail(firstName3 + " / " + lastName3 ,FROM,TO,FLIGHT_NO,DATE,pnr3, String.valueOf(price),email,data.getSegments().get(0).getAirlineName());
                            sendDataToEMail(firstName4 + " / " + lastName4 ,FROM,TO,FLIGHT_NO,DATE,pnr4, String.valueOf(price),email,data.getSegments().get(0).getAirlineName());






                        }


















                        break;


                    case 5:





                        airlineCode = segment.getAirline();
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





                        if (journyTipe==2) {


                            Segment segmentReturn = data.getSegments().get(1);

                            String airlineCodeReturn = segmentReturn.getAirline();

                            String flightNumberReturn = segmentReturn.getFlightNumber();
                            String departureTimeReturn = segmentReturn.getDepartureTime();


                            String[] tsReturn = departureTimeReturn.split("T");
                            String tReturn = tsReturn[0];
                            String DateReturn = "DATE   " + tReturn;

                            String timeReturn = segmentReturn.getAccumulatedDuration();


                            sendDataToEMailReturn(NAME_PASSENGER, FROM, TO, FLIGHT_NO, DATE, TICKIT_NO, String.valueOf(price), email, data.getSegments().get(0).getAirlineName(),
                                    TO, FROM, flightNumberReturn, DateReturn, data.getSegments().get(1).getAirlineName());
                            sendDataToEMailReturn(firstName2 + " / " + lastName2, FROM, TO, FLIGHT_NO, DATE, pnr2, String.valueOf(price), email, data.getSegments().get(0).getAirlineName(),
                                    TO, FROM, flightNumberReturn, DateReturn, data.getSegments().get(1).getAirlineName());
                            sendDataToEMailReturn(firstName4 + " / " + lastName4, FROM, TO, FLIGHT_NO, DATE, pnr4, String.valueOf(price), email, data.getSegments().get(0).getAirlineName(),
                                    TO, FROM, flightNumberReturn, DateReturn, data.getSegments().get(1).getAirlineName());
                            sendDataToEMailReturn(firstName3 + " / " + lastName3, FROM, TO, FLIGHT_NO, DATE, pnr3, String.valueOf(price), email, data.getSegments().get(0).getAirlineName(),
                                    TO, FROM, flightNumberReturn, DateReturn, data.getSegments().get(1).getAirlineName());
                            sendDataToEMailReturn(firstName5 + " / " + lastName5 ,FROM, TO, FLIGHT_NO, DATE, pnr5, String.valueOf(price), email, data.getSegments().get(0).getAirlineName(),
                                    TO, FROM, flightNumberReturn, DateReturn, data.getSegments().get(1).getAirlineName());


                        }else {

                            RoomCartModel roomTripModel1_5 = new RoomCartModel(NAME_PASSENGER, FROM, TO,
                                    FLIGHT_NO, DATE, airlineCode, airlineCode, GROUND_TIME, TICKIT_NO);


                            appDatabase.cartDao().addoffer(roomTripModel1_5);

                            RoomCartModel roomTripModel2_5 = new RoomCartModel(firstName2 + " / " + lastName2, FROM, TO
                                    , FLIGHT_NO, DATE, airlineCode, airlineCode, GROUND_TIME, pnr2);
                            appDatabase.cartDao().addoffer(roomTripModel2_5);


                            RoomCartModel roomTripModel3_5 = new RoomCartModel(firstName3 + " / " + lastName3, FROM, TO,
                                    FLIGHT_NO
                                    , DATE,
                                    airlineCode,
                                    airlineCode
                                    , GROUND_TIME,
                                    pnr3);

                            appDatabase.cartDao().addoffer(roomTripModel3_5);


                            RoomCartModel roomTripModel4_5 = new RoomCartModel(firstName4 + " / " + lastName4,
                                    FROM,
                                    TO,
                                    FLIGHT_NO,
                                    DATE,
                                    airlineCode,
                                    airlineCode,
                                    GROUND_TIME,
                                    pnr4);

                            appDatabase.cartDao().addoffer(roomTripModel4_5);
                            RoomCartModel roomTripModel5_5 = new RoomCartModel(firstName5 + " / " + lastName5
                                    , FROM
                                    , TO,
                                    FLIGHT_NO
                                    , DATE,
                                    airlineCode,
                                    airlineCode,
                                    GROUND_TIME,
                                    pnr5);

                            appDatabase.cartDao().addoffer(roomTripModel5_5);



                            sendDataToEMail(NAME_PASSENGER ,FROM,TO,FLIGHT_NO,DATE,TICKIT_NO, String.valueOf(price),email,data.getSegments().get(0).getAirlineName());
                            sendDataToEMail(firstName2 + " / " + lastName2 ,FROM,TO,FLIGHT_NO,DATE,pnr2, String.valueOf(price),email,data.getSegments().get(0).getAirlineName());
                            sendDataToEMail(firstName3 + " / " + lastName3 ,FROM,TO,FLIGHT_NO,DATE,pnr3, String.valueOf(price),email,data.getSegments().get(0).getAirlineName());
                            sendDataToEMail(firstName4 + " / " + lastName4 ,FROM,TO,FLIGHT_NO,DATE,pnr4, String.valueOf(price),email,data.getSegments().get(0).getAirlineName());
                            sendDataToEMail(firstName5 + " / " + lastName5 ,FROM,TO,FLIGHT_NO,DATE,pnr5, String.valueOf(price),email,data.getSegments().get(0).getAirlineName());

                        }



                            break;
                }




            }

            @Override
            public void onFailure(Call<GetBookingResponse> call, Throwable t) {

            }
        });

    }

    private void sendDataToEMailReturn(String name_passenger, String from, String to, String flight_no, String date, String tickit_no, String price, String email, String airlineName, String fromR, String toR, String flightNumberReturn, String dateReturn
    ,String airplanenameR
    ) {



        StringRequest request = new StringRequest(Request.Method.POST, LinksUrl.URL_SENT_TO_EMAIL_FLIGHT_RETURN, new com.android.volley.Response.Listener<String>() {

            @Override

            public void onResponse(String response) {

                startActivity(new Intent(FlightDetails.this,FlightDetailsActivity.class));


                try {
                    JSONObject jObj = new JSONObject(response);
                    int status = jObj.getInt("msg");
                    String msg = jObj.getString("success");

                    Toast.makeText(FlightDetails.this, ""+msg, Toast.LENGTH_SHORT).show();

                }catch (Exception  e){}



            }

        }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {


            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("name", name_passenger);
                parameters.put("from",from );
                parameters.put("to", to);
                parameters.put("flightnumber",flight_no );
                parameters.put("date", date);
                parameters.put("ticketnumber",tickit_no );
                parameters.put("price", price);
                parameters.put("mail_to",email );
                parameters.put("airportname",airlineName );

                parameters.put("fromR",fromR );
                parameters.put("toR",toR );
                parameters.put("flightnumberR",flightNumberReturn );
                parameters.put("dateR",dateReturn );
                parameters.put("ticketnumberR",tickit_no );
                parameters.put("priceR",price );
                parameters.put("airportnameR",airplanenameR );
                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);



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



  public void sendDataToEMail(String name ,String from , String to ,String flightno ,String date ,String ticketno ,String price, String mail_to , String AirlineNam){

        StringRequest request = new StringRequest(Request.Method.POST, LinksUrl.URL_SENT_TO_EMAIL_FLIGHT, new com.android.volley.Response.Listener<String>() {

            @Override

            public void onResponse(String response) {

startActivity(new Intent(FlightDetails.this,FlightDetailsActivity.class));


                try {
                    JSONObject jObj = new JSONObject(response);
                   int status = jObj.getInt("msg");
                    String msg = jObj.getString("success");

                    Toast.makeText(FlightDetails.this, ""+msg, Toast.LENGTH_SHORT).show();

                }catch (Exception  e){}



            }

        }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {


            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("name", name);
                parameters.put("from",from );
                parameters.put("to", to);
                parameters.put("flightno",flightno );
                parameters.put("date", date);
                parameters.put("ticketno",ticketno );
                parameters.put("price", price);
                parameters.put("mail_to",mail_to );
                parameters.put("airplanename",AirlineNam );
                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);



    }

}
