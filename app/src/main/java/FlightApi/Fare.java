
package FlightApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fare {

    @SerializedName("TotalFare")
    @Expose
    private Double totalFare;
    @SerializedName("BaseFare")
    @Expose
    private Double baseFare;
    @SerializedName("Tax")
    @Expose
    private Double tax;

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

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

}
