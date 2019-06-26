
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentModeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentModeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Limit"/&gt;
 *     &lt;enumeration value="CreditCard"/&gt;
 *     &lt;enumeration value="Fawry"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PaymentModeType")
@XmlEnum
public enum PaymentModeType {

    @XmlEnumValue("Limit")
    LIMIT("Limit"),
    @XmlEnumValue("CreditCard")
    CREDIT_CARD("CreditCard"),
    @XmlEnumValue("Fawry")
    FAWRY("Fawry");
    private final String value;

    PaymentModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentModeType fromValue(String v) {
        for (PaymentModeType c: PaymentModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
