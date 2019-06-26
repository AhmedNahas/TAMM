
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AOTNumbers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AOTNumbers"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Contact" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IntlCall" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DomesticCall" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LocalCall" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OfficeHours" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Emergency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AOTNumbers", propOrder = {
    "country",
    "contact",
    "intlCall",
    "domesticCall",
    "localCall",
    "officeHours",
    "emergency",
    "language"
})
public class AOTNumbers {

    @XmlElement(name = "Country")
    protected String country;
    @XmlElement(name = "Contact")
    protected String contact;
    @XmlElement(name = "IntlCall")
    protected String intlCall;
    @XmlElement(name = "DomesticCall")
    protected String domesticCall;
    @XmlElement(name = "LocalCall")
    protected String localCall;
    @XmlElement(name = "OfficeHours")
    protected String officeHours;
    @XmlElement(name = "Emergency")
    protected String emergency;
    @XmlElement(name = "Language")
    protected String language;

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContact(String value) {
        this.contact = value;
    }

    /**
     * Gets the value of the intlCall property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntlCall() {
        return intlCall;
    }

    /**
     * Sets the value of the intlCall property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntlCall(String value) {
        this.intlCall = value;
    }

    /**
     * Gets the value of the domesticCall property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomesticCall() {
        return domesticCall;
    }

    /**
     * Sets the value of the domesticCall property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomesticCall(String value) {
        this.domesticCall = value;
    }

    /**
     * Gets the value of the localCall property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalCall() {
        return localCall;
    }

    /**
     * Sets the value of the localCall property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalCall(String value) {
        this.localCall = value;
    }

    /**
     * Gets the value of the officeHours property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficeHours() {
        return officeHours;
    }

    /**
     * Sets the value of the officeHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficeHours(String value) {
        this.officeHours = value;
    }

    /**
     * Gets the value of the emergency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmergency() {
        return emergency;
    }

    /**
     * Sets the value of the emergency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmergency(String value) {
        this.emergency = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

}
