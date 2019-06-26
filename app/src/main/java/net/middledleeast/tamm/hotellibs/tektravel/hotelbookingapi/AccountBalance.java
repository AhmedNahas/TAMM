
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountBalance.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccountBalance"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Sufficient"/&gt;
 *     &lt;enumeration value="InSufficient"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AccountBalance")
@XmlEnum
public enum AccountBalance {

    @XmlEnumValue("Sufficient")
    SUFFICIENT("Sufficient"),
    @XmlEnumValue("InSufficient")
    IN_SUFFICIENT("InSufficient");
    private final String value;

    AccountBalance(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccountBalance fromValue(String v) {
        for (AccountBalance c: AccountBalance.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
