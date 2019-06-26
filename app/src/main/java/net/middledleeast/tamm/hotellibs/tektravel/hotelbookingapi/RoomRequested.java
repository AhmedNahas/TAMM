
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoomRequested.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoomRequested"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="FirstRoom"/&gt;
 *     &lt;enumeration value="SecondRoom"/&gt;
 *     &lt;enumeration value="ThirdRoom"/&gt;
 *     &lt;enumeration value="FourthRoom"/&gt;
 *     &lt;enumeration value="FifthRoom"/&gt;
 *     &lt;enumeration value="SixthRoom"/&gt;
 *     &lt;enumeration value="SeventhRoom"/&gt;
 *     &lt;enumeration value="EighthRoom"/&gt;
 *     &lt;enumeration value="NinthRoom"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoomRequested")
@XmlEnum
public enum RoomRequested {

    @XmlEnumValue("FirstRoom")
    FIRST_ROOM("FirstRoom"),
    @XmlEnumValue("SecondRoom")
    SECOND_ROOM("SecondRoom"),
    @XmlEnumValue("ThirdRoom")
    THIRD_ROOM("ThirdRoom"),
    @XmlEnumValue("FourthRoom")
    FOURTH_ROOM("FourthRoom"),
    @XmlEnumValue("FifthRoom")
    FIFTH_ROOM("FifthRoom"),
    @XmlEnumValue("SixthRoom")
    SIXTH_ROOM("SixthRoom"),
    @XmlEnumValue("SeventhRoom")
    SEVENTH_ROOM("SeventhRoom"),
    @XmlEnumValue("EighthRoom")
    EIGHTH_ROOM("EighthRoom"),
    @XmlEnumValue("NinthRoom")
    NINTH_ROOM("NinthRoom");
    private final String value;

    RoomRequested(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoomRequested fromValue(String v) {
        for (RoomRequested c: RoomRequested.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
