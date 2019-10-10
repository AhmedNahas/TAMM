package net.apptamm.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import net.apptamm.tamm.R;
import net.apptamm.tamm.model.Room.AppDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
