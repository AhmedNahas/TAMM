package net.middledleeast.tamm.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
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

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.helper.SharedPreferencesManger;

import java.util.ArrayList;
import java.util.List;

public class AdapterChildCount extends RecyclerView.Adapter<AdapterChildCount.SingleView> {


    // list count of spinner children
    List<Integer> listCountCild;


    Activity activity;

    // list of age 18 no
    private List<Integer> list_age;

    // list to save the age of child
    private List<Integer> list_age_save = new ArrayList<>();


    public AdapterChildCount(Activity activity, List<Integer> listCountCild, List<Integer> list_age) {
        this.listCountCild = listCountCild;
        this.activity = activity;
        this.list_age = list_age;

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

                // add list of age to save list
                //list_age_save.add(list_age.get(i));

//                if (list_age_save.size() > 0) {
//                    if (list_age_save.get(i) != null) {
//                        list_age_save.remove(i);
//                    }
//                }
                if (list_age_save.size() > i) {
                    if (!list_age_save.get(i).equals(list_age.get(i))) {
                        list_age_save.set(i, list_age.get(i));
                    }
                }
                StringBuilder str = new StringBuilder();


                if (list_age.get(i) != 0) {

                    for (int j = listCountCild.size(); j < list_age_save.size(); j++) {

                        str.append(list_age_save.get(j)).append(",");


                    }


                    SharedPreferencesManger.SaveData(activity, "child_count", str.toString());

                    Toast.makeText(activity, "" + list_age.get(i) + ",", Toast.LENGTH_SHORT).show();
                }

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
