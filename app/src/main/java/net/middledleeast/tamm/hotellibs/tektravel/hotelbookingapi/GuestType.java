
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuestType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GuestType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Adult"/&gt;
 *     &lt;enumeration value="Child"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "GuestType")
@XmlEnum
public enum GuestType {

    @XmlEnumValue("Adult")
    ADULT("Adult"),
    @XmlEnumValue("Child")
    CHILD("Child");
    private final String value;

    GuestType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GuestType fromValue(String v) {
        for (GuestType c: GuestType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
