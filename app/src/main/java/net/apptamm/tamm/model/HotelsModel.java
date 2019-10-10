package net.apptamm.tamm.model;

import android.os.Parcel;
import android.os.Parcelable;

public class HotelsModel implements Parcelable {

    int hotelImage ;
    String hotelName , hotelDesc ;

    protected HotelsModel(Parcel in) {
        hotelImage = in.readInt();
        hotelName = in.readString();
        hotelDesc = in.readString();
    }

    public static final Creator<HotelsModel> CREATOR = new Creator<HotelsModel>() {
        @Override
        public HotelsModel createFromParcel(Parcel in) {
            return new HotelsModel(in);
        }

        @Override
        public HotelsModel[] newArray(int size) {
            return new HotelsModel[size];
        }
    };

    public int getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(int hotelImage) {
        this.hotelImage = hotelImage;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelDesc() {
        return hotelDesc;
    }

    public void setHotelDesc(String hotelDesc) {
        this.hotelDesc = hotelDesc;
    }

    public HotelsModel(int hotelImage, String hotelName, String hotelDesc) {
        this.hotelImage = hotelImage;
        this.hotelName = hotelName;
        this.hotelDesc = hotelDesc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(hotelImage);
        parcel.writeString(hotelName);
        parcel.writeString(hotelDesc);
    }
}
