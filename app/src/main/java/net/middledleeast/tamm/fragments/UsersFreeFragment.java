package net.middledleeast.tamm.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.FreeAdapter;
import net.middledleeast.tamm.model.UserList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    private static final String url_user_phone ="http://egyptgoogle.com/freeusers/listusers.php" ;
    List<UserList> users=new ArrayList<>();
    private List<String> listUserName = new ArrayList<>();
    private List<String> listUserPhone = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_users_free, container, false);


        recyclerView=view.findViewById(R.id.recycler_view);

        getUserData();

//        users.ic_add(new Users("Mohamed","01062594878",""));
//        users.ic_add(new Users("Mohamed","01062594878",""));
//        users.ic_add(new Users("Mohamed","01062594878",""));
//        users.ic_add(new Users("Mohamed","01062594878",""));
//        users.ic_add(new Users("Mohamed","01062594878",""));
//        users.ic_add(new Users("Mohamed","01062594878",""));
//
//
//
//        freeAdapter=new FreeAdapter(getContext(),users);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(freeAdapter);
//        freeAdapter.notifyDataSetChanged();
        // Inflate the layout for this fragment



        return view;
    }

    private void getUserData() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url_user_phone, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("freeusers");
                    for (int i=0; i<array.length(); i++ ){
                        JSONObject ob=array.getJSONObject(i);
                        UserList listData=new UserList(ob.getString("username")
                                ,ob.getString("phone"));
                        users.add(listData);

                     freeAdapter = new FreeAdapter(getContext(),users);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(freeAdapter);
                        freeAdapter.notifyDataSetChanged();


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }

}
