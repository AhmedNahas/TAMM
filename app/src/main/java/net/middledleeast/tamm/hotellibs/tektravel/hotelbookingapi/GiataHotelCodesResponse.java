
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Status" type="{http://TekTravel/HotelBookingApi}ResponseStatus" minOccurs="0"/&gt;
 *         &lt;element name="Hotels" type="{http://TekTravel/HotelBookingApi}ArrayOfGiataHotels" minOccurs="0"/&gt;
 *         &lt;element name="HotelDetails" type="{http://TekTravel/HotelBookingApi}ArrayOfAPIHotelDetails" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "status",
    "hotels",
    "hotelDetails"
})
@XmlRootElement(name = "GiataHotelCodesResponse")
public class GiataHotelCodesResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "Hotels")
    protected ArrayOfGiataHotels hotels;
    @XmlElement(name = "HotelDetails")
    protected ArrayOfAPIHotelDetails hotelDetails;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseStatus }
     *     
     */
    public ResponseStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseStatus }
     *     
     */
    public void setStatus(ResponseStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the hotels property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGiataHotels }
     *     
     */
    public ArrayOfGiataHotels getHotels() {
        return hotels;
    }

    /**
     * Sets the value of the hotels property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGiataHotels }
     *     
     */
    public void setHotels(ArrayOfGiataHotels value) {
        this.hotels = value;
    }

    /**
     * Gets the value of the hotelDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAPIHotelDetails }
     *     
     */
    public ArrayOfAPIHotelDetails getHotelDetails() {
        return hotelDetails;
    }

    /**
     * Sets the value of the hotelDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAPIHotelDetails }
     *     
     */
    public void setHotelDetails(ArrayOfAPIHotelDetails value) {
        this.hotelDetails = value;
    }

}
