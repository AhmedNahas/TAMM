
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Filters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Filters"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="StarRating" type="{http://TekTravel/HotelBookingApi}HotelRatingInput"/&gt;
 *         &lt;element name="OrderBy" type="{http://TekTravel/HotelBookingApi}OrderByFilter"/&gt;
 *         &lt;element name="HotelCodeList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Filters", propOrder = {
    "hotelName",
    "starRating",
    "orderBy",
    "hotelCodeList"
})
public class Filters {

    @XmlElement(name = "HotelName")
    protected String hotelName;
    @XmlElement(name = "StarRating", required = true)
    @XmlSchemaType(name = "string")
    protected HotelRatingInput starRating;
    @XmlElement(name = "OrderBy", required = true)
    @XmlSchemaType(name = "string")
    protected OrderByFilter orderBy;
    @XmlElement(name = "HotelCodeList")
    protected String hotelCodeList;

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
     * Gets the value of the starRating property.
     * 
     * @return
     *     possible object is
     *     {@link HotelRatingInput }
     *     
     */
    public HotelRatingInput getStarRating() {
        return starRating;
    }

    /**
     * Sets the value of the starRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelRatingInput }
     *     
     */
    public void setStarRating(HotelRatingInput value) {
        this.starRating = value;
    }

    /**
     * Gets the value of the orderBy property.
     * 
     * @return
     *     possible object is
     *     {@link OrderByFilter }
     *     
     */
    public OrderByFilter getOrderBy() {
        return orderBy;
    }

    /**
     * Sets the value of the orderBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderByFilter }
     *     
     */
    public void setOrderBy(OrderByFilter value) {
        this.orderBy = value;
    }

    /**
     * Gets the value of the hotelCodeList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCodeList() {
        return hotelCodeList;
    }

    /**
     * Sets the value of the hotelCodeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCodeList(String value) {
        this.hotelCodeList = value;
    }

}
