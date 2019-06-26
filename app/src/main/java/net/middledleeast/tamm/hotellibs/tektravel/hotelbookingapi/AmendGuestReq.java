
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmendGuestReq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmendGuestReq"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Action" use="required" type="{http://TekTravel/HotelBookingApi}AmendActionReq" /&gt;
 *       &lt;attribute name="ExistingName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="GuestType" use="required" type="{http://TekTravel/HotelBookingApi}GuestType" /&gt;
 *       &lt;attribute name="Title" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Age" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendGuestReq")
public class AmendGuestReq {

    @XmlAttribute(name = "Action", required = true)
    protected AmendActionReq action;
    @XmlAttribute(name = "ExistingName")
    protected String existingName;
    @XmlAttribute(name = "GuestType", required = true)
    protected GuestType guestType;
    @XmlAttribute(name = "Title")
    protected String title;
    @XmlAttribute(name = "FirstName")
    protected String firstName;
    @XmlAttribute(name = "LastName")
    protected String lastName;
    @XmlAttribute(name = "Age", required = true)
    protected int age;

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link AmendActionReq }
     *     
     */
    public AmendActionReq getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmendActionReq }
     *     
     */
    public void setAction(AmendActionReq value) {
        this.action = value;
    }

    /**
     * Gets the value of the existingName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExistingName() {
        return existingName;
    }

    /**
     * Sets the value of the existingName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExistingName(String value) {
        this.existingName = value;
    }

    /**
     * Gets the value of the guestType property.
     * 
     * @return
     *     possible object is
     *     {@link GuestType }
     *     
     */
    public GuestType getGuestType() {
        return guestType;
    }

    /**
     * Sets the value of the guestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuestType }
     *     
     */
    public void setGuestType(GuestType value) {
        this.guestType = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the age property.
     * 
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     */
    public void setAge(int value) {
        this.age = value;
    }

}
