
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoomRes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoomRes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Guest" type="{http://TekTravel/HotelBookingApi}AmendGuestRes" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Amended" use="required" type="{http://TekTravel/HotelBookingApi}RoomRequested" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomRes", propOrder = {
    "guest"
})
public class RoomRes {

    @XmlElement(name = "Guest")
    protected List<AmendGuestRes> guest;
    @XmlAttribute(name = "Amended", required = true)
    protected RoomRequested amended;

    /**
     * Gets the value of the guest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the guest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGuest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmendGuestRes }
     * 
     * 
     */
    public List<AmendGuestRes> getGuest() {
        if (guest == null) {
            guest = new ArrayList<AmendGuestRes>();
        }
        return this.guest;
    }

    /**
     * Gets the value of the amended property.
     * 
     * @return
     *     possible object is
     *     {@link RoomRequested }
     *     
     */
    public RoomRequested getAmended() {
        return amended;
    }

    /**
     * Sets the value of the amended property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoomRequested }
     *     
     */
    public void setAmended(RoomRequested value) {
        this.amended = value;
    }

}
