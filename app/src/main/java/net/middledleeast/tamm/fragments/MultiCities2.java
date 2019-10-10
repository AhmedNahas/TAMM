package net.middledleeast.tamm.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import net.middledleeast.tamm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MultiCities2 extends Fragment {


    Button next ;
    RelativeLayout  addNewTrip;
    public MultiCities2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_multi_cities2, container, false);

        next = view.findViewById(R.id.next_btn_multi1);
        addNewTrip = view.findViewById(R.id.rv_add);

        addNewTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.flights_container, new MultiCities3())
                        .addToBackStack("MultiCities2").commit();


            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);

                ProceedBeyBeyOriginal proceedBeyBeyOriginal = new ProceedBeyBeyOriginal();

                Bundle bundle = new Bundle();
                bundle.putInt("multi",1);
                proceedBeyBeyOriginal.setArguments(bundle);

                fragmentTransaction.replace(R.id.flights_container, proceedBeyBeyOriginal)
                        .addToBackStack("MultiCities2").commit();


            }
        });
        return view ;
    }

}
