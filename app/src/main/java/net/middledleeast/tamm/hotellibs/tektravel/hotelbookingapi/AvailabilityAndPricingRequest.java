
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
 *         &lt;element name="ResultIndex" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="SessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OptionsForBooking" type="{http://TekTravel/HotelBookingApi}BookingOptions" minOccurs="0"/&gt;
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
    "resultIndex",
    "sessionId",
    "optionsForBooking"
})
@XmlRootElement(name = "AvailabilityAndPricingRequest")
public class AvailabilityAndPricingRequest {

    @XmlElement(name = "ResultIndex")
    protected int resultIndex;
    @XmlElement(name = "SessionId")
    protected String sessionId;
    @XmlElement(name = "OptionsForBooking")
    protected BookingOptions optionsForBooking;

    /**
     * Gets the value of the resultIndex property.
     * 
     */
    public int getResultIndex() {
        return resultIndex;
    }

    /**
     * Sets the value of the resultIndex property.
     * 
     */
    public void setResultIndex(int value) {
        this.resultIndex = value;
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
     * Gets the value of the optionsForBooking property.
     * 
     * @return
     *     possible object is
     *     {@link BookingOptions }
     *     
     */
    public BookingOptions getOptionsForBooking() {
        return optionsForBooking;
    }

    /**
     * Sets the value of the optionsForBooking property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookingOptions }
     *     
     */
    public void setOptionsForBooking(BookingOptions value) {
        this.optionsForBooking = value;
    }

}
