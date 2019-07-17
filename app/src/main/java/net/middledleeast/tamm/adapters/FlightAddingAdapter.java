package net.middledleeast.tamm.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.Proceedbeybey;
import net.middledleeast.tamm.fragments.SearchFlightByCity;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.List;

public class FlightAddingAdapter extends RecyclerView.Adapter<FlightAddingAdapter.SingleView> {


    // list count of spinner children
    List<Integer> listCountCild;
    Context context;





    public FlightAddingAdapter( List<Integer> listCountCild  ) {
        this.listCountCild = listCountCild;;

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



        holder.fromTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchFlightByCity searchFlightByCity = new SearchFlightByCity();


                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                SearchFlightByCity myFragment = new SearchFlightByCity();
                activity.getSupportFragmentManager().beginTransaction().add(R.id.flights_container, myFragment).addToBackStack(null).commit();

            }
        });

        holder.toTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchFlightByCity searchFlightByCity = new SearchFlightByCity();
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                SearchFlightByCity myFragment = new SearchFlightByCity();
                activity.getSupportFragmentManager().beginTransaction().add(R.id.flights_container, myFragment).addToBackStack(null).commit();

            }
        });





            }


    @Override
    public int getItemCount() {
        return listCountCild.size();
    }

    public class SingleView extends RecyclerView.ViewHolder {

        Spinner spinner_no_Child;
        TextView child_no_tv;
        private TextView fromTextView , toTextView;

        public SingleView(@NonNull View itemView) {
            super(itemView);
            spinner_no_Child = itemView.findViewById(R.id.spinner_no_Child);
            child_no_tv = itemView.findViewById(R.id.child_no_tv);

            fromTextView=itemView.findViewById(R.id.country_from_textview);
            toTextView=itemView.findViewById(R.id.country_to_textview);
        }
    }
}
