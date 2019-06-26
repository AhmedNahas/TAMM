
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoomInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoomInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ImageURLs" type="{http://TekTravel/HotelBookingApi}ArrayOfString" minOccurs="0"/&gt;
 *         &lt;element name="Amenities" type="{http://TekTravel/HotelBookingApi}ArrayOfString1" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="SmokingPref" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MaxOccupancy" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MaxAge" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MinAge" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MaxAdult" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MaxChild" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomInformation", propOrder = {
    "description",
    "imageURLs",
    "amenities"
})
public class RoomInformation {

    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "ImageURLs")
    protected ArrayOfString imageURLs;
    @XmlElement(name = "Amenities")
    protected ArrayOfString1 amenities;
    @XmlAttribute(name = "SmokingPref")
    protected String smokingPref;
    @XmlAttribute(name = "MaxOccupancy")
    protected String maxOccupancy;
    @XmlAttribute(name = "MaxAge")
    protected String maxAge;
    @XmlAttribute(name = "MinAge")
    protected String minAge;
    @XmlAttribute(name = "MaxAdult")
    protected String maxAdult;
    @XmlAttribute(name = "MaxChild")
    protected String maxChild;

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
     * Gets the value of the imageURLs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getImageURLs() {
        return imageURLs;
    }

    /**
     * Sets the value of the imageURLs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setImageURLs(ArrayOfString value) {
        this.imageURLs = value;
    }

    /**
     * Gets the value of the amenities property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString1 }
     *     
     */
    public ArrayOfString1 getAmenities() {
        return amenities;
    }

    /**
     * Sets the value of the amenities property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString1 }
     *     
     */
    public void setAmenities(ArrayOfString1 value) {
        this.amenities = value;
    }

    /**
     * Gets the value of the smokingPref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmokingPref() {
        return smokingPref;
    }

    /**
     * Sets the value of the smokingPref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmokingPref(String value) {
        this.smokingPref = value;
    }

    /**
     * Gets the value of the maxOccupancy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxOccupancy() {
        return maxOccupancy;
    }

    /**
     * Sets the value of the maxOccupancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxOccupancy(String value) {
        this.maxOccupancy = value;
    }

    /**
     * Gets the value of the maxAge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxAge() {
        return maxAge;
    }

    /**
     * Sets the value of the maxAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxAge(String value) {
        this.maxAge = value;
    }

    /**
     * Gets the value of the minAge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinAge() {
        return minAge;
    }

    /**
     * Sets the value of the minAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinAge(String value) {
        this.minAge = value;
    }

    /**
     * Gets the value of the maxAdult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxAdult() {
        return maxAdult;
    }

    /**
     * Sets the value of the maxAdult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxAdult(String value) {
        this.maxAdult = value;
    }

    /**
     * Gets the value of the maxChild property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxChild() {
        return maxChild;
    }

    /**
     * Sets the value of the maxChild property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxChild(String value) {
        this.maxChild = value;
    }

}
