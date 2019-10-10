package net.apptamm.tamm.fragments;


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

import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.HotelDetailsResponse;

import net.apptamm.tamm.R;
import net.apptamm.tamm.adapters.BestHotelAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BestDeals extends Fragment {
    RecyclerView recyclerView;
    BestHotelAdapter bestHotelAdapter;
    List<String> listCountry = new ArrayList<>();
    List<String> listImage = new ArrayList<>();
    List<String> listNameHotel = new ArrayList<>();
    List<String> listPrice = new ArrayList<>();
    List<String> listCity = new ArrayList<>();
    private BasicHttpBinding_IHotelService1 service;
    private AuthenticationData authenticationData;
    ImageView right , left ;
    private LinearLayoutManager linearLayoutManager;

    public BestDeals() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_best_deals, container, false);

        recyclerView=view.findViewById(R.id.recycler_view_deals);

        right = view.findViewById(R.id.img_right_deals);

        left = view.findViewById(R.id.img_left_deals);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (linearLayoutManager.findLastCompletelyVisibleItemPosition() < (bestHotelAdapter.getItemCount() - 1)) {
                    linearLayoutManager.scrollToPosition(linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1);
                }

            }
        });



        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (linearLayoutManager.findLastCompletelyVisibleItemPosition() < (bestHotelAdapter.getItemCount() + 1)) {
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

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        }

        RecyclerView.OnItemTouchListener disabler = new RecyclerViewDisabler();

        recyclerView.addOnItemTouchListener(disabler);


         linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        auth();

        listCountry.clear();
        listImage.clear();
        listNameHotel.clear();
        getHotel("1000001");

        recyclerView.setLayoutManager(linearLayoutManager);
        bestHotelAdapter = new BestHotelAdapter(getContext(),getActivity(),2,listCountry,listImage ,listNameHotel ,listPrice);
        recyclerView.setAdapter(bestHotelAdapter);

        return view;

    }

    private void getHotel(String hotelCode) {


        try {
            HotelDetailsResponse detailsResponse = service.HotelDetails(100, null, hotelCode, "EN", authenticationData);



            for (int i = 0; i < detailsResponse.HotelDetails.ImageUrls.size(); i++) {
                String imges = detailsResponse.HotelDetails.ImageUrls.get(i).value;
                String country = detailsResponse.HotelDetails.CityName;
                String hotelName = detailsResponse.HotelDetails.HotelName;

                listNameHotel.add(hotelName);
                listCountry.add(country);
                listImage.add(imges);
            }


            bestHotelAdapter.notifyDataSetChanged();

        } catch (Exception e) {


        }
    }

    private void auth() {

        service = new BasicHttpBinding_IHotelService1();
        service.enableLogging = true;
        authenticationData = new AuthenticationData();
        authenticationData.UserName = ("Tammtest");
        authenticationData.Password = ("Tam@18418756");

    }
}
