
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HotelInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HotelPicture" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HotelDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="HotelAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HotelContactNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rating" type="{http://TekTravel/HotelBookingApi}HotelInfoHotelRating"/&gt;
 *         &lt;element name="HotelPromotion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TripAdvisorRating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TripAdvisorReviewURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TagIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelInfo", propOrder = {
    "hotelCode",
    "hotelName",
    "hotelPicture",
    "hotelDescription",
    "latitude",
    "longitude",
    "hotelAddress",
    "hotelContactNo",
    "rating",
    "hotelPromotion",
    "tripAdvisorRating",
    "tripAdvisorReviewURL",
    "tagIds"
})
public class HotelInfo {

    @XmlElement(name = "HotelCode")
    protected String hotelCode;
    @XmlElement(name = "HotelName")
    protected String hotelName;
    @XmlElement(name = "HotelPicture")
    protected String hotelPicture;
    @XmlElement(name = "HotelDescription")
    protected String hotelDescription;
    @XmlElement(name = "Latitude", required = true, nillable = true)
    protected BigDecimal latitude;
    @XmlElement(name = "Longitude", required = true, nillable = true)
    protected BigDecimal longitude;
    @XmlElement(name = "HotelAddress")
    protected String hotelAddress;
    @XmlElement(name = "HotelContactNo")
    protected String hotelContactNo;
    @XmlElement(name = "Rating", required = true)
    @XmlSchemaType(name = "string")
    protected HotelInfoHotelRating rating;
    @XmlElement(name = "HotelPromotion")
    protected String hotelPromotion;
    @XmlElement(name = "TripAdvisorRating")
    protected String tripAdvisorRating;
    @XmlElement(name = "TripAdvisorReviewURL")
    protected String tripAdvisorReviewURL;
    @XmlElement(name = "TagIds")
    protected String tagIds;

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
     * Gets the value of the hotelPicture property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelPicture() {
        return hotelPicture;
    }

    /**
     * Sets the value of the hotelPicture property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelPicture(String value) {
        this.hotelPicture = value;
    }

    /**
     * Gets the value of the hotelDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelDescription() {
        return hotelDescription;
    }

    /**
     * Sets the value of the hotelDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelDescription(String value) {
        this.hotelDescription = value;
    }

    /**
     * Gets the value of the latitude property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLatitude(BigDecimal value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLongitude(BigDecimal value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the hotelAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelAddress() {
        return hotelAddress;
    }

    /**
     * Sets the value of the hotelAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelAddress(String value) {
        this.hotelAddress = value;
    }

    /**
     * Gets the value of the hotelContactNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelContactNo() {
        return hotelContactNo;
    }

    /**
     * Sets the value of the hotelContactNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelContactNo(String value) {
        this.hotelContactNo = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link HotelInfoHotelRating }
     *     
     */
    public HotelInfoHotelRating getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelInfoHotelRating }
     *     
     */
    public void setRating(HotelInfoHotelRating value) {
        this.rating = value;
    }

    /**
     * Gets the value of the hotelPromotion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelPromotion() {
        return hotelPromotion;
    }

    /**
     * Sets the value of the hotelPromotion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelPromotion(String value) {
        this.hotelPromotion = value;
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
     * Gets the value of the tagIds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTagIds() {
        return tagIds;
    }

    /**
     * Sets the value of the tagIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTagIds(String value) {
        this.tagIds = value;
    }

}
