
package FlightApi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Itinerary {

    @SerializedName("IsHoldEligibleForLcc")
    @Expose
    private Boolean isHoldEligibleForLcc;
    @SerializedName("Segments")
    @Expose
    private List<Segment> segments = null;
    @SerializedName("Passenger")
    @Expose
    private List<Passenger> passenger = null;
    @SerializedName("FareRules")
    @Expose
    private List<FlightApi.fare_rules.FareRule> fareRules = null;
    @SerializedName("Destination")
    @Expose
    private String destination;
    @SerializedName("FareType")
    @Expose
    private String fareType;
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
    @SerializedName("TravelDate")
    @Expose
    private String travelDate;
    @SerializedName("NonRefundable")
    @Expose
    private Boolean nonRefundable;
    @SerializedName("AgentRefNo")
    @Expose
    private Object agentRefNo;
    @SerializedName("IsLcc")
    @Expose
    private Boolean isLcc;
    @SerializedName("AirlineRemark")
    @Expose
    private String airlineRemark;
    @SerializedName("SearchType")
    @Expose
    private Integer searchType;
    @SerializedName("EarnedLoyaltyPoints")
    @Expose
    private Integer earnedLoyaltyPoints;
    @SerializedName("StaffRemarks")
    @Expose
    private Object staffRemarks;

    public Boolean getIsHoldEligibleForLcc() {
        return isHoldEligibleForLcc;
    }

    public void setIsHoldEligibleForLcc(Boolean isHoldEligibleForLcc) {
        this.isHoldEligibleForLcc = isHoldEligibleForLcc;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    public List<Passenger> getPassenger() {
        return passenger;
    }

    public void setPassenger(List<Passenger> passenger) {
        this.passenger = passenger;
    }

    public List<FlightApi.fare_rules.FareRule> getFareRules() {
        return fareRules;
    }

    public void setFareRules(List<FlightApi.fare_rules.FareRule> fareRules) {
        this.fareRules = fareRules;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFareType() {
        return fareType;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
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

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public Boolean getNonRefundable() {
        return nonRefundable;
    }

    public void setNonRefundable(Boolean nonRefundable) {
        this.nonRefundable = nonRefundable;
    }

    public Object getAgentRefNo() {
        return agentRefNo;
    }

    public void setAgentRefNo(Object agentRefNo) {
        this.agentRefNo = agentRefNo;
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

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getEarnedLoyaltyPoints() {
        return earnedLoyaltyPoints;
    }

    public void setEarnedLoyaltyPoints(Integer earnedLoyaltyPoints) {
        this.earnedLoyaltyPoints = earnedLoyaltyPoints;
    }

    public Object getStaffRemarks() {
        return staffRemarks;
    }

    public void setStaffRemarks(Object staffRemarks) {
        this.staffRemarks = staffRemarks;
    }

}
