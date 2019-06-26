
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
 *         &lt;element name="RequestStatus" type="{http://TekTravel/HotelBookingApi}RequestStatus"/&gt;
 *         &lt;element name="ApprovalInformation" type="{http://TekTravel/HotelBookingApi}ApprovalInformation" minOccurs="0"/&gt;
 *         &lt;element name="BookingId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="NewConfirmatioNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NewLastCancellationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AmendmentMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AmendmentRequested" type="{http://TekTravel/HotelBookingApi}AmendmentRequested" minOccurs="0"/&gt;
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
    "requestStatus",
    "approvalInformation",
    "bookingId",
    "newConfirmatioNo",
    "newLastCancellationDate",
    "amendmentMessage",
    "amendmentRequested"
})
@XmlRootElement(name = "AmendmentResponse")
public class AmendmentResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "RequestStatus", required = true)
    @XmlSchemaType(name = "string")
    protected RequestStatus requestStatus;
    @XmlElement(name = "ApprovalInformation")
    protected ApprovalInformation approvalInformation;
    @XmlElement(name = "BookingId")
    protected int bookingId;
    @XmlElement(name = "NewConfirmatioNo")
    protected String newConfirmatioNo;
    @XmlElement(name = "NewLastCancellationDate")
    protected String newLastCancellationDate;
    @XmlElement(name = "AmendmentMessage")
    protected String amendmentMessage;
    @XmlElement(name = "AmendmentRequested")
    protected AmendmentRequested amendmentRequested;

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
     * Gets the value of the requestStatus property.
     * 
     * @return
     *     possible object is
     *     {@link RequestStatus }
     *     
     */
    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    /**
     * Sets the value of the requestStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestStatus }
     *     
     */
    public void setRequestStatus(RequestStatus value) {
        this.requestStatus = value;
    }

    /**
     * Gets the value of the approvalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ApprovalInformation }
     *     
     */
    public ApprovalInformation getApprovalInformation() {
        return approvalInformation;
    }

    /**
     * Sets the value of the approvalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApprovalInformation }
     *     
     */
    public void setApprovalInformation(ApprovalInformation value) {
        this.approvalInformation = value;
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
     * Gets the value of the newConfirmatioNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewConfirmatioNo() {
        return newConfirmatioNo;
    }

    /**
     * Sets the value of the newConfirmatioNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewConfirmatioNo(String value) {
        this.newConfirmatioNo = value;
    }

    /**
     * Gets the value of the newLastCancellationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewLastCancellationDate() {
        return newLastCancellationDate;
    }

    /**
     * Sets the value of the newLastCancellationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewLastCancellationDate(String value) {
        this.newLastCancellationDate = value;
    }

    /**
     * Gets the value of the amendmentMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmendmentMessage() {
        return amendmentMessage;
    }

    /**
     * Sets the value of the amendmentMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmendmentMessage(String value) {
        this.amendmentMessage = value;
    }

    /**
     * Gets the value of the amendmentRequested property.
     * 
     * @return
     *     possible object is
     *     {@link AmendmentRequested }
     *     
     */
    public AmendmentRequested getAmendmentRequested() {
        return amendmentRequested;
    }

    /**
     * Sets the value of the amendmentRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendmentRequested }
     *     
     */
    public void setAmendmentRequested(AmendmentRequested value) {
        this.amendmentRequested = value;
    }

}
