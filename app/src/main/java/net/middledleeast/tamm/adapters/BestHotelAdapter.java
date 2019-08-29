package net.middledleeast.tamm.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.OffersDetailsActivity;

import java.util.List;


public class BestHotelAdapter extends RecyclerView.Adapter<BestHotelAdapter.BestHotelViewHolder> {


    private Context context;
    Activity activity ;
    int id ;

    List<String> listCountry ;
    List<String>listImg ;
    List<String> listNameHotel;
    List<String> listPrice;

    public BestHotelAdapter(Context context, Activity activity, int id, List<String> listCountry, List<String> listImg, List<String> listNameHotel, List<String> listPrice) {
        this.context = context;
        this.activity = activity;
        this.id = id;

        this.listCountry = listCountry;
        this.listImg = listImg;
        this.listNameHotel = listNameHotel;
        this.listPrice = listPrice;

    }

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


        }else {

            String hotelname = listNameHotel.get(position);
            String images = listImg.get(position);
            String country = listCountry.get(position);
            String price = listPrice.get(position);


            holder.tv_best_hotel.setText(hotelname);
            holder.tv_price_.setText(price);
            holder.tv_country_hotel.setText(country);
            Glide.with(context).load(images).into(holder.img_hotel);




            holder.img_hotel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent intent = new Intent(context , OffersDetailsActivity.class);
                    context.startActivity(intent);

                }
            });

        }

    }


    @Override
    public int getItemCount() {

        return listNameHotel != null ? listNameHotel.size() : 0;
    }

    public class BestHotelViewHolder extends RecyclerView.ViewHolder{
        ImageView star,img_hotel;
        TextView tv_country_hotel,tv_price_hotel,tv_best_hotel,tv_price_;


        public BestHotelViewHolder(@NonNull View itemView) {
            super(itemView);
            star=itemView.findViewById(R.id.iv_star_hotel);
            img_hotel=itemView.findViewById(R.id.iv_best_hotel);

            tv_price_=itemView.findViewById(R.id.tv_price_);
            tv_country_hotel=itemView.findViewById(R.id.tv_country_hotel);
            tv_price_hotel=itemView.findViewById(R.id.tv_price_hotel);
            tv_best_hotel=itemView.findViewById(R.id.tv_best_hotel);
        }
    }



}
