
package net.middledleeast.tamm.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountMember {

    @SerializedName("memberbody")
    @Expose
    private List<Memberbody> memberbody = null;

    public List<Memberbody> getMemberbody() {
        return memberbody;
    }

    public void setMemberbody(List<Memberbody> memberbody) {
        this.memberbody = memberbody;
    }

}
