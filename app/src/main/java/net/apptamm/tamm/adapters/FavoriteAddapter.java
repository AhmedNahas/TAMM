package net.apptamm.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import net.apptamm.tamm.R;
import net.apptamm.tamm.model.Room.RoomCartModel;

import java.util.List;

public class FavoriteAddapter extends RecyclerView.Adapter<FavoriteAddapter.FavoriteViewholder> {


    Context context;

List<RoomCartModel> roomCartModels ;


    public FavoriteAddapter(List<RoomCartModel> allData, Context context) {
        this.context =context;
        this.roomCartModels =allData;

    }

    @NonNull
    @Override
    public FavoriteViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offers_raw,parent,false);
        return new FavoriteViewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewholder holder, int position) {




        final RoomCartModel roomCartModel = roomCartModels.get(position);

        final String image = roomCartModel.getImage();
        final String country = roomCartModel.getCountry();
        final String namehotel = roomCartModel.getNamehotel();
        final String price=roomCartModel.getPrice();
        final String city=roomCartModel.getCity();



        holder.tv_city_offer.setText(city);
        holder.tv_country_offer.setText(country);
        holder.tv_hotel_offers.setText(namehotel);
        holder.tv_price.setText(price);
        Glide.with(context).load(image).into(holder.iv_image_offer);



    }

    @Override
    public int getItemCount() {
        return roomCartModels.size();
    }

    public class FavoriteViewholder extends RecyclerView.ViewHolder {

        ImageView iv_image_offer,iv_star_offer;
        TextView tv_hotel_offers,tv_country_offer,tv_city_offer,tv_price;

        public FavoriteViewholder(@NonNull View itemView) {
            super(itemView);

            iv_image_offer=itemView.findViewById(R.id.iv_image_offer);
            iv_star_offer=itemView.findViewById(R.id.iv_star_offer);

            tv_price=itemView.findViewById(R.id.tv_price);
            tv_hotel_offers=itemView.findViewById(R.id.tv_hotel_offers);
            tv_country_offer=itemView.findViewById(R.id.tv_country_offer);
            tv_city_offer=itemView.findViewById(R.id.tv_city_offer);




        }
    }
}
