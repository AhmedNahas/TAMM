
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PriceVerificationStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PriceVerificationStatus"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Successful"/&gt;
 *     &lt;enumeration value="Failed"/&gt;
 *     &lt;enumeration value="NotAvailable"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PriceVerificationStatus")
@XmlEnum
public enum PriceVerificationStatus {

    @XmlEnumValue("Successful")
    SUCCESSFUL("Successful"),
    @XmlEnumValue("Failed")
    FAILED("Failed"),
    @XmlEnumValue("NotAvailable")
    NOT_AVAILABLE("NotAvailable");
    private final String value;

    PriceVerificationStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PriceVerificationStatus fromValue(String v) {
        for (PriceVerificationStatus c: PriceVerificationStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
