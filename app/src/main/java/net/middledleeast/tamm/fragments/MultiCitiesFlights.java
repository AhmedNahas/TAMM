package net.middledleeast.tamm.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.RecommendedOneWay;
import net.middledleeast.tamm.adapters.AdapterChildCount;
import net.middledleeast.tamm.adapters.FlightAddingAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MultiCitiesFlights extends Fragment {


    private RecyclerView fromToRecycler ;
    private CheckedTextView royalClass , firstClass , businessClass , economyClass;

    private Button proccedBtn;
    private Spinner departure , returnFrom , passengerAdult , passengerChild , passengerInfant;
    RelativeLayout addNewTrip;
    RecyclerView addNewTripRv;
    List<Integer> integers = new ArrayList<>();
    FlightAddingAdapter adapter ;
    int count = 0;
    public MultiCitiesFlights() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_multi_cities_flights, container, false);
        addNewTrip=view.findViewById(R.id.rv_add);

            addNewTripRv=view.findViewById(R.id.multicity_rV);
            integers.add(count);
        addNewTripRv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new FlightAddingAdapter(integers);
        addNewTripRv.setAdapter(adapter);

        fromToRecycler=view.findViewById(R.id.from_to_rV);
        proccedBtn=view.findViewById(R.id.procced_btn);
        departure=view.findViewById(R.id.departure_spinner);
        returnFrom=view.findViewById(R.id.return_spinner);
        passengerAdult=view.findViewById(R.id.adult_spinner);
        passengerChild=view.findViewById(R.id.child_spinner);
        passengerInfant=view.findViewById(R.id.infant_spinner);
        royalClass=view.findViewById(R.id.royal_class);
        firstClass=view.findViewById(R.id.first_class);
        businessClass=view.findViewById(R.id.business_class);
        economyClass=view.findViewById(R.id.economy_class);

        addNewTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                integers.add(count);
                adapter.notifyDataSetChanged();
            }
        });

        proccedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getContext().startActivity(new Intent(getContext(), RecommendedOneWay.class));

            }
        });
        royalClass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
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
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
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
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
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
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
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
