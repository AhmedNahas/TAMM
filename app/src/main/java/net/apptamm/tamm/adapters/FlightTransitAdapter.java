package net.apptamm.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.apptamm.tamm.R;

import java.util.List;

import FlightApi.SearchFlightsResponse;


public class FlightTransitAdapter extends RecyclerView.Adapter<FlightTransitAdapter.BestHotelViewHolder> {


    private Context context;

    List<SearchFlightsResponse.Segment> segments;


    public FlightTransitAdapter(Context context ,  List<SearchFlightsResponse.Segment> segments ) {
        this.context = context;
      this.segments = segments;

    }

    @NonNull
    @Override
    public BestHotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.item_transit,parent,false);

        return new BestHotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestHotelViewHolder holder, int position) {


        String cityNameorigin = segments.get(position).getOrigin().getCityName();
        String cityNamedestination = segments.get(position).getDestination().getCityName();

        holder.to.setText(cityNamedestination);
        holder.from.setText(cityNameorigin+"  -");


    }


    @Override
    public int getItemCount() {

        return segments.size();
    }

    public class BestHotelViewHolder extends RecyclerView.ViewHolder{

        TextView from  , to ;

        public BestHotelViewHolder(@NonNull View itemView) {
            super(itemView);

            to=itemView.findViewById(R.id.to);
            from=itemView.findViewById(R.id.from);
        }
    }



}
