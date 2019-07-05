package net.middledleeast.tamm.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.FreeAdapter;
import net.middledleeast.tamm.model.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFreeFragment extends Fragment {


    public UsersFreeFragment() {
        // Required empty public constructor
    }
    ImageView imgView;
    RecyclerView recyclerView;
    FreeAdapter freeAdapter;
    List<Users> users=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_users_free, container, false);

        imgView=view.findViewById(R.id.img_tamm);
        recyclerView=view.findViewById(R.id.recycler_view);

        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        users.add(new Users("Mohamed","01062594878",""));
        freeAdapter=new FreeAdapter(getContext(),users);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(freeAdapter);
        freeAdapter.notifyDataSetChanged();
        // Inflate the layout for this fragment
        return view;
    }

}
