package net.apptamm.tamm.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import net.apptamm.tamm.R;
import net.apptamm.tamm.RegisterationActivity;

public  class FreeAccountPlan extends Fragment {
    private Button accept;
    Toolbar toolbar;
    LinearLayout imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.free_account_plan, container, false);


        toolbar = view.findViewById(R.id.welcome_toolbar);
        imageView = view.findViewById(R.id.back_pressed);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.welcome_container, new FreeAccount())
                        .addToBackStack( "FreeAccountPlan" ).commit();
            }
        });

        accept = view.findViewById(R.id.btn_register_signup);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                RegisterationActivity registerationFragment = new RegisterationActivity();
                Bundle bundle = new Bundle();
                bundle.putInt("free",2);
                registerationFragment.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.welcome_container, registerationFragment)
                        .addToBackStack( "FreeAccountPlan" ).commit();

            }
        });
        return view;
    }
}
