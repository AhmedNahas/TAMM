
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="CheckInDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="CheckOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CityId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="IsNearBySearchAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="NoOfRooms" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="GuestNationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoomGuests" type="{http://TekTravel/HotelBookingApi}ArrayOfRoomGuest" minOccurs="0"/&gt;
 *         &lt;element name="PreferredCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResultCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Filters" type="{http://TekTravel/HotelBookingApi}Filters" minOccurs="0"/&gt;
 *         &lt;element name="IsRoomInfoRequired" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GeoCodes" type="{http://TekTravel/HotelBookingApi}GeoCodes" minOccurs="0"/&gt;
 *         &lt;element name="ResponseTime" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "checkInDate",
    "checkOutDate",
    "countryName",
    "cityName",
    "cityId",
    "isNearBySearchAllowed",
    "noOfRooms",
    "guestNationality",
    "roomGuests",
    "preferredCurrencyCode",
    "resultCount",
    "filters",
    "isRoomInfoRequired",
    "geoCodes",
    "responseTime"
})
@XmlRootElement(name = "HotelSearchRequest")
public class HotelSearchRequest {

    @XmlElement(name = "CheckInDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkInDate;
    @XmlElement(name = "CheckOutDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar checkOutDate;
    @XmlElement(name = "CountryName")
    protected String countryName;
    @XmlElement(name = "CityName")
    protected String cityName;
    @XmlElement(name = "CityId")
    protected int cityId;
    @XmlElement(name = "IsNearBySearchAllowed")
    protected boolean isNearBySearchAllowed;
    @XmlElement(name = "NoOfRooms")
    protected int noOfRooms;
    @XmlElement(name = "GuestNationality")
    protected String guestNationality;
    @XmlElement(name = "RoomGuests")
    protected ArrayOfRoomGuest roomGuests;
    @XmlElement(name = "PreferredCurrencyCode")
    protected String preferredCurrencyCode;
    @XmlElement(name = "ResultCount")
    protected int resultCount;
    @XmlElement(name = "Filters")
    protected Filters filters;
    @XmlElement(name = "IsRoomInfoRequired")
    protected String isRoomInfoRequired;
    @XmlElement(name = "GeoCodes")
    protected GeoCodes geoCodes;
    @XmlElement(name = "ResponseTime")
    protected int responseTime;

    /**
     * Gets the value of the checkInDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckInDate() {
        return checkInDate;
    }

    /**
     * Sets the value of the checkInDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckInDate(XMLGregorianCalendar value) {
        this.checkInDate = value;
    }

    /**
     * Gets the value of the checkOutDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Sets the value of the checkOutDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCheckOutDate(XMLGregorianCalendar value) {
        this.checkOutDate = value;
    }

    /**
     * Gets the value of the countryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the countryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

    /**
     * Gets the value of the cityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the value of the cityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityName(String value) {
        this.cityName = value;
    }

    /**
     * Gets the value of the cityId property.
     * 
     */
    public int getCityId() {
        return cityId;
    }

    /**
     * Sets the value of the cityId property.
     * 
     */
    public void setCityId(int value) {
        this.cityId = value;
    }

    /**
     * Gets the value of the isNearBySearchAllowed property.
     * 
     */
    public boolean isIsNearBySearchAllowed() {
        return isNearBySearchAllowed;
    }

    /**
     * Sets the value of the isNearBySearchAllowed property.
     * 
     */
    public void setIsNearBySearchAllowed(boolean value) {
        this.isNearBySearchAllowed = value;
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
     * Gets the value of the preferredCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreferredCurrencyCode() {
        return preferredCurrencyCode;
    }

    /**
     * Sets the value of the preferredCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreferredCurrencyCode(String value) {
        this.preferredCurrencyCode = value;
    }

    /**
     * Gets the value of the resultCount property.
     * 
     */
    public int getResultCount() {
        return resultCount;
    }

    /**
     * Sets the value of the resultCount property.
     * 
     */
    public void setResultCount(int value) {
        this.resultCount = value;
    }

    /**
     * Gets the value of the filters property.
     * 
     * @return
     *     possible object is
     *     {@link Filters }
     *     
     */
    public Filters getFilters() {
        return filters;
    }

    /**
     * Sets the value of the filters property.
     * 
     * @param value
     *     allowed object is
     *     {@link Filters }
     *     
     */
    public void setFilters(Filters value) {
        this.filters = value;
    }

    /**
     * Gets the value of the isRoomInfoRequired property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsRoomInfoRequired() {
        return isRoomInfoRequired;
    }

    /**
     * Sets the value of the isRoomInfoRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsRoomInfoRequired(String value) {
        this.isRoomInfoRequired = value;
    }

    /**
     * Gets the value of the geoCodes property.
     * 
     * @return
     *     possible object is
     *     {@link GeoCodes }
     *     
     */
    public GeoCodes getGeoCodes() {
        return geoCodes;
    }

    /**
     * Sets the value of the geoCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeoCodes }
     *     
     */
    public void setGeoCodes(GeoCodes value) {
        this.geoCodes = value;
    }

    /**
     * Gets the value of the responseTime property.
     * 
     */
    public int getResponseTime() {
        return responseTime;
    }

    /**
     * Sets the value of the responseTime property.
     * 
     */
    public void setResponseTime(int value) {
        this.responseTime = value;
    }

}
