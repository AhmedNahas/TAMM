
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BookingsBasedOnDate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BookingsBasedOnDate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="BookingId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ConfirmationNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BookingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AgentMarkup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AgencyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BookingStatus" type="{http://TekTravel/HotelBookingApi}APIHotelBookingStatus"/&gt;
 *         &lt;element name="BookingPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TripName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TBOHotelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BookingsBasedOnDate", propOrder = {
    "index",
    "bookingId",
    "confirmationNo",
    "bookingDate",
    "currency",
    "agentMarkup",
    "agencyName",
    "bookingStatus",
    "bookingPrice",
    "tripName",
    "tboHotelCode",
    "remarks"
})
public class BookingsBasedOnDate {

    @XmlElement(name = "Index")
    protected int index;
    @XmlElement(name = "BookingId")
    protected String bookingId;
    @XmlElement(name = "ConfirmationNo")
    protected String confirmationNo;
    @XmlElement(name = "BookingDate")
    protected String bookingDate;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "AgentMarkup")
    protected String agentMarkup;
    @XmlElement(name = "AgencyName")
    protected String agencyName;
    @XmlElement(name = "BookingStatus", required = true)
    @XmlSchemaType(name = "string")
    protected APIHotelBookingStatus bookingStatus;
    @XmlElement(name = "BookingPrice")
    protected String bookingPrice;
    @XmlElement(name = "TripName")
    protected String tripName;
    @XmlElement(name = "TBOHotelCode")
    protected String tboHotelCode;
    @XmlElement(name = "Remarks")
    protected String remarks;

    /**
     * Gets the value of the index property.
     * 
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     */
    public void setIndex(int value) {
        this.index = value;
    }

    /**
     * Gets the value of the bookingId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Sets the value of the bookingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingId(String value) {
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
     * Gets the value of the bookingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the value of the bookingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingDate(String value) {
        this.bookingDate = value;
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

    /**
     * Gets the value of the agentMarkup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentMarkup() {
        return agentMarkup;
    }

    /**
     * Sets the value of the agentMarkup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentMarkup(String value) {
        this.agentMarkup = value;
    }

    /**
     * Gets the value of the agencyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyName() {
        return agencyName;
    }

    /**
     * Sets the value of the agencyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyName(String value) {
        this.agencyName = value;
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
     * Gets the value of the bookingPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingPrice() {
        return bookingPrice;
    }

    /**
     * Sets the value of the bookingPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingPrice(String value) {
        this.bookingPrice = value;
    }

    /**
     * Gets the value of the tripName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripName() {
        return tripName;
    }

    /**
     * Sets the value of the tripName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripName(String value) {
        this.tripName = value;
    }

    /**
     * Gets the value of the tboHotelCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTBOHotelCode() {
        return tboHotelCode;
    }

    /**
     * Sets the value of the tboHotelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTBOHotelCode(String value) {
        this.tboHotelCode = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets the value of the remarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

}
