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
import net.middledleeast.tamm.model.Freeaccount;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FreeAccount extends AppCompatActivity {
    Button accept;
    TextView textfreeaccount;
    private static final String url ="http://egyptgoogle.com/backend/freeaccount/freeaccount.php" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freeaccount);
        accept = findViewById(R.id.btn_register_signup);

        textfreeaccount=findViewById(R.id.textView2);

        getfreeaccount();
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FreeAccount.this, FreeAccountPlan.class);
                startActivity(intent);

            }
        });
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

                        Toast.makeText(getApplicationContext(), ""+array.length(), Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(FreeAccount.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(FreeAccount.this);
        requestQueue.add(stringRequest);

      }
    }

