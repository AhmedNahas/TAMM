
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PriceVerification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PriceVerification"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HotelRooms" type="{http://TekTravel/HotelBookingApi}ArrayOfHotel_Room" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Status" use="required" type="{http://TekTravel/HotelBookingApi}PriceVerificationStatus" /&gt;
 *       &lt;attribute name="PriceChanged" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="AvailableOnNewPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceVerification", propOrder = {
    "hotelRooms"
})
public class PriceVerification {

    @XmlElement(name = "HotelRooms")
    protected ArrayOfHotelRoom hotelRooms;
    @XmlAttribute(name = "Status", required = true)
    protected PriceVerificationStatus status;
    @XmlAttribute(name = "PriceChanged", required = true)
    protected boolean priceChanged;
    @XmlAttribute(name = "AvailableOnNewPrice", required = true)
    protected boolean availableOnNewPrice;

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
     * @return
     *     possible object is
     *     {@link PriceVerificationStatus }
     *     
     */
    public PriceVerificationStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceVerificationStatus }
     *     
     */
    public void setStatus(PriceVerificationStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the priceChanged property.
     * 
     */
    public boolean isPriceChanged() {
        return priceChanged;
    }

    /**
     * Sets the value of the priceChanged property.
     * 
     */
    public void setPriceChanged(boolean value) {
        this.priceChanged = value;
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

}
