
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SupplementType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SupplementType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PerStaySupplement"/&gt;
 *     &lt;enumeration value="PerPersonSupplement"/&gt;
 *     &lt;enumeration value="PerRoomSupplement"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SupplementType")
@XmlEnum
public enum SupplementType {

    @XmlEnumValue("PerStaySupplement")
    PER_STAY_SUPPLEMENT("PerStaySupplement"),
    @XmlEnumValue("PerPersonSupplement")
    PER_PERSON_SUPPLEMENT("PerPersonSupplement"),
    @XmlEnumValue("PerRoomSupplement")
    PER_ROOM_SUPPLEMENT("PerRoomSupplement");
    private final String value;

    SupplementType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SupplementType fromValue(String v) {
        for (SupplementType c: SupplementType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
