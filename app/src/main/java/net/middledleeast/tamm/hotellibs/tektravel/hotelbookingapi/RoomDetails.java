
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoomDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoomDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AdultCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ChildCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ChildAge" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="RoomName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Ameneties" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="GuestInfo" type="{http://TekTravel/HotelBookingApi}ArrayOfGuest" minOccurs="0"/&gt;
 *         &lt;element name="Inclusion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoomPromtion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoomInstructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Supplements" type="{http://TekTravel/HotelBookingApi}ArrayOfSupp_info" minOccurs="0"/&gt;
 *         &lt;element name="RoomRate" type="{http://TekTravel/HotelBookingApi}RoomRate" minOccurs="0"/&gt;
 *         &lt;element name="RoomEssentialInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MealType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomDetails", propOrder = {
    "adultCount",
    "childCount",
    "childAge",
    "roomName",
    "ameneties",
    "guestInfo",
    "inclusion",
    "roomPromtion",
    "roomInstructions",
    "supplements",
    "roomRate",
    "roomEssentialInfo",
    "mealType"
})
public class RoomDetails {

    @XmlElement(name = "AdultCount")
    protected int adultCount;
    @XmlElement(name = "ChildCount")
    protected int childCount;
    @XmlElement(name = "ChildAge", type = Integer.class)
    protected List<Integer> childAge;
    @XmlElement(name = "RoomName")
    protected String roomName;
    @XmlElement(name = "Ameneties")
    protected List<String> ameneties;
    @XmlElement(name = "GuestInfo")
    protected ArrayOfGuest guestInfo;
    @XmlElement(name = "Inclusion")
    protected String inclusion;
    @XmlElement(name = "RoomPromtion")
    protected String roomPromtion;
    @XmlElement(name = "RoomInstructions")
    protected String roomInstructions;
    @XmlElement(name = "Supplements")
    protected ArrayOfSuppInfo2 supplements;
    @XmlElement(name = "RoomRate")
    protected RoomRate roomRate;
    @XmlElement(name = "RoomEssentialInfo")
    protected String roomEssentialInfo;
    @XmlElement(name = "MealType")
    protected String mealType;

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

    /**
     * Gets the value of the childAge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childAge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildAge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getChildAge() {
        if (childAge == null) {
            childAge = new ArrayList<Integer>();
        }
        return this.childAge;
    }

    /**
     * Gets the value of the roomName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Sets the value of the roomName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomName(String value) {
        this.roomName = value;
    }

    /**
     * Gets the value of the ameneties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ameneties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAmeneties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAmeneties() {
        if (ameneties == null) {
            ameneties = new ArrayList<String>();
        }
        return this.ameneties;
    }

    /**
     * Gets the value of the guestInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGuest }
     *     
     */
    public ArrayOfGuest getGuestInfo() {
        return guestInfo;
    }

    /**
     * Sets the value of the guestInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGuest }
     *     
     */
    public void setGuestInfo(ArrayOfGuest value) {
        this.guestInfo = value;
    }

    /**
     * Gets the value of the inclusion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInclusion() {
        return inclusion;
    }

    /**
     * Sets the value of the inclusion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInclusion(String value) {
        this.inclusion = value;
    }

    /**
     * Gets the value of the roomPromtion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomPromtion() {
        return roomPromtion;
    }

    /**
     * Sets the value of the roomPromtion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomPromtion(String value) {
        this.roomPromtion = value;
    }

    /**
     * Gets the value of the roomInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomInstructions() {
        return roomInstructions;
    }

    /**
     * Sets the value of the roomInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomInstructions(String value) {
        this.roomInstructions = value;
    }

    /**
     * Gets the value of the supplements property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSuppInfo2 }
     *     
     */
    public ArrayOfSuppInfo2 getSupplements() {
        return supplements;
    }

    /**
     * Sets the value of the supplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSuppInfo2 }
     *     
     */
    public void setSupplements(ArrayOfSuppInfo2 value) {
        this.supplements = value;
    }

    /**
     * Gets the value of the roomRate property.
     * 
     * @return
     *     possible object is
     *     {@link RoomRate }
     *     
     */
    public RoomRate getRoomRate() {
        return roomRate;
    }

    /**
     * Sets the value of the roomRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoomRate }
     *     
     */
    public void setRoomRate(RoomRate value) {
        this.roomRate = value;
    }

    /**
     * Gets the value of the roomEssentialInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomEssentialInfo() {
        return roomEssentialInfo;
    }

    /**
     * Sets the value of the roomEssentialInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomEssentialInfo(String value) {
        this.roomEssentialInfo = value;
    }

    /**
     * Gets the value of the mealType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMealType() {
        return mealType;
    }

    /**
     * Sets the value of the mealType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMealType(String value) {
        this.mealType = value;
    }

}
