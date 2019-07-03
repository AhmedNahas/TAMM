package net.middledleeast.tamm.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.middledleeast.tamm.R;

import FlightApi.FlightApiService;
import FlightApi.FlightAuthentication;
import FlightApi.FlightConstants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlightSearch extends AppCompatActivity {


    public static final String BASE_URL = "https://xmloutapi.tboair.com/api/v1/";
    private static final String TAG = MainActivity.class.getSimpleName();
    private static Retrofit retrofit = null;
    String password;
    private RecyclerView recyclerView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_search);
        password = "App02072019";

        Gson gson = new GsonBuilder()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).build();

        connectAndGetApiData(gson, client);
        FlightApiService flightApiService = retrofit.create(FlightApiService.class);

        FlightAuthentication flightAuthentication = new FlightAuthentication();
        flightAuthentication.setUserName(FlightConstants.API_USER_NAME);
        flightAuthentication.setPassword(password);
        flightAuthentication.setBookingMode("API");
        flightAuthentication.setIPAddress("192.169.10.22");

        Call<FlightAuthentication> call = flightApiService.getAuthentication("application/json", flightAuthentication);

        call.enqueue(new Callback<FlightAuthentication>() {
            @Override
            public void onResponse(Call<FlightAuthentication> call, Response<FlightAuthentication> response) {
                FlightAuthentication flightAuthentication = response.body();


                System.out.println("Helper: " + flightAuthentication.getTokenId());
            }

            @Override
            public void onFailure(Call<FlightAuthentication> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
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