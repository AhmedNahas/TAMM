
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PriceChange.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PriceChange"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="InformationRequired"/&gt;
 *     &lt;enumeration value="Approved"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PriceChange")
@XmlEnum
public enum PriceChange {

    @XmlEnumValue("InformationRequired")
    INFORMATION_REQUIRED("InformationRequired"),
    @XmlEnumValue("Approved")
    APPROVED("Approved");
    private final String value;

    PriceChange(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PriceChange fromValue(String v) {
        for (PriceChange c: PriceChange.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
