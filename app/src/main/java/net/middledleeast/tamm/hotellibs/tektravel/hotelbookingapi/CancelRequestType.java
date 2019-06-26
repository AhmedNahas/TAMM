
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancelRequestType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CancelRequestType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="HotelCancel"/&gt;
 *     &lt;enumeration value="CheckStatus"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CancelRequestType")
@XmlEnum
public enum CancelRequestType {

    @XmlEnumValue("HotelCancel")
    HOTEL_CANCEL("HotelCancel"),
    @XmlEnumValue("CheckStatus")
    CHECK_STATUS("CheckStatus");
    private final String value;

    CancelRequestType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CancelRequestType fromValue(String v) {
        for (CancelRequestType c: CancelRequestType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
