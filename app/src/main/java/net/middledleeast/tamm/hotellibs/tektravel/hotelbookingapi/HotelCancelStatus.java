
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelCancelStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HotelCancelStatus"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="UnProcessed"/&gt;
 *     &lt;enumeration value="Pending"/&gt;
 *     &lt;enumeration value="InProgress"/&gt;
 *     &lt;enumeration value="Processed"/&gt;
 *     &lt;enumeration value="Rejected"/&gt;
 *     &lt;enumeration value="RefundAwaited"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "HotelCancelStatus")
@XmlEnum
public enum HotelCancelStatus {

    @XmlEnumValue("UnProcessed")
    UN_PROCESSED("UnProcessed"),
    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("InProgress")
    IN_PROGRESS("InProgress"),
    @XmlEnumValue("Processed")
    PROCESSED("Processed"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("RefundAwaited")
    REFUND_AWAITED("RefundAwaited");
    private final String value;

    HotelCancelStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HotelCancelStatus fromValue(String v) {
        for (HotelCancelStatus c: HotelCancelStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
