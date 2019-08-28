package net.middledleeast.tamm.model.Best;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Examble {

    @SerializedName("besthotels")
    @Expose
    private List<Besthotel> besthotels = null;

    public List<Besthotel> getBesthotels() {
        return besthotels;
    }

    public void setBesthotels(List<Besthotel> besthotels) {
        this.besthotels = besthotels;
    }

}
