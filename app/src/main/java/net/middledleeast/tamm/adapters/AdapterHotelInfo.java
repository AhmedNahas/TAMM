package net.middledleeast.tamm.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.HotelDetails;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.Collections;

public class AdapterHotelInfo  extends RecyclerView.Adapter<AdapterHotelInfo.SingleView>{

    ArrayList<String> listnameHotel;
    ArrayList<Integer> listrat;
    ArrayList<String> listPhotoHotel;
    ArrayList<String> listAddressHotel;
    ArrayList<String> listCodeHotels;
    ArrayList<String> listprice;
    Context context  ;
    String sessionId;
    private String mendTime;
    private String mstartTime;
    private onHotelListener onHotelListener;
    private String countryName;
    private String cityName;

    private String cityId;
    private int noOfRooms;
    private ArrayList<String> roomGuests;
    private ArrayList<Integer> resultINdex;
    Activity activity;
    String mHotelCode;
    String name;
    String photos;
    int rat;


    public AdapterHotelInfo(Activity activity, ArrayList<String> listnameHotel, ArrayList<Integer> hotelrat, ArrayList<String> listPhotoHotel,
                            Context context, onHotelListener onHotelListener, ArrayList<String> listAddressHotel, ArrayList<String> hotelCode,
                            String sessionId, String mstartTime, String mendTime, String countryName, String cityName, String cityId,
                            int noOfRooms, ArrayList<String> roomGuests, ArrayList<Integer> resultINdex , ArrayList<String> listprice) {
        this.listnameHotel = listnameHotel;
        this.listPhotoHotel = listPhotoHotel;
        this.listrat = hotelrat;
        this.context = context;
        this.onHotelListener = onHotelListener;
        this.listAddressHotel = listAddressHotel;
        this.listCodeHotels = hotelCode;
        this.sessionId = sessionId;
        this.mstartTime = mstartTime;
        this.mendTime = mendTime;
        this.countryName = countryName;
        this.cityName = cityName;
        this.cityId = cityId;
        this.noOfRooms = noOfRooms;
        this.roomGuests = roomGuests;
        this.resultINdex = resultINdex;
        this.activity = activity;
        this.listprice = listprice;

        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public AdapterHotelInfo.SingleView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotels_row, parent, false);
        return new AdapterHotelInfo.SingleView(view, onHotelListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterHotelInfo.SingleView holder, int position) {

        if (position == 0){
            holder.recommended.setVisibility(View.VISIBLE);
        }else{
            holder.recommended.setVisibility(View.GONE);

        }

        mHotelCode = listCodeHotels.get(position);
        name = listnameHotel.get(position);
        photos = listPhotoHotel.get(position);
        rat = listrat.get(position);

        holder.name.setText(name);
        holder.rat.setText(rat+"");


        Collections.sort(listrat);
        Collections.reverse(listrat);
       String price = listprice.get(position);
       holder.hotelPrice.setText(price);
        Glide.with(context).load(photos).into(holder.photoHotel);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HotelDetails.class);
                mHotelCode = listCodeHotels.get(position);
                name = listnameHotel.get(position);
                photos = listPhotoHotel.get(position);
                rat = listrat.get(position);
                SharedPreferencesManger.SaveData(activity, "hotel_name", name);
//                intent.putExtra("selected_hotel_image",photos);
                intent.putExtra("selected_hotel_name", name);
                intent.putExtra("selected_hotel_rate", rat);
                intent.putExtra("hotelCode", mHotelCode);
                intent.putExtra("checkInDate", mstartTime);
                intent.putExtra("checkOutDate", mendTime);
                intent.putExtra("countryName", countryName);
//                SharedPreferencesManger.SaveData(activity,"cityName",cityName);


                intent.putExtra("cityName", cityName);
                intent.putExtra("cityId", cityId);
                intent.putExtra("noOfRooms", noOfRooms);
                intent.putExtra("roomGuest", roomGuests);
               // intent.putExtra("sessionId", sessionId);
                intent.putExtra("resultIndex", resultINdex.get(position));

                context.startActivity(intent);

                SharedPreferencesManger.SaveData(activity,"mHotel_code", mHotelCode);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listnameHotel.size();
    }

    public interface onHotelListener {
        void onHotelClick(int position);

    }

    public class SingleView extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, rat , hotelPrice,recommended ;
        ImageView photoHotel ;
        onHotelListener onHotelListener;
        RelativeLayout parentLayout;

        public SingleView(@NonNull View itemView, onHotelListener onHotelListener) {
            super(itemView);
            name = itemView.findViewById(R.id.hotel_name);
            rat = itemView.findViewById(R.id.shape_rat);
            photoHotel = itemView.findViewById(R.id.hotel_image);
            parentLayout = itemView.findViewById(R.id.linear);
            hotelPrice = itemView.findViewById(R.id.hotel_pric);
            recommended = itemView.findViewById(R.id.recommended);
            this.onHotelListener = onHotelListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onHotelListener.onHotelClick(getAdapterPosition());

        }
    }
}

