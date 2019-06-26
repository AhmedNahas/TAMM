
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="BookingStatus" type="{http://TekTravel/HotelBookingApi}APIHotelBookingStatus"/&gt;
 *         &lt;element name="BookingId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ConfirmationNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TripId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="SupplierReferenceNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PriceChange" type="{http://TekTravel/HotelBookingApi}PriceChangeStatus" minOccurs="0"/&gt;
 *         &lt;element name="SupplierConfirmationNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "bookingStatus",
    "bookingId",
    "confirmationNo",
    "tripId",
    "supplierReferenceNo",
    "priceChange",
    "supplierConfirmationNo"
})
@XmlRootElement(name = "HotelBookResponse")
public class HotelBookResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "BookingStatus", required = true)
    @XmlSchemaType(name = "string")
    protected APIHotelBookingStatus bookingStatus;
    @XmlElement(name = "BookingId")
    protected int bookingId;
    @XmlElement(name = "ConfirmationNo")
    protected String confirmationNo;
    @XmlElement(name = "TripId")
    protected int tripId;
    @XmlElement(name = "SupplierReferenceNo")
    protected String supplierReferenceNo;
    @XmlElement(name = "PriceChange")
    protected PriceChangeStatus priceChange;
    @XmlElement(name = "SupplierConfirmationNo")
    protected String supplierConfirmationNo;

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
     * Gets the value of the bookingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link APIHotelBookingStatus }
     *     
     */
    public APIHotelBookingStatus getBookingStatus() {
        return bookingStatus;
    }

    /**
     * Sets the value of the bookingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link APIHotelBookingStatus }
     *     
     */
    public void setBookingStatus(APIHotelBookingStatus value) {
        this.bookingStatus = value;
    }

    /**
     * Gets the value of the bookingId property.
     * 
     */
    public int getBookingId() {
        return bookingId;
    }

    /**
     * Sets the value of the bookingId property.
     * 
     */
    public void setBookingId(int value) {
        this.bookingId = value;
    }

    /**
     * Gets the value of the confirmationNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmationNo() {
        return confirmationNo;
    }

    /**
     * Sets the value of the confirmationNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmationNo(String value) {
        this.confirmationNo = value;
    }

    /**
     * Gets the value of the tripId property.
     * 
     */
    public int getTripId() {
        return tripId;
    }

    /**
     * Sets the value of the tripId property.
     * 
     */
    public void setTripId(int value) {
        this.tripId = value;
    }

    /**
     * Gets the value of the supplierReferenceNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierReferenceNo() {
        return supplierReferenceNo;
    }

    /**
     * Sets the value of the supplierReferenceNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierReferenceNo(String value) {
        this.supplierReferenceNo = value;
    }

    /**
     * Gets the value of the priceChange property.
     * 
     * @return
     *     possible object is
     *     {@link PriceChangeStatus }
     *     
     */
    public PriceChangeStatus getPriceChange() {
        return priceChange;
    }

    /**
     * Sets the value of the priceChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceChangeStatus }
     *     
     */
    public void setPriceChange(PriceChangeStatus value) {
        this.priceChange = value;
    }

    /**
     * Gets the value of the supplierConfirmationNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierConfirmationNo() {
        return supplierConfirmationNo;
    }

    /**
     * Sets the value of the supplierConfirmationNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierConfirmationNo(String value) {
        this.supplierConfirmationNo = value;
    }

}
