package net.apptamm.tamm.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.apptamm.tamm.R;
import net.apptamm.tamm.activities.OffersFlightsDetailsActivity;
import net.apptamm.tamm.adapters.FlightAdapter;
import net.apptamm.tamm.helper.SharedPreferencesManger;
import net.apptamm.tamm.model.AllLinks.LinksUrl;
import net.apptamm.tamm.model.Bestflight;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BestFlights extends Fragment {

    RecyclerView recyclerView;
    FlightAdapter flightAdapter;
    ImageView right , left ;

    List<String> listairport=new ArrayList<>() ;
    List<String>listImgflight=new ArrayList<>() ;
    List<String> listtakeoffdate=new ArrayList<>();
    List<String> listlandingdate=new ArrayList<>();
    List<String> listPrice=new ArrayList<>();
    List<String> listfromairport=new ArrayList<>();
    List<String> listtoairport=new ArrayList<>();


    private List<Bestflight>  bestflight = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;

//    private String best_flight = "http://egyptgoogle.com/bestflight/bestflightjson.php";

    RequestQueue requestQueue;

    public BestFlights() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_best_flights, container, false);
        recyclerView=view.findViewById(R.id.recycler_view_flight);

       linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);
        requestQueue = Volley.newRequestQueue(getContext());

        right = view.findViewById(R.id.img_right_deals);
        left = view.findViewById(R.id.img_left_deals);






        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (linearLayoutManager.findLastCompletelyVisibleItemPosition() < (flightAdapter.getItemCount() - 1)) {
                    linearLayoutManager.scrollToPosition(linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1);
                }

            }
        });


        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (linearLayoutManager.findLastCompletelyVisibleItemPosition() < (flightAdapter.getItemCount() + 1)) {
                    linearLayoutManager.scrollToPosition(linearLayoutManager.findLastCompletelyVisibleItemPosition() - 1);
                }


            }
        });







        class RecyclerViewDisabler implements RecyclerView.OnItemTouchListener {

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return true;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

                startActivity(new Intent(getContext(), OffersFlightsDetailsActivity.class));

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        }

        RecyclerView.OnItemTouchListener disabler = new RecyclerViewDisabler();

        recyclerView.addOnItemTouchListener(disabler);




        getBestFlight();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);







        return view;


    }




    private void getBestFlight() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, LinksUrl.URL_BEST_FLIGHT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("bestflight");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);


                        Bestflight listdataflight = new Bestflight(ob.getString("airplane"),ob.getString("fromairport")
                                ,ob.getString("toairport"),ob.getString("picture"),ob.getString("price"),ob.getString("takeoff"),ob.getString("landing"));



                        bestflight.add(listdataflight);

                        String airplane = bestflight.get(i).getAirplane();
                        String from_airport = bestflight.get(i).getFromairport();
                        String to_airport = bestflight.get(i).getToairport();
                        String picture = bestflight.get(i).getPicture();
                        String price = bestflight.get(i).getPrice();
                        String takeoff = bestflight.get(i).getTakeoff();
                        String landing = bestflight.get(i).getLanding();

                        SharedPreferencesManger.SaveData(getActivity(),"airplane",airplane);
                        SharedPreferencesManger.SaveData(getActivity(),"from_airport",from_airport);

                        SharedPreferencesManger.SaveData(getActivity(),"to_airport",to_airport);

                        SharedPreferencesManger.SaveData(getActivity(),"price",price);
                        SharedPreferencesManger.SaveData(getActivity(),"takeoff",takeoff);

                        SharedPreferencesManger.SaveData(getActivity(),"landing",landing);



                        listairport.add(airplane);
                        listfromairport.add(from_airport);
                        listtoairport.add(to_airport);
                        listImgflight.add(picture);
                        listPrice.add(price);
                        listtakeoffdate.add(takeoff);
                        listlandingdate.add(landing);

                    }

                    flightAdapter = new FlightAdapter(getContext(),listairport,listImgflight,listtakeoffdate,listlandingdate,listPrice,listfromairport,listtoairport);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(flightAdapter);

                    flightAdapter.notifyDataSetChanged();


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
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);


    }

}
