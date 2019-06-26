
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SupmtChargeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SupmtChargeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Included"/&gt;
 *     &lt;enumeration value="Addition"/&gt;
 *     &lt;enumeration value="AtProperty"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SupmtChargeType")
@XmlEnum
public enum SupmtChargeType {

    @XmlEnumValue("Included")
    INCLUDED("Included"),
    @XmlEnumValue("Addition")
    ADDITION("Addition"),
    @XmlEnumValue("AtProperty")
    AT_PROPERTY("AtProperty");
    private final String value;

    SupmtChargeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SupmtChargeType fromValue(String v) {
        for (SupmtChargeType c: SupmtChargeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
