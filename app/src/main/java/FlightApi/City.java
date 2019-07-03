
package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class City implements Serializable {

    private final static long serialVersionUID = 4939641513612929703L;
    @SerializedName("CountryCode")
    @Expose
    private Object countryCode;
    @SerializedName("CityCode")
    @Expose
    private String cityCode;
    @SerializedName("CityName")
    @Expose
    private String cityName;

    /**
     * No args constructor for use in serialization
     */
    public City() {
    }

    /**
     * @param cityName
     * @param cityCode
     * @param countryCode
     */
    public City(Object countryCode, String cityCode, String cityName) {
        super();
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.cityName = cityName;
    }

    public Object getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Object countryCode) {
        this.countryCode = countryCode;
    }

    public City withCountryCode(Object countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public City withCityCode(String cityCode) {
        this.cityCode = cityCode;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public City withCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

}
