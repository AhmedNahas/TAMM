
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderByFilter.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OrderByFilter"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PriceAsc"/&gt;
 *     &lt;enumeration value="PriceDesc"/&gt;
 *     &lt;enumeration value="StarRatingAsc"/&gt;
 *     &lt;enumeration value="StarRatingDesc"/&gt;
 *     &lt;enumeration value="TBOPreference"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OrderByFilter")
@XmlEnum
public enum OrderByFilter {

    @XmlEnumValue("PriceAsc")
    PRICE_ASC("PriceAsc"),
    @XmlEnumValue("PriceDesc")
    PRICE_DESC("PriceDesc"),
    @XmlEnumValue("StarRatingAsc")
    STAR_RATING_ASC("StarRatingAsc"),
    @XmlEnumValue("StarRatingDesc")
    STAR_RATING_DESC("StarRatingDesc"),
    @XmlEnumValue("TBOPreference")
    TBO_PREFERENCE("TBOPreference");
    private final String value;

    OrderByFilter(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OrderByFilter fromValue(String v) {
        for (OrderByFilter c: OrderByFilter.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
