package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FareRule implements Serializable {

    private final static long serialVersionUID = 4845964177673056932L;
    public FareRuleResponse fareRuleResponse;
    @SerializedName("ResultId")
    @Expose
    private String resultId;
    @SerializedName("EndUserBrowserAgent")
    @Expose
    private String endUserBrowserAgent;
    @SerializedName("PointOfSale")
    @Expose
    private String pointOfSale;
    @SerializedName("RequestOrigin")
    @Expose
    private String requestOrigin;
    @SerializedName("TokenId")
    @Expose
    private String tokenId;
    @SerializedName("TrackingId")
    @Expose
    private String trackingId;
    @SerializedName("IPAddress")
    @Expose
    private String iPAddress;

    /**
     * No args constructor for use in serialization
     */
    public FareRule() {
        fareRuleResponse = new FareRuleResponse();
    }

    /**
     * @param endUserBrowserAgent
     * @param tokenId
     * @param trackingId
     * @param pointOfSale
     * @param requestOrigin
     * @param iPAddress
     * @param resultId
     */
    public FareRule(String resultId, String endUserBrowserAgent, String pointOfSale, String requestOrigin, String tokenId, String trackingId, String iPAddress) {
        super();
        this.resultId = resultId;
        this.endUserBrowserAgent = endUserBrowserAgent;
        this.pointOfSale = pointOfSale;
        this.requestOrigin = requestOrigin;
        this.tokenId = tokenId;
        this.trackingId = trackingId;
        this.iPAddress = iPAddress;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public FareRule withResultId(String resultId) {
        this.resultId = resultId;
        return this;
    }

    public String getEndUserBrowserAgent() {
        return endUserBrowserAgent;
    }

    public void setEndUserBrowserAgent(String endUserBrowserAgent) {
        this.endUserBrowserAgent = endUserBrowserAgent;
    }

    public FareRule withEndUserBrowserAgent(String endUserBrowserAgent) {
        this.endUserBrowserAgent = endUserBrowserAgent;
        return this;
    }

    public String getPointOfSale() {
        return pointOfSale;
    }

    public void setPointOfSale(String pointOfSale) {
        this.pointOfSale = pointOfSale;
    }

    public FareRule withPointOfSale(String pointOfSale) {
        this.pointOfSale = pointOfSale;
        return this;
    }

    public String getRequestOrigin() {
        return requestOrigin;
    }

    public void setRequestOrigin(String requestOrigin) {
        this.requestOrigin = requestOrigin;
    }

    public FareRule withRequestOrigin(String requestOrigin) {
        this.requestOrigin = requestOrigin;
        return this;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public FareRule withTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public FareRule withTrackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }

    public String getIPAddress() {
        return iPAddress;
    }

    public void setIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public FareRule withIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
        return this;
    }

}