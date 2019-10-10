package net.apptamm.tamm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bestflight {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("airplane")
    @Expose
    private String airplane;
    @SerializedName("fromairport")
    @Expose
    private String fromairport;
    @SerializedName("toairport")
    @Expose
    private String toairport;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("takeoff")
    @Expose
    private String takeoff;
    @SerializedName("landing")
    @Expose
    private String landing;

    public Bestflight( String airplane, String fromairport, String toairport, String picture, String price, String takeoff, String landing) {

        this.airplane=airplane;
        this.fromairport=fromairport;
        this.toairport=toairport;
        this.picture=picture;
        this.price=price;
        this.takeoff=takeoff;
        this.landing=landing;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAirplane() {
        return airplane;
    }

    public void setAirplane(String airplane) {
        this.airplane = airplane;
    }

    public String getFromairport() {
        return fromairport;
    }

    public void setFromairport(String fromairport) {
        this.fromairport = fromairport;
    }

    public String getToairport() {
        return toairport;
    }

    public void setToairport(String toairport) {
        this.toairport = toairport;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(String takeoff) {
        this.takeoff = takeoff;
    }

    public String getLanding() {
        return landing;
    }

    public void setLanding(String landing) {
        this.landing = landing;
    }
}