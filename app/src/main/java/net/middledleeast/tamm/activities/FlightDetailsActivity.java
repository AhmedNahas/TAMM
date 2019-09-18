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
