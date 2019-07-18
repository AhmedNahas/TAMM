package net.middledleeast.tamm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.middledleeast.tamm.R;



public class PassengerDeparture extends AppCompatActivity {
    int counter = 0;
    Button priceFinal;
    private ImageView imgincreaseadult,imgdecreaseadult;
    private TextView txtadult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_departure);
        priceFinal=findViewById(R.id.priceFinal);
        imgdecreaseadult=findViewById(R.id.decrease_adult);
        imgincreaseadult=findViewById(R.id.increase_adult);
        txtadult=findViewById(R.id.txtview_adult);

        priceFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PassengerDeparture.this,SeatSelection.class));
                // startActivity(new Intent(PassengerDeparture.this,Seat));
            }
        });

        imgincreaseadult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           counter=counter+1;
           display(counter);



            }
            private void display(int counter) {
                TextView displayInteger =  findViewById(
                        R.id.txtview_adult);
                displayInteger.setText("" + counter +"KG");

            }


        });
        imgdecreaseadult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter =counter - 1;
                display(counter);
            }

            private void display(int counter) {
                TextView displayInteger =  findViewById(
                        R.id.txtview_adult);
                displayInteger.setText("" + counter +"KG");

            }
        });



    }




}
