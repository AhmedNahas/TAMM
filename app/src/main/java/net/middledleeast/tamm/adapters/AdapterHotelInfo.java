package net.middledleeast.tamm.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.HotelDetails;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.Collections;

public class AdapterHotelInfo  extends RecyclerView.Adapter<AdapterHotelInfo.SingleView>{

    ArrayList<String> listnameHotel;
    ArrayList<String> advisorURLList;
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
    private String feesFree;
    private String feesMember;
    private Integer accountPlan;


    public AdapterHotelInfo(Activity activity, ArrayList<String> listnameHotel, ArrayList<Integer> hotelrat, ArrayList<String> listPhotoHotel,
                            Context context, onHotelListener onHotelListener, ArrayList<String> listAddressHotel, ArrayList<String> hotelCode,
                            String sessionId, String mstartTime, String mendTime, String countryName, String cityName, String cityId,
                            int noOfRooms, ArrayList<String> roomGuests, ArrayList<Integer> resultINdex , ArrayList<String> listprice,ArrayList<String> advisorURLList) {
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
        this.advisorURLList = advisorURLList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public AdapterHotelInfo.SingleView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotels_row, parent, false);
        return new AdapterHotelInfo.SingleView(view, onHotelListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterHotelInfo.SingleView holder, int position) {




        feesFree = SharedPreferencesManger.LoadStringData(context, "feesFree");
        feesMember = SharedPreferencesManger.LoadStringData(context, "feesMember");
        accountPlan = SharedPreferencesManger.LoadIntegerData(context, "accountPlan");
       String gustMode = SharedPreferencesManger.LoadStringData(context, "guestMode");



        String price = listprice.get(position);

        if (gustMode!=null){

            holder.hotelPrice.setText(price);

        }else {
            try {


                String[] prisparts = price.split(" ");
                String prispart2 = prisparts[1];
                String usd = prisparts[0];

                if (accountPlan == 1){

                    double price_ = Double.parseDouble(prispart2);
                    double price_1 = Double.parseDouble(feesFree);
//            SharedPreferencesManger.SaveData(context,"feesFreeForEachRoom", String.valueOf(price_1));


                    double sum = Double.sum(price_1, price_);
                    holder.hotelPrice.setText(usd+sum);

                }else if (accountPlan == 0){

                    double price_ = Double.parseDouble(prispart2);
                    double price_1 = Double.parseDouble(feesMember);
//            SharedPreferencesManger.SaveData(context,"feesMemberForEachRoom", String.valueOf(price_1));


                    double sum = Double.sum(price_1, price_);
                    holder.hotelPrice.setText(usd+sum);

                }else if (accountPlan == 2){

                    double price_ = Double.parseDouble(prispart2);
                    double price_1 = Double.parseDouble("500");
////            SharedPreferencesManger.SaveData(context,"feesFreeForEachRoom", String.valueOf(price_1));


                    double sum = Double.sum(price_1, price_);
                    holder.hotelPrice.setText(usd+sum);

                }
            }catch (Exception e){

            }

        }


        if (position == 0){
            holder.recommended.setVisibility(View.VISIBLE);
        }else{
            holder.recommended.setVisibility(View.GONE);

        }

        mHotelCode = listCodeHotels.get(position);
        name = listnameHotel.get(position);
        final String advisorURL = advisorURLList.get(position);
        photos = listPhotoHotel.get(position);
        rat = listrat.get(position);

        holder.name.setText(name);
        holder.rat.setText(rat+"");
        holder.URLTripAdvisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                if (advisorURL!= null) {
                    i.setData(Uri.parse(advisorURL));
                    context.startActivity(i);
                }else {
                    Toast.makeText(context, "URL Not Available for this Hotel", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Collections.sort(listrat);
        Collections.reverse(listrat);






        Glide.with(context).load(photos).into(holder.photoHotel);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HotelDetails.class);

                intent.removeExtra("selected_hotel_name");
                intent.removeExtra("selected_hotel_rate");
                intent.removeExtra("hotelCode");
                intent.removeExtra("checkInDate");
                intent.removeExtra("checkOutDate");
                intent.removeExtra("countryName");
                intent.removeExtra("cityName");
                intent.removeExtra("cityId");
                intent.removeExtra("noOfRooms");
                intent.removeExtra("roomGuest");
                intent.removeExtra("resultIndex");
                intent.removeExtra("hotelTripAdvisorURL");

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
        ImageView photoHotel , URLTripAdvisor;
        onHotelListener onHotelListener;
        RelativeLayout parentLayout;

        public SingleView(@NonNull View itemView, onHotelListener onHotelListener) {
            super(itemView);
            name = itemView.findViewById(R.id.hotel_name);
            URLTripAdvisor=itemView.findViewById(R.id.trip_advisor_URL);
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

