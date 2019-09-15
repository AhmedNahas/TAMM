package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.model.Room.RoomCartModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyTripsAdapter extends RecyclerView.Adapter<MyTripsAdapter.BookedViewHolder> {

    Context context;
    List<RoomCartModel> allData;

    public MyTripsAdapter(Context context, List<RoomCartModel> allData) {
        this.context = context;
        this.allData = allData;

    }


    @NonNull
    @Override


    public BookedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_trips, parent, false);

        return new BookedViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull BookedViewHolder holder, int position) {


        RoomCartModel data = allData.get(position);


        String namePassenger = data.getNamePassenger();
        String from = data.getFrom();
        String to = data.getTo();
        String flightNo = data.getFlightNo();
        String date = data.getDate();
        String seat = data.getSeat();
        String time = data.getTime();
        String ticketNo = data.getTicketNo();

        holder.NamePassenger.setText(namePassenger);
        holder.From.setText(from);
        holder.To.setText(to);
        holder.FlightNo.setText(flightNo);
        holder.Date.setText(date);
        holder.SEAT.setText(seat);
        holder.Time.setText(time);
        holder.TicketNo.setText(ticketNo);





    }

    @Override
    public int getItemCount() {

        return allData.size();
    }

    public class BookedViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.NamePassenger)
        TextView NamePassenger;
        @BindView(R.id.From)
        TextView From;
        @BindView(R.id.To)
        TextView To;
        @BindView(R.id.FlightNo)
        TextView FlightNo;
        @BindView(R.id.Date)
        TextView Date;
        @BindView(R.id.Gate)
        TextView Gate;
        @BindView(R.id.Hours)
        TextView Time;
        @BindView(R.id.SEAT)
        TextView SEAT;
        @BindView(R.id.TicketNo)
        TextView TicketNo;



        public BookedViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }


}
