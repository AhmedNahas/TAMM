
package FlightApi;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Segment implements Serializable
{

    @SerializedName("NoOfSeatAvailable")
    @Expose
    private Integer noOfSeatAvailable;
    @SerializedName("OperatingCarrier")
    @Expose
    private String operatingCarrier;
    @SerializedName("SegmentIndicator")
    @Expose
    private Integer segmentIndicator;
    @SerializedName("Airline")
    @Expose
    private String airline;
    @SerializedName("Origin")
    @Expose
    private Origin origin;
    @SerializedName("Destination")
    @Expose
    private Destination destination;
    @SerializedName("FlightNumber")
    @Expose
    private String flightNumber;
    @SerializedName("DepartureTime")
    @Expose
    private String departureTime;
    @SerializedName("ArrivalTime")
    @Expose
    private String arrivalTime;
    @SerializedName("BookingClass")
    @Expose
    private String bookingClass;
    @SerializedName("MealType")
    @Expose
    private Object mealType;
    @SerializedName("ETicketEligible")
    @Expose
    private Boolean eTicketEligible;
    @SerializedName("Craft")
    @Expose
    private String craft;
    @SerializedName("StopOver")
    @Expose
    private Boolean stopOver;
    @SerializedName("Stops")
    @Expose
    private Integer stops;
    @SerializedName("Mile")
    @Expose
    private Integer mile;
    @SerializedName("Duration")
    @Expose
    private String duration;
    @SerializedName("GroundTime")
    @Expose
    private String groundTime;
    @SerializedName("AccumulatedDuration")
    @Expose
    private String accumulatedDuration;
    @SerializedName("StopPoint")
    @Expose
    private Object stopPoint;
    @SerializedName("StopPointArrivalTime")
    @Expose
    private String stopPointArrivalTime;
    @SerializedName("StopPointDepartureTime")
    @Expose
    private String stopPointDepartureTime;
    @SerializedName("IncludedBaggage")
    @Expose
    private String includedBaggage;
    @SerializedName("CabinBaggage")
    @Expose
    private String cabinBaggage;
    @SerializedName("AdditionalBaggage")
    @Expose
    private Object additionalBaggage;
    @SerializedName("AliasFlightKey")
    @Expose
    private Object aliasFlightKey;
    @SerializedName("AirlineDetails")
    @Expose
    private AirlineDetails airlineDetails;
    @SerializedName("AirlineName")
    @Expose
    private String airlineName;
    @SerializedName("ArrivalDateText")
    @Expose
    private Object arrivalDateText;
    @SerializedName("DepDateText")
    @Expose
    private Object depDateText;
    private final static long serialVersionUID = 6840247231670000942L;

    public Integer getNoOfSeatAvailable() {
        return noOfSeatAvailable;
    }

    public void setNoOfSeatAvailable(Integer noOfSeatAvailable) {
        this.noOfSeatAvailable = noOfSeatAvailable;
    }

    public String getOperatingCarrier() {
        return operatingCarrier;
    }

    public void setOperatingCarrier(String operatingCarrier) {
        this.operatingCarrier = operatingCarrier;
    }

    public Integer getSegmentIndicator() {
        return segmentIndicator;
    }

    public void setSegmentIndicator(Integer segmentIndicator) {
        this.segmentIndicator = segmentIndicator;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(String bookingClass) {
        this.bookingClass = bookingClass;
    }

    public Object getMealType() {
        return mealType;
    }

    public void setMealType(Object mealType) {
        this.mealType = mealType;
    }

    public Boolean getETicketEligible() {
        return eTicketEligible;
    }

    public void setETicketEligible(Boolean eTicketEligible) {
        this.eTicketEligible = eTicketEligible;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public Boolean getStopOver() {
        return stopOver;
    }

    public void setStopOver(Boolean stopOver) {
        this.stopOver = stopOver;
    }

    public Integer getStops() {
        return stops;
    }

    public void setStops(Integer stops) {
        this.stops = stops;
    }

    public Integer getMile() {
        return mile;
    }

    public void setMile(Integer mile) {
        this.mile = mile;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGroundTime() {
        return groundTime;
    }

    public void setGroundTime(String groundTime) {
        this.groundTime = groundTime;
    }

    public String getAccumulatedDuration() {
        return accumulatedDuration;
    }

    public void setAccumulatedDuration(String accumulatedDuration) {
        this.accumulatedDuration = accumulatedDuration;
    }

    public Object getStopPoint() {
        return stopPoint;
    }

    public void setStopPoint(Object stopPoint) {
        this.stopPoint = stopPoint;
    }

    public String getStopPointArrivalTime() {
        return stopPointArrivalTime;
    }

    public void setStopPointArrivalTime(String stopPointArrivalTime) {
        this.stopPointArrivalTime = stopPointArrivalTime;
    }

    public String getStopPointDepartureTime() {
        return stopPointDepartureTime;
    }

    public void setStopPointDepartureTime(String stopPointDepartureTime) {
        this.stopPointDepartureTime = stopPointDepartureTime;
    }

    public String getIncludedBaggage() {
        return includedBaggage;
    }

    public void setIncludedBaggage(String includedBaggage) {
        this.includedBaggage = includedBaggage;
    }

    public String getCabinBaggage() {
        return cabinBaggage;
    }

    public void setCabinBaggage(String cabinBaggage) {
        this.cabinBaggage = cabinBaggage;
    }

    public Object getAdditionalBaggage() {
        return additionalBaggage;
    }

    public void setAdditionalBaggage(Object additionalBaggage) {
        this.additionalBaggage = additionalBaggage;
    }

    public Object getAliasFlightKey() {
        return aliasFlightKey;
    }

    public void setAliasFlightKey(Object aliasFlightKey) {
        this.aliasFlightKey = aliasFlightKey;
    }

    public AirlineDetails getAirlineDetails() {
        return airlineDetails;
    }

    public void setAirlineDetails(AirlineDetails airlineDetails) {
        this.airlineDetails = airlineDetails;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Object getArrivalDateText() {
        return arrivalDateText;
    }

    public void setArrivalDateText(Object arrivalDateText) {
        this.arrivalDateText = arrivalDateText;
    }

    public Object getDepDateText() {
        return depDateText;
    }

    public void setDepDateText(Object depDateText) {
        this.depDateText = depDateText;
    }

}
