package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.bumptech.glide.Glide;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.model.Room.AppDatabase;
import net.middledleeast.tamm.model.Room.RoomCartModel;

import java.util.List;



public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.Offerviewholder> {
    public static AppDatabase appDatabase;
    private boolean Offer = false;

    Context context;
    int id ;
    List<String> listName;
    List<String>listImg;
    List<String> listcountry;
    List<String> listprice;
    List<String> listcity;

    public OffersAdapter(Context context, int id, List<String> listName, List<String> listImg, List<String> listcountry, List<String> listprice, List<String> listcity) {
        this.context = context;
        this.id = id;
        this.listName = listName;
        this.listImg = listImg;
        this.listcountry = listcountry;
        this.listprice = listprice;
        this.listcity = listcity;
    }

    @NonNull
    @Override
    public Offerviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offers_raw,parent,false);
        return new Offerviewholder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull Offerviewholder holder, int a) {



        if (id==1){

            String hotelName = listName.get(a);
            String images = listImg.get(a);
            String price=listprice.get(a);
            String city=listcity.get(a);
            String country = listcountry.get(a);



            holder.tv_hotel_offers1.setText(hotelName);
            holder.tv_country_offer1.setText(country);
            holder.tv_city_offer1.setText(city);
            holder.tv_price1.setText(price);
            Glide.with(context).load(images).into(holder.iv_image_offer);



            appDatabase= Room.databaseBuilder(context, AppDatabase.class,"offerdp").fallbackToDestructiveMigration().allowMainThreadQueries().build();

            holder.iv_star_offer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Offer==false){


                        holder.iv_star_offer.setImageResource(R.drawable.ic_favorite_true);

                        String country = listName.get(a);
                        String images = listImg.get(a);
                        String hotelName  = listName.get(a);
                        String price=listprice.get(a);
                        String city=listcity.get(a);

                        RoomCartModel roomCartModel=new RoomCartModel(country,images,hotelName,price,city);

                        appDatabase.cartDao().addoffer(roomCartModel);
                        Toast.makeText(context, "Hotel Add To Favorite", Toast.LENGTH_SHORT).show();
                        Offer =true;

                    }else {

                        appDatabase.cartDao().deletAll();
                        holder.iv_star_offer.setImageResource(R.drawable.ic_favorite_false);
                        Offer =false;

                    }

                }
            });


        }else {



        }



    }

    @Override
    public int getItemCount() {
        return listName != null ? listName.size() : 0;
    }

    public class Offerviewholder extends RecyclerView.ViewHolder {

        ImageView iv_image_offer,iv_star_offer;
        TextView tv_hotel_offers1,tv_country_offer1,tv_city_offer1,tv_price1;

        public Offerviewholder(@NonNull View itemView) {
            super(itemView);

            iv_image_offer=itemView.findViewById(R.id.iv_image_offer);
            iv_star_offer=itemView.findViewById(R.id.iv_star_offer);


            tv_price1=itemView.findViewById(R.id.tv_price);
            tv_hotel_offers1=itemView.findViewById(R.id.tv_hotel_offers);
            tv_country_offer1=itemView.findViewById(R.id.tv_country_offer);
            tv_city_offer1=itemView.findViewById(R.id.tv_city_offer);


        }
    }
}
