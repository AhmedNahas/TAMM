package net.middledleeast.tamm.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import net.middledleeast.tamm.R;

import butterknife.BindView;

import static net.middledleeast.tamm.fragments.MemberShip.TERMS;

/**
 * A simple {@link Fragment} subclass.
 */
public class TermsFragment extends Fragment {


    TextView terms ;

    public TermsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_terms, container, false);

        terms = view.findViewById(R.id.tv_term);
        terms.setText(TERMS);


        return view;

    }

}
