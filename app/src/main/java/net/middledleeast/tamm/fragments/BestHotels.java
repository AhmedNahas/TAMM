package net.middledleeast.tamm.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.BestHotelAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class BestHotels extends Fragment {
    RecyclerView recyclerView;
    BestHotelAdapter bestHotelAdapter;

    public BestHotels() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.best_hotels, container, false);
        recyclerView=view.findViewById(R.id.recycler_view_hotels);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        bestHotelAdapter = new BestHotelAdapter();
        recyclerView.setAdapter(bestHotelAdapter);



        return view;


    }

}
