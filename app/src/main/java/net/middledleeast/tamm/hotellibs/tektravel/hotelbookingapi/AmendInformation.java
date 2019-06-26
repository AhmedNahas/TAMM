
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmendInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmendInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CheckIn" type="{http://TekTravel/HotelBookingApi}CheckInReq" minOccurs="0"/&gt;
 *         &lt;element name="CheckOut" type="{http://TekTravel/HotelBookingApi}CheckOutReq" minOccurs="0"/&gt;
 *         &lt;element name="Rooms" type="{http://TekTravel/HotelBookingApi}ArrayOfRoomReq" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendInformation", propOrder = {
    "checkIn",
    "checkOut",
    "rooms"
})
public class AmendInformation {

    @XmlElement(name = "CheckIn")
    protected CheckInReq checkIn;
    @XmlElement(name = "CheckOut")
    protected CheckOutReq checkOut;
    @XmlElement(name = "Rooms")
    protected ArrayOfRoomReq rooms;

    /**
     * Gets the value of the checkIn property.
     * 
     * @return
     *     possible object is
     *     {@link CheckInReq }
     *     
     */
    public CheckInReq getCheckIn() {
        return checkIn;
    }

    /**
     * Sets the value of the checkIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckInReq }
     *     
     */
    public void setCheckIn(CheckInReq value) {
        this.checkIn = value;
    }

    /**
     * Gets the value of the checkOut property.
     * 
     * @return
     *     possible object is
     *     {@link CheckOutReq }
     *     
     */
    public CheckOutReq getCheckOut() {
        return checkOut;
    }

    /**
     * Sets the value of the checkOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckOutReq }
     *     
     */
    public void setCheckOut(CheckOutReq value) {
        this.checkOut = value;
    }

    /**
     * Gets the value of the rooms property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomReq }
     *     
     */
    public ArrayOfRoomReq getRooms() {
        return rooms;
    }

    /**
     * Sets the value of the rooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomReq }
     *     
     */
    public void setRooms(ArrayOfRoomReq value) {
        this.rooms = value;
    }

}
