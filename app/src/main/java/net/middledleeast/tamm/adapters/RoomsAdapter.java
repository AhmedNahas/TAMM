package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Tamm.Hotels.wcf.ArrayOfRequestedRooms;
import com.Tamm.Hotels.wcf.ArrayOfString;
import com.Tamm.Hotels.wcf.ArrayOfString5;
import com.Tamm.Hotels.wcf.AuthenticationData;
import com.Tamm.Hotels.wcf.HotelDetailsResponse;
import com.Tamm.Hotels.wcf.Hotel_Room;
import com.Tamm.Hotels.wcf.RoomInformation;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.Request;
import com.google.gson.Gson;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.ConfirmBookingRoom;

import java.util.List;


public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.ViewHolder> {

    private final Context context;
//    private final Hotel_Room hotel_room;
//    private final ArrayOfRequestedRooms arrayOfRooms;
//    private final String date1;
//    private final String date2;
//    private final int noOfRooms;
//    private final int resultIndex;
//    private final String mHOtelCode;
//    private final AuthenticationData authenticandata;
//    private final String sessionId;
    private List<Hotel_Room> rooms;




    public RoomsAdapter(List<Hotel_Room> rooms, Context context) {
        this.rooms = rooms;
//        this.hotel_room = hotel_room;
//        this.arrayOfRooms = arrayOfRooms;
//        this.date1 = date1;
//        this.date2 = date2;
//        this.noOfRooms = noOfRooms;
//        this.resultIndex = resultIndex;
//        this.mHOtelCode = mHotelCode;
//        this.authenticandata = authenticationData;
//        this.sessionId = sessionId;
        this.context = context;

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
        Hotel_Room hotel_room = rooms.get(position);

        String photo = hotel_room.RoomAdditionalInfo.ImageURLs.get(position);
        Glide.with(context).load(photo).into(holder.roomImg);


        String roomTypeName = hotel_room.RoomTypeName;
//        String roomP = rooms.get(position).RoomPromtion;
//       String photo = rooms.get(position).RoomAdditionalInfo.ImageURLs.get(0);
        holder.mName.setText(roomTypeName);
//

        holder.mName.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, ConfirmBookingRoom.class);
//                intent.putExtra("arrayOfRooms", new Gson().toJson(arrayOfRooms));
//                intent.putExtra("rooms", new Gson().toJson(rooms));
//                intent.putExtra("hotel_room", new Gson().toJson(hotel_room));
//                intent.putExtra("sessionId", sessionId);
//                intent.putExtra("noOfRooms", noOfRooms);
//                intent.putExtra("resultIndex", resultIndex);
//                intent.putExtra("date1", date1);
//                intent.putExtra("date2", date2);
//                intent.putExtra("mHOtelCode", mHOtelCode);
//                intent.putExtra("authenticandata", new Gson().toJson(authenticandata));
//                intent.putExtra("roomIndex", position);
                //context.startActivity(intent);
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
        public TextView mName , roomPrice;
        public ImageView roomImg;


        public ViewHolder(View linearLayout) {
            super(linearLayout);

            this.mName = linearLayout.findViewById(R.id.nametext);
          this.roomImg = linearLayout.findViewById(R.id.room_image);

        }
    }


}
