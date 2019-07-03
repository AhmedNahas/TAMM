package net.middledleeast.tamm.adapters;

import android.annotation.SuppressLint;
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

import java.util.ArrayList;
import java.util.List;

public class AdapterHotelInfo  extends RecyclerView.Adapter<AdapterHotelInfo.SingleView>{

    ArrayList<String> listnameHotel;
    ArrayList<String> listAddressHotel;
    ArrayList<String> listPhotoHotel;
    Context context  ;


    public AdapterHotelInfo(ArrayList<String> listnameHotel , ArrayList<String> listAddressHotel , ArrayList<String> listPhotoHotel  , Context context) {
        this.listnameHotel = listnameHotel;
        this.listAddressHotel =  listAddressHotel ;
        this.listPhotoHotel = listPhotoHotel;
        this.context = context;

    }

    @NonNull
    @Override
    public AdapterHotelInfo.SingleView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info_hotel,parent,false);
        return new AdapterHotelInfo.SingleView(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterHotelInfo.SingleView holder, int position) {

        String name = listnameHotel.get(position);
        String photos = listPhotoHotel.get(position);
        String address = listAddressHotel.get(position);
        holder.nameHotel.setText(name);
        holder.addressHotel.setText(address);

    Glide.with(context).load(photos).into(holder.photoHotel);

    }

    @Override
    public int getItemCount() {
        return listnameHotel.size();
    }

    public class SingleView extends RecyclerView.ViewHolder{

        TextView nameHotel , addressHotel ;
        ImageView photoHotel ;

        public SingleView(@NonNull View itemView) {
            super(itemView);
            nameHotel = itemView.findViewById(R.id.tv_hotel_name);
            addressHotel = itemView.findViewById(R.id.tv_hotel_address);
            photoHotel = itemView.findViewById(R.id.img_photo_hotel);
        }
    }
}
