
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelCancellationPolicies complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HotelCancellationPolicies"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HotelNorms" type="{http://TekTravel/HotelBookingApi}ArrayOfString2" minOccurs="0"/&gt;
 *         &lt;element name="CancelPolicies" type="{http://TekTravel/HotelBookingApi}CancelPolicies" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelCancellationPolicies", propOrder = {
    "hotelNorms",
    "cancelPolicies"
})
public class HotelCancellationPolicies {

    @XmlElement(name = "HotelNorms")
    protected ArrayOfString2 hotelNorms;
    @XmlElement(name = "CancelPolicies")
    protected CancelPolicies cancelPolicies;

    /**
     * Gets the value of the hotelNorms property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString2 }
     *     
     */
    public ArrayOfString2 getHotelNorms() {
        return hotelNorms;
    }

    /**
     * Sets the value of the hotelNorms property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString2 }
     *     
     */
    public void setHotelNorms(ArrayOfString2 value) {
        this.hotelNorms = value;
    }

    /**
     * Gets the value of the cancelPolicies property.
     * 
     * @return
     *     possible object is
     *     {@link CancelPolicies }
     *     
     */
    public CancelPolicies getCancelPolicies() {
        return cancelPolicies;
    }

    /**
     * Sets the value of the cancelPolicies property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelPolicies }
     *     
     */
    public void setCancelPolicies(CancelPolicies value) {
        this.cancelPolicies = value;
    }

}
