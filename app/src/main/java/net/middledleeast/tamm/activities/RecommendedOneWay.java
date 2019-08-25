package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.ChooseFlightAdapter;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;

public class RecommendedOneWay extends AppCompatActivity {

private RecyclerView recyclerView;
    private ArrayList<String> airlineNameList = new ArrayList<>();
    private ArrayList<String> Listduration = new ArrayList<>();

    private ArrayList<String> ListArriveTime = new ArrayList<>();
    private ArrayList<String> ListdeparuerTime = new ArrayList<>();

    private ArrayList<String> countryNameDestinationList = new ArrayList<>();
    private ArrayList<String> countryNameOriginList = new ArrayList<>();
    ArrayList<String> listIncludedBaggage = new ArrayList<>();
    ArrayList<String> listCabinBaggage = new ArrayList<>();
    ArrayList<Double> listTotalFare = new ArrayList<>();
    ArrayList<String> listTypeFare = new ArrayList<>();
    private ArrayList<String> ListairportCode_Origin = new ArrayList<>();
    private ArrayList<String> ListairportCode_Distnation = new ArrayList<>();
    private ArrayList<String> ListflightNumber = new ArrayList<>();
    private ArrayList<String> ListMealType = new ArrayList<>();
    private ArrayList<Long> ListnoOfSeatAvailable = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommended__one_way);


        recyclerView=findViewById(R.id.rv_flightList);
        Listduration = (ArrayList<String>) getIntent().getSerializableExtra("Listduration");


        airlineNameList = (ArrayList<String>) getIntent().getSerializableExtra("airlineName");

        ListArriveTime = (ArrayList<String>) getIntent().getSerializableExtra("arrivalTime");

        ListdeparuerTime = (ArrayList<String>) getIntent().getSerializableExtra("departureTime");

        countryNameDestinationList = (ArrayList<String>) getIntent().getSerializableExtra("countryNameDestinationList");
        countryNameOriginList = (ArrayList<String>) getIntent().getSerializableExtra("countryNameOriginList");

        listIncludedBaggage = (ArrayList<String>) getIntent().getSerializableExtra("listIncludedBaggage");
        listCabinBaggage = (ArrayList<String>) getIntent().getSerializableExtra("listCabinBaggage");

        listTotalFare = (ArrayList<Double>) getIntent().getSerializableExtra("listTotalFare");

        listTypeFare = (ArrayList<String>) getIntent().getSerializableExtra("listTypeFare");

        ListflightNumber = (ArrayList<String>) getIntent().getSerializableExtra("ListflightNumber");


        ListairportCode_Distnation = (ArrayList<String>) getIntent().getSerializableExtra("ListairportCode_Distnation");

        ListairportCode_Origin = (ArrayList<String>) getIntent().getSerializableExtra("ListairportCode_Origin");
       ListMealType = (ArrayList<String>) getIntent().getSerializableExtra("ListMealType");

        ListnoOfSeatAvailable = (ArrayList<Long>) getIntent().getSerializableExtra("ListnoOfSeatAvailable");



        ChooseFlightAdapter chooseFlightAdapter = new ChooseFlightAdapter(this,airlineNameList ,Listduration ,ListArriveTime,ListdeparuerTime
                , countryNameDestinationList , countryNameOriginList,listIncludedBaggage,listCabinBaggage , listTotalFare, listTypeFare ,ListairportCode_Distnation , ListairportCode_Origin
        , ListflightNumber , ListMealType , ListnoOfSeatAvailable);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chooseFlightAdapter);
        chooseFlightAdapter.notifyDataSetChanged();




    }
}
