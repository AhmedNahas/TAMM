package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.model.Room.AppDatabase;
import net.middledleeast.tamm.model.Room.RoomCartModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class MyTripsAdapter extends RecyclerView.Adapter<MyTripsAdapter.BookedViewHolder> {

    Context context;
    List<RoomCartModel> allData;
int jurnyTipe ;

    public MyTripsAdapter(Context context, List<RoomCartModel> allData , int jurnyType ) {
        this.context = context;
        this.allData = allData;

        this.jurnyTipe =jurnyType;
    }


    @NonNull
    @Override


    public BookedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_trips, parent, false);

        return new BookedViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull BookedViewHolder holder, int position) {



         if (holder.FromReturn.getText().toString().equals("")){



             holder.relativeReturnTicket.setVisibility(View.GONE);
         }

        RoomCartModel data = allData.get(position);


        String namePassenger = data.getNamePassenger();
        String from = data.getFrom();
        String to = data.getTo();
        String flightNo = data.getFlightNo();
        String date = data.getDate();
        String time = data.getTime();
        String ticketNo = data.getTicketNo();
        holder.NamePassenger.setText(namePassenger);
        holder.From.setText(from);
        holder.To.setText(to);
        holder.FlightNo.setText(flightNo);
        holder.Date.setText(date);
        holder.Time.setText(time);
        holder.TicketNo.setText(ticketNo);

try {

    String airLineName = "A" +data.getAirLineName();


    String  stringResourceByName = getStringResourceByName(airLineName);
    holder.AirLineName.setText(stringResourceByName);

    String airlineCode = "a" + data.getAirLinePhoto().toLowerCase();


    holder.photoTicket.setImageResource(context.getResources().getIdentifier(airlineCode, "drawable", context.getPackageName()));
    holder.relativeReturnTicket.setVisibility(View.GONE);

}catch (Exception e){


}


        if (jurnyTipe==2){
            holder.relativeReturnTicket.setVisibility(View.VISIBLE);

            String fromReturn = data.getFromReturn();
            String toReturn = data.getToReturn();

            String fLghtNoReturn = data.getFLghtNoReturn();

            String dateReturn = data.getDateReturn();
            String timeReturn = data.getTimeReturn();

            holder.FromReturn.setText(fromReturn);
            holder.ToReturn.setText(toReturn);
            holder.FlightNoReturn.setText(fLghtNoReturn);
            holder.DateReturn.setText(dateReturn);
            holder.HoursReturn.setText(timeReturn);

            String airlineCode = null;
            try {
                airlineCode = "a" + data.getAirLinePhotoReturn().toLowerCase();
                holder.photoTicketReturn.setImageResource(context.getResources().getIdentifier(airlineCode, "drawable", context.getPackageName()));
            } catch (Exception e) {
                e.printStackTrace();
            }


        }else {


            holder.relativeReturnTicket.setVisibility(View.GONE);


        }




        if (position>4){



            AppDatabase appDatabase = Room.databaseBuilder(context, AppDatabase.class, "myTrips").fallbackToDestructiveMigration().allowMainThreadQueries().build();

           appDatabase.cartDao().deletAll();

        }


    }
    private String getStringResourceByName(String aString) {
        String packageName = context.getPackageName();
        int resId = context.getResources().getIdentifier(aString, "string", packageName);
        return context.getString(resId);
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

        @BindView(R.id.Hours)
        TextView Time;

        @BindView(R.id.TicketNo)
        TextView TicketNo;



        @BindView(R.id.from)
        TextView from;

        @BindView(R.id.photo_ticket)
        CircleImageView photoTicket;




        @BindView(R.id.hours)
        TextView hours;

        @BindView(R.id.NamePassenger_Return)
        TextView NamePassengerReturn;
        @BindView(R.id.from_Return)
        TextView fromReturn;
        @BindView(R.id.From_Return)
        TextView FromReturn;
        @BindView(R.id.photo_ticket_Return)
        CircleImageView photoTicketReturn;
        @BindView(R.id.AirLineName)
        TextView AirLineName;
        @BindView(R.id.to_Return)
        TextView toReturn;
        @BindView(R.id.To_Return)
        TextView ToReturn;
        @BindView(R.id.FlightNo_Return)
        TextView FlightNoReturn;
        @BindView(R.id.Date_Return)
        TextView DateReturn;
        @BindView(R.id.hours_Return)
        TextView hoursReturn;
        @BindView(R.id.Hours_Return)
        TextView HoursReturn;

        @BindView(R.id.relative_Return_ticket)
        RelativeLayout relativeReturnTicket;


        public BookedViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }


}
