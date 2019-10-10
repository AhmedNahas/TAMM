package net.apptamm.tamm.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import net.apptamm.tamm.helper.SharedPreferencesManger;

import java.util.List;

public class adapterPhotoHotels extends PagerAdapter {

    Context mContext;
    List<String> mImagList;

    public adapterPhotoHotels(Context context, List<String> mImagList) {
        this.mContext = context;
        this.mImagList = mImagList;
    }

    @Override
    public int getCount() {
        return mImagList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);


        String imgHotelOne = mImagList.get(0);
        SharedPreferencesManger.SaveData(mContext,"imageHotel",imgHotelOne);
        Glide.with(mContext).load(mImagList.get(position)).into(imageView);
        String singlePic = mImagList.get(0);
        SharedPreferencesManger.SaveData(mContext,"singlePic",singlePic);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
