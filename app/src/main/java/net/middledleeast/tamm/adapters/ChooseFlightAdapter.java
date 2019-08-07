package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.List;

public class ChooseFlightAdapter extends RecyclerView.Adapter<ChooseFlightAdapter.ChooseFlightViewHolder> {

    private Context context;
    private List<String> airLineName ;

    public ChooseFlightAdapter(Context context, ArrayList<String> airLineName) {
        this.context = context;
        this.airLineName = airLineName;
    }




    @NonNull
    @Override
    public ChooseFlightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choose_flight_row,parent,false);

        return new ChooseFlightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseFlightViewHolder holder, int position) {

        String fees = airLineName.get(position);

        holder.airLine.setText(fees);







    }

    @Override
    public int getItemCount() {
        return airLineName.size();
    }

    public class ChooseFlightViewHolder extends RecyclerView.ViewHolder{


        TextView airLine;

        public ChooseFlightViewHolder(@NonNull View itemView) {
            super(itemView);

            airLine=itemView.findViewById(R.id.tv_airline);
        }
    }
}
