package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class FareQuoteRespone implements Serializable {

    private final static long serialVersionUID = 2759729124741058958L;
    @SerializedName("Status")
    @Expose
    private long status;
    @SerializedName("IsPriceChanged")
    @Expose
    private boolean isPriceChanged;
    @SerializedName("Result")
    @Expose
    private List<Result> result = new ArrayList<Result>();
    @SerializedName("IsSuccess")
    @Expose
    private boolean isSuccess;
    @SerializedName("Errors")
    @Expose
    private List<Object> errors = new ArrayList<Object>();
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
    public FareQuoteRespone() {
    }

    /**
     * @param result
     * @param tokenId
     * @param errors
     * @param status
     * @param alerts
     * @param trackingId
     * @param isPriceChanged
     * @param isSuccess
     */
    public FareQuoteRespone(long status, boolean isPriceChanged, List<Result> result, boolean isSuccess, List<Object> errors, List<Object> alerts, String tokenId, String trackingId) {
        super();
        this.status = status;
        this.isPriceChanged = isPriceChanged;
        this.result = result;
        this.isSuccess = isSuccess;
        this.errors = errors;
        this.alerts = alerts;
        this.tokenId = tokenId;
        this.trackingId = trackingId;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public FareQuoteRespone withStatus(long status) {
        this.status = status;
        return this;
    }

    public boolean isIsPriceChanged() {
        return isPriceChanged;
    }

    public void setIsPriceChanged(boolean isPriceChanged) {
        this.isPriceChanged = isPriceChanged;
    }

    public FareQuoteRespone withIsPriceChanged(boolean isPriceChanged) {
        this.isPriceChanged = isPriceChanged;
        return this;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public FareQuoteRespone withResult(List<Result> result) {
        this.result = result;
        return this;
    }

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public FareQuoteRespone withIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
        return this;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public FareQuoteRespone withErrors(List<Object> errors) {
        this.errors = errors;
        return this;
    }

    public List<Object> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Object> alerts) {
        this.alerts = alerts;
    }

    public FareQuoteRespone withAlerts(List<Object> alerts) {
        this.alerts = alerts;
        return this;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public FareQuoteRespone withTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public FareQuoteRespone withTrackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }

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


//    public class Fare implements Serializable {
//
//        private final static long serialVersionUID = 5552962623498734665L;
//        @SerializedName("TotalFare")
//        @Expose
//        private double totalFare;
//        @SerializedName("FareType")
//        @Expose
//        private String fareType;
//        @SerializedName("AgentMarkup")
//        @Expose
//        private long agentMarkup;
//        @SerializedName("OtherCharges")
//        @Expose
//        private long otherCharges;
//        @SerializedName("Currency")
//        @Expose
//        private String currency;
//        @SerializedName("ServiceFee")
//        @Expose
//        private long serviceFee;
//        @SerializedName("Vat")
//        @Expose
//        private long vat;
//        @SerializedName("BaseFare")
//        @Expose
//        private double baseFare;
//        @SerializedName("Tax")
//        @Expose
//        private double tax;
//
//        /**
//         * No args constructor for use in serialization
//         */
//        public Fare() {
//        }
//
//        /**
//         * @param baseFare
//         * @param serviceFee
//         * @param totalFare
//         * @param tax
//         * @param agentMarkup
//         * @param otherCharges
//         * @param vat
//         * @param fareType
//         * @param currency
//         */
//        public Fare(double totalFare, String fareType, long agentMarkup, long otherCharges, String currency, long serviceFee, long vat, double baseFare, double tax) {
//            super();
//            this.totalFare = totalFare;
//            this.fareType = fareType;
//            this.agentMarkup = agentMarkup;
//            this.otherCharges = otherCharges;
//            this.currency = currency;
//            this.serviceFee = serviceFee;
//            this.vat = vat;
//            this.baseFare = baseFare;
//            this.tax = tax;
//        }
//
//        public double getTotalFare() {
//            return totalFare;
//        }
//
//        public void setTotalFare(double totalFare) {
//            this.totalFare = totalFare;
//        }
//
//        public Fare withTotalFare(double totalFare) {
//            this.totalFare = totalFare;
//            return this;
//        }
//
//        public String getFareType() {
//            return fareType;
//        }
//
//        public void setFareType(String fareType) {
//            this.fareType = fareType;
//        }
//
//        public Fare withFareType(String fareType) {
//            this.fareType = fareType;
//            return this;
//        }
//
//        public long getAgentMarkup() {
//            return agentMarkup;
//        }
//
//        public void setAgentMarkup(long agentMarkup) {
//            this.agentMarkup = agentMarkup;
//        }
//
//        public Fare withAgentMarkup(long agentMarkup) {
//            this.agentMarkup = agentMarkup;
//            return this;
//        }
//
//        public long getOtherCharges() {
//            return otherCharges;
//        }
//
//        public void setOtherCharges(long otherCharges) {
//            this.otherCharges = otherCharges;
//        }
//
//        public Fare withOtherCharges(long otherCharges) {
//            this.otherCharges = otherCharges;
//            return this;
//        }
//
//        public String getCurrency() {
//            return currency;
//        }
//
//        public void setCurrency(String currency) {
//            this.currency = currency;
//        }
//
//        public Fare withCurrency(String currency) {
//            this.currency = currency;
//            return this;
//        }
//
//        public long getServiceFee() {
//            return serviceFee;
//        }
//
//        public void setServiceFee(long serviceFee) {
//            this.serviceFee = serviceFee;
//        }
//
//        public Fare withServiceFee(long serviceFee) {
//            this.serviceFee = serviceFee;
//            return this;
//        }
//
//        public long getVat() {
//            return vat;
//        }
//
//        public void setVat(long vat) {
//            this.vat = vat;
//        }
//
//        public Fare withVat(long vat) {
//            this.vat = vat;
//            return this;
//        }
//
//        public double getBaseFare() {
//            return baseFare;
//        }
//
//        public void setBaseFare(double baseFare) {
//            this.baseFare = baseFare;
//        }
//
//        public Fare withBaseFare(double baseFare) {
//            this.baseFare = baseFare;
//            return this;
//        }
//
//        public double getTax() {
//            return tax;
//        }
//
//        public void setTax(double tax) {
//            this.tax = tax;
//        }
//
//        public Fare withTax(double tax) {
//            this.tax = tax;
//            return this;
//        }
//
//    }


    public class FareBreakdown implements Serializable {

        private final static long serialVersionUID = -8985501522829660571L;
        @SerializedName("Currency")
        @Expose
        private String currency;
        @SerializedName("PassengerType")
        @Expose
        private long passengerType;
        @SerializedName("PassengerCount")
        @Expose
        private long passengerCount;
        @SerializedName("TotalFare")
        @Expose
        private double totalFare;
        @SerializedName("OtherCharges")
        @Expose
        private long otherCharges;
        @SerializedName("AgentMarkup")
        @Expose
        private long agentMarkup;
        @SerializedName("ServiceFee")
        @Expose
        private long serviceFee;
        @SerializedName("BaseFare")
        @Expose
        private double baseFare;
        @SerializedName("Tax")
        @Expose
        private double tax;

        /**
         * No args constructor for use in serialization
         */
        public FareBreakdown() {
        }

        /**
         * @param baseFare
         * @param serviceFee
         * @param totalFare
         * @param tax
         * @param agentMarkup
         * @param otherCharges
         * @param passengerType
         * @param passengerCount
         * @param currency
         */
        public FareBreakdown(String currency, long passengerType, long passengerCount, double totalFare, long otherCharges, long agentMarkup, long serviceFee, double baseFare, double tax) {
            super();
            this.currency = currency;
            this.passengerType = passengerType;
            this.passengerCount = passengerCount;
            this.totalFare = totalFare;
            this.otherCharges = otherCharges;
            this.agentMarkup = agentMarkup;
            this.serviceFee = serviceFee;
            this.baseFare = baseFare;
            this.tax = tax;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public FareBreakdown withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public long getPassengerType() {
            return passengerType;
        }

        public void setPassengerType(long passengerType) {
            this.passengerType = passengerType;
        }

        public FareBreakdown withPassengerType(long passengerType) {
            this.passengerType = passengerType;
            return this;
        }

        public long getPassengerCount() {
            return passengerCount;
        }

        public void setPassengerCount(long passengerCount) {
            this.passengerCount = passengerCount;
        }

        public FareBreakdown withPassengerCount(long passengerCount) {
            this.passengerCount = passengerCount;
            return this;
        }

        public double getTotalFare() {
            return totalFare;
        }

        public void setTotalFare(double totalFare) {
            this.totalFare = totalFare;
        }

        public FareBreakdown withTotalFare(double totalFare) {
            this.totalFare = totalFare;
            return this;
        }

        public long getOtherCharges() {
            return otherCharges;
        }

        public void setOtherCharges(long otherCharges) {
            this.otherCharges = otherCharges;
        }

        public FareBreakdown withOtherCharges(long otherCharges) {
            this.otherCharges = otherCharges;
            return this;
        }

        public long getAgentMarkup() {
            return agentMarkup;
        }

        public void setAgentMarkup(long agentMarkup) {
            this.agentMarkup = agentMarkup;
        }

        public FareBreakdown withAgentMarkup(long agentMarkup) {
            this.agentMarkup = agentMarkup;
            return this;
        }

        public long getServiceFee() {
            return serviceFee;
        }

        public void setServiceFee(long serviceFee) {
            this.serviceFee = serviceFee;
        }

        public FareBreakdown withServiceFee(long serviceFee) {
            this.serviceFee = serviceFee;
            return this;
        }

        public double getBaseFare() {
            return baseFare;
        }

        public void setBaseFare(double baseFare) {
            this.baseFare = baseFare;
        }

        public FareBreakdown withBaseFare(double baseFare) {
            this.baseFare = baseFare;
            return this;
        }

        public double getTax() {
            return tax;
        }

        public void setTax(double tax) {
            this.tax = tax;
        }

        public FareBreakdown withTax(double tax) {
            this.tax = tax;
            return this;
        }

    }


    public class FareRule implements Serializable {

        private final static long serialVersionUID = 4055350676589616235L;
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
        private String fareRestriction;
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
        public FareRule(String origin, String destination, String airline, String fareRestriction, String fareBasisCode, String fareRuleDetail, String departureDate, Object flightNumber) {
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

        public String getFareRestriction() {
            return fareRestriction;
        }

        public void setFareRestriction(String fareRestriction) {
            this.fareRestriction = fareRestriction;
        }

        public FareRule withFareRestriction(String fareRestriction) {
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

        public String getFareRuleDetail() {
            return fareRuleDetail;
        }

        public void setFareRuleDetail(String fareRuleDetail) {
            this.fareRuleDetail = fareRuleDetail;
        }

        public FareRule withFareRuleDetail(String fareRuleDetail) {
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


    public class Origin implements Serializable {

        private final static long serialVersionUID = 7013690344996741397L;
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
        public Origin(String airportCode, String airportName, String cityCode, String cityName, String countryCode, String countryName, String terminal) {
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

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public Origin withCountryName(String countryName) {
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

    public class Result implements Serializable {

        private final static long serialVersionUID = -9189528326342789221L;
        @SerializedName("ResultId")
        @Expose
        private String resultId;
        @SerializedName("Origin")
        @Expose
        private String origin;
        @SerializedName("Destination")
        @Expose
        private String destination;
        @SerializedName("IsLcc")
        @Expose
        private boolean isLcc;
        @SerializedName("NonRefundable")
        @Expose
        private boolean nonRefundable;
        @SerializedName("AirlineRemark")
        @Expose
        private String airlineRemark;
        @SerializedName("Fare")
        @Expose
        private Fare fare;
        @SerializedName("FareBreakdown")
        @Expose
        private List<FareBreakdown> fareBreakdown = new ArrayList<FareBreakdown>();
        @SerializedName("LastTicketDate")
        @Expose
        private Object lastTicketDate;
        @SerializedName("TicketAdvisory")
        @Expose
        private Object ticketAdvisory;
        @SerializedName("Segments")
        @Expose
        private List<List<Segment>> segments = new ArrayList<List<Segment>>();
        @SerializedName("FareRules")
        @Expose
        private List<FareRules> fareRules = new ArrayList<FareRules>();
        @SerializedName("ValidatingAirline")
        @Expose
        private String validatingAirline;
        @SerializedName("ResponseTime")
        @Expose
        private String responseTime;
        @SerializedName("JourneyType")
        @Expose
        private long journeyType;

        /**
         * No args constructor for use in serialization
         */
        public Result() {
        }

        /**
         * @param ticketAdvisory
         * @param segments
         * @param isLcc
         * @param origin
         * @param fare
         * @param resultId
         * @param validatingAirline
         * @param journeyType
         * @param destination
         * @param nonRefundable
         * @param fareBreakdown
         * @param lastTicketDate
         * @param airlineRemark
         * @param fareRules
         * @param responseTime
         */
        public Result(String resultId, String origin, String destination, boolean isLcc, boolean nonRefundable, String airlineRemark, Fare fare, List<FareBreakdown> fareBreakdown, Object lastTicketDate, Object ticketAdvisory, List<List<Segment>> segments, List<FareRules> fareRules, String validatingAirline, String responseTime, long journeyType) {
            super();
            this.resultId = resultId;
            this.origin = origin;
            this.destination = destination;
            this.isLcc = isLcc;
            this.nonRefundable = nonRefundable;
            this.airlineRemark = airlineRemark;
            this.fare = fare;
            this.fareBreakdown = fareBreakdown;
            this.lastTicketDate = lastTicketDate;
            this.ticketAdvisory = ticketAdvisory;
            this.segments = segments;
            this.fareRules = fareRules;
            this.validatingAirline = validatingAirline;
            this.responseTime = responseTime;
            this.journeyType = journeyType;
        }

        public String getResultId() {
            return resultId;
        }

        public void setResultId(String resultId) {
            this.resultId = resultId;
        }

        public Result withResultId(String resultId) {
            this.resultId = resultId;
            return this;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public Result withOrigin(String origin) {
            this.origin = origin;
            return this;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public Result withDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public boolean isIsLcc() {
            return isLcc;
        }

        public void setIsLcc(boolean isLcc) {
            this.isLcc = isLcc;
        }

        public Result withIsLcc(boolean isLcc) {
            this.isLcc = isLcc;
            return this;
        }

        public boolean isNonRefundable() {
            return nonRefundable;
        }

        public void setNonRefundable(boolean nonRefundable) {
            this.nonRefundable = nonRefundable;
        }

        public Result withNonRefundable(boolean nonRefundable) {
            this.nonRefundable = nonRefundable;
            return this;
        }

        public String getAirlineRemark() {
            return airlineRemark;
        }

        public void setAirlineRemark(String airlineRemark) {
            this.airlineRemark = airlineRemark;
        }

        public Result withAirlineRemark(String airlineRemark) {
            this.airlineRemark = airlineRemark;
            return this;
        }

        public Fare getFare() {
            return fare;
        }

        public void setFare(Fare fare) {
            this.fare = fare;
        }

        public Result withFare(Fare fare) {
            this.fare = fare;
            return this;
        }

        public List<FareBreakdown> getFareBreakdown() {
            return fareBreakdown;
        }

        public void setFareBreakdown(List<FareBreakdown> fareBreakdown) {
            this.fareBreakdown = fareBreakdown;
        }

        public Result withFareBreakdown(List<FareBreakdown> fareBreakdown) {
            this.fareBreakdown = fareBreakdown;
            return this;
        }

        public Object getLastTicketDate() {
            return lastTicketDate;
        }

        public void setLastTicketDate(Object lastTicketDate) {
            this.lastTicketDate = lastTicketDate;
        }

        public Result withLastTicketDate(Object lastTicketDate) {
            this.lastTicketDate = lastTicketDate;
            return this;
        }

        public Object getTicketAdvisory() {
            return ticketAdvisory;
        }

        public void setTicketAdvisory(Object ticketAdvisory) {
            this.ticketAdvisory = ticketAdvisory;
        }

        public Result withTicketAdvisory(Object ticketAdvisory) {
            this.ticketAdvisory = ticketAdvisory;
            return this;
        }

        public List<List<Segment>> getSegments() {
            return segments;
        }

        public void setSegments(List<List<Segment>> segments) {
            this.segments = segments;
        }

        public Result withSegments(List<List<Segment>> segments) {
            this.segments = segments;
            return this;
        }

        public List<FareRules> getFareRules() {
            return fareRules;
        }

        public void setFareRules(List<FareRules> fareRules) {
            this.fareRules = fareRules;
        }

        public Result withFareRules(List<FareRules> fareRules) {
            this.fareRules = fareRules;
            return this;
        }

        public String getValidatingAirline() {
            return validatingAirline;
        }

        public void setValidatingAirline(String validatingAirline) {
            this.validatingAirline = validatingAirline;
        }

        public Result withValidatingAirline(String validatingAirline) {
            this.validatingAirline = validatingAirline;
            return this;
        }

        public String getResponseTime() {
            return responseTime;
        }

        public void setResponseTime(String responseTime) {
            this.responseTime = responseTime;
        }

        public Result withResponseTime(String responseTime) {
            this.responseTime = responseTime;
            return this;
        }

        public long getJourneyType() {
            return journeyType;
        }

        public void setJourneyType(long journeyType) {
            this.journeyType = journeyType;
        }

        public Result withJourneyType(long journeyType) {
            this.journeyType = journeyType;
            return this;
        }

    }

//    public class Segment  implements Serializable {
//
//        private final static long serialVersionUID = -3706154628603223748L;
//        @SerializedName("NoOfSeatAvailable")
//        @Expose
//        private long noOfSeatAvailable;
//        @SerializedName("OperatingCarrier")
//        @Expose
//        private String operatingCarrier;
//        @SerializedName("SegmentIndicator")
//        @Expose
//        private long segmentIndicator;
//        @SerializedName("Airline")
//        @Expose
//        private String airline;
//        @SerializedName("Origin")
//        @Expose
//        private Origin origin;
//        @SerializedName("Destination")
//        @Expose
//        private Destination destination;
//        @SerializedName("FlightNumber")
//        @Expose
//        private String flightNumber;
//        @SerializedName("DepartureTime")
//        @Expose
//        private String departureTime;
//        @SerializedName("ArrivalTime")
//        @Expose
//        private String arrivalTime;
//        @SerializedName("BookingClass")
//        @Expose
//        private String bookingClass;
//        @SerializedName("MealType")
//        @Expose
//        private Object mealType;
//        @SerializedName("ETicketEligible")
//        @Expose
//        private boolean eTicketEligible;
//        @SerializedName("Craft")
//        @Expose
//        private String craft;
//        @SerializedName("StopOver")
//        @Expose
//        private boolean stopOver;
//        @SerializedName("Stops")
//        @Expose
//        private long stops;
//        @SerializedName("Mile")
//        @Expose
//        private long mile;
//        @SerializedName("Duration")
//        @Expose
//        private String duration;
//        @SerializedName("GroundTime")
//        @Expose
//        private String groundTime;
//        @SerializedName("AccumulatedDuration")
//        @Expose
//        private String accumulatedDuration;
//        @SerializedName("StopPoint")
//        @Expose
//        private Object stopPoint;
//        @SerializedName("StopPointArrivalTime")
//        @Expose
//        private String stopPointArrivalTime;
//        @SerializedName("StopPointDepartureTime")
//        @Expose
//        private String stopPointDepartureTime;
//        @SerializedName("IncludedBaggage")
//        @Expose
//        private String includedBaggage;
//        @SerializedName("CabinBaggage")
//        @Expose
//        private String cabinBaggage;
//        @SerializedName("AdditionalBaggage")
//        @Expose
//        private Object additionalBaggage;
//        @SerializedName("AirlineDetails")
//        @Expose
//        private AirlineDetails airlineDetails;
//        @SerializedName("AirlineName")
//        @Expose
//        private String airlineName;
//
//        /**
//         * No args constructor for use in serialization
//         */
//        public Segment() {
//        }
//
//        /**
//         * @param groundTime
//         * @param airlineName
//         * @param craft
//         * @param stopOver
//         * @param includedBaggage
//         * @param stopPointArrivalTime
//         * @param noOfSeatAvailable
//         * @param flightNumber
//         * @param cabinBaggage
//         * @param stops
//         * @param stopPointDepartureTime
//         * @param mile
//         * @param additionalBaggage
//         * @param airline
//         * @param mealType
//         * @param operatingCarrier
//         * @param segmentIndicator
//         * @param eTicketEligible
//         * @param departureTime
//         * @param origin
//         * @param accumulatedDuration
//         * @param stopPoint
//         * @param destination
//         * @param bookingClass
//         * @param airlineDetails
//         * @param duration
//         * @param arrivalTime
//         */
//        public Segment(long noOfSeatAvailable, String operatingCarrier, long segmentIndicator, String airline, Origin origin, Destination destination, String flightNumber, String departureTime, String arrivalTime, String bookingClass, Object mealType, boolean eTicketEligible, String craft, boolean stopOver, long stops, long mile, String duration, String groundTime, String accumulatedDuration, Object stopPoint, String stopPointArrivalTime, String stopPointDepartureTime, String includedBaggage, String cabinBaggage, Object additionalBaggage, AirlineDetails airlineDetails, String airlineName) {
//            super();
//            this.noOfSeatAvailable = noOfSeatAvailable;
//            this.operatingCarrier = operatingCarrier;
//            this.segmentIndicator = segmentIndicator;
//            this.airline = airline;
//            this.origin = origin;
//            this.destination = destination;
//            this.flightNumber = flightNumber;
//            this.departureTime = departureTime;
//            this.arrivalTime = arrivalTime;
//            this.bookingClass = bookingClass;
//            this.mealType = mealType;
//            this.eTicketEligible = eTicketEligible;
//            this.craft = craft;
//            this.stopOver = stopOver;
//            this.stops = stops;
//            this.mile = mile;
//            this.duration = duration;
//            this.groundTime = groundTime;
//            this.accumulatedDuration = accumulatedDuration;
//            this.stopPoint = stopPoint;
//            this.stopPointArrivalTime = stopPointArrivalTime;
//            this.stopPointDepartureTime = stopPointDepartureTime;
//            this.includedBaggage = includedBaggage;
//            this.cabinBaggage = cabinBaggage;
//            this.additionalBaggage = additionalBaggage;
//            this.airlineDetails = airlineDetails;
//            this.airlineName = airlineName;
//        }
//
//        public long getNoOfSeatAvailable() {
//            return noOfSeatAvailable;
//        }
//
//        public void setNoOfSeatAvailable(long noOfSeatAvailable) {
//            this.noOfSeatAvailable = noOfSeatAvailable;
//        }
//
//        public Segment withNoOfSeatAvailable(long noOfSeatAvailable) {
//            this.noOfSeatAvailable = noOfSeatAvailable;
//            return this;
//        }
//
//        public String getOperatingCarrier() {
//            return operatingCarrier;
//        }
//
//        public void setOperatingCarrier(String operatingCarrier) {
//            this.operatingCarrier = operatingCarrier;
//        }
//
//        public Segment withOperatingCarrier(String operatingCarrier) {
//            this.operatingCarrier = operatingCarrier;
//            return this;
//        }
//
//        public long getSegmentIndicator() {
//            return segmentIndicator;
//        }
//
//        public void setSegmentIndicator(long segmentIndicator) {
//            this.segmentIndicator = segmentIndicator;
//        }
//
//        public Segment withSegmentIndicator(long segmentIndicator) {
//            this.segmentIndicator = segmentIndicator;
//            return this;
//        }
//
//        public String getAirline() {
//            return airline;
//        }
//
//        public void setAirline(String airline) {
//            this.airline = airline;
//        }
//
//        public Segment withAirline(String airline) {
//            this.airline = airline;
//            return this;
//        }
//
//        public Origin getOrigin() {
//            return origin;
//        }
//
//        public void setOrigin(Origin origin) {
//            this.origin = origin;
//        }
//
//        public Segment withOrigin(Origin origin) {
//            this.origin = origin;
//            return this;
//        }
//
//        public Destination getDestination() {
//            return destination;
//        }
//
//        public void setDestination(Destination destination) {
//            this.destination = destination;
//        }
//
//        public Segment withDestination(Destination destination) {
//            this.destination = destination;
//            return this;
//        }
//
//        public String getFlightNumber() {
//            return flightNumber;
//        }
//
//        public void setFlightNumber(String flightNumber) {
//            this.flightNumber = flightNumber;
//        }
//
//        public Segment withFlightNumber(String flightNumber) {
//            this.flightNumber = flightNumber;
//            return this;
//        }
//
//        public String getDepartureTime() {
//            return departureTime;
//        }
//
//        public void setDepartureTime(String departureTime) {
//            this.departureTime = departureTime;
//        }
//
//        public Segment withDepartureTime(String departureTime) {
//            this.departureTime = departureTime;
//            return this;
//        }
//
//        public String getArrivalTime() {
//            return arrivalTime;
//        }
//
//        public void setArrivalTime(String arrivalTime) {
//            this.arrivalTime = arrivalTime;
//        }
//
//        public Segment withArrivalTime(String arrivalTime) {
//            this.arrivalTime = arrivalTime;
//            return this;
//        }
//
//        public String getBookingClass() {
//            return bookingClass;
//        }
//
//        public void setBookingClass(String bookingClass) {
//            this.bookingClass = bookingClass;
//        }
//
//        public Segment withBookingClass(String bookingClass) {
//            this.bookingClass = bookingClass;
//            return this;
//        }
//
//        public Object getMealType() {
//            return mealType;
//        }
//
//        public void setMealType(Object mealType) {
//            this.mealType = mealType;
//        }
//
//        public Segment withMealType(Object mealType) {
//            this.mealType = mealType;
//            return this;
//        }
//
//        public boolean isETicketEligible() {
//            return eTicketEligible;
//        }
//
//        public void setETicketEligible(boolean eTicketEligible) {
//            this.eTicketEligible = eTicketEligible;
//        }
//
//        public Segment withETicketEligible(boolean eTicketEligible) {
//            this.eTicketEligible = eTicketEligible;
//            return this;
//        }
//
//        public String getCraft() {
//            return craft;
//        }
//
//        public void setCraft(String craft) {
//            this.craft = craft;
//        }
//
//        public Segment withCraft(String craft) {
//            this.craft = craft;
//            return this;
//        }
//
//        public boolean isStopOver() {
//            return stopOver;
//        }
//
//        public void setStopOver(boolean stopOver) {
//            this.stopOver = stopOver;
//        }
//
//        public Segment withStopOver(boolean stopOver) {
//            this.stopOver = stopOver;
//            return this;
//        }
//
//        public long getStops() {
//            return stops;
//        }
//
//        public void setStops(long stops) {
//            this.stops = stops;
//        }
//
//        public Segment withStops(long stops) {
//            this.stops = stops;
//            return this;
//        }
//
//        public long getMile() {
//            return mile;
//        }
//
//        public void setMile(long mile) {
//            this.mile = mile;
//        }
//
//        public Segment withMile(long mile) {
//            this.mile = mile;
//            return this;
//        }
//
//        public String getDuration() {
//            return duration;
//        }
//
//        public void setDuration(String duration) {
//            this.duration = duration;
//        }
//
//        public Segment withDuration(String duration) {
//            this.duration = duration;
//            return this;
//        }
//
//        public String getGroundTime() {
//            return groundTime;
//        }
//
//        public void setGroundTime(String groundTime) {
//            this.groundTime = groundTime;
//        }
//
//        public Segment withGroundTime(String groundTime) {
//            this.groundTime = groundTime;
//            return this;
//        }
//
//        public String getAccumulatedDuration() {
//            return accumulatedDuration;
//        }
//
//        public void setAccumulatedDuration(String accumulatedDuration) {
//            this.accumulatedDuration = accumulatedDuration;
//        }
//
//        public Segment withAccumulatedDuration(String accumulatedDuration) {
//            this.accumulatedDuration = accumulatedDuration;
//            return this;
//        }
//
//        public Object getStopPoint() {
//            return stopPoint;
//        }
//
//        public void setStopPoint(Object stopPoint) {
//            this.stopPoint = stopPoint;
//        }
//
//        public Segment withStopPoint(Object stopPoint) {
//            this.stopPoint = stopPoint;
//            return this;
//        }
//
//        public String getStopPointArrivalTime() {
//            return stopPointArrivalTime;
//        }
//
//        public void setStopPointArrivalTime(String stopPointArrivalTime) {
//            this.stopPointArrivalTime = stopPointArrivalTime;
//        }
//
//        public Segment withStopPointArrivalTime(String stopPointArrivalTime) {
//            this.stopPointArrivalTime = stopPointArrivalTime;
//            return this;
//        }
//
//        public String getStopPointDepartureTime() {
//            return stopPointDepartureTime;
//        }
//
//        public void setStopPointDepartureTime(String stopPointDepartureTime) {
//            this.stopPointDepartureTime = stopPointDepartureTime;
//        }
//
//        public Segment withStopPointDepartureTime(String stopPointDepartureTime) {
//            this.stopPointDepartureTime = stopPointDepartureTime;
//            return this;
//        }
//
//        public String getIncludedBaggage() {
//            return includedBaggage;
//        }
//
//        public void setIncludedBaggage(String includedBaggage) {
//            this.includedBaggage = includedBaggage;
//        }
//
//        public Segment withIncludedBaggage(String includedBaggage) {
//            this.includedBaggage = includedBaggage;
//            return this;
//        }
//
//        public String getCabinBaggage() {
//            return cabinBaggage;
//        }
//
//        public void setCabinBaggage(String cabinBaggage) {
//            this.cabinBaggage = cabinBaggage;
//        }
//
//        public Segment withCabinBaggage(String cabinBaggage) {
//            this.cabinBaggage = cabinBaggage;
//            return this;
//        }
//
//        public Object getAdditionalBaggage() {
//            return additionalBaggage;
//        }
//
//        public void setAdditionalBaggage(Object additionalBaggage) {
//            this.additionalBaggage = additionalBaggage;
//        }
//
//        public Segment withAdditionalBaggage(Object additionalBaggage) {
//            this.additionalBaggage = additionalBaggage;
//            return this;
//        }
//
//        public AirlineDetails getAirlineDetails() {
//            return airlineDetails;
//        }
//
//        public void setAirlineDetails(AirlineDetails airlineDetails) {
//            this.airlineDetails = airlineDetails;
//        }
//
//        public Segment withAirlineDetails(AirlineDetails airlineDetails) {
//            this.airlineDetails = airlineDetails;
//            return this;
//        }
//
//        public String getAirlineName() {
//            return airlineName;
//        }
//
//        public void setAirlineName(String airlineName) {
//            this.airlineName = airlineName;
//        }
//
//        public Segment withAirlineName(String airlineName) {
//            this.airlineName = airlineName;
//            return this;
//        }
//
//    }
}