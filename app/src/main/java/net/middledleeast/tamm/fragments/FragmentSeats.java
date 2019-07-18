package net.middledleeast.tamm.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.PaymentFlights;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSeats extends Fragment {

Button proceedcheck_out_seat;
    public FragmentSeats() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_seats, container, false);
        proceedcheck_out_seat=view.findViewById(R.id.proceedcheck_out_seat);

        proceedcheck_out_seat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getContext(), PaymentFlights.class));
            }
        });

        return view;
    }

}
