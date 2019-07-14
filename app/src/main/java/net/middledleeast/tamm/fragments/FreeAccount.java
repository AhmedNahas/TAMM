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

public class FreeAccount extends Fragment {
    Button accept;
    TextView textfreeaccount;
    private static final String url ="http://egyptgoogle.com/backend/freeaccount/freeaccount.php" ;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freeaccount, container, false);

        accept = view.findViewById(R.id.btn_register_signup);
            textfreeaccount=view.findViewById(R.id.textView2);

            getfreeaccount();

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.welcome_container, new FreeAccountPlan())
                        .commit();

            }
        });
        return view;
    }

    private void getfreeaccount() {



        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("freeaccount");
                    for (int i=0; i<array.length(); i++ ){
                        JSONObject ob=array.getJSONObject(i);
                        final String msgbody = ob.getString("freebody");

                        textfreeaccount.setText(msgbody);

                        Toast.makeText(getContext(), ""+array.length(), Toast.LENGTH_SHORT).show();

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
