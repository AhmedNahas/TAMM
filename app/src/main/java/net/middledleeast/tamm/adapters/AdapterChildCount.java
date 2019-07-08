package net.middledleeast.tamm.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Context;

import net.middledleeast.tamm.R;

import java.util.List;

public class AdapterChildCount extends RecyclerView.Adapter<AdapterChildCount.SingleView> {


    List<Integer> listCountCild;
    Activity activity
            ;




    public AdapterChildCount(Activity activity , List<Integer> listCountCild) {
        this.listCountCild = listCountCild;
        this.activity = activity;

    }

    @NonNull
    @Override
    public SingleView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spiner_childern,parent,false);
        return new SingleView(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SingleView holder, int position) {


        int integer = listCountCild.get(position);


        holder.child_no_tv.setText("Childern "+integer+" age");






//            listCountCild.remove(position);




    }

    @Override
    public int getItemCount() {
        return listCountCild.size();
    }

    public class SingleView extends RecyclerView.ViewHolder{

        Spinner spinner_no_Child ;
        TextView child_no_tv;

        public SingleView(@NonNull View itemView) {
            super(itemView);
            spinner_no_Child = itemView.findViewById(R.id.spinner_no_Child);
            child_no_tv = itemView.findViewById(R.id.child_no_tv);
        }
    }
}
