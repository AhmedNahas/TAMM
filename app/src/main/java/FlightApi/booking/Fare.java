
package FlightApi.booking;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fare implements Serializable
{

    @SerializedName("TotalFare")
    @Expose
    private Double totalFare;
    @SerializedName("BaseFare")
    @Expose
    private Double baseFare;
    @SerializedName("FareType")
    @Expose
    private Object fareType;
    @SerializedName("AgentMarkup")
    @Expose
    private Double agentMarkup;
    @SerializedName("OtherCharges")
    @Expose
    private Double otherCharges;
    @SerializedName("Tax")
    @Expose
    private Double tax;
    @SerializedName("AgentPreferredCurrency")
    @Expose
    private String agentPreferredCurrency;
    @SerializedName("ServiceFee")
    @Expose
    private Double serviceFee;
    private final static long serialVersionUID = -7385814073415771750L;

    public Double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(Double totalFare) {
        this.totalFare = totalFare;
    }

    public Double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(Double baseFare) {
        this.baseFare = baseFare;
    }

    public Object getFareType() {
        return fareType;
    }

    public void setFareType(Object fareType) {
        this.fareType = fareType;
    }

    public Double getAgentMarkup() {
        return agentMarkup;
    }

    public void setAgentMarkup(Double agentMarkup) {
        this.agentMarkup = agentMarkup;
    }

    public Double getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(Double otherCharges) {
        this.otherCharges = otherCharges;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getAgentPreferredCurrency() {
        return agentPreferredCurrency;
    }

    public void setAgentPreferredCurrency(String agentPreferredCurrency) {
        this.agentPreferredCurrency = agentPreferredCurrency;
    }

    public Double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Double serviceFee) {
        this.serviceFee = serviceFee;
    }

}
