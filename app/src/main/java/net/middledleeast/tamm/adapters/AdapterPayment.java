package net.middledleeast.tamm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.middledleeast.tamm.R;

public class AdapterPayment extends ArrayAdapter<String> {
    String[] spinnerTitles;
    int[] spinnerImages;
    Context mContext;


    public AdapterPayment(@NonNull Context context, String[] titles, int[] images) {
        super(context, R.layout.custom_spinner_row);
        this.spinnerTitles = titles;
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

            mViewHolder.img = (ImageView) convertView.findViewById(R.id.img_payment);
            mViewHolder.title = (TextView) convertView.findViewById(R.id.titel_payment);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.img.setImageResource(spinnerImages[position]);
        mViewHolder.title.setText(spinnerTitles[position]);

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
        return spinnerTitles.length;
    }
}