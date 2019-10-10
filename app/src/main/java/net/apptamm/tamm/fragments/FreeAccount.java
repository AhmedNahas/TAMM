package net.apptamm.tamm.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import net.apptamm.tamm.R;

import static net.apptamm.tamm.fragments.MemberShip.TERMS;

public class FreeAccount extends Fragment {
    Button accept;
    TextView textfreeaccount;
    Toolbar toolbar;
    LinearLayout imageView;

    TextView termes ;


//    private static final String url ="http://egyptgoogle.com/backend/freeaccount/freeaccount.php" ;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freeaccount, container, false);

        termes =view.findViewById(R.id.termes_tv);
        toolbar = view.findViewById(R.id.welcome_toolbar);
        imageView = view.findViewById(R.id.back_pressed);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.welcome_container, new PlansFragment())
                        .addToBackStack("freeAcount").commit();
            }
        });


        termes.setText(TERMS);

        accept = view.findViewById(R.id.btn_register_signup);
            textfreeaccount=view.findViewById(R.id.textView2);

//            getfreeaccount();

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.welcome_container, new FreeAccountPlan())
                        .addToBackStack("freeAcount").commit();

            }
        });
        return view;
    }

//    private void getfreeaccount() {
//
//
//
//        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonObject=new JSONObject(response);
//                    JSONArray array=jsonObject.getJSONArray("freeaccount");
//                    for (int i=0; i<array.length(); i++ ){
//                        JSONObject ob=array.getJSONObject(i);
//                        final String msgbody = ob.getString("freebody");
//
//                        textfreeaccount.setText(msgbody);
//
//
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
//        requestQueue.ic_add(stringRequest);
//
//      }
  }

