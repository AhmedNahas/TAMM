
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
 *         &lt;element name="ClientReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GuestNationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Guests" type="{http://TekTravel/HotelBookingApi}ArrayOfGuest" minOccurs="0"/&gt;
 *         &lt;element name="AddressInfo" type="{http://TekTravel/HotelBookingApi}AddressInfo" minOccurs="0"/&gt;
 *         &lt;element name="PaymentInfo" type="{http://TekTravel/HotelBookingApi}PaymentInfo" minOccurs="0"/&gt;
 *         &lt;element name="SessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FlightInfo" type="{http://TekTravel/HotelBookingApi}FlightInfo" minOccurs="0"/&gt;
 *         &lt;element name="NoOfRooms" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ResultIndex" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HotelRooms" type="{http://TekTravel/HotelBookingApi}ArrayOfRequestedRooms" minOccurs="0"/&gt;
 *         &lt;element name="SpecialRequests" type="{http://TekTravel/HotelBookingApi}ArrayOfSpecialRequest" minOccurs="0"/&gt;
 *         &lt;element name="AgencyReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RestrictDuplicateBooking" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "clientReferenceNumber",
    "guestNationality",
    "guests",
    "addressInfo",
    "paymentInfo",
    "sessionId",
    "flightInfo",
    "noOfRooms",
    "resultIndex",
    "hotelCode",
    "hotelName",
    "hotelRooms",
    "specialRequests",
    "agencyReferenceNumber",
    "restrictDuplicateBooking"
})
@XmlRootElement(name = "HotelBookRequest")
public class HotelBookRequest {

    @XmlElement(name = "ClientReferenceNumber")
    protected String clientReferenceNumber;
    @XmlElement(name = "GuestNationality")
    protected String guestNationality;
    @XmlElement(name = "Guests")
    protected ArrayOfGuest guests;
    @XmlElement(name = "AddressInfo")
    protected AddressInfo addressInfo;
    @XmlElement(name = "PaymentInfo")
    protected PaymentInfo paymentInfo;
    @XmlElement(name = "SessionId")
    protected String sessionId;
    @XmlElement(name = "FlightInfo")
    protected FlightInfo flightInfo;
    @XmlElement(name = "NoOfRooms")
    protected int noOfRooms;
    @XmlElement(name = "ResultIndex")
    protected int resultIndex;
    @XmlElement(name = "HotelCode")
    protected String hotelCode;
    @XmlElement(name = "HotelName")
    protected String hotelName;
    @XmlElement(name = "HotelRooms")
    protected ArrayOfRequestedRooms hotelRooms;
    @XmlElement(name = "SpecialRequests")
    protected ArrayOfSpecialRequest specialRequests;
    @XmlElement(name = "AgencyReferenceNumber")
    protected String agencyReferenceNumber;
    @XmlElement(name = "RestrictDuplicateBooking")
    protected boolean restrictDuplicateBooking;

    /**
     * Gets the value of the clientReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientReferenceNumber() {
        return clientReferenceNumber;
    }

    /**
     * Sets the value of the clientReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientReferenceNumber(String value) {
        this.clientReferenceNumber = value;
    }

    /**
     * Gets the value of the guestNationality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestNationality() {
        return guestNationality;
    }

    /**
     * Sets the value of the guestNationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestNationality(String value) {
        this.guestNationality = value;
    }

    /**
     * Gets the value of the guests property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGuest }
     *     
     */
    public ArrayOfGuest getGuests() {
        return guests;
    }

    /**
     * Sets the value of the guests property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGuest }
     *     
     */
    public void setGuests(ArrayOfGuest value) {
        this.guests = value;
    }

    /**
     * Gets the value of the addressInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AddressInfo }
     *     
     */
    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

    /**
     * Sets the value of the addressInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressInfo }
     *     
     */
    public void setAddressInfo(AddressInfo value) {
        this.addressInfo = value;
    }

    /**
     * Gets the value of the paymentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentInfo }
     *     
     */
    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    /**
     * Sets the value of the paymentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInfo }
     *     
     */
    public void setPaymentInfo(PaymentInfo value) {
        this.paymentInfo = value;
    }

    /**
     * Gets the value of the sessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * Gets the value of the flightInfo property.
     * 
     * @return
     *     possible object is
     *     {@link FlightInfo }
     *     
     */
    public FlightInfo getFlightInfo() {
        return flightInfo;
    }

    /**
     * Sets the value of the flightInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlightInfo }
     *     
     */
    public void setFlightInfo(FlightInfo value) {
        this.flightInfo = value;
    }

    /**
     * Gets the value of the noOfRooms property.
     * 
     */
    public int getNoOfRooms() {
        return noOfRooms;
    }

    /**
     * Sets the value of the noOfRooms property.
     * 
     */
    public void setNoOfRooms(int value) {
        this.noOfRooms = value;
    }

    /**
     * Gets the value of the resultIndex property.
     * 
     */
    public int getResultIndex() {
        return resultIndex;
    }

    /**
     * Sets the value of the resultIndex property.
     * 
     */
    public void setResultIndex(int value) {
        this.resultIndex = value;
    }

    /**
     * Gets the value of the hotelCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCode() {
        return hotelCode;
    }

    /**
     * Sets the value of the hotelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCode(String value) {
        this.hotelCode = value;
    }

    /**
     * Gets the value of the hotelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Sets the value of the hotelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelName(String value) {
        this.hotelName = value;
    }

    /**
     * Gets the value of the hotelRooms property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRequestedRooms }
     *     
     */
    public ArrayOfRequestedRooms getHotelRooms() {
        return hotelRooms;
    }

    /**
     * Sets the value of the hotelRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRequestedRooms }
     *     
     */
    public void setHotelRooms(ArrayOfRequestedRooms value) {
        this.hotelRooms = value;
    }

    /**
     * Gets the value of the specialRequests property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSpecialRequest }
     *     
     */
    public ArrayOfSpecialRequest getSpecialRequests() {
        return specialRequests;
    }

    /**
     * Sets the value of the specialRequests property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSpecialRequest }
     *     
     */
    public void setSpecialRequests(ArrayOfSpecialRequest value) {
        this.specialRequests = value;
    }

    /**
     * Gets the value of the agencyReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyReferenceNumber() {
        return agencyReferenceNumber;
    }

    /**
     * Sets the value of the agencyReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyReferenceNumber(String value) {
        this.agencyReferenceNumber = value;
    }

    /**
     * Gets the value of the restrictDuplicateBooking property.
     * 
     */
    public boolean isRestrictDuplicateBooking() {
        return restrictDuplicateBooking;
    }

    /**
     * Sets the value of the restrictDuplicateBooking property.
     * 
     */
    public void setRestrictDuplicateBooking(boolean value) {
        this.restrictDuplicateBooking = value;
    }

}
