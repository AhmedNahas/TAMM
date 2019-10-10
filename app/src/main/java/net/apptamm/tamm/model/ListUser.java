
package net.apptamm.tamm.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListUser {

    @SerializedName("freeusers")
    @Expose
    private List<UserList> freeusers = null;

    public List<UserList> getFreeusers() {
        return freeusers;
    }

    public void setFreeusers(List<UserList> freeusers) {
        this.freeusers = freeusers;
    }

}
