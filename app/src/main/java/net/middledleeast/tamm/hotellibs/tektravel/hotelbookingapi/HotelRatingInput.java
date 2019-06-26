
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelRatingInput.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HotelRatingInput"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="All"/&gt;
 *     &lt;enumeration value="OneStarOrLess"/&gt;
 *     &lt;enumeration value="TwoStarOrLess"/&gt;
 *     &lt;enumeration value="ThreeStarOrLess"/&gt;
 *     &lt;enumeration value="FourStarOrLess"/&gt;
 *     &lt;enumeration value="FiveStarOrLess"/&gt;
 *     &lt;enumeration value="OneStarOrMore"/&gt;
 *     &lt;enumeration value="TwoStarOrMore"/&gt;
 *     &lt;enumeration value="ThreeStarOrMore"/&gt;
 *     &lt;enumeration value="FourStarOrMore"/&gt;
 *     &lt;enumeration value="FiveStarOrMore"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "HotelRatingInput")
@XmlEnum
public enum HotelRatingInput {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("OneStarOrLess")
    ONE_STAR_OR_LESS("OneStarOrLess"),
    @XmlEnumValue("TwoStarOrLess")
    TWO_STAR_OR_LESS("TwoStarOrLess"),
    @XmlEnumValue("ThreeStarOrLess")
    THREE_STAR_OR_LESS("ThreeStarOrLess"),
    @XmlEnumValue("FourStarOrLess")
    FOUR_STAR_OR_LESS("FourStarOrLess"),
    @XmlEnumValue("FiveStarOrLess")
    FIVE_STAR_OR_LESS("FiveStarOrLess"),
    @XmlEnumValue("OneStarOrMore")
    ONE_STAR_OR_MORE("OneStarOrMore"),
    @XmlEnumValue("TwoStarOrMore")
    TWO_STAR_OR_MORE("TwoStarOrMore"),
    @XmlEnumValue("ThreeStarOrMore")
    THREE_STAR_OR_MORE("ThreeStarOrMore"),
    @XmlEnumValue("FourStarOrMore")
    FOUR_STAR_OR_MORE("FourStarOrMore"),
    @XmlEnumValue("FiveStarOrMore")
    FIVE_STAR_OR_MORE("FiveStarOrMore");
    private final String value;

    HotelRatingInput(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HotelRatingInput fromValue(String v) {
        for (HotelRatingInput c: HotelRatingInput.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
