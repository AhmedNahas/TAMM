
package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookFlight {

    @SerializedName("ResultId")
    @Expose
    private String resultId;
    @SerializedName("TokenId")
    @Expose
    private String tokenId;
    @SerializedName("TrackingId")
    @Expose
    private String trackingId;
    @SerializedName("Itinerary")
    @Expose
    private Itinerary itinerary;


    public String getiPAddress() {
        return iPAddress;
    }

    public void setiPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public String getEndUserBrowserAgent() {
        return endUserBrowserAgent;
    }

    public void setEndUserBrowserAgent(String endUserBrowserAgent) {
        this.endUserBrowserAgent = endUserBrowserAgent;
    }

    @SerializedName("IPAddress")
    @Expose
    private String iPAddress;
    @SerializedName("EndUserBrowserAgent")
    @Expose
    private String endUserBrowserAgent;



    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

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

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

}
