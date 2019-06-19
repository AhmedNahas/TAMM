package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.middledleeast.tamm.R;
import net.middledleeast.tamm.model.AreaItem;

import java.util.ArrayList;
import java.util.List;

public class AreaAdapter extends ArrayAdapter<AreaItem> {

    private ArrayList<AreaItem> areaItems;

    public AreaAdapter(Context context,  List<AreaItem> areaList) {
        super(context, 0,areaList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, View convertView,  ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    private View initView (int position , View convertView , ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.area_row,parent,false);
        }
        TextView areaName = convertView.findViewById(R.id.area_name);
        AreaItem areaSelected = getItem(position);

        if (areaSelected != null){
            areaName.setText(areaSelected.getAreaName());
        }
        return convertView;
    }
}