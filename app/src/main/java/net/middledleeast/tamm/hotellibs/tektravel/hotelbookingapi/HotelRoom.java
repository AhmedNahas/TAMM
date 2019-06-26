
package net.middledleeast.tamm.hotellibs.tektravel.hotelbookingapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Hotel_Room complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Hotel_Room"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RoomIndex" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="RoomTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Inclusion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoomRate" type="{http://TekTravel/HotelBookingApi}RoomRate" minOccurs="0"/&gt;
 *         &lt;element name="RoomPromtion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoomInstructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Supplements" type="{http://TekTravel/HotelBookingApi}ArrayOfSupplement" minOccurs="0"/&gt;
 *         &lt;element name="RoomEssentialInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoomAdditionalInfo" type="{http://TekTravel/HotelBookingApi}RoomInformation" minOccurs="0"/&gt;
 *         &lt;element name="CancelPolicies" type="{http://TekTravel/HotelBookingApi}CancelPolicies" minOccurs="0"/&gt;
 *         &lt;element name="Amenities" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "Hotel_Room", propOrder = {
    "roomIndex",
    "roomTypeName",
    "inclusion",
    "roomTypeCode",
    "ratePlanCode",
    "roomRate",
    "roomPromtion",
    "roomInstructions",
    "supplements",
    "roomEssentialInfo",
    "roomAdditionalInfo",
    "cancelPolicies",
    "amenities",
    "mealType"
})
public class HotelRoom {

    @XmlElement(name = "RoomIndex")
    protected int roomIndex;
    @XmlElement(name = "RoomTypeName")
    protected String roomTypeName;
    @XmlElement(name = "Inclusion")
    protected String inclusion;
    @XmlElement(name = "RoomTypeCode")
    protected String roomTypeCode;
    @XmlElement(name = "RatePlanCode")
    protected String ratePlanCode;
    @XmlElement(name = "RoomRate")
    protected RoomRate roomRate;
    @XmlElement(name = "RoomPromtion")
    protected String roomPromtion;
    @XmlElement(name = "RoomInstructions")
    protected String roomInstructions;
    @XmlElement(name = "Supplements")
    protected ArrayOfSupplement supplements;
    @XmlElement(name = "RoomEssentialInfo")
    protected String roomEssentialInfo;
    @XmlElement(name = "RoomAdditionalInfo")
    protected RoomInformation roomAdditionalInfo;
    @XmlElement(name = "CancelPolicies")
    protected CancelPolicies cancelPolicies;
    @XmlElement(name = "Amenities")
    protected String amenities;
    @XmlElement(name = "MealType")
    protected String mealType;

    /**
     * Gets the value of the roomIndex property.
     * 
     */
    public int getRoomIndex() {
        return roomIndex;
    }

    /**
     * Sets the value of the roomIndex property.
     * 
     */
    public void setRoomIndex(int value) {
        this.roomIndex = value;
    }

    /**
     * Gets the value of the roomTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomTypeName() {
        return roomTypeName;
    }

    /**
     * Sets the value of the roomTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomTypeName(String value) {
        this.roomTypeName = value;
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
     * Gets the value of the roomTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    /**
     * Sets the value of the roomTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomTypeCode(String value) {
        this.roomTypeCode = value;
    }

    /**
     * Gets the value of the ratePlanCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRatePlanCode() {
        return ratePlanCode;
    }

    /**
     * Sets the value of the ratePlanCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatePlanCode(String value) {
        this.ratePlanCode = value;
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
     *     {@link ArrayOfSupplement }
     *     
     */
    public ArrayOfSupplement getSupplements() {
        return supplements;
    }

    /**
     * Sets the value of the supplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSupplement }
     *     
     */
    public void setSupplements(ArrayOfSupplement value) {
        this.supplements = value;
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
     * Gets the value of the roomAdditionalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link RoomInformation }
     *     
     */
    public RoomInformation getRoomAdditionalInfo() {
        return roomAdditionalInfo;
    }

    /**
     * Sets the value of the roomAdditionalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoomInformation }
     *     
     */
    public void setRoomAdditionalInfo(RoomInformation value) {
        this.roomAdditionalInfo = value;
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
     * Gets the value of the amenities property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmenities() {
        return amenities;
    }

    /**
     * Sets the value of the amenities property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmenities(String value) {
        this.amenities = value;
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
