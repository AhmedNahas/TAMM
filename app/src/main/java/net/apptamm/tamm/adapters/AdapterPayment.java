package net.apptamm.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.apptamm.tamm.R;

import java.util.List;

public class AdapterPayment extends ArrayAdapter<String> {
    List<String> spinnerTitles;
List<Integer> spinnerImages;
    Context mContext;


    public AdapterPayment(@NonNull Context context, List<String> spinnerTitles,List<Integer> images) {
        super(context, R.layout.custom_spinner_row);
        this.spinnerTitles = spinnerTitles;
        this.spinnerImages = images;
        this.mContext = context;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_spinner_row, parent, false);

            mViewHolder.img = (ImageView) convertView.findViewById(R.id.payment_icon_image);
            mViewHolder.title = (TextView) convertView.findViewById(R.id.title_);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.img.setImageResource(spinnerImages.get(position));
        mViewHolder.title.setText(spinnerTitles.get(position));

        return convertView;
    }



    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }
    private static class ViewHolder {
        ImageView img;
        TextView title;
    }



    @Override
    public int getCount() {
        return spinnerTitles.size();
    }
}