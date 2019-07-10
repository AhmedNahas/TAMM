
package net.middledleeast.tamm.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Text {

    @SerializedName("freeusers")
    @Expose
    private List<Freeuser> freeusers = null;

    public List<Freeuser> getFreeusers() {
        return freeusers;
    }

    public void setFreeusers(List<Freeuser> freeusers) {
        this.freeusers = freeusers;
    }

}
