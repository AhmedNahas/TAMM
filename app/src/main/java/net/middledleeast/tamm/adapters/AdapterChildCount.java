package net.middledleeast.tamm.adapters;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.api.Api;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.activities.FindHotels;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class AdapterChildCount extends RecyclerView.Adapter<AdapterChildCount.SingleView> {


    // list count of spinner children
    List<Integer> listCountCild;


    Activity activity;
    Context context ;

    // list of age 18 no
    private List<Integer> list_age;

    // list to save the age of child
    private List<Integer> list_age_save = new ArrayList<>();

public  static  boolean child_m ;

    public AdapterChildCount(Activity activity, List<Integer> listCountCild, List<Integer> list_age , Context context ) {
        this.listCountCild = listCountCild;
        this.activity = activity;
        this.list_age = list_age;
        this.context = context;

    }

    @NonNull
    @Override
    public SingleView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spiner_childern, parent, false);
        return new SingleView(view);
    }

    @SuppressLint({"SetTextI18n", "CommitPrefEdits"})
    @Override
    public void onBindViewHolder(@NonNull SingleView holder, int position) {


        // list of children count
        int mPosition = listCountCild.get(position);

        //set the list of children count to text
        holder.child_no_tv.setText("children " + mPosition + " age");


        //adapter spinner children age                         set list of age to adapter(list_age)
        ArrayAdapter adapter = new ArrayAdapter(activity, R.layout.item_spener, list_age);
        adapter.setDropDownViewResource(R.layout.drop_dowen);
        holder.spinner_no_Child.setAdapter(adapter);
        holder.spinner_no_Child.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

//                list_age_save.clear();
//                list_age_save.add(list_age.get(i));
//                StringBuilder str = new StringBuilder();
//                for (int k=0;k<listCountCild.size();k++)
//                {
                if(list_age_save.size()==listCountCild.size()) {
                    for (int k=0;k<listCountCild.size();k++) {
                        list_age_save.set(position,list_age.get(i));
//                        str.append(list_age_save.get(position)).append(",");
                    }
                }
                else
                {
                    list_age_save.add(list_age.get(i));
//                    str.append(list_age_save.get(position)).append(",");
                }

//                }
               String str = list_age_save.toString();
              str=  str.replace("[", "");
               str=  str.replace("]", "");
                        SharedPreferencesManger.SaveData(activity, "child_count", str);

                            Toast.makeText(activity, ""+list_age_save.get(position), Toast.LENGTH_SHORT).show();




//
//
//                //    add list of age to save list
//                final AdapterView.OnItemSelectedListener sp = holder.spinner_no_Child.getOnItemSelectedListener();
//
//                if (list_age.get(i) != 0) {
//
//                    list_age_save.add(list_age.get(i));
//
//                    if (list_age_save.size() > listCountCild.size()) {
//
//                        new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
//                                .setTitleText("Please Re Enter Your Children Data")
//                                .setConfirmText("Ok")
//                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//
//                                        @Override
//                                        public void onClick(SweetAlertDialog sDialog) {
//                                            list_age_save.clear();
//                                            listCountCild.clear();
//                                        //    holder.spinner_no_Child.setSelection(0);
//                                            holder.spinner_no_Child.post(new Runnable() {
//                                                @Override
//                                                public void run() {
//                                                    holder.spinner_no_Child.setSelection(0);
//                                                    holder.spinner_no_Child.setOnItemSelectedListener(sp);
//                                                }
//                                            });
//                                            child_m =true;
//                                            SharedPreferencesManger.remove(activity,"child_count");
//                                            sDialog.dismissWithAnimation();
//                                    }
//                                })
//                                .show();
//
//                    } else if (list_age_save.size() == listCountCild.size()) {
//
//                        child_m = false;
//                        StringBuilder str = new StringBuilder();
//
//
//                        for (int j =0; j < listCountCild.size(); j++) {
//
//                            str.append(list_age_save.get(j)).append(",");
//
//                            Toast.makeText(activity, ""+list_age_save.get(j), Toast.LENGTH_SHORT).show();
//                        }
//
//                        SharedPreferencesManger.SaveData(activity, "child_count", str.toString());
//
//                    }
//
//                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
//
//        SharedPreferences prefs = activity.getPreferences(MODE_PRIVATE);
//
//        StringBuilder str = new StringBuilder();
//        for (int j = 0; j < list_age_save.size(); j++) {
//            str.append(list_age_save.get(j)).append(",");
//        }
//        prefs.edit().putString("child_count", str.toString());


    }

    @Override
    public int getItemCount() {
        return listCountCild.size();
    }

    public class SingleView extends RecyclerView.ViewHolder {

        Spinner spinner_no_Child;
        TextView child_no_tv;

        public SingleView(@NonNull View itemView) {
            super(itemView);
            spinner_no_Child = itemView.findViewById(R.id.spinner_no_Child);
            child_no_tv = itemView.findViewById(R.id.child_no_tv);
        }
    }
}
