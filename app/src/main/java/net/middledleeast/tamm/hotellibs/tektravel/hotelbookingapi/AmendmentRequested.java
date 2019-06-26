
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmendmentRequested complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmendmentRequested"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CheckIn" type="{http://TekTravel/HotelBookingApi}CheckInRes" minOccurs="0"/&gt;
 *         &lt;element name="CheckOut" type="{http://TekTravel/HotelBookingApi}CheckOutRes" minOccurs="0"/&gt;
 *         &lt;element name="Rooms" type="{http://TekTravel/HotelBookingApi}ArrayOfRoomRes" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendmentRequested", propOrder = {
    "checkIn",
    "checkOut",
    "rooms"
})
public class AmendmentRequested {

    @XmlElement(name = "CheckIn")
    protected CheckInRes checkIn;
    @XmlElement(name = "CheckOut")
    protected CheckOutRes checkOut;
    @XmlElement(name = "Rooms")
    protected ArrayOfRoomRes rooms;

    /**
     * Gets the value of the checkIn property.
     * 
     * @return
     *     possible object is
     *     {@link CheckInRes }
     *     
     */
    public CheckInRes getCheckIn() {
        return checkIn;
    }

    /**
     * Sets the value of the checkIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckInRes }
     *     
     */
    public void setCheckIn(CheckInRes value) {
        this.checkIn = value;
    }

    /**
     * Gets the value of the checkOut property.
     * 
     * @return
     *     possible object is
     *     {@link CheckOutRes }
     *     
     */
    public CheckOutRes getCheckOut() {
        return checkOut;
    }

    /**
     * Sets the value of the checkOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckOutRes }
     *     
     */
    public void setCheckOut(CheckOutRes value) {
        this.checkOut = value;
    }

    /**
     * Gets the value of the rooms property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomRes }
     *     
     */
    public ArrayOfRoomRes getRooms() {
        return rooms;
    }

    /**
     * Sets the value of the rooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomRes }
     *     
     */
    public void setRooms(ArrayOfRoomRes value) {
        this.rooms = value;
    }

}
