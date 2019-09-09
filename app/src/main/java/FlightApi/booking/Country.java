
package FlightApi.booking;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country implements Serializable
{

    @SerializedName("CountryCode")
    @Expose
    private String countryCode;
    @SerializedName("CountryName")
    @Expose
    private Object countryName;
    private final static long serialVersionUID = 6265173167287141712L;

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
