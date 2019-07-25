
package net.middledleeast.tamm.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValidationFreeRegister {


    @SerializedName("validationfree")
    @Expose
    private List<Validationfree> validationfree = null;

    public List<Validationfree> getValidationfree() {
        return validationfree;
    }

    public void setValidationfree(List<Validationfree> validationfree) {
        this.validationfree = validationfree;
    }

}
