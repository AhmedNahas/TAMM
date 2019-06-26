
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
 *         &lt;element name="Request" type="{http://TekTravel/HotelBookingApi}AmendmentRequestType" minOccurs="0"/&gt;
 *         &lt;element name="BookingId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="AmendInformation" type="{http://TekTravel/HotelBookingApi}AmendInformation" minOccurs="0"/&gt;
 *         &lt;element name="ConfirmationNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "request",
    "bookingId",
    "amendInformation",
    "confirmationNo"
})
@XmlRootElement(name = "AmendmentRequest")
public class AmendmentRequest {

    @XmlElement(name = "Request")
    protected AmendmentRequestType request;
    @XmlElement(name = "BookingId")
    protected int bookingId;
    @XmlElement(name = "AmendInformation")
    protected AmendInformation amendInformation;
    @XmlElement(name = "ConfirmationNo")
    protected String confirmationNo;

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link AmendmentRequestType }
     *     
     */
    public AmendmentRequestType getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendmentRequestType }
     *     
     */
    public void setRequest(AmendmentRequestType value) {
        this.request = value;
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
     * Gets the value of the amendInformation property.
     * 
     * @return
     *     possible object is
     *     {@link AmendInformation }
     *     
     */
    public AmendInformation getAmendInformation() {
        return amendInformation;
    }

    /**
     * Sets the value of the amendInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendInformation }
     *     
     */
    public void setAmendInformation(AmendInformation value) {
        this.amendInformation = value;
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

}
