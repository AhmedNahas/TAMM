package net.middledleeast.tamm.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.RecommendedTwoWay;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReturnWayFlights extends Fragment {
    private CheckedTextView royalClass, firstClass, businessClass, economyClass;
    private TextView fromTextView, toTextView;
    private RecyclerView fromToRecycler;
    private Button proccedBtn;
    private Spinner departure, returnFrom, passengerAdult, passengerChild, passengerInfant;


    public ReturnWayFlights() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_return_way_flights, container, false);

        royalClass = view.findViewById(R.id.royal_class);
        firstClass = view.findViewById(R.id.first_class);
        businessClass = view.findViewById(R.id.business_class);
        economyClass = view.findViewById(R.id.economy_class);
        fromTextView = view.findViewById(R.id.country_from_textview);
        toTextView = view.findViewById(R.id.country_to_textview);
        fromToRecycler = view.findViewById(R.id.from_to_rV);
        proccedBtn = view.findViewById(R.id.procced_btn);
        departure = view.findViewById(R.id.departure_spinner);
        returnFrom = view.findViewById(R.id.return_spinner);
        passengerAdult = view.findViewById(R.id.adult_spinner);
        passengerChild = view.findViewById(R.id.child_spinner);
        passengerInfant = view.findViewById(R.id.infant_spinner);


        proccedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getContext().startActivity(new Intent(getContext(), RecommendedTwoWay.class));

            }
        });


        fromTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchFlightByCity searchFlightByCity = new SearchFlightByCity();

                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.flights_container, searchFlightByCity)
                        .commit();


            }
        });

        toTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchFlightByCity searchFlightByCity = new SearchFlightByCity();
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.flights_container, searchFlightByCity)
                        .commit();

            }
        });


        royalClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    royalClass.setTextColor(0xFFFFFFFF);
                    businessClass.setTextColor(0xFFBE973B);
                    economyClass.setTextColor(0xFFBE973B);
                    firstClass.setTextColor(0xFFBE973B);

                }
                return false;
            }
        });
        firstClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    firstClass.setTextColor(0xFFFFFFFF);
                    royalClass.setTextColor(0xFFBE973B);
                    businessClass.setTextColor(0xFFBE973B);
                    economyClass.setTextColor(0xFFBE973B);

                }
                return false;
            }
        });
        businessClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    businessClass.setTextColor(0xFFFFFFFF);
                    royalClass.setTextColor(0xFFBE973B);
                    firstClass.setTextColor(0xFFBE973B);
                    economyClass.setTextColor(0xFFBE973B);

                }
                return false;
            }
        });
        economyClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    economyClass.setTextColor(0xFFFFFFFF);
                    royalClass.setTextColor(0xFFBE973B);
                    firstClass.setTextColor(0xFFBE973B);
                    businessClass.setTextColor(0xFFBE973B);

                }
                return false;
            }
        });


        return view;
    }

}
