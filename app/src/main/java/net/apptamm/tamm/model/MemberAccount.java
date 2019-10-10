
package net.apptamm.tamm.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberAccount {

    @SerializedName("paymentusers")
    @Expose
    private List<Paymentuser> paymentusers = null;


    public List<Paymentuser> getPaymentusers() {
        return paymentusers;
    }

    public void setPaymentusers(List<Paymentuser> paymentusers) {
        this.paymentusers = paymentusers;
    }

}
