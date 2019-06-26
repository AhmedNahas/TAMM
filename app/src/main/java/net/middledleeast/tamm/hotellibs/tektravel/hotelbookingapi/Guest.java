
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Guest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Guest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Age" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="LeadGuest" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="GuestType" use="required" type="{http://TekTravel/HotelBookingApi}GuestType" /&gt;
 *       &lt;attribute name="GuestInRoom" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Guest", propOrder = {
    "title",
    "firstName",
    "lastName",
    "age"
})
public class Guest {

    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "Age")
    protected int age;
    @XmlAttribute(name = "LeadGuest", required = true)
    protected boolean leadGuest;
    @XmlAttribute(name = "GuestType", required = true)
    protected GuestType guestType;
    @XmlAttribute(name = "GuestInRoom", required = true)
    protected int guestInRoom;

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

    /**
     * Gets the value of the leadGuest property.
     * 
     */
    public boolean isLeadGuest() {
        return leadGuest;
    }

    /**
     * Sets the value of the leadGuest property.
     * 
     */
    public void setLeadGuest(boolean value) {
        this.leadGuest = value;
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
     * Gets the value of the guestInRoom property.
     * 
     */
    public int getGuestInRoom() {
        return guestInRoom;
    }

    /**
     * Sets the value of the guestInRoom property.
     * 
     */
    public void setGuestInRoom(int value) {
        this.guestInRoom = value;
    }

}
