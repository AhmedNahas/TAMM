
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.math.BigDecimal;

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
 *         &lt;element name="BookingId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="CancellationCharge" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="RefundAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="RequestStatus" type="{http://TekTravel/HotelBookingApi}HotelCancelStatus"/&gt;
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "bookingId",
    "cancellationCharge",
    "refundAmount",
    "requestStatus",
    "currency"
})
@XmlRootElement(name = "HotelCancelResponse")
public class HotelCancelResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "BookingId")
    protected int bookingId;
    @XmlElement(name = "CancellationCharge", required = true)
    protected BigDecimal cancellationCharge;
    @XmlElement(name = "RefundAmount", required = true)
    protected BigDecimal refundAmount;
    @XmlElement(name = "RequestStatus", required = true)
    @XmlSchemaType(name = "string")
    protected HotelCancelStatus requestStatus;
    @XmlElement(name = "Currency")
    protected String currency;

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
     * Gets the value of the cancellationCharge property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCancellationCharge() {
        return cancellationCharge;
    }

    /**
     * Sets the value of the cancellationCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCancellationCharge(BigDecimal value) {
        this.cancellationCharge = value;
    }

    /**
     * Gets the value of the refundAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    /**
     * Sets the value of the refundAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRefundAmount(BigDecimal value) {
        this.refundAmount = value;
    }

    /**
     * Gets the value of the requestStatus property.
     * 
     * @return
     *     possible object is
     *     {@link HotelCancelStatus }
     *     
     */
    public HotelCancelStatus getRequestStatus() {
        return requestStatus;
    }

    /**
     * Sets the value of the requestStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelCancelStatus }
     *     
     */
    public void setRequestStatus(HotelCancelStatus value) {
        this.requestStatus = value;
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
