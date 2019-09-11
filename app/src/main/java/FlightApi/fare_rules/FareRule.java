
package FlightApi.fare_rules;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareRule {

    @SerializedName("Origin")
    @Expose
    private String origin;
    @SerializedName("Destination")
    @Expose
    private String destination;
    @SerializedName("Airline")
    @Expose
    private String airline;
    @SerializedName("FareRestriction")
    @Expose
    private Object fareRestriction;
    @SerializedName("FareBasisCode")
    @Expose
    private String fareBasisCode;
    @SerializedName("FareRuleDetail")
    @Expose
    private String fareRuleDetail;
    @SerializedName("DepartureDate")
    @Expose
    private String departureDate;
    @SerializedName("FlightNumber")
    @Expose
    private String flightNumber;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Object getFareRestriction() {
        return fareRestriction;
    }

    public void setFareRestriction(Object fareRestriction) {
        this.fareRestriction = fareRestriction;
    }

    public String getFareBasisCode() {
        return fareBasisCode;
    }

    public void setFareBasisCode(String fareBasisCode) {
        this.fareBasisCode = fareBasisCode;
    }

    public String getFareRuleDetail() {
        return fareRuleDetail;
    }

    public void setFareRuleDetail(String fareRuleDetail) {
        this.fareRuleDetail = fareRuleDetail;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

}
