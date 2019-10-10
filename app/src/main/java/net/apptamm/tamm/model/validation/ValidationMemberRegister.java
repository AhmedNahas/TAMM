
package net.apptamm.tamm.model.validation;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValidationMemberRegister {

    @SerializedName("validtionmember")
    @Expose
    private List<Validtionmember> validtionmember = null;

    public List<Validtionmember> getValidtionmember() {
        return validtionmember;
    }

    public void setValidtionmember(List<Validtionmember> validtionmember) {
        this.validtionmember = validtionmember;
    }

}
