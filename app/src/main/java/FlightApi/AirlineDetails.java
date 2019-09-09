
package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AirlineDetails {

    @SerializedName("AirlineCode")
    @Expose
    private String airlineCode;
    @SerializedName("FlightNumber")
    @Expose
    private String flightNumber;
    @SerializedName("Craft")
    @Expose
    private String craft;
    @SerializedName("AirlineName")
    @Expose
    private String airlineName;
    @SerializedName("OperatingCarrier")
    @Expose
    private String operatingCarrier;

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getOperatingCarrier() {
        return operatingCarrier;
    }

    public void setOperatingCarrier(String operatingCarrier) {
        this.operatingCarrier = operatingCarrier;
    }

}
