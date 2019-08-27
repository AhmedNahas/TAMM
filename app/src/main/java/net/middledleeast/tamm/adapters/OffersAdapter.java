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
    List<String> getListNameHotel;

    public OffersAdapter(Context context,  List<String> listName , List<String> listImg , List<String> getListNameHotel, int id) {
        this.context = context;
        this.id=id;
        this.listName = listName;
        this.listImg = listImg;
        this.getListNameHotel = getListNameHotel;



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

            String country = listName.get(a);
            String images = listImg.get(a);
            String hotelName  = getListNameHotel.get(a);

            holder.txtview1.setText(hotelName);
            holder.txtview2.setText(country);
            Glide.with(context).load(images).into(holder.imageView2);

            appDatabase= Room.databaseBuilder(context, AppDatabase.class,"offerdp").fallbackToDestructiveMigration().allowMainThreadQueries().build();

            holder.iv_star_offer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Offer==false){


                        holder.iv_star_offer.setImageResource(R.drawable.ic_favorite_true);

                        String country = listName.get(a);
                        String images = listImg.get(a);
                        String hotelName  = getListNameHotel.get(a);

                        RoomCartModel roomCartModel=new RoomCartModel(country,images,hotelName);

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

        ImageView imageView1,imageView2,iv_star_offer;

        TextView txtview1,txtview2,txtview3;

        public Offerviewholder(@NonNull View itemView) {
            super(itemView);
            imageView1=itemView.findViewById(R.id.iv_star_offer);
            imageView2=itemView.findViewById(R.id.iv_image_offer);
            iv_star_offer=itemView.findViewById(R.id.iv_star_offer);

            txtview1=itemView.findViewById(R.id.tv_one_offers);
            txtview2=itemView.findViewById(R.id.tv_address);
            txtview3=itemView.findViewById(R.id.tv_phone_offer);


        }
    }
}
