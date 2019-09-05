
package FlightApi;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Origin implements Serializable
{

    @SerializedName("AirportCode")
    @Expose
    private String airportCode;
    @SerializedName("AirportName")
    @Expose
    private String airportName;
    @SerializedName("CityCode")
    @Expose
    private String cityCode;
    @SerializedName("CityName")
    @Expose
    private String cityName;
    @SerializedName("CountryCode")
    @Expose
    private String countryCode;
    @SerializedName("CountryName")
    @Expose
    private String countryName;
    @SerializedName("Terminal")
    @Expose
    private String terminal;
    private final static long serialVersionUID = 7930344813925567276L;

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

}
