package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;


public class BestHotelAdapter extends RecyclerView.Adapter<BestHotelAdapter.BestHotelViewHolder> {


    private Context context;

    @NonNull
    @Override
    public BestHotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.hotel_shape,parent,false);

        return new BestHotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestHotelViewHolder holder, int position) {


        holder.textView1.setText("hoioio");
        holder.textView2.setText("honkoioi");


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BestHotelViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView1,imageView2;
        TextView textView1,textView2,textView3;


        public BestHotelViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView1=itemView.findViewById(R.id.iv_star_hotel);
            imageView2=itemView.findViewById(R.id.iv_best_hotel);

            textView1=itemView.findViewById(R.id.tv_country_hotel);
            textView2=itemView.findViewById(R.id.tv_price_hotel);
            textView3=itemView.findViewById(R.id.tv_best_hotel);
        }
    }

}
