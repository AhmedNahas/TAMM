package net.middledleeast.tamm.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;

import java.util.List;

public class AdapterAirportCuntry  extends RecyclerView.Adapter<AdapterAirportCuntry.SingleView>{

    List<String> cityCode;
    List<String>   airportName;
    List<String> airportCode ;

    public AdapterAirportCuntry(List<String> cityCode  , List<String>   airportName , List<String> airportCode) {
        this.airportCode=airportCode;
        this.cityCode=cityCode;
        this.airportName= airportName;

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


        }



    }

    @Override
    public int getItemCount() {
        return airportName.size();
    }

    public class SingleView extends RecyclerView.ViewHolder {

        TextView  airportCode , airportName  , cityCode ;

        public SingleView(@NonNull View itemView) {
            super(itemView);

            airportCode = itemView.findViewById(R.id.airportCode);
            airportName = itemView.findViewById(R.id.airportName);
            cityCode = itemView.findViewById(R.id.cityCode);

        }
    }
}
