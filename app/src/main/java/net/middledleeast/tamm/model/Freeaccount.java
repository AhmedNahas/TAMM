
package net.middledleeast.tamm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Freeaccount {

    @SerializedName("freebody")
    @Expose
    private String freebody;

    public String getFreebody() {
        return freebody;
    }

    public void setFreebody(String freebody) {
        this.freebody = freebody;
    }

}
