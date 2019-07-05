
package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Destination implements Serializable {

    private final static long serialVersionUID = -3127361373350279458L;
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

    /**
     * No args constructor for use in serialization
     */
    public Destination() {
    }

    /**
     * @param countryName
     * @param airportName
     * @param terminal
     * @param cityName
     * @param airportCode
     * @param countryCode
     * @param cityCode
     */
    public Destination(String airportCode, String airportName, String cityCode, String cityName, String countryCode, String countryName, String terminal) {
        super();
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.terminal = terminal;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public Destination withAirportCode(String airportCode) {
        this.airportCode = airportCode;
        return this;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Destination withAirportName(String airportName) {
        this.airportName = airportName;
        return this;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Destination withCityCode(String cityCode) {
        this.cityCode = cityCode;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Destination withCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Destination withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Destination withCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Destination withTerminal(String terminal) {
        this.terminal = terminal;
        return this;
    }

}
