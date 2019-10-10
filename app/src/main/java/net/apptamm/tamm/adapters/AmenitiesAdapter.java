package net.apptamm.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.apptamm.tamm.R;

import java.util.ArrayList;

public class AmenitiesAdapter extends RecyclerView.Adapter<AmenitiesAdapter.AmenitiesViewHolder> {

    Context context;
    ArrayList<String> amenities;

    public AmenitiesAdapter(Context context, ArrayList<String> amenities) {
        this.context = context;
        this.amenities = amenities;
    }


    @NonNull
    @Override
    public AmenitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_amenities_recycler,parent,false);
        return new AmenitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AmenitiesViewHolder holder, int position) {

        holder.amenitiesMain.setText(amenities.get(position));


    }

    @Override
    public int getItemCount() {
        return amenities.size();
    }

    public class AmenitiesViewHolder extends RecyclerView.ViewHolder {

        TextView amenitiesMain ;
        public AmenitiesViewHolder(@NonNull View itemView) {
            super(itemView);
            amenitiesMain=itemView.findViewById(R.id.main_amenities);
        }
    }
}
