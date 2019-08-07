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
    private ArrayList<String> feesList = new ArrayList<>();
    private String fees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommended__one_way);


        recyclerView=findViewById(R.id.rv_flightList);


        fees = SharedPreferencesManger.LoadStringData(this,"serviceFee");
        feesList.add(fees);
        ChooseFlightAdapter chooseFlightAdapter = new ChooseFlightAdapter(this,feesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chooseFlightAdapter);
        chooseFlightAdapter.notifyDataSetChanged();




    }
}
