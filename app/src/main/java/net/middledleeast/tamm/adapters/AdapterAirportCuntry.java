package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.fragments.ProceedBeyBeyOriginal;
import net.middledleeast.tamm.model.modelflightSearsh;

import java.util.ArrayList;
import java.util.List;

public class AdapterAirportCuntry extends RecyclerView.Adapter<AdapterAirportCuntry.ExampleViewHolder> implements Filterable {
    private List<modelflightSearsh> exampleList;
    private List<modelflightSearsh> exampleListFull;
    int id;

    Context context ;
    class ExampleViewHolder extends RecyclerView.ViewHolder {
        TextView airportCode, airportName, cityCode;
        RelativeLayout layout_airplan;

        ExampleViewHolder(View itemView) {
            super(itemView);
            airportCode = itemView.findViewById(R.id.airportCode);
            airportName = itemView.findViewById(R.id.airportName);
            cityCode = itemView.findViewById(R.id.cityCode);
            layout_airplan = itemView.findViewById(R.id.layout_airplan);
        }
    }

    public AdapterAirportCuntry(List<modelflightSearsh> exampleList, int id , Context context) {
        this.exampleList = exampleList;
        exampleListFull = new ArrayList<>(exampleList);
        this.id = id;
        this.context = context ;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flight_cuntry,
                parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        modelflightSearsh currentItem = exampleList.get(position);

        String cityCode = currentItem.getCityCode();
        String country = currentItem.getCountry();
        String cuntryCode = currentItem.getCuntryCode();

        holder.airportCode.setText(cuntryCode);
        holder.airportName.setText(country);
        holder.cityCode.setText(cityCode);


        holder.layout_airplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProceedBeyBeyOriginal fragment = new ProceedBeyBeyOriginal();
                Bundle bundle = new Bundle();
                bundle.putString("name_country", country);
                bundle.putString("city_code", cityCode);
                bundle.putInt("id", id);

                fragment.setArguments(bundle);

                ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flights_container, fragment)
                        .commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<modelflightSearsh> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (modelflightSearsh item : exampleListFull) {
                    if (item.getCountry().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            exampleList.clear();
            exampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


}


//public class AdapterAirportCuntry  extends RecyclerView.Adapter<AdapterAirportCuntry.SingleView>{
//
//    List<String> cityCode;
//    List<String>   airportName;
//    List<String> airportCode ;
//    private Activity  activity;
//    Context context ;
//    int id ;
//
//    public AdapterAirportCuntry(List<String> cityCode  , List<String>   airportName , List<String> airportCode , Activity activity  , Context context , int id ) {
//        this.airportCode=airportCode;
//        this.cityCode=cityCode;
//        this.airportName= airportName;
//        this.context = context;
//        this.activity =activity;
//        this.id= id;
//
//    }
//
//    @NonNull
//    @Override
//    public AdapterAirportCuntry.SingleView onCreateViewHolder(@NonNull ViewGroup parent, int i) {
//
//
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flight_cuntry, parent, false);
//        return new  SingleView(view);
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull AdapterAirportCuntry.SingleView holder, int i) {
//
//
//
//        if (i==0){
//
//
//        }else {
//            String airportcode = airportCode.get(i);
//            String name = airportName.get(i);
//            String citycode = cityCode.get(i);
//            holder.airportCode.setText(airportcode);
//            holder.airportName.setText(name);
//            holder.cityCode.setText(citycode);
//
//            holder.layout_airplan.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//ProceedBeyBeyOriginal fragment = new ProceedBeyBeyOriginal();
//                    Bundle bundle = new Bundle();
//                    bundle.putString("name_country",name);
//                    bundle.putString("city_code",citycode);
//                    bundle.putInt("id",id);
//
//fragment.setArguments(bundle);
//
//                    ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.flights_container, fragment)
//                            .commit();
//
//
//                }
//            });
//
//
//
//        }
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return airportName.size();
//    }
//
//    public class SingleView extends RecyclerView.ViewHolder {
//
//        TextView  airportCode , airportName  , cityCode ;
//        RelativeLayout layout_airplan ;
//
//        public SingleView(@NonNull View itemView) {
//            super(itemView);
//
//            airportCode = itemView.findViewById(R.id.airportCode);
//            airportName = itemView.findViewById(R.id.airportName);
//            cityCode = itemView.findViewById(R.id.cityCode);
//            layout_airplan = itemView.findViewById(R.id.layout_airplan);
//
//        }
//    }
//}
