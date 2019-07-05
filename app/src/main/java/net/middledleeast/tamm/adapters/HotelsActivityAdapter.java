package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.HotelDetails;
import net.middledleeast.tamm.model.HotelsModel;

import java.util.List;

public class HotelsActivityAdapter extends RecyclerView.Adapter<HotelsActivityAdapter.RecyclerViewHolder> {

    private Context context;
    private List<HotelsModel> models;
    private onHotelListener onHotelListener;

    public HotelsActivityAdapter(Context context, List<HotelsModel> models , onHotelListener onHotelListener) {
        this.context = context;
        this.models = models;
        this.onHotelListener = onHotelListener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotels_row,parent,false);
        return new RecyclerViewHolder(view , onHotelListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position) {

        holder.hotelImage.setImageResource(models.get(position).getHotelImage());
        holder.hotelName.setText(models.get(position).getHotelName());
        holder.hotelDesc.setText(models.get(position).getHotelDesc());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HotelDetails.class);
                intent.putExtra("selected_hotel_image",models.get(position).getHotelImage());
                intent.putExtra("selected_hotel_name",models.get(position).getHotelName());
                intent.putExtra("selected_hotel_desc",models.get(position).getHotelDesc());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView hotelImage;
        private TextView hotelName , hotelDesc;
        onHotelListener onHotelListener;
        LinearLayout parentLayout;
        public RecyclerViewHolder(@NonNull View itemView , onHotelListener onHotelListener) {
            super(itemView);
            hotelImage = itemView.findViewById(R.id.hotel_image_detail);
            hotelName = itemView.findViewById(R.id.hotel_name_detail);
            hotelDesc = itemView.findViewById(R.id.hotel_desc_detail);
            parentLayout = itemView.findViewById(R.id.linear);
            this.onHotelListener = onHotelListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onHotelListener.onHotelClick(getAdapterPosition());

        }
    }
    public interface onHotelListener {
        void onHotelClick(int position);

    }
}
