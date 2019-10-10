package net.apptamm.tamm.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.apptamm.tamm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MultiCities4 extends Fragment {
    Button next ;

    public MultiCities4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_multi_cities4, container, false);

        next = view.findViewById(R.id.next_btn_multi1);



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
                        .addToBackStack("MultiCities3").commit();

            }
        });
        return  view ;
    }

}
