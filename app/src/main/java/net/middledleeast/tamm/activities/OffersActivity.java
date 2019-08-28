package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.OffersAdapter;
import net.middledleeast.tamm.model.Bestofferhotel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OffersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    OffersAdapter offersAdapter;
    ImageView iv_booked_offers;
    RelativeLayout toolbar_back1_offer;

    private String best_offer_hotels = "http://egyptgoogle.com/backend/hotels/bestdeals.php";

    List<String> listCountry = new ArrayList<>();
    List<String> listPicture = new ArrayList<>();
    List<String> listNameHotel = new ArrayList<>();
    List<String> listprice = new ArrayList<>();
    List<String> listcity =new ArrayList<>();

    private List<Bestofferhotel> bestofferhotels = new ArrayList<>();







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        iv_booked_offers =findViewById(R.id.iv_booked_offers);

        iv_booked_offers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(OffersActivity.this,MyBookActivity.class);
                startActivity(intent);
            }
        });

        toolbar_back1_offer=findViewById(R.id.toolbar_back1_offer);
        toolbar_back1_offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(OffersActivity.this,RenewAccount.class);
                startActivity(intent);

            }
        });

        recyclerView = findViewById(R.id.recycler_view_offer);




        getOffers();

    }

    private void getOffers() {


        StringRequest stringRequest = new StringRequest(Request.Method.GET, best_offer_hotels, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("bestofferhotels");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);

                        Bestofferhotel listData = new Bestofferhotel(ob.getString("id")
                                , ob.getString("picture"),ob.getString("name"),ob.getString("country"),ob.getString("city"),ob.getString("price"));
                        bestofferhotels.add(listData);

                        String name = bestofferhotels.get(i).getName();
                        String image = bestofferhotels.get(i).getPicture();
                        String country = bestofferhotels.get(i).getCountry();
                        String city = bestofferhotels.get(i).getCity();
                        String price = bestofferhotels.get(i).getPrice();

                        listNameHotel.add(name);
                        listPicture.add(image);
                        listCountry.add(country);
                        listcity.add(city);
                        listprice.add(price);


                    }
                    offersAdapter = new OffersAdapter(OffersActivity.this,1,listNameHotel,listPicture ,listCountry ,listprice,listcity);
                    recyclerView.setLayoutManager(new LinearLayoutManager(OffersActivity.this));
                    recyclerView.setAdapter(offersAdapter);
                    offersAdapter.notifyDataSetChanged();


                } catch (JSONException e) {
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(OffersActivity.this);
        requestQueue.add(stringRequest);
    }




    }



