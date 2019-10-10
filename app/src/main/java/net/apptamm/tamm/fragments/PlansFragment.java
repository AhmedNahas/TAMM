package net.apptamm.tamm.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.apptamm.tamm.R;
import net.apptamm.tamm.activities.RenewAccount;
import net.apptamm.tamm.adapters.PlansAdapter;
import net.apptamm.tamm.helper.SharedPreferencesManger;
import net.apptamm.tamm.model.PlanModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlansFragment extends Fragment {

    private RecyclerView recyclerView;
    private PlansAdapter plansAdapter;
    private List<PlanModel> planModelList = new ArrayList<>();
    private TextView member;
    Toolbar toolbar;
    LinearLayout imageView;

    public PlansFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_plans, container, false);


        recyclerView = view.findViewById(R.id.plans_recyclerview);
        member=view.findViewById(R.id.plan_title);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        init();
        plansAdapter = new PlansAdapter(getContext(), planModelList );
        recyclerView.setAdapter(plansAdapter);

        toolbar = view.findViewById(R.id.welcome_toolbar);
        imageView = view.findViewById(R.id.back_pressed);



        final String guestMode = SharedPreferencesManger.LoadStringData(getContext(), "guestMode");
        if(guestMode==guestMode){
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(getContext(), RenewAccount.class);
                    startActivity(intent);
                }
            });


        }else{

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, new AuthenticationFragment())
                            .addToBackStack( "PlansFragment" ) .commit();
                }
            });

        }




        return view;
    }

    private void init() {
        planModelList.add(new PlanModel(getString(R.string.membership), ""));
        planModelList.add(new PlanModel(getString(R.string.free_account_plan), ""));
    }


}
