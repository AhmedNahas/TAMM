
package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("CountryCode")
    @Expose
    private String countryCode;
    @SerializedName("CountryName")
    @Expose
    private Object countryName;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Object getCountryName() {
        return countryName;
    }

    public void setCountryName(Object countryName) {
        this.countryName = countryName;
    }

}
