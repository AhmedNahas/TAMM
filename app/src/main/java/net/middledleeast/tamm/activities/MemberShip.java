package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

public class MemberShip extends AppCompatActivity {
    Button accept;
    TextView textmemberaccount;
    private static final String urlmember ="http://egyptgoogle.com/backend/membership/membership.php" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_ship);
        accept = findViewById(R.id.btn_register_signup);
        textmemberaccount =findViewById(R.id.textView2);
        getmemberaccount();


        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MemberShip.this, MemberShipPlan.class);
                startActivity(intent);
            }
        });
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

                        Toast.makeText(getApplicationContext(), ""+array.length(), Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MemberShip.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(MemberShip.this);
        requestQueue.add(stringRequest);

    }
    }

