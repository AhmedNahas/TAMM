
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequestedRooms complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestedRooms"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RoomIndex" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="RoomTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoomRate" type="{http://TekTravel/HotelBookingApi}Rate" minOccurs="0"/&gt;
 *         &lt;element name="Supplements" type="{http://TekTravel/HotelBookingApi}ArrayOfSuppInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestedRooms", propOrder = {
    "roomIndex",
    "roomTypeName",
    "roomTypeCode",
    "ratePlanCode",
    "roomRate",
    "supplements"
})
public class RequestedRooms {

    @XmlElement(name = "RoomIndex")
    protected int roomIndex;
    @XmlElement(name = "RoomTypeName")
    protected String roomTypeName;
    @XmlElement(name = "RoomTypeCode")
    protected String roomTypeCode;
    @XmlElement(name = "RatePlanCode")
    protected String ratePlanCode;
    @XmlElement(name = "RoomRate")
    protected Rate roomRate;
    @XmlElement(name = "Supplements")
    protected ArrayOfSuppInfo supplements;

    /**
     * Gets the value of the roomIndex property.
     * 
     */
    public int getRoomIndex() {
        return roomIndex;
    }

    /**
     * Sets the value of the roomIndex property.
     * 
     */
    public void setRoomIndex(int value) {
        this.roomIndex = value;
    }

    /**
     * Gets the value of the roomTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomTypeName() {
        return roomTypeName;
    }

    /**
     * Sets the value of the roomTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomTypeName(String value) {
        this.roomTypeName = value;
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

    /**
     * Gets the value of the ratePlanCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRatePlanCode() {
        return ratePlanCode;
    }

    /**
     * Sets the value of the ratePlanCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatePlanCode(String value) {
        this.ratePlanCode = value;
    }

    /**
     * Gets the value of the roomRate property.
     * 
     * @return
     *     possible object is
     *     {@link Rate }
     *     
     */
    public Rate getRoomRate() {
        return roomRate;
    }

    /**
     * Sets the value of the roomRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rate }
     *     
     */
    public void setRoomRate(Rate value) {
        this.roomRate = value;
    }

    /**
     * Gets the value of the supplements property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSuppInfo }
     *     
     */
    public ArrayOfSuppInfo getSupplements() {
        return supplements;
    }

    /**
     * Sets the value of the supplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSuppInfo }
     *     
     */
    public void setSupplements(ArrayOfSuppInfo value) {
        this.supplements = value;
    }

}
