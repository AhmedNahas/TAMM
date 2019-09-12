package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FlightGetBooking implements Serializable {

    private final static long serialVersionUID = -4197815956436995607L;
    public GetBookingResponse getBookingResponse;
    @SerializedName("IPAddress")
    @Expose
    private String iPAddress;
    @SerializedName("PNR")
    @Expose
    private String pNR;

    public String getTokinId() {
        return tokinId;
    }

    public void setTokinId(String tokinId) {
        this.tokinId = tokinId;
    }

    @SerializedName("TokenId")
    @Expose
    private String tokinId;




    /**
     * No args constructor for use in serialization
     */
    public FlightGetBooking() {
        getBookingResponse = new GetBookingResponse();
    }

    /**
     * @param pNR
     * @param iPAddress
     */
    public FlightGetBooking(String iPAddress, String pNR) {
        super();
        this.iPAddress = iPAddress;
        this.pNR = pNR;
    }

    public String getIPAddress() {
        return iPAddress;
    }

    public void setIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public FlightGetBooking withIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
        return this;
    }

    public String getPNR() {
        return pNR;
    }

    public void setPNR(String pNR) {
        this.pNR = pNR;
    }

    public FlightGetBooking withPNR(String pNR) {
        this.pNR = pNR;
        return this;
    }

}