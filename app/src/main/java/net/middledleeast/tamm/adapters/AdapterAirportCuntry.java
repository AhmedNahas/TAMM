package net.middledleeast.tamm.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.fragments.ProceedBeyBeyOriginal;

import java.util.List;

public class AdapterAirportCuntry  extends RecyclerView.Adapter<AdapterAirportCuntry.SingleView>{

    List<String> cityCode;
    List<String>   airportName;
    List<String> airportCode ;
    private Activity  activity;
    Context context ;
    int id ;

    public AdapterAirportCuntry(List<String> cityCode  , List<String>   airportName , List<String> airportCode , Activity activity  , Context context , int id ) {
        this.airportCode=airportCode;
        this.cityCode=cityCode;
        this.airportName= airportName;
        this.context = context;
        this.activity =activity;
        this.id= id;

    }

    @NonNull
    @Override
    public AdapterAirportCuntry.SingleView onCreateViewHolder(@NonNull ViewGroup parent, int i) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flight_cuntry, parent, false);
        return new  SingleView(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAirportCuntry.SingleView holder, int i) {



        if (i==0){


        }else {
            String airportcode = airportCode.get(i);
            String name = airportName.get(i);
            String citycode = cityCode.get(i);
            holder.airportCode.setText(airportcode);
            holder.airportName.setText(name);
            holder.cityCode.setText(citycode);

            holder.layout_airplan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

ProceedBeyBeyOriginal fragment = new ProceedBeyBeyOriginal();
                    Bundle bundle = new Bundle();
                    bundle.putString("name_country",name);
                    bundle.putString("city_code",citycode);
                    bundle.putInt("id",id);

fragment.setArguments(bundle);

                    ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flights_container, fragment)
                            .commit();


                }
            });



        }



    }

    @Override
    public int getItemCount() {
        return airportName.size();
    }

    public class SingleView extends RecyclerView.ViewHolder {

        TextView  airportCode , airportName  , cityCode ;
        RelativeLayout layout_airplan ;

        public SingleView(@NonNull View itemView) {
            super(itemView);

            airportCode = itemView.findViewById(R.id.airportCode);
            airportName = itemView.findViewById(R.id.airportName);
            cityCode = itemView.findViewById(R.id.cityCode);
            layout_airplan = itemView.findViewById(R.id.layout_airplan);

        }
    }
}
