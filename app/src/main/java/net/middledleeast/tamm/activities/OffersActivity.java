package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
import net.middledleeast.tamm.model.Best.BestHotel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OffersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    OffersAdapter offersAdapter;
    ImageView iv_booked_offers;


    private String best_hotels = "http://egyptgoogle.com/backend/hotels/bestdeals.php";

    List<String> listName = new ArrayList<>();
    List<String> listImage = new ArrayList<>();
    List<String> listNameHotel = new ArrayList<>();
    private List<BestHotel> theBest = new ArrayList<>();







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

        recyclerView = findViewById(R.id.recycler_view_offer);

        getOffers();

    }

    private void getOffers() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, best_hotels, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("best hotels");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);



                        BestHotel listData = new BestHotel(ob.getString("id"),ob.getString("offername"),ob.getString("country"),ob.getString("hotelname"),ob.getString("breakfast"),ob.getString("dinner"),ob.getString("lunch"),ob.getString("fromairport"),ob.getString("fromhotel"),ob.getString("day"),ob.getString("month"),ob.getString("year"),ob.getString("dd"),ob.getString("mm"),ob.getString("yy"),ob.getString("offerdesc"),ob.getString("image"),ob.getString("price"));


                        theBest.add(listData);

                        String offerName_ = theBest.get(i).getOffername();

                        String country_ = theBest.get(i).getCountry();
                        String hotelName_ = theBest.get(i).getHotelname();
                        String image = theBest.get(i).getImage();

                        listNameHotel.add(hotelName_);
                        listName.add(country_);
                        listImage.add(image);
                        offersAdapter = new OffersAdapter(OffersActivity.this,listName,listImage ,listNameHotel ,1);

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

