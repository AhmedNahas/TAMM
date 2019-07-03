package net.middledleeast.tamm.activities;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;

import java.nio.charset.StandardCharsets;

import FlightApi.FlightApiService;
import FlightApi.FlightAuthentication;
import FlightApi.FlightConstants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlightSearch extends AppCompatActivity {


    public static final String BASE_URL = "http://xmloutapi.tboair.com";
    private static final String TAG = MainActivity.class.getSimpleName();
    private static Retrofit retrofit = null;
    String password;
    private RecyclerView recyclerView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_search);
        password = "App" + getString(R.string.at) + "02072019";
        connectAndGetApiData();
        FlightApiService flightApiService = retrofit.create(FlightApiService.class);
//
//
        Call<FlightAuthentication> call = flightApiService.getAuthentication(FlightConstants.API_USER_NAME, password, "API", "192.169.10.22");
//
        call.enqueue(new Callback<FlightAuthentication>() {
            @Override
            public void onResponse(Call<FlightAuthentication> call, Response<FlightAuthentication> response) {
//

                System.out.println("Helper: " + response.raw());

            }

            @Override
            public void onFailure(Call<FlightAuthentication> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });
    }

    public Retrofit connectAndGetApiData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public String getAuthToken() {
        byte[] data = new byte[0];
        data = (FlightConstants.API_USER_NAME + ":" + password).getBytes(StandardCharsets.UTF_8);
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }

//    public static void getHomePage(Context mContext, Callback<> callback) {
//        Call<HomepageData> call = retrofit.create(FlightApiService.class).getHomePageData(
//                getAuthToken()
//                , AppSharedPref.getCustomerId(mContext)
//        );
//        call.enqueue(callback);
//    }

}