package net.middledleeast.tamm.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.RegisterationActivity;
import net.middledleeast.tamm.SignInFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuthenticationFragment extends Fragment {


    public AuthenticationFragment() {
        // Required empty public constructor
    }

    private Button btnSignin, btnRegister, btnGuet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_authentication, container, false);
        btnSignin = view.findViewById(R.id.btn_signin);
        btnRegister = view.findViewById(R.id.btn_signup);
        btnGuet = view.findViewById(R.id.btn_signin_as_aguest);

        btnSignin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    btnSignin.setBackgroundColor(Color.parseColor("#BE973B"));
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, new SignInFragment())
                            .commit();
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    btnSignin.setBackground(getActivity().getDrawable(R.drawable.border));
                }
                return false;
            }
        });

        btnRegister.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    btnRegister.setBackgroundColor(Color.parseColor("#BE973B"));
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, new PlansFragment())
                            .commit();
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    btnSignin.setBackground(getActivity().getDrawable(R.drawable.border));
                }
                return false;
            }
        });
        return view;
    }

}
