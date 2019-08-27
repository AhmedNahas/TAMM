package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

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




Bestofferhotel listData=new Bestofferhotel(ob.getString("id"),ob.getString("picture"),ob.getString("name"),ob.getString("country"),ob.getString("city"),ob.getString("price"));
//


//                        final String id = (String) ob.get("id");
//                        final String picture1 =(String) ob.get("picture");
//                        final String name = (String) ob.get("name");
//                        final String country = (String) ob.get("country");
//                        final String city1 = (String) ob.get("city");
//                        final String price1 = (String) ob.get("price");
//
//                        Bestofferhotel listData = new Bestofferhotel(id,picture1,name,country,city1,price1);




                        Toast.makeText(OffersActivity.this, ""+listData.getCity(), Toast.LENGTH_LONG).show();

                        bestofferhotels.add(listData);


                        String country_ = bestofferhotels.get(i).getCountry();

                        String hotelName_ = bestofferhotels.get(i).getName();
                        String picture = bestofferhotels.get(i).getPicture();
                        String city = bestofferhotels.get(i).getCity();
                        String price = bestofferhotels.get(i).getPrice();


                        listNameHotel.add(hotelName_);
                        listCountry.add(country_);
                        listPicture.add(picture);
                        listcity.add(city);
                        listprice.add(price);




                        offersAdapter = new OffersAdapter(OffersActivity.this,1,listCountry,listPicture ,listNameHotel ,listprice,listcity);

                        recyclerView.setLayoutManager(new LinearLayoutManager(OffersActivity.this));
                        recyclerView.setAdapter(offersAdapter);

                    }




                } catch (JSONException e) {
                    e.printStackTrace();


                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //dialog.cancel();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(OffersActivity.this);
        requestQueue.add(stringRequest);



    }

}

