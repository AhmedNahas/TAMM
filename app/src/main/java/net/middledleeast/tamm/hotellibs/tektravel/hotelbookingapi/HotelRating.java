
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelRating.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HotelRating"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="All"/&gt;
 *     &lt;enumeration value="OneStar"/&gt;
 *     &lt;enumeration value="TwoStar"/&gt;
 *     &lt;enumeration value="ThreeStar"/&gt;
 *     &lt;enumeration value="FourStar"/&gt;
 *     &lt;enumeration value="FiveStar"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "HotelRating")
@XmlEnum
public enum HotelRating {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("OneStar")
    ONE_STAR("OneStar"),
    @XmlEnumValue("TwoStar")
    TWO_STAR("TwoStar"),
    @XmlEnumValue("ThreeStar")
    THREE_STAR("ThreeStar"),
    @XmlEnumValue("FourStar")
    FOUR_STAR("FourStar"),
    @XmlEnumValue("FiveStar")
    FIVE_STAR("FiveStar");
    private final String value;

    HotelRating(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HotelRating fromValue(String v) {
        for (HotelRating c: HotelRating.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
