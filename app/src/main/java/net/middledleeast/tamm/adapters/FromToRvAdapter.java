package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;

public class FromToRvAdapter extends RecyclerView.Adapter<FromToRvAdapter.FromToRvViewHolder> {

    Context context;

    @NonNull
    @Override
    public FromToRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.from_to_row,parent,false);
        return new FromToRvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FromToRvViewHolder holder, int position) {

        holder.cityName.setText("Dubai");
        holder.cityCode.setText("DUB");
        holder.countryName.setText("United Emirates");

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FromToRvViewHolder extends RecyclerView.ViewHolder{

        TextView cityName , cityCode , countryName;

        public FromToRvViewHolder(@NonNull View itemView) {

            super(itemView);
            cityName=itemView.findViewById(R.id.city_name);
            cityCode=itemView.findViewById(R.id.city_code);
            countryName=itemView.findViewById(R.id.country_name);
        }
    }
}
