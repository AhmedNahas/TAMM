package net.middledleeast.tamm.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
import com.Tamm.Hotels.wcf.ArrayOfSuppInfo;
import com.Tamm.Hotels.wcf.ArrayOfSupplement;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.BasicHttpBinding_IHotelService1;
import com.Tamm.Hotels.wcf.CancelPolicies;
import com.Tamm.Hotels.wcf.Enums;
import com.Tamm.Hotels.wcf.HotelRoomAvailabilityResponse;
import com.Tamm.Hotels.wcf.Hotel_Room;
import com.Tamm.Hotels.wcf.Rate;
import com.Tamm.Hotels.wcf.RequestedRooms;
import com.Tamm.Hotels.wcf.RoomInformation;
import com.Tamm.Hotels.wcf.SuppInfo;
import com.Tamm.Hotels.wcf.Supplement;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.checkroom;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.List;


public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.ViewHolder> {

    private final Context context;
    Activity activity ;
    private Hotel_Room hotel_room;
    private final String date1;
    private final String date2;
    private final int noOfRooms;
    private final int resultIndex;
    private final String mHOtelCode;
    private final AuthenticationData authenticandata;
    private final String sessionId;
    private List<Hotel_Room> rooms;
    RoomInformation roomInformation;
    private String roomInstructions;
    private String description;
    HotelRoomAvailabilityResponse response;
    BasicHttpBinding_IHotelService1 service;
    AuthenticationData authenticationData;


    public RoomsAdapter(Activity activity, AuthenticationData data, BasicHttpBinding_IHotelService1 service, HotelRoomAvailabilityResponse response, List<Hotel_Room> rooms, Hotel_Room hotel_room,
                        String date1, String date2, int noOfRooms, int resultIndex, String mHotelCode, AuthenticationData authenticationData, String sessionId, Context context) {
        this.rooms = rooms;
        this.hotel_room = hotel_room;
        this.date1 = date1;
        this.date2 = date2;
        this.noOfRooms = noOfRooms;
        this.resultIndex = resultIndex;
        this.mHOtelCode = mHotelCode;
        this.authenticandata = authenticationData;
        this.sessionId = sessionId;
        this.context = context;
        this.roomInformation = hotel_room.RoomAdditionalInfo;
        this.response = response;
        this.service = service;
        this.authenticationData = data;
        this.activity = activity;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder;
        View linearLayout = LayoutInflater.from(context)
                .inflate(R.layout.rooms_row, parent, false);
        holder = new ViewHolder(linearLayout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String roomType = rooms.get(position).RoomTypeName;
        hotel_room = rooms.get(position);
//        Hotel_Room hotel_room1 = rooms.get(1);
        String mealType = rooms.get(position).MealType;
        String instructions = rooms.get(position).RoomInstructions;
        String amneties = rooms.get(position).Amenities;
        String essentialInfo = rooms.get(position).RoomEssentialInfo;
        String currency = rooms.get(position).RoomRate.Currency;
        CancelPolicies cancelPolicies = rooms.get(position).CancelPolicies;
        if (cancelPolicies != null) {
            DateTime deadLine = cancelPolicies.LastCancellationDeadline;
        }
        String roomPromotion = rooms.get(position).RoomPromtion;
        BigDecimal roomprice = rooms.get(position).RoomRate.TotalFare;
        holder.roomPrice.setText(currency + " " + roomprice);

        roomInformation = rooms.get(position).RoomAdditionalInfo;
//        BigDecimal price = rooms.get(position).Supplements.get(position).Price;
        holder.mName.setText(roomType);
//        holder.roomPrice.setText((CharSequence) price);

        ArrayOfSupplement arrayOfSupplement = rooms.get(position).Supplements;
        Gson gson = new Gson();
        String arrayOfsupString = gson.toJson(arrayOfSupplement);
        SharedPreferencesManger.SaveData((Activity) context, "suppArray", arrayOfsupString);
        if (arrayOfSupplement != null) {
            for (Supplement supplement : arrayOfSupplement) {
                boolean requiredSupplement = supplement.SuppIsMandatory;

            }
        }
        //image
        if (roomInformation != null) {
            List<String> images = rooms.get(position).RoomAdditionalInfo.ImageURLs;
            Glide.with(context).load(images).into(holder.img_photo_hotel);
            roomInstructions = rooms.get(position).MealType;
            description = rooms.get(position).RoomAdditionalInfo.Description;
        }


        holder.roomBooken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, checkroom.class);
//                intent.putExtra("arrayOfRooms", new Gson().toJson(arrayOfRooms));
//                intent.putExtra("rooms", new Gson().toJson(rooms));
//                intent.putExtra("hotel_room(xxhdpi)", new Gson().toJson(hotel_room(xxhdpi)));
                intent.putExtra("sessionId", sessionId);
                intent.putExtra("noOfRooms", noOfRooms);
                intent.putExtra("resultIndex", resultIndex);
                intent.putExtra("date1", date1);
                intent.putExtra("date2", date2);
                intent.putExtra("mHOtelCode", mHOtelCode);
//                intent.putExtra("authenticandata", new Gson().toJson(authenticandata));
                intent.putExtra("roomIndex", position + 1);
                intent.putExtra("smok", roomInstructions);
                intent.putExtra("roomTybe", roomType);
                intent.putExtra("description", description);
                intent.putExtra("mealTybe", mealType);
                intent.putExtra("roomPrice", roomprice.toString());
                intent.putExtra("currency", currency);
                SharedPreferencesManger.SaveData(activity,"currency",currency);
                SharedPreferencesManger.SaveData(activity,"roomPrice", roomprice.toString());
                SharedPreferencesManger.SaveData(activity, "roomIndex", position);


                ArrayOfRequestedRooms arrayOfRooms = new ArrayOfRequestedRooms();
                RequestedRooms requestedRooms = new RequestedRooms();
                requestedRooms.RatePlanCode = hotel_room.RatePlanCode;
                requestedRooms.RoomIndex = hotel_room.RoomIndex;
                requestedRooms.RoomRate = new Rate();
                if (hotel_room.Supplements != null) {
                    requestedRooms.Supplements = new ArrayOfSuppInfo();
                    for (Supplement supplement : hotel_room.Supplements) {
                        SuppInfo suppInfo = new SuppInfo();
                        suppInfo.SuppChargeType = Enums.SuppChargeType.valueOf(supplement.SuppChargeType.name());
                        suppInfo.Price = supplement.Price;
                        if (supplement.SuppIsMandatory) {
                            suppInfo.SuppIsSelected = true;

                        }
                        requestedRooms.Supplements.add(suppInfo);
                    }
                }
                requestedRooms.RoomRate.RoomFare = hotel_room.RoomRate.RoomFare;
                requestedRooms.RoomRate.RoomTax = hotel_room.RoomRate.RoomTax;
                requestedRooms.RoomRate.TotalFare = hotel_room.RoomRate.TotalFare;
                requestedRooms.RoomTypeCode = hotel_room.RoomTypeCode;
                arrayOfRooms.add(requestedRooms);
                RequestedRooms requestedRooms1 = new RequestedRooms();
//                requestedRooms1.RatePlanCode = hotel_room1.RatePlanCode;
//                // TODO: 22/07/19 temp fox
//                requestedRooms1.RoomIndex = hotel_room1.RoomIndex;
//                requestedRooms1.RoomRate = new Rate();
//                if (hotel_room1.Supplements != null) {
//                    requestedRooms1.Supplements = new ArrayOfSuppInfo();
//                    for (Supplement supplement : hotel_room1.Supplements) {
//                        SuppInfo suppInfo = new SuppInfo();
//                        suppInfo.SuppChargeType = Enums.SuppChargeType.valueOf(supplement.SuppChargeType.name());
//                        suppInfo.Price = supplement.Price;
//                        if (supplement.SuppIsMandatory) {
//                            suppInfo.SuppIsSelected = true;
//
//                        }
//                        requestedRooms1.Supplements.add(suppInfo);
//                    }
//                }
//                requestedRooms1.RoomRate.RoomFare = hotel_room1.RoomRate.RoomFare;
//                requestedRooms1.RoomRate.RoomTax = hotel_room1.RoomRate.RoomTax;
//                requestedRooms1.RoomRate.TotalFare = hotel_room1.RoomRate.TotalFare;
//                requestedRooms1.RoomTypeCode = hotel_room1.RoomTypeCode;
//                arrayOfRooms.add(requestedRooms1);
                String requestedRoomsString = gson.toJson(arrayOfRooms);
                SharedPreferencesManger.SaveData((Activity) context, "arrayOfroomsreq", requestedRoomsString);



                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mName, roomPrice;
        public ImageView img_photo_hotel;
        public Button roomBooken;


        public ViewHolder(View linearLayout) {
            super(linearLayout);

            this.mName = linearLayout.findViewById(R.id.nametext_room);
            this.img_photo_hotel = linearLayout.findViewById(R.id.room_image);
            this.roomPrice = linearLayout.findViewById(R.id.room_price);
            this.roomBooken = linearLayout.findViewById(R.id.room_booking_btn);


        }
    }


}
