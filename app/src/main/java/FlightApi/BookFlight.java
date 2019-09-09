
package FlightApi;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookFlight implements Serializable
{

    @SerializedName("ResultId")
    @Expose
    private String resultId;
    @SerializedName("TokenId")
    @Expose
    private String tokenId;
    @SerializedName("TrackingId")
    @Expose
    private String trackingId;
    @SerializedName("IPAddress")
    @Expose
    private String ipAddress;
    @SerializedName("Itinerary")
    @Expose
    private Itinerary itinerary;
    private final static long serialVersionUID = 6787855190819769375L;

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

    public void setIPAddress(String ipAddress) {

        this.ipAddress = ipAddress;

    }
}
