
package FlightApi;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Itinerary implements Serializable
{

    @SerializedName("IsHoldEligibleForLcc")
    @Expose
    private Boolean isHoldEligibleForLcc;
    @SerializedName("FlightId")
    @Expose
    private Integer flightId;
    @SerializedName("Segments")
    @Expose
    private List<Segment> segments = null;
    @SerializedName("Passenger")
    @Expose
    private Passenger passenger = null;
    @SerializedName("FareRules")
    @Expose
    private List<FareRule> fareRules = null;
    @SerializedName("PNR")
    @Expose
    private String pNR;
    @SerializedName("Destination")
    @Expose
    private String destination;
    @SerializedName("LastTicketDate")
    @Expose
    private String lastTicketDate;
    @SerializedName("Origin")
    @Expose
    private String origin;
    @SerializedName("CreatedOn")
    @Expose
    private String createdOn;
    @SerializedName("ValidatingAirlineCode")
    @Expose
    private String validatingAirlineCode;
    @SerializedName("IsDomestic")
    @Expose
    private Boolean isDomestic;
    @SerializedName("AirlineCode")
    @Expose
    private Object airlineCode;
    @SerializedName("NonRefundable")
    @Expose
    private Boolean nonRefundable;
    @SerializedName("BookingId")
    @Expose
    private Integer bookingId;
    @SerializedName("IsLcc")
    @Expose
    private Boolean isLcc;
    @SerializedName("AirlineRemark")
    @Expose
    private String airlineRemark;
    private final static long serialVersionUID = -7737601744203642679L;

    public Boolean getIsHoldEligibleForLcc() {
        return isHoldEligibleForLcc;
    }

    public void setIsHoldEligibleForLcc(Boolean isHoldEligibleForLcc) {
        this.isHoldEligibleForLcc = isHoldEligibleForLcc;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public List<FareRule> getFareRules() {
        return fareRules;
    }

    public void setFareRules(List<FareRule> fareRules) {
        this.fareRules = fareRules;
    }

    public String getPNR() {
        return pNR;
    }

    public void setPNR(String pNR) {
        this.pNR = pNR;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLastTicketDate() {
        return lastTicketDate;
    }

    public void setLastTicketDate(String lastTicketDate) {
        this.lastTicketDate = lastTicketDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getValidatingAirlineCode() {
        return validatingAirlineCode;
    }

    public void setValidatingAirlineCode(String validatingAirlineCode) {
        this.validatingAirlineCode = validatingAirlineCode;
    }

    public Boolean getIsDomestic() {
        return isDomestic;
    }

    public void setIsDomestic(Boolean isDomestic) {
        this.isDomestic = isDomestic;
    }

    public Object getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(Object airlineCode) {
        this.airlineCode = airlineCode;
    }

    public Boolean getNonRefundable() {
        return nonRefundable;
    }

    public void setNonRefundable(Boolean nonRefundable) {
        this.nonRefundable = nonRefundable;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Boolean getIsLcc() {
        return isLcc;
    }

    public void setIsLcc(Boolean isLcc) {
        this.isLcc = isLcc;
    }

    public String getAirlineRemark() {
        return airlineRemark;
    }

    public void setAirlineRemark(String airlineRemark) {
        this.airlineRemark = airlineRemark;
    }

}
