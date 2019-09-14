package net.middledleeast.tamm.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.concurrent.TimeUnit;

import FlightApi.FlightApiService;
import FlightApi.FlightGetBooking;
import FlightApi.GetBookingResponse;
import FlightApi.Itinerary;
import FlightApi.Passenger;
import FlightApi.Segment;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static net.middledleeast.tamm.helper.helperMethod.getLocalIpAddress;

public class FlightDetailsActivity extends AppCompatActivity {
    @BindView(R.id.NamePassenger)
    TextView NamePassenger;
    @BindView(R.id.From)
    TextView From;
    @BindView(R.id.To)
    TextView To;
    @BindView(R.id.FlightNo)
    TextView FlightNo;
    @BindView(R.id.Date)
    TextView Date;
    @BindView(R.id.Gate)
    TextView Gate;
    @BindView(R.id.Hours)
    TextView Hours;
    @BindView(R.id.SEAT)
    TextView SEAT;
    @BindView(R.id.TicketNo)
    TextView TicketNo;
    @BindView(R.id.name_passenger)
    TextView namePassenger;
    private Retrofit retrofit;

    public static final String BASE_URL = "https://xmloutapi.tboair.com/api/v1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);
        ButterKnife.bind(this);


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

                String pnr1 = response.body().getItinerary().getPNR();

                Itinerary data = response.body().getItinerary();
                Segment segment = data.getSegments().get(0);
                String flightNumber = segment.getFlightNumber();

                FlightNo.setText("FLIGHT   " + flightNumber);
                String countryCode = segment.getOrigin().getCityCode();
                String countryName = segment.getOrigin().getCityName();
                String countryCode1 = segment.getDestination().getCityCode();
                String countryName1 = segment.getDestination().getCityName();



                String  to =  SharedPreferencesManger.LoadStringData(FlightDetailsActivity.this, "to");
                String  from=     SharedPreferencesManger.LoadStringData(FlightDetailsActivity.this, "from");


                for (int i = 0; i < data.getSegments().size(); i++) {


                    From.setText(countryName + "  /  " + from);

                    To.setText( data.getSegments().get(i).getDestination().getCityName() + "  /  " + to);

                }


//
//                To.setText(countryName + "  /  " + to);
//                From.setText(countryName1 + "  /  " + from);


                String groundTime = segment.getAccumulatedDuration();

                Hours.setText(groundTime);
                Passenger passenger = data.getPassenger().get(0);

                String firstName = passenger.getFirstName();
                String lastName = passenger.getLastName();
                NamePassenger.setText(firstName+" / "+lastName);

                String departureTime = segment.getDepartureTime();


                String[] ts = departureTime.split("T");
                String t = ts[0];
                Date.setText("DATE   "+t);

                TicketNo.setText("TicketNo  : "+pnr1);

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
