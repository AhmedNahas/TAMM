package net.middledleeast.tamm.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.RegisterationActivity;

public class MemberShipPlan extends Fragment {

    private Button accept;

    Toolbar toolbar;
    LinearLayout imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.member_ship_plan, container, false);


        toolbar = view.findViewById(R.id.welcome_toolbar);
        imageView = view.findViewById(R.id.back_pressed);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.welcome_container, new MemberShip())
                        .addToBackStack( "MemberShipPlan" ).commit();
            }
        });



        accept =view.findViewById(R.id.btn_register_signup);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RegisterationActivity registerationActivity = new RegisterationActivity();
                Bundle bundle = new Bundle();
                bundle.putInt("member",1);
                registerationActivity.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.welcome_container,registerationActivity)
                        .addToBackStack( "MemberShipPlan" ) .commit();
            }
        });
        return view;
    }
}
