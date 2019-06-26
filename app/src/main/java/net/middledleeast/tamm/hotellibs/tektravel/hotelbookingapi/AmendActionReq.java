
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmendActionReq.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AmendActionReq"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Rename"/&gt;
 *     &lt;enumeration value="Add"/&gt;
 *     &lt;enumeration value="Delete"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AmendActionReq")
@XmlEnum
public enum AmendActionReq {

    @XmlEnumValue("Rename")
    RENAME("Rename"),
    @XmlEnumValue("Add")
    ADD("Add"),
    @XmlEnumValue("Delete")
    DELETE("Delete");
    private final String value;

    AmendActionReq(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AmendActionReq fromValue(String v) {
        for (AmendActionReq c: AmendActionReq.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
