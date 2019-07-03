package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FareQuote implements Serializable {

    private final static long serialVersionUID = -4228729541315846298L;
    @SerializedName("ResultId")
    @Expose
    private String resultId;
    @SerializedName("IPAddress")
    @Expose
    private String iPAddress;
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

    /**
     * No args constructor for use in serialization
     */
    public FareQuote() {
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
    public FareQuote(String resultId, String iPAddress, String endUserBrowserAgent, String pointOfSale, String requestOrigin, String tokenId, String trackingId) {
        super();
        this.resultId = resultId;
        this.iPAddress = iPAddress;
        this.endUserBrowserAgent = endUserBrowserAgent;
        this.pointOfSale = pointOfSale;
        this.requestOrigin = requestOrigin;
        this.tokenId = tokenId;
        this.trackingId = trackingId;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public FareQuote withResultId(String resultId) {
        this.resultId = resultId;
        return this;
    }

    public String getIPAddress() {
        return iPAddress;
    }

    public void setIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public FareQuote withIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
        return this;
    }

    public String getEndUserBrowserAgent() {
        return endUserBrowserAgent;
    }

    public void setEndUserBrowserAgent(String endUserBrowserAgent) {
        this.endUserBrowserAgent = endUserBrowserAgent;
    }

    public FareQuote withEndUserBrowserAgent(String endUserBrowserAgent) {
        this.endUserBrowserAgent = endUserBrowserAgent;
        return this;
    }

    public String getPointOfSale() {
        return pointOfSale;
    }

    public void setPointOfSale(String pointOfSale) {
        this.pointOfSale = pointOfSale;
    }

    public FareQuote withPointOfSale(String pointOfSale) {
        this.pointOfSale = pointOfSale;
        return this;
    }

    public String getRequestOrigin() {
        return requestOrigin;
    }

    public void setRequestOrigin(String requestOrigin) {
        this.requestOrigin = requestOrigin;
    }

    public FareQuote withRequestOrigin(String requestOrigin) {
        this.requestOrigin = requestOrigin;
        return this;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public FareQuote withTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public FareQuote withTrackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }

}