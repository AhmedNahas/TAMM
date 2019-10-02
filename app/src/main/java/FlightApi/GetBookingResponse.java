package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class GetBookingResponse implements Serializable {

    private final static long serialVersionUID = -5066246334461332700L;
    @SerializedName("Itinerary")
    @Expose
    private Itinerary itinerary;
    @SerializedName("Status")
    @Expose
    private long status;
    @SerializedName("ShowFailedReason")
    @Expose
    private boolean showFailedReason;
    @SerializedName("IsSuccess")
    @Expose
    private boolean isSuccess;
    @SerializedName("Errors")
    @Expose
    private List<Error_> errors = new ArrayList<Error_>();
    @SerializedName("Alerts")
    @Expose
    private List<Object> alerts = new ArrayList<Object>();
    @SerializedName("TokenId")
    @Expose
    private String tokenId;
    @SerializedName("TrackingId")
    @Expose
    private String trackingId;

    /**
     * No args constructor for use in serialization
     */
    public GetBookingResponse() {
    }

    /**
     * @param tokenId
     * @param errors
     * @param status
     * @param alerts
     * @param trackingId
     * @param itinerary
     * @param isSuccess
     * @param showFailedReason
     */
    public GetBookingResponse(Itinerary itinerary, long status, boolean showFailedReason, boolean isSuccess, List<Error_> errors, List<Object> alerts, String tokenId, String trackingId) {
        super();
        this.itinerary = itinerary;
        this.status = status;
        this.showFailedReason = showFailedReason;
        this.isSuccess = isSuccess;
        this.errors = errors;
        this.alerts = alerts;
        this.tokenId = tokenId;
        this.trackingId = trackingId;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public GetBookingResponse withItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
        return this;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public GetBookingResponse withStatus(long status) {
        this.status = status;
        return this;
    }

    public boolean isShowFailedReason() {
        return showFailedReason;
    }

    public void setShowFailedReason(boolean showFailedReason) {
        this.showFailedReason = showFailedReason;
    }

    public GetBookingResponse withShowFailedReason(boolean showFailedReason) {
        this.showFailedReason = showFailedReason;
        return this;
    }

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public GetBookingResponse withIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
        return this;
    }

    public List<Error_> getErrors() {
        return errors;
    }

    public void setErrors(List<Error_> errors) {
        this.errors = errors;
    }

    public GetBookingResponse withErrors(List<Error_> errors) {
        this.errors = errors;
        return this;
    }

    public List<Object> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Object> alerts) {
        this.alerts = alerts;
    }

    public GetBookingResponse withAlerts(List<Object> alerts) {
        this.alerts = alerts;
        return this;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public GetBookingResponse withTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public GetBookingResponse withTrackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }


    public class AirlineDetails implements Serializable {

        private final static long serialVersionUID = 5097339419185564654L;
        @SerializedName("AirlineCode")
        @Expose
        private Object airlineCode;
        @SerializedName("FlightNumber")
        @Expose
        private Object flightNumber;
        @SerializedName("Craft")
        @Expose
        private Object craft;
        @SerializedName("AirlineName")
        @Expose
        private Object airlineName;
        @SerializedName("OperatingCarrier")
        @Expose
        private Object operatingCarrier;

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
        public AirlineDetails(Object airlineCode, Object flightNumber, Object craft, Object airlineName, Object operatingCarrier) {
            super();
            this.airlineCode = airlineCode;
            this.flightNumber = flightNumber;
            this.craft = craft;
            this.airlineName = airlineName;
            this.operatingCarrier = operatingCarrier;
        }

        public Object getAirlineCode() {
            return airlineCode;
        }

        public void setAirlineCode(Object airlineCode) {
            this.airlineCode = airlineCode;
        }

        public AirlineDetails withAirlineCode(Object airlineCode) {
            this.airlineCode = airlineCode;
            return this;
        }

        public Object getFlightNumber() {
            return flightNumber;
        }

        public void setFlightNumber(Object flightNumber) {
            this.flightNumber = flightNumber;
        }

        public AirlineDetails withFlightNumber(Object flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public Object getCraft() {
            return craft;
        }

        public void setCraft(Object craft) {
            this.craft = craft;
        }

        public AirlineDetails withCraft(Object craft) {
            this.craft = craft;
            return this;
        }

        public Object getAirlineName() {
            return airlineName;
        }

        public void setAirlineName(Object airlineName) {
            this.airlineName = airlineName;
        }

        public AirlineDetails withAirlineName(Object airlineName) {
            this.airlineName = airlineName;
            return this;
        }

        public Object getOperatingCarrier() {
            return operatingCarrier;
        }

        public void setOperatingCarrier(Object operatingCarrier) {
            this.operatingCarrier = operatingCarrier;
        }

        public AirlineDetails withOperatingCarrier(Object operatingCarrier) {
            this.operatingCarrier = operatingCarrier;
            return this;
        }

    }


    public class City implements Serializable {

        private final static long serialVersionUID = -5221058624880429208L;
        @SerializedName("CountryCode")
        @Expose
        private String countryCode;
        @SerializedName("CityCode")
        @Expose
        private String cityCode;
        @SerializedName("CityName")
        @Expose
        private String cityName;

        /**
         * No args constructor for use in serialization
         */
        public City() {
        }

        /**
         * @param cityName
         * @param cityCode
         * @param countryCode
         */
        public City(String countryCode, String cityCode, String cityName) {
            super();
            this.countryCode = countryCode;
            this.cityCode = cityCode;
            this.cityName = cityName;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public City withCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public City withCityCode(String cityCode) {
            this.cityCode = cityCode;
            return this;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public City withCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

    }


    public class Country implements Serializable {

        private final static long serialVersionUID = 8538250341924655244L;
        @SerializedName("CountryCode")
        @Expose
        private String countryCode;
        @SerializedName("CountryName")
        @Expose
        private String countryName;

        /**
         * No args constructor for use in serialization
         */
        public Country() {
        }

        /**
         * @param countryName
         * @param countryCode
         */
        public Country(String countryCode, String countryName) {
            super();
            this.countryCode = countryCode;
            this.countryName = countryName;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public Country withCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public Country withCountryName(String countryName) {
            this.countryName = countryName;
            return this;
        }

    }


    public class Destination implements Serializable {

        private final static long serialVersionUID = -2601715543704788967L;
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
        private Object countryName;
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
        public Destination(String airportCode, String airportName, String cityCode, String cityName, String countryCode, Object countryName, String terminal) {
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

        public Object getCountryName() {
            return countryName;
        }

        public void setCountryName(Object countryName) {
            this.countryName = countryName;
        }

        public Destination withCountryName(Object countryName) {
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


    public class Fare implements Serializable {

        private final static long serialVersionUID = -1298349241197725262L;
        @SerializedName("TotalFare")
        @Expose
        private double totalFare;
        @SerializedName("FareType")
        @Expose
        private String fareType;
        @SerializedName("AgentMarkup")
        @Expose
        private long agentMarkup;
        @SerializedName("OtherCharges")
        @Expose
        private double otherCharges;
        @SerializedName("AgentPreferredCurrency")
        @Expose
        private String agentPreferredCurrency;
        @SerializedName("ServiceFee")
        @Expose
        private long serviceFee;
        @SerializedName("Vat")
        @Expose
        private long vat;
        @SerializedName("BaseFare")
        @Expose
        private double baseFare;
        @SerializedName("Tax")
        @Expose
        private double tax;

        /**
         * No args constructor for use in serialization
         */
        public Fare() {
        }

        /**
         * @param baseFare
         * @param serviceFee
         * @param totalFare
         * @param tax
         * @param agentMarkup
         * @param agentPreferredCurrency
         * @param otherCharges
         * @param vat
         * @param fareType
         */
        public Fare(double totalFare, String fareType, long agentMarkup, double otherCharges, String agentPreferredCurrency, long serviceFee, long vat, double baseFare, double tax) {
            super();
            this.totalFare = totalFare;
            this.fareType = fareType;
            this.agentMarkup = agentMarkup;
            this.otherCharges = otherCharges;
            this.agentPreferredCurrency = agentPreferredCurrency;
            this.serviceFee = serviceFee;
            this.vat = vat;
            this.baseFare = baseFare;
            this.tax = tax;
        }

        public double getTotalFare() {
            return totalFare;
        }

        public void setTotalFare(double totalFare) {
            this.totalFare = totalFare;
        }

        public Fare withTotalFare(double totalFare) {
            this.totalFare = totalFare;
            return this;
        }

        public String getFareType() {
            return fareType;
        }

        public void setFareType(String fareType) {
            this.fareType = fareType;
        }

        public Fare withFareType(String fareType) {
            this.fareType = fareType;
            return this;
        }

        public long getAgentMarkup() {
            return agentMarkup;
        }

        public void setAgentMarkup(long agentMarkup) {
            this.agentMarkup = agentMarkup;
        }

        public Fare withAgentMarkup(long agentMarkup) {
            this.agentMarkup = agentMarkup;
            return this;
        }

        public double getOtherCharges() {
            return otherCharges;
        }

        public void setOtherCharges(double otherCharges) {
            this.otherCharges = otherCharges;
        }

        public Fare withOtherCharges(double otherCharges) {
            this.otherCharges = otherCharges;
            return this;
        }

        public String getAgentPreferredCurrency() {
            return agentPreferredCurrency;
        }

        public void setAgentPreferredCurrency(String agentPreferredCurrency) {
            this.agentPreferredCurrency = agentPreferredCurrency;
        }

        public Fare withAgentPreferredCurrency(String agentPreferredCurrency) {
            this.agentPreferredCurrency = agentPreferredCurrency;
            return this;
        }

        public long getServiceFee() {
            return serviceFee;
        }

        public void setServiceFee(long serviceFee) {
            this.serviceFee = serviceFee;
        }

        public Fare withServiceFee(long serviceFee) {
            this.serviceFee = serviceFee;
            return this;
        }

        public long getVat() {
            return vat;
        }

        public void setVat(long vat) {
            this.vat = vat;
        }

        public Fare withVat(long vat) {
            this.vat = vat;
            return this;
        }

        public double getBaseFare() {
            return baseFare;
        }

        public void setBaseFare(double baseFare) {
            this.baseFare = baseFare;
        }

        public Fare withBaseFare(double baseFare) {
            this.baseFare = baseFare;
            return this;
        }

        public double getTax() {
            return tax;
        }

        public void setTax(double tax) {
            this.tax = tax;
        }

        public Fare withTax(double tax) {
            this.tax = tax;
            return this;
        }

    }


    public class FareRule implements Serializable {

        private final static long serialVersionUID = 3056386508569497860L;
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
        private Object fareRuleDetail;
        @SerializedName("DepartureDate")
        @Expose
        private String departureDate;
        @SerializedName("FlightNumber")
        @Expose
        private Object flightNumber;

        /**
         * No args constructor for use in serialization
         */
        public FareRule() {
        }

        /**
         * @param fareRuleDetail
         * @param fareBasisCode
         * @param departureDate
         * @param origin
         * @param fareRestriction
         * @param flightNumber
         * @param airline
         * @param destination
         */
        public FareRule(String origin, String destination, String airline, Object fareRestriction, String fareBasisCode, Object fareRuleDetail, String departureDate, Object flightNumber) {
            super();
            this.origin = origin;
            this.destination = destination;
            this.airline = airline;
            this.fareRestriction = fareRestriction;
            this.fareBasisCode = fareBasisCode;
            this.fareRuleDetail = fareRuleDetail;
            this.departureDate = departureDate;
            this.flightNumber = flightNumber;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public FareRule withOrigin(String origin) {
            this.origin = origin;
            return this;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public FareRule withDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public String getAirline() {
            return airline;
        }

        public void setAirline(String airline) {
            this.airline = airline;
        }

        public FareRule withAirline(String airline) {
            this.airline = airline;
            return this;
        }

        public Object getFareRestriction() {
            return fareRestriction;
        }

        public void setFareRestriction(Object fareRestriction) {
            this.fareRestriction = fareRestriction;
        }

        public FareRule withFareRestriction(Object fareRestriction) {
            this.fareRestriction = fareRestriction;
            return this;
        }

        public String getFareBasisCode() {
            return fareBasisCode;
        }

        public void setFareBasisCode(String fareBasisCode) {
            this.fareBasisCode = fareBasisCode;
        }

        public FareRule withFareBasisCode(String fareBasisCode) {
            this.fareBasisCode = fareBasisCode;
            return this;
        }

        public Object getFareRuleDetail() {
            return fareRuleDetail;
        }

        public void setFareRuleDetail(Object fareRuleDetail) {
            this.fareRuleDetail = fareRuleDetail;
        }

        public FareRule withFareRuleDetail(Object fareRuleDetail) {
            this.fareRuleDetail = fareRuleDetail;
            return this;
        }

        public String getDepartureDate() {
            return departureDate;
        }

        public void setDepartureDate(String departureDate) {
            this.departureDate = departureDate;
        }

        public FareRule withDepartureDate(String departureDate) {
            this.departureDate = departureDate;
            return this;
        }

        public Object getFlightNumber() {
            return flightNumber;
        }

        public void setFlightNumber(Object flightNumber) {
            this.flightNumber = flightNumber;
        }

        public FareRule withFlightNumber(Object flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

    }


//    public class Itinerary implements Serializable {
//
//        private final static long serialVersionUID = 4713545162284606969L;
//        @SerializedName("Segments")
//        @Expose
//        private List<Segment> segments = new ArrayList<Segment>();
//        @SerializedName("Passenger")
//        @Expose
//        private List<Passenger> passenger = new ArrayList<Passenger>();
//        @SerializedName("FareRules")
//        @Expose
//        private List<FareRule> fareRules = new ArrayList<FareRule>();
//        @SerializedName("PNR")
//        @Expose
//        private String pNR;
//        @SerializedName("Destination")
//        @Expose
//        private String destination;
//        @SerializedName("LastTicketDate")
//        @Expose
//        private String lastTicketDate;
//        @SerializedName("Origin")
//        @Expose
//        private String origin;
//        @SerializedName("CreatedOn")
//        @Expose
//        private String createdOn;
//        @SerializedName("ValidatingAirlineCode")
//        @Expose
//        private String validatingAirlineCode;
//        @SerializedName("IsDomestic")
//        @Expose
//        private boolean isDomestic;
//        @SerializedName("AirlineCode")
//        @Expose
//        private Object airlineCode;
//        @SerializedName("NonRefundable")
//        @Expose
//        private boolean nonRefundable;
//        @SerializedName("IsLcc")
//        @Expose
//        private boolean isLcc;
//        @SerializedName("AirlineRemark")
//        @Expose
//        private Object airlineRemark;
//
//        /**
//         * No args constructor for use in serialization
//         */
//        public Itinerary() {
//        }
//
//        /**
//         * @param nonRefundable
//         * @param createdOn
//         * @param pNR
//         * @param passenger
//         * @param airlineCode
//         * @param isDomestic
//         * @param segments
//         * @param validatingAirlineCode
//         * @param isLcc
//         * @param origin
//         * @param lastTicketDate
//         * @param airlineRemark
//         * @param fareRules
//         * @param destination
//         */
//        public Itinerary(List<Segment> segments, List<Passenger> passenger, List<FareRule> fareRules, String pNR, String destination, String lastTicketDate, String origin, String createdOn, String validatingAirlineCode, boolean isDomestic, Object airlineCode, boolean nonRefundable, boolean isLcc, Object airlineRemark) {
//            super();
//            this.segments = segments;
//            this.passenger = passenger;
//            this.fareRules = fareRules;
//            this.pNR = pNR;
//            this.destination = destination;
//            this.lastTicketDate = lastTicketDate;
//            this.origin = origin;
//            this.createdOn = createdOn;
//            this.validatingAirlineCode = validatingAirlineCode;
//            this.isDomestic = isDomestic;
//            this.airlineCode = airlineCode;
//            this.nonRefundable = nonRefundable;
//            this.isLcc = isLcc;
//            this.airlineRemark = airlineRemark;
//        }
//
//        public List<Segment> getSegments() {
//            return segments;
//        }
//
//        public void setSegments(List<Segment> segments) {
//            this.segments = segments;
//        }
//
//        public Itinerary withSegments(List<Segment> segments) {
//            this.segments = segments;
//            return this;
//        }
//
//        public List<Passenger> getPassenger() {
//            return passenger;
//        }
//
//        public void setPassenger(List<Passenger> passenger) {
//            this.passenger = passenger;
//        }
//
//        public Itinerary withPassenger(List<Passenger> passenger) {
//            this.passenger = passenger;
//            return this;
//        }
//
//        public List<FareRule> getFareRules() {
//            return fareRules;
//        }
//
//        public void setFareRules(List<FareRule> fareRules) {
//            this.fareRules = fareRules;
//        }
//
//        public Itinerary withFareRules(List<FareRule> fareRules) {
//            this.fareRules = fareRules;
//            return this;
//        }
//
//        public String getPNR() {
//            return pNR;
//        }
//
//        public void setPNR(String pNR) {
//            this.pNR = pNR;
//        }
//
//        public Itinerary withPNR(String pNR) {
//            this.pNR = pNR;
//            return this;
//        }
//
//        public String getDestination() {
//            return destination;
//        }
//
//        public void setDestination(String destination) {
//            this.destination = destination;
//        }
//
//        public Itinerary withDestination(String destination) {
//            this.destination = destination;
//            return this;
//        }
//
//        public String getLastTicketDate() {
//            return lastTicketDate;
//        }
//
//        public void setLastTicketDate(String lastTicketDate) {
//            this.lastTicketDate = lastTicketDate;
//        }
//
//        public Itinerary withLastTicketDate(String lastTicketDate) {
//            this.lastTicketDate = lastTicketDate;
//            return this;
//        }
//
//        public String getOrigin() {
//            return origin;
//        }
//
//        public void setOrigin(String origin) {
//            this.origin = origin;
//        }
//
//        public Itinerary withOrigin(String origin) {
//            this.origin = origin;
//            return this;
//        }
//
//        public String getCreatedOn() {
//            return createdOn;
//        }
//
//        public void setCreatedOn(String createdOn) {
//            this.createdOn = createdOn;
//        }
//
//        public Itinerary withCreatedOn(String createdOn) {
//            this.createdOn = createdOn;
//            return this;
//        }
//
//        public String getValidatingAirlineCode() {
//            return validatingAirlineCode;
//        }
//
//        public void setValidatingAirlineCode(String validatingAirlineCode) {
//            this.validatingAirlineCode = validatingAirlineCode;
//        }
//
//        public Itinerary withValidatingAirlineCode(String validatingAirlineCode) {
//            this.validatingAirlineCode = validatingAirlineCode;
//            return this;
//        }
//
//        public boolean isIsDomestic() {
//            return isDomestic;
//        }
//
//        public void setIsDomestic(boolean isDomestic) {
//            this.isDomestic = isDomestic;
//        }
//
//        public Itinerary withIsDomestic(boolean isDomestic) {
//            this.isDomestic = isDomestic;
//            return this;
//        }
//
//        public Object getAirlineCode() {
//            return airlineCode;
//        }
//
//        public void setAirlineCode(Object airlineCode) {
//            this.airlineCode = airlineCode;
//        }
//
//        public Itinerary withAirlineCode(Object airlineCode) {
//            this.airlineCode = airlineCode;
//            return this;
//        }
//
//        public boolean isNonRefundable() {
//            return nonRefundable;
//        }
//
//        public void setNonRefundable(boolean nonRefundable) {
//            this.nonRefundable = nonRefundable;
//        }
//
//        public Itinerary withNonRefundable(boolean nonRefundable) {
//            this.nonRefundable = nonRefundable;
//            return this;
//        }
//
//        public boolean isIsLcc() {
//            return isLcc;
//        }
//
//        public void setIsLcc(boolean isLcc) {
//            this.isLcc = isLcc;
//        }
//
//        public Itinerary withIsLcc(boolean isLcc) {
//            this.isLcc = isLcc;
//            return this;
//        }
//
//        public Object getAirlineRemark() {
//            return airlineRemark;
//        }
//
//        public void setAirlineRemark(Object airlineRemark) {
//            this.airlineRemark = airlineRemark;
//        }
//
//        public Itinerary withAirlineRemark(Object airlineRemark) {
//            this.airlineRemark = airlineRemark;
//            return this;
//        }
//
//    }


    public class Meal implements Serializable {

        private final static long serialVersionUID = 8158345377245315832L;
        @SerializedName("Code")
        @Expose
        private Object code;
        @SerializedName("Description")
        @Expose
        private Object description;

        /**
         * No args constructor for use in serialization
         */
        public Meal() {
        }

        /**
         * @param description
         * @param code
         */
        public Meal(Object code, Object description) {
            super();
            this.code = code;
            this.description = description;
        }

        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
        }

        public Meal withCode(Object code) {
            this.code = code;
            return this;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public Meal withDescription(Object description) {
            this.description = description;
            return this;
        }

    }


    public class Nationality implements Serializable {

        private final static long serialVersionUID = -7267073150579520810L;
        @SerializedName("CountryCode")
        @Expose
        private String countryCode;
        @SerializedName("CountryName")
        @Expose
        private Object countryName;

        /**
         * No args constructor for use in serialization
         */
        public Nationality() {
        }

        /**
         * @param countryName
         * @param countryCode
         */
        public Nationality(String countryCode, Object countryName) {
            super();
            this.countryCode = countryCode;
            this.countryName = countryName;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public Nationality withCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Object getCountryName() {
            return countryName;
        }

        public void setCountryName(Object countryName) {
            this.countryName = countryName;
        }

        public Nationality withCountryName(Object countryName) {
            this.countryName = countryName;
            return this;
        }

    }


    public class Origin implements Serializable {

        private final static long serialVersionUID = -2791063053719376993L;
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
        private Object countryName;
        @SerializedName("Terminal")
        @Expose
        private String terminal;

        /**
         * No args constructor for use in serialization
         */
        public Origin() {
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
        public Origin(String airportCode, String airportName, String cityCode, String cityName, String countryCode, Object countryName, String terminal) {
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

        public Origin withAirportCode(String airportCode) {
            this.airportCode = airportCode;
            return this;
        }

        public String getAirportName() {
            return airportName;
        }

        public void setAirportName(String airportName) {
            this.airportName = airportName;
        }

        public Origin withAirportName(String airportName) {
            this.airportName = airportName;
            return this;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public Origin withCityCode(String cityCode) {
            this.cityCode = cityCode;
            return this;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public Origin withCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public Origin withCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Object getCountryName() {
            return countryName;
        }

        public void setCountryName(Object countryName) {
            this.countryName = countryName;
        }

        public Origin withCountryName(Object countryName) {
            this.countryName = countryName;
            return this;
        }

        public String getTerminal() {
            return terminal;
        }

        public void setTerminal(String terminal) {
            this.terminal = terminal;
        }

        public Origin withTerminal(String terminal) {
            this.terminal = terminal;
            return this;
        }

    }


    public class Passenger implements Serializable {

        private final static long serialVersionUID = -6009464303146934179L;
        @SerializedName("PassportIssueCountryCode")
        @Expose
        private Object passportIssueCountryCode;
        @SerializedName("PassportIssueDate")
        @Expose
        private Object passportIssueDate;
        @SerializedName("Title")
        @Expose
        private String title;
        @SerializedName("FirstName")
        @Expose
        private String firstName;
        @SerializedName("LastName")
        @Expose
        private String lastName;
        @SerializedName("Mobile1")
        @Expose
        private String mobile1;
        @SerializedName("Mobile1CountryCode")
        @Expose
        private String mobile1CountryCode;
        @SerializedName("IsLeadPax")
        @Expose
        private boolean isLeadPax;
        @SerializedName("DateOfBirth")
        @Expose
        private String dateOfBirth;
        @SerializedName("Type")
        @Expose
        private long type;
        @SerializedName("PassportNo")
        @Expose
        private String passportNo;
        @SerializedName("Nationality")
        @Expose
        private Nationality nationality;
        @SerializedName("Country")
        @Expose
        private Country country;
        @SerializedName("City")
        @Expose
        private City city;
        @SerializedName("AddressLine1")
        @Expose
        private String addressLine1;
        @SerializedName("AddressLine2")
        @Expose
        private Object addressLine2;
        @SerializedName("Gender")
        @Expose
        private long gender;
        @SerializedName("Email")
        @Expose
        private String email;
        @SerializedName("Meal")
        @Expose
        private Meal meal;
        @SerializedName("Seat")
        @Expose
        private Seat seat;
        @SerializedName("Fare")
        @Expose
        private Fare fare;
        @SerializedName("FFAirline")
        @Expose
        private Object fFAirline;
        @SerializedName("FFNumber")
        @Expose
        private Object fFNumber;
        @SerializedName("PassportExpiry")
        @Expose
        private String passportExpiry;
        @SerializedName("PaxBaggage")
        @Expose
        private List<PaxBaggage> paxBaggage = new ArrayList<PaxBaggage>();
        @SerializedName("PaxMeal")
        @Expose
        private List<PaxMeal> paxMeal = new ArrayList<PaxMeal>();
        @SerializedName("IDCardNo")
        @Expose
        private Object iDCardNo;
        @SerializedName("ZipCode")
        @Expose
        private Object zipCode;
        @SerializedName("PaxSeat")
        @Expose
        private Object paxSeat;
        @SerializedName("Ticket")
        @Expose
        private Ticket ticket;

        /**
         * No args constructor for use in serialization
         */
        public Passenger() {
        }

        /**
         * @param dateOfBirth
         * @param passportNo
         * @param fFNumber
         * @param fare
         * @param type
         * @param city
         * @param paxBaggage
         * @param title
         * @param ticket
         * @param seat
         * @param zipCode
         * @param gender
         * @param firstName
         * @param paxMeal
         * @param meal
         * @param lastName
         * @param isLeadPax
         * @param passportExpiry
         * @param paxSeat
         * @param addressLine2
         * @param addressLine1
         * @param country
         * @param fFAirline
         * @param nationality
         * @param mobile1CountryCode
         * @param email
         * @param iDCardNo
         * @param passportIssueDate
         * @param passportIssueCountryCode
         * @param mobile1
         */
        public Passenger(Object passportIssueCountryCode, Object passportIssueDate, String title, String firstName, String lastName, String mobile1, String mobile1CountryCode, boolean isLeadPax, String dateOfBirth, long type, String passportNo, Nationality nationality, Country country, City city, String addressLine1, Object addressLine2, long gender, String email, Meal meal, Seat seat, Fare fare, Object fFAirline, Object fFNumber, String passportExpiry, List<PaxBaggage> paxBaggage, List<PaxMeal> paxMeal, Object iDCardNo, Object zipCode, Object paxSeat, Ticket ticket) {
            super();
            this.passportIssueCountryCode = passportIssueCountryCode;
            this.passportIssueDate = passportIssueDate;
            this.title = title;
            this.firstName = firstName;
            this.lastName = lastName;
            this.mobile1 = mobile1;
            this.mobile1CountryCode = mobile1CountryCode;
            this.isLeadPax = isLeadPax;
            this.dateOfBirth = dateOfBirth;
            this.type = type;
            this.passportNo = passportNo;
            this.nationality = nationality;
            this.country = country;
            this.city = city;
            this.addressLine1 = addressLine1;
            this.addressLine2 = addressLine2;
            this.gender = gender;
            this.email = email;
            this.meal = meal;
            this.seat = seat;
            this.fare = fare;
            this.fFAirline = fFAirline;
            this.fFNumber = fFNumber;
            this.passportExpiry = passportExpiry;
            this.paxBaggage = paxBaggage;
            this.paxMeal = paxMeal;
            this.iDCardNo = iDCardNo;
            this.zipCode = zipCode;
            this.paxSeat = paxSeat;
            this.ticket = ticket;
        }

        public Object getPassportIssueCountryCode() {
            return passportIssueCountryCode;
        }

        public void setPassportIssueCountryCode(Object passportIssueCountryCode) {
            this.passportIssueCountryCode = passportIssueCountryCode;
        }

        public Passenger withPassportIssueCountryCode(Object passportIssueCountryCode) {
            this.passportIssueCountryCode = passportIssueCountryCode;
            return this;
        }

        public Object getPassportIssueDate() {
            return passportIssueDate;
        }

        public void setPassportIssueDate(Object passportIssueDate) {
            this.passportIssueDate = passportIssueDate;
        }

        public Passenger withPassportIssueDate(Object passportIssueDate) {
            this.passportIssueDate = passportIssueDate;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Passenger withTitle(String title) {
            this.title = title;
            return this;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public Passenger withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Passenger withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public String getMobile1() {
            return mobile1;
        }

        public void setMobile1(String mobile1) {
            this.mobile1 = mobile1;
        }

        public Passenger withMobile1(String mobile1) {
            this.mobile1 = mobile1;
            return this;
        }

        public String getMobile1CountryCode() {
            return mobile1CountryCode;
        }

        public void setMobile1CountryCode(String mobile1CountryCode) {
            this.mobile1CountryCode = mobile1CountryCode;
        }

        public Passenger withMobile1CountryCode(String mobile1CountryCode) {
            this.mobile1CountryCode = mobile1CountryCode;
            return this;
        }

        public boolean isIsLeadPax() {
            return isLeadPax;
        }

        public void setIsLeadPax(boolean isLeadPax) {
            this.isLeadPax = isLeadPax;
        }

        public Passenger withIsLeadPax(boolean isLeadPax) {
            this.isLeadPax = isLeadPax;
            return this;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public Passenger withDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public long getType() {
            return type;
        }

        public void setType(long type) {
            this.type = type;
        }

        public Passenger withType(long type) {
            this.type = type;
            return this;
        }

        public String getPassportNo() {
            return passportNo;
        }

        public void setPassportNo(String passportNo) {
            this.passportNo = passportNo;
        }

        public Passenger withPassportNo(String passportNo) {
            this.passportNo = passportNo;
            return this;
        }

        public Nationality getNationality() {
            return nationality;
        }

        public void setNationality(Nationality nationality) {
            this.nationality = nationality;
        }

        public Passenger withNationality(Nationality nationality) {
            this.nationality = nationality;
            return this;
        }

        public Country getCountry() {
            return country;
        }

        public void setCountry(Country country) {
            this.country = country;
        }

        public Passenger withCountry(Country country) {
            this.country = country;
            return this;
        }

        public City getCity() {
            return city;
        }

        public void setCity(City city) {
            this.city = city;
        }

        public Passenger withCity(City city) {
            this.city = city;
            return this;
        }

        public String getAddressLine1() {
            return addressLine1;
        }

        public void setAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
        }

        public Passenger withAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        public Object getAddressLine2() {
            return addressLine2;
        }

        public void setAddressLine2(Object addressLine2) {
            this.addressLine2 = addressLine2;
        }

        public Passenger withAddressLine2(Object addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        public long getGender() {
            return gender;
        }

        public void setGender(long gender) {
            this.gender = gender;
        }

        public Passenger withGender(long gender) {
            this.gender = gender;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Passenger withEmail(String email) {
            this.email = email;
            return this;
        }

        public Meal getMeal() {
            return meal;
        }

        public void setMeal(Meal meal) {
            this.meal = meal;
        }

        public Passenger withMeal(Meal meal) {
            this.meal = meal;
            return this;
        }

        public Seat getSeat() {
            return seat;
        }

        public void setSeat(Seat seat) {
            this.seat = seat;
        }

        public Passenger withSeat(Seat seat) {
            this.seat = seat;
            return this;
        }

        public Fare getFare() {
            return fare;
        }

        public void setFare(Fare fare) {
            this.fare = fare;
        }

        public Passenger withFare(Fare fare) {
            this.fare = fare;
            return this;
        }

        public Object getFFAirline() {
            return fFAirline;
        }

        public void setFFAirline(Object fFAirline) {
            this.fFAirline = fFAirline;
        }

        public Passenger withFFAirline(Object fFAirline) {
            this.fFAirline = fFAirline;
            return this;
        }

        public Object getFFNumber() {
            return fFNumber;
        }

        public void setFFNumber(Object fFNumber) {
            this.fFNumber = fFNumber;
        }

        public Passenger withFFNumber(Object fFNumber) {
            this.fFNumber = fFNumber;
            return this;
        }

        public String getPassportExpiry() {
            return passportExpiry;
        }

        public void setPassportExpiry(String passportExpiry) {
            this.passportExpiry = passportExpiry;
        }

        public Passenger withPassportExpiry(String passportExpiry) {
            this.passportExpiry = passportExpiry;
            return this;
        }

        public List<PaxBaggage> getPaxBaggage() {
            return paxBaggage;
        }

        public void setPaxBaggage(List<PaxBaggage> paxBaggage) {
            this.paxBaggage = paxBaggage;
        }

        public Passenger withPaxBaggage(List<PaxBaggage> paxBaggage) {
            this.paxBaggage = paxBaggage;
            return this;
        }

        public List<PaxMeal> getPaxMeal() {
            return paxMeal;
        }

        public void setPaxMeal(List<PaxMeal> paxMeal) {
            this.paxMeal = paxMeal;
        }

        public Passenger withPaxMeal(List<PaxMeal> paxMeal) {
            this.paxMeal = paxMeal;
            return this;
        }

        public Object getIDCardNo() {
            return iDCardNo;
        }

        public void setIDCardNo(Object iDCardNo) {
            this.iDCardNo = iDCardNo;
        }

        public Passenger withIDCardNo(Object iDCardNo) {
            this.iDCardNo = iDCardNo;
            return this;
        }

        public Object getZipCode() {
            return zipCode;
        }

        public void setZipCode(Object zipCode) {
            this.zipCode = zipCode;
        }

        public Passenger withZipCode(Object zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Object getPaxSeat() {
            return paxSeat;
        }

        public void setPaxSeat(Object paxSeat) {
            this.paxSeat = paxSeat;
        }

        public Passenger withPaxSeat(Object paxSeat) {
            this.paxSeat = paxSeat;
            return this;
        }

        public Ticket getTicket() {
            return ticket;
        }

        public void setTicket(Ticket ticket) {
            this.ticket = ticket;
        }

        public Passenger withTicket(Ticket ticket) {
            this.ticket = ticket;
            return this;
        }

    }


    public class PaxBaggage implements Serializable {

        private final static long serialVersionUID = 8145305319668435015L;
        @SerializedName("Code")
        @Expose
        private Object code;
        @SerializedName("Description")
        @Expose
        private long description;
        @SerializedName("Price")
        @Expose
        private long price;
        @SerializedName("Weight")
        @Expose
        private long weight;
        @SerializedName("Text")
        @Expose
        private String text;
        @SerializedName("WayTypeField")
        @Expose
        private long wayTypeField;
        @SerializedName("Origin")
        @Expose
        private String origin;
        @SerializedName("Destination")
        @Expose
        private String destination;
        @SerializedName("Currency")
        @Expose
        private Object currency;
        @SerializedName("FlightNumber")
        @Expose
        private Object flightNumber;
        @SerializedName("DepartureTime")
        @Expose
        private String departureTime;

        /**
         * No args constructor for use in serialization
         */
        public PaxBaggage() {
        }

        /**
         * @param text
         * @param wayTypeField
         * @param weight
         * @param price
         * @param description
         * @param departureTime
         * @param origin
         * @param flightNumber
         * @param code
         * @param currency
         * @param destination
         */
        public PaxBaggage(Object code, long description, long price, long weight, String text, long wayTypeField, String origin, String destination, Object currency, Object flightNumber, String departureTime) {
            super();
            this.code = code;
            this.description = description;
            this.price = price;
            this.weight = weight;
            this.text = text;
            this.wayTypeField = wayTypeField;
            this.origin = origin;
            this.destination = destination;
            this.currency = currency;
            this.flightNumber = flightNumber;
            this.departureTime = departureTime;
        }

        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
        }

        public PaxBaggage withCode(Object code) {
            this.code = code;
            return this;
        }

        public long getDescription() {
            return description;
        }

        public void setDescription(long description) {
            this.description = description;
        }

        public PaxBaggage withDescription(long description) {
            this.description = description;
            return this;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }

        public PaxBaggage withPrice(long price) {
            this.price = price;
            return this;
        }

        public long getWeight() {
            return weight;
        }

        public void setWeight(long weight) {
            this.weight = weight;
        }

        public PaxBaggage withWeight(long weight) {
            this.weight = weight;
            return this;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public PaxBaggage withText(String text) {
            this.text = text;
            return this;
        }

        public long getWayTypeField() {
            return wayTypeField;
        }

        public void setWayTypeField(long wayTypeField) {
            this.wayTypeField = wayTypeField;
        }

        public PaxBaggage withWayTypeField(long wayTypeField) {
            this.wayTypeField = wayTypeField;
            return this;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public PaxBaggage withOrigin(String origin) {
            this.origin = origin;
            return this;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public PaxBaggage withDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public Object getCurrency() {
            return currency;
        }

        public void setCurrency(Object currency) {
            this.currency = currency;
        }

        public PaxBaggage withCurrency(Object currency) {
            this.currency = currency;
            return this;
        }

        public Object getFlightNumber() {
            return flightNumber;
        }

        public void setFlightNumber(Object flightNumber) {
            this.flightNumber = flightNumber;
        }

        public PaxBaggage withFlightNumber(Object flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(String departureTime) {
            this.departureTime = departureTime;
        }

        public PaxBaggage withDepartureTime(String departureTime) {
            this.departureTime = departureTime;
            return this;
        }

    }


    public class PaxMeal implements Serializable {

        private final static long serialVersionUID = 1634261206778393707L;
        @SerializedName("Code")
        @Expose
        private Object code;
        @SerializedName("Description")
        @Expose
        private long description;
        @SerializedName("AirlineDescription")
        @Expose
        private Object airlineDescription;
        @SerializedName("Price")
        @Expose
        private long price;
        @SerializedName("Quantity")
        @Expose
        private long quantity;
        @SerializedName("Text")
        @Expose
        private String text;
        @SerializedName("Destination")
        @Expose
        private String destination;
        @SerializedName("Origin")
        @Expose
        private String origin;
        @SerializedName("WayTypeField")
        @Expose
        private long wayTypeField;
        @SerializedName("Currency")
        @Expose
        private Object currency;
        @SerializedName("FlightNumber")
        @Expose
        private Object flightNumber;
        @SerializedName("DepartureTime")
        @Expose
        private String departureTime;

        /**
         * No args constructor for use in serialization
         */
        public PaxMeal() {
        }

        /**
         * @param text
         * @param wayTypeField
         * @param price
         * @param airlineDescription
         * @param description
         * @param departureTime
         * @param origin
         * @param quantity
         * @param flightNumber
         * @param code
         * @param currency
         * @param destination
         */
        public PaxMeal(Object code, long description, Object airlineDescription, long price, long quantity, String text, String destination, String origin, long wayTypeField, Object currency, Object flightNumber, String departureTime) {
            super();
            this.code = code;
            this.description = description;
            this.airlineDescription = airlineDescription;
            this.price = price;
            this.quantity = quantity;
            this.text = text;
            this.destination = destination;
            this.origin = origin;
            this.wayTypeField = wayTypeField;
            this.currency = currency;
            this.flightNumber = flightNumber;
            this.departureTime = departureTime;
        }

        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
        }

        public PaxMeal withCode(Object code) {
            this.code = code;
            return this;
        }

        public long getDescription() {
            return description;
        }

        public void setDescription(long description) {
            this.description = description;
        }

        public PaxMeal withDescription(long description) {
            this.description = description;
            return this;
        }

        public Object getAirlineDescription() {
            return airlineDescription;
        }

        public void setAirlineDescription(Object airlineDescription) {
            this.airlineDescription = airlineDescription;
        }

        public PaxMeal withAirlineDescription(Object airlineDescription) {
            this.airlineDescription = airlineDescription;
            return this;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }

        public PaxMeal withPrice(long price) {
            this.price = price;
            return this;
        }

        public long getQuantity() {
            return quantity;
        }

        public void setQuantity(long quantity) {
            this.quantity = quantity;
        }

        public PaxMeal withQuantity(long quantity) {
            this.quantity = quantity;
            return this;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public PaxMeal withText(String text) {
            this.text = text;
            return this;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public PaxMeal withDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public PaxMeal withOrigin(String origin) {
            this.origin = origin;
            return this;
        }

        public long getWayTypeField() {
            return wayTypeField;
        }

        public void setWayTypeField(long wayTypeField) {
            this.wayTypeField = wayTypeField;
        }

        public PaxMeal withWayTypeField(long wayTypeField) {
            this.wayTypeField = wayTypeField;
            return this;
        }

        public Object getCurrency() {
            return currency;
        }

        public void setCurrency(Object currency) {
            this.currency = currency;
        }

        public PaxMeal withCurrency(Object currency) {
            this.currency = currency;
            return this;
        }

        public Object getFlightNumber() {
            return flightNumber;
        }

        public void setFlightNumber(Object flightNumber) {
            this.flightNumber = flightNumber;
        }

        public PaxMeal withFlightNumber(Object flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(String departureTime) {
            this.departureTime = departureTime;
        }

        public PaxMeal withDepartureTime(String departureTime) {
            this.departureTime = departureTime;
            return this;
        }

    }

    public class Seat implements Serializable {

        private final static long serialVersionUID = -5307939921559549726L;
        @SerializedName("Code")
        @Expose
        private Object code;
        @SerializedName("Description")
        @Expose
        private Object description;

        /**
         * No args constructor for use in serialization
         */
        public Seat() {
        }

        /**
         * @param description
         * @param code
         */
        public Seat(Object code, Object description) {
            super();
            this.code = code;
            this.description = description;
        }

        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
        }

        public Seat withCode(Object code) {
            this.code = code;
            return this;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public Seat withDescription(Object description) {
            this.description = description;
            return this;
        }

    }


    public class Segment implements Serializable {

        private final static long serialVersionUID = -6985134973764778175L;
        @SerializedName("NoOfSeatAvailable")
        @Expose
        private long noOfSeatAvailable;
        @SerializedName("OperatingCarrier")
        @Expose
        private String operatingCarrier;
        @SerializedName("SegmentIndicator")
        @Expose
        private long segmentIndicator;
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
        private boolean eTicketEligible;
        @SerializedName("Craft")
        @Expose
        private String craft;
        @SerializedName("StopOver")
        @Expose
        private boolean stopOver;
        @SerializedName("Stops")
        @Expose
        private long stops;
        @SerializedName("Mile")
        @Expose
        private long mile;
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
        private String additionalBaggage;
        @SerializedName("AirlineDetails")
        @Expose
        private AirlineDetails airlineDetails;
        @SerializedName("AirlineName")
        @Expose
        private String airlineName;

        /**
         * No args constructor for use in serialization
         */
        public Segment() {
        }

        /**
         * @param groundTime
         * @param airlineName
         * @param craft
         * @param stopOver
         * @param includedBaggage
         * @param stopPointArrivalTime
         * @param noOfSeatAvailable
         * @param flightNumber
         * @param cabinBaggage
         * @param stops
         * @param stopPointDepartureTime
         * @param mile
         * @param additionalBaggage
         * @param airline
         * @param mealType
         * @param operatingCarrier
         * @param segmentIndicator
         * @param eTicketEligible
         * @param departureTime
         * @param origin
         * @param accumulatedDuration
         * @param stopPoint
         * @param destination
         * @param bookingClass
         * @param airlineDetails
         * @param duration
         * @param arrivalTime
         */
        public Segment(long noOfSeatAvailable, String operatingCarrier, long segmentIndicator, String airline, Origin origin, Destination destination, String flightNumber, String departureTime, String arrivalTime, String bookingClass, Object mealType, boolean eTicketEligible, String craft, boolean stopOver, long stops, long mile, String duration, String groundTime, String accumulatedDuration, Object stopPoint, String stopPointArrivalTime, String stopPointDepartureTime, String includedBaggage, String cabinBaggage, String additionalBaggage, AirlineDetails airlineDetails, String airlineName) {
            super();
            this.noOfSeatAvailable = noOfSeatAvailable;
            this.operatingCarrier = operatingCarrier;
            this.segmentIndicator = segmentIndicator;
            this.airline = airline;
            this.origin = origin;
            this.destination = destination;
            this.flightNumber = flightNumber;
            this.departureTime = departureTime;
            this.arrivalTime = arrivalTime;
            this.bookingClass = bookingClass;
            this.mealType = mealType;
            this.eTicketEligible = eTicketEligible;
            this.craft = craft;
            this.stopOver = stopOver;
            this.stops = stops;
            this.mile = mile;
            this.duration = duration;
            this.groundTime = groundTime;
            this.accumulatedDuration = accumulatedDuration;
            this.stopPoint = stopPoint;
            this.stopPointArrivalTime = stopPointArrivalTime;
            this.stopPointDepartureTime = stopPointDepartureTime;
            this.includedBaggage = includedBaggage;
            this.cabinBaggage = cabinBaggage;
            this.additionalBaggage = additionalBaggage;
            this.airlineDetails = airlineDetails;
            this.airlineName = airlineName;
        }

        public long getNoOfSeatAvailable() {
            return noOfSeatAvailable;
        }

        public void setNoOfSeatAvailable(long noOfSeatAvailable) {
            this.noOfSeatAvailable = noOfSeatAvailable;
        }

        public Segment withNoOfSeatAvailable(long noOfSeatAvailable) {
            this.noOfSeatAvailable = noOfSeatAvailable;
            return this;
        }

        public String getOperatingCarrier() {
            return operatingCarrier;
        }

        public void setOperatingCarrier(String operatingCarrier) {
            this.operatingCarrier = operatingCarrier;
        }

        public Segment withOperatingCarrier(String operatingCarrier) {
            this.operatingCarrier = operatingCarrier;
            return this;
        }

        public long getSegmentIndicator() {
            return segmentIndicator;
        }

        public void setSegmentIndicator(long segmentIndicator) {
            this.segmentIndicator = segmentIndicator;
        }

        public Segment withSegmentIndicator(long segmentIndicator) {
            this.segmentIndicator = segmentIndicator;
            return this;
        }

        public String getAirline() {
            return airline;
        }

        public void setAirline(String airline) {
            this.airline = airline;
        }

        public Segment withAirline(String airline) {
            this.airline = airline;
            return this;
        }

        public Origin getOrigin() {
            return origin;
        }

        public void setOrigin(Origin origin) {
            this.origin = origin;
        }

        public Segment withOrigin(Origin origin) {
            this.origin = origin;
            return this;
        }

        public Destination getDestination() {
            return destination;
        }

        public void setDestination(Destination destination) {
            this.destination = destination;
        }

        public Segment withDestination(Destination destination) {
            this.destination = destination;
            return this;
        }

        public String getFlightNumber() {
            return flightNumber;
        }

        public void setFlightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
        }

        public Segment withFlightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(String departureTime) {
            this.departureTime = departureTime;
        }

        public Segment withDepartureTime(String departureTime) {
            this.departureTime = departureTime;
            return this;
        }

        public String getArrivalTime() {
            return arrivalTime;
        }

        public void setArrivalTime(String arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        public Segment withArrivalTime(String arrivalTime) {
            this.arrivalTime = arrivalTime;
            return this;
        }

        public String getBookingClass() {
            return bookingClass;
        }

        public void setBookingClass(String bookingClass) {
            this.bookingClass = bookingClass;
        }

        public Segment withBookingClass(String bookingClass) {
            this.bookingClass = bookingClass;
            return this;
        }

        public Object getMealType() {
            return mealType;
        }

        public void setMealType(Object mealType) {
            this.mealType = mealType;
        }

        public Segment withMealType(Object mealType) {
            this.mealType = mealType;
            return this;
        }

        public boolean isETicketEligible() {
            return eTicketEligible;
        }

        public void setETicketEligible(boolean eTicketEligible) {
            this.eTicketEligible = eTicketEligible;
        }

        public Segment withETicketEligible(boolean eTicketEligible) {
            this.eTicketEligible = eTicketEligible;
            return this;
        }

        public String getCraft() {
            return craft;
        }

        public void setCraft(String craft) {
            this.craft = craft;
        }

        public Segment withCraft(String craft) {
            this.craft = craft;
            return this;
        }

        public boolean isStopOver() {
            return stopOver;
        }

        public void setStopOver(boolean stopOver) {
            this.stopOver = stopOver;
        }

        public Segment withStopOver(boolean stopOver) {
            this.stopOver = stopOver;
            return this;
        }

        public long getStops() {
            return stops;
        }

        public void setStops(long stops) {
            this.stops = stops;
        }

        public Segment withStops(long stops) {
            this.stops = stops;
            return this;
        }

        public long getMile() {
            return mile;
        }

        public void setMile(long mile) {
            this.mile = mile;
        }

        public Segment withMile(long mile) {
            this.mile = mile;
            return this;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public Segment withDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public String getGroundTime() {
            return groundTime;
        }

        public void setGroundTime(String groundTime) {
            this.groundTime = groundTime;
        }

        public Segment withGroundTime(String groundTime) {
            this.groundTime = groundTime;
            return this;
        }

        public String getAccumulatedDuration() {
            return accumulatedDuration;
        }

        public void setAccumulatedDuration(String accumulatedDuration) {
            this.accumulatedDuration = accumulatedDuration;
        }

        public Segment withAccumulatedDuration(String accumulatedDuration) {
            this.accumulatedDuration = accumulatedDuration;
            return this;
        }

        public Object getStopPoint() {
            return stopPoint;
        }

        public void setStopPoint(Object stopPoint) {
            this.stopPoint = stopPoint;
        }

        public Segment withStopPoint(Object stopPoint) {
            this.stopPoint = stopPoint;
            return this;
        }

        public String getStopPointArrivalTime() {
            return stopPointArrivalTime;
        }

        public void setStopPointArrivalTime(String stopPointArrivalTime) {
            this.stopPointArrivalTime = stopPointArrivalTime;
        }

        public Segment withStopPointArrivalTime(String stopPointArrivalTime) {
            this.stopPointArrivalTime = stopPointArrivalTime;
            return this;
        }

        public String getStopPointDepartureTime() {
            return stopPointDepartureTime;
        }

        public void setStopPointDepartureTime(String stopPointDepartureTime) {
            this.stopPointDepartureTime = stopPointDepartureTime;
        }

        public Segment withStopPointDepartureTime(String stopPointDepartureTime) {
            this.stopPointDepartureTime = stopPointDepartureTime;
            return this;
        }

        public String getIncludedBaggage() {
            return includedBaggage;
        }

        public void setIncludedBaggage(String includedBaggage) {
            this.includedBaggage = includedBaggage;
        }

        public Segment withIncludedBaggage(String includedBaggage) {
            this.includedBaggage = includedBaggage;
            return this;
        }

        public String getCabinBaggage() {
            return cabinBaggage;
        }

        public void setCabinBaggage(String cabinBaggage) {
            this.cabinBaggage = cabinBaggage;
        }

        public Segment withCabinBaggage(String cabinBaggage) {
            this.cabinBaggage = cabinBaggage;
            return this;
        }

        public String getAdditionalBaggage() {
            return additionalBaggage;
        }

        public void setAdditionalBaggage(String additionalBaggage) {
            this.additionalBaggage = additionalBaggage;
        }

        public Segment withAdditionalBaggage(String additionalBaggage) {
            this.additionalBaggage = additionalBaggage;
            return this;
        }

        public AirlineDetails getAirlineDetails() {
            return airlineDetails;
        }

        public void setAirlineDetails(AirlineDetails airlineDetails) {
            this.airlineDetails = airlineDetails;
        }

        public Segment withAirlineDetails(AirlineDetails airlineDetails) {
            this.airlineDetails = airlineDetails;
            return this;
        }

        public String getAirlineName() {
            return airlineName;
        }

        public void setAirlineName(String airlineName) {
            this.airlineName = airlineName;
        }

        public Segment withAirlineName(String airlineName) {
            this.airlineName = airlineName;
            return this;
        }

    }


    public class Ticket implements Serializable {

        private final static long serialVersionUID = 9212607893327248880L;
        @SerializedName("TicketId")
        @Expose
        private long ticketId;
        @SerializedName("TicketNumber")
        @Expose
        private String ticketNumber;
        @SerializedName("Remarks")
        @Expose
        private String remarks;
        @SerializedName("ValidatingAriline")
        @Expose
        private String validatingAriline;
        @SerializedName("IssueDate")
        @Expose
        private String issueDate;
        @SerializedName("Status")
        @Expose
        private String status;
        @SerializedName("PtcDetail")
        @Expose
        private Object ptcDetail;

        /**
         * No args constructor for use in serialization
         */
        public Ticket() {
        }

        /**
         * @param ticketId
         * @param status
         * @param ptcDetail
         * @param issueDate
         * @param validatingAriline
         * @param remarks
         * @param ticketNumber
         */
        public Ticket(long ticketId, String ticketNumber, String remarks, String validatingAriline, String issueDate, String status, Object ptcDetail) {
            super();
            this.ticketId = ticketId;
            this.ticketNumber = ticketNumber;
            this.remarks = remarks;
            this.validatingAriline = validatingAriline;
            this.issueDate = issueDate;
            this.status = status;
            this.ptcDetail = ptcDetail;
        }

        public long getTicketId() {
            return ticketId;
        }

        public void setTicketId(long ticketId) {
            this.ticketId = ticketId;
        }

        public Ticket withTicketId(long ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public String getTicketNumber() {
            return ticketNumber;
        }

        public void setTicketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
        }

        public Ticket withTicketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
            return this;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public Ticket withRemarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public String getValidatingAriline() {
            return validatingAriline;
        }

        public void setValidatingAriline(String validatingAriline) {
            this.validatingAriline = validatingAriline;
        }

        public Ticket withValidatingAriline(String validatingAriline) {
            this.validatingAriline = validatingAriline;
            return this;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public void setIssueDate(String issueDate) {
            this.issueDate = issueDate;
        }

        public Ticket withIssueDate(String issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Ticket withStatus(String status) {
            this.status = status;
            return this;
        }

        public Object getPtcDetail() {
            return ptcDetail;
        }

        public void setPtcDetail(Object ptcDetail) {
            this.ptcDetail = ptcDetail;
        }

        public Ticket withPtcDetail(Object ptcDetail) {
            this.ptcDetail = ptcDetail;
            return this;
        }

    }
}