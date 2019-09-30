package net.middledleeast.tamm.model;

import java.io.Serializable;

public class CountPassengerAndType implements Serializable {


    String type ;
    int count ;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CountPassengerAndType(String type, int count) {
        this.type = type;
        this.count = count;
    }

    public CountPassengerAndType() {
    }
}
