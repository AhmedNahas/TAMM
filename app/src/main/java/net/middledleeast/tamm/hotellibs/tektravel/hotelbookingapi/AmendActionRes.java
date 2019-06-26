
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmendActionRes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AmendActionRes"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Retained"/&gt;
 *     &lt;enumeration value="Added"/&gt;
 *     &lt;enumeration value="Deleted"/&gt;
 *     &lt;enumeration value="Renamed"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AmendActionRes")
@XmlEnum
public enum AmendActionRes {

    @XmlEnumValue("Retained")
    RETAINED("Retained"),
    @XmlEnumValue("Added")
    ADDED("Added"),
    @XmlEnumValue("Deleted")
    DELETED("Deleted"),
    @XmlEnumValue("Renamed")
    RENAMED("Renamed");
    private final String value;

    AmendActionRes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AmendActionRes fromValue(String v) {
        for (AmendActionRes c: AmendActionRes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
