package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;

public class FromToRvAdapter extends RecyclerView.Adapter<FromToRvAdapter.FromToRvViewHolder> {

    Context context;

    @NonNull
    @Override
    public FromToRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_dialog,parent,false);
        return new FromToRvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FromToRvViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FromToRvViewHolder extends RecyclerView.ViewHolder{

        EditText searchCity;

        public FromToRvViewHolder(@NonNull View itemView) {

            super(itemView);
            searchCity=itemView.findViewById(R.id.et);
        }
    }
}
