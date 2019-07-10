package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.FreeAccount;
import net.middledleeast.tamm.activities.MemberShip;
import net.middledleeast.tamm.fragments.PlansFragment;
import net.middledleeast.tamm.model.PlanModel;

import java.util.List;

public class PlansAdapter extends RecyclerView.Adapter<PlansAdapter.PlansViewHolder>  {

    private Context context;
    private List<PlanModel> planModelList;
    private int row_index = -1;

    public PlansAdapter(Context context, List<PlanModel> planModelList) {
        this.context = context;
        this.planModelList = planModelList;
    }

    @NonNull
    @Override
    public PlansViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.row_plan, viewGroup, false);

        return new PlansViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PlansViewHolder plansViewHolder, final int i) {

        plansViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

if(i==0)
{
    ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
            .replace(R.id.welcome_container, new MemberShip())
            .commit();
}
else
{
    ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
            .replace(R.id.welcome_container, new FreeAccount())
            .commit();
}
                //todo check
//                row_index = i;
//                notifyDataSetChanged();

            }
        });



        plansViewHolder.txtTitle.setText(planModelList.get(i).getTitle());
        if (TextUtils.isEmpty(planModelList.get(i).getDescription())){

        }else {
            plansViewHolder.txtDescription.setText(planModelList.get(i).getDescription());
        }

        plansViewHolder.itemView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    plansViewHolder.imgBackground.setImageDrawable(context.getDrawable(R.drawable.plans_card_colored_background));
                    plansViewHolder.imgLogo.setImageDrawable(context.getDrawable(R.drawable.logo_black));
                    plansViewHolder.txtTitle.setTextColor(Color.BLACK);
                    plansViewHolder.txtDescription.setTextColor(Color.BLACK);
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    plansViewHolder.imgBackground.setImageDrawable(context.getDrawable(R.drawable.plans_card_black_background));
                    plansViewHolder.imgLogo.setImageDrawable(context.getDrawable(R.drawable.logo_colored));
                    plansViewHolder.txtTitle.setTextColor(context.getResources().getColor(R.color.app_color));
                    plansViewHolder.txtDescription.setTextColor(Color.WHITE);
                }
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return planModelList.size();
    }

    public class PlansViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgBackground, imgLogo;
        private TextView txtTitle, txtDescription;
        public PlansViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBackground = itemView.findViewById(R.id.plan_background);
            imgLogo = itemView.findViewById(R.id.plan_logo);
            txtTitle = itemView.findViewById(R.id.plan_title);
            txtDescription = itemView.findViewById(R.id.plan_details);
        }
    }
}
