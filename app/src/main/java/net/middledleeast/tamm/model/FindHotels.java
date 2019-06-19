package net.middledleeast.tamm.model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.adapters.AreaAdapter;
import net.middledleeast.tamm.adapters.RegionAdapter;

import java.util.ArrayList;

public class FindHotels extends AppCompatActivity {

    private ArrayList<RegionItem> regionList = new ArrayList<>();
    private ArrayList<AreaItem> areaList= new ArrayList<>();
    private RegionAdapter regionAdapter;
    private AreaAdapter areaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_hotels);



        regionList();
        areaList();

        Spinner areas = findViewById(R.id.area_spinner);
        areaAdapter = new AreaAdapter(this,areaList);
        areas.setAdapter(areaAdapter);
        areas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AreaItem clickedItem = (AreaItem) parent.getItemAtPosition(position);
                String selectedArea = clickedItem.getAreaName();
                Toast.makeText(FindHotels.this, "Selected : " + selectedArea, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner regions = findViewById(R.id.region_spinner);
        regionAdapter = new RegionAdapter(this,regionList);
        regions.setAdapter(regionAdapter);
        regions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                RegionItem clickedItem = (RegionItem) parent.getItemAtPosition(position);
                String selectedRegion = clickedItem.getName();
                Toast.makeText(FindHotels.this, selectedRegion + " Selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }



    private void regionList() {

        regionList = new ArrayList<>();
        regionList.add(new RegionItem("Cairo",1,1));
        regionList.add(new RegionItem("Giza",2,1));
        regionList.add(new RegionItem("6 October",3,1));

    }
    private void areaList(){
        areaList = new ArrayList<>();
        areaList.add(new AreaItem("Nasr City",1,1));
        areaList.add(new AreaItem("Dokki",2,2));
        areaList.add(new AreaItem("Zayed",3,3));
    }





}
