package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.RegisterationActivity;

public  class FreeAccountPlan extends Fragment {
    private Button accept;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.free_account_plan, container, false);


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
                        .commit();

            }
        });
        return view;
    }
}
