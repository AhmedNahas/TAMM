package net.middledleeast.tamm.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.CityWiseNotificationResponse;
import com.Tamm.Hotels.wcf.GiataHotelCodesResponse;
import com.Tamm.Hotels.wcf.HotelCodesResponse;
import com.Tamm.Hotels.wcf.HotelDetailsResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.BestHotelAdapter;
import net.middledleeast.tamm.helper.SharedPreferencesManger;
import net.middledleeast.tamm.model.Best.BestHotel;
import net.middledleeast.tamm.model.validation.Validtionmember;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BestHotels extends Fragment {
    RecyclerView recyclerView;
    BestHotelAdapter bestHotelAdapter;
    List<String> listName = new ArrayList<>();
    List<String> listImage = new ArrayList<>();
    List<String> listNameHotel = new ArrayList<>();
    private List<BestHotel> theBest = new ArrayList<>();

    //    private BasicHttpBinding_IHotelService1 service;
//    private AuthenticationData authenticationData;
private String best_hotels = "http://egyptgoogle.com/backend/hotels/bestdeals.php";
    RequestQueue requestQueue;


    ImageView right , left ;
    private LinearLayoutManager linearLayoutManager;
    public BestHotels() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.best_hotels, container, false);
        recyclerView=view.findViewById(R.id.recycler_view_hotels);
        right = view.findViewById(R.id.img_right);

        left = view.findViewById(R.id.img_left);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (linearLayoutManager.findLastCompletelyVisibleItemPosition() < (bestHotelAdapter.getItemCount() - 1)) {
                    linearLayoutManager.scrollToPosition(linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1);
                }

            }
        });



        Context context = getActivity();
        requestQueue = Volley.newRequestQueue(context);
        getBestHotels();




        class RecyclerViewDisabler implements RecyclerView.OnItemTouchListener {

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return true;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        }

        RecyclerView.OnItemTouchListener disabler = new RecyclerViewDisabler();

        recyclerView.addOnItemTouchListener(disabler);




        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (linearLayoutManager.findLastCompletelyVisibleItemPosition() < (bestHotelAdapter.getItemCount() + 1)) {
                    linearLayoutManager.scrollToPosition(linearLayoutManager.findLastCompletelyVisibleItemPosition() - 1);
                }


            }
        });
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);



//        listName.clear();
//        listImage.clear();
//        listNameHotel.clear();
//        auth();
//        getHotel("1000002");


        linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        bestHotelAdapter = new BestHotelAdapter(getContext(),getActivity(),listName,listImage ,listNameHotel ,1);
        recyclerView.setAdapter(bestHotelAdapter);


        return view;


    }


    private void getBestHotels() {
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
                    bestHotelAdapter.notifyDataSetChanged();


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



//    private void getHotel(String hotelCode) {
//
//
//        try {
//            HotelDetailsResponse detailsResponse = service.HotelDetails(100, null, hotelCode, "EN", authenticationData);
//
//
//
//            for (int i = 0; i < detailsResponse.HotelDetails.ImageUrls.size(); i++) {
//                String imges = detailsResponse.HotelDetails.ImageUrls.get(i).value;
//                String cityName = detailsResponse.HotelDetails.CityName;
//                String hotelName = detailsResponse.HotelDetails.HotelName;
//                listNameHotel.add(hotelName);
//                listName.add(cityName);
//                listImage.add(imges);
//            }
//
//
//            bestHotelAdapter.notifyDataSetChanged();
//
//        } catch (Exception e) {
//
//
//        }
//    }
//
//    private void auth() {
//
//        service = new BasicHttpBinding_IHotelService1();
//        service.enableLogging = true;
//        authenticationData = new AuthenticationData();
//        authenticationData.UserName = ("Tammtest");
//        authenticationData.Password = ("Tam@18418756");
//
//    }

}
