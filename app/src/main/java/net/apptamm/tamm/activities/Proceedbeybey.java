package net.apptamm.tamm.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import net.apptamm.tamm.R;
import net.apptamm.tamm.fragments.ProceedBeyBeyOriginal;
import net.apptamm.tamm.helper.SharedPreferencesManger;

import FlightApi.FlightAuthentication;
import retrofit2.Retrofit;

public class Proceedbeybey extends AppCompatActivity {



    public static final String BASE_URL = "https://xmloutapi.tboair.com/api/v1/";
    private static final String TAG = MainActivity.class.getSimpleName();
    private static Retrofit retrofit = null;
    public FlightAuthentication flightAuthentication;
    String password;
    private RecyclerView recyclerView = null;
    private boolean ClickRenewHotel = false;

    RelativeLayout toolbar_back1;
    ImageView iv_booked_proceed;
    private Integer accountPlan;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proceedbey_bey);

        iv_booked_proceed=findViewById(R.id.iv_booked_proceed);
        iv_booked_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Proceedbeybey.this,MyTripsActivity.class));
            }
        });


        try {
            accountPlan = SharedPreferencesManger.LoadIntegerData(this, "accountPlan");

            if (accountPlan == 1) {

                iv_booked_proceed.setVisibility(View.VISIBLE);

            } else if (accountPlan == 0) {

                iv_booked_proceed.setVisibility(View.VISIBLE);

            } else if (accountPlan == 2) {
                iv_booked_proceed.setVisibility(View.GONE);

            }
        }catch (Exception e){}

        toolbar_back1=findViewById(R.id.toolbar_back1);
        toolbar_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Proceedbeybey.this, FlightTamm.class));
            }
        });
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);

        fragmentTransaction.replace(R.id.flights_container, new ProceedBeyBeyOriginal())
               .commit();
    }


}

