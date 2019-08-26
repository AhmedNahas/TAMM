
package net.middledleeast.tamm.model.Best;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("best hotels")
    @Expose
    private List<BestHotel> bestHotels = null;

    public List<BestHotel> getBestHotels() {
        return bestHotels;
    }

    public void setBestHotels(List<BestHotel> bestHotels) {
        this.bestHotels = bestHotels;
    }

}
