package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FlightSSR implements Serializable {

    private final static long serialVersionUID = -1072483983538613179L;
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

    /**
     * No args constructor for use in serialization
     */
    public FlightSSR() {
    }

    /**
     * @param endUserBrowserAgent
     * @param tokenId
     * @param trackingId
     * @param pointOfSale
     * @param requestOrigin
     * @param resultId
     */
    public FlightSSR(String resultId, String endUserBrowserAgent, String pointOfSale, String requestOrigin, String tokenId, String trackingId) {
        super();
        this.resultId = resultId;
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

    public FlightSSR withResultId(String resultId) {
        this.resultId = resultId;
        return this;
    }

    public String getEndUserBrowserAgent() {
        return endUserBrowserAgent;
    }

    public void setEndUserBrowserAgent(String endUserBrowserAgent) {
        this.endUserBrowserAgent = endUserBrowserAgent;
    }

    public FlightSSR withEndUserBrowserAgent(String endUserBrowserAgent) {
        this.endUserBrowserAgent = endUserBrowserAgent;
        return this;
    }

    public String getPointOfSale() {
        return pointOfSale;
    }

    public void setPointOfSale(String pointOfSale) {
        this.pointOfSale = pointOfSale;
    }

    public FlightSSR withPointOfSale(String pointOfSale) {
        this.pointOfSale = pointOfSale;
        return this;
    }

    public String getRequestOrigin() {
        return requestOrigin;
    }

    public void setRequestOrigin(String requestOrigin) {
        this.requestOrigin = requestOrigin;
    }

    public FlightSSR withRequestOrigin(String requestOrigin) {
        this.requestOrigin = requestOrigin;
        return this;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public FlightSSR withTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public FlightSSR withTrackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }

}