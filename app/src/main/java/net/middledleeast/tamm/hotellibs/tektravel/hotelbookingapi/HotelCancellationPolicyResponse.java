
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
 *         &lt;element name="CancelPolicies" type="{http://TekTravel/HotelBookingApi}CancelPolicies" minOccurs="0"/&gt;
 *         &lt;element name="HotelNorms" type="{http://TekTravel/HotelBookingApi}ArrayOfString2" minOccurs="0"/&gt;
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
    "cancelPolicies",
    "hotelNorms"
})
@XmlRootElement(name = "HotelCancellationPolicyResponse")
public class HotelCancellationPolicyResponse {

    @XmlElement(name = "Status")
    protected ResponseStatus status;
    @XmlElement(name = "CancelPolicies")
    protected CancelPolicies cancelPolicies;
    @XmlElement(name = "HotelNorms")
    protected ArrayOfString2 hotelNorms;

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

}
