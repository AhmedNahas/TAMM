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
import net.middledleeast.tamm.model.Users;

import java.util.List;

public class FreeAdapter extends RecyclerView.Adapter<FreeAdapter.Freeviewholder> {
    Context context;
    List<Users> users;

    public FreeAdapter(Context context, List<Users> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public Freeviewholder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_card,viewGroup,false);
        return new Freeviewholder(view);
    }

    @Override
    public void onBindViewHolder( Freeviewholder freeviewholder, int i) {
        final Users users = this.users.get(i);
        final String image = users.getImage();
        freeviewholder.name.setText(this.users.get(i).getName());
        freeviewholder.phone.setText(this.users.get(i).getPhone());


        if (image.matches("")){
            freeviewholder.imageView.setImageResource(R.drawable.logo);
        }else {
            Glide.with(context).load(image).into(freeviewholder.imageView);
        }



    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class Freeviewholder extends RecyclerView.ViewHolder{
        TextView name,phone;
        ImageView imageView;

        public Freeviewholder(@NonNull View itemView) {

            super(itemView);
            name=itemView.findViewById(R.id.plan_name);
            phone=itemView.findViewById(R.id.plan_phone);
            imageView=itemView.findViewById(R.id.user_img);




        }
    }
}
