package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class FlightAuthenticationResponse implements Serializable {

    private final static long serialVersionUID = 3172626391598363177L;
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
    public FlightAuthenticationResponse() {
    }

    /**
     * @param tokenId
     * @param errors
     * @param alerts
     * @param trackingId
     * @param agency
     * @param isSuccess
     */
    public FlightAuthenticationResponse(Agency agency, boolean isSuccess, List<Object> errors, List<Object> alerts, String tokenId, Object trackingId) {
        super();
        this.agency = agency;
        this.isSuccess = isSuccess;
        this.errors = errors;
        this.alerts = alerts;
        this.tokenId = tokenId;
        this.trackingId = trackingId;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public FlightAuthenticationResponse withAgency(Agency agency) {
        this.agency = agency;
        return this;
    }

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public FlightAuthenticationResponse withIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
        return this;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public FlightAuthenticationResponse withErrors(List<Object> errors) {
        this.errors = errors;
        return this;
    }

    public List<Object> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Object> alerts) {
        this.alerts = alerts;
    }

    public FlightAuthenticationResponse withAlerts(List<Object> alerts) {
        this.alerts = alerts;
        return this;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public FlightAuthenticationResponse withTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public Object getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(Object trackingId) {
        this.trackingId = trackingId;
    }

    public FlightAuthenticationResponse withTrackingId(Object trackingId) {
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
        private long totalAailableLimit;

        /**
         * No args constructor for use in serialization
         */
        public Agency() {
        }

        /**
         * @param totalAailableLimit
         * @param currency
         */
        public Agency(String currency, long totalAailableLimit) {
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

        public Agency withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public long getTotalAailableLimit() {
            return totalAailableLimit;
        }

        public void setTotalAailableLimit(long totalAailableLimit) {
            this.totalAailableLimit = totalAailableLimit;
        }

        public Agency withTotalAailableLimit(long totalAailableLimit) {
            this.totalAailableLimit = totalAailableLimit;
            return this;
        }

    }
}