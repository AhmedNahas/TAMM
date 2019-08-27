package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;

public class BookedAdapter extends RecyclerView.Adapter<BookedAdapter.BookedViewHolder> {

    Context context;
    String namehotel;
    String checkin;
    String checkout;
    String Cancellation;

    public BookedAdapter(Context context, String namehotel, String checkin, String checkout, String cancellation) {
        this.context = context;
        this.namehotel = namehotel;
        this.checkin = checkin;
        this.checkout = checkout;
        this.Cancellation = cancellation;
    }

    public BookedAdapter() {

    }

    @NonNull
    @Override



    public BookedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mybook_raw,parent,false);
        return new BookedViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull BookedViewHolder holder, int position) {

        holder.tv_cancellation.setText("30/8/2019");
        holder.tv_name_hotel_booked.setText("Mariot");
        holder.tv_checkin_booked.setText("27/8/2019");
        holder.tv_checkout_booked.setText("1/9/2019");








    }

    @Override
    public int getItemCount() {

        return 10;
    }

    public class BookedViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_image_booked;
        TextView  tv_name_hotel_booked,tv_checkin_booked,tv_checkout_booked,tv_cancellation,tv_checkin_txt,tv_checkout_txt,tv_cancellation_policy;
        Button btn_edit,btn_cancel_booked;

        public BookedViewHolder(@NonNull View itemView) {
            super(itemView);


            iv_image_booked=itemView.findViewById(R.id.iv_image_booked);


            tv_name_hotel_booked=itemView.findViewById(R.id.tv_name_hotel_booked);
            tv_checkin_booked=itemView.findViewById(R.id.tv_checkin_booked);
            tv_checkout_booked=itemView.findViewById(R.id.tv_checkout_booked);
            tv_cancellation=itemView.findViewById(R.id.tv_cancellation);
            tv_checkin_txt=itemView.findViewById(R.id.tv_checkin_txt);
            tv_checkout_txt=itemView.findViewById(R.id.tv_checkout_txt);
            tv_cancellation_policy=itemView.findViewById(R.id.tv_cancellation_policy);


            btn_edit=itemView.findViewById(R.id.btn_edit);
            btn_cancel_booked=itemView.findViewById(R.id.btn_cancel_booked);






        }
    }
}
