package net.middledleeast.tamm.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.middledleeast.tamm.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




public class MemberShip extends Fragment {
    Button accept;
    TextView textmemberaccount ;

    private static final String urlmember ="http://egyptgoogle.com/backend/membership/membership.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.member_ship, container, false);


        getmemberaccount();

        accept = view.findViewById(R.id.btn_register_signup);
        textmemberaccount = view.findViewById(R.id.textView2);

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





    private void getmemberaccount() {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, urlmember, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("memberbody");
                    for (int i=0; i<array.length(); i++ ){
                        JSONObject ob=array.getJSONObject(i);
                        final String member = ob.getString("memberbody");

                        textmemberaccount.setText(member);


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

