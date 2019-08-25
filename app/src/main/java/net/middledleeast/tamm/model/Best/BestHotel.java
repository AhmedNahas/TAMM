
package net.middledleeast.tamm.model.Best;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "offername",
        "country",
        "hotelname",
        "breakfast",
        "dinner",
        "lunch",
        "fromairport",
        "fromhotel",
        "day",
        "month",
        "year",
        "dd",
        "mm",
        "yy",
        "offerdesc",
        "image"
})
public class BestHotel {

    @JsonProperty("id")
    private String id;
    @JsonProperty("offername")
    private String offername;
    @JsonProperty("country")
    private String country;
    @JsonProperty("hotelname")
    private String hotelname;
    @JsonProperty("breakfast")
    private String breakfast;
    @JsonProperty("dinner")
    private String dinner;
    @JsonProperty("lunch")
    private String lunch;
    @JsonProperty("fromairport")
    private String fromairport;
    @JsonProperty("fromhotel")
    private String fromhotel;
    @JsonProperty("day")
    private String day;
    @JsonProperty("month")
    private String month;
    @JsonProperty("year")
    private String year;

    public BestHotel(String offername, String country, String hotelname, String image) {
        this.offername = offername;
        this.country = country;
        this.hotelname = hotelname;
        this.image = image;
    }

    @JsonProperty("dd")
    private String dd;
    @JsonProperty("mm")
    private String mm;
    @JsonProperty("yy")
    private String yy;
    @JsonProperty("offerdesc")
    private String offerdesc;
    @JsonProperty("image")
    private String image;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("offername")
    public String getOffername() {
        return offername;
    }

    @JsonProperty("offername")
    public void setOffername(String offername) {
        this.offername = offername;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("hotelname")
    public String getHotelname() {
        return hotelname;
    }

    @JsonProperty("hotelname")
    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    @JsonProperty("breakfast")
    public String getBreakfast() {
        return breakfast;
    }

    @JsonProperty("breakfast")
    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    @JsonProperty("dinner")
    public String getDinner() {
        return dinner;
    }

    @JsonProperty("dinner")
    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    @JsonProperty("lunch")
    public String getLunch() {
        return lunch;
    }

    @JsonProperty("lunch")
    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    @JsonProperty("fromairport")
    public String getFromairport() {
        return fromairport;
    }

    @JsonProperty("fromairport")
    public void setFromairport(String fromairport) {
        this.fromairport = fromairport;
    }

    @JsonProperty("fromhotel")
    public String getFromhotel() {
        return fromhotel;
    }

    @JsonProperty("fromhotel")
    public void setFromhotel(String fromhotel) {
        this.fromhotel = fromhotel;
    }

    @JsonProperty("day")
    public String getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(String day) {
        this.day = day;
    }

    @JsonProperty("month")
    public String getMonth() {
        return month;
    }

    @JsonProperty("month")
    public void setMonth(String month) {
        this.month = month;
    }

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("dd")
    public String getDd() {
        return dd;
    }

    @JsonProperty("dd")
    public void setDd(String dd) {
        this.dd = dd;
    }

    @JsonProperty("mm")
    public String getMm() {
        return mm;
    }

    @JsonProperty("mm")
    public void setMm(String mm) {
        this.mm = mm;
    }

    @JsonProperty("yy")
    public String getYy() {
        return yy;
    }

    @JsonProperty("yy")
    public void setYy(String yy) {
        this.yy = yy;
    }

    @JsonProperty("offerdesc")
    public String getOfferdesc() {
        return offerdesc;
    }

    @JsonProperty("offerdesc")
    public void setOfferdesc(String offerdesc) {
        this.offerdesc = offerdesc;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
