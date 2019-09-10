
package FlightApi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookFlightResponse {

    @SerializedName("BookingId")
    @Expose
    private String bookingId;
    @SerializedName("SSRDenied")
    @Expose
    private Boolean sSRDenied;
    @SerializedName("SSRMessage")
    @Expose
    private String sSRMessage;
    @SerializedName("PNR")
    @Expose
    private String pNR;
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("ChangeInItinerary")
    @Expose
    private Object changeInItinerary;
    @SerializedName("PaymentStatus")
    @Expose
    private Object paymentStatus;
    @SerializedName("WalletAction")
    @Expose
    private Integer walletAction;
    @SerializedName("Itinerary")
    @Expose
    private Itinerary itinerary;
    @SerializedName("IsSuccess")
    @Expose
    private Boolean isSuccess;
    @SerializedName("Errors")
    @Expose
    private List<Object> errors = null;
    @SerializedName("Alerts")
    @Expose
    private List<Object> alerts = null;
    @SerializedName("TokenId")
    @Expose
    private String tokenId;
    @SerializedName("TrackingId")
    @Expose
    private String trackingId;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Boolean getSSRDenied() {
        return sSRDenied;
    }

    public void setSSRDenied(Boolean sSRDenied) {
        this.sSRDenied = sSRDenied;
    }

    public String getSSRMessage() {
        return sSRMessage;
    }

    public void setSSRMessage(String sSRMessage) {
        this.sSRMessage = sSRMessage;
    }

    public String getPNR() {
        return pNR;
    }

    public void setPNR(String pNR) {
        this.pNR = pNR;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getChangeInItinerary() {
        return changeInItinerary;
    }

    public void setChangeInItinerary(Object changeInItinerary) {
        this.changeInItinerary = changeInItinerary;
    }

    public Object getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Object paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getWalletAction() {
        return walletAction;
    }

    public void setWalletAction(Integer walletAction) {
        this.walletAction = walletAction;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public List<Object> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Object> alerts) {
        this.alerts = alerts;
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

}
