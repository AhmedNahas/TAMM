
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PolicyFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PolicyFormat"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Text"/&gt;
 *     &lt;enumeration value="Nodes"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PolicyFormat")
@XmlEnum
public enum PolicyFormat {

    @XmlEnumValue("Text")
    TEXT("Text"),
    @XmlEnumValue("Nodes")
    NODES("Nodes");
    private final String value;

    PolicyFormat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PolicyFormat fromValue(String v) {
        for (PolicyFormat c: PolicyFormat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
