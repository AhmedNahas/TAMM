
package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AirlineDetails implements Serializable {

    private final static long serialVersionUID = -2873923199869212482L;
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

    /**
     * No args constructor for use in serialization
     */
    public AirlineDetails() {
    }

    /**
     * @param operatingCarrier
     * @param airlineName
     * @param craft
     * @param airlineCode
     * @param flightNumber
     */
    public AirlineDetails(String airlineCode, String flightNumber, String craft, String airlineName, String operatingCarrier) {
        super();
        this.airlineCode = airlineCode;
        this.flightNumber = flightNumber;
        this.craft = craft;
        this.airlineName = airlineName;
        this.operatingCarrier = operatingCarrier;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public AirlineDetails withAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
        return this;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public AirlineDetails withFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
        return this;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public AirlineDetails withCraft(String craft) {
        this.craft = craft;
        return this;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public AirlineDetails withAirlineName(String airlineName) {
        this.airlineName = airlineName;
        return this;
    }

    public String getOperatingCarrier() {
        return operatingCarrier;
    }

    public void setOperatingCarrier(String operatingCarrier) {
        this.operatingCarrier = operatingCarrier;
    }

    public AirlineDetails withOperatingCarrier(String operatingCarrier) {
        this.operatingCarrier = operatingCarrier;
        return this;
    }

}
