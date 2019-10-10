
package net.apptamm.tamm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Offers {

    @SerializedName("bestofferhotels")
    @Expose
    private List<Bestofferhotel> bestofferhotels = null;

    public List<Bestofferhotel> getBestofferhotels() {
        return bestofferhotels;
    }

    public void setBestofferhotels(List<Bestofferhotel> bestofferhotels) {
        this.bestofferhotels = bestofferhotels;
    }

}
