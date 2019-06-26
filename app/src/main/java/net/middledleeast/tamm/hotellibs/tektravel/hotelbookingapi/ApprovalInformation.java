
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApprovalInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApprovalInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Rooms" type="{http://TekTravel/HotelBookingApi}ArrayOfRoomPriceRes" minOccurs="0"/&gt;
 *         &lt;element name="TotalPrice" type="{http://TekTravel/HotelBookingApi}TotalPrice" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApprovalInformation", propOrder = {
    "rooms",
    "totalPrice"
})
public class ApprovalInformation {

    @XmlElement(name = "Rooms")
    protected ArrayOfRoomPriceRes rooms;
    @XmlElement(name = "TotalPrice")
    protected TotalPrice totalPrice;

    /**
     * Gets the value of the rooms property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomPriceRes }
     *     
     */
    public ArrayOfRoomPriceRes getRooms() {
        return rooms;
    }

    /**
     * Sets the value of the rooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomPriceRes }
     *     
     */
    public void setRooms(ArrayOfRoomPriceRes value) {
        this.rooms = value;
    }

    /**
     * Gets the value of the totalPrice property.
     * 
     * @return
     *     possible object is
     *     {@link TotalPrice }
     *     
     */
    public TotalPrice getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the value of the totalPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalPrice }
     *     
     */
    public void setTotalPrice(TotalPrice value) {
        this.totalPrice = value;
    }

}
