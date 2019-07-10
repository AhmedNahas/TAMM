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

public class MemberShip extends Fragment {
    Button accept;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.member_ship, container, false);

        accept = view.findViewById(R.id.btn_register_signup);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.welcome_container, new MemberShipPlan())
                        .commit();
            }

        });
        return view;
    }
}
