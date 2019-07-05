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

/**
 * A simple {@link Fragment} subclass.
 */
public class LanguangeFragment extends Fragment {

    private Button btnEnglish, btnArabic;

    public LanguangeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_languange, container, false);
        btnEnglish = view.findViewById(R.id.btn_choose_english);
        btnArabic = view.findViewById(R.id.btn_choose_arabic);

        btnEnglish.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    btnEnglish.setBackgroundColor(Color.parseColor("#BE973B"));
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, new TammFamilyFragment())
                            .commit();
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    btnEnglish.setBackground(getActivity().getDrawable(R.drawable.border));
                }
                return false;
            }
        });

        btnArabic.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    btnEnglish.setBackgroundColor(Color.parseColor("#BE973B"));
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    btnEnglish.setBackground(getActivity().getDrawable(R.drawable.border));
                }
                return false;
            }
        });

        return view;
    }


}
