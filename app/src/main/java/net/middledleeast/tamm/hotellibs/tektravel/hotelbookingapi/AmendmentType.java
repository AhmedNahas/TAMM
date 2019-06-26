
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmendmentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AmendmentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CheckStatus"/&gt;
 *     &lt;enumeration value="OfflineAmendment"/&gt;
 *     &lt;enumeration value="PriceApproved"/&gt;
 *     &lt;enumeration value="WithdrawRequest"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AmendmentType")
@XmlEnum
public enum AmendmentType {

    @XmlEnumValue("CheckStatus")
    CHECK_STATUS("CheckStatus"),
    @XmlEnumValue("OfflineAmendment")
    OFFLINE_AMENDMENT("OfflineAmendment"),
    @XmlEnumValue("PriceApproved")
    PRICE_APPROVED("PriceApproved"),
    @XmlEnumValue("WithdrawRequest")
    WITHDRAW_REQUEST("WithdrawRequest");
    private final String value;

    AmendmentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AmendmentType fromValue(String v) {
        for (AmendmentType c: AmendmentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
