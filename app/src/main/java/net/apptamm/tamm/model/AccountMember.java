
package net.apptamm.tamm.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountMember {

    @SerializedName("memberaccount")
    @Expose
    private List<MemberShipaccount> memberaccount = null;

    public List<MemberShipaccount> getMemberbody() {
        return memberaccount;
    }

    public void setMemberbody(List<MemberShipaccount> memberbody) {
        this.memberaccount = memberbody;
    }

}
