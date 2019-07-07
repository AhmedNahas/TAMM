package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.Hotel_Room;
import com.Tamm.Hotels.wcf.RoomInformation;
import com.bumptech.glide.Glide;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.ConfirmBookingRoom;

import java.util.List;


public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.ViewHolder> {

    private final Context context;
    private final Hotel_Room hotel_room;
    private final ArrayOfRequestedRooms arrayOfRooms;
    private final String date1;
    private final String date2;
    private final int noOfRooms;
    private final int resultIndex;
    private final String mHOtelCode;
    private final AuthenticationData authenticandata;
    private final String sessionId;
    private List<Hotel_Room> rooms;
    RoomInformation roomInformation;


    public RoomsAdapter(List<Hotel_Room> rooms, Hotel_Room hotel_room, ArrayOfRequestedRooms arrayOfRooms,
                        String date1, String date2, int noOfRooms, int resultIndex, String mHotelCode, AuthenticationData authenticationData, String sessionId, Context context) {
        this.rooms = rooms;
        this.hotel_room = hotel_room;
        this.arrayOfRooms = arrayOfRooms;
        this.date1 = date1;
        this.date2 = date2;
        this.noOfRooms = noOfRooms;
        this.resultIndex = resultIndex;
        this.mHOtelCode = mHotelCode;
        this.authenticandata = authenticationData;
        this.sessionId = sessionId;
        this.context = context;
        this.roomInformation = hotel_room.RoomAdditionalInfo;
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
        holder.mName.setText(roomType);

        //image
        if (roomInformation != null) {
            List<String> images = roomInformation.ImageURLs;
        }

        holder.mName.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ConfirmBookingRoom.class);
//                intent.putExtra("arrayOfRooms", new Gson().toJson(arrayOfRooms));
//                intent.putExtra("rooms", new Gson().toJson(rooms));
//                intent.putExtra("hotel_room", new Gson().toJson(hotel_room));
                intent.putExtra("sessionId", sessionId);
                intent.putExtra("noOfRooms", noOfRooms);
                intent.putExtra("resultIndex", resultIndex);
                intent.putExtra("date1", date1);
                intent.putExtra("date2", date2);
                intent.putExtra("mHOtelCode", mHOtelCode);
//                intent.putExtra("authenticandata", new Gson().toJson(authenticandata));
                intent.putExtra("roomIndex", position);
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
        public TextView mName;
        public ImageView img_photo_hotel ;


        public ViewHolder(View linearLayout) {
            super(linearLayout);

            this.mName = linearLayout.findViewById(R.id.nametext);
            this.img_photo_hotel = linearLayout.findViewById(R.id.img_photo_hotel);


        }
    }


}
