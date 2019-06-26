
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoomInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoomInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Images" type="{http://TekTravel/HotelBookingApi}ArrayOfString5" minOccurs="0"/&gt;
 *         &lt;element name="RoomPromotion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Inclusion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="RoomName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomInfo", propOrder = {
    "description",
    "images",
    "roomPromotion",
    "inclusion"
})
public class RoomInfo {

    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Images")
    protected ArrayOfString5 images;
    @XmlElement(name = "RoomPromotion")
    protected String roomPromotion;
    @XmlElement(name = "Inclusion")
    protected String inclusion;
    @XmlAttribute(name = "RoomName")
    protected String roomName;
    @XmlAttribute(name = "RoomTypeCode")
    protected String roomTypeCode;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString5 }
     *     
     */
    public ArrayOfString5 getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString5 }
     *     
     */
    public void setImages(ArrayOfString5 value) {
        this.images = value;
    }

    /**
     * Gets the value of the roomPromotion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomPromotion() {
        return roomPromotion;
    }

    /**
     * Sets the value of the roomPromotion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomPromotion(String value) {
        this.roomPromotion = value;
    }

    /**
     * Gets the value of the inclusion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInclusion() {
        return inclusion;
    }

    /**
     * Sets the value of the inclusion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInclusion(String value) {
        this.inclusion = value;
    }

    /**
     * Gets the value of the roomName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Sets the value of the roomName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomName(String value) {
        this.roomName = value;
    }

    /**
     * Gets the value of the roomTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    /**
     * Sets the value of the roomTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomTypeCode(String value) {
        this.roomTypeCode = value;
    }

}
