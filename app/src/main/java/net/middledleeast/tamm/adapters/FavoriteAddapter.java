package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.model.Room.RoomCartModel;

import java.util.List;

public class FavoriteAddapter extends RecyclerView.Adapter<FavoriteAddapter.FavoriteViewholder> {


    Context context;

List<RoomCartModel> roomCartModels ;


    public FavoriteAddapter(List<RoomCartModel> allData, Context context) {
        this.context =context;
        this.roomCartModels =allData;

    }

    @NonNull
    @Override
    public FavoriteViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offers_raw,parent,false);
        return new FavoriteViewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewholder holder, int position) {


//        RoomCartModel roomCartModel=new RoomCartModel();
//

        final RoomCartModel roomCartModel = roomCartModels.get(position);

        final String image = roomCartModel.getImage();
        final String name = roomCartModel.getName();
        final String namehotel = roomCartModel.getNamehotel();

        holder.txtview1.setText(namehotel);
        holder.txtview2.setText(name);
        Glide.with(context).load(image).into(holder.imageView2);



    }

    @Override
    public int getItemCount() {
        return roomCartModels.size();
    }

    public class FavoriteViewholder extends RecyclerView.ViewHolder {

        ImageView imageView1,imageView2;
        TextView txtview1,txtview2,txtview3;

        public FavoriteViewholder(@NonNull View itemView) {
            super(itemView);

            imageView1=itemView.findViewById(R.id.iv_star_offer);
            imageView2=itemView.findViewById(R.id.iv_image_offer);


            txtview1=itemView.findViewById(R.id.tv_one_offers);
            txtview2=itemView.findViewById(R.id.tv_address);
            txtview3=itemView.findViewById(R.id.tv_phone_offer);

        }
    }
}
