
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DateActionRes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DateActionRes"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Retained"/&gt;
 *     &lt;enumeration value="Changed"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DateActionRes")
@XmlEnum
public enum DateActionRes {

    @XmlEnumValue("Retained")
    RETAINED("Retained"),
    @XmlEnumValue("Changed")
    CHANGED("Changed");
    private final String value;

    DateActionRes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DateActionRes fromValue(String v) {
        for (DateActionRes c: DateActionRes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
