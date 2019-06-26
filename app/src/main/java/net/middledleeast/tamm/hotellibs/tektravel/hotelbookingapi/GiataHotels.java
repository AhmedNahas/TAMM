
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GiataHotels complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GiataHotels"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="HotelAddress" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Latitude" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Longitude" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="StarRating" use="required" type="{http://TekTravel/HotelBookingApi}HotelRating" /&gt;
 *       &lt;attribute name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="CityName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GiataHotels")
public class GiataHotels {

    @XmlAttribute(name = "HotelCode")
    protected String hotelCode;
    @XmlAttribute(name = "HotelName")
    protected String hotelName;
    @XmlAttribute(name = "HotelAddress")
    protected String hotelAddress;
    @XmlAttribute(name = "Latitude")
    protected String latitude;
    @XmlAttribute(name = "Longitude")
    protected String longitude;
    @XmlAttribute(name = "StarRating", required = true)
    protected HotelRating starRating;
    @XmlAttribute(name = "CountryName")
    protected String countryName;
    @XmlAttribute(name = "CityName")
    protected String cityName;
    @XmlAttribute(name = "CountryCode")
    protected String countryCode;

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
     * Gets the value of the latitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatitude(String value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongitude(String value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the starRating property.
     * 
     * @return
     *     possible object is
     *     {@link HotelRating }
     *     
     */
    public HotelRating getStarRating() {
        return starRating;
    }

    /**
     * Sets the value of the starRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelRating }
     *     
     */
    public void setStarRating(HotelRating value) {
        this.starRating = value;
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

}
