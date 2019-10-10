package net.apptamm.tamm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TammFamilyModel {

    @SerializedName("Msgbody")
    @Expose
    private String msgbody;

    public String getMsgbody() {
        return msgbody;
    }

    public void setMsgbody(String msgbody) {
        this.msgbody = msgbody;
    }
}
