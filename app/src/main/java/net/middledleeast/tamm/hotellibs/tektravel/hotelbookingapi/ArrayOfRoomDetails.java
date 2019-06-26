
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRoomDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRoomDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RoomDetails" type="{http://TekTravel/HotelBookingApi}RoomDetails" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRoomDetails", propOrder = {
    "roomDetails"
})
public class ArrayOfRoomDetails {

    @XmlElement(name = "RoomDetails", nillable = true)
    protected List<RoomDetails> roomDetails;

    /**
     * Gets the value of the roomDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomDetails }
     * 
     * 
     */
    public List<RoomDetails> getRoomDetails() {
        if (roomDetails == null) {
            roomDetails = new ArrayList<RoomDetails>();
        }
        return this.roomDetails;
    }

}
