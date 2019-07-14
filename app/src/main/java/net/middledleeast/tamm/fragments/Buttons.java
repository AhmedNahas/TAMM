package net.middledleeast.tamm.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.middledleeast.tamm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Buttons extends Fragment {

    private Button listofuser;


    public Buttons() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_buttons, container, false);

        listofuser=view.findViewById(R.id.btn_list_of_user);
        listofuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.welcome_container,new UsersFreeFragment()).commit();
            }
        });

        // Inflate the layout for this fragment
        return view;


    }

}
