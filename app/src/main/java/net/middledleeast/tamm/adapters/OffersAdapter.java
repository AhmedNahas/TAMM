package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.Offerviewholder> {
    Context context;
int id ;

    public OffersAdapter(Context context,int id) {
        this.context = context;
        this.id=id;
    }

    @NonNull
    @Override
    public Offerviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offers_raw,parent,false);
        return new Offerviewholder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull Offerviewholder holder, int position) {

        if (id==1){

                 holder.txtview1.setText("Huwai Pharmacy");
                 holder.txtview2.setText("gjsafdjsafdaskliyuyrfhshjf");
                 holder.txtview3.setText("+95684712356");

        }else {

            holder.txtview1.setText("Huwai Pharmacy");
            holder.txtview2.setText("gjsafdjsafdaskliyuyr123456");
            holder.txtview3.setText("+95684712356");


        }




    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class Offerviewholder extends RecyclerView.ViewHolder {

        ImageView imageView1,imageView2;
        TextView txtview1,txtview2,txtview3;

        public Offerviewholder(@NonNull View itemView) {
            super(itemView);
            imageView1=itemView.findViewById(R.id.iv_star_offer);
            imageView2=itemView.findViewById(R.id.iv_image_offer);

            txtview1=itemView.findViewById(R.id.tv_one_offers);
            txtview2=itemView.findViewById(R.id.tv_address);
            txtview3=itemView.findViewById(R.id.tv_phone_offer);


        }
    }
}
