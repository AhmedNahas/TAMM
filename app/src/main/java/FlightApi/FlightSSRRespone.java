package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class FlightSSRRespone implements Serializable {

    private final static long serialVersionUID = -1643246149024222182L;
    @SerializedName("BaggageList")
    @Expose
    private BaggageList baggageList;
    @SerializedName("MealDynamicList")
    @Expose
    private MealDynamicList mealDynamicList;
    @SerializedName("SeatDynamicList")
    @Expose
    private Object seatDynamicList;
    @SerializedName("SeatList")
    @Expose
    private SeatList seatList;
    @SerializedName("MealList")
    @Expose
    private MealList mealList;
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
    public FlightSSRRespone() {
    }

    /**
     * @param mealDynamicList
     * @param tokenId
     * @param errors
     * @param mealList
     * @param baggageList
     * @param alerts
     * @param trackingId
     * @param seatList
     * @param isSuccess
     * @param seatDynamicList
     */
    public FlightSSRRespone(BaggageList baggageList, MealDynamicList mealDynamicList, Object seatDynamicList, SeatList seatList, MealList mealList, boolean isSuccess, List<Object> errors, List<Object> alerts, String tokenId, String trackingId) {
        super();
        this.baggageList = baggageList;
        this.mealDynamicList = mealDynamicList;
        this.seatDynamicList = seatDynamicList;
        this.seatList = seatList;
        this.mealList = mealList;
        this.isSuccess = isSuccess;
        this.errors = errors;
        this.alerts = alerts;
        this.tokenId = tokenId;
        this.trackingId = trackingId;
    }

    public BaggageList getBaggageList() {
        return baggageList;
    }

    public void setBaggageList(BaggageList baggageList) {
        this.baggageList = baggageList;
    }

    public FlightSSRRespone withBaggageList(BaggageList baggageList) {
        this.baggageList = baggageList;
        return this;
    }

    public MealDynamicList getMealDynamicList() {
        return mealDynamicList;
    }

    public void setMealDynamicList(MealDynamicList mealDynamicList) {
        this.mealDynamicList = mealDynamicList;
    }

    public FlightSSRRespone withMealDynamicList(MealDynamicList mealDynamicList) {
        this.mealDynamicList = mealDynamicList;
        return this;
    }

    public Object getSeatDynamicList() {
        return seatDynamicList;
    }

    public void setSeatDynamicList(Object seatDynamicList) {
        this.seatDynamicList = seatDynamicList;
    }

    public FlightSSRRespone withSeatDynamicList(Object seatDynamicList) {
        this.seatDynamicList = seatDynamicList;
        return this;
    }

    public SeatList getSeatList() {
        return seatList;
    }

    public void setSeatList(SeatList seatList) {
        this.seatList = seatList;
    }

    public FlightSSRRespone withSeatList(SeatList seatList) {
        this.seatList = seatList;
        return this;
    }

    public MealList getMealList() {
        return mealList;
    }

    public void setMealList(MealList mealList) {
        this.mealList = mealList;
    }

    public FlightSSRRespone withMealList(MealList mealList) {
        this.mealList = mealList;
        return this;
    }

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public FlightSSRRespone withIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
        return this;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public FlightSSRRespone withErrors(List<Object> errors) {
        this.errors = errors;
        return this;
    }

    public List<Object> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Object> alerts) {
        this.alerts = alerts;
    }

    public FlightSSRRespone withAlerts(List<Object> alerts) {
        this.alerts = alerts;
        return this;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public FlightSSRRespone withTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public FlightSSRRespone withTrackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }


    public class BaggageList implements Serializable {

        private final static long serialVersionUID = 5272492400079091439L;
        @SerializedName("OutWard")
        @Expose
        private List<OutWard> outWard = new ArrayList<OutWard>();

        /**
         * No args constructor for use in serialization
         */
        public BaggageList() {
        }

        /**
         * @param outWard
         */
        public BaggageList(List<OutWard> outWard) {
            super();
            this.outWard = outWard;
        }

        public List<OutWard> getOutWard() {
            return outWard;
        }

        public void setOutWard(List<OutWard> outWard) {
            this.outWard = outWard;
        }

        public BaggageList withOutWard(List<OutWard> outWard) {
            this.outWard = outWard;
            return this;
        }

    }


    public class MealDynamicList implements Serializable {

        private final static long serialVersionUID = -4942403185913447239L;
        @SerializedName("OutWard")
        @Expose
        private List<OutWard_> outWard = new ArrayList<OutWard_>();

        /**
         * No args constructor for use in serialization
         */
        public MealDynamicList() {
        }

        /**
         * @param outWard
         */
        public MealDynamicList(List<OutWard_> outWard) {
            super();
            this.outWard = outWard;
        }

        public List<OutWard_> getOutWard() {
            return outWard;
        }

        public void setOutWard(List<OutWard_> outWard) {
            this.outWard = outWard;
        }

        public MealDynamicList withOutWard(List<OutWard_> outWard) {
            this.outWard = outWard;
            return this;
        }

    }


    public class MealList implements Serializable {

        private final static long serialVersionUID = 4845262959192681965L;
        @SerializedName("OutWard")
        @Expose
        private List<OutWard__> outWard = new ArrayList<OutWard__>();

        /**
         * No args constructor for use in serialization
         */
        public MealList() {
        }

        /**
         * @param outWard
         */
        public MealList(List<OutWard__> outWard) {
            super();
            this.outWard = outWard;
        }

        public List<OutWard__> getOutWard() {
            return outWard;
        }

        public void setOutWard(List<OutWard__> outWard) {
            this.outWard = outWard;
        }

        public MealList withOutWard(List<OutWard__> outWard) {
            this.outWard = outWard;
            return this;
        }

    }


    public class OutWard implements Serializable {

        private final static long serialVersionUID = 5630281411759539793L;
        @SerializedName("Code")
        @Expose
        private String code;
        @SerializedName("Description")
        @Expose
        private long description;
        @SerializedName("Price")
        @Expose
        private double price;
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
        private String currency;
        @SerializedName("FlightNumber")
        @Expose
        private String flightNumber;
        @SerializedName("DepartureTime")
        @Expose
        private String departureTime;

        /**
         * No args constructor for use in serialization
         */
        public OutWard() {
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
        public OutWard(String code, long description, double price, long weight, String text, long wayTypeField, String origin, String destination, String currency, String flightNumber, String departureTime) {
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

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public OutWard withCode(String code) {
            this.code = code;
            return this;
        }

        public long getDescription() {
            return description;
        }

        public void setDescription(long description) {
            this.description = description;
        }

        public OutWard withDescription(long description) {
            this.description = description;
            return this;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public OutWard withPrice(double price) {
            this.price = price;
            return this;
        }

        public long getWeight() {
            return weight;
        }

        public void setWeight(long weight) {
            this.weight = weight;
        }

        public OutWard withWeight(long weight) {
            this.weight = weight;
            return this;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public OutWard withText(String text) {
            this.text = text;
            return this;
        }

        public long getWayTypeField() {
            return wayTypeField;
        }

        public void setWayTypeField(long wayTypeField) {
            this.wayTypeField = wayTypeField;
        }

        public OutWard withWayTypeField(long wayTypeField) {
            this.wayTypeField = wayTypeField;
            return this;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public OutWard withOrigin(String origin) {
            this.origin = origin;
            return this;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public OutWard withDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public OutWard withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public String getFlightNumber() {
            return flightNumber;
        }

        public void setFlightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
        }

        public OutWard withFlightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(String departureTime) {
            this.departureTime = departureTime;
        }

        public OutWard withDepartureTime(String departureTime) {
            this.departureTime = departureTime;
            return this;
        }

    }


    public class OutWard_ implements Serializable {

        private final static long serialVersionUID = 3816640757338052292L;
        @SerializedName("Code")
        @Expose
        private String code;
        @SerializedName("Description")
        @Expose
        private long description;
        @SerializedName("AirlineDescription")
        @Expose
        private String airlineDescription;
        @SerializedName("Price")
        @Expose
        private double price;
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
        private String currency;
        @SerializedName("FlightNumber")
        @Expose
        private String flightNumber;
        @SerializedName("DepartureTime")
        @Expose
        private String departureTime;

        /**
         * No args constructor for use in serialization
         */
        public OutWard_() {
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
        public OutWard_(String code, long description, String airlineDescription, double price, long quantity, String text, String destination, String origin, long wayTypeField, String currency, String flightNumber, String departureTime) {
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

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public OutWard_ withCode(String code) {
            this.code = code;
            return this;
        }

        public long getDescription() {
            return description;
        }

        public void setDescription(long description) {
            this.description = description;
        }

        public OutWard_ withDescription(long description) {
            this.description = description;
            return this;
        }

        public String getAirlineDescription() {
            return airlineDescription;
        }

        public void setAirlineDescription(String airlineDescription) {
            this.airlineDescription = airlineDescription;
        }

        public OutWard_ withAirlineDescription(String airlineDescription) {
            this.airlineDescription = airlineDescription;
            return this;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public OutWard_ withPrice(double price) {
            this.price = price;
            return this;
        }

        public long getQuantity() {
            return quantity;
        }

        public void setQuantity(long quantity) {
            this.quantity = quantity;
        }

        public OutWard_ withQuantity(long quantity) {
            this.quantity = quantity;
            return this;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public OutWard_ withText(String text) {
            this.text = text;
            return this;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public OutWard_ withDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public OutWard_ withOrigin(String origin) {
            this.origin = origin;
            return this;
        }

        public long getWayTypeField() {
            return wayTypeField;
        }

        public void setWayTypeField(long wayTypeField) {
            this.wayTypeField = wayTypeField;
        }

        public OutWard_ withWayTypeField(long wayTypeField) {
            this.wayTypeField = wayTypeField;
            return this;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public OutWard_ withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public String getFlightNumber() {
            return flightNumber;
        }

        public void setFlightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
        }

        public OutWard_ withFlightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(String departureTime) {
            this.departureTime = departureTime;
        }

        public OutWard_ withDepartureTime(String departureTime) {
            this.departureTime = departureTime;
            return this;
        }

    }


    public class OutWard__ implements Serializable {

        private final static long serialVersionUID = 8059715890874141299L;
        @SerializedName("Code")
        @Expose
        private String code;
        @SerializedName("Description")
        @Expose
        private String description;

        /**
         * No args constructor for use in serialization
         */
        public OutWard__() {
        }

        /**
         * @param description
         * @param code
         */
        public OutWard__(String code, String description) {
            super();
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public OutWard__ withCode(String code) {
            this.code = code;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public OutWard__ withDescription(String description) {
            this.description = description;
            return this;
        }

    }


    public class SeatList implements Serializable {

        private final static long serialVersionUID = -3811744888343206421L;

    }
}