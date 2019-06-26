package net.middledleeast.tamm.fragments;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.middledleeast.tamm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TammFamilyFragment extends Fragment {


    public TammFamilyFragment() {
        // Required empty public constructor
    }

    private Button btnContinue;

    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tamm_family, container, false);
        btnContinue = view.findViewById(R.id.btn_continue_to_authentication);

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_back_arrow);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setShowHideAnimationEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(upArrow);

        btnContinue.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    btnContinue.setBackgroundColor(Color.parseColor("#BE973B"));
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, new AuthenticationFragment())
                            .commit();
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    btnContinue.setBackground(getActivity().getDrawable(R.drawable.border));
                }
                return false;
            }
        });

        return view;
    }

}
