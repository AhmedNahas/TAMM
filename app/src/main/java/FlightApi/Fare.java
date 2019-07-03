
package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Fare implements Serializable {

    private final static long serialVersionUID = 7964126857077636792L;
    @SerializedName("TotalFare")
    @Expose
    private double totalFare;
    @SerializedName("FareType")
    @Expose
    private String fareType;
    @SerializedName("AgentMarkup")
    @Expose
    private long agentMarkup;
    @SerializedName("OtherCharges")
    @Expose
    private long otherCharges;
    @SerializedName("AgentPreferredCurrency")
    @Expose
    private String agentPreferredCurrency;
    @SerializedName("ServiceFee")
    @Expose
    private long serviceFee;
    @SerializedName("Vat")
    @Expose
    private long vat;
    @SerializedName("BaseFare")
    @Expose
    private double baseFare;
    @SerializedName("Tax")
    @Expose
    private double tax;

    /**
     * No args constructor for use in serialization
     */
    public Fare() {
    }

    /**
     * @param baseFare
     * @param serviceFee
     * @param totalFare
     * @param tax
     * @param agentMarkup
     * @param agentPreferredCurrency
     * @param otherCharges
     * @param vat
     * @param fareType
     */
    public Fare(double totalFare, String fareType, long agentMarkup, long otherCharges, String agentPreferredCurrency, long serviceFee, long vat, double baseFare, double tax) {
        super();
        this.totalFare = totalFare;
        this.fareType = fareType;
        this.agentMarkup = agentMarkup;
        this.otherCharges = otherCharges;
        this.agentPreferredCurrency = agentPreferredCurrency;
        this.serviceFee = serviceFee;
        this.vat = vat;
        this.baseFare = baseFare;
        this.tax = tax;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public Fare withTotalFare(double totalFare) {
        this.totalFare = totalFare;
        return this;
    }

    public String getFareType() {
        return fareType;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    public Fare withFareType(String fareType) {
        this.fareType = fareType;
        return this;
    }

    public long getAgentMarkup() {
        return agentMarkup;
    }

    public void setAgentMarkup(long agentMarkup) {
        this.agentMarkup = agentMarkup;
    }

    public Fare withAgentMarkup(long agentMarkup) {
        this.agentMarkup = agentMarkup;
        return this;
    }

    public long getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(long otherCharges) {
        this.otherCharges = otherCharges;
    }

    public Fare withOtherCharges(long otherCharges) {
        this.otherCharges = otherCharges;
        return this;
    }

    public String getAgentPreferredCurrency() {
        return agentPreferredCurrency;
    }

    public void setAgentPreferredCurrency(String agentPreferredCurrency) {
        this.agentPreferredCurrency = agentPreferredCurrency;
    }

    public Fare withAgentPreferredCurrency(String agentPreferredCurrency) {
        this.agentPreferredCurrency = agentPreferredCurrency;
        return this;
    }

    public long getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(long serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Fare withServiceFee(long serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    public long getVat() {
        return vat;
    }

    public void setVat(long vat) {
        this.vat = vat;
    }

    public Fare withVat(long vat) {
        this.vat = vat;
        return this;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }

    public Fare withBaseFare(double baseFare) {
        this.baseFare = baseFare;
        return this;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public Fare withTax(double tax) {
        this.tax = tax;
        return this;
    }

}
