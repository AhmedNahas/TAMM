
package FlightApi.booking;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City implements Serializable
{

    @SerializedName("CountryCode")
    @Expose
    private Object countryCode;
    @SerializedName("CityCode")
    @Expose
    private String cityCode;
    @SerializedName("CityName")
    @Expose
    private String cityName;
    private final static long serialVersionUID = -3431571772090512798L;

    public Object getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Object countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
