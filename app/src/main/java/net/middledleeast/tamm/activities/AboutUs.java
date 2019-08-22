package net.middledleeast.tamm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

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

public class AboutUs extends AppCompatActivity {

    private TextView textfamilyabout;
    private static final String url ="http://egyptgoogle.com/backend/about/aboutjson.php/" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        textfamilyabout=findViewById(R.id.family_message_about);


        gettextfamilyabout();

    }

    private void gettextfamilyabout() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("freeusers");
                    for (int i=0; i<array.length(); i++ ){
                        JSONObject ob=array.getJSONObject(i);
                        final String msgbody = ob.getString("Text");

                        textfamilyabout.setText(msgbody);

//                        Toast.makeText(getContext(), ""+array.length(), Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(AboutUs.this);
        requestQueue.add(stringRequest);
    }
    }

