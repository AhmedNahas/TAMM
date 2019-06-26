
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PriceChangeStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PriceChangeStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HotelRooms" type="{http://TekTravel/HotelBookingApi}ArrayOfHotel_Room" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Status" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="AvailableOnNewPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="NewPrice" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceChangeStatus", propOrder = {
    "hotelRooms"
})
public class PriceChangeStatus {

    @XmlElement(name = "HotelRooms")
    protected ArrayOfHotelRoom hotelRooms;
    @XmlAttribute(name = "Status", required = true)
    protected boolean status;
    @XmlAttribute(name = "AvailableOnNewPrice", required = true)
    protected boolean availableOnNewPrice;
    @XmlAttribute(name = "NewPrice")
    protected String newPrice;
    @XmlAttribute(name = "Currency")
    protected String currency;

    /**
     * Gets the value of the hotelRooms property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHotelRoom }
     *     
     */
    public ArrayOfHotelRoom getHotelRooms() {
        return hotelRooms;
    }

    /**
     * Sets the value of the hotelRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHotelRoom }
     *     
     */
    public void setHotelRooms(ArrayOfHotelRoom value) {
        this.hotelRooms = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setStatus(boolean value) {
        this.status = value;
    }

    /**
     * Gets the value of the availableOnNewPrice property.
     * 
     */
    public boolean isAvailableOnNewPrice() {
        return availableOnNewPrice;
    }

    /**
     * Sets the value of the availableOnNewPrice property.
     * 
     */
    public void setAvailableOnNewPrice(boolean value) {
        this.availableOnNewPrice = value;
    }

    /**
     * Gets the value of the newPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPrice() {
        return newPrice;
    }

    /**
     * Sets the value of the newPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPrice(String value) {
        this.newPrice = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}
