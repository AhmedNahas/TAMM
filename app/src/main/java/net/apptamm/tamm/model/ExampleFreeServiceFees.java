
package net.apptamm.tamm.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "freeservicefees"
})
public class ExampleFreeServiceFees {

    @JsonProperty("freeservicefees")
    private List<Freeservicefee> freeservicefees = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("freeservicefees")
    public List<Freeservicefee> getFreeservicefees() {
        return freeservicefees;
    }

    @JsonProperty("freeservicefees")
    public void setFreeservicefees(List<Freeservicefee> freeservicefees) {
        this.freeservicefees = freeservicefees;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
