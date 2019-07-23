package net.middledleeast.tamm.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import net.middledleeast.tamm.R;

import java.util.List;


public class BestHotelAdapter extends RecyclerView.Adapter<BestHotelAdapter.BestHotelViewHolder> {


    private Context context;
    Activity activity ;
    int id ;

    public BestHotelAdapter(Context context, Activity activity, List<String> listName , List<String> listImg , List<String> getListNameHotel, int id ) {
        this.context = context;
        this.activity = activity;
        this.listName = listName;
        this.listImg = listImg;
        this.getListNameHotel = getListNameHotel;
        this.id = id;
    }

    List<String> listName ;
    List<String>listImg ;
    List<String> getListNameHotel;


    @NonNull
    @Override
    public BestHotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.hotel_shape,parent,false);

        return new BestHotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestHotelViewHolder holder, int position) {


        if (id == 2){

            holder.tv_best_hotel.setText("Best Deals");


        }

        String name = listName.get(position);
        String images = listImg.get(position);

        String hotelName  = getListNameHotel.get(position);
        holder.tv_price_hotel.setText(hotelName);

        holder.tv_country_hotel.setText(name);
        Glide.with(context).load(images).into(holder.img_hotel);

    }

    @Override
    public int getItemCount() {
        return listName.size();
    }

    public class BestHotelViewHolder extends RecyclerView.ViewHolder{
        ImageView star,img_hotel;
        TextView tv_country_hotel,tv_price_hotel,tv_best_hotel;


        public BestHotelViewHolder(@NonNull View itemView) {
            super(itemView);
            star=itemView.findViewById(R.id.iv_star_hotel);
            img_hotel=itemView.findViewById(R.id.iv_best_hotel);

            tv_country_hotel=itemView.findViewById(R.id.tv_country_hotel);
            tv_price_hotel=itemView.findViewById(R.id.tv_price_hotel);
            tv_best_hotel=itemView.findViewById(R.id.tv_best_hotel);
        }
    }

}
