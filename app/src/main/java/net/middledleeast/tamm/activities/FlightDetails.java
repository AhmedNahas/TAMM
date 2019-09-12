package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.middledleeast.tamm.R;

import java.util.concurrent.TimeUnit;

import FlightApi.FlightApiService;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlightDetails extends AppCompatActivity {

    @BindView(R.id.back_to_hotel)
    Button backToHotel;

    ImageView iv_booked_flight_details;
    public static final String BASE_URL = "https://xmloutapi.tboair.com/api/v1/";

    private static Retrofit retrofit = null;
    @BindView(R.id.get_code)
    Button getCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_details);
        ButterKnife.bind(this);


        Gson gson = new GsonBuilder()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).connectTimeout(0, TimeUnit.SECONDS)
                .readTimeout(0, TimeUnit.SECONDS).build();

        connectAndGetApiData(gson, client);
        FlightApiService flightApiService = retrofit.create(FlightApiService.class);


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



    @OnClick({R.id.iv_booked_flight_details, R.id.get_code, R.id.back_to_hotel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_booked_flight_details:

                break;
            case R.id.get_code:

                startActivity(new Intent(FlightDetails.this, FlightDetailsActivity.class));

                break;
            case R.id.back_to_hotel:

                startActivity(new Intent(FlightDetails.this, FindHotels .class));

                break;
        }
    }



}
