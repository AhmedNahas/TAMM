package net.middledleeast.tamm.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.OffersAdapter;

public class OffersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    OffersAdapter offersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        recyclerView = findViewById(R.id.recycler_view_offer);


        offersAdapter = new OffersAdapter(this,1);
        recyclerView.setLayoutManager(new LinearLayoutManager(OffersActivity.this));
        recyclerView.setAdapter(offersAdapter);

        getOffers();


    }

    private void getOffers() {
//                StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
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
//        requestQueue.add(stringRequest);
//
//      }
//
//    }


    }
}
