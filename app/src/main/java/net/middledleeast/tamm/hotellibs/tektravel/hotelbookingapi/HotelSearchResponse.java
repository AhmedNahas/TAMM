
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
 *         &lt;element name="ResponseTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NoOfRoomsRequested" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CityId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CheckInDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CheckOutDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoomGuests" type="{http://TekTravel/HotelBookingApi}ArrayOfRoomGuest" minOccurs="0"/&gt;
 *         &lt;element name="HotelResultList" type="{http://TekTravel/HotelBookingApi}ArrayOfHotel_Result" minOccurs="0"/&gt;
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
    "responseTime",
    "language",
    "sessionId",
    "noOfRoomsRequested",
    "cityId",
    "checkInDate",
    "checkOutDate",
    "roomGuests",
    "hotelResultList"
})
@XmlRootElement(name = "HotelSearchResponse")
public class HotelSearchResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "ResponseTime")
    protected String responseTime;
    @XmlElement(name = "Language")
    protected String language;
    @XmlElement(name = "SessionId")
    protected String sessionId;
    @XmlElement(name = "NoOfRoomsRequested")
    protected String noOfRoomsRequested;
    @XmlElement(name = "CityId")
    protected String cityId;
    @XmlElement(name = "CheckInDate")
    protected String checkInDate;
    @XmlElement(name = "CheckOutDate")
    protected String checkOutDate;
    @XmlElement(name = "RoomGuests")
    protected ArrayOfRoomGuest roomGuests;
    @XmlElement(name = "HotelResultList")
    protected ArrayOfHotelResult hotelResultList;

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
     * Gets the value of the responseTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseTime() {
        return responseTime;
    }

    /**
     * Sets the value of the responseTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseTime(String value) {
        this.responseTime = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
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
     * Gets the value of the noOfRoomsRequested property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOfRoomsRequested() {
        return noOfRoomsRequested;
    }

    /**
     * Sets the value of the noOfRoomsRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOfRoomsRequested(String value) {
        this.noOfRoomsRequested = value;
    }

    /**
     * Gets the value of the cityId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * Sets the value of the cityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityId(String value) {
        this.cityId = value;
    }

    /**
     * Gets the value of the checkInDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckInDate() {
        return checkInDate;
    }

    /**
     * Sets the value of the checkInDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckInDate(String value) {
        this.checkInDate = value;
    }

    /**
     * Gets the value of the checkOutDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Sets the value of the checkOutDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckOutDate(String value) {
        this.checkOutDate = value;
    }

    /**
     * Gets the value of the roomGuests property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomGuest }
     *     
     */
    public ArrayOfRoomGuest getRoomGuests() {
        return roomGuests;
    }

    /**
     * Sets the value of the roomGuests property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomGuest }
     *     
     */
    public void setRoomGuests(ArrayOfRoomGuest value) {
        this.roomGuests = value;
    }

    /**
     * Gets the value of the hotelResultList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfHotelResult }
     *     
     */
    public ArrayOfHotelResult getHotelResultList() {
        return hotelResultList;
    }

    /**
     * Sets the value of the hotelResultList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfHotelResult }
     *     
     */
    public void setHotelResultList(ArrayOfHotelResult value) {
        this.hotelResultList = value;
    }

}
