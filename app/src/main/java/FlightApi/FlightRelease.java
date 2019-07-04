package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FlightRelease implements Serializable {

    private final static long serialVersionUID = 5853059871773082685L;
    @SerializedName("PNR")
    @Expose
    private String pNR;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("Remarks")
    @Expose
    private String remarks;
    @SerializedName("TokenId")
    @Expose
    private String tokenId;
    @SerializedName("IPAddress")
    @Expose
    private String iPAddress;
    public ReleaseResponse releaseResponse;

    /**
     * No args constructor for use in serialization
     */
    public FlightRelease() {
        releaseResponse = new ReleaseResponse();
    }

    /**
     * @param pNR
     * @param lastName
     * @param tokenId
     * @param remarks
     * @param iPAddress
     */
    public FlightRelease(String pNR, String lastName, String remarks, String tokenId, String iPAddress) {
        super();
        this.pNR = pNR;
        this.lastName = lastName;
        this.remarks = remarks;
        this.tokenId = tokenId;
        this.iPAddress = iPAddress;
    }

    public String getPNR() {
        return pNR;
    }

    public void setPNR(String pNR) {
        this.pNR = pNR;
    }

    public FlightRelease withPNR(String pNR) {
        this.pNR = pNR;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public FlightRelease withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public FlightRelease withRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public FlightRelease withTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public String getIPAddress() {
        return iPAddress;
    }

    public void setIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public FlightRelease withIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
        return this;
    }

}