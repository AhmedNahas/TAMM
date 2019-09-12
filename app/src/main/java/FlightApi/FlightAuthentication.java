package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FlightAuthentication {


    private final static long serialVersionUID = 8182398129840084807L;
    @SerializedName("UserName")

    private String userName;
    @SerializedName("Password")

    private String password;
    @SerializedName("BookingMode")

    private String bookingMode;
    @SerializedName("IPAddress")

    private String iPAddress;


    @SerializedName("Agency")
    @Expose
    private Agency agency;
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
    private Object trackingId;

    /**
     * No args constructor for use in serialization
     */
    public FlightAuthentication() {
    }

    /**
     * @param bookingMode
     * @param userName
     * @param iPAddress
     * @param password
     */
    public FlightAuthentication(String userName, String password, String bookingMode, String iPAddress) {
        super();
        this.userName = userName;
        this.password = password;
        this.bookingMode = bookingMode;
        this.iPAddress = iPAddress;
        this.agency = agency;
        this.isSuccess = isSuccess;
        this.errors = errors;
        this.alerts = alerts;
        this.tokenId = tokenId;
        this.trackingId = trackingId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public FlightAuthentication withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public FlightAuthentication withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getBookingMode() {
        return bookingMode;
    }

    public void setBookingMode(String bookingMode) {
        this.bookingMode = bookingMode;
    }

    public FlightAuthentication withBookingMode(String bookingMode) {
        this.bookingMode = bookingMode;
        return this;
    }

    public String getIPAddress() {
        return iPAddress;
    }

    public void setIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public FlightAuthentication withIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
        return this;
    }

    public FlightAuthentication.Agency getAgency() {
        return agency;
    }

    public void setAgency(FlightAuthentication.Agency agency) {
        this.agency = agency;
    }

    public FlightAuthentication withAgency(FlightAuthentication.Agency agency) {
        this.agency = agency;
        return this;
    }

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public FlightAuthentication withIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
        return this;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public FlightAuthentication withErrors(List<Object> errors) {
        this.errors = errors;
        return this;
    }

    public List<Object> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Object> alerts) {
        this.alerts = alerts;
    }

    public FlightAuthentication withAlerts(List<Object> alerts) {
        this.alerts = alerts;
        return this;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public FlightAuthentication withTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public Object getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(Object trackingId) {
        this.trackingId = trackingId;
    }

    public FlightAuthentication withTrackingId(Object trackingId) {
        this.trackingId = trackingId;
        return this;
    }

    public class Agency implements Serializable {

        private final static long serialVersionUID = -2339200719668579352L;
        @SerializedName("Currency")
        @Expose
        private String currency;
        @SerializedName("TotalAailableLimit")
        @Expose
        private double totalAailableLimit;

        /**
         * No args constructor for use in serialization
         */
        public Agency() {
        }

        /**
         * @param totalAailableLimit
         * @param currency
         */
        public Agency(String currency, Double totalAailableLimit) {
            super();
            this.currency = currency;
            this.totalAailableLimit = totalAailableLimit;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public FlightAuthentication.Agency withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Double getTotalAailableLimit() {
            return totalAailableLimit;
        }

        public void setTotalAailableLimit(double totalAailableLimit) {
            this.totalAailableLimit = totalAailableLimit;
        }

        public FlightAuthentication.Agency withTotalAailableLimit(double totalAailableLimit) {
            this.totalAailableLimit = totalAailableLimit;
            return this;
        }

    }
}
