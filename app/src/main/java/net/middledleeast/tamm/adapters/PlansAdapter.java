package net.middledleeast.tamm.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.fragments.FreeAccount;
import net.middledleeast.tamm.fragments.MemberShip;
import net.middledleeast.tamm.helper.SharedPreferencesManger;
import net.middledleeast.tamm.model.Freeuser;
import net.middledleeast.tamm.model.PlanModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class PlansAdapter extends RecyclerView.Adapter<PlansAdapter.PlansViewHolder>  {

    private Context context;
    Activity activity ;
    private List<PlanModel> planModelList;
    private int row_index = -1;
    private String HI = "http://egyptgoogle.com/backend/freeamountformember/freememberfees.php";
    private String HI2 = "http://egyptgoogle.com/backend/amountformember/amountformember.php";

    public PlansAdapter(Context context, List<PlanModel> planModelList) {
        this.context = context;
        this.planModelList = planModelList;
        this.activity = activity;
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







        if (i==0){

            plansViewHolder.imgBackground.setImageDrawable(context.getDrawable(R.drawable.plans_card_colored_background));
            plansViewHolder.imgLogo.setImageDrawable(context.getDrawable(R.drawable.logo_black));
            plansViewHolder.txtTitle.setTextColor(Color.BLACK);
            plansViewHolder.txtDescription.setTextColor(Color.BLACK);

        }else {


            plansViewHolder.imgBackground.setImageDrawable(context.getDrawable(R.drawable.plans_card_black_background));
            plansViewHolder.imgLogo.setImageDrawable(context.getDrawable(R.drawable.logo_colored));
            plansViewHolder.txtTitle.setTextColor(context.getResources().getColor(R.color.app_color));
            plansViewHolder.txtDescription.setTextColor(Color.WHITE);
        }



        plansViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

if(i==0)
{

//getmember();



    ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
            .replace(R.id.welcome_container, new MemberShip())
            .commit();
}
else
{


//    getFree();

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

//        plansViewHolder.itemView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN){
//                    plansViewHolder.imgBackground.setImageDrawable(context.getDrawable(R.drawable.plans_card_colored_background));
//                    plansViewHolder.imgLogo.setImageDrawable(context.getDrawable(R.drawable.logo_black));
//                    plansViewHolder.txtTitle.setTextColor(Color.BLACK);
//                    plansViewHolder.txtDescription.setTextColor(Color.BLACK);
//                }else if (event.getAction() == MotionEvent.ACTION_UP){
//                    plansViewHolder.imgBackground.setImageDrawable(context.getDrawable(R.drawable.plans_card_black_background));
//                    plansViewHolder.imgLogo.setImageDrawable(context.getDrawable(R.drawable.logo_colored));
//                    plansViewHolder.txtTitle.setTextColor(context.getResources().getColor(R.color.app_color));
//                    plansViewHolder.txtDescription.setTextColor(Color.WHITE);
//                }
//                return false;
//            }
//        });

    }

//    private void getmember() {
//
//        StringRequest stringRequest=new StringRequest(Request.Method.GET, HI2, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonObject=new JSONObject(response);
//                    JSONArray array=jsonObject.getJSONArray("amountformember");
//                    for (int i=0; i<1; i++ ){
//                        JSONObject ob=array.getJSONObject(i);
//                        String msgbody = ob.getString("Msgbody");
//
//
//
//                        SharedPreferencesManger.SaveData(activity,"fees",msgbody);
//
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                Toast.makeText(context, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        RequestQueue requestQueue= Volley.newRequestQueue(context);
//        requestQueue.add(stringRequest);
//
//    }

//    private void getFree() {
//
//        StringRequest stringRequest=new StringRequest(Request.Method.GET, HI, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonObject=new JSONObject(response);
//                    JSONArray array=jsonObject.getJSONArray("freeamountformember");
//                    for (int i=0; i<1; i++ ){
//                        JSONObject ob=array.getJSONObject(i);
//                         String msgbody = ob.getString("Msgbody");
//
//
//
//                        SharedPreferencesManger.SaveData(activity,"fees",msgbody);
//
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                Toast.makeText(context, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        RequestQueue requestQueue= Volley.newRequestQueue(context);
//        requestQueue.add(stringRequest);
//    }

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
