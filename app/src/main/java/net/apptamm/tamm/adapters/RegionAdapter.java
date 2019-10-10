package net.apptamm.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.apptamm.tamm.R;
import net.apptamm.tamm.model.RegionItem;

import java.util.ArrayList;

public class RegionAdapter extends ArrayAdapter<RegionItem> {


    private ArrayList<RegionItem> regionItems;

    public RegionAdapter(Context context , ArrayList<RegionItem> regionList){
        super(context , 0 , regionList);

    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    private View initView (int position , View convertView , ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.region_row,parent,false);
        }

        TextView cityName = convertView.findViewById(R.id.region_name);

        RegionItem areaSelected = getItem(position);

        if (areaSelected != null) {

            cityName.setText(areaSelected.getName());
        }
        return convertView;
    }
}
