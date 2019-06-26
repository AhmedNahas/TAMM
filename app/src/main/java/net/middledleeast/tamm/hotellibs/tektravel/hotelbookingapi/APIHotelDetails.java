
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for APIHotelDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APIHotelDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HotelLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Attractions" type="{http://TekTravel/HotelBookingApi}ArrayOfString3" minOccurs="0"/&gt;
 *         &lt;element name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FaxNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HotelFacilities" type="{http://TekTravel/HotelBookingApi}ArrayOfString4" minOccurs="0"/&gt;
 *         &lt;element name="HotelPolicy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Image" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ImageUrls" type="{http://TekTravel/HotelBookingApi}ArrayOfImageUrlDetails" minOccurs="0"/&gt;
 *         &lt;element name="Map" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PinCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoomInfo" type="{http://TekTravel/HotelBookingApi}ArrayOfRoomInfo" minOccurs="0"/&gt;
 *         &lt;element name="RoomFacilities" type="{http://TekTravel/HotelBookingApi}ArrayOfString6" minOccurs="0"/&gt;
 *         &lt;element name="Services" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HotelWebsiteUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TripAdvisorRating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TripAdvisorReviewURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="HotelRating" use="required" type="{http://TekTravel/HotelBookingApi}HotelInfoHotelRating" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APIHotelDetails", propOrder = {
    "address",
    "hotelLocation",
    "attractions",
    "countryName",
    "countryCode",
    "description",
    "email",
    "faxNumber",
    "hotelFacilities",
    "hotelPolicy",
    "image",
    "imageUrls",
    "map",
    "phoneNumber",
    "pinCode",
    "roomInfo",
    "roomFacilities",
    "services",
    "hotelWebsiteUrl",
    "tripAdvisorRating",
    "tripAdvisorReviewURL",
    "cityName"
})
public class APIHotelDetails {

    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "HotelLocation")
    protected String hotelLocation;
    @XmlElement(name = "Attractions")
    protected ArrayOfString3 attractions;
    @XmlElement(name = "CountryName")
    protected String countryName;
    @XmlElement(name = "CountryCode")
    protected String countryCode;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "FaxNumber")
    protected String faxNumber;
    @XmlElement(name = "HotelFacilities")
    protected ArrayOfString4 hotelFacilities;
    @XmlElement(name = "HotelPolicy")
    protected String hotelPolicy;
    @XmlElement(name = "Image")
    protected String image;
    @XmlElement(name = "ImageUrls")
    protected ArrayOfImageUrlDetails imageUrls;
    @XmlElement(name = "Map")
    protected String map;
    @XmlElement(name = "PhoneNumber")
    protected String phoneNumber;
    @XmlElement(name = "PinCode")
    protected String pinCode;
    @XmlElement(name = "RoomInfo")
    protected ArrayOfRoomInfo roomInfo;
    @XmlElement(name = "RoomFacilities")
    protected ArrayOfString6 roomFacilities;
    @XmlElement(name = "Services")
    protected String services;
    @XmlElement(name = "HotelWebsiteUrl")
    protected String hotelWebsiteUrl;
    @XmlElement(name = "TripAdvisorRating")
    protected String tripAdvisorRating;
    @XmlElement(name = "TripAdvisorReviewURL")
    protected String tripAdvisorReviewURL;
    @XmlElement(name = "CityName")
    protected String cityName;
    @XmlAttribute(name = "HotelCode")
    protected String hotelCode;
    @XmlAttribute(name = "HotelName")
    protected String hotelName;
    @XmlAttribute(name = "HotelRating", required = true)
    protected HotelInfoHotelRating hotelRating;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the hotelLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelLocation() {
        return hotelLocation;
    }

    /**
     * Sets the value of the hotelLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelLocation(String value) {
        this.hotelLocation = value;
    }

    /**
     * Gets the value of the attractions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString3 }
     *     
     */
    public ArrayOfString3 getAttractions() {
        return attractions;
    }

    /**
     * Sets the value of the attractions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString3 }
     *     
     */
    public void setAttractions(ArrayOfString3 value) {
        this.attractions = value;
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
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the faxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Sets the value of the faxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxNumber(String value) {
        this.faxNumber = value;
    }

    /**
     * Gets the value of the hotelFacilities property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString4 }
     *     
     */
    public ArrayOfString4 getHotelFacilities() {
        return hotelFacilities;
    }

    /**
     * Sets the value of the hotelFacilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString4 }
     *     
     */
    public void setHotelFacilities(ArrayOfString4 value) {
        this.hotelFacilities = value;
    }

    /**
     * Gets the value of the hotelPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelPolicy() {
        return hotelPolicy;
    }

    /**
     * Sets the value of the hotelPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelPolicy(String value) {
        this.hotelPolicy = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Gets the value of the imageUrls property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfImageUrlDetails }
     *     
     */
    public ArrayOfImageUrlDetails getImageUrls() {
        return imageUrls;
    }

    /**
     * Sets the value of the imageUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfImageUrlDetails }
     *     
     */
    public void setImageUrls(ArrayOfImageUrlDetails value) {
        this.imageUrls = value;
    }

    /**
     * Gets the value of the map property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMap() {
        return map;
    }

    /**
     * Sets the value of the map property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMap(String value) {
        this.map = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the pinCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPinCode() {
        return pinCode;
    }

    /**
     * Sets the value of the pinCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPinCode(String value) {
        this.pinCode = value;
    }

    /**
     * Gets the value of the roomInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomInfo }
     *     
     */
    public ArrayOfRoomInfo getRoomInfo() {
        return roomInfo;
    }

    /**
     * Sets the value of the roomInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomInfo }
     *     
     */
    public void setRoomInfo(ArrayOfRoomInfo value) {
        this.roomInfo = value;
    }

    /**
     * Gets the value of the roomFacilities property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString6 }
     *     
     */
    public ArrayOfString6 getRoomFacilities() {
        return roomFacilities;
    }

    /**
     * Sets the value of the roomFacilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString6 }
     *     
     */
    public void setRoomFacilities(ArrayOfString6 value) {
        this.roomFacilities = value;
    }

    /**
     * Gets the value of the services property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServices() {
        return services;
    }

    /**
     * Sets the value of the services property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServices(String value) {
        this.services = value;
    }

    /**
     * Gets the value of the hotelWebsiteUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelWebsiteUrl() {
        return hotelWebsiteUrl;
    }

    /**
     * Sets the value of the hotelWebsiteUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelWebsiteUrl(String value) {
        this.hotelWebsiteUrl = value;
    }

    /**
     * Gets the value of the tripAdvisorRating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripAdvisorRating() {
        return tripAdvisorRating;
    }

    /**
     * Sets the value of the tripAdvisorRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripAdvisorRating(String value) {
        this.tripAdvisorRating = value;
    }

    /**
     * Gets the value of the tripAdvisorReviewURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripAdvisorReviewURL() {
        return tripAdvisorReviewURL;
    }

    /**
     * Sets the value of the tripAdvisorReviewURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripAdvisorReviewURL(String value) {
        this.tripAdvisorReviewURL = value;
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
     * Gets the value of the hotelRating property.
     * 
     * @return
     *     possible object is
     *     {@link HotelInfoHotelRating }
     *     
     */
    public HotelInfoHotelRating getHotelRating() {
        return hotelRating;
    }

    /**
     * Sets the value of the hotelRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelInfoHotelRating }
     *     
     */
    public void setHotelRating(HotelInfoHotelRating value) {
        this.hotelRating = value;
    }

}
