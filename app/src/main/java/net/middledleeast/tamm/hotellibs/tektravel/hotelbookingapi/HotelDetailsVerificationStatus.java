
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelDetailsVerificationStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HotelDetailsVerificationStatus"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Successful"/&gt;
 *     &lt;enumeration value="Failed"/&gt;
 *     &lt;enumeration value="NotApplicable"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "HotelDetailsVerificationStatus")
@XmlEnum
public enum HotelDetailsVerificationStatus {

    @XmlEnumValue("Successful")
    SUCCESSFUL("Successful"),
    @XmlEnumValue("Failed")
    FAILED("Failed"),
    @XmlEnumValue("NotApplicable")
    NOT_APPLICABLE("NotApplicable");
    private final String value;

    HotelDetailsVerificationStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HotelDetailsVerificationStatus fromValue(String v) {
        for (HotelDetailsVerificationStatus c: HotelDetailsVerificationStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
