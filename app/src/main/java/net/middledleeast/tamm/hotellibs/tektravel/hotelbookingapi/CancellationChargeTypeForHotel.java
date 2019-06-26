
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancellationChargeTypeForHotel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CancellationChargeTypeForHotel"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Fixed"/&gt;
 *     &lt;enumeration value="Percentage"/&gt;
 *     &lt;enumeration value="Night"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CancellationChargeTypeForHotel")
@XmlEnum
public enum CancellationChargeTypeForHotel {

    @XmlEnumValue("Fixed")
    FIXED("Fixed"),
    @XmlEnumValue("Percentage")
    PERCENTAGE("Percentage"),
    @XmlEnumValue("Night")
    NIGHT("Night");
    private final String value;

    CancellationChargeTypeForHotel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CancellationChargeTypeForHotel fromValue(String v) {
        for (CancellationChargeTypeForHotel c: CancellationChargeTypeForHotel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
