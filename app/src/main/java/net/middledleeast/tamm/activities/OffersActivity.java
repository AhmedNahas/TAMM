package net.middledleeast.tamm.activities;

import android.os.Bundle;
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
import net.middledleeast.tamm.model.Best.BestHotel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OffersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    OffersAdapter offersAdapter;
    private String best_hotels = "http://egyptgoogle.com/backend/hotels/bestdeals.php";

    List<String> listName = new ArrayList<>();
    List<String> listImage = new ArrayList<>();
    List<String> listNameHotel = new ArrayList<>();
    private List<BestHotel> theBest = new ArrayList<>();

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        recyclerView = findViewById(R.id.recycler_view_offer);


        offersAdapter = new OffersAdapter(this,OffersActivity.this,listName,listImage ,listNameHotel ,1);

        recyclerView.setLayoutManager(new LinearLayoutManager(OffersActivity.this));
        recyclerView.setAdapter(offersAdapter);

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



                        BestHotel listData = new BestHotel(ob.getString("offername"),ob.getString("country"),ob.getString("hotelname"),ob.getString("image"));


                        theBest.add(listData);

                        String offerName_ = theBest.get(i).getOffername();

                        String country_ = theBest.get(i).getCountry();
                        String hotelName_ = theBest.get(i).getHotelname();
                        String image = theBest.get(i).getImage();

                        listNameHotel.add(hotelName_);
                        listName.add(country_);
                        listImage.add(image);


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

