package net.middledleeast.tamm.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.SingleView> {


    List<String> arrayOfCityLists;


    public CountryAdapter(List<String> arrayOfCityLists) {
        this.arrayOfCityLists = arrayOfCityLists;

    }

    @NonNull
    @Override
    public SingleView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.region_row,parent,false);
        return new SingleView(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SingleView holder, int position) {
//
//        Hotel_Result result =  arrayOfCityLists.get(position).HotelResultList.get(position);
//      String nam = result.HotelInfo.HotelAddress;

        holder.textView.setText(arrayOfCityLists.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayOfCityLists.size();
    }

    public class SingleView extends RecyclerView.ViewHolder{

        TextView textView;

        public SingleView(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.region_name);
        }
    }
}
