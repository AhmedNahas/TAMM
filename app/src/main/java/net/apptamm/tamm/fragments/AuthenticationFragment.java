package net.apptamm.tamm.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import net.apptamm.tamm.R;
import net.apptamm.tamm.SignInFragment;
import net.apptamm.tamm.activities.RenewAccount;
import net.apptamm.tamm.helper.SharedPreferencesManger;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuthenticationFragment extends Fragment {


    private Integer accountPlan = 0;

    public AuthenticationFragment() {
        // Required empty public constructor
    }

    private Button btnSignin, btnRegister, btnGuet;
    Toolbar toolbar;
    LinearLayout imageView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_authentication, container, false);
        btnSignin = view.findViewById(R.id.btn_signin);
        btnRegister = view.findViewById(R.id.btn_signup);
        btnGuet = view.findViewById(R.id.btn_signin_as_aguest);
        toolbar = view.findViewById(R.id.welcome_toolbar);
        imageView = view.findViewById(R.id.back_pressed);

        accountPlan = SharedPreferencesManger.LoadIntegerData(getActivity(), "accountPlan");


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.welcome_container, new TammFamilyFragment())
                        .commit();
            }
        });



        btnGuet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                accountPlan = 2;
                Intent intent = new Intent(getContext(), RenewAccount.class);
                intent.putExtra("renew",12);

                SharedPreferencesManger.SaveData(getContext(),"accountPlan",accountPlan);

                SharedPreferencesManger.SaveData(getContext(),"guestMode","guestMode");

                startActivity(intent);






            }
        });

        btnSignin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btnSignin.setBackgroundColor(Color.parseColor("#BE973B"));
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, new SignInFragment())
                            .addToBackStack(" Authentication").commit();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    btnSignin.setBackground(getActivity().getDrawable(R.drawable.border));
                }
                return false;
            }
        });

        btnRegister.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btnRegister.setBackgroundColor(Color.parseColor("#BE973B"));
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, new PlansFragment())
                            .addToBackStack(" Authentication").commit();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    btnSignin.setBackground(getActivity().getDrawable(R.drawable.border));
                }
                return false;
            }
        });
        return view;
    }



}