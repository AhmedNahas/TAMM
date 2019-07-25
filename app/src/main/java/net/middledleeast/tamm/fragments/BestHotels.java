package net.middledleeast.tamm.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.StrictMode;
import android.view.LayoutInflater;
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

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.BestHotelAdapter;

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
    private BasicHttpBinding_IHotelService1 service;
    private AuthenticationData authenticationData;

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

        auth();

        listName.clear();
        listImage.clear();
        listNameHotel.clear();
        getHotel("1000002");


         linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        bestHotelAdapter = new BestHotelAdapter(getContext(),getActivity(),listName,listImage ,listNameHotel ,1);
        recyclerView.setAdapter(bestHotelAdapter);


        return view;


    }

    private void getHotel(String hotelCode) {


        try {
            HotelDetailsResponse detailsResponse = service.HotelDetails(100, null, hotelCode, "EN", authenticationData);



            for (int i = 0; i < detailsResponse.HotelDetails.ImageUrls.size(); i++) {
                String imges = detailsResponse.HotelDetails.ImageUrls.get(i).value;
                String cityName = detailsResponse.HotelDetails.CityName;
                String hotelName = detailsResponse.HotelDetails.HotelName;
                listNameHotel.add(hotelName);
                listName.add(cityName);
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
