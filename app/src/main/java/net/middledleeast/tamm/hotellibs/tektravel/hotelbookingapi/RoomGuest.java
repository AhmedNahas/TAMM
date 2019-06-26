
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoomGuest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoomGuest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChildAge" type="{http://TekTravel/HotelBookingApi}ArrayOfInt" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="AdultCount" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="ChildCount" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomGuest", propOrder = {
    "childAge"
})
public class RoomGuest {

    @XmlElement(name = "ChildAge")
    protected ArrayOfInt childAge;
    @XmlAttribute(name = "AdultCount", required = true)
    protected int adultCount;
    @XmlAttribute(name = "ChildCount", required = true)
    protected int childCount;

    /**
     * Gets the value of the childAge property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getChildAge() {
        return childAge;
    }

    /**
     * Sets the value of the childAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setChildAge(ArrayOfInt value) {
        this.childAge = value;
    }

    /**
     * Gets the value of the adultCount property.
     * 
     */
    public int getAdultCount() {
        return adultCount;
    }

    /**
     * Sets the value of the adultCount property.
     * 
     */
    public void setAdultCount(int value) {
        this.adultCount = value;
    }

    /**
     * Gets the value of the childCount property.
     * 
     */
    public int getChildCount() {
        return childCount;
    }

    /**
     * Sets the value of the childCount property.
     * 
     */
    public void setChildCount(int value) {
        this.childCount = value;
    }

}
