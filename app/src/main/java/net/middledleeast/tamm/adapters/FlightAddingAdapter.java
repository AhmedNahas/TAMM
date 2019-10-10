package net.middledleeast.tamm.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.fragments.MultiCitiesFlights;
import net.middledleeast.tamm.fragments.SearchFlightByCity;

import java.util.List;

public class FlightAddingAdapter extends RecyclerView.Adapter<FlightAddingAdapter.SingleView> {


    // list count of spinner children
    List<Integer> listCountCild;
    Context context;
    Activity activity ;


    public FlightAddingAdapter(List<Integer> listCountCild, Context context , Activity activity) {
        this.activity = activity;
        this.listCountCild = listCountCild;
        this.context = context;

    }

    @NonNull
    @Override
    public SingleView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.multicity_row, parent, false);
        return new SingleView(view);
    }

    @SuppressLint({"SetTextI18n", "CommitPrefEdits"})
    @Override
    public void onBindViewHolder(@NonNull SingleView holder, int position) {


        holder.from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SearchFlightByCity searchFlightByCity = new SearchFlightByCity();
//
//                Bundle bundle = new Bundle();
//                bundle.putInt("id_t", 3);
//                searchFlightByCity.setArguments(bundle);
                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().add(R.id.flights_container, searchFlightByCity)
                        .addToBackStack("ProceedBeyBeyOriginal").commit();

            }
        });

        holder.to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }


    @Override
    public int getItemCount() {
        return listCountCild.size();
    }

    public class SingleView extends RecyclerView.ViewHolder {

        TextView from_country , to_country;
        private TextView from, to;

        public SingleView(@NonNull View itemView) {
            super(itemView);


            from = itemView.findViewById(R.id.from_multi);
            to = itemView.findViewById(R.id.to_multi);

            from_country = itemView.findViewById(R.id.from_country_multi);
            to_country = itemView.findViewById(R.id.to_country_multi);

        }
    }
}
