package net.middledleeast.tamm.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.RegisterationActivity;
import net.middledleeast.tamm.activities.FindHotels;
import net.middledleeast.tamm.activities.ReserveRoom;

import butterknife.BindView;

import static net.middledleeast.tamm.fragments.MemberShip.TERMS;

/**
 * A simple {@link Fragment} subclass.
 */
public class TermsFragment extends Fragment {


    TextView terms ;
    RelativeLayout toolbar_back1;

    public TermsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_terms, container, false);

        terms = view.findViewById(R.id.tv_term);
        toolbar_back1=view.findViewById(R.id.toolbar_back1);
        terms.setText(TERMS);

        toolbar_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), RegisterationActivity.class));

            }
        });
        return view;

    }

}
