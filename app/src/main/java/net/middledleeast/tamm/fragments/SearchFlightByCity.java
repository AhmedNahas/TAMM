package net.middledleeast.tamm.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import net.middledleeast.tamm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFlightByCity extends Fragment {

    TextView textView;


    public SearchFlightByCity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_flight_by_city, container, false);
        textView = view.findViewById(R.id.txtdubai);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(SearchFlightByCity.this).commit();
            }
        });
        return view;
    }

}
