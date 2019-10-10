package net.apptamm.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import net.apptamm.tamm.R;

import java.util.List;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.BestFlightViewHolder> {
Context context;

    List<String> listairport ;
    List<String>listImgflight ;
    List<String> listtakeoffdate;
    List<String> listlandingdate;
    List<String> listPrice;
    List<String> listfromairport;
    List<String> listtoairport;

    public FlightAdapter(Context context, List<String> listairport, List<String> listImgflight, List<String> listtakeoffdate, List<String> listlandingdate, List<String> listPrice, List<String> listfromairport, List<String> listtoairport) {
        this.context=context;
        this.listairport = listairport;
        this.listImgflight = listImgflight;
        this.listtakeoffdate = listtakeoffdate;
        this.listlandingdate = listlandingdate;
        this.listPrice = listPrice;
        this.listfromairport = listfromairport;
        this.listtoairport = listtoairport;
    }

    @NonNull
    @Override
    public BestFlightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.flight_raw,parent,false);

        return new BestFlightViewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull BestFlightViewHolder holder, int position) {

        String airline = listairport.get(position);
        String image=listImgflight.get(position);
//        String takeoff = listtakeoffdate.get(position);
//        String landing =listlandingdate.get(position);
        String price = listPrice.get(position);
//        String fromairport = listfromairport.get(position);
//        String toairport = listtoairport.get(position);



        holder.tv_best_flight.setText(airline);
        holder.tv_price_.setText(price);
//        holder.tv_from_airport_flight.setText(fromairport);
//        holder.tv_to_airport_flight.setText(toairport);
//        holder.tv_takeoff_flight.setText(takeoff);
//        holder.tv_land_date.setText(landing);

        Glide.with(context).load(image).into(holder.iv_best_flight);





    }




    @Override
    public int getItemCount() {
        return listairport != null ? listairport.size() : 0;
    }




    public class BestFlightViewHolder extends RecyclerView.ViewHolder {

        TextView tv_from_flight,tv_from_airport_flight,tv_to_flight,tv_to_airport_flight,tv_price_flight,tv_price_
                ,tv_takeoff_date_flight,tv_takeoff_flight,tv_landing_date_flight,tv_land_date,tv_best_flight;
        ImageView iv_best_flight;


        public BestFlightViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_best_flight=itemView.findViewById(R.id.tv_best_flight);
            tv_from_flight=itemView.findViewById(R.id.tv_from_flight);
            tv_from_airport_flight=itemView.findViewById(R.id.tv_from_airport_flight);
            tv_to_flight=itemView.findViewById(R.id.tv_to_flight);
            tv_to_airport_flight=itemView.findViewById(R.id.tv_to_airport_flight);
            tv_price_flight=itemView.findViewById(R.id.tv_price_flight);
            tv_price_= itemView.findViewById(R.id.tv_price_);

            tv_takeoff_date_flight=itemView.findViewById(R.id.tv_takeoff_date_flight);
            tv_takeoff_flight=itemView.findViewById(R.id.tv_takeoff_flight);
            tv_landing_date_flight=itemView.findViewById(R.id.tv_landing_date_flight);
            tv_land_date=itemView.findViewById(R.id.tv_land_date);



            iv_best_flight=itemView.findViewById(R.id.iv_best_flight);



        }
    }
}
