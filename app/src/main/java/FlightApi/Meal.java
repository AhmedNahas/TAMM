
package FlightApi;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meal implements Serializable
{

    @SerializedName("Code")
    @Expose
    private Object code;
    @SerializedName("Description")
    @Expose
    private Object description;
    private final static long serialVersionUID = 5435915554787644658L;

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

}
