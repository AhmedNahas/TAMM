package net.middledleeast.tamm.fragments;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.model.Freeuser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class TammFamilyFragment extends Fragment {

    private TextView textfamily;
    private Button btnContinue;

    private static final String url ="http://egyptgoogle.com/backend/terms/tammfamily.php" ;

    public TammFamilyFragment() {
        // Required empty public constructor
    }


    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tamm_family, container, false);
        btnContinue = view.findViewById(R.id.btn_continue_to_authentication);
        textfamily=view.findViewById(R.id.family_message);



        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_back_arrow);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setShowHideAnimationEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(upArrow);

        btnContinue.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    btnContinue.setBackgroundColor(Color.parseColor("#BE973B"));
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, new AuthenticationFragment())
                            .commit();
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    btnContinue.setBackground(getActivity().getDrawable(R.drawable.border));
                }
                return false;
            }
        });

        gettextfamily();

        return view;
    }





    private void gettextfamily() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("freeusers");
                    for (int i=0; i<array.length(); i++ ){
                        JSONObject ob=array.getJSONObject(i);
                        final String msgbody = ob.getString("Msgbody");

                        textfamily.setText(msgbody);

//                        Toast.makeText(getContext(), ""+array.length(), Toast.LENGTH_SHORT).show();

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
