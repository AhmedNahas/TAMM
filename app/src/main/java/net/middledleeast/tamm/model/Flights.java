package net.middledleeast.tamm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Flights {

    @SerializedName("bestflight")
    @Expose
    private List<Bestflight> bestflight = null;

    public List<Bestflight> getBestflight() {
        return bestflight;
    }

    public void setBestflight(List<Bestflight> bestflight) {
        this.bestflight = bestflight;
    }

}
