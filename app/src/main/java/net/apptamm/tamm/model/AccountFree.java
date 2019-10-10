
package net.apptamm.tamm.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountFree {

    @SerializedName("freeaccount")
    @Expose
    private List<Freeaccount> freeaccount = null;

    public List<Freeaccount> getFreeaccount() {
        return freeaccount;
    }

    public void setFreeaccount(List<Freeaccount> freeaccount) {
        this.freeaccount = freeaccount;
    }

}
