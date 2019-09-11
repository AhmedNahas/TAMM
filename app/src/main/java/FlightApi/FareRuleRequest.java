
package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareRuleRequest {

    @SerializedName("ResultId")
    @Expose
    private String resultId;
//    @SerializedName("EndUserBrowserAgent")
//    @Expose
//    private String endUserBrowserAgent;
//    @SerializedName("PointOfSale")
//    @Expose
//    private String pointOfSale;
//    @SerializedName("RequestOrigin")
//    @Expose
//    private String requestOrigin;
    @SerializedName("TokenId")
    @Expose
    private String tokenId;

    @SerializedName("TrackingId")
    @Expose
    private String trackingId;
//    @SerializedName("IPAddress")
//    @Expose
//    private String iPAddress;

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

//    public String getEndUserBrowserAgent() {
//        return endUserBrowserAgent;
//    }

//    public void setEndUserBrowserAgent(String endUserBrowserAgent) {
//        this.endUserBrowserAgent = endUserBrowserAgent;
//    }

//    public String getPointOfSale() {
//        return pointOfSale;
//    }

//    public void setPointOfSale(String pointOfSale) {
//        this.pointOfSale = pointOfSale;
//    }

//    public String getRequestOrigin() {
//        return requestOrigin;
//    }

//    public void setRequestOrigin(String requestOrigin) {
//        this.requestOrigin = requestOrigin;
//    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

//    public String getIPAddress() {
//        return iPAddress;
//    }

//    public void setIPAddress(String iPAddress) {
//        this.iPAddress = iPAddress;
//    }

}
