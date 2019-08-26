
package net.middledleeast.tamm.model.Best;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BestHotel {

    public BestHotel() {


    }

    public BestHotel(String id, String offername, String country, String hotelname, String breakfast, String dinner, String lunch, String fromairport, String fromhotel, String day, String month, String year, String dd, String mm, String yy, String offerdesc, String image, String price) {

        this.id = id;
        this.offername = offername;
        this.country = country;
        this.hotelname = hotelname;
        this.breakfast = breakfast;
        this.dinner = dinner;
        this.lunch = lunch;
        this.fromairport = fromairport;
        this.fromhotel = fromhotel;
        this.day = day;
        this.month = month;
        this.year = year;
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
        this.offerdesc = offerdesc;
        this.image = image;
        this.price = price;
    }



    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("offername")
    @Expose
    private String offername;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("hotelname")
    @Expose
    private String hotelname;
    @SerializedName("breakfast")
    @Expose
    private String breakfast;
    @SerializedName("dinner")
    @Expose
    private String dinner;
    @SerializedName("lunch")
    @Expose
    private String lunch;
    @SerializedName("fromairport")
    @Expose
    private String fromairport;
    @SerializedName("fromhotel")
    @Expose
    private String fromhotel;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("month")
    @Expose
    private String month;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("dd")
    @Expose
    private String dd;
    @SerializedName("mm")
    @Expose
    private String mm;
    @SerializedName("yy")
    @Expose
    private String yy;
    @SerializedName("offerdesc")
    @Expose
    private String offerdesc;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("price")
    @Expose
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOffername() {
        return offername;
    }

    public void setOffername(String offername) {
        this.offername = offername;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getFromairport() {
        return fromairport;
    }

    public void setFromairport(String fromairport) {
        this.fromairport = fromairport;
    }

    public String getFromhotel() {
        return fromhotel;
    }

    public void setFromhotel(String fromhotel) {
        this.fromhotel = fromhotel;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    public String getYy() {
        return yy;
    }

    public void setYy(String yy) {
        this.yy = yy;
    }

    public String getOfferdesc() {
        return offerdesc;
    }

    public void setOfferdesc(String offerdesc) {
        this.offerdesc = offerdesc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}