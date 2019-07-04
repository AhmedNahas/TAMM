package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class FareRuleResponse implements Serializable {

    private final static long serialVersionUID = 2649173938371396548L;
    @SerializedName("FareRules")
    @Expose
    private List<List<FlightApi.FareRule>> fareRules = new ArrayList<List<FlightApi.FareRule>>();
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
    public FareRuleResponse() {
    }

    /**
     * @param tokenId
     * @param errors
     * @param alerts
     * @param trackingId
     * @param isSuccess
     * @param fareRules
     */
    public FareRuleResponse(List<List<FlightApi.FareRule>> fareRules, boolean isSuccess, List<Object> errors, List<Object> alerts, String tokenId, String trackingId) {
        super();
        this.fareRules = fareRules;
        this.isSuccess = isSuccess;
        this.errors = errors;
        this.alerts = alerts;
        this.tokenId = tokenId;
        this.trackingId = trackingId;
    }

    public List<List<FlightApi.FareRule>> getFareRules() {
        return fareRules;
    }

    public void setFareRules(List<List<FlightApi.FareRule>> fareRules) {
        this.fareRules = fareRules;
    }

    public FareRuleResponse withFareRules(List<List<FlightApi.FareRule>> fareRules) {
        this.fareRules = fareRules;
        return this;
    }

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public FareRuleResponse withIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
        return this;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public FareRuleResponse withErrors(List<Object> errors) {
        this.errors = errors;
        return this;
    }

    public List<Object> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Object> alerts) {
        this.alerts = alerts;
    }

    public FareRuleResponse withAlerts(List<Object> alerts) {
        this.alerts = alerts;
        return this;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public FareRuleResponse withTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public FareRuleResponse withTrackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }

    public class FareRule implements Serializable {

        private final static long serialVersionUID = -6118510353068869875L;
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

        /**
         * No args constructor for use in serialization
         */
        public FareRule() {
        }

        /**
         * @param fareRuleDetail
         * @param fareBasisCode
         * @param origin
         * @param fareRestriction
         * @param airline
         * @param destination
         */
        public FareRule(String origin, String destination, String airline, Object fareRestriction, String fareBasisCode, String fareRuleDetail) {
            super();
            this.origin = origin;
            this.destination = destination;
            this.airline = airline;
            this.fareRestriction = fareRestriction;
            this.fareBasisCode = fareBasisCode;
            this.fareRuleDetail = fareRuleDetail;
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

    }


}